package com.medopract.testscript;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.medopract.generic.BaseClass;
import com.medopract.pom.LoginPage;
import com.medopract.pom.PatientVisitPage;


public class PatientVisitTest extends BaseClass {
	@BeforeMethod
	public void OpenApplication() throws InterruptedException {
		driver=OpenBrowser();
		driver.manage().window().maximize();  
		driver.get("https://medopractapi-zk64betx7a-em.a.run.app/");
		logger.info("Navigated to Application URL");
		
		LoginPage l=new LoginPage(driver);
		l.getGotItButton().click();
		Thread.sleep(2000);
		l.getUsername().sendKeys("ashwinkv016"); 
		l.getPassword().sendKeys("ashwinkv016");
		Thread.sleep(2000);
		l.getSubmitButton().submit();
		Thread.sleep(4000);        
	}

	@Test(priority=1)
	public void patientVisitWithPrimaryComplaint() throws InterruptedException {
		PatientVisitPage pvp=new PatientVisitPage(driver);
		pvp.getPatientsClick().click();
		Thread.sleep(2000);
		pvp.getPatientvisitClick().click();
		Thread.sleep(2000);
		pvp.getPatientVisitName().sendKeys("Sayi");
		Thread.sleep(2000);
		pvp.getpatientVisitNameSuggestions().click();
		Thread.sleep(1000);
		pvp.getPrimaryComplaint().sendKeys("Fever");
		Thread.sleep(1000);
		pvp.getSymptoms().sendKeys("vomiting");
		Thread.sleep(1000);
		pvp.getClickingSymptomsPlusSign().click();
		Thread.sleep(1000);
		pvp.getbloodPressure().sendKeys("80");
		Thread.sleep(1000);
		pvp.getsugarLevel().sendKeys("100");
		Thread.sleep(1000);
		pvp.getheartRate().sendKeys("70");
		Thread.sleep(1000);
		pvp.getInvestigationTests().sendKeys("EcG test");
		Thread.sleep(1000);
		pvp.getClickingInvestigationPlusSign().click();
		Thread.sleep(1000);
		pvp.getclinicalObservation().sendKeys("Illness in fear");
		Thread.sleep(1000);
		pvp.getdiagnosisRemark().sendKeys("normal");
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		pvp.getSaveButton().click();
		Thread.sleep(3000);
	}
	
	@Test(priority=2)
	public void patientVisitWithoutPrimaryComplaint() throws InterruptedException {
		PatientVisitPage pvp=new PatientVisitPage(driver);
		pvp.getPatientsClick().click();
		Thread.sleep(2000);
		pvp.getPatientvisitClick().click();
		Thread.sleep(2000);
		pvp.getPatientVisitName().sendKeys("Sayi");
		Thread.sleep(2000);
		pvp.getpatientVisitNameSuggestions().click();
		Thread.sleep(1000);
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		pvp.getSaveButton().click();
		Thread.sleep(3000);
	}
	
	@Test(priority = 3)
	public void addNewPatientData() throws InterruptedException {
		PatientVisitPage pvp=new PatientVisitPage(driver);
		pvp.getPatientsClick().click();
		Thread.sleep(2000);
		pvp.getPatientvisitClick().click();
		Thread.sleep(2000);
		pvp.getaddNewPatientHyperLink().click();
		Thread.sleep(2000);
	}
	@Test(priority=4)
	public void deleteSymptoms() throws InterruptedException {
		PatientVisitPage pvp=new PatientVisitPage(driver);
		pvp.getPatientsClick().click();
		Thread.sleep(2000);
		pvp.getPatientvisitClick().click();
		Thread.sleep(2000);
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,500)");
		pvp.getSymptoms().sendKeys("vomiting");
		Thread.sleep(1000);
		pvp.getClickingSymptomsPlusSign().click();
		Thread.sleep(2000);
		pvp.getsymptomsDelete().click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 5)
	public void deleteInvstigations() throws InterruptedException {
		PatientVisitPage pvp=new PatientVisitPage(driver);
		pvp.getPatientsClick().click();
		Thread.sleep(2000);
		pvp.getPatientvisitClick().click();
		Thread.sleep(2000);
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,500)");
		pvp.getInvestigationTests().sendKeys("Ecg Test");
		Thread.sleep(2000);
		pvp.getClickingInvestigationPlusSign().click();
		Thread.sleep(2000);
		pvp.getinvestigationDelete().click();
		Thread.sleep(2000);
	}
	
	@Test(priority = 6)
	public void foollowup() throws InterruptedException {
		PatientVisitPage pvp=new PatientVisitPage(driver);
		pvp.getPatientsClick().click();
		Thread.sleep(2000);
		pvp.getPatientvisitClick().click();
		Thread.sleep(2000);
		pvp.getPatientVisitName().sendKeys("Sayi");
		Thread.sleep(2000);
		pvp.getpatientVisitNameSuggestions().click();
		Thread.sleep(1000);
		pvp.getPrimaryComplaint().sendKeys("Fever");
		JavascriptExecutor j=(JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		pvp.getSaveButton().click();
		Thread.sleep(5000);
		pvp.getFollowup().click();
		Thread.sleep(1000);
		pvp.getVisitReason().sendKeys("viral fever");
		Thread.sleep(4000);
		pvp.getcancelBtn().click();
		Thread.sleep(3000);
	}
	
	
	
	@AfterMethod
	public void CloseBrowser() {
		driver.close();
	}
}
