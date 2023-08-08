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
import com.medopract.pom.RegistrationPage;


public class RegistrationPageTest extends BaseClass {

	Logger logger= LogManager.getLogger(RegistrationPageTest.class);
	String url;
	String Registration_FullName;
	String Registration_Email;
	String Registration_Phno;
	String Registration_UserName;
	String Registration_CnfrmUserName;
	String Registration_INCnfrmUserName;
	
	
	@BeforeClass
	public void OpenApplication() throws EncryptedDocumentException, IOException  {
		driver=initializeDriver();
		 url = f.getPropertyData("url");
		Registration_FullName=f.getExcelData("Registration Page", 1, 1);
		Registration_Email=f.getExcelData("Registration Page", 2, 1);
		Registration_Phno=f.getExcelData("Registration Page", 3, 1);
		Registration_UserName=f.getExcelData("Registration Page", 4, 1);
		Registration_CnfrmUserName=f.getExcelData("Registration Page", 5, 1);
		Registration_INCnfrmUserName=f.getExcelData("Registration Page", 6, 1);
		
		driver.get(url);
		logger.info("Navigated to Application URL");
	}

	@Test(priority = 1)
	public void withoutMandatoryAllField()  {
		RegistrationPage rp=new RegistrationPage(driver);
		rp.getGotItButton();
		rp.getClickRegisterNow();
		logger.info("Clicked RegisterNow Button");
		rp.nameField.clear();
		logger.info("Entered Name");
		rp.getemailField().clear();
		logger.info("Entered Email Address");
		rp.getmobileField().clear();
		logger.info("Entered Phone Number");
		rp.getuserNameField().clear();
		logger.info("Entered UserName");
		rp.getconfirmUserNameField().clear();
		logger.info("Entered ConfirmUserName");
		rp.getagreetermCheckBox();
		logger.info("Clicked Checkbox");
	
		rp.getclickRegisterButton();
		logger.info("Clicked On Register Button");
	}

	@Test(priority = 2)
	public void Registration()  {
		RegistrationPage rp=new RegistrationPage(driver);
		rp.nameField.sendKeys(Registration_FullName);
		logger.info("Entered Name");
		rp.getemailField().sendKeys(Registration_Email);
		logger.info("Entered Email Address");
		rp.getmobileField().sendKeys(Registration_Phno);
		logger.info("Entered Phone Number");
		rp.getuserNameField().sendKeys(Registration_UserName);
		logger.info("Entered UserName");
		rp.getconfirmUserNameField().sendKeys(Registration_CnfrmUserName);
		logger.info("Entered ConfirmUserName");
		rp.getagreetermCheckBox();
		logger.info("Clicked Checkbox");
		rp.getclickRegisterButton();
		logger.info("Clicked On Register Button");

	/**	String actual = null;
		try {
			if(rp.getregistrationSuccessfulMsg().isDisplayed())
				actual="success";
		}
		catch(Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, "success");

		rp.getOkButton().click();
		Thread.sleep(3000);
		logger.info("Clicked OK button");**/
	}

	@Test(priority = 3)
	public void registerWithExistingDataAgain()  {
		RegistrationPage rp=new RegistrationPage(driver);
		rp.getclickRegisterButton();
		logger.info("Clicked On Register Button");

		String actual="Doctor Already Registered";
		String expected=rp.geterrorNotification().getText();
		Assert.assertEquals(actual, expected);

		rp.getcancelNotification();
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority = 4)
	public void withoutConfirmUsernameField()  {
		RegistrationPage rp=new RegistrationPage(driver);
		rp.getconfirmUserNameField().clear();
		logger.info("Entered ConfirmUserName");
		rp.getclickRegisterButton();
		logger.info("Clicked On Register Button");


		String actual="Username and ConfirmUserName does not match!";
		String expected=rp.geterrorNotification().getText();
		Assert.assertEquals(actual, expected);

		rp.getcancelNotification();
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority =5)
	public void invalidConfirmUsernameField()  {
		RegistrationPage rp=new RegistrationPage(driver);
		rp.getconfirmUserNameField().sendKeys(Registration_INCnfrmUserName);
		logger.info("Entered ConfirmUserName");
		rp.getclickRegisterButton();
		logger.info("Clicked On Register Button");
		
		String actual = null;
		try {
			if(rp.getconfirmUnErrorNotification().isDisplayed())
				actual="success";
		}
		catch(Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, "success");
		
	}

	@Test(priority = 6)
	public void withoutAgreeTermCheckBox()  {
		RegistrationPage rp=new RegistrationPage(driver);
		rp.getconfirmUserNameField().clear();
		rp.getconfirmUserNameField().sendKeys(Registration_CnfrmUserName);
		rp.getagreetermCheckBox();
		logger.info("Clicked Checkbox");
		rp.getclickRegisterButton();
		logger.info("Clicked On Register Button");
		
		String actual = null;
		try {
			if(rp.getTermsErrorNotification().isDisplayed())
				actual="success";
		}
		catch(Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, "success");
	}
	
	@Test(priority = 7)
	public void withClickHelp() throws  AWTException {
		RegistrationPage rp=new RegistrationPage(driver);
		rp.getclickHelp();
		logger.info("Clicked Help Button");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
	}
	

	@Test(priority = 8)
	public void alreadyAnUser(){
		RegistrationPage rp=new RegistrationPage(driver);
		logger.info("Clicked RegisterNow Button");
		rp.getclickImAlreadyUser();
		logger.info("Clicked I'm already an User Button");
	}
	
	

	@AfterClass
	public void logout() {
		driver.close();
		logger.info("Closed Browser");
	}
}
