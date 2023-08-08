package com.medopract.pom;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	
public class ViewOrEditPage {

	public ViewOrEditPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[text()='VIEW/EDIT']")
	WebElement viewOrEdit;

	@FindBy(xpath="//input[@name='patientname']")
	WebElement patientNameField;

	@FindBy(xpath="//input[@name='phone']")
	WebElement phoneNumberField;

	@FindBy(xpath="(//div[@class='PatientEdit_patientList__1tgKV row'])[1]")
	WebElement patientListClick;

	@FindBy(xpath="//button[text()='Update']")
	WebElement updateButtonClick;

	@FindBy(xpath="//button[text()='Cancel']")
	WebElement cancelButtonClick;

	@FindBy(xpath="(//button[text()='Delete'])[2]")
	WebElement deleteButtonClick;

	@FindBy(xpath="//div[text()='Patient record updated successfully!']")
	WebElement successUpdateMsg;
	
	@FindBy(xpath="//div[text()='Patient record deleted successfully!']")
	WebElement deleteUpdateMsg;
	
	@FindBy(xpath="//div[text()='Please provide required inputs']")
	WebElement errorUpdateMsg;
	
	@FindBy(xpath="//div[@class='PatientEdit_content__3uYLP container-fluid']")
	WebElement viewOrEditPage;
	
	@FindBy(xpath="//div[@class='react-toast-notifications__toast__dismiss-button css-4hd0gx']")
	WebElement cancelNotification;
	
	

	public void getViewOrEdit() {
		 viewOrEdit.click();
	}
	
	public WebElement getViewOrEditPage() {
		return viewOrEditPage;
	}
	
	public WebElement getsuccessUpdateMsg() {
		return successUpdateMsg;
	}
	
	public WebElement getdeleteUpdateMsg() {
		return deleteUpdateMsg;
	}
	
	public WebElement geterrorUpdateMsg() {
		return errorUpdateMsg;
	}

	public WebElement getPatientNameField() {
		return patientNameField;
	}

	public WebElement getPhoneNumberField() {
		return phoneNumberField;
	}

	public void getPatientListClick() {
		 patientListClick.click();
	}

	public void getUpdateButtonClick() {
		 updateButtonClick.click();
	}

	public void getCancelButtonClick() {
		 cancelButtonClick.click();
	}
    public void getDeleteButtonClick() {
	    deleteButtonClick.click();
    }
    public void getcancelNotification() {
		 cancelNotification.click();
	}


}


