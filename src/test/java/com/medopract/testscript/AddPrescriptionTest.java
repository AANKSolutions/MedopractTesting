package com.medopract.testscript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.medopract.generic.BaseClass;
import com.medopract.pom.AddPrescriptionPage;
import com.medopract.pom.LoginPage;

public class AddPrescriptionTest extends BaseClass {

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
	public void withoutAddingMedicineField() throws InterruptedException {
		AddPrescriptionPage ap=new AddPrescriptionPage(driver);
		ap.getclickPrescription().click();
		Thread.sleep(2000);
		logger.info("Clicked on Prescription");
		ap.getPatientNameField().sendKeys("Ashwin");
		logger.info("Entered Patient Name");
		Thread.sleep(2000);
		ap.getpatientNameSuggestion().click();
		logger.info("Clicked Patient Name Suggestion");
		Thread.sleep(2000);
		ap.getEmailField().sendKeys("vashwinkumar008@gmail.com");
		logger.info("Entered Email Field");
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,750)");
		Thread.sleep(2000);
		ap.getSaveAndPrintButton().click();
		logger.info("Clicked Save and Print Button");
		Thread.sleep(2000);

		String expectedResult="Please add medicines";
		String actualResult=ap.geterrorMessage().getText();
		Assert.assertEquals(actualResult, expectedResult);
		
		ap.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority = 2)
	public void addPrescription() throws InterruptedException {
		AddPrescriptionPage ap=new AddPrescriptionPage(driver);
		Thread.sleep(3000);
		ap.getMedicineNameField().sendKeys("Dolo65");
		logger.info("Entered Medicine Name");
		Thread.sleep(2000);
		ap.getTotalNumberDays().sendKeys("100");
		logger.info("Entered Total Number Of Days");
		Thread.sleep(2000);
		ap.getTimingsInput().sendKeys("Morning , Evening");
		logger.info("Entered Time Inputs");
		Thread.sleep(2000);
		ap.getAmountInput().sendKeys("1");
		logger.info("Entered number Of amount to be used");
		Thread.sleep(2000);
		ap.getClickingPlusSign().click();
		logger.info("Clicked Medicine Field Plus Sign");
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		ap.getSaveAndPrintButton().click();
		logger.info("Clicked Save and Print Button");
		Thread.sleep(2000);
		ap.getyesButtonField().click();
		logger.info("Clicked yes");
		Thread.sleep(4000);

		String expectedResult="Prescription created successfully!";
		String actualResult=ap.getsuccessMessage().getText();
		Assert.assertEquals(actualResult, expectedResult);
		
		ap.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");
	}


	@Test(priority= 3)
	public void printPrescription() throws InterruptedException, AWTException {
		AddPrescriptionPage ap=new AddPrescriptionPage(driver);
		
		Thread.sleep(4000);
		ap.getprintPrescription().click();
		logger.info("Clicked PrintPrescription button");
		Thread.sleep(4000);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		logger.info("Return to Home Page");
		Thread.sleep(2000);
	}

	@Test(priority=4)
	public void downloadPrescriptionAgain() throws InterruptedException {
		AddPrescriptionPage ap=new AddPrescriptionPage(driver);
		
		Thread.sleep(4000); 
		ap.getdownloadPrescription().click();
		logger.info("Clicking Download Prescription Button");
		Thread.sleep(4000);
		ap.getdownloadPrescription().click();
		logger.info(" Again Clicking Download Prescription Button");
		Thread.sleep(4000);
	}

	

	@Test(priority = 5)
	public void clickingBack() throws InterruptedException {
		AddPrescriptionPage ap=new AddPrescriptionPage(driver);
		Thread.sleep(2000);
		ap.getbackPrescriptionbtn().click();
		logger.info("Clicking Back in Printing Page");
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,250)");
		Thread.sleep(3000);
		ap.getBackButton().click();
		logger.info("Clicking Back in Prescription Page");
		
		LoginPage l=new LoginPage(driver);
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
	
	@Test(priority =6 )
	public void cancelAddedMedicineField() throws InterruptedException {
		AddPrescriptionPage ap=new AddPrescriptionPage(driver);
		ap.getclickPrescription().click();
		Thread.sleep(2000);
		logger.info("Clicked on Prescription");
		ap.getPatientNameField().sendKeys("Ashwin");
		logger.info("Entered Patient Name");
		Thread.sleep(2000);
		ap.getpatientNameSuggestion().click();
		logger.info("Clicked Patient Name Suggestion");
		Thread.sleep(2000);
		ap.getEmailField().sendKeys("vashwinkumar008@gmail.com");
		logger.info("Entered Email Field");
		Thread.sleep(2000);
		ap.getMedicineNameField().sendKeys("Dolo65");
		logger.info("Entered Medicine Name");
		Thread.sleep(2000);
		ap.getTotalNumberDays().sendKeys("100");
		logger.info("Entered Total Number Of Days");
		Thread.sleep(2000);
		ap.getTimingsInput().sendKeys("Morning , Evening");
		logger.info("Entered Time Inputs");
		Thread.sleep(2000);
		ap.getAmountInput().sendKeys("1");
		logger.info("Entered number Of amount to be used");
		Thread.sleep(2000);
		ap.getClickingPlusSign().click();
		logger.info("Clicked Medicine Field Plus Sign");
		Thread.sleep(3000);
		ap.getMedicineNameField().sendKeys("Dolo65");
		logger.info("Again entering Medicine Name");
		Thread.sleep(2000);
		ap.getTotalNumberDays().sendKeys("100");
		logger.info("Again entering  Total Number Of Days");
		Thread.sleep(2000);
		ap.getTimingsInput().sendKeys("Morning , Evening");
		logger.info("Again entering  Time Inputs");
		Thread.sleep(2000);
		ap.getAmountInput().sendKeys("1");
		logger.info("Again entering  number Of amount to be used");
		Thread.sleep(2000);
		ap.getClickingPlusSign().click();
		logger.info("Again clicking Medicine Field Plus Sign");
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,750)");
		Thread.sleep(4000);
		ap.getdeleteMedicineField().click();
		logger.info("Cancelled Medicine field");
		ap.getdeleteMedicineField().click();
		logger.info("Again Cancelled Medicine field");
		
	}
	
	@Test(priority=7)
	public void withInvaliedMedicineField() throws InterruptedException {
		AddPrescriptionPage ap=new AddPrescriptionPage(driver);
		ap.getMedicineNameField().sendKeys("gg");
		logger.info("Entered Medicine Name");
		Thread.sleep(2000);
		ap.getTotalNumberDays().sendKeys("gg");
		logger.info("Entered Total Number Of Days");
		Thread.sleep(2000);
		ap.getTimingsInput().sendKeys("gg");
		logger.info("Entered Time Inputs");
		Thread.sleep(2000);
		ap.getAmountInput().sendKeys("gg");
		logger.info("Entered number Of amount to be used");
		Thread.sleep(2000);
		ap.getClickingPlusSign().click();
		logger.info("Clicked Medicine Field Plus Sign");
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		ap.getSaveAndPrintButton().click();
		logger.info("Clicked Save and Print Button");
		Thread.sleep(2000);
		ap.getyesButtonField().click();
		logger.info("Clicked yes");
		Thread.sleep(4000);
		Thread.sleep(3000);
		
		String expectedResult="could not create record! Prescriptions record could not be added. due to: ValidationError: medecineDetails.0.totalcountsToConsume: Cast to Number failed for value \"gg\" at path \"totalcountsToConsume\", medecineDetails.0.howmanyatatime: Cast to Number failed for value \"gg\" at path \"howmanyatatime\"";
		String actualResult=ap.getmedicineErrorMsg().getText();
		Assert.assertEquals(actualResult, expectedResult);
		
		ap.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");
	}





	@AfterClass
	public void logout() {
		driver.close();
		logger.info("Closed Browser");
	}
}
