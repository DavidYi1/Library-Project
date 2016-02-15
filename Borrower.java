import java.util.ArrayList;
public abstract class Borrower {
  
  private ArrayList<Book> books;
  private int checkout;
  
  public class Borrower(ArrayList<Book> b, int c) {
    books = new ArrayList<Book>();
    for (int i = 0; i < b.size(); i++)
      books.set(i, b.get(i));
    checkout = c;
  }
  
  public abstract void borrow();
  public abstract void returnBook();
  
}
