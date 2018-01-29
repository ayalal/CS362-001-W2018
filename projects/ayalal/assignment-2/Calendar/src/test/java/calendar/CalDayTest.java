package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	@Test
	public void test01()  throws Throwable  {
		GregorianCalendar cal= new GregorianCalendar();
		CalDay calDay= new CalDay(cal);


		assertEquals(cal.get(cal.DAY_OF_MONTH), calDay.getDay());
		assertEquals(cal.get(cal.MONTH), calDay.getMonth());
		assertEquals(cal.get(cal.YEAR), calDay.getYear());
		assertTrue(calDay.isValid());
	}

	@Test
	public void test02() throws Throwable{
		GregorianCalendar day= new GregorianCalendar(2018,01,15);
		CalDay calDay = new CalDay(day);

		int startHour=21;
		int startMinute=30;
		int startDay=15;
		int startMonth=01;
		int startYear=2018;
		String title="Birthday Party";
		String description="This is my birthday party.";
		//Construct a new Appointment object with the initial data
		Appt appt = new Appt(startHour,
				startMinute ,
				startDay ,
				startMonth ,
				startYear ,
				title,
				description);

		assertEquals("\t --- 1/15/2018 --- \n --- -------- Appointments ------------ --- \n\n", calDay.toString());
	}

//add more unit tests as you needed	
}