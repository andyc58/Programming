/**
  rngTester.java
  @author Andy Cherney
  @version 1.0.0
  6_alc466_lab3
*/

public class rngTester {


    public static void showData(int [] data) {
        String ls = "[";
        int i = 0;
        for (int num: data){
            if (i != data.length - 1) {
                ls += num+", ";
            }
            else {
                ls += num;
            }
            i++;
        }
        ls += "]";
        System.out.println(ls);
    }

    public static void main(String[] args) {
        

        rngSimulation coinFlips = new rngSimulation();
        coinFlips.runSimulation(2);
        System.out.printf("Results for %d coin flips: \n",coinFlips.getSampleSize());
        showData(coinFlips.getData());

        rngSimulation diceRolls = new rngSimulation();
        diceRolls.runSimulation(1, 6);

        System.out.printf("\nResults for %d dice rolls: \n",diceRolls.getSampleSize());
        showData(diceRolls.getData());

        rngSimulation diceRollSums = new rngSimulation();
        diceRollSums.runSimulation(1, 6, 2);
        System.out.printf("\nResults for the sums of rolling 2 independent 6-sided dice %d times \n", diceRollSums.getSampleSize());
        showData(diceRollSums.getData());
        System.out.println();


        /* White box tests for mean: 
         * 
         * A test passes based on a Z-test for the mean
         * Z-score is compared to the critical value
         * SE = sample standard deviation / sqrt(sample size)
         * Z-score = (observed mean - expected mean) / SE
         * 1.96 is the critical value for a confidence level of 95% (estimated from the standard normal distribution in R)
         */

        System.out.printf("The average of the %d coin flips is %.2f\n",coinFlips.getSampleSize(),coinFlips.calculateMean());
        if (Math.abs(coinFlips.calculateMean() - 0.5) / coinFlips.calculateSE() <= 1.96) {
            System.out.println("Coin flips mean: Test Passed");
        }

        System.out.printf("\nThe average of the sums from rolling 2 independent 6-sided dice %d times is %.2f\n",diceRolls.getSampleSize(),diceRolls.calculateMean());
        if (Math.abs(diceRolls.calculateMean() - 3.5) / diceRolls.calculateSE() <= 1.96) {
            System.out.println("Coin flips mean: Test Passed");
        }

        System.out.printf("\nThe average of the sums from rolling 2 independent 6-sided dice %d times is %.2f\n",diceRollSums.getSampleSize(),diceRollSums.calculateMean());
        if (Math.abs(diceRollSums.calculateMean() - 7) / diceRollSums.calculateSE() <= 1.96) {
            System.out.println("Coin flips mean: Test Passed");
        }


        

        // Displaying the histograms
        System.out.println("\nDistribution of the 100 dice rolls:\n");      
        diceRolls.printHistogram();


        System.out.println("\nDistribution of 100 sums from 2 independent dice rolls:\n");
        diceRollSums.printHistogram();


    }
    
}
