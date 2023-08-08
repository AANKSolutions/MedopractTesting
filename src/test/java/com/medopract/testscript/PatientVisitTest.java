package com.medopract.testscript;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.medopract.generic.BaseClass;
import com.medopract.generic.FileLib;
import com.medopract.pom.LoginPage;
import com.medopract.pom.PatientVisitPage;


public class PatientVisitTest extends BaseClass {
	Logger logger= LogManager.getLogger(PatientVisitTest.class);
	String url;
	String un;
	String pw;
	String PatientVisit_Name;
	String PatientVisit_PrimaryComplaint;
	String PatientVisit_Symptoms1;
	String PatientVisit_Symptoms2;
	String PatientVisit_BloodPressure;
	String PatientVisit_SugarLevel;
	String PatientVisit_HeartRate;
	String PatientVisit_investigations1;
	String PatientVisit_investigations2;
	String PatientVisit_Observation;
	String PatientVisit_Remark;
	String PatientVisit_Reason;
	
	@BeforeClass
	public void OpenApplication() throws  IOException {
		driver= initializeDriver();
		FileLib f=new FileLib();
		 url = f.getPropertyData("url");
		 un = f.getPropertyData("un");
		 pw = f.getPropertyData("pw");
		 PatientVisit_Name=f.getExcelData("Patient Visit", 1, 1);
		 PatientVisit_PrimaryComplaint=f.getExcelData("Patient Visit", 2, 1);
		 PatientVisit_Symptoms1=f.getExcelData("Patient Visit", 3, 1);
		 PatientVisit_Symptoms2=f.getExcelData("Patient Visit", 4, 1);
		 PatientVisit_BloodPressure=f.getExcelData("Patient Visit", 5, 1);
		 PatientVisit_SugarLevel=f.getExcelData("Patient Visit", 6, 1);
		 PatientVisit_HeartRate=f.getExcelData("Patient Visit", 7, 1);
		 PatientVisit_investigations1=f.getExcelData("Patient Visit", 8, 1);
		 PatientVisit_investigations2=f.getExcelData("Patient Visit", 9, 1);
		 PatientVisit_Observation=f.getExcelData("Patient Visit", 10, 1);
		 PatientVisit_Remark=f.getExcelData("Patient Visit", 11, 1);
		 PatientVisit_Reason=f.getExcelData("Patient Visit", 12, 1);
		 
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
	public void addNewPatientData()  {
		PatientVisitPage pvp=new PatientVisitPage(driver);
		pvp.getPatientsClick();
		logger.info("Clicked Patients Field");
		pvp.getPatientvisitClick();
		logger.info("Clicked Patient Visit");
		pvp.getaddNewPatientHyperLink();
		logger.info("Clicked Add New Patient HyperLink");
		
		String actual=null;
		try {
			if(pvp.getaddPatientPage().isDisplayed())
				logger.info("Entered Add NewPatient page");
				actual="success";
		}
		catch(Exception e) {
			logger.info("Failed to enter to Add NewPatient page");
			actual="failure";
		}
		Assert.assertEquals(actual, "success");
	}

	@Test(priority=2)
	public void patientVisitWithoutPrimaryComplaint()  {
		PatientVisitPage pvp=new PatientVisitPage(driver);
		pvp.getPatientsClick();
		logger.info("Clicked Patients Field");
		pvp.getPatientvisitClick();
		logger.info("Clicked Patient Visit");
		pvp.getPatientVisitName().sendKeys(PatientVisit_Name);
		logger.info("Clicked Patient Name Field");
		pvp.getpatientVisitNameSuggestions();
		logger.info("Clicked Patient Nmae Suggestion");
		pvp.getSymptoms().sendKeys(PatientVisit_Symptoms1);
		logger.info("Entered symptoms field");
		pvp.getClickingSymptomsPlusSign();
		logger.info("ClickedSymptoms Plus Sign");
		pvp.getbloodPressure().sendKeys(PatientVisit_BloodPressure);
		logger.info("Entered Blood Pressure Level");
		pvp.getsugarLevel().sendKeys(PatientVisit_SugarLevel);
		logger.info("Entered SugarLevel");
		pvp.getheartRate().sendKeys(PatientVisit_HeartRate);
		logger.info("Entered Heart Rate Level");
		pvp.getInvestigationTests().sendKeys(PatientVisit_investigations1);
		logger.info("Entered Investigation Test");
		pvp.getClickingInvestigationPlusSign();
		logger.info("Clicked Investigation Plus Sign");
		pvp.getclinicalObservation().sendKeys(PatientVisit_Observation);
		logger.info("Entered Clinical Observation");
		pvp.getdiagnosisRemark().sendKeys(PatientVisit_Remark);
		logger.info("Entered Diagnosis Remark");
		pvp.getSaveButton();
		logger.info("Clicked Save Button");
		
		String actualResult = pvp.geterrorMessage().getText();
		String expectedResult = "Please add Primary complaint";
		Assert.assertEquals(actualResult, expectedResult);
		
		pvp.getcancelNotification();
		logger.info("Clicked Cancel Notification");
	}
	
	@Test(priority=3)
	public void patientVisitWithPrimaryComplaint()  {
		PatientVisitPage pvp=new PatientVisitPage(driver);
		
		pvp.getPrimaryComplaint().sendKeys(PatientVisit_PrimaryComplaint);
		logger.info("Entered primary complaint field");
		pvp.getSaveButton();
		logger.info("Clicked Save Button");
		
		String actualResult = pvp.getsuccessMessage().getText();
		String expectedResult = "Patient visit added successfully!";
		Assert.assertEquals(actualResult, expectedResult);
		
		pvp.getcancelNotification();
		logger.info("Clicked Cancel Notification");
	}
	

	
	@Test(priority=4)
	public void cancelSymptoms()  {
		PatientVisitPage pvp=new PatientVisitPage(driver);
		
		pvp.getsymptomsDelete();
		logger.info("Clicked Symptoms cancel");
		pvp.getSymptoms().sendKeys(PatientVisit_Symptoms2);
		logger.info("Entered Symptoms");
		pvp.getClickingSymptomsPlusSign();
		logger.info("Clicked Symptoms Plus");
		pvp.getSymptoms().sendKeys(" ");
		logger.info("Entered Symptoms Again");
		pvp.getClickingSymptomsPlusSign();
		logger.info("Clicked Symptoms Plus Again");
		pvp.getSymptoms().sendKeys(PatientVisit_Symptoms1);
		logger.info("Entered Symptoms Again");
		pvp.getClickingSymptomsPlusSign();
		logger.info("Clicked Symptoms Plus Again");
		pvp.getsymptomsDelete();
		logger.info("Clicked Symptoms Cancel Again");
		pvp.getsymptomsDelete();
		logger.info("Clicked Symptoms Cancel Again");
		
	}
	
	@Test(priority = 5)
	public void cancelInvstigations()  {
		PatientVisitPage pvp=new PatientVisitPage(driver);
		pvp.getInvestigationTests().sendKeys(PatientVisit_investigations1);
		logger.info("Entered Investigation Test");
		pvp.getClickingInvestigationPlusSign();
		logger.info("Clicked Investigation Plus Sign");
		pvp.getInvestigationTests().sendKeys(PatientVisit_investigations2);
		logger.info("Entered Investigation Test Again");
		pvp.getClickingInvestigationPlusSign();
		logger.info("Clicked Investigation Plus Sign Again");
		pvp.getinvestigationDelete();
		logger.info("Clicked Investigations Delete Again");
		pvp.getInvestigationTests().sendKeys(PatientVisit_investigations1);
		logger.info("Entered Investigation Test Again");
		pvp.getClickingInvestigationPlusSign();
		logger.info("Clicked Investigation Plus Sign Again");
		pvp.getinvestigationDelete();
		logger.info("Clicked Investigations Delete Again");
		pvp.getinvestigationDelete();
		logger.info("Clicked Investigations Delete");
		
	}
	
	@Test(priority = 6)
	public void followup() {
		PatientVisitPage pvp=new PatientVisitPage(driver);
		
		pvp.getFollowup();
		logger.info("Clicked Follow Up");
		pvp.getVisitReason().sendKeys(PatientVisit_Reason);
		pvp.getdateAndTimeFollowUp().click();
		logger.info("Clicked Date and Time");
		pvp.getdatePickFollowUp();
		pvp.gettimePickFollowUp();
		pvp.getAddAppointment();
		logger.info("Added Appointment");
		
		String expectedResult="Appointment added Successfully";
		String actualResult=pvp.getfollowNotification().getText();
        Assert.assertEquals(actualResult, expectedResult);
        
		pvp.getcancelNotification();
		logger.info("Clicked Cancel Notification");
	}
		
		
		
	
	@AfterClass
	public void logout() {
		driver.close();
		logger.info("Closed Browser");
	}
}
