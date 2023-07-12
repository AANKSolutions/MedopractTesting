package com.medopract.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToDoList {
	public ToDoList(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[.='+'])[2]")
	WebElement clickingPlusSign;
	
	@FindBy(xpath = "//textarea[@name='task_description']")
	 WebElement taskfield;

	@FindBy(xpath = "//button[text()='Add Task']")
	 WebElement Addtask;

	@FindBy(xpath = "//button[@class='react-datepicker__close-icon']")
	 WebElement cancelWithoutDueDate;
	
	@FindBy(xpath = "(//a[@title='Complete'])[1]")
	 WebElement ClickingComplete;

	@FindBy(xpath = "(//a[@title='Delete'])[1]")
	WebElement deleteTask;

	@FindBy(xpath = "//a[text()='View Completed Tasks']")
    WebElement ViewCompletedTask;

	@FindBy(xpath = "//a[text( )='View Open Tasks']")
	WebElement ViewOpenTask;
	
	@FindBy(xpath = "//input[@value='07/14/2023, 12:00 AM']")
	WebElement DateSelect;
	

	public WebElement getclickingPlusSign() {
		return clickingPlusSign;
	}

	public WebElement getTaskfield() {
		return taskfield;
	}

	public WebElement getAddtask() {
		return Addtask;
	}

	public WebElement getcancelWithoutDueDate() {
		return cancelWithoutDueDate;
	}

	public WebElement getClickingComplete() {
		return ClickingComplete;
	}

	public WebElement getDeleteTask() {
		return deleteTask;
	}

	public WebElement getViewCompletedTask() {
		return ViewCompletedTask;
	}

	public WebElement getViewOpenTask() {
		return ViewOpenTask;
	}

	public WebElement getDateSelect() {
		return DateSelect;
	}
	
}
