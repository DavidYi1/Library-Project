import java.util.ArrayList;
public class Student extends Borrower {
  
  private ArrayList<Book> books;
  private int checkout;
  
  public Student(ArrayList<Book> b, int c) {
    super(b, c);
  }
  
  public void borrow() {
    
  }
  
  public void returnBook() {
    
  }
}
