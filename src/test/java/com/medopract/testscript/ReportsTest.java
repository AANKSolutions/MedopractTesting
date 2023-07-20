package com.medopract.testscript;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.medopract.generic.BaseClass;
import com.medopract.pom.AddPatientPage;
import com.medopract.pom.LoginPage;
import com.medopract.pom.ReportsPage;

public class ReportsTest extends BaseClass{

	@BeforeClass
	public void OpenApplication() throws InterruptedException {
		driver=OpenBrowser();
		driver.manage().window().maximize();  
		driver.get("https://medopractapi-zk64betx7a-em.a.run.app/");
		logger.info("Navigated to Application URL"); 

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
		Thread.sleep(2000);   

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
	public void PatientsTab() throws Exception {
		ReportsPage rp = new ReportsPage(driver);
		rp.getClickReports().click();
		Thread.sleep(3000);
		logger.info("Clicked on Reports");
		rp.getPatientsTab().click();
		logger.info("Clicked On Patients Tab");
		Thread.sleep(1000);
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,250)");
		Thread.sleep(3000);
		rp.getYearlyTab().click();
		logger.info("Clicked on Yearly Tab");
		Thread.sleep(3000);
		rp.getDailyTab().click();
		logger.info("Clicked on Daily Tab");
		Thread.sleep(3000);
		rp.getMonthlyTab().click();
		logger.info("Clicked on Monthly Tab");
		Thread.sleep(3000);
		rp.getWeeklyTab().click();
		logger.info("Clicked on Weekly Tab");
		Thread.sleep(3000);
		rp.getDailyTab().click();
		logger.info("Clicked on Daily Tab");
		Thread.sleep(3000);
		rp.getMonthlyTab().click();
		logger.info("Clicked on Monthly Tab");
		Thread.sleep(3000);
		rp.getWeeklyTab().click();
		logger.info("Clicked on Weekly Tab");
		Thread.sleep(3000);
		rp.getWeeklyTab().click();
		logger.info("Clicked on Weekly Tab");
		Thread.sleep(3000);
		rp.getMonthlyTab().click();
		logger.info("Clicked on Monthly Tab");
		Thread.sleep(3000);
	}



	@Test(priority = 2)
	public void addPatient() throws InterruptedException {
		ReportsPage rp = new ReportsPage(driver);
		rp.getClickAddPatient().click();
		Thread.sleep(3000);
		AddPatientPage app=new AddPatientPage(driver);
		app.getPatientNameField().sendKeys("Ashwin");
		Thread.sleep(2000);
		logger.info("Added Patient's Name");
		app.getPhoneNoField().sendKeys("9597277526");
		Thread.sleep(2000);
		logger.info("Added Patient's Phone Number");
		app.getgenderField().click();
		Thread.sleep(2000);
		logger.info("Selected Gender Field");
		Thread.sleep(2000);
		app.getbirthDateField().click();
		Thread.sleep(2000);
		app.getmonthField().sendKeys("10");
		Thread.sleep(1000);
		app.getDayField().sendKeys("12");
		Thread.sleep(1000);
		app.getYearField().sendKeys("2000");
		Thread.sleep(1000);
		logger.info("Entered BirthDate Field");
		app.getBloodGroupField().click();
		Thread.sleep(2000);
		logger.info("Selected Blood Group");
		app.getOccupationField().sendKeys("Engineer");
		Thread.sleep(2000);
		logger.info("Added Occupation Field");
		app.getAddressField().sendKeys("BTM 2nd Stage");
		Thread.sleep(2000);
		logger.info("Added Address");
		app.getEmergencyField().sendKeys("9597277526");
		Thread.sleep(2000);
		logger.info("Added Emergency contact no field");
		app.getAllergiesField().sendKeys("Itching");
		Thread.sleep(2000);
		logger.info("Added Allergy field");
		app.getRemarksField().sendKeys("Normal");
		Thread.sleep(2000);
		logger.info("Added Remark field");
		app.getHistoryField().sendKeys("Nill");
		Thread.sleep(2000);
		logger.info("Added History field");
		app.getHabitsField().sendKeys("Eating Sweets");
		Thread.sleep(2000);
		logger.info("Entered Habit field");
		app.getClickingPlusSign().click();
		Thread.sleep(5000);
		logger.info("Added Habit field by clicking Plus");
		app.getSaveButton().submit();
		Thread.sleep(2000);
		
		String expectedResult="Patient Record created successfully!";
		String actualResult=app.getCreatedSuccessfully().getText();
		Assert.assertEquals(actualResult, expectedResult);
		
		app.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");
	}
	
	@Test(priority=3)
	public void dateView() throws InterruptedException {
		ReportsPage rp=new ReportsPage(driver);
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(780, -193)");
		Thread.sleep(3000);
		rp.getClickReports().click();
		Thread.sleep(3000);
		logger.info("Clicked on Reports");
		
		String TodayDate=rp.gettodayDateView().getText();
		String ActualDate="Wed, Jul 19 2023";
		
		Assert.assertEquals(TodayDate,ActualDate);
	}
	
	@Test(priority = 4)
	public void cancel() throws InterruptedException {
		ReportsPage rp = new ReportsPage(driver);
		LoginPage l=new LoginPage(driver);
		rp.getCancelButton().click();
		logger.info("Clicked on Cancel Button");
		Thread.sleep(3000);
		
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

	@AfterClass
	public void logout() {
		driver.close();
		logger.info("Closed Browser");
	}
}
