import java.io.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class Library {
  
  public static void main (String[] args) throws IOException {
    boolean run = true;
    String action = null;
    ArrayList<String> allBookData = new ArrayList<String>();
    ArrayList<Book> library_books = new ArrayList<Book>();
    
    BufferedReader br = new BufferedReader(new FileReader("books.txt"));
    String line;
    
    while ((line = br.readLine()) != null) {
      allBookData.add(line);
    }
    br.close();
    BufferedReader stu = new BufferedReader(new FileReader("student.txt"));
    String[] StudentInfo = stu.readLine().split(",");
    Student studentUser = new Student(StudentInfo[0],StudentInfo[1],StudentInfo[2], StudentInfo[3], StudentInfo[4]);    
    while ((line = stu.readLine()) != null) { //adds to list of books already borrowed out by user
      for (int i = 0; i < library_books.size(); i++) {
            if (library_books.get(i).getTitle() == line){
              studentUser.addBook(library_books.get(i));
            }
      }
    }
    stu.close();
    
    
    
    //converts all the book data into Book objects
    for(int i = 0; i < allBookData.size(); i++) {
      String bookData = allBookData.get(i);
      String[] bookInfo = bookData.split(","); 
      //split based on comma delimited format
      String title = bookInfo[0];
      String isbn = bookInfo[1];
      String genre = bookInfo[2];
      String author = bookInfo[3];
      String status = bookInfo[4];
      String dueDate = bookInfo[5];
      String checkOut = bookInfo[6];
      String h = bookInfo[7];
      Book input = new Book(title, isbn, genre, author, status, dueDate, checkOut, h);
      library_books.add(input);
    }
    
    Scanner kb = new Scanner(System.in);
    System.out.print("What would you like to access? (borrower/librarian)");
    String user = kb.next();
    
    while (run) {
      if (user.equals("borrower")){
        System.out.print("Are you a student or teacher?");
        user = kb.next();
      }
      if (user.equals("student")){
        System.out.print("Please enter your command (search/browse/checkout/return");
        
      }
      /*if (user.equals("librarian")) {
        
        System.out.print("Do you want to add, remove or view a book?");
        action = kb.next();
        
        System.out.print("Do you want to enter book ISBN or name?");
        String opt = kb.next();
        
        String isbn = null;
        if (opt.equals("ISBN")) {
          System.out.print("Enter ISBN: ");
          isbn = kb.next();
        }
        
        String name = null;
        if (opt.equals("name")) {
          System.out.print("Enter name: ");
          name = kb.next();
        }
        
        String thisLine = null;
        if (action.equals("add")) {
          for (int i = 0; i < library_books.size(); i++) {
            if ((library_books.get(i).getTitle() == name) || (library_books.get(i).getISBN() == name)) {
              library_books.get(i).bookReturned();
            }
          }
          if (action.equals("remove")) {
          System.out.print("For student or teacher?");
          String rec = kb.next();
          for (int i = 0; i < library_books.size(); i++) {
            if ((library_books.get(i).getTitle() == name) || (library_books.get(i).getISBN() == name)) {
              if (rec.equals("student"))
                library_books.get(i).bookCheckedOut(Date ???);
              if (rec.equals("teacher"))
                library_books.get(i).bookCheckedOut(Date ???);
            }
          }
        }
        
        
        if (action.equals("view")) {
          for (int i = 0; i < library_books.size(); i++) {
            if ((library_books.get(i).getTitle() == name) || (library_books.get(i).getISBN() == name)) {
              System.out.println(library_books.get(i).getTitle());
              System.out.println(library_books.get(i).getISBN());
              System.out.println(library_books.get(i).getGenre());
              System.out.println(library_books.get(i).getAuthor());
              System.out.println(library_books.get(i).getStatus());
              }
            }
          }
        }
      }
        
        
        
        */
      
      if(action == "log off") {
        run = false;
        kb.close();
      }
      else{ // if not any of the users.
       System.out.print("Please enter borrower or librarian"); 
      }
    }
  }
}