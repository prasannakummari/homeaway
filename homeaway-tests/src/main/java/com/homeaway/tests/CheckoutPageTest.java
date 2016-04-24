package com.homeaway.tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.homeaway.pages.CheckoutPage;
import com.homeaway.pages.HomePage;
import com.homeaway.pages.IphonesPage;

public class CheckoutPageTest extends BaseTest {

	//Verify the total price of Apple iPhone 4S 16GB SIM-Free – Black is $282.00(includes the shipping price)
	@Test
	public void TotalPriceCheckTest() {
		HomePage hp = new HomePage(driver);
		IphonesPage ipptest = hp.productCategoryToIphones();
		CheckoutPage cptest = ipptest.AddToCart();
		boolean actual = cptest.continueOrder();
		Assert.assertTrue(actual == true);
	}

	//Verify removing all items from your cart produces an empty cart message.
	@Test
	public void removeOrderTest() {
		HomePage hp = new HomePage(driver);
		IphonesPage ipptest = hp.productCategoryToIphones();
		CheckoutPage cptest = ipptest.AddToCart();
		boolean actual = cptest.removeOrder();
		Assert.assertTrue(actual == true);
	}

}
