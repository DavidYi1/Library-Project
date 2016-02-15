public class Teacher extends Borrower {
  
  private Book[] books;
  private int daysDue, id;
  private String name;
  
  public Teacher(int c, int i, String n) {
    books = new Book[4];
    daysDue = 7;
    id = i;
    name = n;
  }
  
  public void borrow() {
    
  }
  
  public void returnBook() {
    
  }
}
