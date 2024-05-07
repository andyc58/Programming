import java.util.Scanner;

public class PaintProgram {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);


        System.out.print("Enter the length, in inches, of the wall you wish to paint: ");
        int length = scan.nextInt();
        
        System.out.print("\nEnter the height, in inches, of the wall you wish to paint: ");
        int height = scan.nextInt();


        scan.close();

        double area = (length * height) / 144; 
        int quart = (int) Math.ceil(area / 100);

        System.out.println("\nThe anount of paint required is: "+quart+" quarts");
        System.out.println("The anount of paint required is: "+quart / 4+" gallons and "+quart % 4+"quart");

    }
    
}
