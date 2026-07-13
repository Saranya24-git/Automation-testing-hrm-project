package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.DriverFactory;
import pages.loginPage;


public class loginTests extends DriverFactory
{
	
	@Test(enabled=false)
	public void TC1_VerifyUserCanLogInWithValidCredentials() 
	{		
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,"Login");
		login.enterUsernameAndPassword("Admin","admin123");
		login.clickLoginButton();	
		Assert.assertEquals(login.verifyDashBoard(), "Dashboard");
	}
	
	@Test(enabled=false)
	public void TC2_VerifyLoginWithInvalidUsername()
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,"Login");
		login.enterUsernameAndPassword("asjdf","admin123");
		login.clickLoginButton();	
		Assert.assertEquals(login.verifyInvalidCredentials(), "Invalid credentials");
	}
	
	@Test(enabled=false)
	public void TC3_VerifyLoginWithInvalidPassword()
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,"Login");
		login.enterUsernameAndPassword("Admin","asdflkj");
		login.clickLoginButton();	
		Assert.assertEquals(login.verifyInvalidCredentials(), "Invalid credentials");
	}
	
	@Test(enabled=false)
	public void TC4_VerifyLoginWithInvalidUsernameandInvalidPassword()
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,"Login");
		login.enterUsernameAndPassword("asdf","asdflkj");
		login.clickLoginButton();	
		Assert.assertEquals(login.verifyInvalidCredentials(), "Invalid credentials");
	}
	
	@Test
	public void TC5_VerifyLoginWithBlankUsername()
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,"Login");
		login.enterUsernameAndPassword("","admin123");
		login.clickLoginButton();	
		Assert.assertEquals(login.verifyRequiredCredentials(), "Required");
	}
}