

SMALLRUNS, LARGERUNS = 32, 64

def findRunLength(n):
    """
    A function that calculates the run length of a given number 'n'.
    
    Parameters:
    n (int): The number for which the run length is being calculated.
    
    Returns:
    int: The calculated run length of the number 'n'.
    """
    
    # Calculate the run length
    r = 0
    if n < SMALLRUNS:
        return SMALLRUNS
    
    while n >= LARGERUNS:
        n, r = divmod(n, 2)
    return n + r


# Define the insertionSort function
def insertionSort(list, start, stop):
    """
    Sorts a sublist of a given list in ascending order using the insertion sort algorithm.

    Parameters:
        list (list): The list to be sorted.
        start (int): The starting index of the sublist to be sorted.
        stop (int): The ending index of the sublist to be sorted.
    """
    
    for i in range(start + 1, stop + 1):
        j = i
        while j > start and list[j] < list[j - 1]:
            # Swap elements
            list[j], list[j - 1] = list[j - 1], list[j] 
            j -= 1

# Define the merge function
def merge(list, start, middle, stop):
    """
    Merge two sorted sublists of a list into a single sorted sublist.

    Parameters:
        list (list): The list containing the sublists to be merged.
        start (int): The starting index of the first sublist.
        middle (int): The ending index of the first sublist and the starting index of the second sublist.
        stop (int): The ending index of the second sublist.

    """
    left = list[start: middle + 1]
    right = list[middle + 1: stop + 1]
    
    i, j = 0, 0
    for k in range(start, stop + 1):
        
        # Compare elements from left and right sublists
        if i >= len(left):
            
            # If left sublist is empty, insert element from right sublist
            list[k] = right[j]
            j += 1
        elif j >= len(right):
            
            # If right sublist is empty, insert element from left sublist
            list[k] = left[i]
            i += 1
            
        elif left[i] < right[j]:
            
            # If element from left sublist is less than element from right sublist, insert element from left sublist
            list[k] = left[i]
            i += 1
        else:
            # If element from right sublist is less than element from left sublist, insert element from right sublist
            list[k] = right[j]
            j += 1

# Define the timsort function
def timsort(list):
    """
    Sorts a list using the Timsort algorithm.

    Parameters:
    - list (list): The list to be sorted.

    """
    
    # Find the minimum run length
    n = len(list)
    min_run = findRunLength(n)

    # Apply insertion sort on the runs
    for i in range(0, n, min_run):
        end = min(i + min_run - 1, n - 1)
        insertionSort(list, i, end)
    
    
    # Merge the runs
    size = min_run
    while size < n:
        for left in range(0, n, 2 * size):
            mid = left + size - 1
            right = min(left + 2 * size - 1, n - 1)
            
            if mid < right:
                merge(list, left, mid, right)
        size *= 2



# For demonstrative purposes
if __name__ == '__main__':
    from random import choices, randrange

    # create a random list A
    A = choices(range(-50, 100 + 1), k = randrange(0, 10000))

    # Apply timsort on the list A
    timsort(A)
    
    # **** Uncomment the below line to print the sorted list *****
    # print(A)
    
    # Compare this implementation with Python's implementation of timsort
    print("Sorted Successfully" if A == sorted(A) else "Failed")
    