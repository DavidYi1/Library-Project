public class Student extends Borrower {
  
  private Book[] books = Books[2];
  private int checkoutTime = 14, osis, grade;
  private String lastName, firstName, officialClass;
  
  public Student(int o, int g, String ln, String fn, String oc) {
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
