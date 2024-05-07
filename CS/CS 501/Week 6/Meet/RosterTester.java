
/**********************
 * RosterTester.java
 * statement coverage test
 * @author Andy Cherney
 * @version 20210430
 **************************/
import java.util.Scanner;

 public class RosterTester{
   public static void main(String[] args){
     //create a roster with no args
     Roster jav = new Roster();
     //create a roster with args
     Roster fds = new Roster("Freshman Design", "CI10X", 4);
     
     Scanner scnr = new Scanner(System.in);
     //use setters
     jav.setCourseName("Intro to Programming with Java");
     jav.setCourseId("CS501");
     


    System.out.println("You will add the same 4 students to both rosters");
     for (int i = 0; i < 4; i++){

        System.out.print("Enter first name: ");
        String first = scnr.nextLine();
        System.out.print("Enter last name: ");
        String last = scnr.nextLine();
        System.out.print("Enter student id: ");
        String id = scnr.nextLine();
        System.out.print("Enter pronouns: ");
        String pronouns = scnr.nextLine();
        System.out.print("Enter anticipated graduation year: ");
        int gradYear = scnr.nextInt();

        jav.addStudent(first, last, id, pronouns, gradYear);
        fds.addStudent(first, last, id, pronouns, gradYear);

        scnr.nextLine();
        System.out.println();
     }




     //use getters
     System.out.println(jav.getCourseName());
    if (jav.getCourseName().equals("Freshman Design")) 
      System.out.println("getCourseName: Passed");
     System.out.println(jav.getCourseId());
    if (jav.getCourseName().equals("CI10X")) 
      System.out.println("getCourseID: Passed");
     System.out.println(jav.getStudents());



     System.out.println(fds.getCourseName());
    if (fds.getCourseName().equals("Freshman Design")) 
      System.out.println("getCourseName: Passed");
     System.out.println(fds.getCourseId());
    if (fds.getCourseName().equals("CI10X")) 
      System.out.println("getCourseID: Passed");
     System.out.println(fds.getStudents());
     
     //use toString
     System.out.println(jav);
     System.out.println(fds);

     

   }
 }