package com.test.qa.pages;

import org.openqa.selenium.By;

import com.test.qa.base.TestBase;

public class HomePage extends TestBase {
	
	public String homePage = "//*[@class='title']";

	public String validateHomePageTitle()
	{
		String homePageTitle = driver.findElement(By.xpath(homePage)).getText();
		return homePageTitle;
	}

}
