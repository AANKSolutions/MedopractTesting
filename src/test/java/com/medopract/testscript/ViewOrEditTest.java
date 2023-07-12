package com.medopract.testscript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.medopract.generic.BaseClass;
import com.medopract.pom.AddPatientPage;
import com.medopract.pom.LoginPage;
import com.medopract.pom.ViewOrEditPage;


public class ViewOrEditTest extends BaseClass{
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
     @Test(priority = 1)
     public void ViewOrEdit() throws InterruptedException {
    	
 		
    	 AddPatientPage ap=new AddPatientPage(driver);
    	 ap.getPatientsClick().click();
    	 Thread.sleep(3000);
    	 
    	 ViewOrEditPage voe=new ViewOrEditPage(driver);
    	 voe.getViewOrEdit().click();
    	 Thread.sleep(3000);
    	 voe.getPatientNameField().sendKeys("Ashwin");
    	 voe.getPatientListClick().click();
    	 Thread.sleep(3000);
    	 
    	 voe.getUpdateButtonClick().submit();
     }
     
     @Test(priority  =3)
     public void editContactUpdate() throws InterruptedException {
    	
  		
     	 AddPatientPage ap=new AddPatientPage(driver);
     	 ap.getPatientsClick().click();
     	 Thread.sleep(3000);
     	 
     	 ViewOrEditPage voe=new ViewOrEditPage(driver);
     	 voe.getViewOrEdit().click();
     	 Thread.sleep(3000);
     	 voe.getPatientNameField().sendKeys("Ashwin");
     	 voe.getPatientListClick().click();
     	 Thread.sleep(3000);
     	 ap.getPhoneNoField().sendKeys("6382565718");
     	 Thread.sleep(1000);
     	 ap.getEmergencyField().sendKeys("9597277526");
     	 Thread.sleep(1000);
     	 voe.getUpdateButtonClick().submit();
      }

     @Test(priority=2)
     public void deleteList() throws InterruptedException, AWTException {
    	 AddPatientPage ap=new AddPatientPage(driver);
     	 ap.getPatientsClick().click();
     	 Thread.sleep(3000);
     	 
     	 ViewOrEditPage voe=new ViewOrEditPage(driver);
     	 voe.getViewOrEdit().click();
     	 Thread.sleep(3000);
     	 voe.getPatientNameField().sendKeys("Ashwin");
     	 Thread.sleep(3000);
     	 voe.getDeleteButtonClick().click();
     	 Thread.sleep(3000);
 		 Robot r=new Robot();
 		 r.keyPress(KeyEvent.VK_ENTER);
     }
     
     @Test(priority = 4)
     public void cancelEdit() throws InterruptedException {
    	 AddPatientPage ap=new AddPatientPage(driver);
    	 ap.getPatientsClick().click();
    	 Thread.sleep(3000);
    	 
    	 ViewOrEditPage voe=new ViewOrEditPage(driver);
    	 voe.getViewOrEdit().click();
    	 Thread.sleep(3000);
    	 voe.getPatientNameField().sendKeys("Ashwin");
    	 voe.getPatientListClick().click();
    	 Thread.sleep(3000);
    	 voe.getCancelButtonClick().submit();
     }
     

     @AfterMethod
 	public void CloseBrowser() {
 		driver.close();
 	}
}
