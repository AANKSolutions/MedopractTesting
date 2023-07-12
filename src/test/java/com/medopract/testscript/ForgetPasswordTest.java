package com.medopract.testscript;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.medopract.generic.BaseClass;
import com.medopract.pom.ForgotPasswordField;
import com.medopract.pom.LoginPage;

public class ForgetPasswordTest extends BaseClass {

	@BeforeMethod
	public void OpenApplication() throws InterruptedException {
		driver=OpenBrowser();
		driver.manage().window().maximize();  
		driver.get("https://medopractapi-zk64betx7a-em.a.run.app/");
		logger.info("Navigated to Application URL");
		LoginPage l=new LoginPage(driver);
		l.getGotItButton().click();
		Thread.sleep(2000);
		l.getUsername().sendKeys("ashwinkv016"); 
		l.getPassword().sendKeys("ashwinkv016");
		Thread.sleep(2000);
		l.getSubmitButton().submit();
		Thread.sleep(4000);     
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
	}

	@Test(priority=2)
	public void BackLoginPage() throws InterruptedException {
		ForgotPasswordField fpf = new ForgotPasswordField(driver);
		//fpf.getGotItButton().click();
		fpf.getForgotPassword().click();
		logger.debug("Clicked On Forget Password");
		Thread.sleep(3000);
		fpf.getBackLoginPage().click();

	}
	@AfterMethod
	public void CloseBrowser() {
		driver.close();
	}
}





