/**
  Instrument.java
  @author Andy Cherney
  @version 1.0.0
  7_alc466_lab1
*/



public class Instrument {

    protected String name;
    protected int yearMade;
    protected String sound;


    public Instrument() {
        this.name = "";
        this.yearMade = 0;

    }
    

    public Instrument(String name, int yearMade, String sound) {
        this.name = name;
        this.yearMade = yearMade;
        this.sound = sound;
    }



    public void setYearMade(int yearMade) {
        this.yearMade = yearMade;
    }

    public void setName(String name) {
        this.name = name;
        
    }

    public String getName(){
        return name;
    }


    public String playSound() {
        return sound;
    }

    
    public int getYearMade() {
        return yearMade;
    }
    
    public String toString() {
        String info = "Instrument: {Name: "+this.getName()+", Year: "+this.getYearMade()+", Sound: "+this.playSound()+"}";
        return info;
    }



}