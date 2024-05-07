import java.io.FileWriter;
import java.io.IOException;
public class exceptions {

    public static void main(String[] args) throws IOException {

        String fileName = "myFile.txt";
        FileWriter file = null;
        try {
            file = new FileWriter(fileName);
            file.write("test");
        } catch (IOException e) {
            System.out.printf("Error writing to: %s", fileName);
        } finally{ //optional
            file.close();
        }

        int i;
        try {
            i= 10/0;
        } catch (ArithmeticException e) {
            System.out.println("You cannot divide by 0!");
        }
     	
        int a[] = new int[10];
        try {
            a[20] = 0;
        } catch (IndexOutOfBoundsException  e) {
            System.out.println("You tried to access an index out of the range of this array");
        }

        try {
            int s = getIndex(a, 11);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Can't access that index");
        }

    }
    public static int getIndex(int arr[], int index) throws IndexOutOfBoundsException {	
        return arr[index];
    }

}