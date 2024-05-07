
/**
 @mainpage
 @section Overview

 This is Andy Cherney's program for HW 2.
*/

/**
  @file
  @author Andy Cherney <alc466@drexel.edu>
  @date January 16, 2023
  @section DESCRIPTION

  Program to get info (ASCII code and character type) for each character in a file
 
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/**
  Read user input from stdin
  @return A pointer to a character array (null terminated) with all characters read 
 */

char * readFromStdIn();


/**
  Lookup function for the character type.
  There are 6 types:
    1. Uppercase letter
    2. Lowercase letter
    3. Digit
    4. Space
    5. Newline
    6. Symbol

  @param c is the character to look up
  @return a string that states what kind of character it is 
 */

char * getType(char c);


/**
  Driver program that reads a file and outputs information on each character in the file
  @return 0 for success 
 */

int main(){

    printf("Enter File Name:\n");
    char * filePath = readFromStdIn(); 
    printf("Opening File: %s\n", filePath);
    
    

    /* Start of Cited Code
    Create a file pointer to read a file and get the first character
    https://www.w3schools.com/c/c_files_read.php
    */

    FILE * filePtr = fopen(filePath, "r"); 
    char c = fgetc(filePtr);
    /* End of Cited Code */
    
    free(filePath); /* No need to keep the file path in memory anymore */



    int line = 1;
    int col = 1;
    while (c != EOF){ /* Read until end of file is detected */

        printf("Line %d Col %d has ASCII Code %d which is a %s.\n",line, col, c, getType(c));
        if (c != '\n'){ /* As long as the character is not a new line, column number gets incremented */
            col++;
        } else { /* If the character is a new line, line number will increment and column number will reset */
            line++;
            col = 1;
        }

        c = fgetc(filePtr); /* Finally, get the next character */
    } 

    fclose(filePtr); /* Need to close the file when done */
    return 0;
    
}


char * getType(char c){
    /* Look up character type */

    if (c >= 'a' && c <= 'z'){
        return "Lower Case Letter";
    } else if (c >= 'A' && c <= 'Z'){
        return "Upper Case Letter";
    } else if (c >= '0' && c <= '9') {
        return "Digit";
    } else if (c == ' '){
        return "Space";
    } else if (c == '\n'){
        return "Newline";
    } else {
        return "Symbol";
    }
}


char * readFromStdIn(){
    char * txt = malloc(201 * sizeof(char)); /* Assume string can be up to 200 characters + null terminator */
    int pos = 0;
    int c = getchar();
    while (c != '\n' && c != EOF){
        txt[pos] = c;
        pos++;
        c = getchar();
    }
    txt[pos] = 0; /* Fix string by adding null terminator */
    return txt;
}