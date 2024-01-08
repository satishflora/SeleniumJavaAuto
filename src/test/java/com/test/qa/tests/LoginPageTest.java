package com.test.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.qa.base.TestBase;
import com.test.qa.pages.LoginPage;


public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		
	}
	@Test
	public void loginPageTitleTest()
	{
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Swag Labs");
	}
	@Test
	public void checkUserLoggedInSuccessfully()
	{
		loginPage.login("normal");
		String homeTitle = loginPage.logInSuccessful();
		Assert.assertEquals(homeTitle, "Products");
	}
    @AfterMethod
    public void tearDown()
    {
    	driver.quit();
    }
    
    
    
    
}
