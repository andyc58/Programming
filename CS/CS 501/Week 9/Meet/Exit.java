/**********************
 * Exit.java
 * Concrete Class for Ride Exit Shops
 * @author Tammy Pirmann
 * @version 1.0 20210516
 ***********************/
 public class Exit extends Shop{
   String rideName;
   boolean photo;
   public Exit(){
     super();
     rideName="N/A";
     photo = false;
   }
   public Exit(String n, String l, String d, int dur, String o, String c, String rn, boolean ph){
     super(n, l, d, dur, o, c);
     rideName = rn;
     photo = ph;
   }
   public String getRideName(){
     return rideName;
   }
   public boolean getPhoto(){
     return photo;
   }
   public void setPhoto(boolean p){
     photo = p;
   }
   public String toString(){
     String str = name + " at " + rideName + " exit. " + description + ". Opens at "+ open + " and closes at " + close;
     return str;
   }
   public String toFile(){
     String tf = super.toFile();
     tf += rideName + "|" + photo + "\n";
     return tf;
   }
 }
