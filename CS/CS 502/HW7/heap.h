/**
	@file
	@author Andy Cherney <alc466@drexel.edu>
	@date March 4, 2024
	@section DESCRIPTION
 
	This is a header file for a heap class. This will be used to hold a cubesum data structure.
 */

#include <stdbool.h>

#ifndef _HEAP_H_
#define _HEAP_H_
#define STARTSIZE 10  


/**
 Stores a sum i^3 + j^3 = k
*/

struct CubeSum{
    int sum;/**< result of i^3 + j^3 */
    int i;/**< First integer in sum */
    int j;/**< Second integer in sum */
};
typedef struct CubeSum CubeSum;

/**
 Heap structure to store all the cube sums
*/

struct Heap{
    CubeSum** data; /* pointer that points to the cubesum pointers */
    int capacity;   /* max size of the heap */
    int currentSize; /* number of elements stored in the heap */
    
};
typedef struct Heap Heap;

/**
 Create a new heap with starting size 10.
    @return the heap that was created.
    */
Heap *newHeap();

/**
 Delete the heap. Free all memory used.
    @param myHeap is the heap to delete
    */
void deleteHeap(Heap *myHeap);

/**
 Determine if the heap is empty.
    @param myHeap is the heap to check
    @return true if the heap is empty and false otherwise
*/
bool isEmpty(Heap *myHeap);


/**
    Compare 2 cubesum objects. This helps keep the heap sorted upon inserting and deletings. 

    @param s1 is the first cubeSum
    @param s2 is the second cubeSum
    @return true if the first sum < second sum or in case of ties, the first i value is less than the second i value. Otherwise, return false
*/

bool cubeSumCompare(CubeSum* s1, CubeSum* s2);


/**
Resizes the heap if more elements are needed.
    @param myHeap is the heap to resize
*/

void resize(Heap *myHeap);

/**
Returns the parent index of a child node in the heap
    @param i the index of the child
*/
int parent(int i);

/**
 Insert a new sum into the heap.
    @param myHeap is the heap to insert into
    @param sum is a pointer to the sum to insert
    */
void insert(Heap *myHeap, CubeSum* sum);


/**
 Remove the minimum from the heap.
    @param myHeap is the heap to remove from
    */
void removeMin(Heap *myHeap);

/**
 Get the pointer to the smallest CubeSum.
    @param myHeap is the heap to get the min of
    @return a pointer to the smallest CubeSum
    */
CubeSum *getMin(Heap *myHeap);

#endif
