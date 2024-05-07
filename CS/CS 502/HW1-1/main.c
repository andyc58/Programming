/**
  @mainpage
  @section Overview

  This is Andy's program for part 1 of HW 1
*/

/**
  @file
  @author Andy Cherney <alc466@drexel.edu>
  @date January 10, 2023
  @section DESCRIPTION

  Program to generate a bar code given a zip code
 
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>


/**
  Check if a string is a positive integer (contains only digits)
  @param str is the string to check
  @return 1 if true and 0 if false
 */

int isInteger(char * str);


/**
  Driver program to make a barcode given a zip code
  @return 0 if successful and 1 on error
 */

int main (){
    
    const int size = 5;
    char zip[size];

    
    printf("Enter Zip Code:\n");

    /* Start of Cited Code
    Another way to get user input
    https://www.geeksforgeeks.org/scanf-in-c/
    */
    scanf("%s", zip); 
    /* End of Cited Code */



    // If the user enters a zip code containing characters other than digits, stop the program (return 1)
    if (! isInteger(zip)){ 
        printf("You can only enter digits\n"); 
        return 1;
    }

    // If the user enters a value that is not exactly 5 digits, stop the program (return 1)
    if (strlen(zip) != size){
        printf("Bad Zip Code\n"); 
        return 1;
    }

    // Array to look up the code by digit (corresponds to index)
    char* codes [10] = {"||...","...||", "..|.|", "..||.", 
                            ".|..|", ".|.|.", ".||..", 
                            "|...|", "|..|.", "|.|.."};

    // Build String and calculate the checksum
    printf("%s", "|"); // Print the first pipe character for scanner alignment
    int checksum = 0;
    for (int i = 0; i < size; i++){
        int val = zip[i] - 48;  // Converts the digit character to an int by offsetting its ASCII code
        printf("%s", codes[val]); // Output the code for the digit (same line)
        checksum += val;
        
    }

    
    
    /* Next Step: Add the error to the result
    To find the error value, we need to know what number should be added to the checksum to reach the next multiple of ten.
    */

    int r = checksum % 10; // Finding remainder of 10 always returns the last digit
    if (r != 0){ // If there is a remainder r, we would need to add 10 - r to the checksum to get the next highest multiple.
        printf("%s", codes[10-r]);
    }else{ // If the sum of digits is already a multiple of 10, we just need to add 0 to the result.
        printf("%s", codes[0]);
    }

    printf("%s\n", "|"); // Final step: Close the code string for scanner alignment

    return 0;
    
}

int isInteger(char* str){
	int pos=0;
	
	for(char * c = str; *c ; c++){ // Can use a pointer to the string to iterate over each character
		/* Check against ASCII Codes */
		if(*c < 48 || *c > 57){
			return 0;
		}

	}
	/* No non-digits found */
	return 1;
}


