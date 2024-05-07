
/**
  @file
  @author Andy Cherney <alc466@drexel.edu>
  @date January 16, 2023
  @section DESCRIPTION

  Gnomesort C implementation
 */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>


/**
    Print an array like a Python list

    @param arr - array to print
    @param size - size of the array
*/


void printArray(int* arr, int size);

/**
    Sort an array using gnome sort algorithm

    @param arr -  array to sort
    @param size - size of the array
*/

void gnomeSort(int* A, int size);

/**
    Main program for the gnomesort algorithm

    @return 0 if successful, 1 if failed
*/


int main() {
    
    long size;

    printf("Enter the size of the array\n"); // Program uses a predefined size
    scanf("%lu", &size); 


    int* A = (int*) malloc((size + 1) * sizeof(int));
    if (A == NULL) {
        perror("Memory allocation failed\n");
        return 1; // Exit the program with an error code
    }

    printf("Enter elements line by line\n");
    for (long i = 0; i<size; i++){
        scanf("%d", &A[i]);
    }

    gnomeSort(A, size);
    printArray(A, size);

    free(A);
    return 0;
}


void printArray(int* arr, int size){
    
    printf("[");
    for (int i = 0; i < size; i++){
        printf("%d", arr[i]);
        if (i != size - 1){
            printf(", "); 
        }      
    }
    printf("]\n");
}

void gnomeSort(int* A, int size){
    int i = 0;
    while (i < size){
        if (i == 0 || A[i] >= A[i - 1]){
            i++;
            continue;
        }
        int temp = A[i];
        A[i] = A[i - 1];
        A[i - 1] = temp;
        i--;
    }
}


