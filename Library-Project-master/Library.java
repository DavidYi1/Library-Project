import java.util.ArrayList;
import java.util.Scanner;
public class Library{
  
  public static void main (String args[]){
    Scanner kb = new Scanner(System.in);
    private boolean run = true;
    String command = null;
    BufferedReader br = new BufferedReader(new FileReader("books.txt"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("books.txt")));
    
    
    System.out.print("What would you like to access? (borrower/librarian)");
    String operator = kb.nextLine();
    while(run){
      ///if(operator.equals("borrower"){
        ///
      }
    else{
      
    }
    
      
  }
    
}