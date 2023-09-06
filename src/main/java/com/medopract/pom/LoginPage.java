package com.medopract.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medopract.generic.BaseClass;

public class LoginPage extends BaseClass{
	
public LoginPage(WebDriver driver){
	PageFactory.initElements(driver, this);
}
	
	@FindBy(name="userName")
	WebElement UsernameField;
	
	@FindBy(name="password")
	WebElement PasswordField;
	
	@FindBy(xpath="//button[.='Submit']")
	WebElement SubmitBtn;
	
	@FindBy(xpath = "//a[@title='Logout']")
	WebElement LogoutBtn;
	
	@FindBy(xpath = "//button[text()=' Got it!']")
	WebElement gotItButton;
	
	@FindBy(xpath = "//div[text()='MedoPract']")
	WebElement accInfo;
	
	@FindBy(xpath="//input[@class='authCommon_checkbox__3oYxx']")
	WebElement rememberMeBtn;
	
	@FindBy(xpath="//div[@class='react-toast-notifications__toast__content css-1ad3zal']")
	WebElement errorMsgNotification;
	

	@FindBy(xpath="//div[@class='react-toast-notifications__toast__dismiss-button css-4hd0gx']")
	WebElement cancelNotification;
 
  
	
	public void setUsername(String un) {
		UsernameField.sendKeys(un);
	}
	
	public void setPassword(String pw) {
		 PasswordField.sendKeys(pw);
	}
	
	public WebElement getUsername() {
		return UsernameField;
	}
	
	public WebElement getPassword() {
		return PasswordField;
	}
	
	public void getSubmitButton() {
		 SubmitBtn.click();
	}
	
	public WebElement geterrorMsgNotification() {
		return errorMsgNotification;
	}
	
	public void getcancelNotification() {
		 cancelNotification.click();
	}
	
	public WebElement getaccInfo() {
		return accInfo;
	}
	
	
	public void getLogoutBtn() {
		 LogoutBtn.click();
	}
	
	public void getGotItButton() {
		 gotItButton.click();
	}
	
	public void getrememberMeBtn() {
		 rememberMeBtn.click();
	}

	
	
	}

