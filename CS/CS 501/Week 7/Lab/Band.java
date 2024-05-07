/**
  Band.java
  @author Andy Cherney
  @version 1.0.0
  7_alc466_lab1
*/


import java.util.ArrayList;

public class Band {
    public static void main(String[] args) {
        
        ArrayList <Instrument> instruments = new ArrayList<>();


        Brass trombone = new Brass();
        trombone.setName("trombone");
        trombone.setYearMade(2012);

        Brass trumpet = new Brass("trumpet", 2022);
        WoodWind clarinet = new WoodWind("clarinet", 2021);
        WoodWind oboe = new WoodWind("oboe", 2018, "woo");
        Stringed guitar = new Stringed("guitar", 2019, "strum");
        guitar.setNumStrings(6);
        Stringed string2 = new Stringed("zither",2021,"pluck!",21);
        Percussion drums = new Percussion("snare drum", 2023);


        instruments.add(trombone);
        instruments.add(trumpet);
        instruments.add(clarinet);
        instruments.add(oboe);
        instruments.add(guitar);
        instruments.add(string2);
        instruments.add(drums);


        for (Instrument i: instruments){
            System.out.println("The "+i.getName()+" sound is "+i.playSound());
        }

        System.out.println();
        for (Instrument i: instruments){
            System.out.println(i);
        }


    }
}
