/**
    @mainpage CS 502 - Homework 7
    @section Description

    Program to output a list of all possible cube sums using a heap. The user will enter a maximum value N and the program
    will print out a range of sums between 0 and N.
*/

/**
    @file
    @author Andy Cherney <alc466@drexel.edu>
    @date March 04, 2024
    @section DESCRIPTION

    Main program to output the list of cube sums
*/

#include <stdio.h>
#include <stdlib.h>
#include "heap.h"

int main(){

    printf("Cube Sum Program.\nComputes Cube Sums from 0 ... N\n");
    printf("Enter max value of N:\n");
    int N;
    scanf("%d", &N);

    /* Make a new heap */
    Heap *myHeap = newHeap();

    for (int i = 0; i <= N; i++){
        
        /* Add (i^3 + 0^3, i, 0) to the Heap */
        CubeSum *sum = malloc(sizeof(CubeSum));
        sum->i = i;
        sum->j = 0;
        sum->sum = i * i * i;
        insert(myHeap, sum);

    }

    while(!isEmpty(myHeap)){

        /* Get the minimum sum*/
        CubeSum* minCubeSum = getMin(myHeap); 

        /* Print the sum */
        printf("%d^3 + %d^3 = %d\n", minCubeSum->i, minCubeSum->j, minCubeSum->sum); 

        /* Need to then remove the minimum from the heap */
        removeMin(myHeap); 

        if(minCubeSum->j < N) {
            
            /* Add a new sum (i^3 + (j+1)^3, i, j+1) to the heap */
            CubeSum* new = (CubeSum*) malloc(sizeof(CubeSum));
            new->sum = minCubeSum->i * minCubeSum->i * minCubeSum->i + (minCubeSum->j + 1) * (minCubeSum->j + 1) * (minCubeSum->j + 1);
            new->i = minCubeSum->i;
            new->j = minCubeSum->j + 1;
            insert(myHeap, new);
        }
       
        /* Free each cubesum when done*/
        free(minCubeSum); 

    }

    /* Remove the heap completely*/
    deleteHeap(myHeap);
    return 0;

}


