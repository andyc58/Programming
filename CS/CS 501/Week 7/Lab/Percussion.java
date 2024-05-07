/**
  Percussion.java
  @author Andy Cherney
  @version 1.0.0
  7_alc466_lab1
*/


public class Percussion extends Instrument{
    

    

    public Percussion(){
        this.sound="boom!";

    }
    

    public Percussion(String name, int year){
        super(name, year, "boom!");
    }
    
    @Override
    public String toString() {
        String info = "Percussion: {Name: "+this.getName()+", Year: "+this.getYearMade()+", Sound: "+this.playSound()+"}";
        return info;
    }
}
