package com.medopract.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPrescriptionPage {

	public AddPrescriptionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//a[text( )='Prescription'])[1]")
	WebElement clickPrescription;
	
	@FindBy(name="patientname")
	WebElement patientNameField;
	
	@FindBy(xpath="(//li[@class='AddPrescription_suggestion__3HFdG'])[2]")
	WebElement patientNameSuggestion;
	
	@FindBy(name="email")                         
	WebElement emailField;
	
	@FindBy(xpath="//a[@class='AddPrescription_addinvestigationtests__BMTsR ']")
	WebElement clickingPlusSign;
	
	@FindBy(xpath="//input[@name='medicinesInput']")
	WebElement medicineNameField;
	
	@FindBy(xpath="//input[@name='daysInput']")
	WebElement totalNumberDays;
	
	@FindBy(xpath="//input[@name='timingsInput']")
	WebElement timingsInput;
	
	@FindBy(xpath="//input[@name='amountInput']")
	WebElement amountInput;
	
	@FindBy(xpath="//button[@class=' AddPrescription_buttonscom__3_zBx']")
	WebElement saveAndPrintButton;
	
	@FindBy(xpath="//a[@class='AddPrescription_buttonscom__3_zBx']")
	WebElement backButton;
	
	@FindBy(xpath = "//button[@class='AddPrescription_okBtn__uL1l0']")
    WebElement yesButtonField;
	
	@FindBy(xpath="//button[@class='AddPrescription_NoBtn___ATps']")           
	WebElement noButtonField;
	
	@FindBy(xpath="//a[@class='AddPrescription_systomremove__3o7gS']")
	WebElement deleteMedicine;
	
	@FindBy(xpath = "//button[text()='Print']")
	WebElement printPrescription;
	
	@FindBy(xpath="//button[text()='Download']")
	WebElement downloadPrescription;
	
	@FindBy(xpath="//a[@class='SavePrescriptionPopUp_buttonscom__2WmCJ']")
	WebElement prescriptionBackBtn;
	
	@FindBy(xpath="//div[text()='Please add medicines']")
	WebElement errorMessage;
	
	@FindBy(xpath="//div[@class='react-toast-notifications__toast__content css-1ad3zal']")
	WebElement medicineErrorMsg;
	
	@FindBy(xpath="//div[text()='Prescription created successfully!']")
	WebElement successMessage;
	
	@FindBy(xpath="//div[@class='react-toast-notifications__toast__dismiss-button css-4hd0gx']")
	WebElement cancelNotification;

	public WebElement getclickPrescription() {
		return clickPrescription;
	}
	
	public WebElement getcancelNotification() {
		return cancelNotification;
	}
	
	public WebElement getmedicineErrorMsg() {
		return medicineErrorMsg;
	}
	
	public WebElement getsuccessMessage() {
		return successMessage;
	}

	public WebElement geterrorMessage() {
		return errorMessage;
	}

	public WebElement getPatientNameField() {
		return patientNameField;
	}
	
	public WebElement getpatientNameSuggestion() {
		return patientNameSuggestion;
	}

	public WebElement getEmailField() {
		return emailField;
	}

	public WebElement getClickingPlusSign() {
		return clickingPlusSign;
	}

	public WebElement getMedicineNameField() {
		return medicineNameField;
	}

	public WebElement getTotalNumberDays() {
		return totalNumberDays;
	}

	public WebElement getTimingsInput() {
		return timingsInput;
	}

	public WebElement getAmountInput() {
		return amountInput;
	}

	public WebElement getSaveAndPrintButton() {
		return saveAndPrintButton;
	}

	public WebElement getBackButton() {
		return backButton;
	}

    public WebElement getyesButtonField() {
    	return yesButtonField;
    }
    
    public WebElement getprescriptionBackBtn() {
    	return prescriptionBackBtn;
    }
		
    public WebElement getprintPrescription() {
    	return printPrescription;
    }	
	
    public WebElement getdownloadPrescription() {
    	return downloadPrescription;
    }
	
    public WebElement getbackPrescriptionbtn() {
    	return prescriptionBackBtn;
    }
	
    public WebElement getdeleteMedicineField() {
    	return deleteMedicine;
    }
}

