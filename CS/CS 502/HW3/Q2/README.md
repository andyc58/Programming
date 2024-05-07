
**The Diving Bell and the Butterfly** by Jean-Domininque Bauby was originally written in French. The first sentence of the book is translated to English below.  

> *through the frayed curtain at my window a warm glow announces the break of day*  

Think about how your program work and try to estimate the number fo questions needed. You should be able to predict the answer without typing out the sentence yourself. You do not need to get the exact answer, but you should not be drastically off.  

Write a short reflection on how both your programs worked. Answer the following:

<br>

### 1. About how many questions do you estimate are needed to type the sentence using linear search?  

I estimate **970** yes/no questions are needed to type out this string using a linear search. To understand how I arrived at this number, we first need to understand the program's mechanics. First there is an alphabet string that consists of all the lowercase characters in the English alphabet plus 3 additional characters at the start (`\space`, `!`, and `.` respectively).

 > ALPHABET =  " !.abcdefghijklmnopqrstuvwxyz"

The way the linear search works is that each character in the alphabet string is iterated over and whenever the user enters 'yes', the cycle starts all over again. The cycle can also start again if the user makes a mistake and skips over the last character `z`. Typing out `!` will stop the loop and is located in the 2nd position of the alphabet string. Keeping this in mind, we first count every unique character in the sentence. The table below represents the distribution of all the characters and their positions in the alphabet string.

| Char     | 't' | 'h' | 'r' | 'o' | 'u' | 'g' | ' ' | 'e' | 'f' | 'a' | 'y' | 'd' | 'c' | 'i' | 'n' | 'm' | 'w' | 'l' | 's' | 'b' | 'k' |
|----------|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|-----|
| Count    | 5   | 4   | 5   | 5   | 3   | 2   | 14  | 5   | 2   | 8   | 3   | 3   | 2   | 2   | 5   | 2   | 4   | 1   | 1   | 1   | 1   |
| Position | 23  | 11  | 21  | 18  | 24  | 10  | 1   | 8   | 9   | 4   | 28  | 7   | 6   | 12  | 17  | 16  | 26  | 15  | 22  | 5   | 14  |

Since every iteration in the alphabet string resets whenever the user enters 'yes' for that character, the position of each character in the string (starting from 1) also indicates the number of yes/no questions for each character. Therefore, to get the total number of questions, we can simply do a weighted total by multiplying each count by the corresponding position and summing the products across the columns. Crunching this out, I calculated a total of **968** questions. However, in order to stop the loop, we need to type in the exclamation point which requires 2 additional yes/no questions, hence bringing the total to **970**.


### 2. About how many questions do you estimate are to type the sentence using binary search?  
   
I would extrapolate about **474** questions. The way I arrived at this result has to do with the time complexity of a binary search. For any sorted dataset with size N, a binary search has a worst case time complexity of log2(N). There are 29 characters to choose from in the alphabet string, so this would mean that log2(29) is close to 5. The real number is slightly lower (about 4.86), so it is rounded to the next highest integer. Therefore, we can expect any character to have 5 questions before it is picked. We still need to include the question when it is picked, which means we can expect 6 total questions per character.

Afterwards, I counted 78 characters in the sentence string plus one more to account for the exclamation point that stops the loop. Multiplying 79 characters by the 6 questions per character yields a total of **474** questions.
   

### 3. If you were Jean-Domininque, which program would you rather use?  

I would choose the binary search typing algorithm. It is a lot faster to type out since the domain of letters gets restricted every time the user enters yes or no. There is no need to iterate through more characters just to get to a certain character as a result. Once the domain gets to a single character, then the user will enter `yes` and the program will reset again. As a result, the number of questions required to type out a string is cut down by slightly more than half than with the linear search.

### 4. What was the easiest part of implementing this assignment?  
   
The easiest part of implementing this assignment was understanding how the linear search typing works. It simply iterates through each character and wraps around if the user goes over or until the user enters yes. When the user enters `!`, the sentence is finished. I wanted to also take into account when the user made a mistake and skipped over the last character `z`, so I decided to make the loop start over again and only end when the user enters the exclamation point. 

### 5. What was the most challenging part of implementing this assigment?  

The most challenging part of implementing this assignment was thinking about how to handle the cases where the range is a single character due to the fact that sometimes, there may be a redundant question to ask. However, I realized that the algorithm already has this optimization simply by keeping track of the previous endpoint. As a result, whenever the difference between `end` and `start` is an odd value, there is no need to ask a question again. Similarly, when the difference is even, it is unknown which one the user wants, so asking the question again is necessary.




