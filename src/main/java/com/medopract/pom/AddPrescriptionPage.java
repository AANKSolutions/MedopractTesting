package com.medopract.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medopract.generic.BaseClass;

public class AddPrescriptionPage extends BaseClass{

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

	public void getclickPrescription() {
		 clickPrescription.click();
	}
	
	public  void getcancelNotification() {
		 cancelNotification.click();
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
	
	public void getpatientNameSuggestion() {
		 patientNameSuggestion.click();
	}

	public WebElement getEmailField() {
		return emailField;
	}

	public void getClickingPlusSign() {
		 clickingPlusSign.click();
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

	public void getSaveAndPrintButton() {
		 saveAndPrintButton.click();
	}

	public void getBackButton() {
		 backButton.click();
	}

    public void getyesButtonField() {
    	 yesButtonField.click();
    }
    
    public void getprescriptionBackBtn() {
    	 prescriptionBackBtn.click();
    }
		
    public void getprintPrescription() {
    	 printPrescription.click();
    }	
	
    public void getdownloadPrescription() {
    	 downloadPrescription.click();
    }
	
    public void getbackPrescriptionbtn() {
    	 prescriptionBackBtn.click();
    }
	
    public void getdeleteMedicineField() {
    	 deleteMedicine.click();
    }
}

