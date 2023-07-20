package com.medopract.testscript;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.medopract.generic.BaseClass;
import com.medopract.pom.ForgotPasswordField;


public class ForgetPasswordTest extends BaseClass {

	@BeforeClass
	public void OpenApplication() throws InterruptedException {
		driver=OpenBrowser();
		driver.manage().window().maximize();  
		driver.get("https://medopractapi-zk64betx7a-em.a.run.app/");
		logger.info("Navigated to Application URL");
		Thread.sleep(3000);
		
	}

	@Test(priority=1)
	public void forgotpassword() throws InterruptedException {

		ForgotPasswordField fpf = new ForgotPasswordField(driver);
		fpf.getGotItButton().click();
		fpf.getForgotPassword().click();
		Thread.sleep(3000);
		logger.info("Clicked On Forgot Password");
		fpf.getUsernamefield().sendKeys("ashwinkv016");
		Thread.sleep(3000);
		//fpf.getResetButtonClick().click();
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
	public void BackLoginPage() throws InterruptedException {
		ForgotPasswordField fpf = new ForgotPasswordField(driver);
		fpf.getBackLoginPage().click();
		Thread.sleep(3000);
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





