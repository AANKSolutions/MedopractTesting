package com.medopract.testscript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.medopract.generic.BaseClass;
import com.medopract.pom.LoginPage;
import com.medopract.pom.ToDoList;

public class ToDoListTest extends BaseClass {

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

	@Test(priority=1)
	public void Todolist() throws InterruptedException {

		ToDoList tdl = new ToDoList(driver);
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		tdl.getclickingPlusSign().click();
		logger.info("Clicking plus Sign");
		Thread.sleep(2000);
		tdl.getTaskfield().sendKeys("Operation");
		logger.info("Entering Value");
		Thread.sleep(4000);
		tdl.getdateAndTime().click();
		logger.info("Clicked Date and Time");
		Thread.sleep(2000);
		tdl.getDateSelect().click();
		Thread.sleep(2000);
		tdl.getTimeSelect().click();
		j.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		tdl.getAddtask().click();
		logger.info("Clicked on Add Task Button");
		Thread.sleep(5000);

		String expectedResult="Tasks record added";
		String actualResult=tdl.getNotification().getText();
		Assert.assertEquals(actualResult, expectedResult);

		tdl.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority=2)
	public void withoutTaskDetails() throws InterruptedException {
		ToDoList tdl = new ToDoList(driver);
		tdl.getTaskfield().clear();
		logger.info("Entering Value");
		Thread.sleep(4000);
		tdl.getAddtask().click();
		logger.info("Clicked on Add Task Button");
		Thread.sleep(5000);

		String actual = null;
		try {
			if(tdl.geterrorMsg().isDisplayed())
				actual="success";
		}
		catch(Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, "success");
	}

	@Test(priority=3)
	public void withoutDueDate() throws InterruptedException {

		ToDoList tdl = new ToDoList(driver);
		tdl.getTaskfield().sendKeys("Operation");
		logger.info("Entering Value");
		Thread.sleep(4000);
		tdl.getcancelWithoutDueDate().click();
		logger.info("Cancelled Due Date");
		Thread.sleep(4000);
		tdl.getAddtask().click();
		logger.info("Clicked on Add Task Button");
		Thread.sleep(5000);

		String expectedResult="Tasks record added";
		String actualResult=tdl.getNotification().getText();
		Assert.assertEquals(actualResult, expectedResult);

		tdl.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");
	}
	
	@Test(priority=4)
	public void deleteTask() throws InterruptedException, AWTException {
		ToDoList tdl = new ToDoList(driver);
		tdl.getDeleteTask().click();
		Thread.sleep(4000);
		logger.info("Clicking on Delete Task");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		logger.info("Clicking Cancel popup");
		
		String expectedResult="No record available with tasks ID :64b8130a535d4697ac7a57e7";
		String actualResult=tdl.getNotification().getText();
		Assert.assertEquals(actualResult, expectedResult);

		tdl.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority = 5)
	public void CompletedTask() throws InterruptedException {
		ToDoList tdl=new ToDoList(driver);
		Thread.sleep(2000);
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		tdl.getClickingComplete().click();
		Thread.sleep(2000);
		logger.info("Clicking on View Completed Task");


		String expectedResult="Tasks record updated as completed";
		String actualResult=tdl.getNotification().getText();
		Assert.assertEquals(actualResult, expectedResult);

		tdl.getcancelNotification().click();
		Thread.sleep(2000);
		logger.info("Clicked Cancel Notification");
	}

	@Test(priority = 6)
	public void viewCompletedTask() throws InterruptedException {
		ToDoList tdl=new ToDoList(driver);
		Thread.sleep(2000);
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,750)");
		Thread.sleep(2000);
		tdl.getViewCompletedTask().click();
		logger.info("Clicking on View Completed Task");
	}

	@Test(priority =7)
	public void viewOpenTask() throws InterruptedException {
		ToDoList tdl=new ToDoList(driver);
		Thread.sleep(2000);
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		tdl.getViewCompletedTask().click();
		logger.info("Clicking on View Completed Task");
		Thread.sleep(1000);
		j.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		tdl.getViewOpenTask().click();
		logger.info("Clicking on View Completed Task");
	}

	@AfterClass
	public void logout() {
		driver.close();
		logger.info("Closed Browser");
	}
}
