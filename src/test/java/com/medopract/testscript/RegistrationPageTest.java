package com.medopract.testscript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.medopract.generic.BaseClass;
import com.medopract.pom.RegistrationPage;


public class RegistrationPageTest extends BaseClass {


	@BeforeClass
	public void OpenApplication() throws InterruptedException {
		driver=OpenBrowser();
		driver.manage().window().maximize();  
		driver.get("https://medopractapi-zk64betx7a-em.a.run.app/");
		logger.info("Navigated to Application URL");
	}

	@Test(priority = 1)
	public void withoutMandatoryAllField() throws InterruptedException {
		RegistrationPage rp=new RegistrationPage(driver);
		rp.getGotItButton().click();
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		rp.getClickRegisterNow().click();
		Thread.sleep(2000);
		logger.info("Clicked RegisterNow Button");
		rp.nameField.sendKeys("");
		logger.info("Entered Name");
		Thread.sleep(1000);
		rp.getemailField().sendKeys("");
		logger.info("Entered Email Address");
		Thread.sleep(1000);
		rp.getmobileField().sendKeys("");
		logger.info("Entered Phone Number");
		Thread.sleep(1000);
		rp.getuserNameField().sendKeys("");
		logger.info("Entered UserName");
		Thread.sleep(1000);
		rp.getconfirmUserNameField().sendKeys("");
		logger.info("Entered ConfirmUserName");
		Thread.sleep(1000);
		rp.getagreetermCheckBox();
		logger.info("Clicked Checkbox");
	
		j.executeScript("window.scrollBy(0,750)");
		Thread.sleep(2000);
		rp.getclickRegisterButton().click();
		logger.info("Clicked On Register Button");
		Thread.sleep(5000);
	}

	@Test(priority = 2)
	public void Registration() throws InterruptedException {
		RegistrationPage rp=new RegistrationPage(driver);
		rp.nameField.sendKeys("Akdevil");
		logger.info("Entered Name");
		Thread.sleep(1000);
		rp.getemailField().sendKeys("ak1234@gmail.com");
		logger.info("Entered Email Address");
		Thread.sleep(1000);
		rp.getmobileField().sendKeys("9486779737");
		logger.info("Entered Phone Number");
		Thread.sleep(1000);
		rp.getuserNameField().sendKeys("Ak1234@1123");
		logger.info("Entered UserName");
		Thread.sleep(1000);
		rp.getconfirmUserNameField().sendKeys("Ak1234@1123");
		logger.info("Entered ConfirmUserName");
		Thread.sleep(1000);
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,750)");
		Thread.sleep(2000);
		rp.getagreetermCheckBox().click();
		logger.info("Clicked Checkbox");
		Thread.sleep(2000);
		rp.getclickRegisterButton().click();
		logger.info("Clicked On Register Button");
		Thread.sleep(3000);	

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
	public void registerWithExistingDataAgain() throws InterruptedException {
		RegistrationPage rp=new RegistrationPage(driver);
		rp.getclickRegisterButton().click();
		logger.info("Clicked On Register Button");
		Thread.sleep(2000);	

		String actual="Doctor Already Registered";
		String expected=rp.geterrorNotification().getText();
		Assert.assertEquals(actual, expected);

		rp.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority = 4)
	public void withoutConfirmUsernameField() throws InterruptedException {
		RegistrationPage rp=new RegistrationPage(driver);
		rp.getconfirmUserNameField().clear();
		rp.getconfirmUserNameField().sendKeys("");
		logger.info("Entered ConfirmUserName");
		Thread.sleep(2000);
		rp.getclickRegisterButton().click();
		logger.info("Clicked On Register Button");
		Thread.sleep(2000);


		String actual="Username and ConfirmUserName does not match!";
		String expected=rp.geterrorNotification().getText();
		Assert.assertEquals(actual, expected);

		rp.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority =5)
	public void invalidConfirmUsernameField() throws InterruptedException {
		RegistrationPage rp=new RegistrationPage(driver);
		//JavascriptExecutor j=(JavascriptExecutor)driver;
		rp.getconfirmUserNameField().sendKeys("Ak1234");
		logger.info("Entered ConfirmUserName");
		Thread.sleep(2000);
		//j.executeScript("window.scrollBy(0,500)");
		rp.getclickRegisterButton().click();
		logger.info("Clicked On Register Button");
		Thread.sleep(2000);
		
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
	public void withoutAgreeTermCheckBox() throws InterruptedException {
		RegistrationPage rp=new RegistrationPage(driver);
		JavascriptExecutor j=(JavascriptExecutor)driver;
		rp.getconfirmUserNameField().clear();
		rp.getconfirmUserNameField().sendKeys("Ak1234@1123");
		Thread.sleep(4000);
		rp.getagreetermCheckBox().click();
		logger.info("Clicked Checkbox");
		Thread.sleep(2000);
		j.executeScript("window.scrollBy(0,500)");
		rp.getclickRegisterButton().click();
		logger.info("Clicked On Register Button");
		Thread.sleep(20000);
		
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
	public void withClickHelp() throws InterruptedException, AWTException {
		RegistrationPage rp=new RegistrationPage(driver);
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(1203, -83)");
		Thread.sleep(2000);
		rp.getclickHelp().click();
		logger.info("Clicked Help Button");
		Thread.sleep(3000);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		Thread.sleep(3000);
	}
	

	@Test(priority = 8)
	public void alreadyAnUser() throws InterruptedException {
		RegistrationPage rp=new RegistrationPage(driver);
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,750)");
		Thread.sleep(3000);
		logger.info("Clicked RegisterNow Button");
		rp.getclickImAlreadyUser().submit();
		logger.info("Clicked I'm already an User Button");
		Thread.sleep(4000);
	}
	
	

	@AfterClass
	public void logout() {
		driver.close();
		logger.info("Closed Browser");
	}
}
