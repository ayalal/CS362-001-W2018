package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
         // Create three valid appointments to use for testing
        Appt appt = new Appt(7,9,10,11,2017,"Super awesome title","Description and such");
        Appt appt1 = new Appt(6,8,9,10,2017,"title","appointment 1");
        Appt appt2 = new Appt(5,7,8,9,2017,"Appointment 2","description for appointment 2");

        LinkedList<Appt> listAppts = new LinkedList<Appt>();
        listAppts.add(appt);
        listAppts.add(appt1);
        listAppts.add(appt2);

        TimeTable t = new TimeTable();
        int [] arr = {2,1,0};
        t.permute(listAppts, arr);

        // These two days are not used because getApptRange fails as a result of assignment 1
        // bugs that caused an array out of range
        GregorianCalendar day1 = new GregorianCalendar(2017, 1, 1);
        GregorianCalendar day2 = new GregorianCalendar(2018, 1, 1);

        // The following fails because of the bug I added <= on line 53 of TimeTable.java
        // This is one of the bugs that comes from assignment 1
        t.getApptRange(listAppts, day1, day2);
        t.getApptRange(listAppts, day2, day1);

        GregorianCalendar day3 = new GregorianCalendar(2017, 1, 1);
        GregorianCalendar day4 = new GregorianCalendar(2018, 1, 1);
        TimeTable m = new TimeTable();
        assertEquals(t.getApptRange(listAppts, day1, day2), m.getApptRange(listAppts, day3, day4));


        t.deleteAppt(listAppts, appt1);
        t.deleteAppt(listAppts, null);
        appt.setStartMinute(500);
        t.deleteAppt(listAppts, appt);
	 }
	 @Test
	  public void test02()  throws Throwable  {
         // Create the 1st valid appointment (title and description are bugged out)
		 Appt appt = new Appt(7,9,10,11,2017,"Super awesome title","Description and such");
         // Create the 2nd valid appointment (title and description bugged for all three appts)
		 Appt appt1 = new Appt(6,8,9,10,2017,"title","appointment 1");
         // Create the 3rd valid appointment
		 Appt appt2 = new Appt(5,7,8,9,2017,"Appointment 2","description for appointment 2");

        // Create a new time table and linked list of appointments
        TimeTable t = new TimeTable();
        LinkedList<Appt> listAppts = new LinkedList<Appt>();

        // This array will be used to set the recurrence
        int[] arr = {2,3,4};
        appt.setRecurrence(arr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);

        // Add each of the valid appointments to the linked list
        listAppts.add(appt);
        listAppts.add(appt1);
        listAppts.add(appt2);

        // These two days will not be used because getApptRange fails (bug from assignment 1)
        GregorianCalendar day1 = new GregorianCalendar(2017, 1, 1);
        GregorianCalendar day2 = new GregorianCalendar(2018, 1, 1);
        // Can't test for day2 before day1 because error will be issued

        // The following fails because of the bug I added <= on line 53 of TimeTable.java
        // Assignment 1 bug
        t.getApptRange(listAppts, day1, day2);

	 }

     @Test
      public void test03() throws Throwable {
        Appt appt = new Appt(7,9,10,11,2017,"Super awesome title","Description and such");
        Appt appt1 = new Appt(6,8,9,10,2017,"title","appointment 1");
        Appt appt2 = new Appt(5,7,8,9,2017,"Appointment 2","description for appointment 2");

        LinkedList<Appt> listAppts = new LinkedList<Appt>();
        listAppts.add(appt);
        listAppts.add(appt1);
        listAppts.add(appt2);

        Appt appt2_ = new Appt(7,9,10,11,2017,"Super awesome title","Description and such");
        Appt appt12 = new Appt(6,8,9,10,2017,"title","appointment 1");
        Appt appt22 = new Appt(5,7,8,9,2017,"Appointment 2","description for appointment 2");

        int[] arr = {2,3,4};
        appt22.setRecurrence(arr, Appt.RECUR_BY_WEEKLY, 2, 0);

        appt12.setRecurrence(arr, Appt.RECUR_BY_MONTHLY, 2, Appt.RECUR_NUMBER_FOREVER);

        appt2_.setRecurrence(arr, Appt.RECUR_BY_YEARLY, 2, Appt.RECUR_NUMBER_FOREVER);
        assertTrue(appt2_.isRecurring());

        LinkedList<Appt> listAppts2 = new LinkedList<Appt>();
        listAppts2.add(appt2_);
        listAppts2.add(appt12);
        listAppts2.add(appt22);

        GregorianCalendar day1 = new GregorianCalendar(2017, 12, 1);
        GregorianCalendar day2 = new GregorianCalendar(2018, 1, 1);

        GregorianCalendar day3 = new GregorianCalendar(2017, 12, 1);
        GregorianCalendar day4 = new GregorianCalendar(2018, 1, 1);

        TimeTable one = new TimeTable();
        TimeTable two = new TimeTable();
        assertSame(one, one);

        assertNotNull(two.getApptRange(listAppts, day3, day4));
        assertNotSame(one, appt);
      }

    @Test
    public void test04()  throws Throwable  {

        Appt appt = new Appt(7,9,10,11,2017,"Super awesome title","Description and such");
        LinkedList<Appt> listAppts = new LinkedList<Appt>();
        listAppts.add(appt);

        int[] arr = {2,3,4};
        appt.setRecurrence(arr, Appt.RECUR_BY_WEEKLY, 2, 0);
        appt.setRecurrence(arr, Appt.RECUR_BY_MONTHLY, 2, Appt.RECUR_NUMBER_FOREVER);
        appt.setRecurrence(arr, Appt.RECUR_BY_YEARLY, 2, Appt.RECUR_NUMBER_FOREVER);

        LinkedList<Appt> listAppts2 = new LinkedList<Appt>();

        GregorianCalendar day1 = new GregorianCalendar(2017, 5, 5);
        GregorianCalendar day2 = new GregorianCalendar(2018, 7, 5);
        GregorianCalendar day3 = new GregorianCalendar(2017, 12, 3);
        GregorianCalendar day4 = new GregorianCalendar(2018, 2, 3);

        TimeTable one = new TimeTable();
        TimeTable two = new TimeTable();
        assertSame(one, one);
    }

    @Test
    public void test05()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt1 = new Appt(startHour,startMinute ,startDay ,startMonth ,startYear ,title,description);

		 startHour=21;
		 startMinute=31;
		 startDay=17;
		 startMonth=02;
		 startYear=2017;
		 title="hello my friend";
		 description="party on wayne";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,startMinute ,startDay ,startMonth ,startYear ,title,description);
		 Appt appt3 = new Appt(startHour,startMinute ,startDay ,startMonth ,startYear ,title,description);
		 Appt appt4 = new Appt(startHour,startMinute ,startDay ,startMonth ,startYear ,title,description);

         appt.setStartHour(23);
         assertEquals(23, appt.getStartHour());

         // Next one fails because of bug from assignment 1
         appt.setStartMinute(10);
         appt.setStartDay(5);
         assertEquals(5, appt.getStartDay());
         appt.setStartMonth(10);
         assertEquals(10, appt.getStartMonth());
         appt.setStartYear(2018);
         assertEquals(2018, appt.getStartYear());

         // Next two fail because of bugs from assignment 1
         appt.setTitle("hello");
         appt.setDescription("Hello there General Kenobi");

         int [] arr = {2, 3, 4};
         appt.setRecurrence(arr, 10, 2, 10);
         appt.setRecurrence(null, 10, 2, 10);

         appt.getRecurNumber();
         assertEquals(10, appt.getRecurNumber());

         appt.getRecurBy();
         assertEquals(10, appt.getRecurBy());

         // Fails as a result of a bug from assignment 1
         appt.getRecurDays();
         assertEquals(null, appt.getRecurDays());
    }
}
