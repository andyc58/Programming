/**
	@file
	@author Andy Cherney <alc466@drexel.edu>
	@date March 8, 2022
	@section DESCRIPTION
 
	This is the header file for the quicksort algorithm. It contains declarations 
  for methods needed to sort edges in a graph, which is required for the kruskal algorithm.
 */

#include "kruskal.h"

#ifndef _Q_SORT_H
#define _Q_SORT_H

/**
  This function will compare 2 edges

  @param e1 pointer to the first edge
  @param e2 pointer to the second edge
  @return 1 if the first edge is less than the 2nd edge, 0 otherwise
*/
int lessThan(Edge* e1, Edge* e2);

/**
  Prints a list of edges

  @param edges the edge list (pointer to edge pointers)
  @param size the size of the edge list
*/
void printEdges(Edge** edges, int size);

/**
  Helper function to call the quicksort algorithm

  @param edges the edge list
  @param size the size of the edge list
*/
void qSort(Edge** edges, int size);

/**
  Recursive implementation of quicksort

  @param edges the edge list
  @param size the size of the edge list
*/
void quickSort(Edge** edges, int start, int stop);

/**
  Partitions the list of edges for the quicksort algorithm

  @param edges the edge list
  @param size the size of the edge list
  @return the index of the pivot
*/
int partition(Edge** edges, int start, int stop);

#endif
