/**
  diceRolls.java
  @author Andy Cherney
  @version 1.0.0
  8_alc466_lab3
*/

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class diceRolls {


    public static void main(String[] args) {

        // Simulate the rolls and print the first indexes of each roll
        Random rng = new Random();
        int [] rolls = simulate(rng, 1000, 1, 6);
        System.out.println("First roll indexes in the simulation: ");
        int target = 1;
        for (int i = 0; i < rolls.length; i++) {
            if (rolls[i] == target) {
                System.out.printf("%d @ index %d\n", target, i);
                target++;
            }
        }

        // Sort the values and count
        insertionSort(rolls); 
        int [][] counts = count(rolls);
        System.out.println("\nCounts:");
        for (int [] cnt: counts){
            System.out.println(cnt[0]+" rolled "+cnt[1]+" times");
        }
       System.out.println();

       // Shuffle the list and ask the user to get a roll at an index, handling any exception that can come upon entry
        shuffleData(rng, rolls);
        Scanner scnr = new Scanner(System.in);
        boolean done = false;
        while (! done) {
            try {
                System.out.print("Enter a value between 0 - 999: ");
                int index = scnr.nextInt();
                System.out.printf("The roll at index %d is a %d.\n", index, rolls[index]);
                done = true;
            } catch (IndexOutOfBoundsException e){
                System.out.println("Index not in range");
                scnr.nextLine();
            }
            catch (InputMismatchException p){
                System.out.println("Invalid entry");
                scnr.nextLine();
            }

        }
        scnr.close();
    }   

    public static int [] simulate (Random rng,int n, int min, int max){
        int [] data = new int [n];
        for (int i = 0; i < n; i++){
            data[i] = rng.nextInt(6)+1;
        }
        return data;
    }

    public static int [][] count (int [] sortedData) {
        int lowerBound = sortedData[0];
        int upperBound = sortedData[sortedData.length-1];
        int [][] counts = new int [upperBound][2];

        for (int d : sortedData) {
            counts[d-lowerBound][0] = d;
            counts[d-lowerBound][1]++;
        }
        return counts;
    }

    public static void insertionSort(int [] data){
        for (int i = 1; i <data.length; i++){
            int val = data[i];
            int position = i;
            while (position > 0 && val < data[position-1]){
                data[position] = data[position-1];
                position--;
            }
            data[position] = val;
        }
    }

    public static void shuffleData(Random rng, int [] data){
        for (int i = 0; i < data.length; i++){
            int randIndex = rng.nextInt(data.length);
            int temp = data[randIndex];
            data[randIndex] = data[i];
            data[i] = temp;   
        }
    }
}
