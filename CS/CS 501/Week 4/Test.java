import java.util.ArrayList;
import java.util.Random;

public class Test {
    
    public static void main(String[] args) {
        
        Random randomGen = new Random();
        ArrayList<Integer> weights = new ArrayList<Integer>(25);

        int sum = 0;
        for (int i = 0; i < 25; i++) {

            weights.add(randomGen.nextInt(500)+1);
            sum += weights.get(i);

        }

        System.out.println("The running sum is using for loop "+sum);


        sum = 0;
        for (Integer i : weights) {
            sum += i;
        }
        System.out.println("The running sum is using enhanced for loop "+sum);

        
        sum = 0;
        int i = 0;
        while (i < weights.size()){
            sum += weights.get(i);
            i++;
        }
        System.out.println("The running sum is using while loop "+sum);
    }

}

