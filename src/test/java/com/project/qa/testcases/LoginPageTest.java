package com.project.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.project.qa.base.TestBase;
import com.project.qa.pages.HomePage;
import com.project.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup(){
		
		initialization();
		
		loginPage = new LoginPage();
	}
	
	
	@Test(priority=1)
	public void LoginPageTitleTest() {
		
		String title = loginPage.validateLoginPageTitle();//we accesses non-static method using Class Object
		Assert.assertEquals(title, "Sign-on: Mercury Tours");
	}
	
	@Test(priority=2)
	public void logoTest() {
		boolean flag = loginPage.validateLogo();
		
	Assert.assertTrue(flag);
	}
	
	
	@Test(priority=3)
	public void LoginTest() {
		
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	@Test
	public void test() {
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
