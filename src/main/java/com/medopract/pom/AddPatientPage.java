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
	
	@FindBy(xpath = "//input[@value='2023-07-06']")
	WebElement birthDateField;
	
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
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveButton;
	
	@FindBy(xpath="//button[text()='Capture photo']")
    WebElement capturePhoto;

	@FindBy(xpath="//button[text()='Reset']")
	WebElement resetButton;
	
	
	
	
	public WebElement getPatientsClick() {
		return patientsClick;
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
