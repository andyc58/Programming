public class searching {

    static int count = 0; 
    public static void main(String[] args) {
        int [] mySortedArray = {0,1,2,3,4,6,7,8,9};
        int [] myArray = {4,7,9,0,2,6,8,1,3};

        linearSearch(8, myArray);
        System.out.println("The count for the linear search is " + count);
        linearSearch(8,mySortedArray);
        System.out.println("The count for the linear search is " + count);
        binarySearch(8, mySortedArray);
        System.out.println("The count for the binary search is " + count);
    }

    public static int linearSearch(int value, int arr[]) 
    {
        count = 0;
        for (int i = 0; i < arr.length; i++) 
        {	
            count ++;	
            if (arr[i] == value) 
            {	
                return i;	
            }	
        }
        return -1;
    }

    public static int binarySearch(int value, int arr[]) 
    {	
        count = 0; 
        int lo = 0, hi = arr.length;
        int mid;
        while (lo <= hi) 
        {
            count++;
            mid = (lo + hi) / 2;	
            if (arr[mid] == value)			
                return mid;	
            if(arr[mid] < value)			
                lo = mid + 1;
            else if (arr[mid] > value)		
                hi = mid - 1;
        }
        return -1;
    }

}