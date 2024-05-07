/**
 @mainpage
 @section Overview

 This is Andy Cherney's program for part 1 of HW 3.
*/

/**
  @file
  @author Andy Cherney <alc466@drexel.edu>
  @date January 22, 2023
  @section DESCRIPTION

  A linear search typing program. Repeatedly ask the user what letter they are thinking until they get the right one. 
  Stop when the user types the exclamation point.
 */


#include <stdio.h>
#include <stdlib.h>


/**
  Driver for a linear search typing program

  @return 0 if successful
 */


int main(){

    const char* ALPHABET = " !.abcdefghijklmnopqrstuvwxyz";

    const int size = 101; /* User will enter no more than 100 characters in the text string before entering ! */

    char* text = malloc(size*sizeof(char));


    int i = 0; /* References the index of the character in the alphabet */
    int j = 0; /* References the index for the character of the text string */

    /* User will enter no more than 100 characters in the text string before entering ! */
    while (i < size){

        char letter = ALPHABET[i % 29];  /* Alphabet will reset back if user goes above the 29 characters found in the alphabet */
        printf("Are you thinking of the letter '%c'?\n", letter);
        char userEntered;
        scanf(" %c", &userEntered); /* Removes the newline from input buffer */

        int yes = userEntered == 'y' || userEntered == 'Y';
        
        if (letter == '!' && yes){ /* Exit if the user types yes for the exclamation mark */
            break;
        }
        
        if (yes){ /* If the user did type yes for all other chars, add the letter to the text string */
            text[j] = letter;
            j++;
            i = 0; /* Resets the alphabet back when the user entered yes */
            continue;
        }


        i++;
    }

    printf("You typed:\n%s\n",text);
    free(text);

    return 0;
}



