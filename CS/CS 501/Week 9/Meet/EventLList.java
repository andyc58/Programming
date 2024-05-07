/*****************************
 * EventLList.java
 * Represents a linked list of events
 * @author Tammy Pirmann
 * @version 1.0 20210523
 ******************************/
 public class EventLList {
   private EventNode llist;
   
   public EventLList(){
     llist = null;
   }
   
   public void add(Event e){
     EventNode node = new EventNode(e);
     EventNode current;
     if (llist == null){
       llist = node;
     } else {
       current = llist;
       while (current.next != null) {
         current = current.next;
       }
       current.next = node;
     }
   }
   
   public String toString(){
     String out = "";
     EventNode current = llist;
     while (current != null) {
       out += current.event + "\n";
       current = current.next;
     }
     return out;
   }
   
   //Inner class representing a node in the linked list
   private class EventNode {
     public Event event;
     public EventNode next;
     
     public EventNode(Event e){
       event = e;
       next = null;
     }
   }
 }