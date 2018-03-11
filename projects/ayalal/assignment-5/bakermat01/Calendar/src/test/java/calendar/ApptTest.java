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

     //test setters and getters
	 @Test
	  public void test01()  throws Throwable  {
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
	// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());

		 //below are added tests for recur values
		 assertEquals(0, appt.getRecurNumber() );
		 assertEquals(0, appt.getRecurIncrement());
		 assertEquals(2, appt.getRecurBy());
		 assertFalse(appt.isRecurring());

		 //assertions for the setter methods
		 appt.setStartMinute(40);
		 assertEquals(40, appt.getStartMinute());

		 appt.setStartHour(5);
		 assertEquals(5, appt.getStartHour());

		 appt.setTitle(null);
		 assertEquals(null, appt.getTitle());

		 appt.setTitle("title");
		 assertEquals("title", appt.getTitle());

		 appt.setDescription("description");
		 assertEquals("description", appt.getDescription());

		 appt.setDescription(null);
		 assertEquals(null, appt.getDescription());
	 }
	//test the toString method
	 @Test
	  public void test02()  throws Throwable  {

		 int startHour=21;
		 int startMinute=30;
		 int startDay=50;
		 int startMonth=10;
		 int startYear=2018;
		 String title="False appointment";
		 String description="this is not a real appointment";
		 //Construct a new Appointment object with the initial data
		 Appt appt = new Appt(startHour,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		assertEquals(null, appt.toString());
	 }

	@Test
	public void test03() throws Throwable{

		 		 int startHour=0;
				 int startMinute=0;
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

		         Appt appt2 = new Appt(startHour+3,
				 				          startMinute+3 ,
				 				          startDay-3 ,
				 				          startMonth ,
				 				          startYear ,
				 				          title,
		         		  description);

		         assertEquals(0, appt.compareTo(appt));
		         assertEquals(-3, appt.compareTo(appt2));

		}



//add more unit tests as you needed

}
