package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedList;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";

         // Create 3 valid appointments (which contain bugs)
		Appt appt = new Appt(startHour,startMinute ,startDay ,startMonth ,startYear ,title,description);
		Appt appt1 = new Appt(startHour,40,8,8,2018,"title","appointment 1");

        //Check Day
        //appt.setDay(10);
        //assertEquals(10, appt.getDay());
        Appt ap = new Appt(10,10,10,10,2018,"thing", "apt1");
        assertNotNull(ap);

        // Check valid start hour
        appt1.setStartHour(6);
        assertEquals(6, appt1.getStartHour());

        // Create hew appointment, set start hour and check if all valid
		Appt appt2 = new Appt(startHour,20,4,10,2017,"Appointment 2","description for appointment 2");
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
        CalDay cD = new CalDay(today);

        // Check month, year, and valid
        cD.iterator();
        cD.getMonth();
        assertEquals(1, cD.getMonth());

        // Check year and valid
        cD.getYear();
        assertEquals(2018, cD.getYear());
        cD.toString();
        cD.isValid();
        assertTrue(cD.isValid());
        cD.getDay();

        // Add three appointments and check valid
        cD.addAppt(appt);
        cD.addAppt(appt1);
        cD.addAppt(appt2);
        assertTrue(cD.valid);

        cD.getAppts();
        cD.iterator();
        cD.toString();
        cD.getSizeAppts();

        appt.setStartHour(40);
        assertEquals(40, appt.getStartHour());
        cD.addAppt(appt);

        cD.valid = false;
        assertFalse(cD.valid);
        cD.toString();
    }
    @Test
    public void test02()  throws Throwable  {
        int startHour=21;
        int startMinute=30;
        int startDay=15;
        int startMonth=01;
        int startYear=2018;
        String title="Birthday Party";
        String description="This is my birthday party.";
        int [] arr = {2, 3, 4};
        Appt appt = new Appt(startHour,startMinute ,startDay ,startMonth ,startYear ,title,description);
        appt.setRecurrence(arr, 10, 2, 10);

        //This will break because of a bug
        appt.setStartHour(0);
        assertFalse(appt.getValid());

        appt.setStartHour(10);
        appt.setStartMinute(500);
        assertFalse(appt.getValid());


        appt.setStartHour(10);
        appt.setStartMinute(5);
        appt.setStartDay(40);
        assertFalse(appt.getValid());

        appt.setStartHour(10);
        appt.setStartMinute(5);
        appt.setStartDay(4);
        appt.setStartMonth(1); //Broken
        assertTrue(appt.getValid());

        appt.setStartHour(10);
        appt.setStartMinute(5);
        appt.setStartDay(4);
        appt.setStartMonth(10);
        appt.setStartYear(2010); // Not checked
        assertTrue(appt.getValid());

        appt.setStartHour(25);
        appt.setStartMinute(61);
        appt.setStartDay(40);
        appt.setStartMonth(1);
        assertFalse(appt.getValid());

        appt.setDescription("hello");
        assertEquals("hello", appt.getDescription());
    }
}
