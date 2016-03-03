import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Book {
  //Fields
  private String title;
  private String isbn;
  private String genre;
  private String author;
  private String status;
  private Date dueDate;
  private boolean checkedOut;
  private String lastHolder;
  
  public Book(String t, String i, String g, String a, String s, String dd, String check, String h) {
    title = t;
    isbn = i;
    genre = g;
    author = a;
    status = s;
    //if there exists nothing between s and check then this should be false and the book is in the library
    if (!dd.equals(" "))
      dueDate = convertStringToDate(dd);
    else 
      dueDate = null;
    
    //checks to see if checkedOut or not. Should be consistent with dueDate so useful as a debugging tool.
    if (check.equals("true"))
      checkedOut = true;
    else 
      checkedOut = false;
      
    lastHolder = h;
  }
  
  public String getTitle() {
    return title;
  }
  public boolean checkAvailable() {
   return !checkedOut; 
  }
  
  public String getGenre() {
    return genre;
  }
  
  public String getISBN() {
    return isbn;
  }
  
  public void setLastHolder(String s) {
    lastHolder = s;
  }
  
  public void bookCheckedOut(Date dueIn) {
    checkedOut = true;
    dueDate = dueIn;
  }
  
  public void bookReturned() {
    checkedOut = false;
    dueDate = null;
  }
  
  public Date getDateDue() {
   return dueDate;
  }
  
  public Date convertStringToDate(String dateString) {
    Date date = null;
    Date formatteddate = null;
    DateFormat df = new SimpleDateFormat("MMM dd yyyy");
    try {
      date = df.parse(dateString);
    }
    catch ( Exception ex ) {
      System.out.println(ex);
    }
    return date;
  }
  
  public String convertDateToString(Date dd) {
    SimpleDateFormat sdfr = new SimpleDateFormat("MMM dd yyyy");
    String dateString = sdfr.format(dd);
    return dateString;
  }
}
