public class Student extends Borrower {
  
  private Book[] books;
  private int checkout, osis, grade;
  private String lastName, firstName, officialClass;
  
  public Student(Book[] b, int c, int o, int g, String ln, String fn, String oc) {
    super(b, c);
    osis = o;
    grade = g;
    lastName = ln;
    firstName = fn;
    officialClass = oc;
  }
  
  public void borrow() {
    
  }
  
  public void returnBook() {
    
  }
}
