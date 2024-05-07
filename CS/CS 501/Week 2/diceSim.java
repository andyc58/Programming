/**
 * diceSim.java
 * 2_alc466_lab2
 *
 * @author Andy Cherney
 * @version 1.0
 */

public class diceSim {


    public static void main(String[] args) {

        /* Generate Rolls */
        int die1Num = (int) (1 + Math.random() * (10 - 1));
        int die2Num = (int) (1 + Math.random() * (10 - 1));
       
        /*  Add */
        int sum = die1Num + die2Num;
        System.out.printf("Addition: %d + %d = %d\n",die1Num, die2Num,sum);

        /* Subtract */
        int difference = die1Num - die2Num;
        System.out.printf("Subtraction %d - %d = %d\n",die1Num, die2Num,difference);

        /* Multiply */
        int product = die1Num * die2Num;
        System.out.printf("Multiplication: %d * %d = %d\n",die1Num, die2Num, product);

        /* Divide */
        int quotient = die1Num / die2Num;
        int remainder = die1Num % die2Num;
        System.out.printf("Division:  %d / %d = %d r %d\n", die1Num, die2Num, quotient, remainder);

        /* Exponentiation */
        int exponentiation = (int) Math.pow(die1Num, die2Num);
        System.out.printf("Exponentiation: %d ^ %d = %d\n",die1Num, die2Num,exponentiation );
        
    }
    
}
