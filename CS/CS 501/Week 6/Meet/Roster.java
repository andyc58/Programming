/************************
 * Roster.java
 * Represents a class roster
 * @author Tammy Pirmann
 * @version 20210430
 *************************/
 public class Roster{  
   private String courseName;
   private String courseId;
   private Student[] students;
   private int count;
   
   public Roster(){
     courseName = "NA";
     courseId = "NA000";
     students = new Student[10];
     count = 0;
   }
   public Roster(String cName, String cId, int max){
     courseName = cName;
     courseId = cId;
     students = new Student[max];
     count = 0;
   }
   public void setCourseName(String cn){
     courseName = cn;
   }
   public void setCourseId(String id){
     courseId = id;
   }
   public String getCourseName(){
     return courseName;
   }
   public String getCourseId(){
     return courseId;
   }
   public Student[] getStudents(){
     return students;
   }
   public Student getOneStudent(int s){
     return students[s];
   }
   public void addStudent(String f, String l, String id, String p, int y){
     if (count < students.length) {
       students[count] = new Student(f, l, id, p, y);
       count++;
     }
   }
   public String toString(){
     String rost = courseName + " " + courseId + " Roster\n";
     for(Student stu : students){
       rost += stu + "\n";
     }
     return rost;
   }
}
 