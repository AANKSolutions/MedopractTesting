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
import com.medopract.pom.AddPatientPage;
import com.medopract.pom.LoginPage;
import com.medopract.pom.ViewOrEditPage;


public class ViewOrEditTest extends BaseClass{
	@BeforeClass
	public void OpenApplication() throws InterruptedException {
		driver=OpenBrowser();
		driver.manage().window().maximize();
		driver.get("https://medopractapi-zk64betx7a-em.a.run.app/");
		logger.info("Navigated to Application URL"); 

		LoginPage l=new LoginPage(driver);
		l.getGotItButton().click();
		Thread.sleep(2000);
		l.getUsername().sendKeys("ashwinkv016"); 
		logger.info("Entered UserName Field");
		l.getPassword().sendKeys("ashwinkv016");
		logger.info("Entered Password Field");
		Thread.sleep(2000);
		l.getSubmitButton().submit();
		logger.info("Clicked Submit Button");
		Thread.sleep(2000);

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

	@Test(priority=1)
	public void deleteList() throws InterruptedException, AWTException {
		AddPatientPage ap=new AddPatientPage(driver);
		ap.getPatientsClick().click();
		logger.info("Clicking Add Patient");
		Thread.sleep(3000);

		ViewOrEditPage voe=new ViewOrEditPage(driver);
		voe.getViewOrEdit().click();
		logger.info("Clicked View or edit");
		Thread.sleep(3000);
		voe.getPatientNameField().sendKeys("Ashwin");
		logger.info("Entered Patient Name");
		Thread.sleep(3000);
		voe.getDeleteButtonClick().click();
		Thread.sleep(3000);
		logger.info("Clicked delete button");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		logger.info("Pressed Enter");
		Thread.sleep(4000);

		String actual="Patient record deleted successfully!";
		String expected=voe.getdeleteUpdateMsg().getText();
		Assert.assertEquals(actual, expected);

		voe.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");
	}


	@Test(priority = 2)
	public void ViewOrEdit() throws InterruptedException {
		ViewOrEditPage voe=new ViewOrEditPage(driver);
		voe.getPatientListClick().click();
		logger.info("Clicked Patient List");
		Thread.sleep(3000);
		voe.getUpdateButtonClick().submit();
		logger.info("Clicked Update Button");
		Thread.sleep(3000);

		String actual="Patient record updated successfully!";
		String expected=voe.getsuccessUpdateMsg().getText();
		Assert.assertEquals(actual, expected);

		voe.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority  =3)
	public void updateContactField() throws InterruptedException, AWTException {

		ViewOrEditPage voe=new ViewOrEditPage(driver);
		AddPatientPage ap=new AddPatientPage(driver);
		Thread.sleep(3000);
		ap.getPhoneNoField().clear();
		ap.getPhoneNoField().sendKeys("9597277526");
		Thread.sleep(1000);
		ap.getEmergencyField().clear();
		ap.getEmergencyField().sendKeys("9597277526");
		Thread.sleep(1000);
		voe.getUpdateButtonClick().submit();
		logger.info("Clicked Update Button");
		Thread.sleep(3000);
		
		String actual="Patient record updated successfully!";
		String expected=voe.getsuccessUpdateMsg().getText();
		Assert.assertEquals(actual, expected);

		voe.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");
	}
	
	@Test(priority=4)
	public void withoutMandatoryData() throws InterruptedException, AWTException {
		ViewOrEditPage voe=new ViewOrEditPage(driver);
		AddPatientPage ap=new AddPatientPage(driver);
		ap.getPatientNameField().clear();
		Thread.sleep(3000);
		logger.info("Cleared Name Field");
		ap.getPhoneNoField().clear();
		logger.info("Cleared Phone Number Field");
		Thread.sleep(2000);
		voe.getUpdateButtonClick().submit();
		logger.info("Clicked Update Button");
		Thread.sleep(4000);
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ALT);
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_ALT);
		Thread.sleep(1000);
		
		String actual="Please provide required inputs";
		String expected=voe.geterrorUpdateMsg().getText();
		Assert.assertEquals(actual, expected);

		voe.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");
	}
	
	@Test(priority =5)
	public void withoutAddressField() throws InterruptedException {
		ViewOrEditPage voe=new ViewOrEditPage(driver);
		AddPatientPage ap=new AddPatientPage(driver);
		ap.getAddressField().clear();
		Thread.sleep(2000);
		voe.getUpdateButtonClick().submit();
		logger.info("Clicked Update Button");
		Thread.sleep(3000);
	}

	@Test(priority = 6)
	public void cancelEdit() throws InterruptedException {
		ViewOrEditPage voe=new ViewOrEditPage(driver);
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,750)");
		voe.getCancelButtonClick().click();
		logger.info("Clicked Cancel Button");
		Thread.sleep(2000);

	}


	@AfterClass
	public void CloseBrowser() {
		driver.close();
		logger.info("Closing Browser");
	}
}
