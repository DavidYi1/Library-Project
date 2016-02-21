public abstract class Borrower {
  
  private Book[] books;
  private int daysDue;
  
  public Borrower() {
    books = new Book[0];
  }
  
  public void borrow(Book b) {
    for (int i = 0; i < books.length; i++) {
      if (books[i] == null) {
        books[i] = b;
        break;
      }
    }
  }
  
  public abstract void returnBook();
}
