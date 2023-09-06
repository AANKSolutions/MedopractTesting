package com.medopract.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass  {
	public static WebDriver driver;
	public static Logger logger;
	public static WebDriverWait wait;
	public static BaseClass base;



	public WebDriver initializeDriver() {
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger = LogManager.getLogger(BaseClass.class);
         base=new BaseClass();
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return driver;
	}

	public String getPropertyData(String key) throws IOException {

		FileInputStream fisconfig=new FileInputStream("./data/medopract.property");
		Properties p=new Properties();
		p.load(fisconfig);
		String data = p.getProperty(key);
		return data;
	}

	public String getExcelData(String sheetName,int rowNum,int cell) throws EncryptedDocumentException,IOException {

		FileInputStream fisexcel=new FileInputStream("./data/medopract.xlsx");
		Workbook wb = WorkbookFactory.create(fisexcel);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cell).getStringCellValue();
		return data;
	}


	public void waitForElementVisibility(WebElement element, Duration sec, String pageElementName, WebDriver driver)
			throws Exception {
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public void waitForElementToBeClickable(WebElement element, Duration sec, String pageElementName, WebDriver driver) throws Exception {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

	public void click(WebElement element, String pageElementName, WebDriver driver) throws Exception {
		waitForElementToBeClickable(element, Duration.ofSeconds(20), pageElementName, driver);
		element.click();

	}

}
