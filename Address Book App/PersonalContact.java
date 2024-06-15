/**
  PersonalContact.java
  @author Andy Cherney
  @version 1.0.0

  A contact can be a personal contact. Child data class of the parent class Contact.
*/



public class PersonalContact extends Contact {

    private String relationship;

    public PersonalContact() {
        super();
        this.relationship = "NA";
    }


    public PersonalContact(String name, String relationship) {
        super(name);
        this.relationship = relationship;
    }


    public PersonalContact(String name, String phone, String email, String relationship){
        super(name, phone, email);
        this.relationship = relationship;
    }



    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        if (isNull(relationship)) {
            this.relationship = "NA";
            return ; 
        }

        this.relationship = relationship;
    }


    public String toString() {
        String clean = super.toString().replace("Contact: {","Personal Contact: {");
        clean = clean.replace("}","");
        String extendedInfo = ", Relationship: "+this.getRelationship();       


        return clean+extendedInfo+"}";
    }
}
