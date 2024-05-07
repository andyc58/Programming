/**********************
 * Gift.java
 * Concrete Class for Gift Shops
 * @author Tammy Pirmann
 * @version 1.0 20210516
 ***********************/
 public class Gift extends Shop{
   String theme;
   public Gift(){
     super();
     theme = "N/A";
   }
   public Gift(String n, String l, String d, int dur, String o, String c, String t){
     super(n, l, d, dur, o, c);
     theme = t;
   }
   public String getTheme(){
     return theme;
   }
   public void setTheme(String t){
     theme = t;
   } 
   public String toString(){
     String str = name + " : " + theme + " at " + location + ". " + description;
     str += ". Opens at " + open + " and closes at " + close;
     return str;
   }
   public String toFile(){
     String tf = super.toFile();
     tf += theme + "\n";
     return tf;
   }
 }