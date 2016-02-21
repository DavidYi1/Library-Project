public class Student extends Borrower {
  
  private Book[] books;
  private int daysDue, osis, grade;
  private String lastName, firstName, officialClass;
  
  public Student(int o, int g, String ln, String fn, String oc) {
    books = new Book[2];
    daysDue = 14;
    osis = o;
    grade = g;
    lastName = ln;
    firstName = fn;
    officialClass = oc;
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
