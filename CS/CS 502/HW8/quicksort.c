/**
	@file
	@author Andy Cherney <alc466@drexel.edu>
	@date March 8, 2022
	@section DESCRIPTION
 
  This is the implementation file for the quicksort algorithm. It contains declarations 
  for methods needed to sort edges in a graph, which is required for the kruskal algorithm.
 */



#include <stdio.h>
#include <stdlib.h>
#include "quicksort.h"
#include "kruskal.h"

int lessThan(Edge* e1, Edge* e2){
    /** Node with the smallest weight wins ***/
    if (e1->weight < e2->weight){
        return 1;
    }

    /** When there is a tie, the smallest from node wins ***/
    if (e1->weight == e2->weight && e1->from < e2->from){
        return 1; 
    }

    return 0;
  
}

void printEdges(Edge** edges, int size){
    int cost = 0; /* Total weight of MST*/
    for(int i=0; i < size; i++){
        
        /** Always print smallest node first **/
        if (edges[i]->from < edges[i]->to)
            printf("Added Edge: (%d, %d) with weight %d\n", edges[i]->from, edges[i]->to, edges[i]->weight);
        else
            printf("Added Edge: (%d, %d) with weight %d\n", edges[i]->to, edges[i]->from, edges[i]->weight);
        
        cost += edges[i]->weight;
    }

    printf("MST Weight: %d\n", cost);
}

void qSort(Edge** edges, int size){
    quickSort(edges, 0, size - 1);
}

void quickSort(Edge** edges, int start, int stop){
    if(start >= stop){
      return;
    }

    /* Recursively partition on both sides of the pivot*/
    int p = partition(edges,start,stop);
    quickSort(edges,start,p - 1);
    quickSort(edges,p + 1,stop);
}

int partition(Edge** edges, int start, int stop){

    /* Choose random pivot */
    int r = start + rand() % (stop - start + 1);

    /* Swap pivot with last element */
    Edge* temp = edges[r];
    edges[r] = edges[stop];
    edges[stop] = temp;
    

    Edge* pivot = edges[stop];
    int j = start;

    /* Move all elements less than pivot to the left */
    for(int i = start; i < stop; i++){
        if(lessThan(edges[i], pivot)){
            temp = edges[j];
            edges[j] = edges[i];
            edges[i] = temp;
            j++;
            
        }
    }

    /* Move pivot to its final position */
    edges[stop] = edges[j];
    edges[j] = pivot;
    return j;
}
