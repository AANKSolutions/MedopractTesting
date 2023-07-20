package com.medopract.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportsPage {	

	public ReportsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[text()='Reports'])[1]")
	WebElement ClickReports;

	@FindBy(xpath = "//button[@class='reports_button__UT7hg']")
	WebElement ClickAddPatient;

	@FindBy(xpath = "//button[@class='reports_cancel__2pOmr']")
	WebElement patientsTab;

	@FindBy(xpath = "//button[text()='Yearly']")
	WebElement yearlyTab;

	@FindBy(xpath = "(//button[@class='reports_topbtns__3csCF'])[1]")
	WebElement monthlyTab;

	@FindBy(xpath = "(//button[@class='reports_topbtns__3csCF'])[2]")
	WebElement weeklyTab;

	@FindBy(xpath = "(//button[@class='reports_topbtns__3csCF'])[3]")
	WebElement dailyTab;

	@FindBy(xpath="//a[@title='Cancel']")
	WebElement cancelButton;
	
	@FindBy(xpath = "//div[@class='col-md-2']")
	WebElement todayDateView;



	public WebElement getClickReports() {
		return ClickReports;
	}
	
	public WebElement gettodayDateView() {
		return todayDateView;
	}

	public WebElement getClickAddPatient() {
		return ClickAddPatient;
	}

	public WebElement getPatientsTab() {
		return patientsTab;
	}

	public WebElement getYearlyTab() {
		return yearlyTab;
	}

	public WebElement getMonthlyTab() {
		return monthlyTab;
	}

	public WebElement getWeeklyTab() {
		return weeklyTab;
	}

	public WebElement getDailyTab() {
		return dailyTab;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

}


