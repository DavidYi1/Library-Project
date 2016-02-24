import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Library {
  
  public static void main (String args[]) {
    boolean run = true;
    String command = null;
    ArrayList<String> AllbookData = new ArrayList<String>();
    ArrayList<Book> library_books = new ArrayList<Book>();
    BufferedReader br = new BufferedReader(new FileReader("books.txt"));
    String line;
    while(!(br.readline() == null)){
      line = br.readline();
      bookdata.add(line);
    }
    for(int i = 0; i < AllBookData.size(); i++){
      String bookData = AllBookData.get(i);
      String[] bookinfo = bookData.split(","); //split based on comma delimited format
      String title = bookinfo[0];
      String isbn = bookinfo[1];
      String genre = bookinfo[2];
      String author = bookinfo[3];
      String status = bookinfo[4];
      String check = bookinfo[5];
      String daysDue = 


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
        
        String  thisLine = null;
        if (action.equals("add")) {
          
        }
        
        if (action.equals("remove")) {
          
        }
        
        if (action.equals("view")) {
          while ((thisLine = br.readLine()) != null) {
            if (thisLine.contains(isbn) || thisLine.contains(name)) {
              System.out.print(thisLine);
              break;
            }
          }
        }
      }
      
      else {
        run = false;
        kb.close();
        br.close();
      }
    }
    
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("books.txt")));
  }
}
