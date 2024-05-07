/**
 * BookTracking.java
 * 3_alc466_lab3
 *
 * @author Andy Cherney
 * @version 1.0
 */


public class BookTracking {

    public static void main(String[] args) {
        
        Book bookA = new Book();
        bookA.setTitle("A Tale of Two Cities");
        bookA.setAuthor("Charles Dickens");
        bookA.setYear(1859);
        bookA.setFormat("epub");
        bookA.setStatus("finished");
        System.out.println("Book A");
        System.out.println(bookA.toString());


        /* A full example demonstrating how the tracker works */
        Book bookB = new Book();
        bookB.setTitle("The Shining");
        bookB.setFormat("kindle");
        bookB.setAuthor("Stephen King");
        bookB.setYear(2008);

        bookB.setStatus("want it");
        System.out.println("Book B");
        System.out.println(bookB.toString());


        System.out.println("...10 days later...\n");
        bookB.setStatus("own it");
        System.out.println(bookB.toString());

        System.out.println("...20 days later...\n");
        bookB.setStatus("finished");
        System.out.println(bookB.toString());

        if (bookB.readIt()){
            System.out.println("I now read this book");
        }
        else {
            System.out.println("I did not yet read this book");
        }

    }
    
}
