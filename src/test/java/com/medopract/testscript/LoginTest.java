package com.medopract.testscript;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.medopract.generic.BaseClass;
import com.medopract.pom.LoginPage;

public class LoginTest extends BaseClass {

	@BeforeMethod
	public void OpenApplication() {
		driver=OpenBrowser();
		driver.manage().window().maximize();  
		driver.get("https://medopractapi-zk64betx7a-em.a.run.app/");
		logger.info("Navigated to Application URL");
	}

	@Test(priority = 1)
	public void login() throws InterruptedException {
		LoginPage l=new LoginPage(driver);
		l.getGotItButton().click();
		l.getUsername().sendKeys("ashwinkv016");
		logger.info("Entered Username");
		Thread.sleep(2000);
		l.getPassword().sendKeys("ashwinkv016");
		logger.info("Entered Password");
		Thread.sleep(2000);
		l.getSubmitButton().submit();
		logger.info("Clicked submit button");
		Thread.sleep(2000);                 
		if(driver.getTitle().equals("MedoPract App")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 2)
	public void loginWithoutData() throws InterruptedException {
		LoginPage l=new LoginPage(driver);
		l.getUsername().sendKeys(" ");
		logger.info("Entered Username without data");
		Thread.sleep(2000);
		l.getPassword().sendKeys(" ");
		logger.info("Entered Username without data");
		Thread.sleep(2000);
		l.getSubmitButton().submit();
		logger.info("Clicked submit button");
	}
	@Test(priority = 3)
	public void loginWithoutUsername() throws InterruptedException {
		LoginPage l=new LoginPage(driver);
		l.getUsername().sendKeys(" ");
		logger.info("Entered Username without data");
		Thread.sleep(2000);
		l.getPassword().sendKeys("ashwinkv016");
		logger.info("Entered Password");
		Thread.sleep(2000);
		l.getSubmitButton().submit();;
		logger.info("Clicked submit button");
		Thread.sleep(2000); 
	}
	@Test(priority = 4)
	public void loginWithoutPassword() throws InterruptedException {
		LoginPage l=new LoginPage(driver);
		l.getUsername().sendKeys("ashwinkv016");
		logger.info("Entered Password without data");
		Thread.sleep(2000);
		l.getPassword().sendKeys(" ");
		logger.info("Entered Password");
		Thread.sleep(2000);
		l.getSubmitButton().submit();;
		logger.info("Clicked submit button");
		Thread.sleep(2000); 

	}

	@AfterMethod
	public void CloseBrowser() {
		driver.close();
	}
}

