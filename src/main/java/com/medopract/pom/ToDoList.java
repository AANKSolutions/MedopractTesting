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

	@FindBy(xpath = "//a[@class='todoList_Tasklink__1460g']")
    WebElement ViewCompletedTask;

	@FindBy(xpath = "//a[@class='todoList_Tasklink__1460g']")
	WebElement ViewOpenTask;
	
	@FindBy(xpath = "//input[@class='todoList_todotime__1bSAv']")
	WebElement dateAndTime;
	
	@FindBy(xpath = "//div[@class='react-datepicker__day react-datepicker__day--025']")
	WebElement dateSelect;
	
	@FindBy(xpath="(//li[@class='react-datepicker__time-list-item '])[3]")
	WebElement timeSelect;
	
	@FindBy(xpath="//div[@class='react-toast-notifications__toast__content css-1ad3zal']")
	WebElement notification;
	
	@FindBy(xpath = "//div[@class='react-toast-notifications__toast__dismiss-button css-4hd0gx']")
	WebElement cancelNotification;
	
	@FindBy(xpath = "//span[@class='todoList_descriptionerrorshow__1eD27']")
	WebElement errorMsg;
	
	
	

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
		return dateSelect;
	}
	
	public WebElement getTimeSelect() {
		return timeSelect;
	}
	
	public WebElement getdateAndTime() {
		return dateAndTime;
	}
	
	public WebElement getNotification() {
		return notification;
	}
	
	public WebElement getcancelNotification() {
		return cancelNotification;
	}
	
	public WebElement geterrorMsg() {
		return errorMsg;
	}
	
}
