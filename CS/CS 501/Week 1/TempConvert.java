
/**
 * TempConvert.java
 * temperature conversion program
 *
 * @author Tammy Pirmann
 * @version 1.0
 */


public class TempConvert {

  public static void main (String args[]){
    double fahr = 100; //change this value and run again for new conversion
    double cels;

    cels = ( 5.0 * (fahr - 32.0) ) / 9.0;

    System.out.println(fahr + "F is " + cels + " in C."); //pay attention to spaces inside the quotes
  }
}


