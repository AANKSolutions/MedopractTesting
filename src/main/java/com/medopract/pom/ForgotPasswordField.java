package com.medopract.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordField {

	public ForgotPasswordField(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[text( )='Forgot password?']")
	WebElement forgotpassword;

	@FindBy(name = "userName")
	WebElement usernamefield;

	@FindBy(xpath = "//button[text( )='Reset Password']")
	WebElement ResetButtonClick;

	@FindBy(xpath = "(//div[@class='col-sm-12'])[2]/..")
	WebElement BackLoginPage;
	
	@FindBy(xpath = "//button[text()=' Got it!']")
	WebElement gotItButton;

	public WebDriver driver;
	

	public WebElement getForgotPassword() {
		return forgotpassword;
	}

	public WebElement getUsernamefield() {
		return usernamefield;
	}

	public WebElement getResetButtonClick() {
		return ResetButtonClick;
	}

	public WebElement getBackLoginPage() {
		return BackLoginPage;
	}
	
	public WebElement getGotItButton() {
		return gotItButton;
	}

}



