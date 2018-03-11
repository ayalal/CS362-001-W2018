package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.*;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {

	private static final long TestTimeout = (60 * 500 * 1); /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
		 //tests the deleteAppt function by generating two appointment objects and an empty appointment
		 //then placing them within a list which we then delete the appintments from. 
		 @Test
	 	 public void randomtestDeleteAppt()  throws Throwable  {
	 		 long startTime = Calendar.getInstance().getTimeInMillis();
	 		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


	 		 System.out.println("Start test!");

	 		try{
	 			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
	 				long randomseed =System.currentTimeMillis();
	 				Random random = new Random(randomseed);

	 				 int startHour=ValuesGenerator.getRandomIntBetween(random, 0, 24);
	 				 int startMinute=ValuesGenerator.RandInt(random);
	 				 int startDay=ValuesGenerator.RandInt(random);
	 				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
	 				 int startYear=ValuesGenerator.RandInt(random);
	 				 String title="Birthday Party";
	 				 String description="This is my birthday party.";
	 				 //Construct a new Appointment object with the initial data
	 				 //this appointment should pass
	 				 Appt appt = new Appt(startHour,
	 									startMinute ,
	 									startDay ,
	 									startMonth ,
	 									startYear ,
	 									title,
	 								 description);

	 				 int fakeHour=ValuesGenerator.getRandomIntBetween(random, 0, 24);
	 				 int fakeMinute=ValuesGenerator.RandInt(random);
	 				 int fakeDay=ValuesGenerator.RandInt(random);
	 				 int fakeMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
	 				 int fakeYear=ValuesGenerator.RandInt(random);
	 				 String faketitle="False Test";
	 				 String fakedescription="Test should not pass";

	 				 Appt appt2 = new Appt(startHour,
	 									fakeMinute ,
	 									fakeDay ,
	 									fakeMonth ,
	 									fakeYear ,
	 									faketitle,
	 								 fakedescription);

					 TimeTable testTable = new TimeTable();

					 Appt apptEmpty = null;

	 				 LinkedList<Appt> list = new LinkedList<Appt>();
					 list.add(appt);
					 list.add(appt2);
					 list.add(apptEmpty);

					 testTable.deleteAppt(list, list.get(0));
					 testTable.deleteAppt(list, list.get(1));
					 testTable.deleteAppt(list, apptEmpty);


	 				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
	 				 if((iteration%10000)==0 && iteration!=0 )
	 						 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

	 				 }
	 				 }catch(NullPointerException e){

	 				 }
	 	}

		//tests the getApptRange function by generating two dates and then filling a list with appointments
		//then it gets the range of the appointments. It will follow this structure in a for loop so that we get a
		//variety of coverage in our test.
		@Test
	public void randomTestApptRange() throws Throwable{
		long startTime = Calendar.getInstance().getTimeInMillis();
		long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;

		TimeTable testTable = new TimeTable();

		try {
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed = System.currentTimeMillis();
				Random random = new Random(randomseed);

				for (int i = 0; i < NUM_TESTS; i++) {

					int firstYear = ValuesGenerator.getRandomIntBetween(random, 1999, 2003);
					int firstDay = ValuesGenerator.getRandomIntBetween(random, 1, 31);
					int firstMonth = ValuesGenerator.getRandomIntBetween(random, 1, 12);
					int secondYear = ValuesGenerator.getRandomIntBetween(random, 2016, 2019);
					int secondDay = ValuesGenerator.getRandomIntBetween(random, 1, 31);
					int secondMonth = ValuesGenerator.getRandomIntBetween(random, 1, 12);

					GregorianCalendar calDay = new GregorianCalendar(firstYear, firstMonth, firstDay);
					GregorianCalendar calDay2 = new GregorianCalendar(secondYear, secondMonth, secondDay);

						LinkedList<Appt> apptList = new LinkedList<Appt>();
						int randomSize = ValuesGenerator.getRandomIntBetween(random, 5, 20);

						for(int x = 0; x < randomSize; x++){
							int startHour=ValuesGenerator.RandInt(random);
							int startMinute=ValuesGenerator.RandInt(random);
							int startDay=ValuesGenerator.RandInt(random);;
							int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
							int startYear=ValuesGenerator.getRandomIntBetween(random, 2004, 2015);
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

							apptList.add(appt);
						}

					testTable.getApptRange(apptList, calDay, calDay2);
				}

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);


				if((iteration%10000)==0 && iteration!=0 ) {
					System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);
				}
			}
		}
		catch (NullPointerException e){

		}
	}



}
