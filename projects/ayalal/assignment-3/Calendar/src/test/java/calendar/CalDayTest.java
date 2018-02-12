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
	//test getters and isValid method
	@Test
	public void test01()  throws Throwable  {
		GregorianCalendar cal= new GregorianCalendar();
		CalDay calDay= new CalDay(cal);


		assertEquals(cal.get(cal.DAY_OF_MONTH), calDay.getDay());
		assertEquals(cal.get(cal.MONTH), calDay.getMonth());
		assertEquals(cal.get(cal.YEAR), calDay.getYear());
		assertTrue(calDay.isValid());
	}

	//test the toString method
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

		CalDay emptyDay = new CalDay();
		assertTrue(emptyDay.toString().matches(""));


	}
		//a large test to test multiple methods for coverage
		@Test
		  public void test03()  throws Throwable  {
			 int startHour=21;
			 int startMinute=30;
			 int startDay=15;
			 int startMonth=01;
			 int startYear=2018;
			 String title="Birthday Party";
			 String description="This is my birthday party.";

	         // Create 3 valid appointments
			Appt appt = new Appt(startHour,startMinute ,startDay ,startMonth ,startYear ,title,description);
			Appt appt1 = new Appt(startHour,40,8,8,2018,"Soccer","the big game");

	        // Check valid start hour
	        appt1.setStartHour(6);
	        assertEquals(6, appt1.getStartHour());

	        // Create hew appointment, set start hour and check if all valid
			Appt appt2 = new Appt(startHour,20,4,10,2017,"Soccer 2","another game");
	        appt2.setStartHour(4);
	        assertEquals(4, appt2.getStartHour());

	        // Create linked list to hold appoints and add three to the list
	        LinkedList<Appt> listAppts = new LinkedList<Appt>();
	        listAppts.add(appt);
	        listAppts.add(appt1);
	        listAppts.add(appt2);

	        // Create two valid gregorian calendars
	        GregorianCalendar today = new GregorianCalendar(2018, 1, 24);
	        GregorianCalendar tomorrow = new GregorianCalendar(2018, 1, 25);

	        LinkedList<CalDay> calDays = new LinkedList<CalDay>();
	        calDays = new LinkedList<CalDay>();

	        // Create two new CalDay objects
	        CalDay day = new CalDay();
	        day.iterator();
	        CalDay calDay = new CalDay(today);

	        // Check month, year, and valid
	        calDay.iterator();
	        calDay.getMonth();
	        assertEquals(1, calDay.getMonth());

	        // Check year and valid
	        calDay.getYear();
	        assertEquals(2018, calDay.getYear());
	        calDay.toString();
	        calDay.isValid();
	        assertTrue(calDay.isValid());
	        calDay.getDay();

	        // Add three appointments and check valid
	        calDay.addAppt(appt);
	        calDay.addAppt(appt1);
	        calDay.addAppt(appt2);
	        assertTrue(calDay.valid);

	        calDay.getAppts();
	        calDay.iterator();
	        calDay.toString();
	        calDay.getSizeAppts();

	        appt.setStartHour(40);
	        assertEquals(40, appt.getStartHour());
	        calDay.addAppt(appt);

	        calDay.valid = false;
	        assertFalse(calDay.valid);
	        calDay.toString();
    }

    //a more extensive test on the Iterator method
    @Test
    public void test04() throws Throwable{

		GregorianCalendar superBowl = new GregorianCalendar(2018, 2, 4);
		CalDay calDay = new CalDay(superBowl);
		CalDay emptyDay = new CalDay();

		calDay.iterator();
		assertEquals(null, emptyDay.iterator());

		}

//add more unit tests as you needed
}