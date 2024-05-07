
def gnome_sort(a):
    
    """
    Python implementation of the gnomesort algorithm.
    
    :param a: array to sort
    """
    
    i = 0
    while i < len(a):
        if (i == 0 or a[i] >= a[i - 1]):
            i += 1
            continue
        
        a[i], a[i - 1] = a[i - 1], a[i]
        i -= 1


def main():
    
    """
    Driver program that tests gnomesort on input. You can run this file as a script as a demonstration for the gnomesort function
    
    """
    
    size = int(input("Enter the size of the array:\n"))
    test_array = []
    print("Enter values line by line")
    for i in range(size):
        test_array.append(int(input()))
    
    gnome_sort(test_array)
    print(test_array)

# Used so that the main function is not called upon import to other files
if __name__ == '__main__': 
    main()