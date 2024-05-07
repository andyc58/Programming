/*************************
 * CourseHelper.java
 * Program to help prof with course tasks
 * @author Tammy Pirmann
 * @version 20210430
 ****************************/
 import java.util.Scanner;
 import java.util.Random;
 public class CourseHelper {
   public static void main(String[] args){
     Scanner kbd = new Scanner(System.in);
     Random rand = new Random();
     //get roster info
     System.out.println("Enter course name: ");
     String name = kbd.nextLine();
     System.out.println("Enter course id: ");
     String id = kbd.nextLine();
     System.out.println("Enter max enrollment: ");
     int max = kbd.nextInt();
     Roster monPM = new Roster(name, id, max);
     
     //load roster with students
     System.out.println("Student information needed is first name, last name, id, pronouns, grad year");
     boolean continu = true;
     String first, last, sid, pro, c;
     int year;
     while(continu){
       System.out.println("First Name: ");
       first = kbd.next();
       System.out.println("Last Name: ");
       last = kbd.next();
       System.out.println("ID: ");
       sid = kbd.next();
       System.out.println("Pronouns: ");
       pro = kbd.next();
       System.out.println("Grad Year: ");
       year = kbd.nextInt();
       monPM.addStudent(first, last, id, pro, year);
       System.out.println("Continue? Y/N");
       c = kbd.next();
       if (c.equalsIgnoreCase("N")){
         continu = false;
       }
     }
     //call on random student
     System.out.print(monPM.getOneStudent(rand.nextInt(max)));
   }
 }