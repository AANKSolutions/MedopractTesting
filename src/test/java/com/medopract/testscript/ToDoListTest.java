package com.medopract.testscript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.medopract.generic.BaseClass;
import com.medopract.pom.LoginPage;
import com.medopract.pom.ToDoList;

public class ToDoListTest extends BaseClass {
	Logger logger= LogManager.getLogger(ToDoListTest.class);



	@BeforeClass
	public void OpenApplication() throws  IOException, InterruptedException {
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
	@Test(priority=1)
	public void Todolist() throws InterruptedException, EncryptedDocumentException, IOException  {

		ToDoList tdl = new ToDoList(driver);

		tdl.clickingPlusSign();
		logger.info("Clicking plus Sign");
		Thread.sleep(3000);
		tdl.getTaskfield().sendKeys(getExcelData("To do List", 1, 1));
		logger.info("Entering Value");
		tdl.getdateAndTime();
		logger.info("Clicked Date and Time");
		tdl.getDateSelect();
		tdl.getTimeSelect();
		tdl.getAddtask();	
		logger.info("Clicked on Add Task Button");
		Thread.sleep(2000);
		String expectedResult="Tasks record added";
		String actualResult=tdl.getNotification().getText();
		Assert.assertEquals(actualResult, expectedResult);
		tdl.getcancelNotification();
		logger.info("Clicked Cancel Notification");
		Thread.sleep(2000);
	}


	@Test(priority = 2)
	public void CompletedTask() throws InterruptedException  {
		ToDoList tdl=new ToDoList(driver);
		tdl.getClickingComplete();
		logger.info("Clicking on View Completed Task");

		Thread.sleep(2000);
		String expectedResult="Tasks record updated as completed";
		String actualResult=tdl.getNotification().getText();
		Assert.assertEquals(actualResult, expectedResult);

		tdl.getcancelNotification();
		logger.info("Clicked Cancel Notification");
		Thread.sleep(2000);
	}

	@Test(priority=3)
	public void withoutTaskDetails() throws InterruptedException  {
		ToDoList tdl = new ToDoList(driver);
		tdl.getTaskfield().clear();
		logger.info("Entering Value");
		tdl.getAddtask();
		logger.info("Clicked on Add Task Button");
		Thread.sleep(2000);
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

	@Test(priority=4)
	public void withoutDueDate() throws InterruptedException, EncryptedDocumentException, IOException {

		ToDoList tdl = new ToDoList(driver);
		tdl.getTaskfield().sendKeys(getExcelData("To do List", 1, 1));
		logger.info("Entering Value");
		tdl.getcancelWithoutDueDate();
		logger.info("Cancelled Due Date");
		tdl.getAddtask();
		logger.info("Clicked on Add Task Button");
		Thread.sleep(2000);
		String expectedResult="Tasks record added";
		String actualResult=tdl.getNotification().getText();
		Assert.assertEquals(actualResult, expectedResult);

		tdl.getcancelNotification();
		logger.info("Clicked Cancel Notification");
		Thread.sleep(2000);
	}



	@Test(priority = 5)
	public void viewCompletedTask() throws InterruptedException  {
		ToDoList tdl=new ToDoList(driver);
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,750)");
		Thread.sleep(10000);
		tdl.getViewCompletedTask();
		logger.info("Clicking on View Completed Task");
		Thread.sleep(2000);
	}


	@Test(priority =6)
	public void viewOpenTask()  {
		ToDoList tdl=new ToDoList(driver);
		logger.info("Clicking on View Completed Task");
		tdl.getViewOpenTask();
		logger.info("Clicking on View Completed Task");
	}

	@Test(priority=7)
	public void deleteTask() throws  AWTException, InterruptedException {
		ToDoList tdl = new ToDoList(driver);
		tdl.getDeleteTask();
		logger.info("Clicking on Delete Task");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		logger.info("Clicking Cancel popup");
		Thread.sleep(2000);
		String actual = null;
		try {
			if(tdl.getNotification().isDisplayed())
				actual="success";
		}
		catch(Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, "success");

		tdl.getcancelNotification();
		logger.info("Clicked Cancel Notification");
		Thread.sleep(2000);
	}


	@AfterClass
	public void logout() {
		driver.close();
		logger.info("Closed Browser");
	}
}
