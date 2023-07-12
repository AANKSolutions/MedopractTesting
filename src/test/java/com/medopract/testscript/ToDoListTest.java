package com.medopract.testscript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.medopract.generic.BaseClass;
import com.medopract.pom.LoginPage;
import com.medopract.pom.ToDoList;

public class ToDoListTest extends BaseClass {
	
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
	public void Todolist() throws InterruptedException {

		ToDoList tdl = new ToDoList(driver);
		tdl.getclickingPlusSign().click();
		logger.debug("Clicking plus Sign");
		tdl.getTaskfield().sendKeys("Operation");
		logger.debug("Entering Value");
		Thread.sleep(4000);
		tdl.getAddtask().click();
		logger.debug("Clicked on Add Task Button");
		Thread.sleep(5000);
		tdl.getClickingComplete().click();
		logger.debug("Clicked on Clicking Complete");
	}

	@Test(priority=2)
	public void withoutTaskDetails() throws InterruptedException {

		ToDoList tdl = new ToDoList(driver);
		tdl.getclickingPlusSign().click();
		logger.debug("Clicking plus Sign");
		tdl.getTaskfield().sendKeys(" ");
		logger.debug("Entering Value");
		Thread.sleep(4000);
		tdl.getAddtask().click();
		logger.debug("Clicked on Add Task Button");
		Thread.sleep(5000);
		tdl.getClickingComplete().click();
		logger.debug("Clicked on Clicking Complete");

	}
	@Test(priority=3)
	public void withoutDueDate() throws InterruptedException {

		ToDoList tdl = new ToDoList(driver);
		tdl.getclickingPlusSign().click();
		logger.debug("Clicking plus Sign");
		tdl.getTaskfield().sendKeys("Operation");
		logger.debug("Entering Value");
		Thread.sleep(4000);
		tdl.getcancelWithoutDueDate().click();
		logger.debug("Cancelled Due Date");
		Thread.sleep(4000);
		tdl.getAddtask().click();
		logger.debug("Clicked on Add Task Button");
		Thread.sleep(5000);
		tdl.getClickingComplete().click();
		logger.debug("Clicked on Clicking Complete");
	}
	@Test(priority=4)
	public void deleteTask() throws InterruptedException, AWTException {
		
		ToDoList tdl = new ToDoList(driver);
		tdl.getDeleteTask().click();
		Thread.sleep(4000);
		logger.debug("Clicking on Delete Task");
		Robot r=new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		logger.info("Clicking Cancel popup");
	}
	
	@Test(priority = 5)
	public void viewCompletedTask() throws InterruptedException {
		ToDoList tdl=new ToDoList(driver);
		Thread.sleep(2000);
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		tdl.getViewCompletedTask().click();
		logger.info("Clicking on View Completed Task");
	}
	
	@Test(priority =6)
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
	
	@AfterMethod
	public void CloseBrowser() {
		driver.close();
	}
}
