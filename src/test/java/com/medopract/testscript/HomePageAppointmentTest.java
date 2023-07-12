package com.medopract.testscript;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.medopract.generic.BaseClass;
import com.medopract.pom.HomePageAppointment;
import com.medopract.pom.LoginPage;


public class HomePageAppointmentTest extends BaseClass {


	@BeforeMethod
	public void openApplication() throws InterruptedException {
		driver=OpenBrowser();
		driver.manage().window().maximize();  
		driver.get("https://medopractapi-zk64betx7a-em.a.run.app/");
		logger.info("navigated to application URL");
		LoginPage l=new LoginPage(driver);
		l.getGotItButton().click();
		Thread.sleep(2000);
		l.getUsername().sendKeys("ashwinkv016"); 
		l.getPassword().sendKeys("ashwinkv016");
		Thread.sleep(2000);
		l.getSubmitButton().submit();
		Thread.sleep(4000);     

	}


	@Test(priority = 1)
	public void AddAppointment() throws InterruptedException {	
		HomePageAppointment hpa = new HomePageAppointment(driver);
		hpa.getClickingplus().click();
		logger.info("Clicked Plus ");
		hpa.getNameField().sendKeys("Ashwin");
		logger.info("Entered Name");
		Thread.sleep(2000);
		hpa.getLastNameField().sendKeys("Kumar");
		logger.info("Entered LastName");
		Thread.sleep(2000);
		hpa.getVisitReasonField().sendKeys("Gastric");
		logger.info("Entered VisitReason");
		Thread.sleep(2000);
		hpa.getMobileField().sendKeys("6382565718");
		logger.info("Entered MobileNo");
		Thread.sleep(2000);
		hpa.getAddAppointmentButton().click();
		logger.info("Clicked AddAppointment Button");
		Thread.sleep(3000);
	}


	@Test(priority = 6)
	public void CancelAppointment() throws InterruptedException {
		HomePageAppointment hpa = new HomePageAppointment(driver);
		hpa.getCancelExistingAppointment().click();
		logger.info("Clicked on Cancel ");
		Thread.sleep(2000);
	}


	@Test(priority = 2)
	public void EditExistingAppointment() throws InterruptedException {
		HomePageAppointment hpa = new HomePageAppointment(driver);
		hpa.getEditExistingAppointment().click();
		logger.info("clicked on Edit option");
		Thread.sleep(3000);
		hpa.getLastNameField().clear();
		Thread.sleep(3000);
		hpa.getLastNameField().sendKeys("AK");
		Thread.sleep(3000);
		hpa.getMobileField().clear();
		Thread.sleep(3000);
		hpa.getMobileField().sendKeys("9597277526");
		Thread.sleep(3000);
		hpa.getUpdateButton().click();
		logger.info("clicked on Update Button");
		Thread.sleep(3000);
	}


	@Test(priority = 3)
	public void ClickSMSReminder() throws InterruptedException {
		HomePageAppointment hpa = new HomePageAppointment(driver);
		hpa.getSMSReminder().click();
		logger.info("Clicking on SMS Reminder");
		Thread.sleep(3000);
	}


	@Test(priority = 4)
	public void ClickAgainSMSReminder() throws InterruptedException {
		HomePageAppointment hpa = new HomePageAppointment(driver);
		hpa.getClickingplus().click();
		logger.info("Clicked Plus Sign");
		hpa.getNameField().sendKeys("Ashwin");
		logger.debug("Entered Name");
		Thread.sleep(2000);
		hpa.getLastNameField().sendKeys("AK");
		logger.debug("Entered LastName");
		Thread.sleep(2000);
		hpa.getVisitReasonField().sendKeys("Gastric");
		logger.debug("Entered VisitReason");
		Thread.sleep(2000);
		hpa.getMobileField().sendKeys("9597277526");
		logger.debug("Entered MobileNo.");
		Thread.sleep(2000);
		hpa.getSMSReminder().click();
		logger.debug("Clicking again on SMS Reminder");
		Thread.sleep(3000);
	}



	@Test(priority = 5)
	public void EditingPhoneNumber() throws InterruptedException {
		HomePageAppointment hpa = new HomePageAppointment(driver);
		hpa.getEditExistingAppointment().click();
		logger.info("clicked on Edit option");
		Thread.sleep(3000);
		hpa.getMobileField().clear();
		Thread.sleep(3000);
		hpa.getMobileField().sendKeys("6382565718");
		logger.info("Entered MobileNo");
		Thread.sleep(2000);
		hpa.getUpdateButton().click();
		logger.info("clicked on Update Button");
		Thread.sleep(3000);
		hpa.getSMSReminder().click();
		logger.info("Clicking again on SMS Reminder");
		Thread.sleep(3000);
	}
	@AfterMethod
	public void CloseBrowser() {
		driver.close();
	}

}



