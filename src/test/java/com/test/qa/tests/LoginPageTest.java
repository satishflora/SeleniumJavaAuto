package com.test.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.qa.base.TestBase;
import com.test.qa.pages.LoginPage;




public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeTest
	public void setUp()
	{
		initialization("chrome");
		loginPage = new LoginPage(getDriver());
		
	}
	@Test(priority =1)
	public void loginPageTitleTest()
	{
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Swag Labs");
	}
	@Test(priority =2)
	public void checkUserLoggedInSuccessfully()
	{
		loginPage.login("normal");
		String homeTitle = loginPage.logInSuccessful();
		Assert.assertEquals(homeTitle, "Products");
	}
    @AfterTest
    public void tearDown()
    {
    	getDriver().quit();
    }
        
    
}


