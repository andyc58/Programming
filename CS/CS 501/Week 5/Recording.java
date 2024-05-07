/**
  Recording.java
  @author Andy Cherney
  @version 1.0.0
  5_alc466_lab2

*/


public class Recording {

    private int id;
    private String name;
    private String sound;
    

    public Recording (int id,String name, String content){
        this.id = id;
        this.name = name;
        this.sound = content;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getSound() {
        return sound;
    }

    public String toString() {
        String info = "Recording{id: "+this.getId()+", name: "+this.getName() + ", sound: "+this.getSound()+"}";
        return info;
    }

}