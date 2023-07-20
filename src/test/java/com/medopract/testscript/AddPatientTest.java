package com.medopract.testscript;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.medopract.generic.BaseClass;
import com.medopract.pom.AddPatientPage;
import com.medopract.pom.LoginPage;

public class AddPatientTest extends BaseClass {

	@BeforeClass
	public void OpenApplication() throws InterruptedException  {
		driver=OpenBrowser();
		driver.manage().window().maximize();  
		driver.get("https://medopractapi-zk64betx7a-em.a.run.app/patients");
		logger.info("Navigated to Application URL");
		Thread.sleep(2000);

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
	
	@Test(priority = 1)
	public void AddPatient() throws InterruptedException {
		
		AddPatientPage app=new AddPatientPage(driver);
		app.getPatientsClick().click();
		Thread.sleep(3000);
		logger.info("Clicking Patients");
		app.getAddPatientClick().click();
		Thread.sleep(2000);
		logger.info("Clicking Add Patient");
		app.getPatientNameField().sendKeys("Ashwin");
		Thread.sleep(2000);
		logger.info("Added Patient's Name");
		app.getPhoneNoField().sendKeys("9597277526");
		Thread.sleep(2000);
		logger.info("Added Patient's Phone Number");
		app.getgenderField().click();
		Thread.sleep(2000);
		logger.info("Selected Gender Field");
		app.getbirthDateField().click();
		Thread.sleep(2000);
		app.getmonthField().sendKeys("10");
		Thread.sleep(1000);
		app.getDayField().sendKeys("12");
		Thread.sleep(1000);
		app.getYearField().sendKeys("2000");
		Thread.sleep(1000);
		app.getBloodGroupField().click();
		Thread.sleep(2000);
		logger.info("Selected Blood Group");
		app.getOccupationField().sendKeys("Engineer");
		Thread.sleep(2000);
		logger.info("Added Occupation Field");
		app.getAddressField().sendKeys("BTM 2nd Stage");
		Thread.sleep(2000);
		logger.info("Added Address");
		app.getEmergencyField().sendKeys("6382565718");
		Thread.sleep(2000);
		logger.info("Added Emergency contact no field");
		app.getAllergiesField().sendKeys("Itching");
		Thread.sleep(2000);
		logger.info("Added Allergy field");
		app.getRemarksField().sendKeys("Normal");
		Thread.sleep(2000);
		logger.info("Added Remark field");
		app.getHistoryField().sendKeys("Nill");
		Thread.sleep(2000);
		logger.info("Added History field");
		app.getHabitsField().sendKeys("Eating Sweets");
		Thread.sleep(2000);
		logger.info("Entered Habit field");
		app.getClickingPlusSign().click();
		Thread.sleep(5000);
		logger.info("Added Habit field by clicking Plus");
		app.getSaveButton().submit();
		Thread.sleep(2000);
		
		String expectedResult="Patient Record created successfully!";
		String actualResult=app.getCreatedSuccessfully().getText();
		Assert.assertEquals(actualResult, expectedResult);
		
		app.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority = 2)
	public void resetPatientData() throws InterruptedException {
		
		AddPatientPage app=new AddPatientPage(driver);
		
		app.getSaveButton();
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,250)");
		
		Thread.sleep(5000);
		logger.info("Clicked SaveButton");
		app.getResetButton().click();
		logger.info("Clicked ResetButton"); 
		Thread.sleep(5000);
	    
		String actual = null;
		try {
			if(app.getCreatedSuccessfully().isDisplayed())
				actual="success";
		}
		catch(Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, "failure");
	}
	
	@Test(priority = 3)
	public void withoutMandatoryAllData() throws InterruptedException {
		
		AddPatientPage app=new AddPatientPage(driver);
		app.getPatientsClick().getLocation();
	    JavascriptExecutor j=(JavascriptExecutor)driver;
	    j.executeScript("window.scrollBy(0,0)");
		Thread.sleep(3000);
		logger.info("Clicking Patients");
		app.getAddPatientClick();
		Thread.sleep(4000);
		logger.info("Clicking Add Patient");
		app.getPatientNameField().sendKeys(" ");
		Thread.sleep(2000);
		logger.info("Added Patient's Name");
		app.getPhoneNoField().sendKeys(" ");
		Thread.sleep(2000);
		logger.info("Added Patient's Phone Number");
		app.getOccupationField().sendKeys(" ");
		Thread.sleep(2000);
		logger.info("Added Occupation Field");
		app.getAddressField().sendKeys(" ");
		Thread.sleep(2000);
		logger.info("Added Address");
		app.getEmergencyField().sendKeys(" ");
		Thread.sleep(2000);
		logger.info("Added Emergency contact no field");
		app.getAllergiesField().sendKeys(" ");
		Thread.sleep(2000);
		logger.info("Added Allergy field");
		app.getRemarksField().sendKeys(" ");
		Thread.sleep(2000);
		logger.info("Added Remark field");
		app.getHistoryField().sendKeys(" ");
		Thread.sleep(2000);
		logger.info("Added History field");
		app.getHabitsField().sendKeys(" ");
		Thread.sleep(2000);
		logger.info("Entered Habit field");
		app.getClickingPlusSign().click();
		Thread.sleep(2000);
		logger.info("Added Habit field by clicking Plus");
		app.getSaveButton().submit();
		Thread.sleep(2000);
		logger.info("Clicked SaveButton");
		Thread.sleep(2000);
		
		String actualResult = app.getErrorMessage().getText();
		String expectedResult = "Please provide required inputs";
		Assert.assertEquals(actualResult, expectedResult);
		
		app.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");
	}
	
	
	@Test(priority=4)
	public void nameWithSpecialCharacter() throws InterruptedException {
		AddPatientPage app=new AddPatientPage(driver);
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,0)");
		Thread.sleep(3000);
		app.getPatientNameField().sendKeys("@#&*()");
		Thread.sleep(2000);
		logger.info("Added Patient's Name");
		Thread.sleep(2000);
		app.getPhoneNoField().sendKeys(" ");
		
		String expectedTitle = "Please enter valid name- Only Alphabets and spaces are allowed";
		String actualTitle = app.getnameErrorMsg().getText();
		Assert.assertEquals(expectedTitle, actualTitle);
		
		
	}
	@Test(priority = 5)
	public void withIncorrectPhoneNo() throws InterruptedException {
		
		AddPatientPage app=new AddPatientPage(driver);
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,0)");
		Thread.sleep(3000);
		app.getPatientNameField().clear();
		logger.info("Cleared Patient's Name");
		app.getPhoneNoField().sendKeys("959727752");
		Thread.sleep(2000);
		logger.info("Added Patient's Phone Number");
		app.getgenderField().click();
		Thread.sleep(2000);
		logger.info("Selected Gender Field");
		
		String expectedTitle = "Mobile number must be 10 digits long valid number";
		String actualTitle = app.getMobileNoErrorMsg().getText();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
	
	@Test(priority = 6)
	public void sameContactNoInEmergencyField() throws InterruptedException {
		AddPatientPage app=new AddPatientPage(driver);
		
		app.getPatientNameField().sendKeys("Ashwin");
		Thread.sleep(2000);
		logger.info("Added Patient's Name");
		app.getPhoneNoField().clear();
		app.getPhoneNoField().sendKeys("9597277526");
		Thread.sleep(2000);
		logger.info("Added Patient's Phone Number");
		app.getgenderField().click();
		Thread.sleep(2000);
		logger.info("Selected Gender Field");
		app.getbirthDateField().click();
		Thread.sleep(2000);
		app.getmonthField().sendKeys("10");
		Thread.sleep(1000);
		app.getDayField().sendKeys("12");
		Thread.sleep(1000);
		app.getYearField().sendKeys("2000");
		Thread.sleep(1000);
		Thread.sleep(2000);
		app.getBloodGroupField().click();
		Thread.sleep(2000);
		logger.info("Selected Blood Group");
		app.getOccupationField().sendKeys("Engineer");
		Thread.sleep(2000);
		logger.info("Added Occupation Field");
		app.getAddressField().sendKeys("BTM 2nd Stage");
		Thread.sleep(2000);
		logger.info("Added Address");
		app.getEmergencyField().sendKeys("9597277526");
		Thread.sleep(2000);
		logger.info("Added Emergency contact no field");
		app.getAllergiesField().sendKeys("Itching");
		Thread.sleep(2000);
		logger.info("Added Allergy field");
		app.getRemarksField().sendKeys("Normal");
		Thread.sleep(2000);
		logger.info("Added Remark field");
		app.getHistoryField().sendKeys("Nill");
		Thread.sleep(2000);
		logger.info("Added History field");
		app.getHabitsField().sendKeys("Eating Sweets");
		Thread.sleep(2000);
		logger.info("Entered Habit field");
		app.getClickingPlusSign().click();
		Thread.sleep(5000);
		logger.info("Added Habit field by clicking Plus");
		app.getSaveButton().submit();
		Thread.sleep(2000);
		
		String expectedResult="Patient Record created successfully!";
		String actualResult=app.getCreatedSuccessfully().getText();
		Assert.assertEquals(actualResult, expectedResult);
		
		app.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");
	}



	@AfterClass
	public void logout() {
		driver.close();
		logger.info("Closed Browser");
	}
}
