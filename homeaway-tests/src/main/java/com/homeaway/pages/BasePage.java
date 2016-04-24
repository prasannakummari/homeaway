package com.homeaway.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

public abstract class BasePage {
    protected WebDriver driver = null;	
	
	public FluentWait<WebDriver> returnWait(){
		FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver)
			    .withTimeout(30, TimeUnit.SECONDS)
			    .pollingEvery(5, TimeUnit.SECONDS)
			    .ignoring(NoSuchElementException.class); 
		return fWait;
	}

}
