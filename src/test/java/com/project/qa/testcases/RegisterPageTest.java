package com.project.qa.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.project.qa.base.TestBase;
import com.project.qa.pages.HomePage;
import com.project.qa.pages.LoginPage;
import com.project.qa.pages.RegisterPage;
import com.project.qa.util.TestUtil;

public class RegisterPageTest extends TestBase{
	
	RegisterPage registerPage;
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    
    String sheetname = "Sheet1";
    
    public RegisterPageTest() {
    	super();
    }
	
    @BeforeMethod
	public void setup(){
		
		initialization();
		
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		registerPage = homePage.clickRegister();
		
	}

    @Test(priority=2)
    public void verifyRegisterPageTitleTest() {
    	
    	String title = registerPage.verifyRegisterPageTitle();
    	Assert.assertEquals(title, "Register: Mercury Tours");
    }
    
    @Test(priority=3)
    public void verifyRegisterPageLogoTest() {
    	
    	Assert.assertTrue(registerPage.verifyRegisterLogo());
    }
    
    @DataProvider
	public Object[][] getUserTestData() {
    	Object data[][] = TestUtil.getTestData(sheetname);
    	return data;
		
	}
	
    
    @Test(priority=1,dataProvider = "getUserTestData")
    public void createnewUserTest(String firstname, String lastname, String email, String city,String countryname) {
    	
    	registerPage.createnewUser(firstname,lastname,email,city,countryname);
    }
    
    
    
    @AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
