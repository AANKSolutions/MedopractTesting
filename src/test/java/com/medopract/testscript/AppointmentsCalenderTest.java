package com.medopract.testscript;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.medopract.generic.BaseClass;
import com.medopract.pom.AppointmentsCalenderPage;
import com.medopract.pom.LoginPage;

public class AppointmentsCalenderTest extends BaseClass {
	Logger logger= LogManager.getLogger(AppointmentsCalenderTest.class);
	String url;
	String un;
	String pw;
    String Appointments_FirstName1;
    String Appointments_FirstName2;
    String Appointments_LastName1;
	String Appointments_LastName2;
	String Appointments_VisitReason1;
	String Appointments_VisitReason2;
	String Appointments_VisitReason3;
	String Appointments_Phno1;
	String Appointments_Phno2;
	
	
	@BeforeClass
	public void OpenApplication() throws IOException, InterruptedException {
		driver= initializeDriver();
		
		 url = f.getPropertyData("url");
		 un = f.getPropertyData("un");
		 pw = f.getPropertyData("pw");
		 Appointments_FirstName1=f.getExcelData("Appointments Calender", 1, 1);
		 Appointments_FirstName2=f.getExcelData("Appointments Calender", 2, 1);
		 Appointments_LastName1=f.getExcelData("Appointments Calender", 3, 1);
		 Appointments_LastName2=f.getExcelData("Appointments Calender", 4, 1);
		 Appointments_VisitReason1=f.getExcelData("Appointments Calender", 5, 1);
		 Appointments_VisitReason2=f.getExcelData("Appointments Calender", 6, 1);
		 Appointments_VisitReason3=f.getExcelData("Appointments Calender", 7, 1);
		 Appointments_Phno1=f.getExcelData("Appointments Calender", 8, 1);
		 Appointments_Phno2=f.getExcelData("Appointments Calender", 9, 1);
	    
		   
		driver.get(url);
		logger.info("Navigated to Application URL");

		LoginPage l=new LoginPage(driver);
		l.getGotItButton();
		l.setUsername(un); 
		logger.info("Entered UserName Field");
		l.setPassword(pw);
		logger.info("Entered Password Field");
		l.getSubmitButton();
		logger.info("Clicked Submit Button");
		//Thread.sleep(2000);
		String actual = null;
		try {
			if(l.getaccInfo().isDisplayed())
				actual="success";
		}
		catch(Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, "success");
	}

	@Test(priority=1)
	public void AddAppointmentsCalender()  {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage(driver);
		acp.getClickAppointmentCalender();
		logger.info("Clicked Appointment Calender");
		acp.getNewAppointment();
		logger.info("Clicked New Appointment");
		acp.getFirstNameField().sendKeys(Appointments_FirstName1);
		logger.info("Entered FirstName Field");
		acp.getLastNameField().sendKeys(Appointments_LastName1);
		logger.info("Entered LastName Field");
		acp.getVisitreasonField().sendKeys(Appointments_VisitReason1);
		logger.info("Entered VisitReason Field");
		acp.getContactNumberField().sendKeys(Appointments_Phno1);
		logger.info("Entered ContactNumber Field");
		acp.getdateAndTimeField();
		logger.info("Clicked DateAndTime Field");
		acp.getdatePick();
		acp.gettimePick();
		acp.getDurationField();
		logger.info("Clicked Duration Field");
		acp.getSaveAppointmentButton();
		logger.info("Clicked SaveAppointment Field");
		
		String expectedResult="Appointment added Successfully";
		String actualResult=acp.getsuccessMsg().getText();
		Assert.assertEquals(actualResult, expectedResult);
		
		acp.getcancelNotification();
		logger.info("Clicked Cancel Notification");
	}
	
	@Test(priority=2)
	public void AddAppointmentWithoutName()  {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage(driver);
		acp.getNewAppointment();
		logger.info("Clicked New Appointment");
		acp.getVisitreasonField().sendKeys(Appointments_VisitReason1);
		logger.info("Entered VisitReason Field");
		acp.getContactNumberField().sendKeys(Appointments_Phno1);
		logger.info("Entered ContactNumber Field");
		acp.getdateAndTimeField();
		logger.info("Clicked DateAndTime Field");
		acp.getdatePick();
		acp.gettimePick();
		acp.getDurationField();
		logger.info("Clicked Duration Field");
		acp.getSaveAppointmentButton();
		logger.info("Clicked SaveAppointment Field");
		
		String expectedResult="something went wrong!";
		String actualResult=acp.geterrorMsg().getText();
		Assert.assertEquals(actualResult, expectedResult);
		
		acp.getcancelNotification();
		logger.info("Clicked Cancel Notification");
	}
	
	@Test(priority =3)
	public void AddAppointmentWithoutVisitReason()  {
	AppointmentsCalenderPage acp=new AppointmentsCalenderPage(driver);
	acp.getNewAppointment();
	logger.info("Clicked New Appointment");
	acp.getFirstNameField().sendKeys(Appointments_FirstName1);
	logger.info("Entered FirstName Field");
	acp.getLastNameField().sendKeys(Appointments_LastName1);
	logger.info("Entered LastName Field");
	acp.getContactNumberField().sendKeys(Appointments_Phno1);
	logger.info("Entered ContactNumber Field");
	acp.getdateAndTimeField();
	logger.info("Clicked DateAndTime Field");
	acp.getdatePick();
	acp.gettimePick();
	acp.getDurationField();
	logger.info("Clicked Duration Field");
	acp.getSaveAppointmentButton();
	logger.info("Clicked SaveAppointment Field");

	String expectedResult="something went wrong!";
	String actualResult=acp.geterrorMsg().getText();
	Assert.assertEquals(actualResult, expectedResult);
	
	acp.getcancelNotification();
	logger.info("Clicked Cancel Notification");
	}

	@Test(priority=4)
	public void addPatientWithoutContactNo()  {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage(driver);
		acp.getNewAppointment();
		logger.info("Clicked New Appointment");
		acp.getFirstNameField().sendKeys(Appointments_FirstName1);
		logger.info("Entered FirstName Field");
		acp.getLastNameField().sendKeys(Appointments_LastName1);
		logger.info("Entered LastName Field");
		acp.getVisitreasonField().sendKeys(Appointments_VisitReason1);
		logger.info("Entered VisitReason Field");
		acp.getdateAndTimeField();
		logger.info("Clicked DateAndTime Field");
		acp.getdatePick();
		acp.gettimePick();
		acp.getDurationField();
		logger.info("Clicked Duration Field");
		acp.getSaveAppointmentButton();
		logger.info("Clicked SaveAppointment Field");

		String expectedResult="Appointment added Successfully";
		String actualResult=acp.getsuccessMsg().getText();
		Assert.assertEquals(actualResult, expectedResult);
		
		acp.getcancelNotification();
		logger.info("Clicked Cancel Notification");
	}
	
	@Test(priority=5)
	public void updateWithInvaliedData()  {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage(driver);
		acp.getUpdatedExistingAppointment();
		logger.info("Clicked ExistingAppointment Field");
		acp.getFirstNameField().clear();
		logger.info("Cleared First Name Field");
		acp.getLastNameField().clear();
		logger.info("Cleared Last Name Field");
		acp.getVisitreasonField().clear();
		logger.info("Cleared Visit Reason Field");
		acp.getContactNumberField().clear();
		logger.info("Cleared ContactNo Field");
		acp.getDurationField();
		logger.info("Clicked Duration Field");
		acp.getSaveAppointmentButton();
		logger.info("Clicked SaveAppointment Button");
		
		String expectedResult="Appointment Updated Successfully";
		String actualResult=acp.getupdateSuccessMsg().getText();
		Assert.assertEquals(actualResult, expectedResult);
		
		acp.getcancelNotification();
		logger.info("Clicked Cancel Notification");
	}
	

	@Test(priority=6)
	public void updateAppointmentWithValidData()  {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage(driver);
		acp.getUpdatedExistingAppointment();
		logger.info("Clicked ExistingAppointment");
		acp.getFirstNameField().clear();
		acp.getFirstNameField().sendKeys(Appointments_FirstName2);
		logger.info("Entered FirstName Field");
		acp.getLastNameField().clear();
		acp.getLastNameField().sendKeys(Appointments_LastName2);
		logger.info("Entered LastName Field");
		acp.getVisitreasonField().clear();
		acp.getVisitreasonField().sendKeys(Appointments_VisitReason2);
		logger.info("Entered VisitReason Field");
		acp.getContactNumberField().clear();
		acp.getContactNumberField().sendKeys(Appointments_Phno2);
		logger.info("Entered ContactNo Field");
		acp.getDurationField();
		logger.info("Entered Duration Field");
		acp.getSaveAppointmentButton();
		logger.info("Clicked SaveAppointment Button");
		
		String expectedResult="Appointment Updated Successfully";
		String actualResult=acp.getupdateSuccessMsg().getText();
		Assert.assertEquals(actualResult, expectedResult);
		
		acp.getcancelNotification();
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority=7)
	public void existingAppointmentInMonth()  {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage(driver);
		acp.getMonthButton();
		acp.getExistingAppointment();
		logger.info("Clicked ExistingAppointment");
		acp.getcancelExistingAppointment();
		logger.info("Clicked Cancel ExistingAppointment");
		acp.getExistingAppointment();
		logger.info("Clicked ExistingAppointment");
		acp.getVisitreasonField().clear();
		acp.getVisitreasonField().sendKeys(Appointments_VisitReason1);
		logger.info("Entered VisitReason Field");
		acp.getSaveAppointmentButton();
		logger.info("Clicked Save Button");
		acp.getmonthBackButton();
		acp.getmonthNextButton();
		acp.getExistingAppointment();
		acp.getcancelExistingAppointment();
		acp.getmonthTodayButton();
		
	}
	
	@Test(priority=8)
	public void existingAppointmentInWeek()  {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage(driver);
		acp.getWeekButton();
		acp.getExistingAppointment();
		logger.info("Clicked ExistingAppointment");
		acp.getVisitreasonField().clear();
		acp.getVisitreasonField().sendKeys(Appointments_VisitReason2);
		logger.info("Entered Visit Reason");
		acp.getSaveAppointmentButton();
		logger.info("Clicked Save Button");
		acp.getweekBackButton();
		acp.getweekBackButton();
		acp.getweekNextButton();
		acp.getExistingAppointment();
		logger.info("Clicked ExistingAppointment");
		acp.getcancelExistingAppointment();
		logger.info("Clicked Cancel ExistingAppointment");
		acp.getweekTodayButton();
	}
	
	@Test(priority=9)
	public void existingAppointmentInDay()  {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage(driver);
		acp.getDayButton();
		acp.getExistingAppointment();
		logger.info("Clicked ExistingAppointment");
		acp.getcancelExistingAppointment();
		logger.info("Clicked Cancel ExistingAppointment");
		acp.getdayBackButton();
		acp.getdayBackButton();
		acp.getdayBackButton();
		acp.getdayNextButton();
		acp.getdayBackButton();
		acp.getdayNextButton();
		acp.getdayNextButton();
		acp.getExistingAppointment();
		logger.info("Clicked ExistingAppointment");
		acp.getcancelExistingAppointment();
		logger.info("Clicked Cancel ExistingAppointment");
		acp.getdayTodayButton();
	}
	
	@Test(priority=10)
	public void agenda()  {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage(driver);
		acp.getAgendaButton();
		acp.getagendaExistingAppointment().click();
		logger.info("Clicked Agenda ExistingAppointment");
		acp.getcancelExistingAppointment();
		logger.info("Clicked Cancel ExistingAppointment");
		acp.getBackAgendaButton();
		acp.getNextAgendaButton();
		acp.getNextAgendaButton();
		acp.getTodayAgendaButton();
	}

	@AfterClass
	public void logout() {
		driver.close();
		logger.info("Closed Browser");
	}
	
	
}
