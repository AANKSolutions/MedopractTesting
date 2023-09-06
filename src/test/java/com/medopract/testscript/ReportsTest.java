package com.medopract.testscript;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.medopract.generic.BaseClass;
import com.medopract.pom.AddPatientPage;
import com.medopract.pom.LoginPage;
import com.medopract.pom.ReportsPage;

public class ReportsTest extends BaseClass{
	Logger logger= LogManager.getLogger(ReportsTest.class);


	@BeforeClass
	public void OpenApplication() throws  IOException {
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
	public void PatientsTab()  {
		ReportsPage rp = new ReportsPage(driver);
		rp.getClickReports();
		logger.info("Clicked on Reports");
		rp.getPatientsTab();
		logger.info("Clicked On Patients Tab");
		rp.getYearlyTab();
		logger.info("Clicked on Yearly Tab");
		rp.getDailyTab();
		logger.info("Clicked on Daily Tab");
		rp.getMonthlyTab();
		logger.info("Clicked on Monthly Tab");
		rp.getWeeklyTab();
		logger.info("Clicked on Weekly Tab");
		rp.getDailyTab();
		logger.info("Clicked on Daily Tab");
		rp.getMonthlyTab();
		logger.info("Clicked on Monthly Tab");
		rp.getWeeklyTab();
		logger.info("Clicked on Weekly Tab");
		rp.getWeeklyTab();
		logger.info("Clicked on Weekly Tab");
		rp.getMonthlyTab();
		logger.info("Clicked on Monthly Tab");
	}



	@Test(priority = 2)
	public void addPatient() throws EncryptedDocumentException, IOException  {
		ReportsPage rp = new ReportsPage(driver);
		rp.getClickAddPatient();
		AddPatientPage app=new AddPatientPage(driver);
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
		logger.info("Entered BirthDate Field");
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
		app.getSaveButton();

		String expectedResult="Patient Record created successfully!";
		String actualResult=app.getCreatedSuccessfully().getText();
		Assert.assertEquals(actualResult, expectedResult);

		app.getcancelNotification();
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority=3)
	public void dateView(){
		ReportsPage rp=new ReportsPage(driver);
		rp.getClickReports();
		logger.info("Clicked on Reports");

		String TodayDate=rp.gettodayDateView().getText();
		String ActualDate="Wed, Jul 19 2023";

		Assert.assertEquals(TodayDate,ActualDate);
	}

	@Test(priority = 4)
	public void cancel()  {
		ReportsPage rp = new ReportsPage(driver);
		LoginPage l=new LoginPage(driver);
		rp.getCancelButton();
		logger.info("Clicked on Cancel Button");

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
