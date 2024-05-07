/**
  Strings.java
  @author Andy Cherney
  @version 1.0.0
  7_alc466_lab1
*/

public class Stringed extends Instrument {
    

    private int numStrings;

    public Stringed(){
        this.sound="strum";
        this.numStrings = 0;
    }
    

    public Stringed(String name, int year){
        super(name, year, "strum!");
        this.numStrings = 0;
    }

    public Stringed(String name, int year, String sound){
        super(name, year, sound);
        this.numStrings = 0;
    }

    public Stringed(String name, int year, String sound ,int numStrings){
        super(name, year, sound);
        this.numStrings = numStrings;
    }

    public void setNumStrings(int numStrings) {
        this.numStrings = numStrings;
    }

    public int getNumStrings() {
        return numStrings;
    }

    
    @Override
    public String toString() {
        String info = "Strings: {Name: "+this.getName()+", Year: "+this.getYearMade()+", Sound: "+this.playSound()+", NumStrings: "+this.getNumStrings()+"}";
        return info;
    }
}
