package com.medopract.testscript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.medopract.generic.BaseClass;
import com.medopract.pom.AddPrescriptionPage;
import com.medopract.pom.LoginPage;

public class AddPrescriptionTest extends BaseClass {
	Logger logger= LogManager.getLogger(AddPrescriptionTest.class);


	@BeforeClass
	public void OpenApplication() throws IOException {
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
	@Test(priority = 1)
	public void withoutAddingMedicineField() throws EncryptedDocumentException, IOException  {
		AddPrescriptionPage ap=new AddPrescriptionPage(driver);
		ap.getclickPrescription();
		logger.info("Clicked on Prescription");
		ap.getPatientNameField().sendKeys(getExcelData("Add Prescription", 1, 1));
		logger.info("Entered Patient Name");
		ap.getpatientNameSuggestion();
		logger.info("Clicked Patient Name Suggestion");
		ap.getEmailField().sendKeys(getExcelData("Add Prescription", 2, 2));
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
	public void addPrescription() throws EncryptedDocumentException, IOException  {
		AddPrescriptionPage ap=new AddPrescriptionPage(driver);
		ap.getMedicineNameField().sendKeys(getExcelData("Add Prescription", 3, 1));
		logger.info("Entered Medicine Name");
		ap.getTotalNumberDays().sendKeys(getExcelData("Add Prescription", 5, 1));
		logger.info("Entered Total Number Of Days");
		ap.getTimingsInput().sendKeys(getExcelData("Add Prescription", 7, 1));
		logger.info("Entered Time Inputs");
		ap.getAmountInput().sendKeys(getExcelData("Add Prescription", 9, 1));
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
	public void cancelAddedMedicineField() throws EncryptedDocumentException, IOException  {
		AddPrescriptionPage ap=new AddPrescriptionPage(driver);
		ap.getclickPrescription();
		logger.info("Clicked on Prescription");
		ap.getPatientNameField().sendKeys(getExcelData("Add Prescription", 1, 1));
		logger.info("Entered Patient Name");
		ap.getpatientNameSuggestion();
		logger.info("Clicked Patient Name Suggestion");
		ap.getEmailField().sendKeys(getExcelData("Add Prescription", 2, 2));
		logger.info("Entered Email Field");
		ap.getMedicineNameField().sendKeys(getExcelData("Add Prescription", 3, 1));
		logger.info("Entered Medicine Name");
		ap.getTotalNumberDays().sendKeys(getExcelData("Add Prescription", 5, 1));
		logger.info("Entered Total Number Of Days");
		ap.getTimingsInput().sendKeys(getExcelData("Add Prescription", 7, 1));
		logger.info("Entered Time Inputs");
		ap.getAmountInput().sendKeys(getExcelData("Add Prescription", 9, 1));
		logger.info("Entered number Of amount to be used");
		ap.getClickingPlusSign();
		logger.info("Clicked Medicine Field Plus Sign");
		ap.getMedicineNameField().sendKeys(getExcelData("Add Prescription", 3, 1));
		logger.info("Again entering Medicine Name");
		ap.getTotalNumberDays().sendKeys(getExcelData("Add Prescription", 5, 1));
		logger.info("Again entering  Total Number Of Days");
		ap.getTimingsInput().sendKeys(getExcelData("Add Prescription", 7, 1));
		logger.info("Again entering  Time Inputs");
		ap.getAmountInput().sendKeys(getExcelData("Add Prescription", 9, 1));
		logger.info("Again entering  number Of amount to be used");
		ap.getClickingPlusSign();
		logger.info("Again clicking Medicine Field Plus Sign");
		ap.getdeleteMedicineField();
		logger.info("Cancelled Medicine field");
		ap.getdeleteMedicineField();
		logger.info("Again Cancelled Medicine field");

	}

	@Test(priority=7)
	public void withInvaliedMedicineField() throws EncryptedDocumentException, IOException {
		AddPrescriptionPage ap=new AddPrescriptionPage(driver);
		ap.getMedicineNameField().sendKeys(getExcelData("Add Prescription", 4, 1));
		logger.info("Entered Medicine Name");
		ap.getTotalNumberDays().sendKeys(getExcelData("Add Prescription", 6, 1));
		logger.info("Entered Total Number Of Days");
		ap.getTimingsInput().sendKeys(getExcelData("Add Prescription", 8, 1));
		logger.info("Entered Time Inputs");
		ap.getAmountInput().sendKeys(getExcelData("Add Prescription", 10, 1));
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
