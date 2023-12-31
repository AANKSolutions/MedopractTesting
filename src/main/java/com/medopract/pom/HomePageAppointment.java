package com.medopract.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medopract.generic.BaseClass;

public class HomePageAppointment extends BaseClass{

	public WebDriver driver;

	public HomePageAppointment(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath ="//div[contains(@class,'nextAppointment_addition__3AA9I')]")
	WebElement ClickingSigns;

	@FindBy(name = "firstName")
	WebElement NameField;

	@FindBy(name = "lastName")
	WebElement LastNameField;

	@FindBy(name = "visitReason")
	WebElement VisitReasonField;

	@FindBy(name = "mobile")
	WebElement MobileField;

	@FindBy(xpath = "//button[text( )='Add Appointment']")
	WebElement AddAppointmentButton;

	@FindBy(xpath = "//a[@class='nextAppointment_edit__teObG']")
	WebElement EditExistingAppointment;

	@FindBy(xpath = "//button[@id='cursorStyle']")
	WebElement UpdateButton;
	
	@FindBy(xpath = "//a[@title='Cancel']")
	WebElement CancelExistingAppointment;
	
	@FindBy(xpath="//button[@title='Send Reminder SMS']")
	WebElement SMSReminder;
	
	@FindBy(xpath="(//span[@class='nextAppointment_descriptionerrorshow__2IHdw'])[1]")
	WebElement errorMsg;
	
	@FindBy(xpath="//div[@class='react-toast-notifications__toast__dismiss-button css-4hd0gx']")
	WebElement cancelNotification;
	
	@FindBy(xpath="//div[@class='react-toast-notifications__toast__content css-1ad3zal']")
	WebElement Notification;

	
	public void getClickingSigns() {
		 ClickingSigns.click();
	}
	
	public WebElement geterrorMsg() {
		return errorMsg;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getNameField() {
		return NameField;
	}

	public WebElement getLastNameField() {
		return LastNameField;
	}

	public WebElement getVisitReasonField() {
		return VisitReasonField;
	}

	public WebElement getMobileField() {
		return MobileField;
	}

	public void getAddAppointmentButton() {
		 AddAppointmentButton.click();
	}

	public void getCancelExistingAppointment() {
		 CancelExistingAppointment.click();
	}

	public void getEditExistingAppointment() {
		 EditExistingAppointment.click();
	}

	public void getUpdateButton() {
		 UpdateButton.click();
	}

	public void getSMSReminder() {
		 SMSReminder.click();
	}
	
	public WebElement getNotification() {
		return Notification;
	}


	public void getcancelNotification() {
		 cancelNotification.click();
	}

	
}

