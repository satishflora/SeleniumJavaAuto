package com.test.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.qa.base.TestBase;

public class LoginPage extends TestBase {
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
		
public String userType_admin = "admin";	
public String userType_normal = "normal";
public String usernamePath = "//input[@id='user-name']";
public String passwordPath = "//input[@id='password']";
public String buttonPath = "//input[@id='login-button']";
public String homePage = "//*[@class='title']";

public String validateLoginPageTitle()
{
	return driver.getTitle();
}

public String logInSuccessful()
{
	//loginToApp(usernamePath, passwordPath, buttonPath, userType_admin );	
	String homePageTitle = driver.findElement(By.xpath(homePage)).getText();
	return homePageTitle;
}

public void login(String userType)
{   
	String user = userType;
	if(user == "admin")
	{
		enterData(driver, this.usernamePath, prop.getProperty("admin_user"));
		enterData(driver, this.passwordPath, prop.getProperty("admin_pass"));
		clickOnElement(driver, this.buttonPath);
	}
	else if(user == "normal")
	{
		enterData(driver, this.usernamePath, prop.getProperty("normal_user"));
		enterData(driver, this.passwordPath, prop.getProperty("normal_pass"));
		clickOnElement(driver, this.buttonPath);	
	}
	else {
		System.out.println("User type is undefined");
		System.exit(0);
	}
}

}
