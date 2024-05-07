/**
  TestPrep.java
  @author Andy Cherney
  @version 1.0.0

  4_alc466_meet
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class TestPrep {
  public static void main(String args[]){
    Scanner keyboard = new Scanner(System.in);          //User input object (scanner)
    Random randGen = new Random();                  // For RNG
    ArrayList<Cafe> drinks = new ArrayList<Cafe>();         //Creates a list of drinks
  
// Prints these lines with newlines
    System.out.println("It's time to get ready for midterms!");
    System.out.println("You know you have to be alert for study sessions.");
    System.out.println("Caffeinated beverages from your favorite cafe will work.");
    System.out.println("We all like different drinks, so get ready to enter yours.");
    System.out.println("You will need the name, the mg of caffeine and the price.");
    System.out.println("When you are done, enter DONE then 0 then 0.");
    
    String name = "na"; // Initializes a string called na
    int caffeine; // Initialize caffeine
    double price; // Initialize price
    
    while (!name.equalsIgnoreCase("DONE")){ //Run the game as long as the user did not enter DONE 
      System.out.println("Enter a drink name or DONE: ");
      name = keyboard.nextLine(); // Prompt user for the drink
      System.out.println("Enter the caffeine in mg: ");
      caffeine = keyboard.nextInt(); // Prompt user for the caffeine amount
      System.out.println("Enter the price: ");
      price = keyboard.nextDouble(); // Prompt user for the price
      keyboard.nextLine();
      if (!name.equalsIgnoreCase("DONE")) { // if user did not enter done, adds a café object to the array list
        drinks.add(new Cafe(name, caffeine, price));
      }
    }

    int max = drinks.size(); // Sets max equal to the length of the arraylist
    System.out.println(max); // Prints the max
   

    // Prints the next actions for the user with newlines
    System.out.println("The human body can handle about 500 mg of caffeine before bad things start to happen.");
    System.out.println("You will now play chicken with your drink choices. Try to stay alert without going over.");
    System.out.println("You can DRINK or be DONE");
    System.out.println("The drink will be chosen at random from the ones you entered");
   
    int totalCaffeine = 0; // Initialize total caffeine
    String tally = ""; // Initializes the tally string to show everything the user drank
    String choice = "DRINK"; 
    while (!choice.equalsIgnoreCase("DONE")){ // If the choice is not DONE, enter the loop
      
      System.out.println("You can DRINK or be DONE! You have drank"+tally+" and your total caffeine intake is "+totalCaffeine+" mg");
      choice = keyboard.nextLine(); // Prompts the user for choice to drink or be done
      
    
      Cafe bev = drinks.get(randGen.nextInt(max));   // Beverage is chosen at random (max is the highest index)
      
      totalCaffeine += bev.getCaffeine(); // Adds caffeine value of that drink to total caffeine
      tally += "["+bev.toString() +"] ";  // Adds to the tally string
      
      
    }

    if (totalCaffeine > 500){ // If the total caffeine drank is bigger than 500, it is a warning and the user loses 
       System.out.println("You lose! You get the jitters and can't remember anything you studied today!");
    } 
    else if (totalCaffeine > 100){ // If the total caffeine drank is between 100 and 500, the user wins
       System.out.println("You win! You stay alert for the whole study session!");
    } 
    else{ // Otherwise, the user fell asleep
       System.out.println("What's this? It's like you didn't play! You fell asleep on your book.");
    }
    System.out.println("You drank: " + tally); // Prints the tally (drinks list)
     
  }
}
