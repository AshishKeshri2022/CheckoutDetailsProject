package com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class BasePage 
{
	
	public static WebDriver driver=null;
	public static Properties OR=new Properties();
	FileInputStream fis=null;
	public WebDriverWait wait=null;
	
	@Test(priority=1)
	public void setup(ITestContext name)
	{
		try {
			fis=new FileInputStream(System.getProperty("user.dir") + "\\src\\com\\or\\"+name.getName().trim()+".properties");
			OR.load(fis);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
				
		if(driver==null)
		{
			try
			{
				
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\com\\driver\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
				wait=new WebDriverWait(driver,30);
				driver.get("https://qa-practical-test.myshopify.com/");
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}	
	}
	
	public void type(String locator,String value)
	{
		if(locator.endsWith("_CSS"))
		{
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		}
		else if(locator.endsWith("_XPATH"))
		{
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		}
	}
	public void click(String locator)
	{
		if(locator.endsWith("_CSS"))
		{
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		}
		else if(locator.endsWith("_XPATH"))
		{
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		}
	}
	
	public String getText(String locator)
	{
		String value=null;
		if(locator.endsWith("_CSS"))
		{
			value= driver.findElement(By.cssSelector(OR.getProperty(locator))).getText();
		}
		else if(locator.endsWith("_XPATH"))
		{
			value= driver.findElement(By.xpath(OR.getProperty(locator))).getText();
		}
		return value;
	}
	
	@AfterSuite
	public void closeBrowser()
	{
		 driver.close();
	}
	


}
