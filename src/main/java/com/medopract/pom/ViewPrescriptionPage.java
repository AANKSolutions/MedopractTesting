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
	
	@FindBy(xpath="//a[text()='VIEW PRESCRIPTIONS']")
	WebElement viewPrescriptionsLink;
	
	@FindBy(name="patientname")
	WebElement patientNameField;
	
	@FindBy(xpath="(//div[@class='ViewPrescription_suggestions__JcWfc'])[1]")
	WebElement patientNameFieldSugg;
	
	@FindBy(xpath="//div[@class='ViewPrescription_patientList__2wK1Y row'][1]")
	WebElement prescriptionDetails;
	
	@FindBy(xpath="//a[text()='Back']")
	WebElement backBtn;
	
	@FindBy(xpath="//a[text()='Go to Patient Details']")
	WebElement goToPatientDetails;
	
	public WebElement getPrescriptionsLink(){
	return prescriptionsLink;
}
	
	public WebElement getviewPrescriptionsLink(){
	return viewPrescriptionsLink;
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
