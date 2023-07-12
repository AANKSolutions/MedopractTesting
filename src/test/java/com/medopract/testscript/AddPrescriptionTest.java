package com.medopract.testscript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.medopract.generic.BaseClass;
import com.medopract.pom.AddPrescriptionPage;
import com.medopract.pom.LoginPage;

public class AddPrescriptionTest extends BaseClass {
	
	@BeforeMethod
	public void OpenApplication() throws InterruptedException {
		driver= OpenBrowser();
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
		Thread.sleep(2000);
	}
	
   @Test(priority = 1)
   public void addPrescription() throws InterruptedException {
	   AddPrescriptionPage ap=new AddPrescriptionPage(driver);
	   ap.getclickPrescription().click();
	   Thread.sleep(2000);
	   ap.getPatientNameField().sendKeys("Sayi");
	   Thread.sleep(2000);
	   ap.getpatientNameSuggestion().click();
	   Thread.sleep(2000);
	   ap.getEmailField().sendKeys("vashwinkumar008@gmail.com");
	   Thread.sleep(2000);
	   ap.getMedicineNameField().sendKeys("Dolo65");
	   Thread.sleep(2000);
	   ap.getTotalNumberDays().sendKeys("100");
	   Thread.sleep(2000);
	   ap.getTimingsInput().sendKeys("Morning , Evening");
	   Thread.sleep(2000);
	   ap.getAmountInput().sendKeys("1");
	   Thread.sleep(2000);
	   ap.getClickingPlusSign().click();
	   JavascriptExecutor j=(JavascriptExecutor)driver;
	   j.executeScript("window.scrollBy(0,250)");
	   Thread.sleep(2000);
	   ap.getSaveAndPrintButton().click();
	   Thread.sleep(2000);
	   ap.getyesButtonField().click();
	   Thread.sleep(4000);
   }
   
   
   @Test(priority = 2)
   public void withoutAddingMedicineField() throws InterruptedException {
	   AddPrescriptionPage ap=new AddPrescriptionPage(driver);
	   ap.getclickPrescription().click();
	   Thread.sleep(2000);
	   ap.getPatientNameField().sendKeys("Sayi");
	   Thread.sleep(2000);
	   ap.getpatientNameSuggestion().click();
	   Thread.sleep(2000);
	   ap.getEmailField().sendKeys("vashwinkumar008@gmail.com");
	   Thread.sleep(2000);
	   JavascriptExecutor j=(JavascriptExecutor)driver;
	   j.executeScript("window.scrollBy(0,750)");
	   Thread.sleep(2000);
	   ap.getSaveAndPrintButton().click();
	   Thread.sleep(2000);
   }
   
   @Test(priority = 3)
   public void deleteAddedMedicineField() throws InterruptedException {
	   AddPrescriptionPage ap=new AddPrescriptionPage(driver);
	   ap.getclickPrescription().click();
	   Thread.sleep(2000);
	   ap.getPatientNameField().sendKeys("Sayi");
	   Thread.sleep(2000);
	   ap.getpatientNameSuggestion().click();
	   Thread.sleep(2000);
	   ap.getEmailField().sendKeys("vashwinkumar008@gmail.com");
	   Thread.sleep(2000);
	   ap.getMedicineNameField().sendKeys("Dolo65");
	   Thread.sleep(2000);
	   ap.getTotalNumberDays().sendKeys("100");
	   Thread.sleep(2000);
	   ap.getTimingsInput().sendKeys("Morning , Evening");
	   Thread.sleep(2000);
	   ap.getAmountInput().sendKeys("1");
	   Thread.sleep(2000);
	   ap.getClickingPlusSign().click();
	   JavascriptExecutor j=(JavascriptExecutor)driver;
	   j.executeScript("window.scrollBy(0,750)");
	   Thread.sleep(4000);
	   ap.getdeleteMedicineField().click();
	   Thread.sleep(2000);
	   ap.getSaveAndPrintButton().click();
   }
   
   @Test(priority= 4)
   public void printPrescription() throws InterruptedException, AWTException {
	   AddPrescriptionPage ap=new AddPrescriptionPage(driver);
	   ap.getclickPrescription().click();
	   Thread.sleep(2000);
	   ap.getPatientNameField().sendKeys("Sayi");
	   Thread.sleep(2000);
	   ap.getpatientNameSuggestion().click();
	   Thread.sleep(2000);
	   ap.getEmailField().sendKeys("vashwinkumar008@gmail.com");
	   Thread.sleep(2000);
	   ap.getMedicineNameField().sendKeys("Dolo65");
	   Thread.sleep(2000);
	   ap.getTotalNumberDays().sendKeys("100");
	   Thread.sleep(2000);
	   ap.getTimingsInput().sendKeys("Morning , Evening");
	   Thread.sleep(2000);
	   ap.getAmountInput().sendKeys("1");
	   Thread.sleep(2000);
	   ap.getClickingPlusSign().click();
	   JavascriptExecutor j=(JavascriptExecutor)driver;
	   j.executeScript("window.scrollBy(0,250)");
	   Thread.sleep(2000);
	   ap.getSaveAndPrintButton().click();
	   Thread.sleep(2000);
	   ap.getyesButtonField().click();
	   Thread.sleep(4000);
	   ap.getprintPrescription().click();
	   Thread.sleep(4000);
	   Robot r=new Robot();
	   r.keyPress(KeyEvent.VK_ESCAPE);
	   Thread.sleep(2000);
   }
   
   @Test(priority=5)
   public void downloadPrescription() throws InterruptedException {
	   AddPrescriptionPage ap=new AddPrescriptionPage(driver);
	   ap.getclickPrescription().click();
	   Thread.sleep(2000);
	   ap.getPatientNameField().sendKeys("Sayi");
	   Thread.sleep(2000);
	   ap.getpatientNameSuggestion().click();
	   Thread.sleep(2000);
	   ap.getEmailField().sendKeys("vashwinkumar008@gmail.com");
	   Thread.sleep(2000);
	   ap.getMedicineNameField().sendKeys("Dolo65");
	   Thread.sleep(2000);
	   ap.getTotalNumberDays().sendKeys("100");
	   Thread.sleep(2000);
	   ap.getTimingsInput().sendKeys("Morning , Evening");
	   Thread.sleep(2000);
	   ap.getAmountInput().sendKeys("1");
	   Thread.sleep(2000);
	   ap.getClickingPlusSign().click();
	   JavascriptExecutor j=(JavascriptExecutor)driver;
	   j.executeScript("window.scrollBy(0,250)");
	   Thread.sleep(2000);
	   ap.getSaveAndPrintButton().click();
	   Thread.sleep(2000);
	   ap.getyesButtonField().click();
	   Thread.sleep(4000); 
	   ap.getdownloadPrescription().click();
	   Thread.sleep(4000);
   }
   
   @Test(priority=6)
   public void downloadPrescriptionAgain() throws InterruptedException {
	   AddPrescriptionPage ap=new AddPrescriptionPage(driver);
	   ap.getclickPrescription().click();
	   Thread.sleep(2000);
	   ap.getPatientNameField().sendKeys("Sayi");
	   Thread.sleep(2000);
	   ap.getpatientNameSuggestion().click();
	   Thread.sleep(2000);
	   ap.getEmailField().sendKeys("vashwinkumar008@gmail.com");
	   Thread.sleep(2000);
	   ap.getMedicineNameField().sendKeys("Dolo65");
	   Thread.sleep(2000);
	   ap.getTotalNumberDays().sendKeys("100");
	   Thread.sleep(2000);
	   ap.getTimingsInput().sendKeys("Morning , Evening");
	   Thread.sleep(2000);
	   ap.getAmountInput().sendKeys("1");
	   Thread.sleep(2000);
	   ap.getClickingPlusSign().click();
	   JavascriptExecutor j=(JavascriptExecutor)driver;
	   j.executeScript("window.scrollBy(0,250)");
	   Thread.sleep(2000);
	   ap.getSaveAndPrintButton().click();
	   Thread.sleep(2000);
	   ap.getyesButtonField().click();
	   Thread.sleep(4000); 
	   ap.getdownloadPrescription().click();
	   Thread.sleep(4000);
	   ap.getdownloadPrescription().click();
	   Thread.sleep(4000);
   }
   
   @Test(priority = 7)
   public void clickingBack() throws InterruptedException {
	   AddPrescriptionPage ap=new AddPrescriptionPage(driver);
	   ap.getclickPrescription().click();
	   Thread.sleep(2000);
	   ap.getPatientNameField().sendKeys("Sayi");
	   Thread.sleep(2000);
	   ap.getpatientNameSuggestion().click();
	   Thread.sleep(2000);
	   ap.getEmailField().sendKeys("vashwinkumar008@gmail.com");
	   Thread.sleep(2000);
	   ap.getMedicineNameField().sendKeys("Dolo65");
	   Thread.sleep(2000);
	   ap.getTotalNumberDays().sendKeys("100");
	   Thread.sleep(2000);
	   ap.getTimingsInput().sendKeys("Morning , Evening");
	   Thread.sleep(2000);
	   ap.getAmountInput().sendKeys("1");
	   Thread.sleep(2000);
	   ap.getClickingPlusSign().click();
	   JavascriptExecutor j=(JavascriptExecutor)driver;
	   j.executeScript("window.scrollBy(0,250)");
	   Thread.sleep(2000);
	   ap.getSaveAndPrintButton().click();
	   Thread.sleep(2000);
	   ap.getyesButtonField().click();
	   j.executeScript("window.scrollBy(0,250)");
	   Thread.sleep(4000);
	   ap.getbackPrescriptionbtn().click();
	   Thread.sleep(3000);
	   ap.getBackButton().click();
   }
   
   
   @AfterMethod
	public void CloseBrowser() {
		driver.close();
	}
}
