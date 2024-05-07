/***********************
 * StudentTester.java
 * Statement coverage test
 * @author Tammy Pirmann
 * @version 20210430
 ****************************/
import java.util.Random;
public class StudentTester{
  public static void main(String[] args){
    Random rng = new Random();
    //create two students
    Student ss = new Student();
    Student tt = new Student("Timmy", "Tomas", "tt123", "he/him", 2021);
    
    //use each setter
    ss.setName("Susan", "Smith");
    ss.setId("ss456");
    ss.setPronouns("she/her");
    ss.setGradYear(2022);
    
    //use toString
    System.out.println(ss);
    System.out.println(tt);
    
    //add grades and attend
    for(int wk = 0; wk < 10; wk++){
      ss.addGrade(wk, rng.nextInt(35)+65);
      ss.addAttendance(wk, true);
    }
    for(int wk = 0; wk < 10; wk++){
      tt.addGrade(wk, 85);
      boolean coin;
      if(rng.nextInt(2)==1){
        coin = true;
      } else {
        coin = false;
      }
      tt.addAttendance(wk, coin);
    }     
    
    //use each getter and calcs
    System.out.println(ss.getName() + " " + ss.getPronouns() + " " + ss.getId() + " Graduates " + ss.getGradYear());
    System.out.println(ss.calcAvg(10));
    System.out.println(ss.printGrades()); 
    System.out.println(ss.calcAttend(10));
    System.out.println(ss.printAttendance());
    System.out.println();
    System.out.println(tt.getName() + " " + tt.getPronouns() + " " + tt.getId() + " Graduates " + tt.getGradYear());
    System.out.println(tt.calcAvg(10));
    System.out.println(tt.printGrades());
    System.out.println(tt.calcAttend(10));
    System.out.println(tt.printAttendance());
  }
}