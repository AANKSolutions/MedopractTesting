package com.medopract.testscript;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.medopract.generic.BaseClass;
import com.medopract.pom.AppointmentsCalenderPage;
import com.medopract.pom.LoginPage;

public class AppointmentsCalenderTest extends BaseClass {
	Logger logger= LogManager.getLogger(AppointmentsCalenderTest.class);
	
	
	@BeforeClass
	public void OpenApplication() throws IOException, InterruptedException {
		   
		 driver= initializeDriver(); 
			driver.get(getPropertyData("url"));
			logger.info("Navigated to Application URL");
	        base=new BaseClass();
			LoginPage l=new LoginPage(driver);
			l.getGotItButton();
			l.setUsername(getPropertyData("un")); 
			logger.info("Entered UserName Field");
			l.setPassword(getPropertyData("pw"));
			logger.info("Entered Password Field");
			l.getSubmitButton();
			logger.info("Clicked Submit Button");
	         
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
	public void AddAppointmentsCalender() throws EncryptedDocumentException, IOException  {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage(driver);
		acp.getClickAppointmentCalender();
		logger.info("Clicked Appointment Calender");
		acp.getNewAppointment();
		logger.info("Clicked New Appointment");
		acp.getFirstNameField().sendKeys(getExcelData("Appointments Calender", 1, 1));
		logger.info("Entered FirstName Field");
		acp.getLastNameField().sendKeys(getExcelData("Appointments Calender", 3, 1));
		logger.info("Entered LastName Field");
		acp.getVisitreasonField().sendKeys(getExcelData("Appointments Calender", 5, 1));
		logger.info("Entered VisitReason Field");
		acp.getContactNumberField().sendKeys(getExcelData("Appointments Calender", 8, 1));
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
	public void AddAppointmentWithoutName() throws EncryptedDocumentException, IOException  {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage(driver);
		acp.getNewAppointment();
		logger.info("Clicked New Appointment");
		acp.getVisitreasonField().sendKeys(getExcelData("Appointments Calender", 5, 1));
		logger.info("Entered VisitReason Field");
		acp.getContactNumberField().sendKeys(getExcelData("Appointments Calender", 8, 1));
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
	public void AddAppointmentWithoutVisitReason() throws EncryptedDocumentException, IOException  {
	AppointmentsCalenderPage acp=new AppointmentsCalenderPage(driver);
	acp.getNewAppointment();
	logger.info("Clicked New Appointment");
	acp.getFirstNameField().sendKeys(getExcelData("Appointments Calender", 1, 1));
	logger.info("Entered FirstName Field");
	acp.getLastNameField().sendKeys(getExcelData("Appointments Calender", 3, 1));
	logger.info("Entered LastName Field");
	acp.getContactNumberField().sendKeys(getExcelData("Appointments Calender", 8, 1));
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
	public void addPatientWithoutContactNo() throws EncryptedDocumentException, IOException  {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage(driver);
		acp.getNewAppointment();
		logger.info("Clicked New Appointment");
		acp.getFirstNameField().sendKeys(getExcelData("Appointments Calender", 1, 1));
		logger.info("Entered FirstName Field");
		acp.getLastNameField().sendKeys(getExcelData("Appointments Calender", 3, 1));
		logger.info("Entered LastName Field");
		acp.getVisitreasonField().sendKeys(getExcelData("Appointments Calender", 5, 1));
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
	public void updateAppointmentWithValidData() throws EncryptedDocumentException, IOException  {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage(driver);
		acp.getUpdatedExistingAppointment();
		logger.info("Clicked ExistingAppointment");
		acp.getFirstNameField().clear();
		acp.getFirstNameField().sendKeys(getExcelData("Appointments Calender", 2, 1));
		logger.info("Entered FirstName Field");
		acp.getLastNameField().clear();
		acp.getLastNameField().sendKeys(getExcelData("Appointments Calender", 4, 1));
		logger.info("Entered LastName Field");
		acp.getVisitreasonField().clear();
		acp.getVisitreasonField().sendKeys(getExcelData("Appointments Calender", 6, 1));
		logger.info("Entered VisitReason Field");
		acp.getContactNumberField().clear();
		acp.getContactNumberField().sendKeys(getExcelData("Appointments Calender", 9, 1));
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
	public void existingAppointmentInMonth() throws EncryptedDocumentException, IOException  {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage(driver);
		acp.getMonthButton();
		acp.getExistingAppointment();
		logger.info("Clicked ExistingAppointment");
		acp.getcancelExistingAppointment();
		logger.info("Clicked Cancel ExistingAppointment");
		acp.getExistingAppointment();
		logger.info("Clicked ExistingAppointment");
		acp.getVisitreasonField().clear();
		acp.getVisitreasonField().sendKeys(getExcelData("Appointments Calender", 5, 1));
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
	public void existingAppointmentInWeek() throws EncryptedDocumentException, IOException  {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage(driver);
		acp.getWeekButton();
		acp.getExistingAppointment();
		logger.info("Clicked ExistingAppointment");
		acp.getVisitreasonField().clear();
		acp.getVisitreasonField().sendKeys(getExcelData("Appointments Calender", 6, 1));
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
