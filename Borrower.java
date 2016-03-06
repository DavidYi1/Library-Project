import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
public abstract class Borrower {
  
  private Book[] books;
  private int daysDue;
  private Date[] dates;

  
  public abstract void returnBook(Book b);
  public abstract void borrow(Book b);
  public abstract String getName();
}
