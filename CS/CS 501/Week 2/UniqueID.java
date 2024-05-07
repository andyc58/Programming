/**
 * UniqueId.java
 * 2_alc466_meet
 *
 * @author Andy Cherney
 * @version 1.0
 */

import java.util.Random;
import java.util.Scanner;

public class UniqueID {
    

    public static void main(String[] args) {
    
        String firstName;
        String lastName;

        Scanner scan = new Scanner(System.in);

        /* Name input */
        System.out.print("Enter your first name: ");
        firstName = scan.nextLine();
        System.out.print("Enter your last name: ");
        lastName = scan.nextLine();
        
        scan.close();

        /* 4 Digit Number (0 - 9999) */
        Random rand = new Random();
        int number = rand.nextInt(10000);
        
        /* Find character from first and last name */
        int firstNameIndex = rand.nextInt(firstName.length() - 1);
        int lastNameIndex = rand.nextInt(lastName.length() - 1);
        char f = firstName.toLowerCase().charAt(firstNameIndex);
        char l = lastName.toLowerCase().charAt(lastNameIndex);


        /* Print id */
        System.out.printf("Your new unique id is %c%c%d\n", f, l, number);


    
    }
}
