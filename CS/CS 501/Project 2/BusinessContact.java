/**
  BusinessContact.java
  @author Andy Cherney
  @version 1.0.0

  A contact can be a business contact. Child data class of the parent class Contact.
*/


public class BusinessContact extends Contact {
    
    private String department;
    private String title;

    public BusinessContact() {
        super();
        department = "NA";
        title = "NA";
    }


    public BusinessContact(String name, String department, String title) {
        super(name);
        this.department = department;
        this.title = title;
    }

    public BusinessContact(String name, String email ,String phone ,String department, String title) {
        super(name, email, phone);
        this.department = department;
        this.title = title;
    }



    public void setDepartment(String dept) {
        if (isNull(dept)) {
            this.department= "NA";
            return ; 
        }

        this.department = dept;
    }
    public void setTitle(String t) {
        if (isNull(t)) {
            this.title = "NA";
            return ; 
        }
        this.title = t;
    }
   
    public String getDepartment() {
        return department;
    }
    
    public String getTitle() {
        return title;
    }


    public String toString(){

        String clean = super.toString().replace("Contact: {","Business Contact: {");
        clean = clean.replace("}","");
        String extendedInfo = ", Department: "+this.getDepartment()
                            + ", Title: "+this.getTitle()
        ;

        return clean+extendedInfo+"}";
    }
    
    
}
