/**
 @mainpage Prime Detection
 @section Description
 
 Given a starting point, finds the next prime number.
 */
/**
 @file
 @author Mark Boady <mwb33@drexel.edu>
 @date Summer 2023
 @section Details
 
 You should only need to change main(void) to solve this problem.
 */
/* You do not need any libraries that are not provided here. */
#include <stdlib.h>
#include <time.h>
#include <stdio.h>
#include <stdbool.h>
/**
 Determine if the number is prime.
 @param x is a positive integer
 @return true if the number prime and false otherwise
 */
bool isPrime(int x);

/**
 Find the first prime larger that x.
 @param x is the starting point
 @return the first prime larger than x
 */
int firstPrimeAfter(int x);

/**
    Run some tests on our function.
    @return always 0
 */
int main(void){
    printf("| %10s | %10s | %10s |\n","Start","Prime","Clocks");
    printf("| ---------- | ---------- | ---------- |\n");
    char* format="| %10d | %10d | %10d |\n";
    int start = 1024;
    for(int count=0; count < 21; count++){
        clock_t start_t = clock();
        int answer = firstPrimeAfter(start);
        clock_t end_t = clock();
        int clockCount = end_t - start_t;
        printf(format,start,answer,clockCount);
        start=start*2;
    }
    return 0;
}

bool isPrime(int x){
    if(x==2){return true;}
    int a = 2;
    while(a*a <= x){
        if(x % a == 0){
            return false;
        }
        a++;
    }
    return true;
}

int firstPrimeAfter(int x){
    /* Less than 2 is for overflow errors */
    while(!isPrime(x) || x < 2){
        x++;
    }
    return x;
}