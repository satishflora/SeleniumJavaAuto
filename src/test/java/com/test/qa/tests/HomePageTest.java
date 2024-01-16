package com.test.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.qa.base.TestBase;
import com.test.qa.pages.LoginPage;
import com.test.qa.pages.HomePage;

public class HomePageTest extends TestBase  {
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest()
	{
		super();
	}
	@BeforeTest
	public void setUp()
	{
		initialization("chrome");
		homePage = new HomePage(getDriver());
		loginPage = new LoginPage(getDriver());
		loginPage.login("normal");
		
	}
	@Test(priority = 1)
	public void ValidateHomePageTitleTest()
	{
		String homeTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homeTitle, "Products");
	}
	@Test (priority = 2)
	public void ValidateNumberOfProductsOnThePage()
	{
		int count = homePage.numberOfProducts();
		Assert.assertEquals(count, 6, "Count of products are not correct");   
	}
	
	@Test (priority = 3)
	public void ValidateItemPrice()
	{
		homePage.priceOfItem();  
	}
	
	@AfterTest
	public void TearDown()
	{
		getDriver().quit();
	}
}
