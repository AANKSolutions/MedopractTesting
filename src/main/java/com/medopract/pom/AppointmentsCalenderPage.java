package com.medopract.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppointmentsCalenderPage {

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

	@FindBy(xpath = "//button[text( )='Agenda']")
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
	
	

	public WebElement getNewAppointment() {
		return NewAppointment;
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
	
	public WebElement getcancelNotification() {
		return cancelNotification;
	}

	public WebElement getClickAppointmentCalender() {
		return clickAppointmentCalender;
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

	public WebElement getdateAndTimeField() {
		return dateAndTimeField;
	}
	
	public WebElement getdatePick() {
		return datePick;
	}
	
	public WebElement gettimePick() {
		return timePick;
	}
	
	public WebElement getContactNumberField() {
		return contactNumberField;
	}
	
	public WebElement getDurationField() {
		return duration;
	}

	public WebElement getSaveAppointmentButton() {
		return saveAppointmentButton;
	}

	public WebElement getMonthButton() {
		return monthButton;
	}

	public WebElement getWeekButton() {
		return weekButton;
	}

	public WebElement getDayButton() {
		return dayButton;
	}

	public WebElement getAgendaButton() {
		return agendaButton;
	}

	public WebElement getweekTodayButton() {
		return weekTodayButton;
	}

	public WebElement getweekBackButton() {
		return weekBackButton;
	}

	public WebElement getweekNextButton() {
		return weekNextButton;
	}

	public WebElement getTodayAgendaButton() {
		return todayAgendaButton;
	}

	public WebElement getBackAgendaButton() {
		return backAgendaButton;
	}

	public WebElement getNextAgendaButton() {
		return nextAgendaButton;
	}

	public WebElement getExistingAppointment() {
		return existingAppointment;
	}
	
	public WebElement getUpdatedExistingAppointment() {
		return updatedExistingAppointment;
	}
	
	
	public WebElement getagendaExistingAppointment() {
		return agendaExistingAppointment;
	}
	
	public WebElement getcancelExistingAppointment() {
		return cancelExistingAppointment;
	}

	public WebElement getdayTodayButton() {
		return dayTodayButton;
	}

	public WebElement getdayBackButton() {
		return dayBackButton;
	}

	public WebElement getdayNextButton() {
		return dayNextButton;
	}

	public WebElement getmonthNextButton() {
		return monthNextButton;
	}

	public WebElement getmonthTodayButton() {
		return monthTodayButton;
	}

	public WebElement getmonthBackButton() {
		return monthBackButton;
	}
	
}
