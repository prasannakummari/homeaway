package com.homeaway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//This class maps to online store login page using my account link
public class AccountLoginPage extends BasePage {
	
	public AccountLoginPage(WebDriver driver){
		this.driver = driver;
	}
	public YourAccountPage loginToMyAccount(){		
	    returnWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#log")));
		driver.findElement(By.cssSelector("input#log")).sendKeys("Prasanna");
		driver.findElement(By.cssSelector("input#pwd")).sendKeys("Password09");
		driver.findElement(By.cssSelector("input#login")).submit();
		YourAccountPage yap = new YourAccountPage(driver);
		return yap;
	}
	
}
