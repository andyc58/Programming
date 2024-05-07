/**
  BandTester.java
  @author Andy Cherney
  @version 1.0.0
  5_alc466_lab2

*/

public class BandTester {
    public static void main(String[] args) {
        
    
    
    // Initialize band
    Prop flag = new Prop("flag");
    flag.setDescription("A representation of the band");
    Prop baton = new Prop("baton");
    flag.setDescription("Conductor can use this to direct the band");

    Woodwind clarinet = new Woodwind("clarinet", "mid");
    Woodwind flute = new Woodwind("flute", "high");

    Brass trumpet = new Brass("trumpet", "high");
    Brass trombone = new Brass("trombone", "mid");

    Percussion bassDrum = new Percussion("bass drum", "low");
    Percussion snare = new Percussion("snare drum", "high");

    
    /* WhiteBox test of Woodwind class*/ 


    // Playing notes

    clarinet.playSound("A");
    clarinet.playSound("B#");

    flute.playSound("C#");
    
    

    // String Representations
    System.out.println(flute);
    System.out.println(clarinet);


    // Recording Notes
    flute.record("Bb");
    flute.record("Ab");
    clarinet.record("D");



    System.out.println(flute);

    System.out.println(flute.getRecordings());
    System.out.println(clarinet.getRecordings());

    flute.deleteRecording(2);
    flute.deleteRecording(4); // Invalid location


    System.out.println(flute.getRecordings());

    }
}
