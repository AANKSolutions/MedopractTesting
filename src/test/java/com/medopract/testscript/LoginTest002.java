package com.medopract.testscript;

import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.medopract.generic.BaseClass;
import com.medopract.pom.LoginPage;

public class LoginTest002 extends BaseClass {
	Logger logger=LogManager.getLogger(LoginTest002.class);
	
	@BeforeMethod
	public void openBrowser() throws IOException {
		initializeDriver();
		logger.info("Open Browser");
		driver.get(getPropertyData("url"));
		
	}

	@DataProvider(name = "LoginData")
	public Object[][] LoginData(){
		Object[][] data= {
				{"ashwinkv016", "ashwinkv016", "successful"},
				{"ashwinkv016", "ashwin", "failure"},
				{"ashwin", "ashwinkv016", "failure"},
				{" ", " ", "failure"}
		};
		return data;		
	}
	
	@Test(dataProvider = "LoginData")
	public void login(String un, String pass, String expected) throws InterruptedException {
		LoginPage l=new LoginPage(driver);
		l.getGotItButton();
		logger.info("Clicked Got It Btn");
		l.getUsername().sendKeys(un);
		logger.info("Entered UserName");
		Thread.sleep(1000);
		l.getPassword().sendKeys(pass);
		logger.info("Entered Password");
		Thread.sleep(1000);
		l.getSubmitButton();
		logger.info("Clicked Submit Btn");
		
       Thread.sleep(2000);
		
		String actual = null;
		try {
			if (expected.equalsIgnoreCase("successful")) {
				logger.info("user got logged in");
				Assert.assertTrue(l.getaccInfo().isDisplayed());
				actual = "successful";
				l.getLogoutBtn();
				logger.info("Clicked logout Btn");
			}
		} catch (Exception e) {
			actual = "failure";
			logger.info("User didn't login");
			l.getcancelNotification();
		}
		
	}
		@AfterMethod
		public void closeBrowser() {
			driver.close();
			logger.info("Browser got closed");
		}
	
}

