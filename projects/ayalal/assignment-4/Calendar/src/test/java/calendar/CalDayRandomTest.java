package calendar;
import java.util.Calendar;
import java.util.Random;

import java.util.*;

import org.junit.Test;


import static org.junit.Assert.*;
public class CalDayRandomTest {
	private static final long TestTimeout = (60 * 500 * 1); /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class

    		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

        return methodArray[n] ; // return the method name
        }
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
    public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return the value of the  appointments to recur
        }
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
    public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return appointments to recur forever or Never recur
        }

		//tests the addAppt function by creating three appointment objects then adding them to a calendar day.
	 @Test
	  public void randomtest01()  throws Throwable  {
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

					int secondHour=ValuesGenerator.getRandomIntBetween(random, 0, 3);
					int secondMinute=ValuesGenerator.RandInt(random);
					int secondDay=ValuesGenerator.RandInt(random);
					int secondMonth=ValuesGenerator.getRandomIntBetween(random, 1, 2);
					int secondYear=ValuesGenerator.RandInt(random);
					String secondtitle="a second appt";
					String seconddescription="another soccer game";
									//Construct a new Appointment object with the initial data
									//this appointment should pass
					Appt appt2 = new Appt(secondHour,
													 secondMinute ,
													 secondDay ,
													 secondMonth ,
													 secondYear ,
													 secondtitle,
													seconddescription);

					int fakeHour=ValuesGenerator.getRandomIntBetween(random, 0, 24);
					int fakeMinute=ValuesGenerator.RandInt(random);
					int fakeDay=ValuesGenerator.RandInt(random);
				  int fakeMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				  int fakeYear=ValuesGenerator.RandInt(random);
				  String faketitle="False Test";
				  String fakedescription="Test should not pass";

					Appt apptFake = new Appt(startHour,
  								 fakeMinute ,
  								 fakeDay ,
  								 fakeMonth ,
  								 fakeYear ,
  								 faketitle,
  								fakedescription);

					GregorianCalendar testCalendar = new GregorianCalendar();
				 	CalDay calday = new CalDay(testCalendar);

					calday.addAppt(appt);
					calday.addAppt(apptFake);
					calday.addAppt(appt2);

					elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
					if((iteration%10000)==0 && iteration!=0 )
							System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

					}
					}catch(NullPointerException e){

					}
	 }

}
