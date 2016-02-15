public abstract class Borrower {
  
  private Book[] books;
  private int checkout;
  
  public Borrower(Book[] b, int c) {
    books = new Book[b.length];
    for (int i = 0; i < b.length; i++)
      books[i] = b[i];
    checkout = c;
  }
  
  public abstract void borrow();
  public abstract void returnBook();
}
