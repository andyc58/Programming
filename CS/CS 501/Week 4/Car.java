/**
  Car.java
  @author Andy Cherney
  @version 1.0.0
  4_alc466_lab1

*/



import java.util.ArrayList;

public class Car {

    private String plate;
    private String name;
    private double price;
    private int value;
    private int year;
   

    public Car(){
        this.plate = "";
        this.name = "";
        this.price = 0;
        this.value = 0;
        this.year = 0;
    }

    public Car(double price){
        this.price = price;
    }

    public Car(int value){
        this.value = value;
    }


    public Car(double price, int value){
        this.value = value;
        this.price = price;
    }

  
    
    public Car(String plate, String name, double price, int value ,int year){
        this.plate = plate;
        this.name = name;
        this.price = price;
        this.value = value;
        this.year = year;
    }




    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getValue() {
        return value;
    }

    public String getPlate() {
        return plate;
    }

    public int getYear() {
        return year;
    }


    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setPlate(String plate) {
        this.plate = plate.toUpperCase();
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void addtoGarage(ArrayList<Car> garage) {
        System.out.printf("%s added to garage\n", this);
        garage.add(this);
    }


    public void removefromGarage(ArrayList<Car> garage) {

        System.out.printf("%s removed from garage\n", this);
        garage.remove(this);
    }

    public String toString(){

        String info = String.format("Car(Plate: %s, Name: %s, Year: %d, Price: %f, Value: %d)", 
                                            this.plate, this.name, this.year, this.price, this.value);
        return info;

    }

}

