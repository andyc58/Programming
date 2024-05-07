/**
  rngSimulation.java
  @author Andy Cherney
  @version 1.0.0
  6_alc466_lab3
*/

import java.util.Random;

public class rngSimulation {

    private Random rng = new Random();
    private int sampleSize;
    private int [] data;


    public rngSimulation() {
        sampleSize = 100;
        data = new int [sampleSize];
    }

    public rngSimulation(int n) {
        sampleSize = n;
        data = new int [n];
    }
    

    public int getSampleSize() {
        return sampleSize;
    }

    public int[] getData() {
        return data;
    }

    public double calculateMean (){

        double total = 0.0;
        for (int num: data)
            total += num;

        return total / data.length;
    }


    private int calculateMax(){

        int currValue = 0;
        for (int num: data){
            if (num > currValue)
                currValue = num;
        }
        return currValue;
    }


    private int calculateMax(int [][] distribution){

        int currValue = 0;
        for (int [] row: distribution){
            int num = row[1];
            if (num > currValue)
                currValue = num;
        }
        return currValue;
    }


    private int calculateMin(){

        int currValue = this.calculateMax();
        for (int num: data){
            if (num  < currValue)
                currValue = num;
        }
        return currValue;
    }


    public double calculateSE(){
        double mean = this.calculateMean();
        double sqDeviation = 0.0;
        for (int num: data)
            sqDeviation += Math.pow(num - mean, 2);
        
        double variance = sqDeviation / (data.length - 1);
        return Math.sqrt(variance / data.length);

    }


    public void runSimulation(int upperBound){

        for (int i = 0; i < sampleSize; i++){
            int trial = rng.nextInt(upperBound);
            data[i] = trial;
        }
    }   

    public void runSimulation(int lowerBound, int upperBound){

        for (int i = 0; i < sampleSize; i++){
            int trial = rng.nextInt(upperBound) + lowerBound;
            data[i] = trial;
        }
    }


    public void runSimulation(int lowerBound, int upperBound, int n){

        // Runs a simulation where the sum of multiple trials is added to the results

        for (int i = 0; i < sampleSize; i++){
            
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += rng.nextInt(upperBound) + lowerBound;
            }
            data[i] = sum;
        }
    }


    private int [][] generateDistribution(){

        /*  
         *  Generates a table of counts for each value
         *  1st element in each row of the distribution is the value of the random variable
         *  2nd element in each row of the distribution is the count
        */ 

        
        // This determines the proper range of the random variable so that they can be stored by index
        int min = this.calculateMin();
        int max = this.calculateMax();
        int [][] distribution = new int[max - min + 1][2];

        for (int num: this.data){
            distribution[num-min][0] = num; // Store all possible values
            distribution[num-min][1]++; // Count the values
        }
        
        return distribution;
    }



    public void printHistogram (){
        int [][] distribution = this.generateDistribution();
        int highestCount = calculateMax(distribution); // Value will be used to determine spacing between the bars and count

        for (int [] row : distribution) {
            int count = row[1];
            int possibleValue = row[0];
            
            String val = possibleValue + ": ";
            System.out.print(val);
            for (int j = 0; j < count; j++) {
                System.out.print("*");
            }
            for (int k=0; k < highestCount-count-val.length()+10; k++)
                System.out.print(" ");
            System.out.print(count);
            System.out.println();
        
        }


    }

}

