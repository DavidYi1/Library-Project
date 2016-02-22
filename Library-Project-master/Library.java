import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
  
  public static void main (String args[]) {
    boolean run = true;
    String command = null;
    BufferedReader br = new BufferedReader(new FileReader("books.txt"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("books.txt")));
    
    Scanner kb = new Scanner(System.in);
    System.out.print("What would you like to access? (borrower/librarian)");
    String user = kb.next();
    
    while (run) {
      if (user.equals("librarian")) {
        
        System.out.print("Do you want to add, remove or view a book?");
        String action = kb.next();
        
        if (action.equals("add")) {
          
        }
        
        if (action.equals("remove")) {
          
        }
        
        if (action.equals("view")) {
          
        }
        
      }
    }
  }
}
