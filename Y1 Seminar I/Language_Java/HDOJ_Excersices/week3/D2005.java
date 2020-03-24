package HDOJ.week3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author SonderLau
 */
public class D2005 {
    public static void main(String[] args) throws ParseException {
             Scanner sc = new Scanner(System.in);
             while (sc.hasNext()){
                 String time = sc.nextLine();
                 SimpleDateFormat stdYearFormat = new SimpleDateFormat("yyyy/MM/dd");
                 Date date = stdYearFormat.parse(time);
                 SimpleDateFormat dayOfYear =new SimpleDateFormat("D");
                 System.out.println(dayOfYear.format(date));
             }
             sc.close();
    }

}


