/***************************
 * Student.java
 * Represents a student in my class
 * @author Tammy Pirmann
 * @version 20210430
 *****************************/
 public class Student{
   private String first, last, id, pronouns;
   private int gradYear;
   private double[] grades;
   private boolean[] attend;
   
   public Student(){
     first = "Sue";
     last = "Sample";
     id = "ss111";
     pronouns = "she/her";
     gradYear = 2020;
     grades = new double[10];
     attend = new boolean[10];
   }
   public Student(String f, String l, String id, String p, int gy){
     first = f;
     last = l;
     this.id = id;
     pronouns = p;
     gradYear = gy;
     grades = new double[10];
     attend = new boolean[10];
   }
   public void setName(String f, String l){
     first = f;
     last = l;
   }
   public void setId(String id){
     this.id = id;
   }
   public void setPronouns(String p){
     pronouns = p;
   }
   public void setGradYear(int gy){
     gradYear = gy;
   }
   public String getName(){
     return first + " " + last;
   }
   public String getId(){
     return id;
   }
   public String getPronouns(){
     return pronouns;
   }
   public int getGradYear(){
     return gradYear;
   }
   public double[] getGrades(){
     return grades;
   }
   public boolean[] getAttend(){
     return attend;
   }
   public boolean addGrade(int wk, double g){
     boolean result = false;
     if (wk <= 10){
       this.grades[wk] = g;
       result = true;
     }
     return result;
   }
   public boolean addAttendance(int wk, boolean a){
     boolean result = false;
     if (wk <= 10){
       this.attend[wk] = a;
       result = true;
     }
     return result;
   }
   public String calcAttend(int wk){
     String calc = "Attendance Ratio as Attended/Weeks: ";
     int countAtt = 0;
     for(int week = 0; week < wk; week++){
       if (attend[week]) countAtt++;
     }
     calc += countAtt + "/" + wk;
     return calc;
   }
   public double calcAvg(int wk){
     double sum = 0;
     for (double grade : grades){
       sum += grade;
     }
     return sum/wk;
   }
   public String printGrades(){
     String grds = "Grades: ";
     for(double grade : grades) {
       grds += grade + "  ";
     } 
     return grds;
   }
   public String printAttendance(){
     String att = "Attendance: ";
     for(boolean attnd : attend) {
       att += attnd + "  ";
     } 
     return att;
   }

   public String toString(){
     return (first + " " + last + " " + id);
   }
 }