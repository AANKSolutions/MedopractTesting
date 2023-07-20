package com.medopract.testscript;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.medopract.generic.BaseClass;
import com.medopract.pom.HomePageAppointment;
import com.medopract.pom.LoginPage;


public class HomePageAppointmentTest extends BaseClass {


	@BeforeClass
	public void openApplication() throws InterruptedException {
		driver=OpenBrowser();
		driver.manage().window().maximize();  
		driver.get("https://medopractapi-zk64betx7a-em.a.run.app/");
		logger.info("navigated to application URL");
		
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
	
	@Test(priority = 1)
	public void addAppointmentWithoutData() throws InterruptedException {	
		HomePageAppointment hpa = new HomePageAppointment(driver);
		hpa.getClickingSigns().click();
		logger.info("Clicked Sign");
		Thread.sleep(3000);
		hpa.getAddAppointmentButton().click();
		logger.info("Clicked AddAppointment Button");
		Thread.sleep(3000);
		
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
	public void clickingMinusSign() throws InterruptedException {	
		HomePageAppointment hpa = new HomePageAppointment(driver);
		hpa.getClickingSigns().click();
		logger.info("Clicked Sign");
		Thread.sleep(3000);
		hpa.getClickingSigns().click();
		logger.info("Clicked Sign");
		Thread.sleep(3000);
		hpa.getClickingSigns().click();
		logger.info("Again Clicked Sign");
		Thread.sleep(3000);
	}
	
	@Test(priority = 3)
	public void addAppointmentWithoutVisitReason() throws InterruptedException {	
		HomePageAppointment hpa = new HomePageAppointment(driver);
		hpa.getClickingSigns().click();
		logger.info("Clicked Plus");
		hpa.getNameField().sendKeys("Ak");
		logger.info("Entered Name");
		Thread.sleep(2000);
		hpa.getLastNameField().sendKeys("Kumar");
		logger.info("Entered LastName");
		Thread.sleep(2000);
		hpa.getMobileField().sendKeys("6382565718");
		logger.info("Entered MobileNo");
		Thread.sleep(2000);
		hpa.getAddAppointmentButton().click();
		logger.info("Clicked AddAppointment Button");
		Thread.sleep(3000);
		
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
	public void addAppointment() throws InterruptedException {	
		HomePageAppointment hpa = new HomePageAppointment(driver);
		hpa.getVisitReasonField().sendKeys("Gastric");
		logger.info("Entered VisitReason");
		Thread.sleep(2000);
		hpa.getAddAppointmentButton().click();
		logger.info("Clicked AddAppointment Button");
		Thread.sleep(3000);
	}
	
	@Test(priority = 5)
	public void addAppointmentwithoutContactNo() throws InterruptedException {	
		HomePageAppointment hpa = new HomePageAppointment(driver);
		hpa.getNameField().sendKeys("Ak");
		logger.info("Entered Name");
		Thread.sleep(2000);
		hpa.getLastNameField().sendKeys("Kumar");
		logger.info("Entered LastName");
		Thread.sleep(2000);
		hpa.getVisitReasonField().sendKeys("Gastric");
		logger.info("Entered VisitReason");
		Thread.sleep(2000);
		hpa.getMobileField().clear();
		logger.info("Entered MobileNo");
		Thread.sleep(2000);
		hpa.getAddAppointmentButton().click();
		logger.info("Clicked AddAppointment Button");
		Thread.sleep(3000);
		
		String actual="Appointment added Successfully";
		String expected=hpa.getNotification().getText();
		Assert.assertEquals(actual, expected);

		hpa.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");
	}


	@Test(priority = 6)
	public void EditExistingAppointment() throws InterruptedException {
		HomePageAppointment hpa = new HomePageAppointment(driver);
		hpa.getEditExistingAppointment().click();
		logger.info("clicked on Edit option");
		Thread.sleep(3000);
		hpa.getNameField().clear();
		Thread.sleep(1000);
		hpa.getNameField().sendKeys("Ashwin");
		Thread.sleep(3000);
		hpa.getMobileField().clear();
		Thread.sleep(1000);
		hpa.getMobileField().sendKeys("9597277526");
		Thread.sleep(3000);
		hpa.getUpdateButton().click();
		logger.info("clicked on Update Button");
		Thread.sleep(3000);
		
		String actual="Appointment Updated Successfully";
		String expected=hpa.getNotification().getText();
		Assert.assertEquals(actual, expected);

		hpa.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");
	}
	
	


	@Test(priority = 7)
	public void ClickSMSReminder() throws InterruptedException {
		HomePageAppointment hpa = new HomePageAppointment(driver);
		hpa.getSMSReminder().click();
		logger.info("Clicking on SMS Reminder");
		Thread.sleep(3000);
		
		String actual="Reminder SMS Sent to : 9597277526";
		String expected=hpa.getNotification().getText();
		Assert.assertEquals(actual, expected);

		hpa.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");
	}


	@Test(priority = 8)
	public void ClickAgainSMSReminder() throws InterruptedException {
		HomePageAppointment hpa = new HomePageAppointment(driver);
		hpa.getSMSReminder().click();
		logger.debug("Clicking again on SMS Reminder");
		Thread.sleep(3000);
		
		String actual="SMS Not Sent: Reminder Already Sent";
		String expected=hpa.getNotification().getText();
		Assert.assertEquals(actual, expected);

		hpa.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");
	}
	
	@Test(priority = 9)
	public void CancelAppointment() throws InterruptedException {
		HomePageAppointment hpa = new HomePageAppointment(driver);
		hpa.getCancelExistingAppointment().click();
		logger.info("Clicked on Cancel ");
		Thread.sleep(2000);
		
		String actual="Appointment Cancelled successfully!";
		String expected=hpa.getNotification().getText();
		Assert.assertEquals(actual, expected);

		hpa.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");
	}
	
	@AfterClass
	public void logout() {
		driver.close();
		logger.info("Closed Browser");
	}

}



