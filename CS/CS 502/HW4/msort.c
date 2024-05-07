/**
@file
@author Andy Cherney <alc466@drexel.edu>
@date February 02, 2024
@section DESCRIPTION

Functions used to implement the mergesort algorithm (REQUIRED)
*/

#include <stdio.h>
#include <stdlib.h>
#include "myString.h"
#include "msort.h"


void msort(char** wordList, int size){
    msortRec(wordList, 0, size - 1); /* Mergesort helper */

}


void msortRec(char** wordList, int start, int stop){
    if (start >= stop){ /* Nothing left to return since this would imply only one element in the array*/
        return ;
    }
    int middle = start + (stop - start) / 2;

    /* Recursively divide the array in half and sort */
    msortRec(wordList, start, middle);  
    msortRec(wordList, middle + 1, stop);

    /* Merge the sorted subsets back together */
    merge(wordList, start, middle, stop);
}


void merge(char** wordList, int start, int middle, int stop){

    const int STRSIZE = 200;

    /* Create the left subarray */
    int lSize = middle - start + 1;
    char ** left = malloc(lSize * sizeof(char*));

    /* Create the right subarray */
    int rSize = stop - (middle + 1) + 1;
    char ** right = malloc(rSize * sizeof(char*));

    /* Copy the data to the left array */
    for (int i = 0; i < lSize; i++){
        left[i] = malloc((STRSIZE + 1) * sizeof(char));
        left[i] = wordList[start + i];
    }

    /* Copy the data to the right array */
    for (int i = 0; i < rSize; i++){
        right[i] =  malloc((STRSIZE + 1) * sizeof(char));
        right[i] = wordList[middle + 1 + i];
    }

     /* 
        i = index of the left subarray, 
        j = index of the right subarray
        k = index of the original array
    */
    int i = 0, j = 0;
    for (int k = start; k <= stop; k++){

        if (i >= lSize) {  
            
            /* 
            If the index of the left array is larger than the left array size, 
            there are no more elements left to compare on the left side. We need to copy from the right.
            */ 
            wordList[k] = right[j];
            j++;

        } else if (j >= rSize){ 

            /* 
            Similarly, if the index of the right array is larger than the right array size, 
            there are no more elements left to compare on the right side. We need to copy from the left.
            */ 
            wordList[k] = left[i];
            i++;

        /* For both iterators inside the array */

        } else if (lessThan(left[i], right[j])){
            /* 
            If the left value is smaller than the right, add the left value to the array
            */ 
            wordList[k] = left[i];
            i++;

        } else {

            /* 
            If the right value is smaller than the left, add the right value to the array
            */ 
            wordList[k] = right[j];
            j++;
        }
    }

    /* Free both arrays to save space. Pointers will be freed at the end.*/
    free(left);
    free(right); 

}

