/**
  Instrument.java
  @author Andy Cherney
  @version 1.0.0
  5_alc466_lab2

*/

public interface Instrument {

    public void playSound();
    public void deleteRecording(int loc);
    public void record(String note);
}
