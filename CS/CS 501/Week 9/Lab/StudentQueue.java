/**
  StudentQueue.java
  @author Andy Cherney
  @version 1.0.0
  9_alc466_lab2
*/


public class StudentQueue {

    private Student head;


    public void enqueue(Student s){
        if (head == null){
            head = s;
        }
        
        else {
            Student currStudent = head;
            while (currStudent.getNext() != null) {
                currStudent = currStudent.getNext();
            }
            currStudent.setNext(s);
            s.setPrev(currStudent);
    
        }

    }


    public void sortQueue() {

        Student sorted = null;
        Student curr = head;

        while (curr != null) {
            Student nextStudent = curr.getNext();
            curr.setNext(null);
            curr.setPrev(null);
            sorted = sortedInsert(sorted, curr);
            curr = nextStudent;

        }

        head = sorted;
    }



    private Student sortedInsert(Student headRefStudent, Student newStudent) {

        Student curr;

        // Case where Queue is empty
        if (headRefStudent == null) {
            headRefStudent = newStudent;
            
        }

        // Case where the student needs to be at the beginning of the Queue
        else if (headRefStudent.getLastName().compareToIgnoreCase(newStudent.getLastName()) >= 0){
            newStudent.setNext(headRefStudent);
            newStudent.getNext().setPrev(newStudent);
            headRefStudent = newStudent;
        }


        else{
            curr = headRefStudent;


            // Move to the reference after which the new student is to be inserted
            while (curr.getNext() != null && curr.getNext().getLastName().compareToIgnoreCase(newStudent.getLastName()) < 0) {
                    curr = curr.getNext();
            }

            // Set the appropriate links
            newStudent.setNext(curr.getNext());

            // Case where the new new node is not inserted at the end of the Queue
            if (curr.getNext() != null) {
                newStudent.getNext().setPrev(curr.getNext());
            }

            curr.setNext(newStudent);
            newStudent.setPrev(curr);

        }
    
        return headRefStudent;
    }



    public void printNeighbors(){

        Student currStudent = head;
        while (currStudent != null) {
            currStudent.writeNeighborNames();
            System.out.println();
            currStudent = currStudent.getNext();
        }
    }
}