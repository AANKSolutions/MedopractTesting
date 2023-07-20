package com.medopract.generic;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseClass{
	public WebDriver driver;
	public Logger logger;
	
	
	public WebDriver OpenBrowser() {
		
	 driver=new ChromeDriver();
     driver.manage().window().maximize();
	
		logger=Logger.getLogger("Medopract");
	    PropertyConfigurator.configure("Log4j.properties");		
			return driver;	
	}

	
}