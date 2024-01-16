package com.test.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.qa.base.TestBase;

public class HomePage extends TestBase {
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String homePage = "//*[@class='title']";
	public String product = "//div[@class='inventory_item']";
	public String price = "//*[text() = 'Sauce Labs Backpack']//parent::a//parent::div//following-sibling::div//child::div";

	public String validateHomePageTitle()
	{
		String homePageTitle = driver.findElement(By.xpath(homePage)).getText();
		return homePageTitle;
	}
    
	public int numberOfProducts()
	{
		List<WebElement> lo =  driver.findElements(By.xpath(product));
		int productsCount = lo.size();
		return productsCount;	
	}
	
	public void priceOfItem()
	{
		String priceOfItem = driver.findElement(By.xpath(price)).getText();
		System.out.println(priceOfItem);
	}
	
}
