package com.medopract.testscript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.medopract.generic.BaseClass;
import com.medopract.pom.AddPrescriptionPage;
import com.medopract.pom.LoginPage;

public class AddPrescriptionTest extends BaseClass {
	Logger logger= LogManager.getLogger(AddPrescriptionTest.class);

	String url;
	String un;
	String pw;
	String AddPrescription_Patientname;
	String AddPrescription_Email_Id;
	String AddPrescription_MedicineName1;
	String AddPrescription_MedicineName2;
	String AddPrescription_NoOfDays1;
	String AddPrescription_NoOfDays2;
	String AddPrescription_Instructions1;
	String AddPrescription_Instructions2;
	String AddPrescription_AmountToTake1;
	String AddPrescription_AmountToTake2;


	@BeforeClass
	public void OpenApplication() throws IOException {
		driver= initializeDriver();
		url = f.getPropertyData("url");
		un = f.getPropertyData("un");
		pw = f.getPropertyData("pw");
		AddPrescription_Patientname=f.getExcelData("Add Prescription", 1, 1);
		AddPrescription_Email_Id=f.getExcelData("Add Prescription", 2, 2);
		AddPrescription_MedicineName1=f.getExcelData("Add Prescription", 3, 1);
		AddPrescription_MedicineName2=f.getExcelData("Add Prescription", 4, 1);
		AddPrescription_NoOfDays1=f.getExcelData("Add Prescription", 5, 1);
		AddPrescription_NoOfDays2=f.getExcelData("Add Prescription", 6, 1);
		AddPrescription_Instructions1=f.getExcelData("Add Prescription", 7, 1);
		AddPrescription_Instructions2=f.getExcelData("Add Prescription", 8, 1);
		AddPrescription_AmountToTake1=f.getExcelData("Add Prescription", 9, 1);
		AddPrescription_AmountToTake2=f.getExcelData("Add Prescription", 10, 1);
		
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
	public void withoutAddingMedicineField()  {
		AddPrescriptionPage ap=new AddPrescriptionPage(driver);
		ap.getclickPrescription();
		logger.info("Clicked on Prescription");
		ap.getPatientNameField().sendKeys(AddPrescription_Patientname);
		logger.info("Entered Patient Name");
		ap.getpatientNameSuggestion();
		logger.info("Clicked Patient Name Suggestion");
		ap.getEmailField().sendKeys(AddPrescription_Email_Id);
		logger.info("Entered Email Field");
		ap.getSaveAndPrintButton();
		logger.info("Clicked Save and Print Button");

		String expectedResult="Please add medicines";
		String actualResult=ap.geterrorMessage().getText();
		Assert.assertEquals(actualResult, expectedResult);

		ap.getcancelNotification();
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority = 2)
	public void addPrescription()  {
		AddPrescriptionPage ap=new AddPrescriptionPage(driver);
		ap.getMedicineNameField().sendKeys(AddPrescription_MedicineName1);
		logger.info("Entered Medicine Name");
		ap.getTotalNumberDays().sendKeys(AddPrescription_NoOfDays1);
		logger.info("Entered Total Number Of Days");
		ap.getTimingsInput().sendKeys(AddPrescription_Instructions1);
		logger.info("Entered Time Inputs");
		ap.getAmountInput().sendKeys(AddPrescription_AmountToTake1);
		logger.info("Entered number Of amount to be used");
		ap.getClickingPlusSign();
		logger.info("Clicked Medicine Field Plus Sign");
		ap.getSaveAndPrintButton();
		logger.info("Clicked Save and Print Button");
		ap.getyesButtonField();
		logger.info("Clicked yes");

		String expectedResult="Prescription created successfully!";
		String actualResult=ap.getsuccessMessage().getText();
		Assert.assertEquals(actualResult, expectedResult);

		ap.getcancelNotification();
		logger.info("Clicked Cancel Notification");
	}


	@Test(priority= 3)
	public void printPrescription() throws AWTException {
		AddPrescriptionPage ap=new AddPrescriptionPage(driver);
		ap.getprintPrescription();
		logger.info("Clicked PrintPrescription button");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		logger.info("Return to Home Page");
	}

	@Test(priority=4)
	public void downloadPrescriptionAgain() {
		AddPrescriptionPage ap=new AddPrescriptionPage(driver);
		ap.getdownloadPrescription();
		logger.info("Clicking Download Prescription Button");
		ap.getdownloadPrescription();
		logger.info(" Again Clicking Download Prescription Button");
	}



	@Test(priority = 5)
	public void clickingBack() {
		AddPrescriptionPage ap=new AddPrescriptionPage(driver);
		ap.getbackPrescriptionbtn();
		logger.info("Clicking Back in Printing Page");
		ap.getBackButton();
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
	public void cancelAddedMedicineField()  {
		AddPrescriptionPage ap=new AddPrescriptionPage(driver);
		ap.getclickPrescription();
		logger.info("Clicked on Prescription");
		ap.getPatientNameField().sendKeys(AddPrescription_Patientname);
		logger.info("Entered Patient Name");
		ap.getpatientNameSuggestion();
		logger.info("Clicked Patient Name Suggestion");
		ap.getEmailField().sendKeys(AddPrescription_Email_Id);
		logger.info("Entered Email Field");
		ap.getMedicineNameField().sendKeys(AddPrescription_MedicineName1);
		logger.info("Entered Medicine Name");
		ap.getTotalNumberDays().sendKeys(AddPrescription_NoOfDays1);
		logger.info("Entered Total Number Of Days");
		ap.getTimingsInput().sendKeys(AddPrescription_Instructions1);
		logger.info("Entered Time Inputs");
		ap.getAmountInput().sendKeys(AddPrescription_AmountToTake1);
		logger.info("Entered number Of amount to be used");
		ap.getClickingPlusSign();
		logger.info("Clicked Medicine Field Plus Sign");
		ap.getMedicineNameField().sendKeys(AddPrescription_MedicineName1);
		logger.info("Again entering Medicine Name");
		ap.getTotalNumberDays().sendKeys(AddPrescription_NoOfDays1);
		logger.info("Again entering  Total Number Of Days");
		ap.getTimingsInput().sendKeys(AddPrescription_Instructions1);
		logger.info("Again entering  Time Inputs");
		ap.getAmountInput().sendKeys(AddPrescription_AmountToTake1);
		logger.info("Again entering  number Of amount to be used");
		ap.getClickingPlusSign();
		logger.info("Again clicking Medicine Field Plus Sign");
		ap.getdeleteMedicineField();
		logger.info("Cancelled Medicine field");
		ap.getdeleteMedicineField();
		logger.info("Again Cancelled Medicine field");

	}

	@Test(priority=7)
	public void withInvaliedMedicineField() {
		AddPrescriptionPage ap=new AddPrescriptionPage(driver);
		ap.getMedicineNameField().sendKeys(AddPrescription_MedicineName2);
		logger.info("Entered Medicine Name");
		ap.getTotalNumberDays().sendKeys(AddPrescription_NoOfDays2);
		logger.info("Entered Total Number Of Days");
		ap.getTimingsInput().sendKeys(AddPrescription_Instructions2);
		logger.info("Entered Time Inputs");
		ap.getAmountInput().sendKeys(AddPrescription_AmountToTake2);
		logger.info("Entered number Of amount to be used");
		ap.getClickingPlusSign();
		logger.info("Clicked Medicine Field Plus Sign");
		ap.getSaveAndPrintButton();
		logger.info("Clicked Save and Print Button");
		ap.getyesButtonField();
		logger.info("Clicked yes");

		String expectedResult="could not create record! Prescriptions record could not be added. due to: ValidationError: medecineDetails.0.totalcountsToConsume: Cast to Number failed for value \"gg\" at path \"totalcountsToConsume\", medecineDetails.0.howmanyatatime: Cast to Number failed for value \"gg\" at path \"howmanyatatime\"";
		String actualResult=ap.getmedicineErrorMsg().getText();
		Assert.assertEquals(actualResult, expectedResult);

		ap.getcancelNotification();
		logger.info("Clicked Cancel Notification");
	}

	@AfterClass
	public void logout() {
		driver.close();
		logger.info("Closed Browser");
	}
}
