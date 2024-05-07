/**
@file
@author Andy Cherney <alc466@drexel.edu>
@date February 02, 2024
@section DESCRIPTION

Functions implemented for my custom string.h library.
*/

#include <stdio.h>
#include <stdlib.h>
#include "myString.h"

int countLines(FILE *filePtr){
    int count = 0;

    char c = fgetc(filePtr);

    /* Read each character in the file until EOF*/
    while(c != EOF){
        if (c == '\n') {
            count++;
        }
        c = fgetc(filePtr);
    }
    
    fseek(filePtr, 0, 0); /* Go back to beginning of file when done */
    return count;
}

int length(char* word){
    int i = 0;

    /* We need to exclude a newline character as well as the null terminator */
    while(word[i] != 0 && word[i] != '\n'){ 
        i++;
    }
    return i;
}


int lessThan(const char* word1, const char* word2) {

    /* String comparison */
    int counter = 0;
    while (word1[counter] != 0 && word2[counter] != 0) {
        if (word1[counter] < word2[counter]){
            return 1;
        }
        if (word1[counter] > word2[counter]){
            return 0;
        }
        counter++;
    }
    return (word1[counter] == 0); /* Check if word1 reached the null terminator (case if one of the strings is empty)*/
}
