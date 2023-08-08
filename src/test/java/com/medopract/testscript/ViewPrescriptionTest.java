package com.medopract.testscript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.medopract.generic.BaseClass;
import com.medopract.pom.AddPrescriptionPage;
import com.medopract.pom.LoginPage;
import com.medopract.pom.ViewPrescriptionPage;


public class ViewPrescriptionTest extends BaseClass {
	Logger logger= LogManager.getLogger(ViewPrescriptionTest.class);
	
	String url;
	String un;
	String pw;
	String ViewPrescription_Name;
	
	
	@BeforeClass
	public void OpenApplication() throws  IOException, InterruptedException {
		driver= initializeDriver();
		driver.manage().window().maximize();
		url = f.getPropertyData("url");
		un = f.getPropertyData("un");
		pw = f.getPropertyData("pw");
		ViewPrescription_Name=f.getExcelData("View Prescription", 1, 2);
		
		
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
	@Test(priority=1)
	public void viewPrescription()  {
		ViewPrescriptionPage vpv=new ViewPrescriptionPage(driver);
		vpv.getPrescriptionsLink();
		logger.info("Clicked Prescription");
		vpv.getviewPrescriptionsLink();
		logger.info("Clicked View Prescription");
		vpv.getpatientNameField().sendKeys(ViewPrescription_Name);
		logger.info("Entered Patient Name");
		vpv.getpatientNameFieldSugg();
		logger.info("Clicked Patient Name Field Suggestion");
		vpv.getprescriptionDetails();
		logger.info("Clicked Prescription Details");

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
	public void printPrescription() throws  AWTException {
		AddPrescriptionPage ap=new AddPrescriptionPage(driver);
		ap.getprintPrescription();
		logger.info("Clicked PrintPrescription button");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		logger.info("Return to Home Page");
	}

	@Test(priority=3)
	public void downloadPrescription()  {
		AddPrescriptionPage ap=new AddPrescriptionPage(driver);
		ap.getdownloadPrescription();
		logger.info("Clicking Download Prescription Button");
		ap.getdownloadPrescription();
		logger.info(" Again Clicking Download Prescription Button");
		ap.getdownloadPrescription();
		logger.info(" Again Clicking Download Prescription Button");
	}
	@Test(priority = 4)
	public void clickingBackButton()  {
		AddPrescriptionPage ap=new AddPrescriptionPage(driver);
		ap.getbackPrescriptionbtn();
		logger.info("Clicked Back Button");
	}

	@Test(priority=5)
	public void patientDetails() {
		ViewPrescriptionPage vpv=new ViewPrescriptionPage(driver);
		vpv.getgoToPatientDetails();

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
