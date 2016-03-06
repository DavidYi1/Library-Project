import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class Tests {
  public static void main(String args[]) {
    String test = "god,I,really,,really,hate this,jesus";
    String[] testSplit = test.split(",");
    for (String s : testSplit){
      System.out.println(s);
    }
    if (testSplit[3].equals(""))
      System.out.println(test);
    Date date = null;
    if (date == null)
      System.out.println(test);
    /*
       // Instantiate a Date object
       
       Date date = new Date();
       int noOfDays = 14;
       GregorianCalendar calendar = new GregorianCalendar();
       calendar.setTime(date);
       calendar.add(Calendar.DATE, noOfDays);
       date.setTime(calendar.getTime().getTime());

       // display time and date using toString()
       System.out.println(date);
       String dateString = null;
       
       SimpleDateFormat sdfr = new SimpleDateFormat("MMM dd, yyyy");
       SimpleDateFormat sdfr2 = new SimpleDateFormat("dd-MMM-yyyy");
       dateString = sdfr.format(date); //convert date to string
       
       Date d1 = convertStringToDate(dateString);
       System.out.println(dateString);
       System.out.println(d1);

       
       System.out.printf("%1$s %2$tB %2$td, %2$tY", 
                         "Due date:", d1);
                         
      */
   }
  
  public static Date convertStringToDate(String dateString)
  {
    Date date = null;
    Date formatteddate = null;
    DateFormat df = new SimpleDateFormat("MMM dd, yyyy");
    try{
        date = df.parse(dateString);

    }
    catch ( Exception ex ){
        System.out.println(ex);
    }
    return date;
  }

}