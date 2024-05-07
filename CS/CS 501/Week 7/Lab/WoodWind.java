/**
  WoodWind.java
  @author Andy Cherney
  @version 1.0.0
  7_alc466_lab1
*/


public class WoodWind extends Instrument {
    

    public WoodWind(){
        this.sound="toot!";
    }
    

    public WoodWind(String name, int year){
        super(name, year, "toot");
    }

    public WoodWind(String name, int year, String sound){
        super(name, year, sound);
    }
    
    @Override
    public String toString() {
        String info = "Woodwind: {Name: "+this.getName()+", Year: "+this.getYearMade()+", Sound: "+this.playSound()+"}";
        return info;
    }

}
