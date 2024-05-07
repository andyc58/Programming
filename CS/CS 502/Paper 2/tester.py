
import random
import subprocess
import os
from timsort import timsort
import pandas as pd
from time import time


def is_sorted(arr):
    return arr == sorted(arr)


def run_C(a, file, print):
    
    """ 
    Runs a C program (Timing is done within the program to reduce overhead of reading in the array)
    
    :param a: Input list to stdin
    :param file: file path to the C program
    :param min_runs: starting number of runs for timsort
    :param print: 0 to just time the program, 1 to print the actual result
    :return: runtime of the program, result of the program
    """
    
    test_size = len(a)
    test_str = "\n".join(str(x) for x in a)
    

    try:
        if not os.path.exists(f"{file}"):
            subprocess.call(["gcc", "-o", f"{file}", f"{file}.c"]) # Compiles the program if the executable to it does not currently exist

        prog_name = os.path.join('.',f'{file}')
        
        
        C_out = subprocess.Popen([prog_name, str(test_size), str(print)], stdin=subprocess.PIPE, 
                                    stdout=subprocess.PIPE, text=True) # Opens the C program
    except FileNotFoundError:
        print("C file does not exist in the current path")
        exit(1) # Stops the program
    
    
    stdout, stderr = C_out.communicate(input=test_str) # Sends input to stdin
    result = stdout.strip().split('\n')[-1] # Result is found after all the prompt strings (separated by newlines)

    return result


def run_Python(a):
    
    """ 
    Runs the Python implementation
    
    :param a: an input list
    :return: runtime of the program, result of the program
    """
    
    start = time()
    timsort(a)
    end = time()
    runtime = end - start
    return runtime, a


def run_tests(n, lower_bound, upper_bound, max_inputs):
    
    """
    Run the tests for both implementations
    
    :param n: number of tests to generate
    :param lower_bound: lower bound of the RNG for the array values
    :param upper_bound: upper bound of the RNG for the array values
    :param max_inputs: highest input size that RNG should generate
    :return: a list of dictionaries containing the results of each test (will be organized into a table later)
    
    """

    results = []
    value_range = range(lower_bound, upper_bound+1) # Set range for RNG
    
    for i in range(n):
        if i < 2:
            test = random.choices(value_range, k=i) # Generate the first edge test cases (length 0 and 1 arrays)
            
        else:
            test = random.choices(value_range, k=random.randint(2, max_inputs)) # Randomly generate the next test cases
        
        
        C_result = run_C(test, "timsort", print=1)
        _ ,py_result = run_Python(test.copy())

        test_row = {"Size": len(test),"Test case": test, "C result": C_result, "Python result": str(py_result)}
        test_row['Passed'] =  is_sorted(py_result) and test_row['C result'] == test_row['Python result']
        print(f'Test {i+1}: {"Passed" if test_row["Passed"] else "Failed"}')
        results.append(test_row)

    return results



def time_algorithms(n, start_size, multiplier):
    
    
    """
    Times the algorithms by exponentially increasing array size
    
    :param n: number of tests
    :param start_size: value to start timing on (will increase exponentially)
    :param multiplier: factor to increase start_size
    :return: a list of dictionaries containing the timings for each implementation (will be organized into a table later)
    
    """
    
    runtimes = []
    
    for i in range(n):
        array = random.choices(range(-50, 100), k=start_size)
        runtime_data = {}
        runtime_data["Size"] = start_size
        runtime_C = run_C(array, "timsort", print=0)
        runtime_data["C time"] = float(runtime_C)
    
        runtime_python, _ = run_Python(array)
    
        runtime_data['Python time'] = runtime_python
        print(f"{i+1}:",runtime_data)
        runtimes.append(runtime_data)
        start_size *= multiplier
    
    return runtimes


def main():
    random.seed(8547) # Set seed for RNG
    
    print("Running Tests")
    results = run_tests(20, -50, 100, 15)
    
    # Write the test results to a CSV
    data = pd.DataFrame(results)
    data.index += 1
    data.to_csv('tests.csv', sep = ';', index_label='#')
    
    print()
    print(data)


    print("Running Timing")
    runtimes = time_algorithms(27, 1, 2) # Generate 17 arrays with starting size 1 and a multiplier of 2
    # Write the timing results to a CSV
    runtimes_df = pd.DataFrame(runtimes)
    runtimes_df.to_csv('timsort_timing.csv', sep = ';', index = False)

main()

