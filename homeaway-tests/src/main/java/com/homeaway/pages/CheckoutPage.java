package com.homeaway.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//This class maps to Checkout page
public class CheckoutPage extends BasePage{
	
			
	public CheckoutPage(WebDriver driver){
		this.driver = driver;
	}
	public boolean continueOrder(){
		driver.findElement(By.xpath("//span[contains(text(),'Continue')]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	 	
		Select Countrydd = new Select(driver.findElement(By.xpath("//*[@id='current_country']")));
 	    Countrydd.selectByVisibleText("Canada");
 	    driver.findElement(By.xpath("//input[contains(@value, 'Calculate')]")).click();
 		returnWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='checkout_total']/span[contains(text(),'$282.00')]")));
 	    boolean found = driver.findElement(By.xpath("//span[@id='checkout_total']/span[contains(text(),'$282.00')]")).isDisplayed();
		return found;
	}
	public boolean removeOrder(){
		driver.findElement(By.xpath("//input[@value = 'Remove']")).click();
		String x = driver.findElement(By.cssSelector(".entry-content")).getText();
		if (x.contains("Oops, there is nothing"));
		return true;
	}
}
