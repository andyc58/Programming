/**
  Student.java
  @author Andy Cherney
  @version 1.0.0
  9_alc466_lab2
*/

public class Student {

    private String firstName, lastName;
    private Student prev, next;
    
    public Student (String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public Student (String firstName, String lastName, Student prevStudent, Student nextStudent) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.prev = prevStudent;
        this.next = nextStudent;
    }


    public void setPrev(Student prev) {
        this.prev = prev;
    }

    public void setNext(Student next) {
        this.next = next;
    }

    public Student getNext() {
        return next;
    }

    public Student getPrev() {
        return prev;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public void writeNeighborNames() {

        if (prev != null){
            System.out.printf("The student before %s is %s\n", this.toString() ,prev);
        } else{
            System.out.printf("%s is the first student\n", this.toString());
        }

        

        if (next != null){
            System.out.printf("The student after %s is %s\n", this.toString() ,next);
        } else{
            System.out.printf("%s is the last student\n", this.toString());
        }

        
        
    }

    
    public String toString() {
        return this.getFirstName() + " " + this.getLastName();
    }


}