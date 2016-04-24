package com.homeaway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
//This page maps to Home Page
public class HomePage extends BasePage {

		public HomePage(WebDriver driver){
		this.driver = driver;
	}
	public IphonesPage productCategoryToIphones(){
		Actions products = new Actions(driver);
		products.moveToElement(driver.findElement(By.cssSelector("#menu-item-33>a"))).perform();
		returnWait().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#menu-item-37>a")));
		driver.findElement(By.cssSelector("#menu-item-37>a")).click();
		IphonesPage ipp = new IphonesPage(driver);		
		return ipp;		    
	}
	public AccountLoginPage homeToMyAccount(){
		driver.findElement(By.xpath("//a[@class = 'account_icon']")).click();
		AccountLoginPage lp = new AccountLoginPage(driver);
		return lp;
	}
		
}
