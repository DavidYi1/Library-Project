public abstract class Borrower {
  
  private Book[] books;
  private int daysDue;
  
  public abstract void borrow();
  public abstract void returnBook();
}
