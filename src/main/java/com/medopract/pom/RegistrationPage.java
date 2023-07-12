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

	@FindBy(xpath="//button[text()='OK']")
	WebElement successMessage;

	@FindBy(xpath = "(//div[@class='col-sm-12'])[2]/..")
	WebElement clickImAlreadyUser;

	@FindBy(xpath = "//a[@class='TooltipAuth_helpTag__DvHOH']")
	WebElement clickHelp;

	@FindBy(xpath = "//button[text()=' Got it!']")
	WebElement gotItButton;

	

	public WebElement getClickRegisterNow() {
		return ClickRegisterNow;
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
	
	public WebElement getagreetermCheckBox() {
		return agreetermCheckBox;
	}
	
	public WebElement getclickRegisterButton(){
        return clickRegisterButton;
}
	
	public WebElement getsuccessMessage(){
        return successMessage;
}
		
	public WebElement getclickImAlreadyUser(){
        return clickImAlreadyUser;
}
	public WebElement getclickHelp(){
        return clickHelp;
}
	
	public WebElement getGotItButton() {
		return gotItButton;
	}	
	
}
