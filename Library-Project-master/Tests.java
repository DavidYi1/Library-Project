import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
public class Tests {
  public static void main(String args[]) {
       // Instantiate a Date object
    
       Date date = new Date();
       int noOfDays = 14;
       GregorianCalendar calendar = new GregorianCalendar();
       calendar.setTime(date);
       calendar.add(Calendar.DATE, noOfDays);
       date.setTime(calendar.getTime().getTime());

       // display time and date using toString()
       System.out.print(date);
       System.out.printf("%1$s %2$tB %2$td, %2$tY", 
                         "Due date:", date);
   }
}