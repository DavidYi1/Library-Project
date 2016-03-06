import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class Teacher extends Borrower {
  
  private Book[] books = new Book[4]; //need this here for borrow method to work
  private int daysDue = 7;
  private String id;
  private String name;
  private Date[] dates = new Date[4];
  private Date today = new Date();
  
  public Teacher(String i, String n) {
    id = i;
    name = n;
  }
  
   
  public void addBook(Book b){ // used at the start to add all books 
    for (int i = 0; i < books.length; i++) {
        if (books[i] == null) {
          books[i] = b;
          dates[i] = b.getDateDue();
          return;
        }
      }
  }
  
  public String getName(){
    return name;
  }

  
public void borrow(Book b){
    if(noSpace() == false){
      Date date = new Date();
      GregorianCalendar calendar = new GregorianCalendar();
      calendar.setTime(date);
      calendar.add(Calendar.DATE, daysDue);
      date.setTime(calendar.getTime().getTime());
      System.out.printf("%1$s %2$tB %2$td, %2$tY", "The due date for this boook is ", date);
      System.out.println(" ");
      for (int i = 0; i < books.length; i++) {
        if (books[i] == null) {
          books[i] = b;
          dates[i] = date;
          b.bookCheckedOut(date);
          return;
        }
      }
    }
    else{
      fullSpace();
    }
  }
  
  public boolean noSpace(){
    for (int i = 0; i < books.length; i++) {
        if (books[i] == null) {
          return false;
        }
      }
    return true;
  }
  

  
  public void fullSpace(){
    System.out.println("You can not borrow anymore books");
  }
  
  public Book findBook(String title){
    for (Book b : books) {
      if (title.equals(b.getTitle())) {
        return b;
      }
    }
    return null;
  }
  
  public void returnBook(Book b) {
    if(b == null){
      System.out.println("No such book exists");
      return;
    }
    for (int i = 0; i < books.length; i++) {
        if (books[i] == b) {
          books[i] = null;
          if(today.after(dates[i]))
            System.out.println("This book is overdue. Please return it faster next time as others may wish to read it");
          dates[i] = null;               
          return;
        }
      }
    System.out.println("No such book borrowed");
  }
  
  public void showBorrowedBooks(){
    for (int i = 0; i < books.length; i++){
      if(books[i] != null)
        System.out.println(books[i].getTitle());
    }
  }
}
