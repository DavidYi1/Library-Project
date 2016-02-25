import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
  
  public static void main (String[] args) {
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
    
    //Shouldn't this go in my while loop? We need to identify what book they want first before we can add all the info to the array.
    String[] bookInfo = new String[allBookData.size()];
    for(int i = 0; i < allBookData.size(); i++) {
      String bookData = allBookData.get(i);
      bookInfo = bookData.split(","); //split based on comma delimited format
      String title = bookInfo[0];
      String isbn = bookInfo[1];
      String genre = bookInfo[2];
      String author = bookInfo[3];
      String status = bookInfo[4];
      
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
        
        /**
        while (br.readLine() != null) {
          line = br.readLine();
          allBookData.add(line);
        }
        */
        
        String thisLine = null;
        if (action.equals("add")) {
          
        }
        
        if (action.equals("remove")) {
          
        }
        
        if (action.equals("view")) {
          for (int i = 0; i < bookInfo.length; i++) {
            System.out.println(bookInfo[i]);
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
    pw.close();
    
  }
}