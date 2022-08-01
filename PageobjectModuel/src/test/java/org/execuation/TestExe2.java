package org.execuation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.utility.BaseClass;

public class TestExe2 extends BaseClass {

	@DataProvider(name="loginData")
	public String[][] excelData() throws IOException {
		File file = new File("C:\\Users\\Yuvaraj\\OneDrive\\Desktop\\Testcase Sample.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet("Sheet2");
		int noofRow = sheet.getPhysicalNumberOfRows();
		int noofcolum=sheet.getRow(0).getLastCellNum();
		String [][] data = new String[noofRow-1][noofcolum];
		
		for (int i = 0; i <noofRow-1; i++) {
			for (int j = 0; j <noofcolum; j++) {
				DataFormatter df =new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i+1).getCell(j));
			}
		}
		
		return data;
	}

	/*@DataProvider(name="loginData")
	public String[][] loginDataProvider() {
		String[][] data = { { "Admin", "admin123" },
				{ "Admin", "admin12" }, 
				{ "Admi", "admin123" },
				{ "Admi", "admin12" } };
		return data;
	}*/
	
	@Test(dataProvider="loginData")
	public void sample3(String userName,String passWord) {
		//loadDriver();
		url("https://opensource-demo.orangehrmlive.com/");
		WebElement username = driver.findElement(By.id("txtUsername"));
		username.sendKeys(userName);
		WebElement pass = driver.findElement(By.id("txtPassword"));
		pass.sendKeys(passWord);
		WebElement login = driver.findElement(By.id("btnLogin"));
		login.click();
	}

}
