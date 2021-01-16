package com.project.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath= "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3")
	WebElement loginSuccessLabel;
	
	@FindBy(linkText = "REGISTER")
	WebElement registerLink;
	
	@FindBy(linkText = "CONTACT")
	WebElement contactLink;
	
	
	@FindBy(linkText = "SUPPORT")
	WebElement supportLink;

	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public RegisterPage clickRegister() {
		
		registerLink.click();
		return new RegisterPage();
	}
	
public ContactPage clickContact() {
		
		contactLink.click();
		return new ContactPage();
	}

public boolean verifyLoginSuccess() {
	
	System.out.println(loginSuccessLabel.getText());
	return loginSuccessLabel.isDisplayed();
}
	
	
}
