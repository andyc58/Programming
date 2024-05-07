/**
  Woodwind.java
  @author Andy Cherney
  @version 1.0.0
  5_alc466_lab2

*/


import java.util.ArrayList;

public class Woodwind implements Instrument {

    private String name;
    private String sound;
    private String pitch;
    private ArrayList <Recording> recordings = new ArrayList<>();


    public Woodwind(){
        this.name = "";
        this.pitch = "";
        this.sound = "toot";

        
    }

    public Woodwind(String name, String pitch){
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
        return recordings.size();
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
 
    public ArrayList<Recording> getRecordings() {
        return recordings;
    }

    

    public void deleteRecording(int loc){
        
        if (Math.abs(loc - this.getNumRecordings()) >= this.getNumRecordings()) {
            System.out.println("Recording Not Found");
            return;
        }

        System.out.println("Recording Removed");
        recordings.remove(loc - 1);
        
    }

    public String toString(){
        String info = "Woodwind{name: "+this.getName()+", pitch: "+this.getPitch()+", sound: "+this.getSound()+", recordings: "+this.getNumRecordings()+"}";
        return info;
    }

}
