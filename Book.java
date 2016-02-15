public class Book{
  //Fields
  private String Title;
  private String ISBN;
  private String Genre;
  private String Author;
  private String Status;
  private boolean checkedOut = false;
  private int checkoutTime = 0;
  
  public Book(String t, String i, String g, String a, String s ){
    Title = t;
    ISBN = i;
    Genre = g;
    Author = a;
    Status = s;
  }
  
  public void setCheckoutTime(int x){
    checkoutTime = x;
  }
  
  public void bookCheckedOut(){
    checkedOut = true;
  }
  
  public void bookReturned(){
    checkedOut = false;
  }
}
