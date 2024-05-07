/**
 @mainpage
 @section Overview

 This is Andy's program for part 2 of HW 1
*/

/**
  @file
  @author Andy Cherney <alc466@drexel.edu>
  @date January 10, 2023
  @section DESCRIPTION
  
  Program to calculate heart's desire, personality number, and power number given a name
 */

#include <stdio.h>
#include <stdlib.h>


/**
  Read from stdin using a custom buffer size until hitting a newline
  @param bufferSize a predefined-size for the buffer
  @return A pointer to a character array (null terminated) with letters read
 */

char* readFromStdin(int bufferSize);


/**
    Finds the numerical representation of the letter to use in the calculation (case-insensitive).
    @param letter - the letter to look up
    @return a number that represents the letter in the calculation
*/

int getLetterValue(char letter);


/**
    Slices a string from the start to a fixed number of characters. If the size is larger than the length of the string, the original string is returned
    @param str - the string to truncate
    @param size - number of characters to keep (inclusive)
    @return a sliced string containing the characters from the start to the position indicated by size
*/

char* truncate(char* str, int size);


/**
    Repeatedly calculates the sum of the digits of a number until a 1 digit number is reached (needed for numerology calculations)
    @param num - number to calculate
    @return a digit from 0 to 9 that is the result of repeatedly calculating the sum of digits
*/

int repeatDigitSum(int num);

/**
    Check if a letter is an obvious vowel (excludes y).
    @param letter - character to check.
    @return 1 if true and 0 if false 
*/

int isVowel(char letter);

/**
    Calculates the power number given a name.
    @param name - name to calculate.
    @return integer representing the power number
*/

int computePowerNumber(char * name);

/**
    Calculates the heart desire numer given a name.
    @param name - name to calculate.
    @return integer representing the heart desire
*/

int computeHeartDesire(char * name);

/**
    Calculates the personality numer given a name.
    @param name - name to calculate.
    @return integer representing personalize number
*/
int computePersonalityNumber(char * name);

/**
	Driver program to calculate heart's desire, personality number, and power number given a name
    @return 0 if successful and 1 on error
 */

int main (){

    const int SIZE = 50;

    printf("Enter Your Name:\n");
    char * name = readFromStdin(SIZE);
    char * nameTrimmed = truncate(name,SIZE); // Returns original string if length is less than 50 characters

    free(name);


    printf("Heart's Desire Number: %d\n"
            "Personality Number: %d\n"
            "Power Number: %d\n",
            computeHeartDesire(nameTrimmed),
            computePersonalityNumber(nameTrimmed),
            computePowerNumber(nameTrimmed));


    free(nameTrimmed);
    return 0;
}   



char* readFromStdin(int bufferSize){
	/* Create an array buffer */
	char* buffer = malloc(sizeof(char)*bufferSize);
	/* Place characters into buffer starting at pos 0 */
	int position = 0;
	/* Loop over characters */
	char temp;
	temp = getchar();
	while(temp != EOF && temp != '\n'){
		buffer[position]=temp;
		temp = getchar();
		position++;
	}
	/* Null Terminate the String */
	buffer[position]=0;
	position++;
	
    /* Return the string we read in */
	return buffer;
}



int getLetterValue(char letter){
    const int LOWERSTART = 97; // ASCII start value for lowercase letters
    const int UPPERSTART = 65; // ASCII start value for uppercase letters

    /*
        Letters have a value spanning from 1 to 9 and increase alphabetically. After 9, the sequence resets back to 1 and repeats.
        Therefore, the pattern is as follows:
            1. Need to first know the ASCII code of the letter and offset it by the start ASCII position 
            2. Divide that number by 9 to get its remainder and add 1 to the result
    */ 

    
    if (LOWERSTART <= letter && letter <= LOWERSTART+26) {
        return (letter - LOWERSTART) % 9 + 1; 
    }

    if (UPPERSTART <= letter && letter <= UPPERSTART+26){
        return (letter - UPPERSTART) % 9 + 1;
    }

    return 0;
    
}


char* truncate(char* str, int size){
    char * truncStr  = malloc(sizeof(char)*size); // Allocate memory to fit the string size
    
    for (int i=0; i<size; i++){
        truncStr[i] = str[i];
    }
    
    return truncStr;
}

int repeatDigitSum(int num){

    
    int digitSum = 0;
    while (num != 0){
        int rem = num % 10; // Add last digit to digit sum
        digitSum += rem;
        num /= 10; // Dividing by 10 brings the next digit to the ones place
        
        if (num == 0 && digitSum >= 10){ // Once the number reaches 0, digit sum becomes the number and this process continues until the sum is a single digit number
            num = digitSum;
            digitSum = 0;
        }

    }

    return digitSum;
}



int isVowel(char letter){

    int lowercase = (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u');
    int uppercase = (letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U');

    return lowercase || uppercase; 
}

int computePowerNumber(char * name){
    int initSum = 0;

    int pos = 0;
    char letter = name[pos];

    // This number is based on all letters in the name
    while (letter != 0){
        initSum += getLetterValue(letter);
        pos++;
        letter = name[pos];
    }
    return repeatDigitSum(initSum);
}


int computeHeartDesire(char * name){
    int initSum = 0;
    int pos = 0;
    char left = '\0'; // Reference to the previous letter
    char curr = name[pos]; // Reference to the current letter
    char right = name[pos+1]; // Reference to the character after current letter

    // Heart's Desire number is based on all vowels in the name
    while (curr != 0){
        
        // In the case of a y, we need to add only if any character adjacent to it is a consonant. 
        if (curr == 'y' || curr == 'Y'){
            if (! isVowel(left) && left != 0 || ! isVowel(right)) {

                initSum += getLetterValue(curr);
            }  
        } else if(isVowel(curr)){
            initSum += getLetterValue(curr);
            
        }

        // Update letter references
        left = name[pos];  
        pos++;
        curr = name[pos];
        right = name[pos+1];

    }

    return repeatDigitSum(initSum);
}
            


int computePersonalityNumber(char * name){
    int initSum = 0;
    int pos = 0;
    char left = '\0'; // Reference to the previous letter
    char curr = name[pos]; // Reference to the current letter
    char right = name[pos+1]; // Reference to the character after current letter


    // Personality number is based on all consonants in the name
    while (curr != 0){

        // In the case of a y, we need to add only if any character adjacent to is a vowel. 
        if (curr == 'y' || curr == 'Y'){ 
            if (isVowel(left) && left != 0 || isVowel(right)) {
                initSum += getLetterValue(curr);
            }  
        }
        else if(! isVowel(curr)){
            initSum += getLetterValue(curr);

        }

        // Update letter references
        left = name[pos]; 
        pos++;
        curr = name[pos];
        right = name[pos+1];

    }

    return repeatDigitSum(initSum); 
}

