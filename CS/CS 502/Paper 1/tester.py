
import random
import subprocess
import os
from gnomeSort import gnome_sort
import pandas as pd
from time import time



def is_sorted(arr):
    
    """ 
    Check if the list is sorted
    
    :param arr: Array to check
    :return: true if list is sorted false otherwise
    """
    
    prev = 0
    for i in range(1, len(arr) - 1):
        if arr[i] < arr[prev]:
            return False
        prev += 1
    return True



def run_C(a, file):
    
    """ 
    Runs a C program and times it (Used to run the C gnomesort implementation)
    
    :param a Input list to stdin
    :param file file path to the C program
    :return: runtime of the program, result of the program
    """
    
    test_size = len(a)
    test_str = "\n".join(str(x) for x in a)
    input_string = f"{test_size}\n{test_str}\n"

    try:
        if not os.path.exists(f"{file}"):
            subprocess.call(["gcc", "-o", f"{file}", f"{file}.c"]) # Compiles the program if the executable to it does not currently exist

        C_out = subprocess.Popen([os.path.join('.',f'{file}')], stdin=subprocess.PIPE, stdout=subprocess.PIPE, text=True) # Opens the C program
    except FileNotFoundError:
        print("C file does not exist in the current path")
        exit(1) # Stops the program
    
    start = time()
    stdout, stderr = C_out.communicate(input=input_string) # Sends input to stdin
    end = time()
    runtime = end - start
    result = stdout.strip().split('\n')[-1] # Result is found after all the prompt strings (separated by newlines)

    return runtime, result


def run_Python(a):
    
    """ 
    Runs the Python implementation
    
    :param a: an input list
    :return: runtime of the program, result of the program
    """
    
    start = time()
    gnome_sort(a)
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
        
        _ ,C_result = run_C(test, "gnomeSort")
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
    runtime_data = {}
    

    for i in range(n):
        array = random.choices(range(-50, 100), k=start_size)
        runtime_data["Size"] = start_size
        runtime_C, _ = run_C(array, "gnomeSort")
        runtime_data["C time"] = runtime_C
    
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
    runtimes = time_algorithms(17, 1, 2) # Generate 17 arrays with starting size 1 and a multiplier of 2
    
    # Write the timing results to a CSV
    runtimes_df = pd.DataFrame(runtimes)
    runtimes_df.to_csv('timing.csv', sep = ';', index = False)

main()

