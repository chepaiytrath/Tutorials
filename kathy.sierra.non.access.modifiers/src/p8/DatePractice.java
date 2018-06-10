package p8;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DatePractice {
	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d.toString());
		
		Calendar cal = Calendar.getInstance();
		cal.roll(Calendar.YEAR, true);
		System.out.println(cal.toString());
	}
}
