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
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("books.txt")));
    BufferedReader br = new BufferedReader(new FileReader("books.txt"));
    
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
          pw.append(name);
        }
        
        if (action.equals("remove")) {
          try {
            while ((thisLine = br.readLine()) != null) {
              if (thisLine.contains(isbn) || thisLine.contains(name)) {
                String trimmedLine = thisLine.trim();
                if (trimmedLine.contains(name)) 
                  continue;
                pw.write(thisLine + System.getProperty("line.separator"));
                break;
              }
            }
          }
          catch ( Exception ex ){
            System.out.println(ex);
          }
        }
        
        if (action.equals("view")) {
          try {
            while ((thisLine = br.readLine()) != null) {
              if (thisLine.contains(isbn) || thisLine.contains(name)) {
                System.out.print(thisLine);
                break;
              }
            }
          }
          catch ( Exception ex ){
            System.out.println(ex);
          }
        }
      }
      
      else {
        run = false;
        kb.close();
        pw.close();
        br.close();
      }
    }
  }
}
