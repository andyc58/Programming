/**
  AddressBookTester.java
  @author Andy Cherney
  @version 1.0.0

  White Box tests for the address book's behavior
*/


public class AddressBookTester {

    public static void main(String[] args) {
        
       AddressBook addressBook = new AddressBook();
       addressBook.setOwner("Andy");
       System.out.printf("%s's address book\n\n",addressBook.getOwner());


        // Valid contact
        System.out.println("Contact 1 created");
        BusinessContact c1 = new BusinessContact();
        c1.setName("John Doe");
        c1.parsePhoneNumber("215 527 5126");
        c1.parseEmail("john.doe@gmail.com");
        System.out.println(c1);



        // Contact with invalid phone number and email (tests the default values)
        System.out.println("\nContact 2 created");
        PersonalContact c2 = new PersonalContact();
        c2.setName("Joe");
        c2.parsePhoneNumber("2345432345");
        c2.parseEmail("ac32");
        System.out.println(c2);

        // Contact with alls nulls (tests the default values)
        System.out.println("\nContact 3 created");
        BusinessContact c3 = new BusinessContact();
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
        c6.parsePhoneNumber("201 345 1245");
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


        System.out.println("\nBusiness contact with weird looking email");
        BusinessContact c9 = new BusinessContact();
        c9.setName("");
        c9.parsePhoneNumber("");
        c9.parseEmail("wes234@lockheed_martin.com");
        c9.setDepartment("Finance");
        c9.setTitle("Advisor");
        System.out.println(c9);

        System.out.println("\nBusiness contact with weird looking email");
        BusinessContact c10 = new BusinessContact();
        c10.setName("");
        c10.parsePhoneNumber("");
        c10.parseEmail("wes234@lockheed_martin.com");
        c10.setDepartment("");
        c10.setTitle("");
        System.out.println(c10);


        System.out.println("\nAccidentally added\n");
        BusinessContact c11 = new BusinessContact();
        c11.setName("");
        c11.parsePhoneNumber("");
        c11.parseEmail("");
        c11.setDepartment("");
        c11.setTitle("");
        System.out.println(c10);



        System.out.println("\nLast contact\n");
        PersonalContact c12 = new PersonalContact();
        c12.setName("");
        c12.parsePhoneNumber("213 405 2934");
        c12.parseEmail("cgreene132@aol.com");
        c12.setRelationship("bff");
        System.out.println(c12);



        

        System.out.println("\nAdding Contacts: (6 of 12 should be added)\n");
        
        addressBook.addContact(c1);
        addressBook.addContact(c2); // C2 should not be added (invalid phone and email)
        addressBook.addContact(c3); // C3 should not be added (no data)
        addressBook.addContact(c4);
        addressBook.addContact(c5); 
        addressBook.addContact(c6); // Should be added because a key identifier (phone number) exists
        addressBook.addContact(c7);
        addressBook.addContact(c8); // Should not be added (invalid phone and email)
        addressBook.addContact(c9); // Should be added because a key identifier (email) exists even if all other fields are NA
        addressBook.addContact(c10); // Should not be added (duplicate email with c9)
        addressBook.addContact(c11); // Should not be added (no key identifiers)
        addressBook.addContact(c12);
        System.out.println();
        addressBook.printAllContacts();


        System.out.println("This is the 4th contact");
        System.out.println(addressBook.getContact(4)); // Alex Bohler
        System.out.println(addressBook.getContact(10)); // Catches out of range index error and returns null


        System.out.println("\nModifiy Contact 5:");
        BusinessContact c10mod = new BusinessContact();
        c10mod.setName("Wesley Crusher");
        c10mod.parsePhoneNumber("104 687 2392");
        c10mod.parseEmail("wes234@lockheed.com");
        c10mod.setDepartment("");
        c10mod.setTitle("");

        addressBook.modifyContact(5, c10mod);
        addressBook.printAllContacts(); // Should modify the name and email


        System.out.println("Now let's change contact 5 with nulls (Should not change)");
        c10mod.setName("");
        c10mod.parseEmail("");
        addressBook.modifyContact(5, c10mod);
        addressBook.printAllContacts(); // Should be unchanged


        System.out.println("Now let's change contact 5's email and phone again");
        c10mod.parsePhoneNumber("789 345 1023");
        c10mod.parseEmail("wes835@lockheed.com");
        addressBook.modifyContact(5, c10mod);
        addressBook.printAllContacts(); 


        System.out.println("Now undefine contact 5's name, title, and dept (should change back to NA)");
        c10mod.setName("!");
        c10mod.setDepartment("!");
        c10mod.setTitle("!");
        addressBook.modifyContact(5, c10mod);
        addressBook.printAllContacts();



        System.out.println("Same for personal contacts (modify Contact 6)");
        PersonalContact c12mod = new PersonalContact();
        c12mod.setName("Chris Greene");
        c12mod.parsePhoneNumber("893 103 4553");
        c12mod.parseEmail("cgreene577@aol.com");
        addressBook.modifyContact(6, c12mod);
        addressBook.printAllContacts();


        System.out.println("Should not change if the modified name is undefined");
        c12mod.setName("");
        addressBook.modifyContact(6, c12mod);
        addressBook.printAllContacts();


        System.out.println("Undefine relationhip and change phone and email again");
        c12mod.setRelationship("!");
        c12mod.parsePhoneNumber("645 304 1924");
        c12mod.parseEmail("cgreene998@aol.com");
        addressBook.modifyContact(6, c12mod);
        addressBook.printAllContacts();


        System.out.println("\nFind Contact by index:");
        addressBook.findContact(2);
        addressBook.findContact(10); // Catches index error

        
        
        /* 
        This uses fuzzy matching. As long as the either the input contact's name, email, or phone matches the target and is defined, the search is valid 
        */
        System.out.println("\nFind Contact by info:"); 
        System.out.printf("Input Contact: %s\n\n", c12mod);
        addressBook.findContact(c12mod); // Shouldn't find anything

        System.out.println();

        addressBook.findContact(new Contact("Chris Greene")); 
        System.out.println(); // Returns Chris Greene because name matches
        addressBook.findContact(new Contact("Alicia Smith"));  // Returns Alicia Smith because name matches

        System.out.println();
        Contact n2 = new Contact();
        n2.parsePhoneNumber("213 405 2934"); // Returns Chris Greene
        addressBook.findContact(n2); 


        System.out.println("\nExample of a fuzzy search by returning both matches");
        n2.setName("Alicia Smith"); // Returns both Chris Greene (match by phone number) and Alicia Smith (match by name)
        addressBook.findContact(n2); 



        System.out.println();
        Contact n3 = new Contact();
        n3.parseEmail("edc455@merck.com");
        addressBook.findContact(n3); 
        System.out.println();


        System.out.println("\nRemove contacts by index:");
        addressBook.removeContact(5); // Remove contact in the 5th position (5 contacts remaining)
        addressBook.removeContact(10); // Catch index error
        System.out.println();
        addressBook.printAllContacts();



        System.out.println("\nRemove contacts by identifying information:");
        
        /* Deleting contacts must have stricter criteria, so it is important to check if all identifiers match beforehand */
        Contact t2 = new Contact();
        t2.setName("");
        addressBook.removeContact(t2); // Should not remove anything
        t2.setName("John Doe");
        t2.parsePhoneNumber("215 527 5126"); // Still should not remove anything
        addressBook.removeContact(t2);
        t2.parseEmail("john.doe@gmail.com");
        addressBook.removeContact(t2); // This step should remove it (4 contacts left in address book)
        System.out.println();
        addressBook.printAllContacts();


    }
}
