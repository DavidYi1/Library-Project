import java.io.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Library {
  
  public static void main (String[] args) throws IOException {
    boolean run = true;
    String command = null;
    ArrayList<String> allBookData = new ArrayList<String>();
    ArrayList<Book> library_books = new ArrayList<Book>();
    
    BufferedReader br = new BufferedReader(new FileReader("books.txt"));
    
    String line;
    while (br.readLine() != null) {
      line = br.readLine();
      allBookData.add(line);
    }
    
    //converts all the book data into Book objects
    for(int i = 0; i < allBookData.size(); i++) {
      String bookData = allBookData.get(i);
      String[] bookInfo = bookData.split(","); //split based on comma delimited format
      String title = bookInfo[0];
      String isbn = bookInfo[1];
      String genre = bookInfo[2];
      String author = bookInfo[3];
      String status = bookInfo[4];
      String dueDate = bookInfo[5];
      String checkedOut = bookInfo[6];
      Book input = new Book(title, isbn, genre, author, status, dueDate, checkedOut);
      library_books.add(input);
    }
    
    Scanner kb = new Scanner(System.in);
    System.out.print("What would you like to access? (borrower/librarian)");
    String user = kb.next();
    
    while (run) {
      if (user.equals("librarian")) {
        
        System.out.print("Do you want to add, remove or view a book?");
        String action = kb.next();
        
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
        }
        
        if (action.equals("remove")) {
          System.out.print("For student or teacher?");
          String rec = kb.next();
          for (int i = 0; i < library_books.size(); i++) {
            if ((library_books.get(i).getTitle() == name) || (library_books.get(i).getISBN() == name)) {
              if (rec.equals("student"))
                library_books.get(i).bookCheckedOut(new Date());
              if (rec.equals("teacher"))
                library_books.get(i).bookCheckedOut(new Date());
              library_books.remove(i);
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
      
      else {
        
      }
    }
  }
}
