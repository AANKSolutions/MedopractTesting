package com.medopract.testscript;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.medopract.generic.BaseClass;
import com.medopract.pom.LoginPage;

public class LoginTest extends BaseClass {

	@BeforeClass
	public void OpenApplication() throws InterruptedException {
		driver=OpenBrowser();
		driver.manage().window().maximize();  
		driver.get("https://medopractapi-zk64betx7a-em.a.run.app/");
		logger.info("Navigated to Application URL");
		Thread.sleep(2000);
		
		
		Assert.assertEquals("MedoPract App", driver.getTitle());
	}


	@Test(priority = 1)
	public void loginWithoutData() throws InterruptedException {
		LoginPage l=new LoginPage(driver);
		l.getGotItButton().click();
		Thread.sleep(2000);
		l.getUsername().clear();
		logger.info("Entered Username without data");
		Thread.sleep(2000);
		l.getPassword().clear();
		logger.info("Entered Username without data");
		Thread.sleep(2000);
		l.getSubmitButton().submit();
		logger.info("Clicked submit button");
		Thread.sleep(2000);
			
		String expectedResult="No record available with Doctor ID :";
		String actualResult=l.geterrorMsgNotification().getText();
		Assert.assertEquals(actualResult, expectedResult);
		
		l.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");             	
	}
	
	@Test(priority = 2)
	public void loginWithoutPassword() throws InterruptedException {
		LoginPage l=new LoginPage(driver);
		
		l.getUsername().sendKeys("ashwinkv016");
		logger.info("Entered Username");
		Thread.sleep(2000);
		l.getPassword().clear();
		logger.info("Cleared Password");
		Thread.sleep(2000);
		l.getSubmitButton().submit();;
		logger.info("Clicked submit button");
		Thread.sleep(2000); 
	

		String expectedResult="Invalid Password!";
		String actualResult=l.geterrorMsgNotification().getText();
		Assert.assertEquals(actualResult, expectedResult);
		
		l.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");    

	}
	
	@Test(priority = 3)
	public void loginWithoutUsername() throws InterruptedException {
		LoginPage l=new LoginPage(driver);
		l.getUsername().clear();
		l.getUsername().sendKeys(" ");
		logger.info("Cleared Username without data");
		Thread.sleep(2000);
		l.getPassword().sendKeys("ashwinkv016");
		logger.info("Entered Password");
		Thread.sleep(2000);
		l.getSubmitButton().click();
		logger.info("Clicked submit button");
		Thread.sleep(2000); 
		

		String expectedResult="No record available with Doctor ID :";
		String actualResult=l.geterrorMsgNotification().getText();
		Assert.assertEquals(actualResult, expectedResult);
		
		l.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");    
	}
	
	
	@Test(priority=4)
	public void incorrectDetails() throws InterruptedException {
		LoginPage l=new LoginPage(driver);
		l.getUsername().clear();
		l.getUsername().sendKeys("@#$%");
		logger.info("Entered Username");
		Thread.sleep(2000);
		l.getPassword().clear();
		l.getPassword().sendKeys("12345@@2");
		logger.info("Entered Password");
		Thread.sleep(2000);
		l.getSubmitButton().submit();;
		logger.info("Clicked submit button");
		Thread.sleep(2000); 
		
		String expectedResult="No record available with Doctor ID :@#$%";
		String actualResult=l.geterrorMsgNotification().getText();
		Assert.assertEquals(actualResult, expectedResult);
		
		l.getcancelNotification().click();
		Thread.sleep(7000);
		logger.info("Clicked Cancel Notification");
	
	}
	

	@Test(priority = 5)
	public void loginwithoutRememberMe() throws InterruptedException {
		LoginPage l=new LoginPage(driver);
		l.getUsername().clear();
		l.getUsername().sendKeys("ashwinkv016");
		logger.info("Entered Username");
		Thread.sleep(2000);
		l.getPassword().clear();
		l.getPassword().sendKeys("ashwinkv016");
		logger.info("Entered Password");
		Thread.sleep(2000);
		l.getSubmitButton().submit();
		logger.info("Clicked submit button");
		Thread.sleep(5000); 
				
		String actual = null;
		try {
			if(l.getaccInfo().isDisplayed())
				actual="success";
		}
		catch(Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, "success");
		
		l.getLogoutBtn().click();
		Thread.sleep(5000);
		logger.info("Clicked logout");
	}
	
	@Test(priority = 6)
	public void loginWithRememberMe() throws InterruptedException {
		LoginPage l=new LoginPage(driver);
		l.getUsername().clear();
		l.getUsername().sendKeys("ashwinkv016");
		logger.info("Entered Username");
		Thread.sleep(2000);
		l.getPassword().clear();
		l.getPassword().sendKeys("ashwinkv016");
		logger.info("Entered Password");
		Thread.sleep(2000);
		l.getrememberMeBtn().click();
		Thread.sleep(2000);
		logger.info("Clicked Remember me Button");
		l.getSubmitButton().submit();
		logger.info("Clicked submit button");
		Thread.sleep(5000); 
		
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

