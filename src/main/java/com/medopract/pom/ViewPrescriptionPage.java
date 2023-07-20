package com.medopract.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewPrescriptionPage {

	public ViewPrescriptionPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//a[text()='Prescription'])[1]")
	WebElement prescriptionsLink;
	
	@FindBy(xpath="(//a[text()='VIEW PRESCRIPTIONS'])[1]")
	WebElement viewPrescriptionsLink;
	
	@FindBy(name="patientname")        
	WebElement patientNameField;
	
	@FindBy(xpath="//li[@class='ViewPrescription_suggestion__3OklH'][1]")
	WebElement patientNameFieldSugg;
	
	@FindBy(xpath="(//div[@class='ViewPrescription_patientList__2wK1Y row'])[1]")
	WebElement prescriptionDetails;
	
	@FindBy(xpath="//a[text()='Back']")
	WebElement backBtn;

	@FindBy(xpath="//a[text()='Go to Patient Details']")
	WebElement goToPatientDetails;

	@FindBy(xpath="(//div[@class='SavePrescriptionPopUp_rowWrapper__1R7Vf'])[1]")
	WebElement viewPrescriptionsuccessful;
	
	@FindBy(xpath="//a[text()='VIEW/EDIT']")
	WebElement patientDetailsPage;
	
	public WebElement getPrescriptionsLink(){
	return prescriptionsLink;
}

	public WebElement getpatientDetailsPage(){
	return patientDetailsPage;
}
	
	public WebElement getviewPrescriptionsLink(){
	return viewPrescriptionsLink;
}
	public WebElement getviewPrescriptionsuccessful(){
		return viewPrescriptionsuccessful;
	}
	
	public WebElement getpatientNameField(){
	return  patientNameField;
}
	
	public WebElement getpatientNameFieldSugg(){
	return patientNameFieldSugg;
}
	
	public WebElement getprescriptionDetails(){
		return prescriptionDetails;
	}
	
	public WebElement getbackBtn(){
		return backBtn;
	}
	
	public WebElement getgoToPatientDetails(){
		return goToPatientDetails;
	}
}
