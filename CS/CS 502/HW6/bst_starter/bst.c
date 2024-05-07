/**
	@file
	@author Andy Cherney <alc466@drexel.edu>
	@date February 23, 2022
	@section DESCRIPTION
 
	This is the implementation file for a binary search tree and its methods. 
 */

#include "bst.h"
#include <stdio.h>
#include <stdlib.h>


BST* newBST(){

    BST *T = malloc(sizeof(*T));
    if (T == NULL){
        perror("Tree Malloc error");
        exit(1);
    }

    T->root = NULL;
    return T;

}

void deleteBST(BST* T){
    if (T->root == NULL) {
        return;
    }
    deleteNode(T->root);
    free(T);
    
}

void insert(BST* T, int target){
    T->root = insertValue(target, T->root);
}

char find(BST* T, int target){
    return findValue(target, T->root);
}

void deleteFromTree(BST* T, int target){
    T->root = deleteValue(target, T->root);
}

int min(BST* T){
    return findMin(T->root);
}

void inorder(BST* T){
    inorderWalker(T->root);
    printf("\n");
}

void preorder(BST* T){
    preorderWalker(T->root);
    printf("\n");
}

void postorder(BST* T){
    postorderWalker(T->root);
    printf("\n");
}

int height(BST* T){
    return nodeHeight(T->root);
}


void inorderWalker(Node* current){
    if (current == NULL){
        return ;
    }

    inorderWalker(current->left);
    printf("%d ", current->value);
    inorderWalker(current->right);
}

void preorderWalker(Node* current){
    if (current == NULL){
        return ;
    }
    
    printf("%d ", current->value);
    preorderWalker(current->left);
    preorderWalker(current->right);

}

void postorderWalker(Node* current){
    if (current == NULL){
        return ;
    }

    postorderWalker(current->left);
    postorderWalker(current->right);
    printf("%d ", current->value);
}



Node* insertValue(int target, Node* current){
    if (current == NULL){
        Node* newNode = malloc(sizeof(*newNode));
        if (newNode == NULL){
        perror("Node Malloc error");
        exit(2);
        }
        newNode->value = target;
        newNode->left = NULL;
        newNode->right = NULL;
        return newNode;
    }

    if (current->value == target){
        return current;
    }

    if (current->value > target){
        current->left = insertValue(target, current->left);
    } else {
        current->right = insertValue(target, current->right);
    }
    return current;
}


char findValue(int target, Node* current){
    if (current == NULL){
        return 0;
    }
    if (current->value == target){
        return 1;
    } 

    if (current->value > target){
        return findValue(target, current->left);
    }
    return findValue(target, current->right);

}


int findMin(Node* current){
    if (current == NULL){
        return -1;
    } 
    if (current->left == NULL){
        return current->value;
    }
    return findMin(current->left);

}

int nodeHeight(Node* current){
    if (current == NULL){
        return -1;
    } else{

    int lheight = nodeHeight(current->left);
    int rheight = nodeHeight(current->right);

    if (lheight > rheight){
        return (lheight + 1);
    }
    return (rheight + 1);
    }


}

Node* deleteValue(int target, Node* current){
    if (current == NULL){
        return NULL;
    }
    if (current->value == target){
        return deleteNode(current);
    }
    if (current->value > target){
        current->left = deleteValue(target, current->left);
    } else {
        current->right = deleteValue(target, current->right);
    }
    
    return current;
}

Node* deleteNode(Node* current){
    if (current->left == NULL){
        return current->right;
    }
    if (current->right  == NULL){
        return current->left;
    }
    int minVal = findMin(current->right);
    current->value = minVal;
    current->right = deleteValue(minVal, current->right);
    return current;
}
