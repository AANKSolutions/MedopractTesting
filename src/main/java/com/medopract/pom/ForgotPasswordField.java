package com.medopract.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medopract.generic.BaseClass;

public class ForgotPasswordField extends BaseClass{

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
	
	@FindBy(xpath = "//p[@class='authCommon_title2__3cJid']")
	WebElement forgetPassPage;
	
	@FindBy(xpath = "//p[@class='authCommon_title2__3cJid']")
	WebElement backLoginPage;
	
	public WebElement getForgotPassPage() {
		return forgetPassPage;
	}

	public WebElement getbackLoginPage() {
		return backLoginPage;
	}

	public void getForgotPassword() {
		 forgotpassword.click();
	}

	public WebElement getUsernamefield() {
		return usernamefield;
	}

	public void getResetButtonClick() {
         ResetButtonClick.click();
	}

	public void getBackLoginPage() {
		 BackLoginPage.click();;
	}
	
	public void getGotItButton() {
		 gotItButton.click();
	}

}



