package com.medopract.testscript;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.medopract.generic.BaseClass;
import com.medopract.pom.LoginPage;

public class LoginTest extends BaseClass {
	Logger logger= LogManager.getLogger(LoginTest.class);

	@BeforeClass
	public void OpenApplication() throws IOException  {
		driver=initializeDriver();
		
		driver.get(getPropertyData("url"));
		logger.info("Navigated to Application URL");
		
		Assert.assertEquals("MedoPract App", driver.getTitle());
	}


	@Test(priority = 1)
	public void loginWithoutData() throws EncryptedDocumentException, IOException  {
		LoginPage l=new LoginPage(driver);
		l.getGotItButton();
		l.getUsername().sendKeys(getExcelData("Login", 3, 1));
		logger.info("Entered Username without data");
		l.getPassword().sendKeys(getExcelData("Login", 6, 1));
		logger.info("Entered Username without data");
		l.getSubmitButton();
		logger.info("Clicked submit button");
		       	
	}
	
	@Test(priority = 2)
	public void loginWithoutPassword() throws EncryptedDocumentException, IOException  {
		LoginPage l=new LoginPage(driver);
		l.getUsername().sendKeys(getExcelData("Login", 1, 1));
		logger.info("Entered Username");
		l.getSubmitButton();
		logger.info("Clicked submit button");
	

		String expectedResult="Invalid Password!";
		String actualResult=l.geterrorMsgNotification().getText();
		Assert.assertEquals(actualResult, expectedResult);
		
		l.getcancelNotification();
		logger.info("Clicked Cancel Notification");    

	}
	
	@Test(priority = 3)
	public void loginWithoutUsername() throws EncryptedDocumentException, IOException  {
		LoginPage l=new LoginPage(driver);
		l.getUsername().clear();
		logger.info("Cleared Username without data");
		l.getPassword().sendKeys(getExcelData("Login", 4, 1));
		logger.info("Entered Password");
		l.getSubmitButton();
		logger.info("Clicked submit button");
		

		String expectedResult="No record available with Doctor ID :";
		String actualResult=l.geterrorMsgNotification().getText();
		Assert.assertEquals(actualResult, expectedResult);
		
		l.getcancelNotification();
		logger.info("Clicked Cancel Notification");    
	}
	
	
	@Test(priority=4)
	public void incorrectDetails() throws EncryptedDocumentException, IOException  {
		LoginPage l=new LoginPage(driver);
		l.getUsername().sendKeys(getExcelData("Login", 2, 1));
		logger.info("Entered Username");
		l.getPassword().clear();
		l.getPassword().sendKeys(getExcelData("Login", 5, 1));
		logger.info("Entered Password");
		l.getSubmitButton();
		logger.info("Clicked submit button");
		
		String expectedResult="No record available with Doctor ID :!*(&";
		String actualResult=l.geterrorMsgNotification().getText();
		Assert.assertEquals(actualResult, expectedResult);
		
		l.getcancelNotification();
		logger.info("Clicked Cancel Notification");
	
	}
	

	@Test(priority = 5)
	public void loginwithoutRememberMe() throws EncryptedDocumentException, IOException  {
		LoginPage l=new LoginPage(driver);
		l.getUsername().clear();
		l.getUsername().sendKeys(getExcelData("Login", 1, 1));
		logger.info("Entered Username");
		l.getPassword().clear();
		l.getPassword().sendKeys(getExcelData("Login", 4, 1));
		logger.info("Entered Password");
		l.getSubmitButton();
		logger.info("Clicked submit button");
				
		String actual = null;
		try {
			if(l.getaccInfo().isDisplayed())
				actual="success";
		}
		catch(Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, "success");
		
		l.getLogoutBtn();
		logger.info("Clicked logout");
	}
	
	@Test(priority = 6)
	public void loginWithRememberMe() throws EncryptedDocumentException, IOException  {
		LoginPage l=new LoginPage(driver);
		l.getUsername().sendKeys(getExcelData("Login", 1, 1));
		logger.info("Entered Username");
		l.getPassword().sendKeys(getExcelData("Login", 4, 1));
		logger.info("Entered Password");
		l.getrememberMeBtn();
		logger.info("Clicked Remember me Button");
		l.getSubmitButton();
		logger.info("Clicked submit button");
		
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

