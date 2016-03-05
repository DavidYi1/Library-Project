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
    String lineStudent = stu.readLine();
    String[] StudentInfo = lineStudent.split(",");
    Student studentUser = new Student(StudentInfo[0],StudentInfo[1],StudentInfo[2], StudentInfo[3], StudentInfo[4]);    
    while ((line = stu.readLine()) != null) {
      for(Book x : library_books){
        if(x.getTitle().equals(line)){
          studentUser.addBook(x);
        }
      }
    }
    stu.close();
    
    //import teacher info over. Essentially the same as above but for teacher
    BufferedReader teach = new BufferedReader(new FileReader("teacher.txt"));
    String lineTeacher = teach.readLine();
    String[] TeacherInfo = lineTeacher.split(",");
    Teacher teacherUser = new Teacher(TeacherInfo[0],TeacherInfo[1]); 
    while ((line = teach.readLine()) != null) {
      for(Book x : library_books){
        if(x.getTitle().equals(line))
          teacherUser.addBook(x);
      }
    }
    teach.close();
    
    //Find user
    Scanner kb = new Scanner(System.in);
    System.out.print("What account type would you like to access? (student/teacher/librarian)");
    String user = kb.next();
    
    System.out.println("");
    
    //If user is of borrower class
    if (user.equals("student") || user.equals("teacher") ){
      System.out.print("Please enter your command (search/browse/checkout/return/view checked-out books)");
      action = kb.nextLine();
      
      if(action.equals("search")){
        System.out.print("Enter an ISBN or Title");
        String query = kb.nextLine();
            
        for(Book x : library_books){
          if(x.getTitle().equals(query) || x.getISBN().equals(query)){
            System.out.print("The book" + x.getTitle() + "(" + x.getISBN() + ")" + " is currently ");
            if(x.checkAvailable()){
              System.out.println("available");
            }
            else {
              System.out.println("unavailable");
            }
          }
        }
        System.out.println("These are the books currently avaiable based on your search. If the book you want didn't appear, please wait until it is returned or another copy is obtained by the library");
      }
      
      if(action.equals("browse")){
        System.out.print("Enter a genre you are interested in");
        String query = kb.nextLine();
        System.out.println("You should take a look at these books currently available:");
        for(Book x : library_books){
          if(x.getGenre().equals(query) && x.checkAvailable())
            System.out.println(x.getTitle() + "(" + x.getISBN() + ")" );
          
        }
        System.out.println("If none of these books pique your interest, please wait until some other books are returned or more books are obtained by the library");
      }
      
      
      if (action.equals("checkout") && user.equals("student")){
        System.out.print("Enter the book name you wish to borrow. Make sure that it is avaiable first");
        String query = kb.nextLine();
        for(Book x : library_books){
          if(x.getTitle().equals(query) && x.checkAvailable()){
            System.out.print(x.getTitle() + " is the book being borrowed");
            studentUser.borrow(x);
            x.setLastHolder(studentUser.getName());
          }
        }
      }
      if (action.equals("checkout") && user.equals("teacher")){
        System.out.print("Enter the book name you wish to borrow. Make sure that it is avaiable first");
        String query = kb.nextLine();
        for(Book x : library_books){
          if(x.getTitle().equals(query) && x.checkAvailable()){
            System.out.print(x.getTitle() + " is the book being borrowed");
            studentUser.borrow(x);
            x.setLastHolder(teacherUser.getName());
          }
        }
      }
      if(action.equals("return")&& user.equals("student")){
        System.out.print("Enter the title of the book you are returning");
        String query = kb.nextLine();
        Book returningBook = studentUser.findBook(query);
        studentUser.returnBook(returningBook);
        for(Book x : library_books){
          if(x.equals(returningBook))
            x.bookReturned();
        }
      }
      if(action.equals("return")&& user.equals("teacher")){
        System.out.print("Enter the title of the book you are returning");
        String query = kb.nextLine();
        Book returningBook = teacherUser.findBook(query);
        teacherUser.returnBook(returningBook);
        for(Book x : library_books){
          if(x.equals(returningBook))
            x.bookReturned();
        }
      }
      else
        System.out.print("Could not understand action. Please restart");
    }
    
   
      
    /*  
     * if (user.equals("librarian")) {
        
        //enter librarian methods
        //add book
        
        
        //remove book
        
        
        //Checks array list of the last user 
      */
      
    PrintWriter bookfile = new PrintWriter(new BufferedWriter(new FileWriter("books.txt")));
    for(Book x: library_books){
      String printTitle = x.getTitle();
      String printISBN = x.getISBN();
      String printGenre = x.getGenre();
      String printDueDate;
      String printCheckedOut;
      //if book has been checked out
      if(x.getDateDue() != null){
        printDueDate = x.convertDateToString(x.getDateDue());
        printCheckedOut = "true";
      }
      else{
        printDueDate = x.convertDateToString(x.getDateDue());
        printCheckedOut = "false";
      }
      //need to add last user function
      bookfile.println(printTitle + "," + printISBN + "," + printGenre + "," + printDueDate + "," + printCheckedOut);
    }
    bookfile.close();
    
    //Make a file of student info
    PrintWriter studentfile = new PrintWriter(new BufferedWriter(new FileWriter("student.txt")));
    studentfile.println(lineStudent); // adds the first line back of student info
    for(String bookTitle : studentUser.listBorrowedBooks())
      studentfile.println(bookTitle);
    studentfile.close();
    
    //Make a file of teacher info
    PrintWriter teacherfile = new PrintWriter(new BufferedWriter(new FileWriter("student.txt")));
    teacherfile.println(lineTeacher); // adds the first line back of student info
    for(teacherfile bookTitle : teacherUser.listBorrowedBooks())
      teacherfile.println(bookTitle);
    teacherfile.close();
    
  }
}


