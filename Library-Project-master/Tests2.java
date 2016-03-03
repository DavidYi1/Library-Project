import java.io.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Tests2 {
  public static void main(String args[]) {
    BufferedReader br = new BufferedReader(new FileReader("books.txt"));
    String line;
    
    while (br.readLine() != null) {
      line = br.readLine();
      allBookData.add(line);
    }
  }
}
