package com.project.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR
	@FindBy(name="userName")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="submit")
	WebElement loginbtn;
	
	@FindBy(linkText = "Home")
	WebElement homebtn;
	
	@FindBy(xpath="//img[contains(@alt,'Guru99')]")
	WebElement logo;
	
	//Initialize Page Objects/WebElements
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions-Features
	
public String validateLoginPageTitle() {
	return driver.getTitle();
}

public boolean validateLogo() {
	
	return logo.isDisplayed();
}
	
public HomePage login(String un,String pwd) {
	
	username.sendKeys(un);
	password.sendKeys(pwd);
	loginbtn.click();
	
	return new HomePage();
}

}
