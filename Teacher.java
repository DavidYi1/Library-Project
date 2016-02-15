import java.util.ArrayList;
public class Teacher extends Borrower {
  
  private ArrayList<Book> books;
  private int checkout;
  
  public Teacher(ArrayList<Book> b, int c) {
    super(b, c);
  }
  
  public void borrow() {
    
  }
  
  public void returnBook() {
    
  }
}
