public class Teacher extends Borrower {
  
  private Book[] books;
  private int checkout, id;
  private String name;
  
  public Teacher(Book[] b, int c, int i, String n) {
    super(b, c);
    checkout = c;
    id = i;
    name = n;
  }
  
  public void borrow() {
    
  }
  
  public void returnBook() {
    
  }
}
