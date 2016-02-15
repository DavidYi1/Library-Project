public class Book {
  //Fields
  private String title;
  private String isbn;
  private String genre;
  private String author;
  private String status;
  private boolean checkedOut;
  private int daysDue;
  
  public Book(String t, String i, String g, String a, String s) {
    title = t;
    isbn = i;
    genre = g;
    author = a;
    status = s;
    checkedOut = false;
    daysDue = 0;
  }
  
  public void setCheckoutTime(int x) {
    checkoutTime = x;
  }
  
  public void bookCheckedOut() {
    checkedOut = true;
  }
  
  public void bookReturned() {
    checkedOut = false;
  }
}
