import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Book {
  //Fields
  private String title;
  private String isbn;
  private String genre;
  private String author;
  private String status;
  private boolean checkedOut;
  private int daysDue;
  private Date dueDate;
  
  public Book(String t, String i, String g, String a, String s) {
    title = t;
    isbn = i;
    genre = g;
    author = a;
    status = s;
    checkedOut = false;
    daysDue = 0;
    dueDate = null;
  }
  public String getTitle(){
    return title;
  }
  
  public String getISBN(){
    return isbn;
  }
  
  public void setCheckoutTime(int dd) {
    daysDue = dd;
  }
  
  public void bookCheckedOut(Date dueIn) {
    checkedOut = true;
    dueDate = dueIn;
  }
  
  public void bookReturned() {
    checkedOut = false;
    dueDate = null;
  }
  
}
