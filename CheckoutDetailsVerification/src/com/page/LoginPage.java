package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.base.BasePage;

public class LoginPage extends BasePage
{

	@Test(priority = 1)
	public void Login() {
		try {
			type("passwordBox_CSS", "brauff");
			click("enterButton_XPATH");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(OR.getProperty("catalog_XPATH"))));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
