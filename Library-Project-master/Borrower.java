public abstract class Borrower {
  
  private Book[] books;
  private int daysDue;
  
  public abstract void borrow(Book b);
  
  public abstract void returnBook();
}
