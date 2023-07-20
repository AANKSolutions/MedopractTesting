package com.medopract.testscript;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.medopract.generic.BaseClass;
import com.medopract.pom.LoginPage;
import com.medopract.pom.PatientVisitPage;


public class PatientVisitTest extends BaseClass {
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
	
	@Test(priority = 1)
	public void addNewPatientData() throws InterruptedException {
		PatientVisitPage pvp=new PatientVisitPage(driver);
		pvp.getPatientsClick().click();
		Thread.sleep(3000);
		logger.info("Clicked Patients Field");
		pvp.getPatientvisitClick().click();
		Thread.sleep(2000);
		logger.info("Clicked Patient Visit");
		pvp.getaddNewPatientHyperLink().click();
		Thread.sleep(2000);
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
	public void patientVisitWithoutPrimaryComplaint() throws InterruptedException {
		PatientVisitPage pvp=new PatientVisitPage(driver);
		pvp.getPatientsClick().click();
		Thread.sleep(3000);
		logger.info("Clicked Patients Field");
		pvp.getPatientvisitClick().click();
		Thread.sleep(2000);
		logger.info("Clicked Patient Visit");
		pvp.getPatientVisitName().sendKeys("Ashwin");
		Thread.sleep(2000);
		logger.info("Clicked Patient Name Field");
		pvp.getpatientVisitNameSuggestions().click();
		Thread.sleep(1000);
		logger.info("Clicked Patient Nmae Suggestion");
		pvp.getSymptoms().sendKeys("vomiting");
		Thread.sleep(3000);
		logger.info("Entered symptoms field");
		pvp.getClickingSymptomsPlusSign().click();
		Thread.sleep(1000);
		logger.info("ClickedSymptoms Plus Sign");
		pvp.getbloodPressure().sendKeys("80");
		Thread.sleep(1000);
		logger.info("Entered Blood Pressure Level");
		pvp.getsugarLevel().sendKeys("100");
		Thread.sleep(1000);
		logger.info("Entered SugarLevel");
		pvp.getheartRate().sendKeys("70");
		Thread.sleep(1000);
		logger.info("Entered Heart Rate Level");
		pvp.getInvestigationTests().sendKeys("EcG test");
		Thread.sleep(1000);
		logger.info("Entered Investigation Test");
		pvp.getClickingInvestigationPlusSign().click();
		Thread.sleep(1000);
		logger.info("Clicked Investigation Plus Sign");
		pvp.getclinicalObservation().sendKeys("Illness in fear");
		Thread.sleep(1000);
		logger.info("Entered Clinical Observation");
		pvp.getdiagnosisRemark().sendKeys("normal");
		logger.info("Entered Diagnosis Remark");
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		pvp.getSaveButton().click();
		logger.info("Clicked Save Button");
		Thread.sleep(3000);
		
		String actualResult = pvp.geterrorMessage().getText();
		String expectedResult = "Please add Primary complaint";
		Assert.assertEquals(actualResult, expectedResult);
		
		pvp.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");
	}
	
	@Test(priority=3)
	public void patientVisitWithPrimaryComplaint() throws InterruptedException {
		PatientVisitPage pvp=new PatientVisitPage(driver);
		
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,-250)");
		Thread.sleep(3000);
		pvp.getPrimaryComplaint().sendKeys("Fever");
		logger.info("Entered primary complaint field");
		j.executeScript("window.scrollBy(0,250)");
		Thread.sleep(3000);
		pvp.getSaveButton().click();
		logger.info("Clicked Save Button");
		Thread.sleep(3000);
		
		String actualResult = pvp.getsuccessMessage().getText();
		String expectedResult = "Patient visit added successfully!";
		Assert.assertEquals(actualResult, expectedResult);
		
		pvp.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");
	}
	

	
	@Test(priority=4)
	public void cancelSymptoms() throws InterruptedException {
		PatientVisitPage pvp=new PatientVisitPage(driver);
		
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,-250)");
		Thread.sleep(3000);
		pvp.getsymptomsDelete().click();
		Thread.sleep(2000);
		logger.info("Clicked Symptoms cancel");
		pvp.getSymptoms().sendKeys("stomach pain");
		Thread.sleep(1000);
		logger.info("Entered Symptoms");
		pvp.getClickingSymptomsPlusSign().click();
		Thread.sleep(5000);
		logger.info("Clicked Symptoms Plus");
		pvp.getSymptoms().sendKeys("Headache");
		Thread.sleep(1000);
		logger.info("Entered Symptoms Again");
		pvp.getClickingSymptomsPlusSign().click();
		Thread.sleep(5000);
		logger.info("Clicked Symptoms Plus Again");
		pvp.getSymptoms().sendKeys("Stomach pain");
		Thread.sleep(1000);
		logger.info("Entered Symptoms Again");
		pvp.getClickingSymptomsPlusSign().click();
		Thread.sleep(5000);
		logger.info("Clicked Symptoms Plus Again");
		pvp.getsymptomsDelete().click();
		Thread.sleep(2000);
		logger.info("Clicked Symptoms Cancel Again");
		pvp.getsymptomsDelete().click();
		Thread.sleep(2000);
		logger.info("Clicked Symptoms Cancel Again");
		
	}
	
	@Test(priority = 5)
	public void cancelInvstigations() throws InterruptedException {
		PatientVisitPage pvp=new PatientVisitPage(driver);
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,250)");
		pvp.getInvestigationTests().sendKeys("Ecg Test");
		Thread.sleep(2000);
		logger.info("Entered Investigation Test");
		pvp.getClickingInvestigationPlusSign().click();
		Thread.sleep(2000);
		logger.info("Clicked Investigation Plus Sign");
		pvp.getInvestigationTests().sendKeys("Blood Test");
		Thread.sleep(2000);
		logger.info("Entered Investigation Test Again");
		pvp.getClickingInvestigationPlusSign().click();
		Thread.sleep(2000);
		logger.info("Clicked Investigation Plus Sign Again");
		pvp.getinvestigationDelete().click();
		Thread.sleep(2000);
		logger.info("Clicked Investigations Delete Again");
		pvp.getInvestigationTests().sendKeys("Platelet Count");
		Thread.sleep(2000);
		logger.info("Entered Investigation Test Again");
		pvp.getClickingInvestigationPlusSign().click();
		Thread.sleep(2000);
		logger.info("Clicked Investigation Plus Sign Again");
		pvp.getinvestigationDelete().click();
		Thread.sleep(2000);
		logger.info("Clicked Investigations Delete Again");
		pvp.getinvestigationDelete().click();
		Thread.sleep(2000);
		logger.info("Clicked Investigations Delete");
		
	}
	
	@Test(priority = 6)
	public void followup() throws InterruptedException {
		PatientVisitPage pvp=new PatientVisitPage(driver);
		
		Thread.sleep(3000);
		pvp.getFollowup().click();
		Thread.sleep(2000);
		logger.info("Clicked Follow Up");
		pvp.getVisitReason().sendKeys("fever");
		Thread.sleep(2000);
		pvp.getdateAndTimeFollowUp().click();
		Thread.sleep(2000);
		logger.info("Clicked Date and Time");
		pvp.getdatePickFollowUp().click();
		Thread.sleep(2000);
		pvp.gettimePickFollowUp().click();
		Thread.sleep(2000);
		pvp.getAddAppointment().click();
		Thread.sleep(3000);
		logger.info("Added Appointment");
		
		String expectedResult="Appointment added Successfully";
		String actualResult=pvp.getfollowNotification().getText();
        Assert.assertEquals(actualResult, expectedResult);
        
		pvp.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");
	}
		
		
		
	
	@AfterClass
	public void logout() {
		driver.close();
		logger.info("Closed Browser");
	}
}
