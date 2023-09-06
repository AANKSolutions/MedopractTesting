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
import com.medopract.pom.AddPatientPage;
import com.medopract.pom.LoginPage;

public class AddPatientTest extends BaseClass {
	Logger logger= LogManager.getLogger(AddPatientTest.class);
		
	@BeforeClass
	public void OpenApplication() throws  IOException  {
		driver= initializeDriver(); 
		driver.get(getPropertyData("url"));
		logger.info("Navigated to Application URL");
        base=new BaseClass();
		LoginPage l=new LoginPage(driver);
		l.getGotItButton();
		l.setUsername(getPropertyData("un")); 
		logger.info("Entered UserName Field");
		l.setPassword(getPropertyData("pw"));
		logger.info("Entered Password Field");
		l.getSubmitButton();
		logger.info("Clicked Submit Button");
         
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
	public void AddPatient() throws Exception {

	    AddPatientPage app = new AddPatientPage(driver);
	    app.getPatientsClick();
	    logger.info("Clicking Patients");
	    
	    app.getAddPatientClick();
	    logger.info("Clicking Add Patient");
	    
	    app.getPatientNameField().sendKeys(getExcelData("Add Patient", 1, 1));
	    logger.info("Added Patient's Name");
	    
	    app.getPhoneNoField().sendKeys(getExcelData("Add Patient", 3, 1));
	    logger.info("Added Patient's Phone Number");
	    
	    app.getgenderField();
	    logger.info("Selected Gender Field");
	    
	    app.getbirthDateField();
	    app.getmonthField().sendKeys(getExcelData("Add Patient", 5, 1));
	    app.getDayField().sendKeys(getExcelData("Add Patient", 6, 1));
	    app.getYearField().sendKeys(getExcelData("Add Patient", 7, 1));
	    
	    app.getBloodGroupField();
	    logger.info("Selected Blood Group");
	    
	    app.getOccupationField().sendKeys(getExcelData("Add Patient", 8, 1));
	    logger.info("Added Occupation Field");
	    
	    app.getAddressField().sendKeys(getExcelData("Add Patient", 9, 1));
	    logger.info("Added Address");
	    
	    app.getEmergencyField().sendKeys(getExcelData("Add Patient", 10, 1));
	    logger.info("Added Emergency contact no field");
	    
	    app.getAllergiesField().sendKeys(getExcelData("Add Patient", 12, 1));
	    logger.info("Added Allergy field");
	    
	    app.getRemarksField().sendKeys(getExcelData("Add Patient", 13, 1));
	    logger.info("Added Remark field");
	    
	    app.getHistoryField().sendKeys(getExcelData("Add Patient", 14, 1));
	    logger.info("Added History field");
	    
	    app.getHabitsField().sendKeys(getExcelData("Add Patient", 15, 1));
	    logger.info("Entered Habit field");
	  
	    app.getClickingPlusSign();
	    logger.info("Added Habit field by clicking Plus");
	    
	    app.getHabitsField().sendKeys(getExcelData("Add Patient", 16, 1));
	    logger.info("Entered Habit field");
	    
	    app.getClickingPlusSign();
	    logger.info("Added Habit field by clicking Plus");
	    
	    app.getHabitsField().sendKeys(getExcelData("Add Patient", 15, 1));
	    logger.info("Entered Habit field");
	    
	    app.getClickingPlusSign();
	    logger.info("Added Habit field by clicking Plus");
	    
	    app.getcancelHabit();
	    
	    app.getSaveButton();
	    
	    String expectedResult = "Patient Record created successfully!";
	    String actualResult = app.getCreatedSuccessfully().getText();
	    Assert.assertEquals(actualResult, expectedResult);
	    
	    app.getcancelNotification();
	    logger.info("Clicked Cancel Notification");
	}


	@Test(priority = 2)
	public void resetPatientData() throws InterruptedException  {

		AddPatientPage app=new AddPatientPage(driver);
		app.getResetButton();
		logger.info("Clicked ResetButton"); 
         Thread.sleep(2000);
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
	public void withoutMandatoryAllData()  {

		AddPatientPage app=new AddPatientPage(driver);
		app.getPatientsClick();
		logger.info("Clicking Patients");
		app.getAddPatientClick();
		logger.info("Clicking Add Patient");
		app.getPatientNameField().clear();		
		logger.info("Added Patient's Name");
		app.getPhoneNoField().clear();
		logger.info("Added Patient's Phone Number");
		app.getOccupationField().clear();
		logger.info("Added Occupation Field");
		app.getAddressField().clear();
		logger.info("Added Address");
		app.getEmergencyField().clear();
		logger.info("Added Emergency contact no field");
		app.getAllergiesField().clear();
		logger.info("Added Allergy field");
		app.getRemarksField().clear();
		logger.info("Added Remark field");
		app.getHistoryField().clear();
		logger.info("Added History field");
		app.getHabitsField().clear();
		logger.info("Entered Habit field");
		app.getClickingPlusSign();
		logger.info("Added Habit field by clicking Plus");
		app.getSaveButton();
		logger.info("Clicked SaveButton");

		String actualResult = app.getErrorMessage().getText();
		String expectedResult = "Please provide required inputs";
		Assert.assertEquals(actualResult, expectedResult);

		app.getcancelNotification();
		logger.info("Clicked Cancel Notification");
	}


	@Test(priority=4)
	public void nameWithSpecialCharacter() throws InterruptedException, EncryptedDocumentException, IOException {
		AddPatientPage app=new AddPatientPage(driver);
		app.getPatientNameField().sendKeys(getExcelData("Add Patient", 2, 1));
		logger.info("Added Patient's Name");
		app.getPhoneNoField().sendKeys(getExcelData("Add Patient", 3, 1));

		String expectedTitle = "Please enter valid name- Only Alphabets and spaces are allowed";
		String actualTitle = app.getnameErrorMsg().getText();
		Assert.assertEquals(expectedTitle, actualTitle);


	}
	@Test(priority = 5)
	public void withIncorrectPhoneNo() throws Exception, Exception  {

		AddPatientPage app=new AddPatientPage(driver);
		app.getPatientNameField().clear();
		logger.info("Cleared Patient's Name");
		app.getPhoneNoField().sendKeys(getExcelData("Add Patient", 4, 1));
		logger.info("Added Patient's Phone Number");
		app.getgenderField();
		logger.info("Selected Gender Field");

		String expectedTitle = "Mobile number must be 10 digits long valid number";
		String actualTitle = app.getMobileNoErrorMsg().getText();
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@Test(priority = 6)
	public void sameContactNoInEmergencyField() throws EncryptedDocumentException, IOException  {
		AddPatientPage app=new AddPatientPage(driver);
		app.getPatientsClick();
		logger.info("Clicking Patients");
		app.getAddPatientClick();
		logger.info("Clicking Add Patient");
		app.getPatientNameField().sendKeys(getExcelData("Add Patient", 1, 1));
		logger.info("Added Patient's Name");
		app.getPhoneNoField().clear();
		app.getPhoneNoField().sendKeys(getExcelData("Add Patient", 3, 1));
		logger.info("Added Patient's Phone Number");
		app.getgenderField();
		logger.info("Selected Gender Field");
		app.getbirthDateField();
		app.getmonthField().sendKeys(getExcelData("Add Patient", 5, 1));
		app.getDayField().sendKeys(getExcelData("Add Patient", 6, 1));
		app.getYearField().sendKeys(getExcelData("Add Patient", 7, 1));
		app.getBloodGroupField();
		logger.info("Selected Blood Group");
		app.getOccupationField().sendKeys(getExcelData("Add Patient", 8, 1));
		logger.info("Added Occupation Field");
		app.getAddressField().sendKeys(getExcelData("Add Patient", 9, 1));
		logger.info("Added Address");
		app.getEmergencyField().sendKeys(getExcelData("Add Patient", 11, 1));
		logger.info("Added Emergency contact no field");
		app.getAllergiesField().sendKeys(getExcelData("Add Patient", 12, 1));
		logger.info("Added Allergy field");
		app.getRemarksField().sendKeys(getExcelData("Add Patient", 13, 1));
		logger.info("Added Remark field");
		app.getHistoryField().sendKeys(getExcelData("Add Patient", 14, 1));
		logger.info("Added History field");
		app.getHabitsField().sendKeys(getExcelData("Add Patient", 15, 1));
		logger.info("Entered Habit field");
		app.getClickingPlusSign();
		logger.info("Added Habit field by clicking Plus");
		app.getSaveButton();

		String expectedResult="Patient Record created successfully!";
		String actualResult=app.getCreatedSuccessfully().getText();
		Assert.assertEquals(actualResult, expectedResult);

		app.getcancelNotification();
		logger.info("Clicked Cancel Notification");
	}



	@AfterClass
	public void logout() {
		driver.close();
		logger.info("Closed Browser");
	}
}
