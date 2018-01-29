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

	 @Test
	public void test03() throws Throwable{
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

		 listofAppts.add(apptTwo);
		 listofAppts.add(appt);
		 int[] pv = new int[2];
		 pv[0] = 0;
		 pv[1] = 1;

		 TimeTable timeTable=new TimeTable();
		 listofAppts = timeTable.permute(listofAppts, pv);

		 assertEquals(appt.getStartMonth()+1, listofAppts.get(0).getStartMonth());

	 }

	 @Test
	public void test04() throws Throwable{

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
//add more unit tests as you needed
}