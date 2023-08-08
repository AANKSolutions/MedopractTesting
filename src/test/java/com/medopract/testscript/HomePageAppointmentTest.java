package com.medopract.testscript;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.medopract.generic.BaseClass;
import com.medopract.generic.FileLib;
import com.medopract.pom.HomePageAppointment;
import com.medopract.pom.LoginPage;


public class HomePageAppointmentTest extends BaseClass {

	Logger logger= LogManager.getLogger(HomePageAppointmentTest.class);
	String url;
	String un;
	String pw;
	String HomePageApp_Firstname1;
	String HomePageApp_Firstname2;
	String HomePageApp_Lastname;
	String HomePageApp_VisitReason1;
	String HomePageApp_VisitReason2;
	String HomePageApp_Phno1;
	String HomePageApp_Phno2;
	
	
	@BeforeClass
	public void openApplication() throws  IOException {
		driver= initializeDriver();
		 url = f.getPropertyData("url");
		 un = f.getPropertyData("un");
		 pw = f.getPropertyData("pw");
		 HomePageApp_Firstname1=f.getExcelData("HomePage Appointments", 1, 1);
		 HomePageApp_Firstname2=f.getExcelData("HomePage Appointments", 2, 1);
		 HomePageApp_Lastname=f.getExcelData("HomePage Appointments", 3, 1);
		 HomePageApp_VisitReason1= f.getExcelData("HomePage Appointments", 4, 1);
		 HomePageApp_VisitReason2= f.getExcelData("HomePage Appointments", 5, 1);
		 HomePageApp_Phno1= f.getExcelData("HomePage Appointments", 6, 1);
		 HomePageApp_Phno2= f.getExcelData("HomePage Appointments", 7, 1);
		 
		 
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
	
	@Test(priority = 1)
	public void addAppointmentWithoutData()  {	
		HomePageAppointment hpa = new HomePageAppointment(driver);
		hpa.getClickingSigns();
		logger.info("Clicked Sign");
		hpa.getAddAppointmentButton();
		logger.info("Clicked AddAppointment Button");
		
		String actual = null;
		try {
			if(hpa.geterrorMsg().isDisplayed())
				actual="success";
		}
		catch(Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, "success");
	}
	
	@Test(priority = 2)
	public void clickingMinusSign()  {	
		HomePageAppointment hpa = new HomePageAppointment(driver);
		hpa.getClickingSigns();
		logger.info("Clicked Sign");
		hpa.getClickingSigns();
		logger.info("Clicked Sign");
		hpa.getClickingSigns();
		logger.info("Again Clicked Sign");
	}
	
	@Test(priority = 3)
	public void addAppointmentWithoutVisitReason()  {	
		HomePageAppointment hpa = new HomePageAppointment(driver);
		hpa.getClickingSigns();
		logger.info("Clicked Plus");
		hpa.getNameField().sendKeys(HomePageApp_Firstname1);
		logger.info("Entered Name");
		hpa.getLastNameField().sendKeys(HomePageApp_Lastname);
		logger.info("Entered LastName");
		hpa.getMobileField().sendKeys(HomePageApp_Phno1);
		logger.info("Entered MobileNo");
		hpa.getAddAppointmentButton();
		logger.info("Clicked AddAppointment Button");
		
		String actual = null;
		try {
			if(hpa.geterrorMsg().isDisplayed())
				actual="success";
		}
		catch(Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, "success");
	}
	
	
     
	@Test(priority = 4)
	public void addAppointment()  {	
		HomePageAppointment hpa = new HomePageAppointment(driver);
		hpa.getVisitReasonField().sendKeys(HomePageApp_VisitReason1);
		logger.info("Entered VisitReason");
		hpa.getAddAppointmentButton();
		logger.info("Clicked AddAppointment Button");
		
		String actual="Appointment added Successfully";
		String expected=hpa.getNotification().getText();
		Assert.assertEquals(actual, expected);

		hpa.getcancelNotification();
		logger.info("Clicked Cancel Notification");
	}
	
	@Test(priority = 5)
	public void addAppointmentwithoutContactNo() {	
		HomePageAppointment hpa = new HomePageAppointment(driver);
		hpa.getNameField().sendKeys(HomePageApp_Firstname1);
		logger.info("Entered Name");
		hpa.getLastNameField().sendKeys(HomePageApp_Lastname);
		logger.info("Entered LastName");
		hpa.getVisitReasonField().sendKeys(HomePageApp_VisitReason1);
		logger.info("Entered VisitReason");
		hpa.getMobileField().clear();
		logger.info("Entered MobileNo");
		hpa.getAddAppointmentButton();
		logger.info("Clicked AddAppointment Button");
		
		String actual="Appointment added Successfully";
		String expected=hpa.getNotification().getText();
		Assert.assertEquals(actual, expected);

		hpa.getcancelNotification();
		logger.info("Clicked Cancel Notification");
	}


	@Test(priority = 6)
	public void EditExistingAppointment() {
		HomePageAppointment hpa = new HomePageAppointment(driver);
		hpa.getEditExistingAppointment();
		logger.info("clicked on Edit option");
		hpa.getNameField().clear();
		hpa.getNameField().sendKeys(HomePageApp_Firstname2);
		hpa.getMobileField().clear();
		hpa.getMobileField().sendKeys(HomePageApp_Phno2);
		hpa.getUpdateButton();
		logger.info("clicked on Update Button");
		
		String actual="Appointment Updated Successfully";
		String expected=hpa.getNotification().getText();
		Assert.assertEquals(actual, expected);

		hpa.getcancelNotification();
		logger.info("Clicked Cancel Notification");
	}
	
	


	@Test(priority = 7)
	public void ClickSMSReminder()  {
		HomePageAppointment hpa = new HomePageAppointment(driver);
		hpa.getSMSReminder();
		logger.info("Clicking on SMS Reminder");
		
		String actual="Reminder SMS Sent to : 9597277526";
		String expected=hpa.getNotification().getText();
		Assert.assertEquals(actual, expected);

		hpa.getcancelNotification();
		logger.info("Clicked Cancel Notification");
	}


	@Test(priority = 8)
	public void ClickAgainSMSReminder() {
		HomePageAppointment hpa = new HomePageAppointment(driver);
		hpa.getSMSReminder();
		logger.debug("Clicking again on SMS Reminder");
		
		String actual="SMS Not Sent: Reminder Already Sent";
		String expected=hpa.getNotification().getText();
		Assert.assertEquals(actual, expected);

		hpa.getcancelNotification();
		logger.info("Clicked Cancel Notification");
	}
	
	@Test(priority = 9)
	public void CancelAppointment() {
		HomePageAppointment hpa = new HomePageAppointment(driver);
		hpa.getCancelExistingAppointment();
		logger.info("Clicked on Cancel ");
		
		String actual="Appointment Cancelled successfully!";
		String expected=hpa.getNotification().getText();
		Assert.assertEquals(actual, expected);

		hpa.getcancelNotification();
		logger.info("Clicked Cancel Notification");
	}
	
	@AfterClass
	public void logout() {
		driver.close();
		logger.info("Closed Browser");
	}

}



