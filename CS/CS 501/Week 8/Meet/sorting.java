/**
 * @author Samantha Bewley
 */
public class sorting {

    public static void main(String[] args) 
    {
        int [] myArray = {5,8,0,22,3,6,1,2,3};
        selectionSort(myArray);
        printArray(myArray);

        int [] myArray2 = {5,8,0,22,3,6,1,2,3};
        insertionSort(myArray2);
        printArray(myArray2);
    }

    public static void selectionSort(int [] a)
    {
        int min; 
        int temp;

        for (int i = 0; i < a.length-1; i++)
        {
            min = i; 
            for (int scan = i+1; scan<a.length; scan++)
            {
                if (a[scan] < a[min])
                {
                    min = scan;
                }
            }
            // swap values
            temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
    }

    public static void insertionSort(int [] a)
    {
        for (int i = 1; i <a.length; i++)
        {
            int key = a[i];
            int position = i;
            while (position > 0 && key < a[position-1])
            {
                a[position] = a[position-1];
                position--;
            }
            a[position]= key;
        }
    }

    public static void printArray(int [] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}