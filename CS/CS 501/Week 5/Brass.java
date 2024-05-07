/**
  Brass.java
  @author Andy Cherney
  @version 1.0.0
  5_alc466_lab2

*/


import java.util.ArrayList;

public class Brass implements Instrument{
    

    private String name;
    private String sound;
    private String pitch;
    private ArrayList <Recording> recordings;
    private int numRecordings;

    public Brass(){
        this.name = "";
        this.pitch = "";
        this.sound = "toot";
        this.numRecordings = recordings.size();
        
    }


    public Brass(String name, String pitch){
        this.name = name;
        this.pitch = pitch;
        this.sound = "toot";
        
    }

    public String getName() {
        return name;
    }

    public String getSound() {
        return sound;
    }

    public String getPitch() {
        return pitch;
    }

    public void setPitch(String pitch) {
        this.pitch = pitch;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getNumRecordings() {
        return numRecordings;
    }



    public void playSound(){
        System.out.println("Played Sound: "+this.getSound());
    }


    public void playSound(String note){
        System.out.println("Played Sound: "+note);
    }
    
    public void record(String note){
        System.out.println("Recording Added");

        int id = recordings.size() + 1;

        recordings.add(new Recording(id,this.getName(), note));
        
    }


    public void deleteRecording(int id){
        
        if (id - 1  > this.getNumRecordings()) {
            System.out.println("Recording Not Found");
            return;
        }

        System.out.println("Recording Removed");
        recordings.remove(id - 1);
        
    }
 

    public String toString(){
        String info = "Brass{name: "+this.getName()+", pitch: "+this.getPitch()+", sound: "+this.getSound()+", recordings"+this.getNumRecordings()+"}";
        return info;



    }

}
