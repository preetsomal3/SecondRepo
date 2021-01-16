package com.project.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.project.qa.base.TestBase;
import com.project.qa.pages.ContactPage;
import com.project.qa.pages.HomePage;
import com.project.qa.pages.LoginPage;
import com.project.qa.pages.RegisterPage;
import com.project.qa.util.TestUtil;


//Test cases should be separated - independent with each other
//before each test case -- launch the browser and login
//@test -- execute test case
//after each test case -- close the browser



public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	
	TestUtil testUtil;
	ContactPage contactPage;
	RegisterPage registerPage;
	
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup(){
		
		initialization();
		
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1,enabled = true)
	public void verifyHomePageTitleTest() {
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, ": Mercury Tours","Home Page title not matched");

	}
	
	@Test(priority=2,enabled = true)
	public void verifyloginsuccessTest() {
		Assert.assertTrue(homePage.verifyLoginSuccess());
	}
	
	@Test(priority=3)
	public void clickContactLinkTest() {
		
		contactPage = homePage.clickContact();
	}
	
	@Test(priority=4,enabled = true)
	public void clickRegisterLinkTest() {
		
		registerPage = homePage.clickRegister();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
