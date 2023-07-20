package com.medopract.pom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	//public WebDriver driver;
	
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
	
	@FindBy(xpath = "//div[@class='col-md-8']")
	WebElement accInfo;
	
	@FindBy(xpath="//input[@class='authCommon_checkbox__3oYxx']")
	WebElement rememberMeBtn;
	
	@FindBy(xpath="//div[@class='react-toast-notifications__toast__content css-1ad3zal']")
	WebElement errorMsgNotification;
	

	@FindBy(xpath="//div[@class='react-toast-notifications__toast__dismiss-button css-4hd0gx']")
	WebElement cancelNotification;
 
  
	
	public WebElement getUsername() {
		return UsernameField;
	}
	
	public WebElement geterrorMsgNotification() {
		return errorMsgNotification;
	}
	
	public WebElement getcancelNotification() {
		return cancelNotification;
	}
	
	public WebElement getaccInfo() {
		return accInfo;
	}
	
	public WebElement getPassword() {
		return PasswordField;
	}
	
	public WebElement getSubmitButton() {
		return SubmitBtn;
	}
	
	public WebElement getLogoutBtn() {
		return LogoutBtn;
	}
	
	public WebElement getGotItButton() {
		return gotItButton;
	}
	
	public WebElement getrememberMeBtn() {
		return rememberMeBtn;
	}
	
	}

