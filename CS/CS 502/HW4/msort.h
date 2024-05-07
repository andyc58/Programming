/**
@file
@author Andy Cherney <mwb33@drexel.edu>
@date February 02, 2024
@section DESCRIPTION

This library will be used to implement the merge sort algorithm. 
*/

#ifndef MSORT_H
#define MSORT_H

    /**
        Merge Sort an array of strings
        @param wordList is the list of words to sort
        @param size is the number of words to sort
    */
    void msort(char** wordList, int size);

    /**
        Recursive implemenation of merge sort
        @param wordList is the array to sort
        @param start is the first index to sort
        @param stop is the last index to sort
    */
    void msortRec(char** wordList, int start, int stop);

    /**
        Merge two sections of the array together
        @param wordList is the array to merge
        @param start is the start of the first half
        @param middle is the break point, the last value of the first half
        @param stop is the end of the second half
    */
    void merge(char** wordList, int start, int middle, int stop);

#endif
