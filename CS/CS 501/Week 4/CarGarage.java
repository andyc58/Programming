/**
  CarGarage.java
  @author Andy Cherney
  @version 1.0.0
  4_alc466_lab1

*/


import java.util.ArrayList;
import java.util.Scanner;

public class CarGarage {
    
    public static void main(String[] args) {
        
        ArrayList<Car> garage = new ArrayList<Car>();
        Scanner scan = new Scanner(System.in);


        // Demonstrates how a car can have a price, a value, or both
        System.out.print("Enter the price of the first car: ");
        double price = scan.nextDouble();

        System.out.print("Enter the value of the first car: ");
        int value = scan.nextInt();
        Car car1 = new Car(price, value);
        scan.nextLine();
        
        System.out.print("Do you wish to add this car to the garage? Y/N? ");
        String prompt = scan.nextLine();
        if (prompt.toLowerCase().equals("y")){
            car1.addtoGarage(garage);
            
        }


        System.out.print("\nEnter the intial price of the second car: ");
        price = scan.nextDouble();
        
        Car car2 = new Car(price);
        scan.nextLine();
        
        System.out.print("Do you wish to add this car to the garage? Y/N? ");
        prompt = scan.nextLine();
        if (prompt.toLowerCase().equals("y")){
            car2.addtoGarage(garage);
        }



        System.out.print("\nEnter the intial value of the third car: ");
        value = scan.nextInt();
        Car car3 = new Car(value);
        scan.nextLine();

        System.out.print("Do you wish to add this car to the garage? Y/N? ");
        prompt = scan.nextLine();
        if (prompt.toLowerCase().equals("y")){
            System.out.println();
            car3.addtoGarage(garage);
        }



        System.out.println("\nLet's add some more cars. We added one with defaults for you to modify");
        Car car4 = new Car();

        System.out.print("Enter the plate number of the 4th car: ");
        String plate = scan.nextLine();

        System.out.print("Enter the name: ");
        String name= scan.nextLine();

        System.out.print("Enter the year: ");
        int year= scan.nextInt();

        System.out.print("Enter the price: ");
        price = scan.nextDouble();

        System.out.print("Enter the value: ");
        value = scan.nextInt();


        // Demonstrates the use of getters and setters
        car4.setName(name);
        System.out.printf("\nCar 4's name is %s\n",car4.getName());
        car4.setPlate(plate);
        System.out.printf("Car 4's license plate is %s\n",car4.getPlate());
        car4.setPrice(price);
        System.out.printf("Car 4's price is %f\n",car4.getPrice());
        car4.setYear(year);
        System.out.printf("Car 4's year is %d\n",car4.getYear());
        car4.setValue(value);
        System.out.printf("Car 4's value is %d\n",car4.getValue());
        
        car4.addtoGarage(garage);
        
        

        System.out.printf("\nCars have been added. The number of cars in the garage is %d.\n\n",garage.size());

        // Removing cars from garage
        
        
        System.out.println("10 minutes later a customer came in to buy car 4.");
        car4.removefromGarage(garage);
        System.out.printf("\nThe number of cars in the garage is now %d\n\n",garage.size());


        scan.close();
        
        



        
    }
}
