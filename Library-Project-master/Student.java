import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Student extends Borrower {
  
  private Book[] books = new Book[2];
  private Date[] dueDate = new Date[2];
  private int daysDue = 14, osis, grade;
  private String lastName, firstName, officialClass;
  
  public Student(int o, int g, String ln, String fn, String oc) {
    osis = o;
    grade = g;
    lastName = ln;
    firstName = fn;
    officialClass = oc;
  }
  
  public boolean noSpace() {
    for (int i = 0; i < books.length; i++) {
      if (books[i] == null) {
        return false;
      }
    }
    return true;
  }
  
  public void borrow(Book b) {
    super.borrow(b);
  }
  
  public void fullSpace() {
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
