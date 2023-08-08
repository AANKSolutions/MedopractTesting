package com.medopract.testscript;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
	String url;
	String un;
	String pw;
	
	String AddPatient_Name1;
	String AddPatient_Phno1;
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
	@BeforeClass
	public void OpenApplication() throws  IOException {
		driver= initializeDriver();
		 url = f.getPropertyData("url");
		 un = f.getPropertyData("un");
		 pw = f.getPropertyData("pw");
		 AddPatient_Name1=f.getExcelData("Add Patient", 1, 1);
		 AddPatient_Phno1=f.getExcelData("Add Patient", 3, 1);
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
	public void addPatient()  {
		ReportsPage rp = new ReportsPage(driver);
		rp.getClickAddPatient();
		AddPatientPage app=new AddPatientPage(driver);
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
		logger.info("Entered BirthDate Field");
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
