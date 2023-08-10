package com.medopract.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medopract.generic.BaseClass;

public class AppointmentsCalenderPage extends BaseClass{

	public AppointmentsCalenderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath= "(//a[.='Appointments'])[1]")
	WebElement clickAppointmentCalender;

	@FindBy(xpath = "//button[.='NEW APPOINTMENT']")
	WebElement NewAppointment;

	@FindBy(xpath= "(//input[@class='Appointments_input__3JhVR'])[1]")
	WebElement firstNameField;

	@FindBy(xpath = "(//input[@class='Appointments_input__3JhVR'])[2]")
	WebElement lastNameField;

	@FindBy(css = "textarea[name='visitreason']")
	WebElement visitreasonField;

	@FindBy(xpath = "(//input[@class='Appointments_input__3JhVR'])[3]")
	WebElement contactNumberField;
	
	@FindBy(xpath="//input[@class='Appointments_datetimeinput__1uUsg']")
	WebElement dateAndTimeField;
	
	@FindBy(xpath="//div[@class='react-datepicker__day react-datepicker__day--020']")
	WebElement datePick;
	
	@FindBy(xpath="(//li[@class='react-datepicker__time-list-item '])[4]")
	WebElement timePick;
	
	@FindBy(xpath = "//select[@name='duration']/option[text()='45 Minutes ']")
	WebElement duration;

	@FindBy(xpath = "//button[text()='Save Appointment']")
	WebElement saveAppointmentButton;

	@FindBy(xpath = "//button[text()='Month']")
	WebElement monthButton;

	@FindBy(xpath = "//button[text()='Week']")
	WebElement weekButton;

	@FindBy(xpath = "//button[text()='Day']")
	WebElement dayButton;

	@FindBy(xpath = "//button[text()='Agenda']")
	WebElement agendaButton;

	@FindBy(xpath = "//button[text()='Today']")
	WebElement weekTodayButton;

	@FindBy(xpath = "//button[text()='Back']")
	WebElement weekBackButton;

	@FindBy(xpath = "//button[text()='Next']")
	WebElement weekNextButton;

	@FindBy(xpath = "//button[text()='Today']")
	WebElement todayAgendaButton;

	@FindBy(xpath = "//button[text()='Back']")
	WebElement backAgendaButton;

	@FindBy(xpath = "//button[text()='Next']")
	WebElement nextAgendaButton;
	
	@FindBy(xpath="(//div[@class='rbc-event-content'])[1]")
    WebElement existingAppointment;
	
	@FindBy(xpath="(//div[@class='rbc-event'])[1]")
    WebElement updatedExistingAppointment;
	
	@FindBy(xpath="//td[@class='rbc-agenda-event-cell'][1]")
	WebElement agendaExistingAppointment;
	
	@FindBy(xpath="(//div[@class='col-md-2'])[2]")
	WebElement cancelExistingAppointment;
	
	@FindBy(xpath="//button[text()='Today']")
	WebElement dayTodayButton;
	
	@FindBy(xpath="//button[text()='Back']")
	WebElement dayBackButton;
	
	@FindBy(xpath="//button[text()='Next']")
	WebElement dayNextButton;
	
	@FindBy(xpath="//button[text()='Today']")
	WebElement monthTodayButton;
	
	@FindBy(xpath="//button[text()='Back']")
	WebElement monthBackButton;
	
	@FindBy(xpath="//button[text()='Next']")
	WebElement monthNextButton;
	
	@FindBy(xpath="//div[text()='Appointment added Successfully']")
	WebElement successMsg;
	
	@FindBy(xpath="//div[text()='Appointment Updated Successfully']")
	WebElement updateSuccessMsg;
	
	@FindBy(xpath="//div[text()='something went wrong!']")
	WebElement errorMsg;
	
	@FindBy(xpath="//div[@class='react-toast-notifications__toast__dismiss-button css-4hd0gx']")
    WebElement cancelNotification;
	
	

	public void getNewAppointment() {
		 NewAppointment.click();
	}
	
	public WebElement getsuccessMsg() {
		return successMsg;
	}
	
	public WebElement getupdateSuccessMsg() {
		return updateSuccessMsg;
	}
	
	public WebElement geterrorMsg() {
		return errorMsg;
	}
	
	public void getcancelNotification() {
		 cancelNotification.click();
	}

	public void getClickAppointmentCalender() {
		 clickAppointmentCalender.click();
	}

	public WebElement getFirstNameField() {
		return firstNameField;
	}

	public WebElement getLastNameField() {
		return lastNameField;
	}

	public WebElement getVisitreasonField() {
		return visitreasonField;
	}

	public void getdateAndTimeField() {
		 dateAndTimeField.click();
	}
	
	public void getdatePick() {
		 datePick.click();
	}
	
	public void gettimePick() {
		 timePick.click();
	}
	
	public WebElement getContactNumberField() {
		return contactNumberField;
	}
	
	public void getDurationField() {
		 duration.click();
	}

	public void getSaveAppointmentButton() {
		 saveAppointmentButton.click();
	}

	public void getMonthButton() {
		 monthButton.click();
	}

	public void getWeekButton() {
		 weekButton.click();
	}

	public void getDayButton() {
		 dayButton.click();
	}

	public void getAgendaButton() {
		 agendaButton.click();
	}

	public void getweekTodayButton() {
		 weekTodayButton.click();
	}

	public void getweekBackButton() {
		 weekBackButton.click();
	}

	public void getweekNextButton() {
		 weekNextButton.click();
	}

	public void getTodayAgendaButton() {
		 todayAgendaButton.click();
	}

	public void getBackAgendaButton() {
		 backAgendaButton.click();
	}

	public void getNextAgendaButton() {
		 nextAgendaButton.click();
	}

	public void getExistingAppointment() {
		 existingAppointment.click();
	}
	
	public void getUpdatedExistingAppointment() {
		 updatedExistingAppointment.click();
	}
	
	
	public WebElement getagendaExistingAppointment() {
		return agendaExistingAppointment;
	}
	
	public void getcancelExistingAppointment() {
		 cancelExistingAppointment.click();
	}

	public void getdayTodayButton() {
		 dayTodayButton.click();
	}

	public void getdayBackButton() {
		 dayBackButton.click();
	}

	public void getdayNextButton() {
		 dayNextButton.click();
	}

	public void getmonthNextButton() {
		 monthNextButton.click();
	}

	public void getmonthTodayButton() {
		 monthTodayButton.click();
	}

	public void getmonthBackButton() {
		 monthBackButton.click();
	}
	
}
