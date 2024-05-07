/**
  AddressBookApp.java
  @author Andy Cherney
  @version 1.0.0

  UI for the address book (driver class)
*/

import java.util.InputMismatchException;
import java.util.Scanner;


public class AddressBookApp {
    // Useful info for the user in case they don't know a particular field when creating a contact
    public static final String NULLPROMPT = "you may simply hit return or enter 'n', 'na', or 'null' to pass"; 

    public static void showUserOptions(){

       String menu = ("MENU\n"
               + "1 - Add contact to address book\n"
               + "2 - Remove contact\n"
               + "3 - Contact lookup\n"
               + "4 - Change contact info\n"
               + "5 - Output all contact information\n"
               + "6 - Quit");
      
       System.out.println("\n"+menu);
    }

    public static void main(String[] args) {

        boolean done = false;
        
        System.out.print("Enter your first name: ");
        Scanner scnr = new Scanner(System.in);
        String ownerName = scnr.nextLine();

    
        AddressBook addressBook = new AddressBook(ownerName);
        System.out.printf("\nWelcome to your address book, %s! Here is a menu of options to choose from: \n",addressBook.getOwner());
        
        showUserOptions();
        while (! done) {
            try {
            System.out.print("\nChoose an option: ");
            
            char choice = scnr.nextLine().charAt(0);
        
            switch (choice) {
                case ('1'):
                    System.out.print("\nWould you like to create a personal or a business contact?\n"
                                +"  p - personal\n"
                                +"  b - business\n");
                    System.out.print("\nChoose an option: ");
                    char type = scnr.nextLine().toLowerCase().charAt(0);
                    while (type != 'b' && type != 'p'){
                        System.out.print("\nInvalid. Pleae try again: \n"                                
                                +"  p - personal\n"
                                +"  b - business\n");
                        System.out.print("\nChoose an option: ");
                        type = scnr.nextLine().toLowerCase().charAt(0);
                    }
                    System.out.println("For all unknown fields, "+NULLPROMPT);
                    addContactForm(addressBook, scnr, type);
                    System.out.println();
                    showUserOptions();
                    break;

                case ('2'):
                    contactLookupAndDeleteForm(addressBook, scnr, "delete");
                    showUserOptions();
                    break;

                case ('3'):
                    contactLookupAndDeleteForm(addressBook, scnr, "find");
                    showUserOptions();
                    break;

                case ('4'):
                    contactModifyForm(addressBook, scnr);
                    showUserOptions();
                    break;

                
                case ('5'):
                    
                    System.out.println("\nHere is a list of your contacts: \n");
                    addressBook.printAllContacts();
                    showUserOptions();
                    break;


                case ('6'): 
                    System.out.println();
                    done = true;
                    break;


                default:
                    System.out.println("Invalid entry. Please try again");
                    break;

            }

        } catch (StringIndexOutOfBoundsException emptyStr){
            System.out.println("You didn't enter anything. Please start again");
            showUserOptions();
        } catch (InputMismatchException mismatch){
            System.out.println("Wrong input. Please start again");
            showUserOptions();
        }

    }

    scnr.close();

}
        
    public static BusinessContact createBusinessContactForm(Scanner scnr) {

    
        BusinessContact b = (BusinessContact) new BusinessContact();

        System.out.print("\nEnter the contact's name: ");
        String name = scnr.nextLine();
        System.out.print("Enter the contact's phone number in XXX XXX XXXX format, where the X's represent the digits: ");
        String phoneNumber = scnr.nextLine();
        System.out.print("Enter the contact's email: ");
        String email = scnr.nextLine();
        System.out.print("Enter the contact's department: ");
        String dept = scnr.nextLine();
        System.out.print("Enter the contact's job title: ");
        String title = scnr.nextLine();
        System.out.println();

        b.setName(name);
        b.parsePhoneNumber(phoneNumber);
        b.parseEmail(email);
        b.setDepartment(dept);
        b.setTitle(title);
        return b;
            
    }



    public static PersonalContact createPersonalContactForm(Scanner scnr){


        PersonalContact p = new PersonalContact();

        System.out.print("\nEnter the contact's name: ");
        String name = scnr.nextLine();
        System.out.print("Enter the contact's phone number in XXX XXX XXXX format: ");
        String phoneNumber = scnr.nextLine();
        System.out.print("Enter the contact's email: ");
        String email = scnr.nextLine();
        System.out.print("Enter the contact's relationship to you? ");
        String relationship = scnr.nextLine();
        System.out.println();

        p.setName(name);
        p.parsePhoneNumber(phoneNumber);
        p.parseEmail(email);
        p.setRelationship(relationship);

        return p;
    }


    public static void contactModifyForm(AddressBook addressBook, Scanner scnr){
        
        System.out.println("\nHere is the list of your address book contacts:\n");
        addressBook.printAllContacts();
        System.out.print("Enter the location number of the contact you wish to modify as it appears above! ");
        int pos = scnr.nextInt();   
        scnr.nextLine();
        
        try {
                
                /*  
                The getClass method returns the runtime object's class, and the getSimpleName method returns the name of that class as a string. 
                These are built-in methods for every class just like the toString() method.

                Sources: 
                https://www.scaler.com/topics/getclass-in-java/ 
                https://www.geeksforgeeks.org/class-getsimplename-method-in-java-with-examples/
                */
                String contactType = addressBook.getContact(pos).getClass().getSimpleName().toLowerCase();

                System.out.println("\nTo keep a field as is, "+NULLPROMPT);
                System.out.println("Note: if you want to undefine a non-identifying field (anything except phone and email), simply enter '!' for those fields. ");
                switch (contactType.charAt(0)){ // 
                    case 'b':
                        BusinessContact b = createBusinessContactForm(scnr);
                        addressBook.modifyContact(pos, b);
                        break;

                    case 'p':
                        PersonalContact p = createPersonalContactForm(scnr);
                        addressBook.modifyContact(pos, p);
                        break;

                }

                System.out.println("New Info:");
                System.out.println(addressBook.getContact(pos));

        } catch (NullPointerException none) {   
                System.out.println("Contact not found");
        }

    }

    public static void addContactForm(AddressBook addressBook, Scanner scnr, char type){
            switch (type){ // 
                case 'b':
                    BusinessContact b = createBusinessContactForm(scnr);
                    addressBook.addContact(b);
                    break;
                case 'p':
                    PersonalContact p = createPersonalContactForm(scnr);
                    addressBook.addContact(p);
                    break;
                default :
                    System.out.println("Invalid type. Please start again");  
            }
    }   
    
    public static void contactLookupAndDeleteForm(AddressBook addressBook, Scanner scnr, String action){
        
        boolean done = false;
        String startPrompt;
        while (! done){


            if (action.equals("delete")){
                startPrompt = "\nThere are 2 ways of deleting a contact in this program:\n";
                System.out.println(startPrompt
                                +"1 - By position \n"
                                +"2 - By identifying contact info\n");
            }
            else{
                startPrompt = "\nThere are 2 ways of finding a contact in this program:\n";
                System.out.println(startPrompt
                                +"1 - By position \n"
                                +"2 - By identifying contact info (Query-based match)\n");
            }

            System.out.print("Choose an option: ");
            char addingChoice = scnr.nextLine().charAt(0);

            switch (addingChoice) {
                case ('1'):
                    
                    if (action.equals("delete")){
                        System.out.println("\nHere is your current list of contacts:\n");
                        addressBook.printAllContacts();
                    }

                    System.out.printf("\nEnter the index of the contact you wish to %s (starts from 1)! ",action);
                    int pos = scnr.nextInt();   
                    scnr.nextLine();

                    if (action.equals("delete")){
                        addressBook.removeContact(pos);
                    }
                    else if(action.equals("find")){
                        addressBook.findContact(pos);
                    }
                    
                    done = true;
                    break;

                case ('2'):
                    
                    if (action.equals("delete")){
                        System.out.println("You will need to enter identifying information (name, email, and phone) exactly to delete a contact this way (case-insensitive).");
                        System.out.println("If a field is undefined or you don't know, "+NULLPROMPT);
                    }

                    else if(action.equals("find")){

                        /* 
                            To explain this better, suppose you enter the name of 1 contact, but a phone number of another contact. 
                            Then, the program will output the information for both contacts. (kind of like how a google search query works) 
                        */

                        System.out.println("This is a fuzzier search that will return all matches that equal each defined field (at least 1 has to match).");
                        System.out.println("For all unknown or blank fields, "+NULLPROMPT);
                    }
                    
                    
                    System.out.print("\nEnter the contact's name: ");
                    String name = scnr.nextLine();
                    System.out.print("Enter the contact's phone number in XXX XXX XXXX format: ");
                    String phoneNumber = scnr.nextLine();
                    System.out.print("Enter the contact's email: ");
                    String email = scnr.nextLine();

                    Contact target = new Contact();
                    target.setName(name);
                    target.parsePhoneNumber(phoneNumber);
                    target.parseEmail(email);
        
    
                    if (action.equals("delete")){
                        addressBook.removeContact(target);
                    }
                    else if(action.equals("find")){
                        addressBook.findContact(target);
                    }

                    done = true;
                    break;
                
                default:
                    System.out.println("\nInvalid Entry. Please try again!");
                    break;
        
            }

        }
    }

}