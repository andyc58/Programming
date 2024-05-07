/**
 @mainpage
 @section Overview

 This is Andy's program for HW 5
*/

/**
  @file
  @author Andy Cherney <alc466@drexel.edu>
  @date February 12, 2023
  @section DESCRIPTION
  
  Program to list all txt files and their contents given a directory from the command line
 */


#include <dirent.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/stat.h>


/**
    Driver program to list all txt files and their contents given a directory from the command line

    @param argc - number of command line args
    @param argv - list of command line args
    @return 0 if successful, -1 if error in opening file, 1 if bad directory, 2 if less args than expected, 3 if malloc for file path fails
*/

int main(int argc, char** argv){

    DIR *directory;
    struct dirent *de;
    struct stat st;

    if (argc != 2) {
        printf("Usage: %s <directory_path>\n", argv[0]);
        return 2;
    }

    if (!(directory = opendir(argv[1]))){
        perror("Failed to open directory\n");
        return 1;
    }
    
    int count = 0; // Counter for the number of txt files in directory
    while ((de = readdir(directory))){
        
        int r = stat (de->d_name, &st) ;
        if (! (S_ISREG(st.st_mode))){ // Check for a regular file and skip if it isn't
            continue;
        }


        if (strstr(de->d_name, ".txt")){
            

            FILE *filePtr;
            
            // We need the absolute path to the file to open it. The length of the path consists of the directory name length, a slash, and the file name length
            int fullPathLength = strlen(argv[1]) + strlen(de->d_name) + 1; 
            char* fullPath = malloc((fullPathLength+1)*sizeof(char)); 
            if (fullPath == NULL) {
                perror("Path allocation Error");
                return 3;
            }

            strcat(fullPath, argv[1]); // Stores the directory string
            strcat(fullPath, "/"); // Add slash
            strcat(fullPath, de->d_name); // Add file name
            
            filePtr = fopen(fullPath, "r");
            if (!filePtr) {
                free(fullPath);
                closedir(directory);
                perror("Error while opening file");
                return -1;
            }

            free(fullPath); // No need to keep file path any longer
            
            count++;
            printf("File contents of %s:\n------------------------------------------------------\n", de->d_name);
            
            // Keep printing contents to stdout char by char
            int c;
            while ((c = fgetc(filePtr)) != EOF){
                putc(c, stdout);
            }

            fclose(filePtr);
   
            printf("\n");
        }
    } 

    if (count == 0){ // If there aren't any txt files, print a message
        printf("None found\n");
    }

    closedir(directory); // Close directory when done
    return 0;
    
}



