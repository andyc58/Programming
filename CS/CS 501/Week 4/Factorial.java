/************************************
 * Factorial.java
 * Multiple ways to compute factorials
 * @author Samantha Bewley
 * @version 1.0
 ********************************/

import java.util.Scanner;
public class Factorial {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter the factorial you would like to compute: ");
        int factorial = keyboard.nextInt();
        System.out.println(factorial + "! is " + factorialRecursion(factorial) + " using recursion.");

        System.out.print(factorial + "! is ");
        
        int result = 1;
        for (int i = factorial; i >= 1; i--){
            result *= i;
        }
        System.out.println(factorial + "! is " + result+ " using a for loop.");
        
        
        result = 1;
        while (factorial > 1){
            result = result * (factorial);
            factorial = factorial - 1;
        }
        System.out.println(result+ " using a while loop.");




    }

    public static int factorialRecursion(int factorial)
    {
        if (factorial <=1)
            return 1; 
        else 
            return factorialRecursion(factorial-1) * factorial;
    }

    
}