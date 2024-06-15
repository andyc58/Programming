/**
  Contact.java
  @author Andy Cherney
  @version 1.0.0

  Establishes the parent data class (all contacts)
*/



import java.util.regex.Pattern;

public class Contact {

    protected String name;
    protected String phoneNumber;
    protected String email;


    public Contact(){
        name = "NA";
        phoneNumber = "NA";
        email = "NA";
    }

    public Contact(String name){
        this.name = name;
        phoneNumber = "NA";
        email = "NA";
    }
   
    public Contact(String name, String phone, String email){
        this.name = name;
        this.phoneNumber = phone;
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String n) {

        if (isNull(n)) {
            this.name = "NA";
            return ; 
        }


        this.name = n;
    }

    public void parsePhoneNumber(String phone) {


        if (isNull(phone)) {
            this.phoneNumber = "NA";
            return ;
        }   

        
        if (validate("\\d{3} \\d{3} \\d{4}", phone) || validate("\\(\\d{3}\\)-\\d{3}-\\d{4}", phone)){

            // Replace all characters in the set via regex matching https://www.javatpoint.com/java-string-replaceall. 
            // This will help with cleaning the entered phone number string before parsing into (XXX)-XXX-XXXX format

            phone = phone.replaceAll("\\D","");  // Removes all non-digit characters
            String parsed = "("+phone.substring(0,3)
                +")-"+phone.substring(3,6)
                +"-"+phone.substring(6,10);
            this.phoneNumber = parsed;
            return ; 
        }
        System.out.println("Invalid phone number format. NA set.");

        }


    public void parseEmail(String e) {

        if (isNull(e)) {
            this.email = "NA";
            return ;
        }

        if (validate("\\w+.*\\w+@\\w+.*\\w+\\.\\w{2,}", e)){
            this.email= e;
            return;
        }
        

        System.out.println("Email format not recognized. NA set.");


    }

    protected static boolean validate(String pattern, String str) {
        
        // Validate a string based on a regex match (implementation taken from project 1)

        Pattern p = Pattern.compile(pattern);
        boolean valid = p.matcher(str).find();
        return valid;

    }

    protected static boolean isNull(String s){
        // Validates whether a string should be considered undefined for the fields. NA strings are used instead of nulls for all values to help with comparisons.

        return s.isEmpty() || s.equalsIgnoreCase("na") || 
                s.equalsIgnoreCase("n") || s.equalsIgnoreCase("null") || s.equalsIgnoreCase("none");
    }


    public String toString(){
        String fullInfo = "Name: "+this.getName()
                                +", Phone: "+this.getPhoneNumber()
                                +", Email: "+this.getEmail()
                                ;
        return "Contact: {"+fullInfo+"}";
    }


}

    
