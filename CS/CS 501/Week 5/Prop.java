/**
  Prop.java
  @author Andy Cherney
  @version 1.0.0
  5_alc466_lab2

*/

public class Prop {
    
    private String name;
    private String description;


    public Prop(){
        this.name="";
        this.description="";

    }

    public Prop(String name){
        this.name=name;
        this.description="";

    }

    public String getName() {
        return name;
    }

    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

}
