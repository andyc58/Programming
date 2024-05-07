
/**
 * Book.java
 * 3_alc466_lab3
 *
 * @author Andy Cherney
 * @version 1.0
 */


public class Book {
    

    private String title;
    private String format;
    private int year;
    private String author;
    private String status;
    private boolean read;

    public Book (){
        this.title = "";
        this.format = "";
        this.year = 0;
        this.author = "";
        this.status= "";
        this.read = false;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public void setFormat(String format) {
        this.format = format;
    }


    public void setStatus(String status) {

        this.status = status;
        
        if (status.equals("finished") || status.equals("read")) {
            this.read = true;
        }
        
        
    }

    public boolean readIt(){
        return this.read;
    }

    
    public String toString() {


      String info = "Title: "+this.title+"\n"+
                    "Year: "+this.year+"\n"+
                    "Format: "+this.format+"\n"+
                    "Author: "+this.author+"\n"+
                    "Status: "+this.status+"\n";


      return info;
      

    }


}
