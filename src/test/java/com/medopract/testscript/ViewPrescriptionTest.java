package com.medopract.testscript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.medopract.generic.BaseClass;
import com.medopract.pom.AddPrescriptionPage;
import com.medopract.pom.LoginPage;
import com.medopract.pom.ViewPrescriptionPage;


public class ViewPrescriptionTest extends BaseClass {
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
@Test(priority=1)
public void viewPrescription() throws InterruptedException {
	ViewPrescriptionPage vpv=new ViewPrescriptionPage(driver);
	vpv.getPrescriptionsLink().click();
	logger.info("Clicked Prescription ");
	Thread.sleep(2000);
	vpv.getviewPrescriptionsLink().click();
	logger.info("Clicked View Prescription");
	Thread.sleep(2000);
	vpv.getpatientNameField().sendKeys("Ashwin");
	logger.info("Entered Patient Name");
	Thread.sleep(2000);
	vpv.getpatientNameFieldSugg().click();
	logger.info("Clicked Patient Name Field Suggestion");
	Thread.sleep(2000);
	vpv.getprescriptionDetails().click();
	logger.info("Clicked Prescription Details");
	Thread.sleep(2000);
	
	String actual = null;
	try {
		if(vpv.getviewPrescriptionsuccessful().isDisplayed())
			actual="success";
			logger.info("Prescription viewed");
	}
	catch(Exception e) {
		actual="failure";
		logger.info("Prescription not viewed");
	}
	Assert.assertEquals(actual, "success");
}


@Test(priority=2)
public void printPrescription() throws InterruptedException, AWTException {
	AddPrescriptionPage ap=new AddPrescriptionPage(driver);
	ap.getprintPrescription().click();
	logger.info("Clicked PrintPrescription button");
	Thread.sleep(4000);
	Robot r=new Robot();
	r.keyPress(KeyEvent.VK_ESCAPE);
	logger.info("Return to Home Page");
	Thread.sleep(2000);
}

@Test(priority=3)
public void downloadPrescription() throws InterruptedException {
	AddPrescriptionPage ap=new AddPrescriptionPage(driver);
	ap.getdownloadPrescription().click();
	logger.info("Clicking Download Prescription Button");
	Thread.sleep(4000);
	ap.getdownloadPrescription().click();
	logger.info(" Again Clicking Download Prescription Button");
	Thread.sleep(4000);
	ap.getdownloadPrescription().click();
	logger.info(" Again Clicking Download Prescription Button");
	Thread.sleep(4000);
}
@Test(priority = 4)
public void clickingBackButton() throws InterruptedException {
	AddPrescriptionPage ap=new AddPrescriptionPage(driver);
	ap.getbackPrescriptionbtn().click();
	logger.info("Clicked Back Button");
	Thread.sleep(3000);
}

@Test(priority=5)
public void patientDetails() throws InterruptedException{
	ViewPrescriptionPage vpv=new ViewPrescriptionPage(driver);
	JavascriptExecutor j=(JavascriptExecutor)driver;
	j.executeScript("window.scrollBy(0,750)");
	Thread.sleep(2000);
	vpv.getgoToPatientDetails().click();
	Thread.sleep(4000);
	
	String actual = null;
	try {
		if(vpv.getpatientDetailsPage().isDisplayed())
			actual="success";
			logger.info("Patient page viewed");
	}
	catch(Exception e) {
		actual="failure";
		logger.info("Patient page not viewed");
	}
	Assert.assertEquals(actual, "success");
}


@AfterClass
public void logout() {
	driver.close();
	logger.info("Closed Browser");
}
}
