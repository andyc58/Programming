
/**
  PaintProgramWithClass.java
  @author Andy Cherney
  @version 1.0.0

*/

public class PaintProgramWithClass {

    public static void main(String[] args) {
        
        Wall wallA = new Wall();
        wallA.setHeight(12);
        wallA.setWidth(10);
        System.out.println("Wall A's area is "+wallA.area());


        Wall wallB = new Wall();
        wallB.setHeight(20);
        wallB.setWidth(4);
        System.out.println("Wall B's area is "+wallB.area());

        Wall wallC = new Wall();
        wallC.setHeight(33);
        wallC.setWidth(35);
        System.out.println("Wall C's area is "+wallC.area());

        double totalArea = wallA.area() + wallB.area() + wallC.area();
        int qt = (int) Math.ceil(totalArea / 100);

        System.out.println("The total amount of paint required is: "+ qt / 4 + " gallons, and " + qt % 4 + " quarts.");


    }
    
}
