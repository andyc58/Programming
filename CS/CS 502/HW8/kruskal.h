/**
	@file
	@author Andy Cherney <alc466@drexel.edu>
	@date March 8, 2024
	@section DESCRIPTION
 
	This is the header file for the kruskal algorithm. It contains declarations for methods 
  needed to to create a graph, add edges, and run the algorithm.
 */

#ifndef _KRUSKAL_H
#define _KRUSKAL_H

/**
	A structure to represent an edge in a graph.
 */

typedef struct Edge Edge;
struct Edge {
  int from; /**<The id of the source node*/
  int to; /**<The id of the destination node*/
  int weight; /**<The weight of the edge*/
};


/**
	A structure to represent a graph.
 */

typedef struct Graph Graph;
struct Graph {
  int numE, numV; /**<numE is the number of edges, numV is the number of vertices (nodes)*/
  Edge** edges; /**<Pointer to a pointer of edges*/
  
};

/**
	A subset structure to represent a node for the union find algorithm
 */

typedef struct Subset Subset;
struct Subset {  
    int p; /**<Value of the parent node*/
    int rank;  /**<Priority of the node*/
} ;

/**
	Create a new empty graph

  @param V initializer for the number of vertices
	@return Pointer to empty BST
 */

Graph* newGraph(int V);


/**
	Add an edge to the graph

  @param graph The graph to add the edge in
  @param from The id of the from node
  @param to The id of the to node
  @param weight The weight of the edge
 */

void addEdge(Graph* graph,int from, int to, int weight);


/**
	Removes all memory space used by the graph

  @param graph The graph to remove
 */

void deleteGraph(Graph* myGraph);


/**
  Helper function to find the union of 2 sets

  @param x The id of the first node
  @param y The id of the second node
  @param A The array of subsets (nodes)
*/

void Union(int x, int y, Subset A []);


/**
  Link 2 subsets together

  @param x The id of the first node
  @param y The id of the second node
  @param A The array of subsets (nodes)
*/

void link(int x, int y, Subset A []);


/**
  Create a new subset for the union find algorithm

  @param x The id of the node
  @param A The array of subsets (nodes)
*/

void makeSet(int x, Subset A []);


/**
  Find the set that node x belongs to. 
  
  @param x The id of the node
  @param A The array of subsets (nodes)
  @return The id of the set
*/
int findSet(int x, Subset A []);


/**
	Find the MST using Kruskal's algorithm. 

  @param graph The graph to run the algorithm on
 */
void kruskalMST(Graph* graph);

#endif
