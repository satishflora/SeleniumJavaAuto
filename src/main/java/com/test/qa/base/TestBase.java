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
import org.openqa.selenium.edge.EdgeDriver;

public class TestBase {
	public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	//public static WebDriver driver;
	public static Properties prop;
	public String usernameField;
	public String passwordField;
	public String submitbutton;
	
	public void setDriver(WebDriver driver)
	{
		this.driver.set(driver);
	}
	
	public WebDriver getDriver()
	{
		return this.driver.get();
	}
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
	
	public void initialization(String browser)
	{
		String browsername = browser;
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
			setDriver(new ChromeDriver());
		}
		else if(browsername.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver","D:\\msedgedriver.exe");
			setDriver(new EdgeDriver());
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().get(prop.getProperty("url"));
		
	}
	
	public static WebElement textField(WebDriver driver, String fieldPath)
	{
		WebElement usernameEl = driver.findElement(By.xpath(fieldPath));	
		return usernameEl;
	}
	
	public static void enterData(WebDriver driver, String fieldPath, String Data)
	{
		WebElement usernameEl = driver.findElement(By.xpath(fieldPath));	
		usernameEl.sendKeys(Data);
	}
	
	public static void clickOnElement(WebDriver driver, String button)
	{
		driver.findElement(By.xpath(button)).click();
	}
	
}
