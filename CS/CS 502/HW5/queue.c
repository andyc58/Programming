
/**
        @file
        @author Andy Cherney <alc466@drexel.edu>
        @date 2022-2023
        @section DESCRIPTION

        This is the C implementation file for a classic queue data structure.
        It includes the Queue Structure and all methods needed. Its purpose is also to solve the Josephus puzzle.
 */

#include "queue.h"
#include <stdio.h>
#include <stdlib.h>

Queue *newQueue(){
    // Create new queue
    struct Queue *Q = malloc(sizeof(*Q));
    Q->head = NULL;
    Q->tail = NULL;
    return Q;
}

char isEmpty(Queue *Q){

    /* Here all we need to check is whether the head is null or not*/
    return (Q->head == NULL);
}

void enqueue(int v, Queue *Q){

    /* Initialize a new node*/
    struct Node *newNode = malloc(sizeof(*newNode));
    newNode->value = v;
    newNode->next = NULL;

    if (isEmpty(Q)){
        Q->head = newNode; /* If the queue is empty, the head will now be the new node*/
    }else{
        Q->tail->next = newNode; /* Otherwise, put the node after the current tail */
    }
    Q->tail = newNode; /* Tail will always reference the new node */
}

int front(Queue *Q){

    /* Front will return the value at the head of the queue and -1 if the queue is empty*/
    if (isEmpty(Q)){
        return -1;
    }
    return Q->head->value;
}

void dequeue(Queue *Q){

    /* Don't do anything if the queue is empty*/
    if (isEmpty(Q)){
        return;
    }

    /* Next value in queue becomes the new head */
    Node *temp = Q->head;
    Q->head = temp->next;

    free(temp); /* No need to keep temporary pointer to the head anymore */

    /* In the case that the queue becomes empty after removal, remove tail reference */
    if (isEmpty(Q)){
        Q->tail = NULL;
    }
}

void printQueue(Queue *Q){

    /* Print each value by moving the head pointer to the next node */
    Node *head = Q->head;
    while (head){
        if (!head->next){
            printf("%d\n", head->value);
        } else{
            printf("%d ", head->value);
        }
        head = head->next;
    }
}

void josephus(int n, int m){

    /* Starting queue that holds everyone */
    Queue *people = newQueue();

    /* 2nd queue to log the order eliminated */
    Queue *eliminated = newQueue();

    /* Populate the starting queue*/
    for (int i = 0; i < n; i++){
        enqueue(i, people);
    }

    int j;

    /*
    When the queue is not empty, we move each person to the back of the queue until the mth person
    is reached. That person is then transfered to the secondary queue and eliminated
    from the starting queue
    */

    while (!isEmpty(people)){
        for (j = 1; j < m; j++){
            int first = front(people);
            dequeue(people);
            enqueue(first, people);
        }

        /* Transfer the eliminated person*/
        enqueue(front(people), eliminated);
        dequeue(people);
    }
    free(people);

    /* Prints the secondary queue and frees it when done */
    printf("Order Eliminated:\n");
    printQueue(eliminated);

    while (!isEmpty(eliminated)){
        dequeue(eliminated);
    }
    free(eliminated);
}
