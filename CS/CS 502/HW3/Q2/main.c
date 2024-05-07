/**
 @mainpage
 @section Overview

 This is Andy Cherney's program for part 2 of HW 3.
*/

/**
  @file
  @author Andy Cherney <alc466@drexel.edu>
  @date January 22, 2023
  @section DESCRIPTION

  A binary search typing program. Similar to the linear search, but repeatedly ask the user a range of letters and split out the range 
  until they get the right one. Stop when the user types the exclamation point.
 */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>


/** 
 Driver for binary search typing

 @return 0 if successful,  -1 if user does not choose any letter
*/

int main() {
    char in;
    const int SIZE = 100; /* User will not type more than 100 characters*/
    char* text = malloc((SIZE+1)*sizeof(char)); 
    int i = 0;
    const char* ALPHABET =  " !.abcdefghijklmnopqrstuvwxyz";
    
    int done = 0;
    while (! done) {
        int start = 0;
        int end = strlen(ALPHABET) - 1; /* 29 characters in the alphabet string */

        while (start <= end) {
            int mid = start + (end - start) / 2;
            
            /* Handle the single character range */
            if (start == end) {
                printf("Is your letter '%c'? (y/n)\n", ALPHABET[start]);
                scanf(" %c", &in);
                int yes = (in == 'y') || (in == 'Y');
                if (yes) {
                    if (ALPHABET[start] == '!') {
                            printf("You typed:\n%s\n", text);
                            free(text);
                            return 0;
                    }
                    text[i] = ALPHABET[start];
                    i++;
                    break;
                } else {
                    printf("You didn't choose anything.\n");
                    return -1; /* Exit if user makes a mistake and types 'n' */
                }
             } else { /* Adjust the range otherwise */
                printf("Is your letter between '%c' and '%c'? (y/n)\n", ALPHABET[start], ALPHABET[mid]);
                scanf(" %c", &in);
                int yes = (in == 'y') || (in == 'Y');
                if (yes) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            
        }
    }
}
