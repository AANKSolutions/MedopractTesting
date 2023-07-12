package com.medopract.testscript;

import java.awt.Window;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.medopract.generic.BaseClass;
import com.medopract.pom.LoginPage;
import com.medopract.pom.ViewPrescriptionPage;

public class ViewPrescriptionTest extends BaseClass {
@BeforeMethod
public void OpenApplication() throws InterruptedException {
		driver=OpenBrowser();
		driver.manage().window().maximize();
		driver.get("https://medopractapi-zk64betx7a-em.a.run.app/");
		logger.info("Navigated to Application URL"); 

		LoginPage l=new LoginPage(driver);
		l.getGotItButton().click();
		Thread.sleep(3000);
		l.getUsername().sendKeys("ashwinkv016");
		l.getPassword().sendKeys("ashwinkv016");
		Thread.sleep(3000);
		l.getSubmitButton().submit();
		Thread.sleep(2000);
	}
@Test(priority=1)
public void viewPrescription() throws InterruptedException {
	ViewPrescriptionPage vpv=new ViewPrescriptionPage(driver);
	vpv.getPrescriptionsLink().click();
	Thread.sleep(2000);
	vpv.getviewPrescriptionsLink().click();
	Thread.sleep(2000);
	vpv.getpatientNameField().sendKeys("Sayi");
	Thread.sleep(2000);
	vpv.getpatientNameFieldSugg().click();
	Thread.sleep(2000);
	vpv.getprescriptionDetails().click();
	Thread.sleep(2000);
	vpv.getbackBtn().click();
	Thread.sleep(2000);
	
}

@Test(priority=2)
public void patientDetails() throws InterruptedException{
	ViewPrescriptionPage vpv=new ViewPrescriptionPage(driver);
	vpv.getPrescriptionsLink().click();
	Thread.sleep(2000);
	vpv.getviewPrescriptionsLink().click();
	Thread.sleep(2000);
	vpv.getpatientNameField().sendKeys("Sayi");
	Thread.sleep(2000);
	vpv.getpatientNameFieldSugg().click();
	Thread.sleep(2000);
	JavascriptExecutor j=(JavascriptExecutor)driver;
	j.executeScript("window.scrollBy(0,250)");
	Thread.sleep(3000);
	vpv.getgoToPatientDetails().click();
	Thread.sleep(4000);
}


@AfterMethod
public void logout() {
	driver.close();
}
}
