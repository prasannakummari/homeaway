package com.homeaway.tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.homeaway.pages.AccountLoginPage;
import com.homeaway.pages.AccountLogoutPage;
import com.homeaway.pages.HomePage;
import com.homeaway.pages.YourAccountPage;

public class YourAccountPageTest extends BaseTest {

	//Verify updating your account details is saved
	@Test
	public void updateProfileTest() {
		HomePage hpTest = new HomePage(driver);
		AccountLoginPage lipTest = hpTest.homeToMyAccount();
		YourAccountPage yapTest = lipTest.loginToMyAccount();
		yapTest.updateProfile();
		boolean actual = yapTest.retrieveProfile();
		Assert.assertTrue(actual == true);
	}

	//Verify your account details are retrieved after logging out and back in using the My Account link.
	@Test
	public void retrieveProfileTest() {
		HomePage hpTest = new HomePage(driver);
		AccountLoginPage lipTest = hpTest.homeToMyAccount();
		YourAccountPage yapTest = lipTest.loginToMyAccount();
		yapTest.updateProfile();
		AccountLogoutPage lopTest = yapTest.logOut();
		HomePage hpTest1 = lopTest.backToOnlineStore();
		AccountLoginPage lipTest1 = hpTest1.homeToMyAccount();
		YourAccountPage yapTest1 = lipTest1.loginToMyAccount();
		boolean actual = yapTest1.retrieveProfile();
		Assert.assertTrue(actual == true);
	}

}
