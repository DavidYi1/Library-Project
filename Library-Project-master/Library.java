import java.io.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Library {
  
  public static void main (String[] args) throws IOException {
    boolean run = true;
    String action = " ";
    
    //make library
    ArrayList<String> allBookData = new ArrayList<String>();
    ArrayList<Book> library_books = new ArrayList<Book>();
    
    BufferedReader br = new BufferedReader(new FileReader("books.txt"));
    String line;
    
    while ((line = br.readLine()) != null) {
      allBookData.add(line);
    }
    br.close();

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
    
    //import all student info from the student.txt and reads what books are borrowed. 
    //Library checked for borrowed books and dates are assigned
    BufferedReader stu = new BufferedReader(new FileReader("student.txt"));
    String[] StudentInfo = stu.readLine().split(",");
    Student studentUser = new Student(StudentInfo[0],StudentInfo[1],StudentInfo[2], StudentInfo[3], StudentInfo[4]);    
    while ((line = stu.readLine()) != null) {
      for (Book x : library_books) {
        if (x.getTitle().equals(line)) {
          studentUser.addBook(x);
        }
      }
    }
    stu.close();
    
    //import teacher info over. Essentially the same as above but for teacher
    BufferedReader teach = new BufferedReader(new FileReader("teacher.txt"));
    String[] TeacherInfo = teach.readLine().split(",");
    Teacher teacherUser = new Teacher(TeacherInfo[0],TeacherInfo[1]); 
    while ((line = teach.readLine()) != null) {
      for(Book x : library_books){
        if(x.getTitle().equals(line))
          teacherUser.addBook(x);
      }
    }
    teach.close();
    
    Scanner kb = new Scanner(System.in);
    System.out.print("What would you like to access? (borrower/librarian)");
    String user = kb.next();
    
    while (run) {
      if (user.equals("borrower")){
        System.out.print("Are you a student or teacher?");
        user = kb.nextLine();
      }
      
      if (user.equals("student")){
        System.out.print("Please enter your command (search/browse/checkout/return/view checked out books/log off)");
        action = kb.nextLine();
        
        if (action.equals("search")) {
          System.out.print("Enter an ISBN or Title");
          String query = kb.nextLine();
          
          for (Book x : library_books) {
            if (x.getTitle().equals(query) || x.getISBN().equals(query)) {
             System.out.print("The book" + x.getTitle() + "(" + x.getISBN() + ")" + " is currently ");
             if (x.checkAvailable()) {
               System.out.println("available");
             }
             else {
               System.out.println("unavailable");
             }
            }
          }
          System.out.println("These are the books currently avaiable based on your search. If the book you want didn't appear, please wait until it is returned or another copy is obtained by the library");
          action = " "; //reset the action
        }
        
        if (action.equals("browse")) {
          System.out.print("Enter a genre you are interested in");
          String query = kb.nextLine();
          System.out.println("You should take a look at these books currently available:");
          for (Book x : library_books) {
           if (x.getGenre().equals(query) && x.checkAvailable())
             System.out.println(x.getTitle() + "(" + x.getISBN() + ")" );
          }
          System.out.println("If none of these books pique your interest, please wait until some other books are returned or more books are obtained by the library");
          action = " ";
        }
        
        if (action.equals("checkout")) {
          System.out.print("Enter the book name you wish to borrow. Make sure that it is avaiable first");
          String query = kb.nextLine();
          for (Book x : library_books) {
            if (x.getTitle().equals(query) && x.checkAvailable()) {
              System.out.print(x.getTitle() + " is the book being borrowed");
              studentUser.borrow(x);
              x.setLastHolder(studentUser.getName());
            }
          }
          action = " ";
        }
        
        if (action.equals("return")) {
          System.out.print("Enter the title of the book you are returning");
          String query = kb.nextLine();
          Book returningBook = studentUser.findBook(query);
          studentUser.returnBook(returningBook);
          for (Book x : library_books) {
           if (x.equals(returningBook))
             x.bookReturned();
          }
          action = " ";
        }
      }
      
      if (user.equals("teacher")) {
        System.out.print("Please enter your command (search/browse/checkout/return/view checked out books/log off)");
        action = kb.nextLine();
        
        if (action.equals("search")) {
          System.out.print("Enter an ISBN or Title");
          String query = kb.nextLine();
          
          for(Book x : library_books) {
            if(x.getTitle().equals(query) || x.getISBN().equals(query)){
             System.out.print("The book" + x.getTitle() + "(" + x.getISBN() + ")" + " is currently ");
             if (x.checkAvailable()) {
               System.out.println("available");
             }
             else {
               System.out.println("unavailable");
             }
            }
          }
          System.out.println("These are the books currently avaiable based on your search. If the book you want didn't appear, please wait until it is returned or another copy is obtained by the library");
          action = null; //reset the action
        }
        
        if (action.equals("browse")) {
          System.out.print("Enter a genre you are interested in");
          String query = kb.nextLine();
          System.out.println("You should take a look at these books currently available:");
          for (Book x : library_books) {
           if (x.getGenre().equals(query) && x.checkAvailable())
             System.out.println(x.getTitle() + "(" + x.getISBN() + ")" );
          }
          System.out.println("If none of these books pique your interest, please wait until some other books are returned or more books are obtained by the library");
          action = " ";
        }
        
        if (action.equals("checkout")) {
          System.out.print("Enter the book name you wish to borrow. Make sure that it is avaiable first");
          String query = kb.nextLine();
          for (Book x : library_books) {
            if (x.getTitle().equals(query) && x.checkAvailable()) {
              System.out.print(x.getTitle() + " is the book being borrowed");
              teacherUser.borrow(x);
              x.setLastHolder(teacherUser.getName());
            }
          }
          action = " ";
        }
        
        if (action.equals("return")) {
          System.out.print("Enter the title of the book you are returning");
          String query = kb.nextLine();
          Book returningBook = teacherUser.findBook(query);
          teacherUser.returnBook(returningBook);
          for(Book x : library_books){
           if(x.equals(returningBook))
             x.bookReturned();
          }
          action = null;
        }
      }
      
      if (user.equals("librarian")) {
        
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
            for (int i = 0; i < library_books.size(); i++) {
              if ((library_books.get(i).getTitle() == name) || (library_books.get(i).getISBN() == name)) {
                library_books.remove(i);
              }
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
      
      else if (action.equals("log off")) {
        run = false;
        kb.close();
      }
      
      else { // if not any of the users.
	System.out.print("Please enter borrower or librarian"); 
	user = kb.nextLine();
      }
    }
  }
}
