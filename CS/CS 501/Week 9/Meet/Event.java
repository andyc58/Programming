/***************************
 * Event.java
 * Superclass for SevenHills Agenda
 * @author Tammy Pirmann
 * @version 1.0 20210515
 *****************************/
 public class Event implements Comparable<Event> {
 
   String name, location, description;
   int duration;
   //constructors
   public Event(){
     name = "N/A";
     location = "N/A";
     description = "N/A";
     duration = 0;
   } 
   public Event(String n, String l, String d, int dur){
     name = n;
     location = l;
     description = d;
     duration = dur;
   }
   //getters
   public String getName(){
     return name;
   }
   public String getLocation(){
     return location;
   }
   public String getDescription(){
     return description;
   }
   public int getDuration(){
     return duration;
   }
   //setters
   public void setName(String n){
     name = n;
   }
   public void setLocation(String l){
     location = l;
   }
   public void setDescription(String d){
     description = d;
   }
   public void setDuration(int d){
     duration = d;
   }
   //overrides
   public String toString(){
     String str = name + " at " + location + ". " + description + ". ";
     return str;
   }
   public String toFile(){
     return name + "|" + location + "|" + description + "|" + duration + "|";
   }
   public int compareTo(Event other){
     return (this.name.compareTo(other.getName()));
   }
   
 }