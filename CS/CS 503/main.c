#include "csapp.h"

/* Initialize count to 0 */
int cnt = 0;
pthread_mutex_t mutex;

/* Data structure for the thread data */
typedef struct data_t data_t;
struct data_t{
 double val;
 pthread_t id;
 int index;
 };


/* Assume these already exist */
initque();
int enque(data_t * dt);
double proc(char * ar);
void *work (void * arg);


int main (int argc, char ** argv){

    if (argc != 3){
        perror("Usage: <file path 1> <file path 2>\n");
        return 1;
    }

    initque();

    FILE *file1 = fopen(argv[1], "r");
    FILE *file2 = fopen(argv[2], "r");

    /* Create an list (pointer of pthread pointers) that stores the 2 threads (one for each file) */
    int num_threads = argc - 1;
    pthread_t* t = (pthread_t*) malloc(num_threads * sizeof(pthread_t));
    
    
    /* Create the 2 threads for each file path */
    for (int i=1; i<=num_threads; i++){
        pthread_create(&t[i - 1], NULL, work, argv[i]);
    }

     /* Join the 2 threads */
    for (int i=1; i<=num_threads; i++){
        pthread_join(t[i - 1], NULL);
    }

    /* Close the files as the threads complete */
    fclose(file1);
    fclose(file2);
    

    /* Print the final value of count */
    printf("Final count: %d\n", cnt);

    free(t);
  
    /* Destroy the mutex when done */
    pthread_mutex_destroy(&mutex);
    return 0;
}

void *work(void *arg) {
    FILE *file = (FILE *) arg;
    char myBuffer[128];
    struct data_t data;

    /* Read as long as there are 128 bytes in the file */
    while (fread(myBuffer, 1, 128, file) == 128) {
        data.val = proc(myBuffer); 
        data.id = pthread_self();

        /* Safely increment the count */
        pthread_mutex_lock(&mutex);
        data.index = ++cnt;
        pthread_mutex_unlock(&mutex);

        /* Enqueue the data */
        enque(&data); 
    }

    return NULL;
}



