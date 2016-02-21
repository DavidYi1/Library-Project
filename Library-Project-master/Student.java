public class Student extends Borrower {
  
  private Book[] books = new Book[2]; // I want to make sure that they exist as permanent fields instead of object fields
  private String[] dueDates = new String[2];
  private int daysDue = 14, osis, grade;
  private String lastName, firstName, officialClass;
  
  public Student(int o, int g, String ln, String fn, String oc) {
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
