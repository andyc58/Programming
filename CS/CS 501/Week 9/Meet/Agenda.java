/*************************
 * Agenda.java
 * represents a family daily agenda for the part
 * implemented as a linked list of events
 * @author Tammy Pirmann
 * @version 1.0 20210523
 ***********************/
 public class Agenda {
   public static void main(String[] args){
     EventLList agenda = new EventLList();
     agenda.add(new Gift("Main Street General Store", "Main and Broad Streets", "Park souveneir shop with penny candy and post cards", 30, "08:00 AM", "08:00 PM", "Old fashioned general store"));
     agenda.add(new Event("Mean Green Machine", "Broad and Green Streets", "Roller Coaster Ride", 60));
     agenda.add(new Exit("Green Gifts", "Main and Green Streets", "Exit gift shop", 15, "10:00 AM", "08:00 PM", "Mean Green Machine", true));

     System.out.println(agenda);
   }
 }