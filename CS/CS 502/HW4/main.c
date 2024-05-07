/**
@mainpage CS 502 - Homework 4
@section Description

Program to read a file and sort its contents
*/

/**
@file
@author Andy Cherney <mwb33@drexel.edu>
@date February 02, 2024
@section DESCRIPTION

Main program to read a file and sort its contents using a merge sort algorithm.
*/

#include <stdio.h>
#include <stdlib.h>
#include "myString.h"
#include "msort.h"


/**
    Used to release an array of strings from memory. Necessary because char pointers inside could be malloced as well
    @param wordList is the list of words to sort
*/

void freeList(char** A);

/**
    Prints out a string array
    @param A the list to print
*/

void printArray(char** A);

int main(){

    FILE *filePtr;

    const int STRSIZE = 200;/* Assume a line contains no more than 200 characters*/

    char filePath [101]; /* Assume user types in no more than 100 characters for the file path */
    printf("Enter File Name:\n");
    scanf(" %100s", filePath);
    printf("Opening File: %s\n", filePath);
    filePtr = fopen(filePath, "r"); /* Create pointer to the file object */

    int count = countLines(filePtr);
    
    char** words = malloc((count + 1) * sizeof(char*)); /* First allocate for the number of strings in the array*/
    for (int i = 0; i < count; i++){
        words[i] = malloc((STRSIZE + 1) * sizeof(char));  /* Allocate the max number of characters for each string */
        fgets(words[i], STRSIZE + 1, filePtr); /* Read the file and put the word into the array  */
        int wordLength = length(words[i]);
        words[i][wordLength] = 0; /* Need to replace newline with null terminator in each word */
    }
    
    fclose(filePtr);
    msort(words, count);
    printArray(words);

    /* Frees both the pointers and the array of pointers itself*/
    freeList(words);


}



void freeList(char** A){
    char **t = A; /* Temporary pointer */
    for (;*t; t++){
        free(*t); /* Release each char pointer in the array */
    }
    free(A); /* Releases the array itself */
}



void printArray(char** A){
    int i = 0;
    for (;*A; A++){
        printf("%d: %s\n", i ,*A); 
        i++;
    }
}
