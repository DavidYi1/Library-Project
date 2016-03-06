import java.io.*;
import java.util.*;


public class Library {
  
  public static void main (String[] args) throws IOException {
    
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
      ArrayList<String> h = new ArrayList<String>();
      for(int k = 7; k < bookInfo.length; k++)
        h.add(bookInfo[k]);
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
      for (Book x : library_books) {
        if (x.getTitle().equals(line)) {
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
      for (Book x : library_books) {
        if (x.getTitle().equals(line))
          teacherUser.addBook(x);
      }
    }
    teach.close();
    
    //Find user
    Scanner kb = new Scanner(System.in);
    System.out.print("What account type would you like to access? (student/teacher/librarian)");
    String user = kb.next();
    
    System.out.println("");
    
    String action;
    //If user is of borrower class
    if (user.equals("student") || user.equals("teacher")) {
      System.out.print("Please enter your command (search/browse/checkout/return/view checked-out books)");
      action = kb.next();
      
      if (action.equals("search")) {
        System.out.print("Enter an ISBN or Title");
        String query = kb.next();
        
        for (Book x : library_books) {
          if (x.getTitle().equals(query) || x.getISBN().equals(query)) {
            System.out.print("The book " + x.getTitle() + "(" + x.getISBN() + ")" + " is currently ");
            if (x.checkAvailable()) {
              System.out.println("available");
            }
            else {
              System.out.println("unavailable");
            }
          }
        }
        System.out.println("These are the books currently avaiable based on your search. If the book you want didn't appear, please wait until it is returned or another copy is obtained by the library");
      }
      
      if (action.equals("browse")) {
        System.out.print("Enter a genre you are interested in");
        String query = kb.next();
        System.out.println("You should take a look at these books currently available:");
        for (Book x : library_books) {
          if (x.getGenre().equals(query) && x.checkAvailable())
            System.out.println(x.getTitle() + "(" + x.getISBN() + ")");
        }
        System.out.println("If none of these books pique your interest, please wait until some other books are returned or more books are obtained by the library");
      }
      
      if (action.equals("checkout") && user.equals("student")) {
        System.out.print("Enter the book name you wish to borrow. Make sure that it is avaiable first");
        String query = kb.next();
        for (Book x : library_books) {
          if (x.getTitle().equals(query) && x.checkAvailable()) {
            System.out.print(x.getTitle() + " is the book being borrowed");
            studentUser.borrow(x);
            x.addLastHolder(studentUser.getName());
          }
        }
      }
      
      if (action.equals("checkout") && user.equals("teacher")){
        System.out.print("Enter the book name you wish to borrow. Make sure that it is avaiable first");
        String query = kb.next();
        for(Book x : library_books){
          if(x.getTitle().equals(query) && x.checkAvailable()){
            System.out.print(x.getTitle() + " is the book being borrowed");
            teacherUser.borrow(x);
            x.addLastHolder(teacherUser.getName());
          }
        }
      }
      
      if(action.equals("return")&& user.equals("student")){
        System.out.print("Enter the title of the book you are returning");
        String query = kb.next();
        Book returningBook = studentUser.findBook(query);
        studentUser.returnBook(returningBook);
        for(Book x : library_books){
          if(x.equals(returningBook))
            x.bookReturned();
        }
      }
      
      if(action.equals("return")&& user.equals("teacher")){
        System.out.print("Enter the title of the book you are returning");
        String query = kb.next();
        Book returningBook = teacherUser.findBook(query);
        teacherUser.returnBook(returningBook);
        for(Book x : library_books){
          if(x.equals(returningBook))
            x.bookReturned();
        }
      }
      
      if(action.equals("view checked-out books") && user.equals("student")){
        studentUser.showBorrowedBooks();
        System.out.println("These are your borrowed books. If none appear, then you have borrowed no books");
      }
      
      if(action.equals("view checked-out books") && user.equals("teacher")){
        teacherUser.showBorrowedBooks();
        System.out.println("These are your borrowed books. If none appear, then you have borrowed no books");
      }
    }
    
    if (user.equals("librarian")) {
      System.out.print("Please enter your command (add/remove/view history/log off): ");
      action = kb.next();
      
      if (action.equals("add")) {
        System.out.print("Enter Title: ");
        String t = kb.next();
        
        System.out.print("Enter ISBN: ");
        String i = kb.next();
        
        System.out.print("Enter Genre: ");
        String g = kb.next();
        
        System.out.print("Enter Author: ");
        String a = kb.next();
        
        System.out.print("Enter Status: ");
        String s = kb.next();
        
        ArrayList<String> h = new ArrayList<String>();
        Book b = new Book(t, i, g, a, s, "", "false", h);
        library_books.add(b);
      }
      
      if (action.equals("remove")) {
        System.out.print("Enter ISBN or Title: ");
        String query = kb.next();
        
        for (int i = 0; i < library_books.size(); i++) {
          if ((library_books.get(i).getTitle().equals(query)) || (library_books.get(i).getISBN().equals(query))) {
            library_books.remove(i);
          }
        }
      }
      
      if (action.substring(0, 4).equals("view")) {
        System.out.print("Enter ISBN or Title: ");
        String query = kb.next();
        
        for (Book x : library_books) {
          if (x.getTitle().equals(query) || x.getISBN().equals(query)) {
            System.out.println(x.getLH());
          }
        }
      }
    }
    
    PrintWriter bookfile = new PrintWriter(new BufferedWriter(new FileWriter("books.txt")));
    for(Book x: library_books){
      String printTitle = x.getTitle();
      String printISBN = x.getISBN();
      String printGenre = x.getGenre();
      String printAuthor = x.getAuthor();
      String printStatus = x.getStatus();
      String printDueDate;
      String printCheckedOut;
      String printLH = "";
      //if book has been checked out
      if(x.getDateDue() != null){
        printDueDate = x.convertDateToString(x.getDateDue());
        printCheckedOut = "true";
      }
      else{
        printDueDate = " ";
        printCheckedOut = "false";
      }
      for(String data : x.getLH())
        printLH = printLH + (data + ",");
      //need to add last user function
      bookfile.println(printTitle + "," + printISBN + "," + printGenre + "," + printAuthor + "," + printStatus + "," + printDueDate + "," + printCheckedOut + "," + printLH);
    }
    bookfile.close();
    
    //Make a file of student info
    PrintWriter studentfile = new PrintWriter(new BufferedWriter(new FileWriter("student.txt")));
    studentfile.println(lineStudent); // adds the first line back of student info
    for(String bookTitle : studentUser.listBorrowedBooks())
      studentfile.println(bookTitle);
    studentfile.close();
    
    //Make a file of teacher info
    PrintWriter teacherfile = new PrintWriter(new BufferedWriter(new FileWriter("teacher.txt")));
    teacherfile.println(lineTeacher); // adds the first line back of student info
    for(String bookTitle : teacherUser.listBorrowedBooks())
      teacherfile.println(bookTitle);
    teacherfile.close();
    
    kb.close();
  }
}
