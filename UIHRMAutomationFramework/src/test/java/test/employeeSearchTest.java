package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import constants.UIConstants;
import pages.PIMPage;
import pages.addEmployeePage;
import pages.dashboardPage;
import pages.loginPage;

public class employeeSearchTest extends BaseTest
{
	@Test(enabled=false)
	public void TC15_SearchEmployeeByName()
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,UIConstants.LOGIN_PAGE_TITLE);
		login.enterUsernameAndPassword("Admin","admin123");
		login.clickLoginButton();	
		dashboardPage dashboard = new dashboardPage(driver);
		Assert.assertEquals(dashboard.verifyDashBoard(), UIConstants.DASHBOARD_PAGE_TITLE);
		PIMPage pim = new PIMPage(driver);
		pim.PIMclick();
		Assert.assertEquals(pim.verifyPIM(), UIConstants.PIM_PAGE_TITLE);
		pim.clickAddEmplpyee();
		addEmployeePage addEmployee = new addEmployeePage(driver);
		Assert.assertEquals(addEmployee.addEmployeeText(),UIConstants.PIM_PAGE_ADD_EMPLOYEE_TEXT);
		addEmployee.enterFirstName("testcheck123");
		addEmployee.enterLastName("test");
		addEmployee.clickSaveButton();
		pim.PIMclick();
		pim.searchByEmployeeName("testcheck123");
		pim.clickSearch();	
		Assert.assertEquals(pim.checkEmployeeNameTable(),"testcheck123");
	}
	
	@Test(enabled=false)
	public void TC16_SearchEmployeeByID()
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,UIConstants.LOGIN_PAGE_TITLE);
		login.enterUsernameAndPassword("Admin","admin123");
		login.clickLoginButton();	
		PIMPage pim = new PIMPage(driver);
		pim.PIMclick();
		Assert.assertEquals(pim.verifyPIM(), UIConstants.PIM_PAGE_TITLE);
		pim.searchByEmployeeID("0425");
		pim.clickSearch();	
		Assert.assertEquals(pim.checkEmployeeIDTable(),"0425");		
	}
	
	@Test(enabled=false)
	public void TC17_SearchEmployeeByStatus()
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,UIConstants.LOGIN_PAGE_TITLE);
		login.enterUsernameAndPassword("Admin","admin123");
		login.clickLoginButton();	
		PIMPage pim = new PIMPage(driver);
		pim.PIMclick();
		Assert.assertEquals(pim.verifyPIM(), UIConstants.PIM_PAGE_TITLE);
		pim.searchByEmployeeStatus("Full-Time Contract");
		pim.clickSearch();	
		WebElement row = pim.checkEmployeeStatusTable("0042");
		String status = row.findElement(By.xpath(".//div//div[6]")).getText();
		Assert.assertEquals(status, "Full-Time Contract");		
	}
	//Search by Job Title
	//Search by Supervisor Name
	//Search by Multiple Filters
	//Search with Invalid Employee Name
	//Search with Invalid Employee ID
	//Search Without Any Filters
	//Reset Search Filters
}