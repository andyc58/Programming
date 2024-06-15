/**
  AddressBook.java
  @author Andy Cherney
  @version 1.0.0

  Defines the class for the address book, a collection of contact objects. 
*/

import java.util.ArrayList;

public class AddressBook {
    
    private String ownerName;
    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    public AddressBook () {
        this.ownerName = "";
    }


    public AddressBook (String name) {
        this.ownerName = name;
    }

    public String getOwner() {
        return ownerName;
    }

    public void setOwner(String ownerName) {
        this.ownerName = ownerName;
    }


    public Contact getContact(int pos){

        // Looks up a contact by position (starting from 1) (utility method for modifying a contact)

        Contact input = null;
        try {
            input = contacts.get(pos - 1);
        } catch (IndexOutOfBoundsException notInRange){
            System.out.printf("\nIndex not in range of address book. Value should be between 1 and %d inclusive. Please start again. \n", contacts.size());
            
        }
        return input;
    }



    public void addContact(Contact input){

        String newContactEmail = input.getEmail();
        String newContactPhoneNumber = input.getPhoneNumber();

        if (! newContactPhoneNumber.equalsIgnoreCase("na") || ! newContactEmail.equalsIgnoreCase("na")) {
            for (Contact contact: contacts) {

                boolean samePhone = contact.getPhoneNumber().equals(newContactPhoneNumber) && ! contact.getPhoneNumber().equals("NA");
                boolean sameEmail = contact.getEmail().equals(newContactEmail) && ! contact.getEmail().equals("NA");

                if (samePhone || sameEmail) {
                    System.out.println("Contact not added. A contact with similar credentials already exists. Please start again");
                    return;
                }
            }
            System.out.println("Contact added");
            contacts.add(input);
            return;
         
        }
        System.out.println("Contact not added. Contact must have at least a phone number or an email address defined. Please start again");
         
    }

    public void removeContact(int pos){

        // Deletes a contact by its index in the address book (starts from 1 onward)
        
        try {
            contacts.remove(pos - 1);
            System.out.println("Contact deleted");

        } catch (IndexOutOfBoundsException i) {
            System.out.printf("\nIndex not in range of address book. Value should be between 1 and %d inclusive. Please start again\n", contacts.size());
        }
        
    }


    public void removeContact(Contact input){


        /* Deletes a contact by checking if key identifying information matches (name, phone, and email)  */
    
        String targetName = input.getName();
        String targetPhone = input.getPhoneNumber();
        String targetEmail = input.getEmail();


        /* Need a loop because only identifying fields are checked */
        for (Contact contact: contacts){

            if (contact.getName().equalsIgnoreCase(targetName) && contact.getPhoneNumber().equals(targetPhone) && contact.getEmail().equals(targetEmail)){
                contacts.remove(contact);
                System.out.println("Contact deleted");
                return ;
            }
        }
        System.out.println("Contact not removed. Please view your contacts and try again");
    }




    public void findContact(int pos){
        
        try {
            System.out.println("\nFound contact: ");
            System.out.println(contacts.get(pos - 1));
        } catch (IndexOutOfBoundsException i) {
            System.out.printf("\nIndex not in range of address book. Enter a value between 1 and %d inclusive. Please start again\n", contacts.size());
        }
        
    }


    public void findContact(Contact input){

        /* Does a fuzzy search by returning all contacts with either a matching and defined name, phone number or email address  */
        boolean found = false;
        String targetName = input.getName();
        String targetPhone = input.getPhoneNumber();
        String targetEmail = input.getEmail();

    
        int i = 0;

        System.out.println("\nFound: ");
        for (Contact contact: contacts){

            if (contact.getName().equalsIgnoreCase(targetName)  && ! targetName.equals("NA")
                        || contact.getPhoneNumber().equals(targetPhone) && ! targetPhone.equals("NA") 
                        || contact.getEmail().equals(targetEmail) && ! targetEmail.equals("NA") ){
                
                i++;
                System.out.println(i + ". " + contact);
                found = true;
            }
        }
        if (! found){
            System.out.println("None");
        }
        

    }

    public void modifyContact(int position, PersonalContact input){
        
        // Modifies a personal contact

        boolean modified = false;
        String targetName = input.getName();
        String targetPhone = input.getPhoneNumber();
        String targetEmail = input.getEmail();
        String targetRelationship = input.getRelationship();
        String erased = "!";

        try {
            
            // Need to downcast the parent instance of the PersonalContact in the list first before modifying
            // Source: https://www.baeldung.com/java-type-casting
            PersonalContact toModify = (PersonalContact) contacts.get(position-1); 
            
            // As long as the field is not NA, do the modification. ! will convert the field back to NA for non-identifying fields

            if (! targetName.equals("NA")){
                if (targetName.equalsIgnoreCase(erased)){
                    targetName = "NA";
                }
                toModify.setName(targetName);
                modified = true;
            }
         
            if (! targetPhone.equals("NA")){
                toModify.parsePhoneNumber(targetPhone);
                modified = true;
            }

            if (! targetEmail.equals("NA")){
                toModify.parseEmail(targetEmail);
                modified=true;
            }


            if (! targetRelationship.equals("NA")){
                if (targetRelationship.equalsIgnoreCase(erased)){
                    targetRelationship = "NA";
                }
                toModify.setRelationship(targetRelationship);
                modified = true;
            }


            if (modified){
                System.out.println("\nModified successfully\n");
                return ;
            }
            
            
            System.out.println("\nUnchanged\n");
            

            } catch (IndexOutOfBoundsException i) {
            System.out.printf("\nIndex not in range of address book. Value should be between 1 and %d inclusive. Please start again\n", contacts.size());

            }

    }


    public void modifyContact(int position, BusinessContact input){
        boolean modified = false;
        String targetName = input.getName();
        String targetPhone = input.getPhoneNumber();
        String targetEmail = input.getEmail();
        String targetDepartment = input.getDepartment();
        String targetTitle = input.getTitle();
        String erased = "!";

        try {

            // Need to downcast the parent instance of BusinessContact in the list first before modifying
            // Source: https://www.baeldung.com/java-type-casting
            
            BusinessContact toModify = (BusinessContact) contacts.get(position - 1); // Need to cast the parent object first before modifying
        

            if (! targetName.equals("NA")){
                if (targetName.equalsIgnoreCase(erased)){
                    targetName = "NA";
                }
                toModify.setName(targetName);
                modified = true;
            }
         
            if (! targetPhone.equals("NA")){
                toModify.parsePhoneNumber(targetPhone);
                modified = true;
            }

            if (! targetEmail.equals("NA")){
                toModify.parseEmail(targetEmail);
                modified=true;
            }

            if (! targetDepartment.equals("NA")){
                if (targetDepartment.equalsIgnoreCase(erased)){
                    targetDepartment = "NA";
                }
                toModify.setDepartment(targetDepartment);
                modified =true;
            }

            if (! targetTitle.equals("NA")){
                if (targetTitle.equalsIgnoreCase(erased)){
                    targetTitle = "NA";
                }
                toModify.setTitle(targetTitle);
                modified = true;
            }


            if (modified){
                System.out.println("\nModified successfully\n");
                return;
            }
            
            System.out.println("\nUnchanged\n");
            
  
        } catch (IndexOutOfBoundsException notInRange) {
            System.out.printf("\nIndex not in range of address book. Value should be between 1 and %d inclusive. Please start again\n", contacts.size());
        } 
        
    }


    public void printAllContacts() {

        if (contacts.size() == 0){
            System.out.println("None");
            return ;
        }

        int i = 0;
        for (Contact c: contacts) {
            System.out.println((i+1)+". "+c);
            i++;
        }
        
        System.out.println();
    }
}
