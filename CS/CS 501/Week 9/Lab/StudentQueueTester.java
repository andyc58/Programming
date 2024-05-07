/**
  StudentQueueTester.java
  @author Andy Cherney
  @version 1.0.0
  9_alc466_lab2
*/


public class StudentQueueTester {
    public static void main(String[] args) {
        StudentQueue studentQueue = new StudentQueue();


        studentQueue.enqueue(new Student("John", "Smith"));
        studentQueue.enqueue(new Student("Andy", "Cherney"));
        studentQueue.enqueue(new Student("Eric", "Johnson"));
        studentQueue.enqueue(new Student("Alice", "Bunson"));
        studentQueue.enqueue(new Student("Yuki", "Takayama"));


        System.out.println("Before sorting by last name: \n");
        studentQueue.printNeighbors();
        System.out.println();


        System.out.println("After sorting by last name: \n");
        studentQueue.sortQueue();
        studentQueue.printNeighbors();

    
    }
}
