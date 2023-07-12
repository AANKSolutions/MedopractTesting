package com.medopract.pom;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	
public class ViewOrEditPage {

	public ViewOrEditPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[text( )='VIEW/EDIT']")
	WebElement viewOrEdit;

	@FindBy(xpath="//input[@name='patientname']")
	WebElement patientNameField;

	@FindBy(xpath="//input[@name='phone']")
	WebElement phoneNumberField;

	@FindBy(xpath="(//div[text()='Ashwin'])[3]")
	WebElement patientListClick;

	@FindBy(xpath="//button[text( )='Update']")
	WebElement updateButtonClick;

	@FindBy(xpath="//button[text( )='Cancel']")
	WebElement cancelButtonClick;

	@FindBy(xpath="(//button[text()='Delete'])[2]")
	WebElement deleteButtonClick;

	public WebElement getViewOrEdit() {
		return viewOrEdit;
	}

	public WebElement getPatientNameField() {
		return patientNameField;
	}

	public WebElement getPhoneNumberField() {
		return phoneNumberField;
	}

	public WebElement getPatientListClick() {
		return patientListClick;
	}

	public WebElement getUpdateButtonClick() {
		return updateButtonClick;
	}

	public WebElement getCancelButtonClick() {
		return cancelButtonClick;
	}
    public WebElement getDeleteButtonClick() {
	   return deleteButtonClick;
}



}


