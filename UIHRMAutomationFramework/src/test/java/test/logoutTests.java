package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.dashboardPage;
import pages.loginPage;
import base.DriverFactory;

public class logoutTests extends DriverFactory
{
	@Test(enabled=true)
	public void TC07_Logout()
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,"Login");
		login.enterUsernameAndPassword("Admin","admin123");
		login.clickLoginButton();	
		dashboardPage dashboard = new dashboardPage(driver);
		Assert.assertEquals(dashboard.verifyDashBoard(), "Dashboard");
		dashboard.clickProfileDropdown();
		dashboard.clickLogoutButton();
		Assert.assertEquals(loginPageCheck,"Login");		
	}
}