package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import annotations.TestDataSheet;
import pages.dashboardPage;
import pages.loginPage;
import base.BaseTest;
import constants.UIConstants;
import dataProviders.TestDataProvider;
import datamodels.LoginData;
import datamodels.LogoutData;
@TestDataSheet(sheetName = "Logout",  model=LogoutData.class)

public class logoutTests extends BaseTest
{
	@Test(enabled=true,dataProvider = "TestData", dataProviderClass = TestDataProvider.class)
	public void TC07_Logout(String username, String password)
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,UIConstants.LOGIN_PAGE_TITLE);
		login.enterUsernameAndPassword(username,password);
		login.clickLoginButton();	
		dashboardPage dashboard = new dashboardPage(driver);
		Assert.assertEquals(dashboard.verifyDashBoard(), UIConstants.DASHBOARD_PAGE_TITLE);
		dashboard.clickProfileDropdown();
		dashboard.clickLogoutButton();
		Assert.assertEquals(loginPageCheck,UIConstants.LOGIN_PAGE_TITLE);		
	}
}