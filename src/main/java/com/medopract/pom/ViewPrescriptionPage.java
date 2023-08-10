package com.medopract.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medopract.generic.BaseClass;

public class ViewPrescriptionPage extends BaseClass{

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
	
	
	public void getPrescriptionsLink(){
	 prescriptionsLink.click();
}

	public WebElement getpatientDetailsPage(){
	return patientDetailsPage;
}
	
	public void getviewPrescriptionsLink(){
	 viewPrescriptionsLink.click();
}
	public WebElement getviewPrescriptionsuccessful(){
		return viewPrescriptionsuccessful;
	}
	
	public WebElement getpatientNameField(){
	return  patientNameField;
}
	
	public void getpatientNameFieldSugg(){
	 patientNameFieldSugg.click();
}
	
	public void getprescriptionDetails(){
		 prescriptionDetails.click();
	}
	
	public void getbackBtn(){
		 backBtn.click();
	}
	
	public void getgoToPatientDetails(){
		 goToPatientDetails.click();
	}
}
