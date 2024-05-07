/**
	@file
	@author Andy Cherney <alc466@drexel.edu>
	@date March 4, 2024
	@section DESCRIPTION
 
	This is the implementation file for a heap. The heap will be used to hold a cubesum data structure.
 */


#include "heap.h"
#include <stdio.h>
#include <stdlib.h>

Heap *newHeap(){

    /* Initialize a new heap */
    Heap* myHeap = (Heap *) malloc(sizeof(Heap));
    myHeap->currentSize = 0;
    myHeap->capacity = STARTSIZE;
    myHeap->data = (CubeSum **) malloc(STARTSIZE * sizeof(CubeSum *));
    return myHeap;
}

void deleteHeap(Heap *myHeap){

    /* After all values have been printed we can remove the array and the heap pointer*/
    if (myHeap) {
        free(myHeap->data);
        free(myHeap);
    }
}


bool cubeSumCompare(CubeSum* s1, CubeSum* s2){

    /* 
    To maintain the heap order, we need to be sure the sums are inserted and deleted correctly. 
    The cubesums are compared the following way:

        1. Lowest sum wins
        2. If the sums are equal, first addend (i) wins
    */

    if (s1->sum < s2->sum) {
        return true;
    }

    if (s1->sum == s2->sum && s1->i < s2->i){
        return true;
    }

    return false;

}

/* Check if the size is 0 or not to see if the heap is empty*/
bool isEmpty(Heap *myHeap){
    return myHeap->currentSize == 0; 
}

void resize(Heap *myHeap){

    /* No need to resize if the size is less than the capacity */
    if (myHeap->currentSize < myHeap->capacity){
        return ;
    }

    /* Add another level to the heap structure*/
    myHeap->capacity *= 2; 
    myHeap->data = (CubeSum **) realloc(myHeap->data, myHeap->capacity * sizeof(CubeSum *));

}

int parent(int i){
    return (i - 1) / 2;
}

void insert(Heap *myHeap, CubeSum *sum){
    
    /* Check if heap needs to be resized if necessary*/
    resize(myHeap);
    int i = myHeap->currentSize;

    /* 
        We need to upheap by first comparing the new cubesum with its parent. If sum comes before the parent,
        it needs to move down to the child's position. We repeat for each element until the root is reached
    */
    while (i > 0 && cubeSumCompare(sum, myHeap->data[parent(i)])){
        myHeap->data[i] = myHeap->data[parent(i)];
        i = parent(i); /* Update parent index */
    }
    
    /* Finally, insert the sum and increase the heap size*/
    myHeap->data[i] = sum;
    myHeap->currentSize++;
}



void removeMin(Heap *myHeap){

    /* No need to do anything if the heap is empty*/
    if (isEmpty(myHeap)){
        return;
    }

    /* Set first to the last value */
    myHeap->currentSize--;
    myHeap->data[0] = myHeap->data[myHeap->currentSize];

    int i = 0;
    int done = 0;

    /* This is the downheap procedure*/
    while (! done){

        /* Find a child index */
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        

        /* We want the current node to be the minimum*/
        int minimum = i; 

        /* Min becomes the left child if it is less than the current value*/
        if (leftChild < myHeap->currentSize && cubeSumCompare(myHeap->data[leftChild], myHeap->data[minimum])){
            minimum = leftChild;
        }


        /* Min becomes the right child if it is less than the current value*/
        if (rightChild < myHeap->currentSize && cubeSumCompare(myHeap->data[rightChild], myHeap->data[minimum])) {
            minimum = rightChild;
        }

        /* If the minimum was reached, we are done */
        if (minimum == i){
            break;
        } 

        /* Otherwise, we have to swap the current with the minimum value*/
        CubeSum* t = myHeap->data[i];
        myHeap->data[i] = myHeap->data[minimum];
        myHeap->data[minimum] = t;
        i = minimum;
    }


}


CubeSum *getMin(Heap *myHeap){

    /* 
    Since the heap maintains the order when inserting and deleting, the min cubesum is always the first value
    */
    return myHeap->data[0];
}