/**
  ContactTester.java
  @author Andy Cherney
  @version 1.0.0

  White Box tests for the contact class and its subclasses
*/


public class ContactTester {

    public static void main(String[] args) {
        

        // Valid contact
        System.out.println("Contact 1 created");
        Contact c1 = new Contact("John Doe");
        c1.setName("John Doe");
        c1.parsePhoneNumber("215 527 5126");
        c1.parseEmail("john.doe@gmail.com");
        System.out.println(c1);



        // Contact with invalid phone number and email (tests the default values)
        System.out.println("\nContact 2 created");
        Contact c2 = new Contact();
        c2.setName("Joe");
        c2.parsePhoneNumber("2345432345");
        c2.parseEmail("ac32");
        System.out.println(c2);

        // Contact with alls nulls (tests the default values)
        System.out.println("\nContact 3 created");
        Contact c3 = new Contact();
        c3.setName("");
        c3.parsePhoneNumber("");
        c3.parseEmail("");
        System.out.println(c3);



        // Personal contact
        System.out.println("\nPersonal contact created");
        PersonalContact c4 = new PersonalContact();
        c4.setName("Alicia Smith");
        c4.parsePhoneNumber("267 954 1023");
        c4.parseEmail("alicia.smith@gmail.com");
        c4.setRelationship("girlfriend");
        System.out.println(c4);


        // Personal contact with all nulls and invalid email and phone
        System.out.println("\nPersonal contact with invalid phone and email created");
        PersonalContact c5 = new PersonalContact();
        c5.setName("Emily");
        c5.parsePhoneNumber("13");
        c5.parseEmail("23");
        c5.setRelationship("friend");
        System.out.println(c5);


        
        System.out.println("\nPersonal contact with nulls created");
        PersonalContact c6 = new PersonalContact();
        c6.setName("");
        c6.parsePhoneNumber("");
        c6.parseEmail("");
        c6.setRelationship("");
        System.out.println(c6);


        System.out.println("\nBusiness contact created");
        BusinessContact c7 = new BusinessContact();
        c7.setName("Alex Bohler");
        c7.parsePhoneNumber("102 234 5631");
        c7.parseEmail("edc455@merck.com");
        c7.setDepartment("R&D");
        c7.setTitle("Quality analyst");
        System.out.println(c7);


        System.out.println("\nBusiness contact with invalid phone and email created");
        BusinessContact c8 = new BusinessContact();
        c8.setName("Alex Smith");
        c8.parsePhoneNumber("23");
        c8.parseEmail("12");
        c8.setDepartment("Finance");
        c8.setTitle("CFO");
        System.out.println(c8);


        System.out.println("\nBusiness contact with all nulls");
        BusinessContact c9 = new BusinessContact();
        c9.setName("");
        c9.parsePhoneNumber("");
        c9.parseEmail("");
        c9.setDepartment("");
        c9.setTitle("");
        System.out.println(c9);

 
 
     }

}
    
