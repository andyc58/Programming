/**
  Cafe.java
  @author Andy Cherney
  @version 1.0.0

  4_alc466_meet
*/
public class Cafe {

private String name; // Declares private variable name
private int caffeine; // Declares private variable caffeine
private double price; // Declares private variable price

public Cafe(){ // Default Constructor for the cafe object with initial value for name = "Coffee", caffeine = 100, price = 1.50
  name = "Coffee";  
  caffeine = 100;
  price = 1.50;
}
public Cafe(String n, int c, double p){ // This constructor allows the user to instantiate with parameters
  name = n;
  caffeine = c;
  price = p;
}


// These are all getters for the cafe object's attributes
public String getName(){
   return name;
}
public int getCaffeine(){
   return caffeine;
}
public double getPrice(){
    return price;
}


// Returns the string containing the attribute info
public String toString(){
   return (name + ", " + caffeine + "mg of caffeine at $" + price);
}
}