package com.medopract.testscript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.medopract.generic.BaseClass;
import com.medopract.pom.AddPatientPage;
import com.medopract.pom.LoginPage;
import com.medopract.pom.ViewOrEditPage;


public class ViewOrEditTest extends BaseClass{
	Logger logger= LogManager.getLogger(ViewOrEditTest.class);

	@BeforeClass
	public void OpenApplication() throws  IOException {
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

	@Test(priority=1)
	public void deleteList() throws  AWTException, EncryptedDocumentException, IOException {
		AddPatientPage ap=new AddPatientPage(driver);
		ap.getPatientsClick();
		logger.info("Clicking Add Patient");

		ViewOrEditPage voe=new ViewOrEditPage(driver);
		voe.getViewOrEdit();
		logger.info("Clicked View or edit");
		voe.getPatientNameField().sendKeys(getExcelData("View or Edit", 1, 1));
		logger.info("Entered Patient Name");
		voe.getDeleteButtonClick();
		logger.info("Clicked delete button");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		logger.info("Pressed Enter");

		String actual="Patient record deleted successfully!";
		String expected=voe.getdeleteUpdateMsg().getText();
		Assert.assertEquals(actual, expected);

		voe.getcancelNotification();
		logger.info("Clicked Cancel Notification");
	}


	@Test(priority = 2)
	public void ViewOrEdit()  {
		ViewOrEditPage voe=new ViewOrEditPage(driver);
		voe.getPatientListClick();
		logger.info("Clicked Patient List");
		voe.getUpdateButtonClick();
		logger.info("Clicked Update Button");

		String actual="Patient record updated successfully!";
		String expected=voe.getsuccessUpdateMsg().getText();
		Assert.assertEquals(actual, expected);

		voe.getcancelNotification();
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority  =3)
	public void updateContactField() throws  AWTException, EncryptedDocumentException, IOException {

		ViewOrEditPage voe=new ViewOrEditPage(driver);
		AddPatientPage ap=new AddPatientPage(driver);
		ap.getPhoneNoField().clear();
		ap.getPhoneNoField().sendKeys(getExcelData("View or Edit", 2, 1));
		ap.getEmergencyField().clear();
		ap.getEmergencyField().sendKeys(getExcelData("View or Edit", 3, 1));
		voe.getUpdateButtonClick();
		logger.info("Clicked Update Button");

		String actual="Patient record updated successfully!";
		String expected=voe.getsuccessUpdateMsg().getText();
		Assert.assertEquals(actual, expected);

		voe.getcancelNotification();
		logger.info("Clicked Cancel Notification");
	}


	@Test(priority =4)
	public void withoutAddressField() {
		ViewOrEditPage voe=new ViewOrEditPage(driver);
		AddPatientPage ap=new AddPatientPage(driver);
		ap.getAddressField().clear();
		voe.getUpdateButtonClick();
		logger.info("Clicked Update Button");

	}

	@Test(priority=5)
	public void withoutMandatoryData() throws  AWTException {
		ViewOrEditPage voe=new ViewOrEditPage(driver);
		AddPatientPage ap=new AddPatientPage(driver);
		ap.getPatientNameField().clear();
		logger.info("Cleared Name Field");
		ap.getPhoneNoField().clear();
		logger.info("Cleared Phone Number Field");
		voe.getUpdateButtonClick();
		logger.info("Clicked Update Button");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_ALT);

		String actual="Please provide required inputs";
		String expected=voe.geterrorUpdateMsg().getText();
		Assert.assertEquals(actual, expected);

		voe.getcancelNotification();
		logger.info("Clicked Cancel Notification");
	}


	@Test(priority = 6)
	public void cancelEdit()  {
		ViewOrEditPage voe=new ViewOrEditPage(driver);
		voe.getCancelButtonClick();
		logger.info("Clicked Cancel Button");
	}

	@AfterClass
	public void CloseBrowser() {
		driver.close();
		logger.info("Closing Browser");
	}
}
