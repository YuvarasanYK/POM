package org.execuation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.utility.BaseClass;

public class CrossBrowserTesting extends BaseClass{
	@Parameters("browserName")
	@Test
	public void sample3(String name) {
		loadDriver(name);
		url("https://opensource-demo.orangehrmlive.com/");
		WebElement username = driver.findElement(By.id("txtUsername"));
		username.sendKeys("Admin");
		WebElement pass = driver.findElement(By.id("txtPassword"));
		pass.sendKeys("admin123");
		WebElement login = driver.findElement(By.id("btnLogin"));
		login.click();
	}

}
