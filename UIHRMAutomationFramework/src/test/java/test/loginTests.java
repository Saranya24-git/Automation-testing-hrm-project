package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.DriverFactory;
import pages.loginPage;


public class loginTests extends DriverFactory
{
	
	@Test(enabled=true)
	public void TC1VerifyUserCanLogInWithValidCredentials() 
	{		
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,"Login");
		login.enterUsernameAndPassword("Admin","admin123");
		login.clickLoginButton();
		
	}
	
}