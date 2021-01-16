package com.project.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.project.qa.base.TestBase;

public class RegisterPage extends TestBase{

	@FindBy(xpath ="//img[contains(@src,'register')]")
	WebElement registerLogo;
	
	@FindBy(name="firstName")
	WebElement firstName;
	
	@FindBy(name="lastName")
	WebElement lastName;
	
	@FindBy(name="userName")
	WebElement userName;
	
	@FindBy(name="city")
	WebElement City;
	
	@FindBy(name ="country")
	WebElement country;
	
	@FindBy(name ="submit")
	WebElement submitbtn;
	
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyRegisterLogo() {
		
		return registerLogo.isDisplayed();
	}
	
	public String verifyRegisterPageTitle() {
		
		return driver.getTitle();
	}
	
	//method to select element by path for an element where xpath is dynamic 
	public void selectElement(String name) {
		driver.findElement(By.xpath("//table[@name='"+name+"']")).click();
	}
	
	
	public void createnewUser(String firstname, String lastname, String email, String city,String countryname) {
		
		
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		userName.sendKeys(email);
		City.sendKeys(city);
		Select sel = new Select(country);
		sel.selectByVisibleText(countryname);
		submitbtn.click();
	}

}
