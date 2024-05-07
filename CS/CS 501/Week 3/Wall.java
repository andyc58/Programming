/**
  Wall.java
  @author Andy Cherney
  @version 1.0.0

*/


public class Wall {
    

    private double width;
    private double height;

    public Wall () {
        this.width = 0;
        this.height = 0;
    }

    // Setters
    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }


    // Getters
    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    
    // Calculate Area
    
    public double area(){
        return this.width * this.height;
    }



}
