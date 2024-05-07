/**
@file
@author Andy Cherney <mwb33@drexel.edu>
@date February 02, 2024
@section DESCRIPTION

Since this assignment prohibits the use of the string.h library in C, this library will be used to manually define 
any necessary functions that come from that library or custom functions that work with strings in some way. 
*/

#ifndef MYSTRING_H
#define MYSTRING_H


/**
    Count the number of lines in a file
    @param filePtr is the pointer to the file object
    @return number of lines
*/

int countLines(FILE *filePtr);

/**
    Find the number of characters in the string excluding the null terminator (Part of string.h)
    @param str the string to count
    @return number of characters in the string excluding the null
*/
int length(char* str);


/**
    Compare 2 strings alphabetically (Similar to strcmp of string.h)
    @param word1 first string to compare
    @param word2 second string to compare
    @return 1 if the first string is lexicographically lower than the second string, 0 otherwise
*/
int lessThan(const char* word1, const char* word2);

#endif
