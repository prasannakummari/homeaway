package com.homeaway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//This class maps to online store my account logout page
public class AccountLogoutPage extends BasePage {

	   public AccountLogoutPage(WebDriver driver){
		   this.driver = driver;
	   }
	   public HomePage backToOnlineStore(){
		   driver.findElement(By.xpath("//a[contains(text(),'Back to ONLINE STORE')]")).click();
		   HomePage hp = new HomePage(driver);
		   return hp;
	   }


}
