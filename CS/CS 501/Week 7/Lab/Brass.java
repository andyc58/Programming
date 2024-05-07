/**
  Brass.java
  @author Andy Cherney
  @version 1.0.0
  7_alc466_lab1
*/


public class Brass extends Instrument{
    

    public Brass(){
        this.sound="wah!";
    }
    

    public Brass(String name, int year){
        super(name, year, "wah!");
    }
    
    @Override
    public String toString() {
        String info = "Brass: {Name: "+this.getName()+", Year: "+this.getYearMade()+", Sound: "+this.playSound()+"}";
        return info;
    }


}
