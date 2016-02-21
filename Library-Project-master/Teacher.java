public class Teacher extends Borrower {
  
  private Book[] books = new Book[4]; //need this here for borrow method to work
  private String[] dueDates = new String[4];
  private int daysDue = 7, id;
  private String name;
  
  public Teacher(int i, String n) {
    id = i;
    name = n;
  }
  
  public void borrow(Book b) {
    for (int i = 0; i < books.length; i++) {
      if (books[i] == null) {
        books[i] = b;
        break;
      }
    }
  }
  
  public void returnBook() {
    
  }
}
