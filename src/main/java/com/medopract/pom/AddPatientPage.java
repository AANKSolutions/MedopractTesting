package com.medopract.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medopract.generic.BaseClass;


public class AddPatientPage extends BaseClass {
	
	public AddPatientPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[text( )='Patients'])[1]")
	WebElement patientsClick;
	
	@FindBy(xpath = "//div[@class='react-date-picker__inputGroup']")
	WebElement birthDateField;
	
	@FindBy(css = "input[name='month'],[class='react-date-picker__inputGroup__input react-date-picker__inputGroup__month']")
	WebElement monthField;
	
	@FindBy (css="input[name='day'],[class='react-date-picker__inputGroup__input react-date-picker__inputGroup__day']")
	WebElement dayField;
	
	@FindBy(css = "input[name='year'],[class='react-date-picker__inputGroup__input react-date-picker__inputGroup__year']")
	WebElement yearField;
	
	@FindBy(xpath = "//div[@class='react-toast-notifications__toast__dismiss-button css-4hd0gx']")
	WebElement cancelNotification;
	
	@FindBy(xpath="//a[text( )='ADD PATIENT']")
	WebElement addPatientClick;
	
	@FindBy(name="patientname")
	WebElement patientNameField;
	
	@FindBy(name="phoneNumber")
	WebElement phoneNoField;
	
	@FindBy(xpath = "//select[@name='gender']/option[@value='Male']")
	WebElement genderField;
	
	@FindBy(xpath = "//select[@name='bloodgroup']/option[@value='A+']")
	WebElement bloodGroupField;
	
	@FindBy(name="occupation")
	WebElement OccupationField;
	
	@FindBy(name="address")
	WebElement addressField;
	
	@FindBy(name="emergency")
	WebElement emergencyField;
	
	@FindBy(name="allergies")
	WebElement allergiesField;
	
	@FindBy(name="diagnosisRemark")
	WebElement remarksField;
	
	@FindBy(name="history")
	WebElement historyField;
	
	@FindBy(name="habits")
	WebElement habitsField;
	
	@FindBy(xpath="//a[@class='CreatePatient_addinvestigationtests__18P-9']")
	WebElement clickingPlusSign;
	
	@FindBy(id="fileButton")
	WebElement selectImage;
	
	@FindBy(xpath="(//div[@class='col-md-2 col-sm-2 col-5'])[1]")
	WebElement saveButton;
	
	@FindBy(xpath="//button[text()='Capture photo']")
    WebElement capturePhoto;

	@FindBy(xpath="(//div[@class='col-md-2 col-sm-2 col-5'])[2]")
	WebElement resetButton;
	
	@FindBy(xpath="//div[text()='Patient Record created successfully!']")
	WebElement createdSuccessfully;
 
	@FindBy(xpath="//div[text()='Please provide required inputs']")
	WebElement errorMessage;
	
	@FindBy(xpath = "//p[text()='Please enter valid name- Only Alphabets and spaces are allowed']")
	WebElement nameErrorMsg;

	@FindBy(xpath = "//p[text()='Mobile number must be 10 digits long valid number']")
	WebElement mobileNoErrorMsg;
	
	@FindBy(xpath = "//span[@class='CreatePatientSidebar_patientId__3-vo7']")
	WebElement patientId;
	
	public WebElement getPatientsClick() {
		return patientsClick;
	}
	
	public WebElement getnameErrorMsg() {
		return nameErrorMsg;
	}
	
	public WebElement getpatientId() {
		return patientId;
	}
	
	public WebElement getcancelNotification () {
		return cancelNotification;
	}
	
	public WebElement getErrorMessage() {
		return errorMessage;
	}
	
	public WebElement getMobileNoErrorMsg() {
		return mobileNoErrorMsg;
	}
	
	
	public WebElement getCreatedSuccessfully() {
		return createdSuccessfully;
	}

	public WebElement getAddPatientClick() {
		return addPatientClick;
	}

	public WebElement getPatientNameField() {
		return patientNameField;
	}
	
	public WebElement getbirthDateField() {
		return birthDateField;
	}
	
	public WebElement getmonthField() {
		return monthField;
	}
	
	public WebElement getDayField() {
		return dayField;
	}
	
	public WebElement getYearField() {
		return yearField;
	}

	public WebElement getPhoneNoField() {
		return phoneNoField;
	}
	
	public WebElement getgenderField() {
		return genderField;
	}
	
	public WebElement getBloodGroupField() {
		return bloodGroupField;
	}

	public WebElement getOccupationField() {
		return OccupationField;
	}
	
	public WebElement getAddressField() {
		return addressField;
	}

	public WebElement getEmergencyField() {
		return emergencyField;
	}

	public WebElement getAllergiesField() {
		return allergiesField;
	}

	public WebElement getRemarksField() {
		return remarksField;
	}

	public WebElement getHistoryField() {
		return historyField;
	}

	public WebElement getHabitsField() {
		return habitsField;
	}

	public WebElement getClickingPlusSign() {
		return clickingPlusSign;
	}
	
	public WebElement getSelectImage() {
		return selectImage;
	}
  
	public WebElement getCapturePhoto() {
		return capturePhoto;
	}
	
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public WebElement getResetButton() {
		return resetButton;
	}
	
	
}
