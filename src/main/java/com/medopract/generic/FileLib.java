package com.medopract.generic;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class FileLib {
	//WebDriver driver;
	Properties p;

	public  FileLib() {
		File src = new File("./data/medopract.property");
		try{
			FileInputStream fis=new FileInputStream(src);
			p=new Properties();
			p.load(fis);
		}
		catch(Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
	public String getApplicationURL() {
		String url = p.getProperty("BaseURL");
		return url;
	}
	public String getUsername() {
		String un = p.getProperty("Username");
	    return un;	
	}
	public String getPassword() {
		String pw = p.getProperty("Password");
		return pw;
	}
}