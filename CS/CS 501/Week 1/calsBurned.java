
/**
 * calsBurned.java
 * 1_alc466_lab3
 *
 * @author Andy Cherney
 * @version 1.0
 */


import java.util.Scanner;

public class calsBurned {
    
    public static void main(String[] args) {
        
        /* Define Modifiers */
        double WEIGHTMOD = 0.035;
        double HEIGHTMOD = 0.029;


        /* Define Input Variables */
        int totalCals;
        double weight;
        double height;
        double walkVelocity;


        Scanner scan = new Scanner(System.in);

        System.out.print("\nHow many calories do you wish to burn? "); 
        totalCals = scan.nextInt();

        System.out.print("\nEnter weight in lbs: ");
        weight = scan.nextDouble() / 2.2; // converts to lbs to kg

        System.out.print("\nEnter height in ft: "); // (eg. 5.5)
        height = scan.nextDouble() / 3.3 ; // converts ft to meters


        System.out.print("\nHow fast do you normally walk in mph? ");
        walkVelocity = scan.nextDouble() / 2.237; // converts mph to m / s
        
        scan.close();
        


        /* Calculates Calories Burned per Minute */
        double calsBurnedRate = WEIGHTMOD * weight + HEIGHTMOD * (Math.pow(walkVelocity, 2) / height);

        int totalTimeNeeded = (int) Math.ceil(totalCals / calsBurnedRate);

        String result = "\nYou need to walk a total of "+ totalTimeNeeded + " minutes to burn " + 
                        totalCals + " calories";
        
        System.out.println(result);

    }

}
