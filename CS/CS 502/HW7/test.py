import subprocess
import os


input_path = './examples/tests'
res_path = './examples/test_results'

inputs = filter(lambda x: x[-4::] == '.txt',os.listdir(input_path))
results = filter(lambda x: x[-4::] == '.txt',os.listdir(res_path))

for input, result in zip(inputs, results):
   
    with open(f"{input_path}/{input}") as inpt:
        i = inpt.read().strip()
        
    with open(f"{res_path}/{result}") as res:
        r = res.read()
        
    
    
    s =  subprocess.Popen("./main", stdin=subprocess.PIPE, stdout=subprocess.PIPE, text=True)
    s_out, s_err = s.communicate(i)
    
    check = "Passed" if s_out == r else "Failed"
    print(f"{input}: {check}")
    



