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



	public void getClickReports() {
		 ClickReports.click();
	}
	
	public WebElement gettodayDateView() {
		return todayDateView;
	}

	public void getClickAddPatient() {
		 ClickAddPatient.click();
	}

	public void getPatientsTab() {
		 patientsTab.click();
	}

	public void getYearlyTab() {
		 yearlyTab.click();
	}

	public void getMonthlyTab() {
		 monthlyTab.click();
	}

	public void getWeeklyTab() {
		 weeklyTab.click();
	}

	public void getDailyTab() {
		 dailyTab.click();
	}

	public void getCancelButton() {
		 cancelButton.click();
	}

}


