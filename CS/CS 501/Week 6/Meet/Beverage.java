import java.util.Scanner;

public class Beverage {
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        String[] beverage = new String[5];
        double[] price = new double[5];
        for(int i = 0; i < beverage.length; i++){
            System.out.println("Enter beverage name (5 total):");
            beverage[i] = keyboard.next();
            System.out.println("Enter price: ");
            price[i] = keyboard.nextDouble();
        }
        
        for(int i = 0; i < beverage.length; i++){
            System.out.print(beverage[i] + "\t");
            System.out.print(price[i] + "\n");
        }

    }
    
}