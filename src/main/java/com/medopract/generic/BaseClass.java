package com.medopract.generic;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass extends FileLib {
	public WebDriver driver;
	public  static Logger logger;
	public WebDriverWait webDriverWait;
	public FileLib f;
	
	public WebDriver initializeDriver() {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		driver=new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		f=new FileLib();
		logger= LogManager.getLogger(BaseClass.class);

		return driver;	
	}

	public void waitForElementVisibility(WebElement element, Duration sec, String pageElementName, WebDriver driver)
			throws Exception {
		webDriverWait = new WebDriverWait(driver, 10);
		webDriverWait.until(ExpectedConditions.visibilityOf(element));
		
	}
	public void waitForElementVisibility2(Object object, Duration sec, String pageElementName, WebDriver driver)
			throws Exception {
		webDriverWait = new WebDriverWait(driver, 10);
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated((By) object));
	}

	public void click(WebElement element, String pageElementName, WebDriver driver) throws Exception {
		waitForElementVisibility(element, Duration.ofSeconds(20), pageElementName, driver);
		element.click();
	
	}

}

