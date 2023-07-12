package com.medopract.testscript;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.medopract.generic.BaseClass;
import com.medopract.pom.AddPatientPage;
import com.medopract.pom.LoginPage;

public class AddPatientTest extends BaseClass {

	@BeforeMethod
	public void OpenApplication() throws InterruptedException  {
		driver=OpenBrowser();
		driver.manage().window().maximize();  
		driver.get("https://medopractapi-zk64betx7a-em.a.run.app/");
		logger.info("Navigated to Application URL");
		Thread.sleep(2000);

		LoginPage l=new LoginPage(driver);
		l.getGotItButton().click();
		Thread.sleep(2000);
		l.getUsername().sendKeys("ashwinkv016"); 
		l.getPassword().sendKeys("ashwinkv016");
		Thread.sleep(2000);
		l.getSubmitButton().submit();
		Thread.sleep(4000);
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
		app.getPatientNameField().sendKeys("Sunil");
		Thread.sleep(2000);
		logger.info("Added Patient's Name");
		app.getPhoneNoField().sendKeys("6382565718");
		Thread.sleep(2000);
		logger.info("Added Patient's Phone Number");
		app.getgenderField().click();
		Thread.sleep(2000);
		logger.info("Selected Gender Field");
		// app.getbirthDateField().sendKeys("");;
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
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,1000)");
		app.getAllergiesField().sendKeys("Itching");
		Thread.sleep(2000);
		logger.info("Added Allergy field");
		app.getRemarksField().sendKeys("Normal");
		Thread.sleep(2000);
		logger.info("Added Remark field");
		j.executeScript("window.scrollBy(0,500)");
		app.getHistoryField().sendKeys("Nill");
		Thread.sleep(2000);
		logger.info("Added History field");
		app.getHabitsField().sendKeys("Eating Sweets");
		Thread.sleep(2000);
		logger.info("Entered Habit field");
		app.getClickingPlusSign().click();
		Thread.sleep(5000);
		logger.info("Added Habit field by clicking Plus");
		j.executeScript("window.scrollBy(0,250)");
		app.getSaveButton().submit();
		Thread.sleep(2000);
	}

	@Test(priority = 2)
	public void resetPatientData() throws InterruptedException {
		
		AddPatientPage app=new AddPatientPage(driver);
		app.getPatientsClick().click();
		Thread.sleep(3000);
		logger.info("Clicking Patients");
		app.getAddPatientClick().click();
		Thread.sleep(2000);
		logger.info("Clicking Add Patient");
		app.getPatientNameField().sendKeys("Gopi");
		Thread.sleep(2000);
		logger.info("Added Patient's Name");
		app.getPhoneNoField().sendKeys("9597277526");
		Thread.sleep(2000);
		logger.info("Added Patient's Phone Number");
		app.getgenderField().click();
		Thread.sleep(2000);
		logger.info("Selected Gender Field");
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
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,250)");
		app.getAllergiesField().sendKeys("Itching");
		Thread.sleep(2000);
		logger.info("Added Allergy field");
		app.getRemarksField().sendKeys("Normal");
		Thread.sleep(2000);
		logger.info("Added Remark field");
		j.executeScript("window.scrollBy(0,250)");
		app.getHistoryField().sendKeys("Nill");
		Thread.sleep(2000);
		logger.info("Added History field");
		app.getHabitsField().sendKeys("Eating Sweets");
		Thread.sleep(2000);
		logger.info("Entered Habit field");
		app.getClickingPlusSign().click();
		Thread.sleep(2000);
		logger.info("Added Habit field by clicking Plus");
		app.getSaveButton().submit();
		Thread.sleep(2000);
		logger.info("Clicked SaveButton");
		app.getResetButton().submit();
		logger.info("Clicked ResetButton"); 
		Thread.sleep(2000);
	}

	@Test(priority = 3)
	public void withoutMandatoryAllData() throws InterruptedException {
		
		AddPatientPage app=new AddPatientPage(driver);
		app.getPatientsClick().click();
		Thread.sleep(3000);
		logger.info("Clicking Patients");
		app.getAddPatientClick().click();
		Thread.sleep(2000);
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
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,250)");
		app.getAllergiesField().sendKeys(" ");
		Thread.sleep(2000);
		logger.info("Added Allergy field");
		app.getRemarksField().sendKeys(" ");
		Thread.sleep(2000);
		logger.info("Added Remark field");
		j.executeScript("window.scrollBy(0,250)");
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
	}

	@AfterMethod
	public void CloseBrowser() {
		driver.close();
	}
}
