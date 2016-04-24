package com.homeaway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//This page maps to Your Account page 
public class YourAccountPage extends BasePage {
    
	   public YourAccountPage(WebDriver driver){
		   this.driver = driver;
	   }
	   public void updateProfile(){
		   returnWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Your Details')]")));
		   driver.findElement(By.xpath("//a[contains(text(), 'Your Details')]")).click();
		   driver.findElement(By.xpath("//input[@id='wpsc_checkout_form_2']")).clear();
		   driver.findElement(By.xpath("//input[@id='wpsc_checkout_form_2']")).sendKeys("Prasanna");
		   Select countrydd = new Select(driver.findElement(By.xpath("//select[@id='wpsc_checkout_form_7']")));
		   countrydd.selectByVisibleText("USA");
		   driver.findElement(By.xpath("//input[@id='wpsc_checkout_form_17']")).clear();
		   driver.findElement(By.xpath("//input[@id='wpsc_checkout_form_17']")).sendKeys("78893");
		   driver.findElement(By.xpath("//input[@name = 'submit']")).submit();		   
	   }
	   public AccountLogoutPage logOut(){
		   driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
		   AccountLogoutPage lop = new AccountLogoutPage(driver);
		   return lop;
	   }
	   public boolean retrieveProfile(){
		   driver.findElement(By.xpath("//a[contains(text(), 'Your Details')]")).click();
		   returnWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Prasanna']")));
		   boolean a = driver.findElement(By.xpath("//input[@value='Prasanna']")).isDisplayed();
		   boolean b = driver.findElement(By.xpath("//option[@value = 'US']")).isSelected();
		   returnWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='78893']")));
		   boolean c = driver.findElement(By.xpath("//input[@value='78893']")).isDisplayed();
		   if (a && b && c == true)
		   return true;	
		   return false;
	   }
	  
}
