/* $begin shellmain */
#include "csapp.h"

#define MAXARGS   128
#define MAXVARS   10
#define MAXPROCESSES 100

/* function prototypes */
void eval(char*cmdline);
int parseline(char *buf, char **argv);
int builtin_command(char **argv); 
void print_vars();
void set_var(char **argv);
void check_background_processes();
char * find_path();

char *vars[MAXVARS]; /* Define var array*/
pid_t processes [MAXPROCESSES]; /* Define processes array*/

int main() 
{
	/*  Initialize the processes array with -1's to ensure none are being tracked now */
	for (int i = 0; i < MAXPROCESSES; i++) {
        processes[i] = -1; 
    }

    char cmdline[MAXLINE]; /* command line */


    while (1) {
	/* read */
	printf("> ");                   
	Fgets(cmdline, MAXLINE, stdin); 
	if (feof(stdin))
	    exit(0);

	/* evaluate */
	eval(cmdline);
    } 
}
/* $end shellmain */
  
/* $begin eval */
/* eval - evaluate a command line */
void eval(char *cmdline) 
{
    char *argv[MAXARGS]; /* argv for execve() */
    char buf[MAXLINE];   /* holds modified command line */
    int bg;              /* should the job run in bg or fg? */
    pid_t pid;           /* process id */
	
	
    strcpy(buf, cmdline);
    bg = parseline(buf, argv); 
    if (argv[0] == NULL)  
	return;   /* ignore empty lines */

    if (!builtin_command(argv)) { 
	if ((pid = Fork()) == 0) {   /* child runs user job */
		
	if (execve(argv[0], argv, environ) < 0) {
		
		char *path = find_path(); // Checks if PATH exists
		if (path != NULL){
			char fullPath [MAXLINE];
			sprintf(fullPath ,"%s/%s", path, argv[0]);
			if (execve(fullPath, argv, environ) < 0) {
				printf("%s: Command not found.\n", argv[0]);
				exit(0);

			}

		} else {
			printf("%s: Command not found.\n", argv[0]);
			exit(0);
		}

	    }
	}

	/* parent waits for foreground job to terminate */
	if (!bg) {
	    int status;
	    if (waitpid(pid, &status, 0) < 0)
		unix_error("waitfg: waitpid error");
	}
	else
	    printf("%d %s", pid, cmdline);
		for (int i = 0; i < MAXPROCESSES; i++) {
			if (processes[i] == -1) { // Find an empty slot
				processes[i] = pid; // Store the PID of the background process
				break;
			}
		}
		
    }
    return;
}

/* if first arg is a builtin command, run it and return true */
int builtin_command(char **argv) 
{
    if (!strcmp(argv[0], "quit")) /* quit command */
	exit(0);  
    if (!strcmp(argv[0], "&"))    /* ignore singleton & */
	return 1;
	if (!strcmp(argv[0], "set")){ 
		if (! argv[1]) print_vars();
		else set_var(argv+1);
		return 1;
	} 
	if (!strcmp(argv[0], "proc")){ /* Print the background processes that are completed */
		check_background_processes();
		return 1;
	}

    return 0;  /* not a builtin command */
}
/* $end eval */

/* $begin parseline */
/* parseline - parse the command line and build the argv array */
int parseline(char *buf, char **argv) {
    char *delim;         /* points to first space delimiter */
    int argc;            /* number of args */
    int bg;              /* background job? */

    buf[strlen(buf)-1] = ' ';  /* replace trailing '\n' with space */
    while (*buf && (*buf == ' ')) /* ignore leading spaces */
	buf++;

    /* build the argv list */
    argc = 0;
    while ((delim = strchr(buf, ' '))) {
	argv[argc++] = buf;
	*delim = '\0';
	buf = delim + 1;
	while (*buf && (*buf == ' ')) /* ignore spaces */
	       buf++;
    }
    argv[argc] = NULL;
    
    if (argc == 0)  /* ignore blank line */
	return 1;

    /* should the job run in the background? */
    if ((bg = (*argv[argc-1] == '&')) != 0)
	argv[--argc] = NULL;

    return bg;
}
/* $end parseline */


void print_vars(){
	for (int i = 0; i < MAXVARS && vars[i] != NULL; i++) {
		printf("%s\n", vars[i]);
	}
}

void set_var(char **argv) {

    for (int i = 0; i < MAXVARS; i++) {
        if (vars[i] == NULL) {
            vars[i] = strdup(*argv); // Store new variable
            return;
        }
	}

    printf("Error: Variable limit reached.\n");
}

void check_background_processes() {
    for (int i = 0; i < MAXPROCESSES; i++) {
        if (processes[i] > 0) { // Check only valid PIDs
            int status;
            pid_t result = waitpid(processes[i], &status, WNOHANG);
            if (result == 0) {
                // Process is still running
            } else {
                // Process has ended
                printf("Background process %d done\n", processes[i]);
                processes[i] = -1; // Reset the slot
            }
        }
    }
}



char* find_path(){
	char *path = NULL;
	for (int i = 0; i < MAXVARS && vars[i] != NULL; i++) {
		if (strncmp(vars[i], "PATH=", 5) == 0) {
			path = vars[i] + 5; // Skip over "PATH=" part
			break;
		}
	}
	return path;
}