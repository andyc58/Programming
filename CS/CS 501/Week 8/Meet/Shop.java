/***************************
 * Shop.java
 * Shops and restaurants use this class for SevenHills Agenda
 * @author Tammy Pirmann
 * @version 1.0 20210515
 *****************************/
public class Shop extends Event{
  String open;
  String close;
  
  public Shop(){
    super();
    open = "0:00 AM";
    close = "0:00 PM";
  }
  public Shop(String n, String l, String d, int dur, String o, String c){
    super(n, l, d, dur);
    open = o;
    close = c;
  }
  
  public String getOpen(){
    return open;
  }
  public String getClose(){
    return close;
  }
  public void setOpen(String o){
    open = o;
  }
  public void setClose(String c){
    close = c;
  }
  public String toString(){
     String str = super.toString();
     str += ". Opens at " + open + " and closes at " + close;
     return str;
   }
  public String toFile(){
    String tf = super.toFile();
    tf += open + "|" + close + "|";
    return tf;
  }
}