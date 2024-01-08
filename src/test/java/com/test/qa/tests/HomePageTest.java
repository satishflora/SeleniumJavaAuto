package com.test.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
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
	@BeforeMethod
	public void setUp()
	{
		initialization();
		homePage = new HomePage();
		loginPage = new LoginPage();
		loginPage.login("normal");
		
	}
	@Test
	public void HomePageTitleTest()
	{
		String homeTitle = homePage.validateHomePageTitle();
		Assert.assertEquals(homeTitle, "Products");
	}
	
	@AfterMethod
	public void TearDown()
	{
		//driver.quit();
	}
}
