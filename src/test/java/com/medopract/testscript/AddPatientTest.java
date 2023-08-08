package com.medopract.testscript;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.medopract.generic.BaseClass;
import com.medopract.pom.AddPatientPage;
import com.medopract.pom.LoginPage;

public class AddPatientTest extends BaseClass {
	Logger logger= LogManager.getLogger(AddPatientTest.class);

	    String url;
		String un;
		String pw;
		
		String AddPatient_Name1;
		String AddPatient_Name2;
		String AddPatient_Phno1;
		String AddPatient_Phno2;
		String AddPatient_Month;
		String AddPatient_Day;
		String AddPatient_Year;
		String AddPatient_Occupation;
		String AddPatient_Address;
		String AddPatient_EmergencyPhno1;
		String AddPatient_EmergencyPhno2;
		String AddPatient_Allergy;
		String AddPatient_Remark;
		String AddPatient_History;
		String AddPatient_Habit1;
		String AddPatient_Habit2;
		
	@BeforeClass
	public void OpenApplication() throws  IOException  {
		driver= initializeDriver();
		 url = f.getPropertyData("url");
		 un = f.getPropertyData("un");
		 pw = f.getPropertyData("pw");
			
		 AddPatient_Name1=f.getExcelData("Add Patient", 1, 1);
		 AddPatient_Name2=f.getExcelData("Add Patient", 2, 1);
		 AddPatient_Phno1=f.getExcelData("Add Patient", 3, 1);
		 AddPatient_Phno2=f.getExcelData("Add Patient", 4, 1);
		 AddPatient_Month=f.getExcelData("Add Patient", 5, 1);
		 AddPatient_Day=f.getExcelData("Add Patient", 6, 1);
		 AddPatient_Year=f.getExcelData("Add Patient", 7, 1);
		 AddPatient_Occupation=f.getExcelData("Add Patient", 8, 1);
		 AddPatient_Address=f.getExcelData("Add Patient", 9, 1);
		 AddPatient_EmergencyPhno1=f.getExcelData("Add Patient", 10, 1);
		 AddPatient_EmergencyPhno2=f.getExcelData("Add Patient", 11, 1);
		 AddPatient_Allergy=f.getExcelData("Add Patient", 12, 1);
		 AddPatient_Remark=f.getExcelData("Add Patient", 13, 1);
		 AddPatient_History=f.getExcelData("Add Patient", 14, 1);
		 AddPatient_Habit1=f.getExcelData("Add Patient", 15, 1);
		 AddPatient_Habit2=f.getExcelData("Add Patient", 16, 1);	 
		
		driver.get(url);
		logger.info("Navigated to Application URL");

		LoginPage l=new LoginPage(driver);
		l.getGotItButton();
		l.setUsername(un); 
		logger.info("Entered UserName Field");
		l.setPassword(pw);
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

		AddPatientPage app=new AddPatientPage(driver);
		app.getPatientsClick();
		
		logger.info("Clicking Patients");
		app.getAddPatientClick();
		logger.info("Clicking Add Patient");
		waitForElementVisibility(app.getPatientNameField(), null, AddPatient_Address, driver);
		app.getPatientNameField().sendKeys(AddPatient_Name1);
		logger.info("Added Patient's Name");
		app.getPhoneNoField().sendKeys(AddPatient_Phno1);
		logger.info("Added Patient's Phone Number");
		app.getgenderField();
		logger.info("Selected Gender Field");
		app.getbirthDateField();
		app.getmonthField().sendKeys(AddPatient_Month);
		app.getDayField().sendKeys(AddPatient_Day);
		app.getYearField().sendKeys(AddPatient_Year);
		app.getBloodGroupField();
		logger.info("Selected Blood Group");
		app.getOccupationField().sendKeys(AddPatient_Occupation);
		logger.info("Added Occupation Field");
		app.getAddressField().sendKeys(AddPatient_Address);
		logger.info("Added Address");
		app.getEmergencyField().sendKeys(AddPatient_EmergencyPhno1);
		logger.info("Added Emergency contact no field");
		app.getAllergiesField().sendKeys(AddPatient_Allergy);
		logger.info("Added Allergy field");
		app.getRemarksField().sendKeys(AddPatient_Remark);
		logger.info("Added Remark field");
		app.getHistoryField().sendKeys(AddPatient_History);
		logger.info("Added History field");
		app.getHabitsField().sendKeys(AddPatient_Habit1);
		logger.info("Entered Habit field");
		app.getClickingPlusSign();
		logger.info("Added Habit field by clicking Plus");
		app.getHabitsField().sendKeys(AddPatient_Habit2);
		logger.info("Entered Habit field");
		app.getClickingPlusSign();
		logger.info("Added Habit field by clicking Plus");
		app.getHabitsField().sendKeys(AddPatient_Habit1);
		logger.info("Entered Habit field");
		app.getClickingPlusSign();
		logger.info("Added Habit field by clicking Plus");
		app.getcancelHabit();
		Thread.sleep(2000);
		app.getSaveButton();

		String expectedResult="Patient Record created successfully!";
		String actualResult=app.getCreatedSuccessfully().getText();
		Assert.assertEquals(actualResult, expectedResult);

		app.getcancelNotification();
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority = 2)
	public void resetPatientData()  {

		AddPatientPage app=new AddPatientPage(driver);

		app.getSaveButton();
		logger.info("Clicked SaveButton");
		app.getResetButton();
		logger.info("Clicked ResetButton"); 

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
	public void nameWithSpecialCharacter() throws InterruptedException {
		AddPatientPage app=new AddPatientPage(driver);
		app.getPatientNameField().sendKeys(AddPatient_Name2);
		logger.info("Added Patient's Name");
		app.getPhoneNoField().sendKeys(AddPatient_Phno1);

		String expectedTitle = "Please enter valid name- Only Alphabets and spaces are allowed";
		String actualTitle = app.getnameErrorMsg().getText();
		Assert.assertEquals(expectedTitle, actualTitle);


	}
	@Test(priority = 5)
	public void withIncorrectPhoneNo()  {

		AddPatientPage app=new AddPatientPage(driver);
		app.getPatientNameField().clear();
		logger.info("Cleared Patient's Name");
		app.getPhoneNoField().sendKeys(AddPatient_Phno2);
		logger.info("Added Patient's Phone Number");
		app.getgenderField();
		logger.info("Selected Gender Field");

		String expectedTitle = "Mobile number must be 10 digits long valid number";
		String actualTitle = app.getMobileNoErrorMsg().getText();
		Assert.assertEquals(expectedTitle, actualTitle);
	}

	@Test(priority = 6)
	public void sameContactNoInEmergencyField()  {
		AddPatientPage app=new AddPatientPage(driver);
		app.getPatientsClick();
		logger.info("Clicking Patients");
		app.getAddPatientClick();
		logger.info("Clicking Add Patient");
		app.getPatientNameField().sendKeys(AddPatient_Name1);
		logger.info("Added Patient's Name");
		app.getPhoneNoField().clear();
		app.getPhoneNoField().sendKeys(AddPatient_Phno1);
		logger.info("Added Patient's Phone Number");
		app.getgenderField();
		logger.info("Selected Gender Field");
		app.getbirthDateField();
		app.getmonthField().sendKeys(AddPatient_Month);
		app.getDayField().sendKeys(AddPatient_Day);
		app.getYearField().sendKeys(AddPatient_Year);
		app.getBloodGroupField();
		logger.info("Selected Blood Group");
		app.getOccupationField().sendKeys(AddPatient_Occupation);
		logger.info("Added Occupation Field");
		app.getAddressField().sendKeys(AddPatient_Address);
		logger.info("Added Address");
		app.getEmergencyField().sendKeys(AddPatient_EmergencyPhno2);
		logger.info("Added Emergency contact no field");
		app.getAllergiesField().sendKeys(AddPatient_Allergy);
		logger.info("Added Allergy field");
		app.getRemarksField().sendKeys(AddPatient_Remark);
		logger.info("Added Remark field");
		app.getHistoryField().sendKeys(AddPatient_History);
		logger.info("Added History field");
		app.getHabitsField().sendKeys(AddPatient_Habit1);
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
