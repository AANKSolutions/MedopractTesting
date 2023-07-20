package com.medopract.testscript;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.medopract.generic.BaseClass;
import com.medopract.pom.AppointmentsCalenderPage;
import com.medopract.pom.LoginPage;

public class AppointmentsCalenderTest extends BaseClass {
	
	@BeforeClass
	public void OpenApplication() throws InterruptedException {
		driver= OpenBrowser();
		driver.manage().window().maximize();
		driver.get("https://medopractapi-zk64betx7a-em.a.run.app/");
		logger.info("Navigated to Application URL");
		Thread.sleep(2000);

		LoginPage l=new LoginPage(driver);
		l.getGotItButton().click();
		Thread.sleep(2000);
		l.getUsername().sendKeys("ashwinkv016"); 
		logger.info("Entered UserName Field");
		l.getPassword().sendKeys("ashwinkv016");
		logger.info("Entered Password Field");
		Thread.sleep(2000);
		l.getSubmitButton().submit();
		logger.info("Clicked Submit Button");
		Thread.sleep(4000);
		
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
	public void AddAppointmentsCalender() throws InterruptedException {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage(driver);
		acp.getClickAppointmentCalender().click();
		Thread.sleep(3000);
		logger.info("Clicked Appointment Calender");
		acp.getNewAppointment().click();
		Thread.sleep(4000);
		logger.info("Clicked New Appointment");
		acp.getFirstNameField().sendKeys("Ashwin");
		Thread.sleep(2000);
		logger.info("Entered FirstName Field");
		acp.getLastNameField().sendKeys("Kumar");
		Thread.sleep(2000);
		logger.info("Entered LastName Field");
		acp.getVisitreasonField().sendKeys("Fever");
		Thread.sleep(2000);
		logger.info("Entered VisitReason Field");
		acp.getContactNumberField().sendKeys("9597277526");
		Thread.sleep(2000);
		logger.info("Entered ContactNumber Field");
		acp.getdateAndTimeField().click();
		Thread.sleep(2000);
		logger.info("Clicked DateAndTime Field");
		acp.getdatePick().click();
		Thread.sleep(2000);
		acp.gettimePick().click();
		Thread.sleep(2000);
		acp.getDurationField().click();
		Thread.sleep(2000);
		logger.info("Clicked Duration Field");
		acp.getSaveAppointmentButton().click();
		Thread.sleep(2000);
		logger.info("Clicked SaveAppointment Field");
		
		String expectedResult="Appointment added Successfully";
		String actualResult=acp.getsuccessMsg().getText();
		Assert.assertEquals(actualResult, expectedResult);
		
		acp.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");
	}
	
	@Test(priority=2)
	public void AddAppointmentWithoutName() throws InterruptedException {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage(driver);
		acp.getNewAppointment().click();
		Thread.sleep(4000);
		logger.info("Clicked New Appointment");
		acp.getVisitreasonField().sendKeys("Fever");
		Thread.sleep(2000);
		logger.info("Entered VisitReason Field");
		acp.getContactNumberField().sendKeys("9597277526");
		Thread.sleep(2000);
		logger.info("Entered ContactNumber Field");
		acp.getdateAndTimeField().click();
		Thread.sleep(2000);
		logger.info("Clicked DateAndTime Field");
		acp.getdatePick().click();
		Thread.sleep(2000);
		acp.gettimePick().click();
		Thread.sleep(2000);
		acp.getDurationField().click();
		Thread.sleep(2000);
		logger.info("Clicked Duration Field");
		acp.getSaveAppointmentButton().click();
		Thread.sleep(2000);
		logger.info("Clicked SaveAppointment Field");
		
		String expectedResult="something went wrong!";
		String actualResult=acp.geterrorMsg().getText();
		Assert.assertEquals(actualResult, expectedResult);
		
		acp.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");
	}
	
	@Test(priority =3)
	public void AddAppointmentWithoutVisitReason() throws InterruptedException {
	AppointmentsCalenderPage acp=new AppointmentsCalenderPage(driver);
	
	acp.getNewAppointment().click();
	Thread.sleep(4000);
	logger.info("Clicked Appointment Calender");
	acp.getNewAppointment().click();
	Thread.sleep(4000);
	logger.info("Clicked New Appointment");
	acp.getFirstNameField().sendKeys("Ashwin");
	Thread.sleep(2000);
	logger.info("Entered FirstName Field");
	acp.getLastNameField().sendKeys("Kumar");
	Thread.sleep(2000);
	logger.info("Entered LastName Field");
	acp.getContactNumberField().sendKeys("9597277526");
	Thread.sleep(2000);
	logger.info("Entered ContactNumber Field");
	acp.getdateAndTimeField().click();
	Thread.sleep(2000);
	logger.info("Clicked DateAndTime Field");
	acp.getdatePick().click();
	Thread.sleep(2000);
	acp.gettimePick().click();
	Thread.sleep(2000);
	acp.getDurationField().click();
	Thread.sleep(2000);
	logger.info("Clicked Duration Field");
	acp.getSaveAppointmentButton().click();
	Thread.sleep(2000);
	logger.info("Clicked SaveAppointment Field");

	String expectedResult="something went wrong!";
	String actualResult=acp.geterrorMsg().getText();
	Assert.assertEquals(actualResult, expectedResult);
	
	acp.getcancelNotification().click();
	Thread.sleep(2000);
	logger.info("Clicked Cancel Notification");
	}
	
	@Test(priority=4)
	public void addPatientWithoutContactNo() throws InterruptedException {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage(driver);
		acp.getNewAppointment().click();
		Thread.sleep(4000);
		logger.info("Clicked New Appointment");
		acp.getFirstNameField().sendKeys("Ashwin");
		Thread.sleep(2000);
		logger.info("Entered FirstName Field");
		acp.getLastNameField().sendKeys("Kumar");
		Thread.sleep(2000);
		logger.info("Entered LastName Field");
		acp.getVisitreasonField().sendKeys("Fever");
		Thread.sleep(2000);
		logger.info("Entered VisitReason Field");
		acp.getdateAndTimeField().click();
		Thread.sleep(2000);
		logger.info("Clicked DateAndTime Field");
		acp.getdatePick().click();
		Thread.sleep(2000);
		acp.gettimePick().click();
		Thread.sleep(2000);
		acp.getDurationField().click();
		Thread.sleep(2000);
		logger.info("Clicked Duration Field");
		acp.getSaveAppointmentButton().click();
		Thread.sleep(2000);
		logger.info("Clicked SaveAppointment Field");

		String expectedResult="Appointment added Successfully";
		String actualResult=acp.getsuccessMsg().getText();
		Assert.assertEquals(actualResult, expectedResult);
		
		acp.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");
	}
	
	@Test(priority=5)
	public void updateWithInvaliedData() throws InterruptedException {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage(driver);
		acp.getUpdatedExistingAppointment().click();
		Thread.sleep(2000);
		logger.info("Clicked ExistingAppointment Field");
		acp.getFirstNameField().clear();
		Thread.sleep(2000);
		logger.info("Cleared First Name Field");
		acp.getLastNameField().clear();
		Thread.sleep(2000);
		logger.info("Cleared Last Name Field");
		acp.getVisitreasonField().clear();
		Thread.sleep(2000);
		logger.info("Cleared Visit Reason Field");
		acp.getContactNumberField().clear();
		Thread.sleep(2000);
		logger.info("Cleared ContactNo Field");
		acp.getDurationField().click();
		Thread.sleep(2000);
		logger.info("Clicked Duration Field");
		acp.getSaveAppointmentButton().click();
		Thread.sleep(3000);
		logger.info("Clicked SaveAppointment Button");
		
		String expectedResult="Appointment Updated Successfully";
		String actualResult=acp.getupdateSuccessMsg().getText();
		Assert.assertEquals(actualResult, expectedResult);
		
		acp.getcancelNotification().click();
		Thread.sleep(4000);
		logger.info("Clicked Cancel Notification");
	}
	

	@Test(priority=6)
	public void updateAppointmentWithValidData() throws InterruptedException {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage(driver);
		acp.getUpdatedExistingAppointment().click();
		Thread.sleep(2000);
		logger.info("Clicked ExistingAppointment");
		acp.getFirstNameField().clear();
		Thread.sleep(1000);
		acp.getFirstNameField().sendKeys("Niteesh");
		Thread.sleep(2000);
		logger.info("Entered FirstName Field");
		acp.getLastNameField().clear();
		Thread.sleep(1000);
		acp.getLastNameField().sendKeys("NK");
		Thread.sleep(2000);
		logger.info("Entered LastName Field");
		acp.getVisitreasonField().clear();
		Thread.sleep(1000);
		acp.getVisitreasonField().sendKeys("Kidney Stone");
		Thread.sleep(2000);
		logger.info("Entered VisitReason Field");
		acp.getContactNumberField().clear();
		Thread.sleep(1000);
		acp.getContactNumberField().sendKeys("6382565718");
		Thread.sleep(2000);
		logger.info("Entered ContactNo Field");
		acp.getDurationField().click();
		Thread.sleep(2000);
		logger.info("Entered Duration Field");
		acp.getSaveAppointmentButton().click();
		Thread.sleep(2000);
		logger.info("Clicked SaveAppointment Button");
		
		String expectedResult="Appointment Updated Successfully";
		String actualResult=acp.getupdateSuccessMsg().getText();
		Assert.assertEquals(actualResult, expectedResult);
		
		acp.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority=7)
	public void existingAppointmentInMonth() throws InterruptedException {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage(driver);
		acp.getMonthButton().click();
		Thread.sleep(2000);
		acp.getExistingAppointment().click();
		Thread.sleep(2000);
		logger.info("Clicked ExistingAppointment");
		acp.getcancelExistingAppointment().click();
		Thread.sleep(4000);
		logger.info("Clicked Cancel ExistingAppointment");
		acp.getExistingAppointment().click();
		Thread.sleep(2000);
		logger.info("Clicked ExistingAppointment");
		acp.getVisitreasonField().clear();
		Thread.sleep(1000);
		acp.getVisitreasonField().sendKeys("Stomach Pain");
		Thread.sleep(2000);
		logger.info("Entered VisitReason Field");
		acp.getSaveAppointmentButton().click();
		Thread.sleep(3000);
		logger.info("Clicked Save Button");
		acp.getmonthBackButton().click();
		Thread.sleep(3000);
		acp.getmonthNextButton().click();
		Thread.sleep(3000);
		acp.getExistingAppointment().click();
		Thread.sleep(2000);
		acp.getcancelExistingAppointment().click();
		Thread.sleep(4000);
		acp.getmonthTodayButton().click();
		Thread.sleep(3000);
		
	}
	
	@Test(priority=8)
	public void existingAppointmentInWeek() throws InterruptedException {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage(driver);
		acp.getWeekButton().click();
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		acp.getExistingAppointment().click();
		Thread.sleep(2000);
		logger.info("Clicked ExistingAppointment");
		acp.getVisitreasonField().clear();
		acp.getVisitreasonField().sendKeys("Throat infection");
		Thread.sleep(2000);
		logger.info("Entered Visit Reason");
		acp.getSaveAppointmentButton().click();
		Thread.sleep(2000);
		logger.info("Clicked Save Button");
		acp.getweekBackButton().click();
		Thread.sleep(2000);
		acp.getweekBackButton().click();
		Thread.sleep(2000);
		acp.getweekNextButton().click();
		j.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		acp.getExistingAppointment().click();
		Thread.sleep(2000);
		logger.info("Clicked ExistingAppointment");
		acp.getcancelExistingAppointment().click();
		Thread.sleep(4000);
		logger.info("Clicked Cancel ExistingAppointment");
		acp.getweekTodayButton().click();
		Thread.sleep(2000);
	}
	
	@Test(priority=9)
	public void existingAppointmentInDay() throws InterruptedException {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage(driver);
		acp.getDayButton().click();
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		acp.getExistingAppointment().click();
		Thread.sleep(2000);
		logger.info("Clicked ExistingAppointment");
		acp.getcancelExistingAppointment().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel ExistingAppointment");
		acp.getdayBackButton().click();
		Thread.sleep(2000);
		acp.getdayBackButton().click();
		Thread.sleep(2000);
		acp.getdayBackButton().click();
		Thread.sleep(2000);
		acp.getdayNextButton().click();
		Thread.sleep(2000);
		acp.getdayBackButton().click();
		Thread.sleep(2000);
		acp.getdayNextButton().click();
		Thread.sleep(2000);
		acp.getdayNextButton().click();
		Thread.sleep(2000);
		acp.getExistingAppointment().click();
		Thread.sleep(2000);
		logger.info("Clicked ExistingAppointment");
		acp.getcancelExistingAppointment().click();
		Thread.sleep(4000);
		logger.info("Clicked Cancel ExistingAppointment");
		acp.getdayTodayButton().click();
		Thread.sleep(2000);
	}
	
	@Test(priority=10)
	public void agenda() throws InterruptedException {
		AppointmentsCalenderPage acp=new AppointmentsCalenderPage(driver);
		acp.getAgendaButton().click();
		Thread.sleep(2000);
		acp.getagendaExistingAppointment().click();
		Thread.sleep(2000);
		logger.info("Clicked Agenda ExistingAppointment");
		acp.getcancelExistingAppointment().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel ExistingAppointment");
		acp.getBackAgendaButton().click();
		Thread.sleep(2000);
		acp.getNextAgendaButton().click();
		Thread.sleep(2000);
		acp.getNextAgendaButton().click();
		Thread.sleep(2000);
		acp.getTodayAgendaButton().click();
		Thread.sleep(2000);
	}

	@AfterClass
	public void logout() {
		driver.close();
		logger.info("Closed Browser");
	}
	
	
}
