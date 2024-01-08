package com.test.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public String usernameField;
	public String passwordField;
	public String submitbutton;
	
	
	public TestBase()
	{
		 getProperties();
	}
	
	public void getProperties()
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("D:\\My-Workspace\\demoproject\\src\\main\\java\\com\\test\\qa\\config\\config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e)
		{
		  e.printStackTrace();	
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void initialization()
	{
		String browsername = prop.getProperty("browser");
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		
	}
	
	public static WebElement textField(String fieldPath)
	{
		WebElement usernameEl = driver.findElement(By.xpath(fieldPath));	
		return usernameEl;
	}
	
	public static void enterData(String fieldPath, String Data)
	{
		WebElement usernameEl = driver.findElement(By.xpath(fieldPath));	
		usernameEl.sendKeys(Data);
	}
	
	public static void clickOnElement(String button)
	{
		driver.findElement(By.xpath(button)).click();
	}
	
}
