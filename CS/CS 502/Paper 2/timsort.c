/**
  @mainpage CS 502 - Research Project 2
  @section Description

  Program to sort an array of integers using the Timsort algorithm
*/


/**
  @file
  @author Andy Cherney <alc466@drexel.edu>
  @date March 7, 2023
  @section DESCRIPTION

  Timsort C implementation
 */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define SMALLRUN 32
#define LARGERUN 64


/**
  Finds the start length of a run in the array

  @param n size of the array
  @return length of the run
*/
int findRunLength(int n);


/**
   Returns the minimum of two numbers

   @param a is the first number
   @param b is the second number
   @return the minimum value
 */ 

int min(int a, int b);


/**
   Insertion sort algorithm needed to sort the runs

   @param list array to be sorted
   @param start starting index
   @param stop ending index
*/
void insertionSort(int* list, long start, long stop);

/**
    Merge algorithm needed to combine the run and build the new sorted array

    @param list the original array
    @param start starting index
    @param middle middle index
    @param stop ending index
*/
void merge(int* list, long start, long middle, long stop);


/**
    Main function for the Timsort algorithm

    @param list the original array to be sorted
    @param n size of the array
*/

void timSort(int* list, long n);


/**
    Print an array like a Python list

    @param list the original array to be printed
    @param n size of the array
*/

void printArray(int* list, long n);


/**
    Check if a string has all numeric characters

    @param s the string to check
*/
int isNumeric(char* s);

/**
    Driver program for the timsort algorithm. It takes in 2 command line arguments:
    1. The size of the array
    2. A value 0 or 1 specifying whether the sorted output should be printed. 
        If the output is not printed returns a success message followed by the number of seconds the algorithm took 
        to run.
    
    @param argc number of arguments (size of the array) and a value specifying whether the output should be printed
    @param argv array of arguments
    @return 0 if successful, 1 if failed
*/

int main(int argc, char** argv){

    long size;
    int printOutput;

    /* Check if the right amount of args was given */
    if (argc != 3){
        printf("Usage: <array size> <print output?>");
        return 0;
    }

    /* Check if the arguments are valid */
    if (! isNumeric(argv[1]) || ! isNumeric(argv[2])){
        perror("Wrong arg types: Must be numeric");
        return 1;
    }

    /* Set the size and printOutput variables */
    size = atol(argv[1]);
    printOutput = atoi(argv[2]); 
    
    /* Make space for the array */
    int * A = malloc((size)*sizeof(int));
    if (A == NULL){
        perror("Malloc Error");
        return 1;
    }

    /* Get the array from the user */
    printf("Enter the %ld elements line by line\n", size);
    for (long i = 0; i<size; i++){
        scanf("%d", &A[i]);
    }

    /* Time and sort the array */
    clock_t start = clock();
    timSort(A,size);
    clock_t end = clock();
    long double total = (long double) (end - start) / CLOCKS_PER_SEC;

    if (printOutput){
        /* Print the sorted array if user specifies a value of 1 or higher */
        printArray(A, size);
    } else{
        /* Print the number of seconds the algorithm took to run */
        printf("Sorted successfully.\n");
        printf("%.12Lf", total);

    }

    free(A);
    return 0;
}

int isNumeric(char* s){
    for (; *s; s++){
        if (*s < 48 || *s > 57){
            return 0;
        }
    }
    return 1;
}

int min(int a, int b){
    if (a < b)
        return a;
    return b;
}

int findRunLength(int n){  

    /* 
    Note: Various implementations of this algorithm are possible. 
    This one will cap the run length at 32 for all values of n less than 32.
    The array size will be used to determine the length of the run to guarantee a size such that

    array size / min run length is near a power of 2
    
    */  
    int r = 0;
    if (n < SMALLRUN)
        return SMALLRUN;

    while (n >= LARGERUN){
        r = n % 2;
        n = n / 2;
    }
    return n + r;
}

void insertionSort(int* list, long start, long stop) { 
    for (long i = start + 1; i <= stop; i++) { 
        long j = i;
        while (j > start && list[j] < list[j - 1]) { 
            /* Swap left and right if the left is larger than the right */
            int temp = list[j];
            list[j] = list[j - 1]; 
            list[j - 1] = temp;
            j--; 
        }   
    } 
}

void merge(int* list, long start, long middle, long stop){

    /* Create the left subarray */
    long lSize = middle - start + 1;
    int* left = malloc(lSize * sizeof(int));

    /* Create the right subarray */
    long rSize = stop - (middle + 1) + 1;
    int* right = malloc(rSize * sizeof(int));

    /* Copy the data to the left array */
    for (long i = 0; i < lSize; i++){

        left[i] = list[start + i];
    }

    /* Copy the data to the right array */
    for (long i = 0; i < rSize; i++){
        right[i] = list[middle + 1 + i];
    }

     /* 
        i = index of the left subarray, 
        j = index of the right subarray
        k = index of the original array
    */
    long i = 0, j = 0;
    for (long k = start; k <= stop; k++){

        if (i >= lSize) {  
            
            /* 
            If the index of the left array is larger than the left array size, 
            there are no more elements left to compare on the left side. We need to copy from the right.
            */ 
            list[k] = right[j];
            j++;

        } else if (j >= rSize){ 

            /* 
            Similarly, if the index of the right array is larger than the right array size, 
            there are no more elements left to compare on the right side. We need to copy from the left.
            */ 
            list[k] = left[i];
            i++;

        /* For both iterators inside the array */

        } else if (left[i] < right[j]){
            /* 
            If the left value is smaller than the right, add the left value to the array
            */ 
            list[k] = left[i];
            i++;

        } else {

            /* 
            If the right value is smaller than the left, add the right value to the array
            */ 
            list[k] = right[j];
            j++;
        }
    }

    /* Free both arrays to save space. */
    free(left);
    free(right); 

}

void timSort(int* list, long n) {

    int minRun = findRunLength(n);
  
    /* Sort individual subarrays of size minRun*/ 
    for (long i = 0; i < n; i += minRun) {
        int end = min((i + minRun - 1), (n - 1));
        insertionSort(list, i, end); 
    }
    /*
     Start merging from size minRun. 
     The current run size increases by 2 * minRun until the array is sorted
    */

    for (long size = minRun; size < n; size = 2 * size) { 
  
        /* pick starting point of left sub array. We 
        are going to merge list[left..left+size-1] 
        and list[left+size, left+2*size-1] 
        After every merge, we increase left by 2*size 
        */
        for (long left = 0; left < n; left += 2 * size) { 
            
            /*
             Find ending point of 
             left sub array 
             mid+1 is starting point 
             of right sub array 
            */
            long mid = left + size - 1; 
            long right = min(left + 2 * size - 1, n - 1); 
  
            /*
             merge sub array list[left.....mid] & 
             list[mid+1....right] 
            */
            if (mid < right) 
                merge(list, left, mid, right); 
        } 
    } 
} 

void printArray(int* arr, long n){
    /* Print an array like in Python */
    printf("[");
    for (long i = 0; i < n; i++){
        printf("%d", arr[i]);
        if (i != n - 1){
            printf(", "); 
        }      
    }
    printf("]\n");
}

