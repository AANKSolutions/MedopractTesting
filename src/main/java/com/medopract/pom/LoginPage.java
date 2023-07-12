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
	
	public WebElement getUsername() {
		return UsernameField;
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
	
	}

