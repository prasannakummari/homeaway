package com.homeaway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
//This class maps to iPhones page
public class IphonesPage extends BasePage {

	public IphonesPage(WebDriver driver){
		this.driver = driver;
	}
	public CheckoutPage AddToCart(){
		driver.findElement(By.xpath("//div[contains(@class,'view_96')]/descendant::input[contains(@value, 'Add To Cart')]")).click();
		returnWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Checkout')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
 	   	CheckoutPage cp = new CheckoutPage(driver);
		return cp;
	}
	
}
