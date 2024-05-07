/**
  @mainpage CS 502 - Homework 8
  @section Description

  Program to build a minimum spanning tree using Kruskal's Algorithm
*/

/**
  @file
  @author Andy Cherney <alc466@drexel.edu>
  @date March 8, 2024
  @section DESCRIPTION
 
  This is the implementation file for the kruskal algorithm. It contains declarations for methods 
  needed to to create a graph, add edges, and run the algorithm.
*/

#include <stdio.h>
#include <stdlib.h>
#include "kruskal.h"
#include "quicksort.h"


/**
	Driver program to build a minimum spanning tree using Kruskal's Algorithm
 */

int main() {

    int numNodes;
    Graph *myGraph;

    /* Get input path from user */
    printf("Enter File Containing Graph:\n");
    char path [200];
    scanf("%s",path);
    FILE *file = fopen(path, "r");
    if (file == NULL) {
        perror("Failed to open file");
        exit(-1);
    }
    fscanf(file, "%d", &numNodes);
    
    int from, to, weight;
    myGraph = newGraph(numNodes);

    /* Add edges to graph from file */
    while (fscanf(file, "%d %d %d", &from, &to, &weight) == 3){
        addEdge(myGraph, from , to, weight);
    }
    
    /* Run Kruskal's Algorithm */
    fclose(file);
    printf("Running Kruskal's Algorithm\n");
    printf("Input File: %s\n", path);
    kruskalMST(myGraph);
    deleteGraph(myGraph);

    return 0;
  }
