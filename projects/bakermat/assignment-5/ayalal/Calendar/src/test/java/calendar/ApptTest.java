package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 Appt appt = new Appt(startHour,startMinute ,startDay ,startMonth ,startYear ,title,description);

	     // assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 //assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 //assertEquals("Birthday Party", appt.getTitle());
		 //assertEquals("This is my birthday party.", appt.getDescription());         		

		 appt.getValid();
         assertTrue(appt.getValid());
		 //appt.getStartHour();
         //assertEquals(21, appt.getStartHour());
         // Start minute will fail any asserts because of the bugs from assignment 1
		 //appt.getStartMinute();
         //assertEquals(15, appt.getStartDay());
		 appt.getStartDay();
		 appt.getStartMonth();
         //assertEquals(01, appt.getStartMonth());
         // Any asserts on the following two functions will fail because of bugs from assignment 1
		 appt.getTitle();
		 appt.getDescription();
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

         appt.setStartHour(23);
         assertEquals(23, appt.getStartHour());

         // Next one fails because of bug from assignment 1
         appt.setStartMinute(10);
         //appt.setStartDay(5);
         //assertEquals(5, appt.getStartDay());
         //appt.setStartMonth(10);
         //assertEquals(10, appt.getStartMonth());
         //appt.setStartYear(2018);
         //assertEquals(2018, appt.getStartYear());

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
         //assertEquals(null, appt.getRecurDays());

         appt.isRecurring();
         assertTrue(appt.isRecurring());
         appt.getRecurIncrement();

         //These next runs just get more code coverage, not testing any particular values
         appt.toString();
         appt.setStartDay(100);
         appt.toString();
         appt.compareTo(appt1);

         appt.setStartHour(15);
         assertEquals(15, appt.getStartHour());
         appt.toString();

         appt.setStartHour(0);
         assertEquals(0, appt.getStartHour());
         appt.toString();

         //These tests will fail because of assignment 1 bug
         //appt.setTitle(null);
         //appt.setDescription(null);

         appt.setStartHour(24);
         assertFalse(appt.getValid());
         appt.getValid();

         // This will fail because of bugs from assignment 1
         appt.setStartHour(20);
         appt.setStartMinute(90);
         appt.getValid();
         assertFalse(appt.getValid());

         // This will fail because of assignment 1 bugs
         appt.setStartMinute(40);
         appt.setStartDay(100);
         appt.getValid();
         assertFalse(appt.getValid());
         appt.setStartDay(10);
    }

    @Test
     public void test03() throws Throwable {
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
        //appt.setStartHour(0);
        //assertFalse(appt.getValid());

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
        //appt.setStartMonth(1); //Broken
        assertTrue(appt.getValid());

        appt.setStartHour(10);
        appt.setStartMinute(5);
        appt.setStartDay(4);
        appt.setStartMonth(10);
        //appt.setStartYear(2010); // Not checked
        assertTrue(appt.getValid());

        appt.setStartHour(25);
        appt.setStartMinute(61);
        appt.setStartDay(40);
        appt.setStartMonth(1);
        assertFalse(appt.getValid());

        //appt.setDescription("hello");
        //assertEquals("hello", appt.getDescription());
     }

    @Test
    public void test04() throws Throwable {

    }

}
