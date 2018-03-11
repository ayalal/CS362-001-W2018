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

	//test the deleteAppts method
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

		 String titleSecond="Soccer Game";
		 String descriptionSecond="Champions League Final!";
		 //Construct a new Appointment object with the initial data
		 Appt apptTwo = new Appt(startHour-2,
				 startMinute+10 ,
				 startDay+2 ,
				 startMonth+1 ,
				 startYear+1 ,
				 titleSecond,
				 descriptionSecond);

		 LinkedList<Appt> listofAppts = new LinkedList<Appt>();

		 listofAppts.add(appt);
		 listofAppts.add(apptTwo);

		 TimeTable timeTable= new TimeTable();
		 LinkedList<Appt> deletedAppts= timeTable.deleteAppt(listofAppts, listofAppts.get(1));

	 }

	 //test addAppt method and getApptRange method
	 @Test
	public void test02() throws Throwable{

	 	GregorianCalendar day = new GregorianCalendar(2018, 01, 15);
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

		 int startHour2=15;
		 int startMinute2=30;
		 int startDay2=22;
		 int startMonth2=11;
		 int startYear2=2018;
		 String title2="meet the parents";
		 String description2="catch up with the parents";

		 //Construct a new Appointments
		 Appt apptTwo = new Appt(startHour2,
				 startMinute2 ,
				 startDay2 ,
				 startMonth2 ,
				 startYear2 ,
				 title2,
				 description2);

		 int[] recurDays = new int[0];
		 appt.setRecurrence(recurDays, 2, 0, 0);
		 apptTwo.setRecurrence(recurDays, 2, 0, 0);

		 calDay.addAppt(appt);
		 calDay.addAppt(apptTwo);
		 TimeTable timeTable=new TimeTable();
		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();

		 GregorianCalendar today = new GregorianCalendar(2018,01,15);
		 GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		 tomorrow.add(Calendar.DAY_OF_MONTH,1);
		 calDays = timeTable.getApptRange(calDay.getAppts(), today, tomorrow);

		 LinkedList<Appt> listofAppts = new LinkedList<Appt>();
		 listofAppts.add(appt);
		 listofAppts.add(apptTwo);

	 }
		  //test permute and appointment deletion and apptRange
		  @Test
		  public void test03()  throws Throwable  {

	        Appt appt = new Appt(7,9,10,11,2017,"appointment","that appointment");
	        Appt appt1 = new Appt(6,8,9,10,2017,"important meeting","a place in time");
	        Appt appt2 = new Appt(5,7,8,9,2017,"movies","black panther");

	        LinkedList<Appt> listAppts = new LinkedList<Appt>();
	        listAppts.add(appt);
	        listAppts.add(appt1);
	        listAppts.add(appt2);

	        TimeTable table = new TimeTable();
	        int [] arr = {2,1,0};
	        table.permute(listAppts, arr);

	        table.deleteAppt(listAppts, appt1);
	        table.deleteAppt(listAppts, null);
	        appt.setStartMinute(500);
	        table.deleteAppt(listAppts, appt);



	        GregorianCalendar firstDay = new GregorianCalendar(2017, 1, 1);
	        GregorianCalendar secondDay = new GregorianCalendar(2018, 1, 1);


	        table.getApptRange(listAppts, firstDay, secondDay);

	 }

	 //test GetNextApptOccurrence method
	 @Test
	 public void test04() throws Throwable{

		 TimeTable timetable = new TimeTable();
		 GregorianCalendar superBowl = new GregorianCalendar(2018, 2, 4);
         GregorianCalendar superBowl2 = new GregorianCalendar(2019, 2, 4);

		 Appt Olympics =  new Appt(5, 5, 4, 2, 2018, "Olympics", "The Olympic games");

		 int[] recurDays = new int[]{4};
		 Olympics.setRecurrence(recurDays, Olympics.RECUR_BY_YEARLY, 2, Olympics.RECUR_NUMBER_FOREVER);

		 GregorianCalendar Occurrence = timetable.GetNextApptOccur(Olympics,superBowl);
         assertTrue(superBowl2.equals(Occurrence));

		 }


//add more unit tests as you needed
}