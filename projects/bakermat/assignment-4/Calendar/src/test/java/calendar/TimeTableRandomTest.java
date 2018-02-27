package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;

import java.util.LinkedList;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	private static final long TestTimeout = 10 * 500 * 1; /* Timeout at 30 seconds */
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
   /**
     * Generate Random Tests that tests Appt Class.
     */
	 @Test
	  public void radnomtest2()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		 System.out.println("Start testing...");
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				 int startHour=ValuesGenerator.RandInt(random);
				 int startMinute=ValuesGenerator.RandInt(random);
				 int startDay=ValuesGenerator.RandInt(random);;
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear=ValuesGenerator.RandInt(random);
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 //Construct a new Appointment object with the initial data	 
				 Appt appt = new Appt(
                         startHour,
				          startMinute ,
				          startDay ,
				          startMonth ,
				          startYear ,
				          title,
				         description);
			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);						   
						}
					   else if (methodName.equals("setRecurrence")){
						   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
						   int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
						   int recur=ApptRandomTest.RandomSelectRecur(random);
						   int recurIncrement = ValuesGenerator.RandInt(random);
						   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
						   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						}				
				}
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			}
		}catch(NullPointerException e){
		}
		 System.out.println("Done testing...");
	 }
	 @Test
	  public void radnomtest()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		 System.out.println("Start testing...");
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				 int startHour=ValuesGenerator.RandInt(random);
				 int startMinute=ValuesGenerator.RandInt(random);
				 int startDay=ValuesGenerator.RandInt(random);;
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear=ValuesGenerator.RandInt(random);
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
			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
				//	   if (methodName.equals("setTitle")){
				//		   String newTitle=(String) ValuesGenerator.getString(random);
				//		   appt.setTitle(newTitle);						   
				//		}
				//	   else if (methodName.equals("setRecurrence")){
				//		   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
				//		   int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
				//		   int recur=ApptRandomTest.RandomSelectRecur(random);
				//		   int recurIncrement = ValuesGenerator.RandInt(random);
				//		   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
				//		   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
				//		}				
				}
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			}
		}catch(NullPointerException e){
		} System.out.println("Done testing...");
	 }
	 @Test
	  public void radnomtestREMOVE()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		 System.out.println("Start testing...");
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
                int nL = ValuesGenerator.getRandomIntBetween(random, 0, 1);
                TimeTable testingThing = new TimeTable();
                if (nL == 0) {
                    LinkedList<Appt> aAppts = null;
				 int startHour=ValuesGenerator.RandInt(random);
				 int startMinute=ValuesGenerator.RandInt(random);
				 int startDay=ValuesGenerator.getRandomIntBetween(random, -40, 70);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear=ValuesGenerator.RandInt(random);
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
                 testingThing.deleteAppt(aAppts, appt);
                } else {
                    LinkedList<Appt> aAppts = new LinkedList<Appt>();
                    int nAppts = ValuesGenerator.RandInt(random);
                    int rem = ValuesGenerator.getRandomIntBetween(random, 0, nAppts);
                    for (int i = 0; i < nAppts; i ++) {
                     int startHour=ValuesGenerator.RandInt(random);
                     int startMinute=ValuesGenerator.RandInt(random);
                     int startDay=ValuesGenerator.getRandomIntBetween(random, -40, 70);
                     int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
                     int startYear=ValuesGenerator.RandInt(random);
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
                     aAppts.add(appt);
                    }
			//for (int i = 0; i < NUM_TESTS; i++) {
			//		String methodName = ApptRandomTest.RandomSelectMethod(random);
			//		   if (methodName.equals("setTitle")){
			//			   String newTitle=(String) ValuesGenerator.getString(random);
			//			   appt.setTitle(newTitle);						   
			//			}
			//		   else if (methodName.equals("setRecurrence")){
			//			   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
			//			   int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
			//			   int recur=ApptRandomTest.RandomSelectRecur(random);
			//			   int recurIncrement = ValuesGenerator.RandInt(random);
			//			   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
			//			   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
			//			}				
			//	}
                    int j = 0;
                    for (j = 0; j < rem-1; j++) {
                        int r = ValuesGenerator.getRandomIntBetween(random, 0, aAppts.size()-1);
                        if (r == rem) { testingThing.deleteAppt(aAppts, null);
                        } else { testingThing.deleteAppt(aAppts, aAppts.get(r)); }}}
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			}
		}catch(NullPointerException e){
		}
		 System.out.println("Done testing...");
	 }
	 @Test
	  public void radnomtestRANGENAUGHT()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		 System.out.println("Start testing...");
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
                TimeTable tT = new TimeTable();
                int dONE = ValuesGenerator.getRandomIntBetween(random, -40, 70);
                int mONE = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                int yONE = ValuesGenerator.RandInt(random); // no error checking
                    int dTWO = ValuesGenerator.getRandomIntBetween(random, -40, 70);
                    int mTWO = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                    int yTWO = yONE + 2;
                GregorianCalendar cONE = new GregorianCalendar(yONE, mONE, dONE);
                    GregorianCalendar cTWO = new GregorianCalendar(yTWO, mTWO, dTWO);
                LinkedList<Appt> aAppts = new LinkedList<Appt>();
                int nAppts = ValuesGenerator.RandInt(random);
                for (int i = 0; i < nAppts; i++) {
				 int startHour=ValuesGenerator.RandInt(random);
				 int startMinute=ValuesGenerator.RandInt(random);
				 int startDay=ValuesGenerator.RandInt(random);;
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear=ValuesGenerator.RandInt(random);
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
                 aAppts.add(appt);
			for (int j = 0; j < NUM_TESTS; j++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);						   
						}
					   else if (methodName.equals("setRecurrence")){
						   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
						   int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
						   int recur=ApptRandomTest.RandomSelectRecur(random);
						   int recurIncrement = ValuesGenerator.RandInt(random);
						   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
						   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						}				
				}
            // ERROR OUT OF RANGE
            //LinkedList<CalDay> aRange = tT.getApptRange(aAppts, cONE, cTWO);
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
                }
			}
		}catch(NullPointerException e){
		}
		 System.out.println("Done testing...");
	 }
	 @Test
	  public void radnomtestRANGENAUGHT_()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		 System.out.println("Start testing...");
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
                TimeTable tT = new TimeTable();
                int dONE = ValuesGenerator.getRandomIntBetween(random, -40, 70);
                int mONE = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                int yONE = ValuesGenerator.RandInt(random); // no error checking
                    int dTWO = ValuesGenerator.getRandomIntBetween(random, -40, 70);
                    int mTWO = ValuesGenerator.getRandomIntBetween(random, 1, 11);
                    int yTWO = ValuesGenerator.RandInt(random);
                GregorianCalendar cONE = new GregorianCalendar(yONE, mONE, dONE);
                    GregorianCalendar cTWO = new GregorianCalendar(yTWO, mTWO, dTWO);
                //LinkedList<Appt> aAppts = new LinkedList<Appt>();
                //int nAppts = ValuesGenerator.RandInt(random);
                //for (int i = 0; i < nAppts; i++) {
				// int startHour=ValuesGenerator.RandInt(random);
				// int startMinute=ValuesGenerator.RandInt(random);
				// int startDay=ValuesGenerator.RandInt(random);;
				// int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				// int startYear=ValuesGenerator.RandInt(random);
				// String title="Birthday Party";
				// String description="This is my birthday party.";
				// //Construct a new Appointment object with the initial data	 
				// Appt appt = new Appt(startHour,
				//          startMinute ,
				//          startDay ,
				//          startMonth ,
				//          startYear ,
				//          title,
				//         description);
                // aAppts.add(appt);
			//for (int j = 0; j < NUM_TESTS; j++) {
			//		String methodName = ApptRandomTest.RandomSelectMethod(random);
			//		   if (methodName.equals("setTitle")){
			//			   String newTitle=(String) ValuesGenerator.getString(random);
			//			   appt.setTitle(newTitle);						   
			//			}
			//		   else if (methodName.equals("setRecurrence")){
			//			   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
			//			   int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
			//			   int recur=ApptRandomTest.RandomSelectRecur(random);
			//			   int recurIncrement = ValuesGenerator.RandInt(random);
			//			   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
			//			   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
			//			}				
			//	}
            //    //LinkedList<CalDay> aRange = tT.getApptRange(aAppts, cONE, cTWO);
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
                //}
			}
		}catch(NullPointerException e){
		}
		 System.out.println("Done testing...");
	 }
	 @Test
	  public void radnomtestRANGE()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		 System.out.println("Start testing...");
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				 int startHour=ValuesGenerator.RandInt(random);
				 int startMinute=ValuesGenerator.RandInt(random);
				 int startDay=ValuesGenerator.RandInt(random);;
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear=ValuesGenerator.RandInt(random);
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
			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);						   
						}
					   else if (methodName.equals("setRecurrence")){
						   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
						   int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
						   int recur=ApptRandomTest.RandomSelectRecur(random);
						   int recurIncrement = ValuesGenerator.RandInt(random);
						   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
						   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						}				
				}
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			}
		}catch(NullPointerException e){
		}
		 System.out.println("Done testing...");
	 }
	 @Test
	  public void radnomtestTEST()  throws Throwable  {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;
		 System.out.println("Start testing...");
		try{ 
			for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				long randomseed =System.currentTimeMillis(); //10
	//			System.out.println(" Seed:"+randomseed );
				Random random = new Random(randomseed);
				 int startHour=ValuesGenerator.RandInt(random);
				 int startMinute=ValuesGenerator.RandInt(random);
				 int startDay=ValuesGenerator.RandInt(random);;
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear=ValuesGenerator.RandInt(random);
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
			 if(!appt.getValid())continue;
			for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);						   
						}
					   else if (methodName.equals("setRecurrence")){
						   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
						   int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
						   int recur=ApptRandomTest.RandomSelectRecur(random);
						   int recurIncrement = ValuesGenerator.RandInt(random);
						   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
						   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
						}				
				}
				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
			        if((iteration%10000)==0 && iteration!=0 )
			              System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);
			}
		}catch(NullPointerException e){
		}
		 System.out.println("Done testing...");
	 }
}
