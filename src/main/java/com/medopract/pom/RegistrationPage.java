package com.medopract.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {


	public WebDriver driver;

	public RegistrationPage(WebDriver driver){

		PageFactory.initElements(driver, this);	

	}
	@FindBy(xpath = "//a[text()='Register Now']")
	WebElement ClickRegisterNow;

	@FindBy(name = "fullName")
	public WebElement nameField;

	@FindBy(name="email")
	WebElement emailField;

	@FindBy(name="mobile")
	WebElement mobileField;

	@FindBy(name = "userName")
	WebElement userNameField;

	@FindBy(name="confirmUserName")
	WebElement confirmUserNameField;

	@FindBy(name="agreeterm")
	WebElement agreetermCheckBox;

	@FindBy(xpath="//button[text()='Register']")
	WebElement clickRegisterButton;

	@FindBy(xpath = "(//div[@class='col-sm-12'])[2]/..")
	WebElement clickImAlreadyUser;

	@FindBy(xpath = "//a[@class='TooltipAuth_helpTag__DvHOH']")
	WebElement clickHelp;

	@FindBy(xpath = "//button[text()=' Got it!']")
	WebElement gotItButton;

	@FindBy(xpath = "//button[@class='register_okBtn__3PRzY']")
	WebElement okButton;

	@FindBy(xpath="//span[@class='register_modalText__2Q3RR']")
	WebElement registrationSuccessfulMsg;

	@FindBy(xpath="//div[@class='react-toast-notifications__toast__dismiss-button css-4hd0gx']")
	WebElement cancelNotification;
	
	@FindBy(xpath="//div[@class='react-toast-notifications__toast__content css-1ad3zal']")
	WebElement errorNotification;
	
	@FindBy(xpath="//p[text()='Confirm Username must be 8-16 Characters, Alphabets, Numbers and ._%+-@ allowed']")
	WebElement confirmUnErrorNotification;
	
	@FindBy(xpath="//p[text()='Please check this box if you want to Proceed!']")
	WebElement TermsErrorNotification;
	
	
	public WebElement getconfirmUnErrorNotification() {
		return confirmUnErrorNotification;
	}

	public WebElement getTermsErrorNotification() {
		return TermsErrorNotification;
	}

	public void getClickRegisterNow() {
		 ClickRegisterNow.click();
	}

	public WebElement geterrorNotification() {
		return errorNotification;
	}


	public void getcancelNotification() {
		 cancelNotification.click();
	}

	public WebElement getregistrationSuccessfulMsg() {
		return registrationSuccessfulMsg;
	}

	public WebElement getnameField() {
		return nameField;
	}

	public WebElement getemailField() {
		return emailField;
	}

	public WebElement getmobileField() {
		return mobileField;
	}

	public WebElement getuserNameField() {
		return userNameField;
	}

	public WebElement getconfirmUserNameField() {
		return confirmUserNameField;
	}

	public void getagreetermCheckBox() {
		 agreetermCheckBox.click();
	}

	public void getclickRegisterButton(){
		 clickRegisterButton.click();
	}

	public void getclickImAlreadyUser(){
		 clickImAlreadyUser.click();
	}
	public void getclickHelp(){
		 clickHelp.click();
	}

	public void getGotItButton() {
		 gotItButton.click();
	}	

	public void getOkButton() {
		 okButton.click();
	}
}
