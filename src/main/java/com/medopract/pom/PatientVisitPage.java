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

	@FindBy(xpath="//a[@class='PatientVisit_addsymtoms__1b_WG ']")
	WebElement clickingSymptomsPlusSign;

	@FindBy(name="symtomsIndicationsInput")
	WebElement symptoms;

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

	@FindBy(xpath="//a[@class='PatientVisit_addinvestigationtests__3VHP_ PatientVisit_indication150__I0XhM']")
	WebElement clickingInvestigationPlusSign;

	@FindBy(name="clinicalObservation")
	WebElement clinicalObservation;

	@FindBy(name="diagnosisRemark")
	WebElement diagnosisRemark;

	@FindBy(xpath="//a[@class=' PatientVisit_buttonscom__2NWJ0']")
	WebElement saveButton;

	@FindBy(xpath="//a[@class='PatientVisit_buttonscom__2NWJ0']")
	WebElement followup;

	@FindBy(xpath="//input[@name='visitReason']")
	WebElement visitReason;

	@FindBy(xpath="//a[text( )='Add Appointment']")
	WebElement addAppointment;

	@FindBy(xpath = "//div[@class='react-datepicker-wrapper']")
	WebElement dateAndTime;

	@FindBy(xpath="//a[@class='PatientVisit_addnewpatient__3XoyA']")
	WebElement addNewPatientHyperLink;

	@FindBy(id="fileButton")
	WebElement resultAndDocument;
	
	@FindBy(xpath="(//input[@class='PatientVisit_followupInput__3tX-8'])[2]")
	WebElement followUpDateAndTime;
	
	@FindBy(xpath="//div[@class='react-datepicker__day react-datepicker__day--025 react-datepicker__day--selected']")
	WebElement datePickFollowUp;
	
	@FindBy(xpath="//li[text()='10:00 AM']")
	WebElement timePickFollowUp;
	
	@FindBy(xpath = "//a[text()='Cancel']")
	WebElement cancelBtn;

	public WebElement getPatientsClick() {
		return patientsClick;
	}

	public WebElement getPatientvisitClick() {
		return patientvisitClick;
	}

	public WebElement getPatientVisitName() {
		return patientVisitName;
	}

	public WebElement getpatientVisitNameSuggestions() {
		return patientVisitNameSuggestions;
	}

	public WebElement getPrimaryComplaint() {
		return primaryComplaint;
	}

	public WebElement getClickingSymptomsPlusSign() {
		return clickingSymptomsPlusSign;
	}

	public WebElement getSymptoms() {
		return symptoms;
	}

	public WebElement getsymptomsDelete() {
		return  symptomsDelete;
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

	public WebElement getClickingInvestigationPlusSign() {
		return clickingInvestigationPlusSign;
	}

	public WebElement getinvestigationDelete() {
		return investigationDelete;
	}
	public WebElement getclinicalObservation(){
		return clinicalObservation;
	}

	public WebElement getdiagnosisRemark() {
		return diagnosisRemark;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getFollowup() {
		return followup;
	}

	public WebElement getAddAppointment() {
		return addAppointment;
	}

	public WebElement getVisitReason() {
		return visitReason;
	}

	public WebElement getdateAndTime() {
		return dateAndTime;
	}

	public WebElement getaddNewPatientHyperLink() {
		return addNewPatientHyperLink;
	}

	public WebElement getresultAndDocument() {
		return resultAndDocument;
	}
	
	public WebElement getfollowUpDateAndTime() {
		return followUpDateAndTime;
	}
	
	public WebElement getdatePickFollowUp() {
		return datePickFollowUp;
	}
	
	public WebElement gettimePickFollowUp() {
		return timePickFollowUp;
	}
	
	public WebElement getcancelBtn() {
		return cancelBtn;
	}
}
