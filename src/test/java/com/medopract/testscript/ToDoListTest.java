package com.medopract.testscript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
	String url; 
	String un;
	String pw;
    String ToDoTaskDetails;
   

	@BeforeClass
	public void OpenApplication() throws  IOException, InterruptedException {
		driver= initializeDriver();
		 url = f.getPropertyData("url");
		 un = f.getPropertyData("un");
		 pw = f.getPropertyData("pw");
		 ToDoTaskDetails=f.getExcelData("To do List", 1, 1);
		
		 
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
		Thread.sleep(2000);

		Assert.assertEquals("MedoPract App", driver.getTitle());

		String actual = null;
		try {
			if(l.getaccInfo().isDisplayed())
				actual="success";
		}
		catch(Exception e) {
			actual="failure";
		}
		Assert.assertEquals(actual, "success");
		Thread.sleep(2000);
	}

	@Test(priority=1)
	public void Todolist() throws InterruptedException  {

		ToDoList tdl = new ToDoList(driver);
		
		tdl.clickingPlusSign();
		logger.info("Clicking plus Sign");
		Thread.sleep(3000);
		tdl.getTaskfield().sendKeys(ToDoTaskDetails);
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
	public void withoutDueDate() throws InterruptedException {

		ToDoList tdl = new ToDoList(driver);
		tdl.getTaskfield().sendKeys(ToDoTaskDetails);
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
