package com.medopract.testscript;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.medopract.generic.BaseClass;
import com.medopract.pom.ForgotPasswordField;


public class ForgetPasswordTest extends BaseClass {
	
	Logger logger= LogManager.getLogger(ForgetPasswordTest.class);

	@BeforeClass
	public void OpenApplication() throws EncryptedDocumentException, IOException  {
		driver=initializeDriver();
		driver.get(getPropertyData("url"));
		logger.info("Navigated to Application URL");
	}

	@Test(priority=1)
	public void forgotpassword() throws EncryptedDocumentException, IOException  {

		ForgotPasswordField fpf = new ForgotPasswordField(driver);
		fpf.getGotItButton();
		fpf.getForgotPassword();
		logger.info("Clicked On Forgot Password");
		fpf.getUsernamefield().sendKeys(getExcelData("Forget Password", 1, 2));
		//fpf.getResetButtonClick();
		logger.info("Clicked On ResetButton");
		
		String actual=null;
		try {
			if(fpf.getForgotPassPage().isDisplayed())
			actual="success";
			logger.info("Forget Password Page is displayed");
		}
		catch(Exception e) {
			actual="failure";
			logger.info("Forget Password Page is not displayed");
		}
		Assert.assertEquals(actual, "success");
	}

	@Test(priority=2)
	public void BackLoginPage() {
		ForgotPasswordField fpf = new ForgotPasswordField(driver);
		fpf.getBackLoginPage();
		logger.info("Clicked On Back Login Page");
		String actual=null;
		try {
			if(fpf.getbackLoginPage().isDisplayed())
			actual="success";
			logger.info("LoginPage is displayed");
		}
		catch(Exception e) {
			actual="failure";
			logger.info(" LoginPage is not displayed");
		}
		Assert.assertEquals(actual, "success");
		

	}
	@AfterClass
	public void logout() {
		driver.close();
		logger.info("Closed Browser");
	}
}





