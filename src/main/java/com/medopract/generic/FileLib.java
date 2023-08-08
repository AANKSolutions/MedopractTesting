package com.medopract.generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	Properties p;
	public String getPropertyData(String key) throws IOException {
		
		FileInputStream fisconfig=new FileInputStream("./data/medopract.property");
		p=new Properties();
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

}
