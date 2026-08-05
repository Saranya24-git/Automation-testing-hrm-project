package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import annotations.TestDataSheet;
import constants.UIConstants;
import dataProviders.TestDataProvider;
import datamodels.LoginData;
import pages.dashboardPage;
import pages.loginPage;
import base.BaseTest;

@TestDataSheet(sheetName = "Login",  model=LoginData.class)

public class loginTests extends BaseTest
{
		
	@Test(enabled=false,dataProvider = "TestData", dataProviderClass = TestDataProvider.class)
	public void TC01_VerifyUserCanLogInWithValidCredentials(LoginData data) 
	{		
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,UIConstants.LOGIN_PAGE_TITLE,UIConstants.LOGIN_PAGE_ERROR);
		login.enterUsernameAndPassword(data.getUsername(),data.getPassword());
		login.clickLoginButton();	
		dashboardPage dashboard = new dashboardPage(driver);
		Assert.assertEquals(dashboard.verifyDashBoard(), UIConstants.DASHBOARD_PAGE_TITLE, UIConstants.DASHBOARD_PAGE_ERROR);
	}
	
	@Test(enabled=true, dataProvider = "TestData",dataProviderClass = TestDataProvider.class)
	public void TC02_VerifyLoginWithInvalidUsername(LoginData data)
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,UIConstants.LOGIN_PAGE_TITLE);
		login.enterUsernameAndPassword(data.getUsername(),data.getPassword());
		login.clickLoginButton();	
		Assert.assertEquals(login.verifyInvalidCredentials(), UIConstants.LOGIN_PAGE_INVALID_CREDENTIALS);
	}
	
	@Test(enabled=true, dataProvider = "TestData",dataProviderClass = TestDataProvider.class)
	public void TC03_VerifyLoginWithInvalidPassword(LoginData data)
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,UIConstants.LOGIN_PAGE_TITLE);
		login.enterUsernameAndPassword(data.getUsername(),data.getPassword());
		login.clickLoginButton();	
		Assert.assertEquals(login.verifyInvalidCredentials(), UIConstants.LOGIN_PAGE_INVALID_CREDENTIALS);
	}
	
	@Test(enabled=true, dataProvider = "TestData",dataProviderClass = TestDataProvider.class)
	public void TC04_VerifyLoginWithInvalidUsernameandInvalidPassword(LoginData data)
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,UIConstants.LOGIN_PAGE_TITLE);
		login.enterUsernameAndPassword(data.getUsername(),data.getPassword());
		login.clickLoginButton();	
		Assert.assertEquals(login.verifyInvalidCredentials(), UIConstants.LOGIN_PAGE_INVALID_CREDENTIALS);
	}
	
	@Test(enabled=true, dataProvider = "TestData",dataProviderClass = TestDataProvider.class)
	public void TC05_VerifyLoginWithBlankUsername(LoginData data)
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,UIConstants.LOGIN_PAGE_TITLE);
		login.enterUsernameAndPassword(data.getUsername(),data.getPassword());
		login.clickLoginButton();	
		Assert.assertEquals(login.verifyRequiredCredentials(), UIConstants.REQUIRED_TEXT);
	}
	
	@Test(enabled=true, dataProvider = "TestData",dataProviderClass = TestDataProvider.class)
	public void TC06_VerifyLoginWithBlankPassword(LoginData data)
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,UIConstants.LOGIN_PAGE_TITLE);
		login.enterUsernameAndPassword(data.getUsername(),data.getPassword());
		login.clickLoginButton();	
		Assert.assertEquals(login.verifyRequiredCredentials(), UIConstants.REQUIRED_TEXT);
	}
}