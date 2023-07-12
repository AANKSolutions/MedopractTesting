package com.medopract.testscript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.medopract.generic.BaseClass;
import com.medopract.pom.RegistrationPage;

public class RegistrationPageTest extends BaseClass {


	@BeforeMethod
	public void OpenApplication() throws InterruptedException {
		driver=OpenBrowser();
		driver.manage().window().maximize();  
		driver.get("https://medopractapi-zk64betx7a-em.a.run.app/");
		logger.info("Navigated to Application URL");


	}
	@Test(priority = 1)
	public void Registration() throws InterruptedException {
		RegistrationPage rp=new RegistrationPage(driver);
		rp.getGotItButton().click();
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		rp.getClickRegisterNow().click();
		Thread.sleep(2000);
		logger.info("Clicked RegisterNow Button");
		rp.nameField.sendKeys("Amit");
		logger.info("Entered Name");
		Thread.sleep(1000);
		rp.getemailField().sendKeys("amitvv123@gmail.com");
		logger.info("Entered Email Address");
		Thread.sleep(1000);
		rp.getmobileField().sendKeys("9486779737");
		logger.info("Entered Phone Number");
		Thread.sleep(1000);
		rp.getuserNameField().sendKeys("amitvv1234");
		logger.info("Entered UserName");
		Thread.sleep(1000);
		rp.getconfirmUserNameField().sendKeys("amitvv1234");
		logger.info("Entered ConfirmUserName");
		Thread.sleep(1000);
		rp.getagreetermCheckBox().click();
		logger.info("Clicked Checkbox");
		Thread.sleep(2000);
		j.executeScript("window.scrollBy(0,500)");
		rp.getclickRegisterButton().click();
		logger.info("Clicked On Register Button");
		Thread.sleep(2000);	
	}

	@Test(priority = 2)
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
		Thread.sleep(2000);
		j.executeScript("window.scrollBy(0,500)");
		rp.getclickRegisterButton().click();
		logger.info("Clicked On Register Button");
		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void withoutConfirmUsernameField() throws InterruptedException {
		RegistrationPage rp=new RegistrationPage(driver);
		rp.getGotItButton().click();
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		rp.getClickRegisterNow().click();
		Thread.sleep(2000);
		logger.info("Clicked RegisterNow Button");
		rp.nameField.sendKeys("Niti");
		logger.info("Entered Name");
		Thread.sleep(1000);
		rp.getemailField().sendKeys("Niti123@gmail.com");
		logger.info("Entered Email Address");
		Thread.sleep(1000);
		rp.getmobileField().sendKeys("9486779737");
		logger.info("Entered Phone Number");
		Thread.sleep(1000);
		rp.getuserNameField().sendKeys("nitikv1234");
		logger.info("Entered UserName");
		Thread.sleep(1000);
		rp.getconfirmUserNameField().sendKeys("");
		logger.info("Entered ConfirmUserName");
		Thread.sleep(1000);
		j.executeScript("window.scrollBy(0,250)");
		Thread.sleep(1000);
		rp.getagreetermCheckBox().click();
		logger.info("Clicked Checkbox");
		Thread.sleep(2000);
		rp.getclickRegisterButton().click();
		logger.info("Clicked On Register Button");
		Thread.sleep(2000);
	}

	@Test(priority =5)
	public void invalidConfirmUsernameField() throws InterruptedException {
		RegistrationPage rp=new RegistrationPage(driver);
		rp.getGotItButton().click();
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		rp.getClickRegisterNow().click();
		Thread.sleep(2000);
		logger.info("Clicked RegisterNow Button");
		rp.nameField.sendKeys("Niti");
		logger.info("Entered Name");
		Thread.sleep(1000);
		rp.getemailField().sendKeys("Niti123@gmail.com");
		logger.info("Entered Email Address");
		Thread.sleep(1000);
		rp.getmobileField().sendKeys("9486779737");
		logger.info("Entered Phone Number");
		Thread.sleep(1000);
		rp.getuserNameField().sendKeys("nitikv1234");
		logger.info("Entered UserName");
		Thread.sleep(1000);
		rp.getconfirmUserNameField().sendKeys("niti");
		logger.info("Entered ConfirmUserName");
		Thread.sleep(1000);
		j.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		rp.getagreetermCheckBox().click();
		logger.info("Clicked Checkbox");
		Thread.sleep(2000);
		rp.getclickRegisterButton().click();
		logger.info("Clicked On Register Button");
		Thread.sleep(2000);
	}

	@Test(priority = 6)
	public void withoutAgreeTermCheckBox() throws InterruptedException {
		RegistrationPage rp=new RegistrationPage(driver);
		rp.getGotItButton().click();
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		rp.getClickRegisterNow().click();
		Thread.sleep(2000);
		logger.info("Clicked RegisterNow Button");
		rp.nameField.sendKeys("Niti");
		logger.info("Entered Name");
		Thread.sleep(1000);
		rp.getemailField().sendKeys("Niti123@gmail.com");
		logger.info("Entered Email Address");
		Thread.sleep(1000);
		rp.getmobileField().sendKeys("9486779737");
		logger.info("Entered Phone Number");
		Thread.sleep(1000);
		rp.getuserNameField().sendKeys("nitikv1234");
		logger.info("Entered UserName");
		Thread.sleep(1000);
		rp.getconfirmUserNameField().sendKeys("nitikv1234");
		logger.info("Entered ConfirmUserName");
		Thread.sleep(1000);
		rp.getagreetermCheckBox();
		logger.info("Clicked Checkbox");
		Thread.sleep(2000);
		j.executeScript("window.scrollBy(0,500)");
		rp.getclickRegisterButton().click();
		logger.info("Clicked On Register Button");
		Thread.sleep(2000);
	}
	@Test(priority = 3)
	public void loginWithExistingDataAgain() throws InterruptedException {
		RegistrationPage rp=new RegistrationPage(driver);
		rp.getGotItButton().click();
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		rp.getClickRegisterNow().click();
		Thread.sleep(2000);
		logger.info("Clicked RegisterNow Button");
		rp.nameField.sendKeys("Amit");
		logger.info("Entered Name");
		Thread.sleep(1000);
		rp.getemailField().sendKeys("amitvv123@gmail.com");
		logger.info("Entered Email Address");
		Thread.sleep(1000);
		rp.getmobileField().sendKeys("9486779737");
		logger.info("Entered Phone Number");
		Thread.sleep(1000);
		rp.getuserNameField().sendKeys("amitvv1234");
		logger.info("Entered UserName");
		Thread.sleep(1000);
		rp.getconfirmUserNameField().sendKeys("amitvv1234");
		logger.info("Entered ConfirmUserName");
		Thread.sleep(1000);
		rp.getagreetermCheckBox().click();
		logger.info("Clicked Checkbox");
		Thread.sleep(2000);
		j.executeScript("window.scrollBy(0,500)");
		rp.getclickRegisterButton().click();
		logger.info("Clicked On Register Button");
		Thread.sleep(2000);	
	}
	@Test(priority = 7)
	public void alreadyAnUser() throws InterruptedException {
		RegistrationPage rp=new RegistrationPage(driver);
		rp.getGotItButton().click();
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		rp.getClickRegisterNow().click();
		Thread.sleep(3000);
		logger.info("Clicked RegisterNow Button");
		rp.getclickImAlreadyUser().submit();
		logger.info("Clicked I'm already an User Button");
	}
	@Test(priority = 8)
	public void withClickHelp() throws InterruptedException, AWTException {
		RegistrationPage rp=new RegistrationPage(driver);
		rp.getGotItButton().click();
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		rp.getClickRegisterNow().click();
		Thread.sleep(2000);
		logger.info("Clicked RegisterNow Button");
		rp.getclickHelp().click();
		logger.info("Clicked Help Button");
		Thread.sleep(3000);
		 Robot r=new Robot();
		 r.keyPress(KeyEvent.VK_ESCAPE);
	}
	@AfterMethod
	public void CloseBrowser() {
		driver.close();
	}
}
