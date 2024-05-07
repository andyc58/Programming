/**
	@file
	@author Andy Cherney <alc466@drexel.edu>
	@date March 8, 2024
	@section DESCRIPTION
 
  This is the implementation file for the kruskal algorithm. It contains declarations for methods 
  needed to to create a graph, add edges, and run the algorithm.
 */

#include <stdlib.h>
#include <stdio.h>
#include "kruskal.h"
#include "quicksort.h"

Graph* newGraph(int numV) {
    Graph* myGraph = malloc(sizeof(Graph));
    myGraph->numV = numV; /* Num vertices */
    myGraph->numE = 0; /* Num edges starts at 0 */
    myGraph->edges = NULL; /* Initialize to NULL, no edges initially */
    return myGraph;
}

void deleteGraph(Graph* myGraph){
    Edge** temp = myGraph->edges;
    while(myGraph->numE > 0){ 
      free(*temp);
      myGraph->numE--; /* Decrement the number of edges */
      temp++;
    }

    /* Free the edges array */
    free(myGraph->edges);
    free(myGraph);
}

void addEdge(Graph* graph, int from, int to, int weight) {
    /* Increment the number of edges */
    graph->numE++;

    /* Reallocate memory for a new edge in the list */
    Edge** temp = realloc(graph->edges, graph->numE * sizeof(Edge));

    /* Check if realloc succeeded */
    if (temp == NULL) {
        free(temp);
        deleteGraph(graph);
        perror("Failed to add edge");
        exit(-1);
    }

    /* Update the edges array */
    graph->edges = temp;

    /* Allocate space for the new edge */
    graph->edges[graph->numE - 1] = malloc(sizeof(Edge));

    /* Access the last element of the edges array */
    Edge* newEdge = graph->edges[graph->numE - 1];

    /* Assign values to the new edge */
    newEdge->from = from;
    newEdge->to = to;
    newEdge->weight = weight;
}

void Union(int x, int y, Subset A []){

    /* Link the sets containing x and y */
    link(findSet(x, A), findSet(y, A), A);
}

void link(int x, int y, Subset A []){
    if (A[x].rank < A[y].rank)
        A[x].p = y;
    else {
        A[y].p = x;
        if (A[x].rank == A[y].rank)
            A[x].rank++;    
    }
}


void makeSet(int x, Subset A []){
    /* Each set is just a node with itself as the parent*/
    A[x].p = x;
    A[x].rank = 0;
}

int findSet(int x, Subset A []) {
    if (A[x].p != x)
        A[x].p = findSet(A[x].p, A);
    return A[x].p;
}

void kruskalMST(Graph* graph){

    /* Sort the edges by weight and break ties */
    qSort(graph->edges, graph->numE);

    /* Initialize the minimum spanning tree */
    Edge* mst [graph->numV];
    int e = 0, i = 0;

    /* Create a set for each vertex */
    Subset* subsets = (Subset*) malloc(graph->numV * sizeof(Subset));
    for (int v = 0; v < graph->numV; ++v) {  
        makeSet(v, subsets);
    } 

    while(e < graph->numV - 1 && i < graph->numE){

        /* Find the next edge in the set */
        Edge* next = graph->edges[i];
        i++;
        int x = findSet(next->from, subsets);
        int y = findSet(next->to, subsets);

        /* Add the edge to the minimum spanning tree if it does not create a cycle */
        if (x != y){
            mst[e] = next;
            e++;
            Union(x, y, subsets);
        } 
    }

    /* Print the minimum spanning tree */
    printEdges(mst, e);
    free(subsets);

}