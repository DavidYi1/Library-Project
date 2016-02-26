import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Teacher extends Borrower {
  
  private Book[] books = new Book[4];
  private Date[] dueDate = new Date[4];
  private int daysDue = 7, id;
  private String name;
  
  public Teacher(int i, String n) {
    id = i;
    name = n;
  }
  
  public boolean noSpace(){
    for (int i = 0; i < books.length; i++) {
      if (books[i] == null) {
        return false;
      }
    }
    return true;
  }
  public void borrow(Book b) {
    super.borrow(b,daysDue);
  }
  
  public void fullSpace(){
    System.out.print("You can not borrow anymore books");
  }
  
  public void returnBook(Book b) {
    for (int i = 0; i < books.length; i++) {
      if (books[i] == b) {
        books[i] = null;
        dueDate[i] = null;
        return;
      }
    }
    System.out.print("No such book borrowed");
  }
}