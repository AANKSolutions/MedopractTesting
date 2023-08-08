package com.medopract.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientVisitPage {
	public PatientVisitPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//a[text( )='Patients'])[1]")
	WebElement patientsClick;

	@FindBy(xpath="//a[text()='PATIENT VISIT']") 
	WebElement patientvisitClick;

	@FindBy(xpath="//input[@class='PatientVisit_patientnameinput__53SG5']")
	WebElement patientVisitName;

	@FindBy(xpath="(//div[@class='PatientVisit_suggestions__vl23C'])[1]")
	WebElement patientVisitNameSuggestions;

	@FindBy(name="primarycomplain")
	WebElement primaryComplaint;

	@FindBy(xpath="(//a[text()='+'])[1]")
	WebElement clickingSymptomsPlusSign;

	@FindBy(name="symtomsIndicationsInput")
	WebElement symptoms;
	
	@FindBy(xpath = "//div[@class='react-toast-notifications__toast__dismiss-button css-4hd0gx']")
	WebElement cancelNotification;

	@FindBy(xpath = "//a[@class='PatientVisit_systomremove__1kpoS']")
	WebElement symptomsDelete;

	@FindBy(name="bloodPressure")
	WebElement bloodPressure;

	@FindBy(name="sugarLevel")
	WebElement sugarLevel;

	@FindBy(name="heartRate")
	WebElement heartRate;

	@FindBy(xpath="//input[@name='investigationtests']")
	WebElement InvestigationTests;

	@FindBy(xpath = "//a[@class='PatientVisit_invsremove__1fW0V']")
	WebElement investigationDelete;

	@FindBy(xpath="(//a[text()='+'])[2]")
	WebElement clickingInvestigationPlusSign;

	@FindBy(name="clinicalObservation")
	WebElement clinicalObservation;

	@FindBy(name="diagnosisRemark")              
	WebElement diagnosisRemark;

	@FindBy(xpath="(//div[@class='col-md-2 col-sm-2'])[1]")
	WebElement saveButton;

	@FindBy(xpath="(//div[@class='col-md-2 col-sm-2'])[3]")
	WebElement followup;

	@FindBy(xpath="//input[@name='visitReason']")
	WebElement visitReason;

	@FindBy(xpath="//a[text()='Add Appointment']")
	WebElement addAppointment;

	@FindBy(xpath = "(//input[@class='PatientVisit_followupInput__3tX-8'])[2]")
	WebElement dateAndTimeFollowUp;
	
	@FindBy(xpath = "//div[@class='react-datepicker__day react-datepicker__day--014']")
	WebElement datePickFollowUp;
	
	@FindBy(xpath = "(//li[@class='react-datepicker__time-list-item '])[2]")
	WebElement timePickFollowUp;

	@FindBy(xpath="//a[@class='PatientVisit_addnewpatient__3XoyA']")
	WebElement addNewPatientHyperLink;

	@FindBy(id="fileButton")
	WebElement resultAndDocument;
	
	
	@FindBy(xpath = "//a[text()='Cancel']")
	WebElement cancelBtn;
	
	@FindBy(xpath="//div[text()='Please add Primary complaint']")
	WebElement errorMessage;
	
	@FindBy(xpath="//div[text()='Patient visit added successfully!']")
	WebElement successMessage;
	
	@FindBy(xpath="//div[@class='CreatePatient_content__5FiiA container-fluid']")
	WebElement addPatientPage;
	
	@FindBy(xpath = "//div[text()='Appointment added Successfully']")
	WebElement followNotification;
	
	

	public void getPatientsClick() {
		 patientsClick.click();
		 }
	
	public WebElement getfollowNotification() {
		return followNotification;
	}
	
	public WebElement getaddPatientPage() {
		return addPatientPage;
	}
	
	public WebElement getsuccessMessage() {
		return successMessage;
	}

	public WebElement geterrorMessage() {
		return errorMessage;
	}

	public void getPatientvisitClick() {
		 patientvisitClick.click();
	}

	public WebElement getPatientVisitName() {
		return patientVisitName;
	}

	public void getpatientVisitNameSuggestions() {
		 patientVisitNameSuggestions.click();
	}

	public WebElement getPrimaryComplaint() {
		return primaryComplaint;
	}

	public void getClickingSymptomsPlusSign() {
		 clickingSymptomsPlusSign.click();
	}

	public WebElement getSymptoms() {
		return symptoms;
	}

	public void getsymptomsDelete() {
		  symptomsDelete.click();
	}

	public WebElement getbloodPressure() {
		return bloodPressure ;
	}

	public WebElement getsugarLevel() {
		return sugarLevel ;
	}

	public WebElement getheartRate() {
		return heartRate ;
	}

	public WebElement getInvestigationTests() {
		return InvestigationTests;
	}

	public void getClickingInvestigationPlusSign() {
		 clickingInvestigationPlusSign.click();
	}

	public void getinvestigationDelete() {
		 investigationDelete.click();
	}
	public WebElement getclinicalObservation(){
		return clinicalObservation;
	}

	public WebElement getdiagnosisRemark() {
		return diagnosisRemark;
	}

	public void getSaveButton() {
		 saveButton.click();
	}

	public void getFollowup() {
		 followup.click();
	}

	public void getAddAppointment() {
		 addAppointment.click();
	}

	public WebElement getVisitReason() {
		return visitReason;
	}

	public WebElement getdateAndTimeFollowUp() {
		return dateAndTimeFollowUp;
	}

	public void getaddNewPatientHyperLink() {
		 addNewPatientHyperLink.click();
	}

	public WebElement getresultAndDocument() {
		return resultAndDocument;
	}
	
	public void getdatePickFollowUp() {
		 datePickFollowUp.click();
	}
	
	public void gettimePickFollowUp() {
		 timePickFollowUp.click();
	}
	
	public void getcancelBtn() {
		 cancelBtn.click();
	}
	
	public void getcancelNotification() {
		 cancelNotification.click();
	}
}
