package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import annotations.TestDataSheet;
import base.BaseTest;
import constants.UIConstants;
import dataProviders.TestDataProvider;
import datamodels.UpdateEmployeeData;
import pages.PIMPage;
import pages.dashboardPage;
import pages.jobDetailsPage;
import pages.loginPage;
import pages.personalDetailsPage;

@TestDataSheet(sheetName = "UpdateEmployee",  model=UpdateEmployeeData.class)

public class updateEmployeeTest extends BaseTest
{
	@Test(enabled=false, dataProvider = "TestData", dataProviderClass = TestDataProvider.class)
	public void TC25_UpdateFirstName(UpdateEmployeeData data)
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,UIConstants.LOGIN_PAGE_TITLE);
		login.enterUsernameAndPassword(data.getUsername(),data.getPassword());
		login.clickLoginButton();	
		dashboardPage dashboard = new dashboardPage(driver);
		Assert.assertEquals(dashboard.verifyDashBoard(), UIConstants.DASHBOARD_PAGE_TITLE);
		PIMPage pim = new PIMPage(driver);
		pim.PIMclick();
		Assert.assertEquals(pim.verifyPIM(), UIConstants.PIM_PAGE_TITLE);
		pim.searchByEmployeeID(data.getEmpID());
		pim.clickSearch();	
		pim.editSearchedEmployeeProfile(data.getEmpID());	
		personalDetailsPage pdpage = new personalDetailsPage(driver);
		pdpage.updateFirstName(data.getFirstName());
		pdpage.clickSave();
		pim.PIMclick();
		Assert.assertEquals(pim.verifyPIM(), UIConstants.PIM_PAGE_TITLE);
		pim.searchByEmployeeID(data.getEmpID());
		pim.clickSearch();
		List<WebElement> rows = pim.checkEmployeeTableData();
		for(WebElement row : rows)
		{
			String employeeId = row.findElement(By.xpath(".//div[@role='cell'][2]"))
                    .getText()
                    .trim();

			String employeeFirstName = row.findElement(By.xpath(".//div[@role='cell'][3]"))
                      .getText()
                      .trim();
			Assert.assertEquals(employeeId, data.getEmpID());
			Assert.assertTrue(employeeFirstName.contains(data.getFirstName()));			
		}		
	}
	
	@Test(enabled=false, dataProvider = "TestData", dataProviderClass = TestDataProvider.class)
	public void TC26_UpdateLastName(UpdateEmployeeData data)
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,UIConstants.LOGIN_PAGE_TITLE);
		login.enterUsernameAndPassword(data.getUsername(),data.getPassword());
		login.clickLoginButton();	
		dashboardPage dashboard = new dashboardPage(driver);
		Assert.assertEquals(dashboard.verifyDashBoard(), UIConstants.DASHBOARD_PAGE_TITLE);
		PIMPage pim = new PIMPage(driver);
		pim.PIMclick();
		Assert.assertEquals(pim.verifyPIM(), UIConstants.PIM_PAGE_TITLE);
		pim.searchByEmployeeID(data.getEmpID());
		pim.clickSearch();	
		pim.editSearchedEmployeeProfile(data.getEmpID());	
		personalDetailsPage pdpage = new personalDetailsPage(driver);
		pdpage.updateLastName(data.getLastName());
		pdpage.clickSave();
		pim.PIMclick();
		Assert.assertEquals(pim.verifyPIM(), UIConstants.PIM_PAGE_TITLE);
		pim.searchByEmployeeID(data.getEmpID());
		pim.clickSearch();
		List<WebElement> rows = pim.checkEmployeeTableData();
		for(WebElement row : rows)
		{
			String employeeId = row.findElement(By.xpath(".//div[@role='cell'][2]"))
                    .getText()
                    .trim();

			String employeeLastName = row.findElement(By.xpath(".//div[@role='cell'][4]"))
                      .getText()
                      .trim();
			Assert.assertEquals(employeeId, data.getEmpID());
			Assert.assertTrue(employeeLastName.contains(data.getLastName()));			
		}		
	}
	
	@Test(enabled=false, dataProvider = "TestData", dataProviderClass = TestDataProvider.class)
	public void TC27_UpdateEmployeeId(UpdateEmployeeData data)
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,UIConstants.LOGIN_PAGE_TITLE);
		login.enterUsernameAndPassword(data.getUsername(),data.getPassword());
		login.clickLoginButton();	
		dashboardPage dashboard = new dashboardPage(driver);
		Assert.assertEquals(dashboard.verifyDashBoard(), UIConstants.DASHBOARD_PAGE_TITLE);
		PIMPage pim = new PIMPage(driver);
		pim.PIMclick();
		Assert.assertEquals(pim.verifyPIM(), UIConstants.PIM_PAGE_TITLE);
		pim.searchByEmployeeID(data.getEmpID());
		pim.clickSearch();	
		pim.editSearchedEmployeeProfile(data.getEmpID());	
		personalDetailsPage pdpage = new personalDetailsPage(driver);
		pdpage.updateEmployeeId(data.getUpdateEmpId());
		pdpage.clickSave();
		pim.PIMclick();
		Assert.assertEquals(pim.verifyPIM(), UIConstants.PIM_PAGE_TITLE);
		pim.searchByEmployeeID(data.getUpdateEmpId());
		pim.clickSearch();
		List<WebElement> rows = pim.checkEmployeeTableData();
		for(WebElement row : rows)
		{
			String employeeId = row.findElement(By.xpath(".//div[@role='cell'][2]"))
                    .getText()
                    .trim();
			Assert.assertEquals(employeeId, data.getUpdateEmpId());		
		}		
	}
	
	@Test(enabled=false, dataProvider = "TestData", dataProviderClass = TestDataProvider.class)
	public void TC28_UpdateMultipleFields(UpdateEmployeeData data)
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,UIConstants.LOGIN_PAGE_TITLE);
		login.enterUsernameAndPassword(data.getUsername(),data.getPassword());
		login.clickLoginButton();	
		dashboardPage dashboard = new dashboardPage(driver);
		Assert.assertEquals(dashboard.verifyDashBoard(), UIConstants.DASHBOARD_PAGE_TITLE);
		PIMPage pim = new PIMPage(driver);
		pim.PIMclick();
		Assert.assertEquals(pim.verifyPIM(), UIConstants.PIM_PAGE_TITLE);
		pim.searchByEmployeeID(data.getEmpID());
		pim.clickSearch();	
		pim.editSearchedEmployeeProfile(data.getEmpID());	
		personalDetailsPage pdpage = new personalDetailsPage(driver);
		pdpage.updateFirstName(data.getFirstName());
		pdpage.updateLastName(data.getLastName());
		pdpage.clickSave();
		jobDetailsPage jdpage = new jobDetailsPage(driver);
		jdpage.clickJobTab();
		jdpage.updateJob(data.getJob());
		jdpage.clickSave();
		pim.PIMclick();
		Assert.assertEquals(pim.verifyPIM(), UIConstants.PIM_PAGE_TITLE);
		pim.searchByEmployeeID(data.getEmpID());
		pim.clickSearch();
		List<WebElement> rows = pim.checkEmployeeTableData();
		for(WebElement row : rows)
		{
			String employeeId = row.findElement(By.xpath(".//div[@role='cell'][2]"))
                    .getText()
                    .trim();
			String employeeFirstName = row.findElement(By.xpath(".//div[@role='cell'][3]"))
                    .getText()
                    .trim();
			String employeeLastName = row.findElement(By.xpath(".//div[@role='cell'][4]"))
                    .getText()
                    .trim();
			String empJob = row.findElement(By.xpath(".//div[@role='cell'][5]")).getText().trim();
			Assert.assertEquals(employeeId, data.getEmpID());
			Assert.assertTrue(employeeFirstName.contains(data.getFirstName()));
			Assert.assertTrue(employeeLastName.contains(data.getLastName()));
			Assert.assertTrue(empJob.contains(data.getJob()));	
		}		
	}
	
	@Test(enabled=false, dataProvider = "TestData", dataProviderClass = TestDataProvider.class)
	public void TC29_MandatoryFieldValidation(UpdateEmployeeData data)
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,UIConstants.LOGIN_PAGE_TITLE);
		login.enterUsernameAndPassword(data.getUsername(),data.getPassword());
		login.clickLoginButton();	
		dashboardPage dashboard = new dashboardPage(driver);
		Assert.assertEquals(dashboard.verifyDashBoard(), UIConstants.DASHBOARD_PAGE_TITLE);
		PIMPage pim = new PIMPage(driver);
		pim.PIMclick();
		Assert.assertEquals(pim.verifyPIM(), UIConstants.PIM_PAGE_TITLE);
		pim.searchByEmployeeID(data.getEmpID());
		pim.clickSearch();	
		pim.editSearchedEmployeeProfile(data.getEmpID());	
		personalDetailsPage pdpage = new personalDetailsPage(driver);
		String errorMessage  = pdpage.checkMandatoryForFirstName();
		Assert.assertEquals(errorMessage, UIConstants.REQUIRED_ERRRORMESSAGE);
	}
	
	@Test(enabled=false, dataProvider = "TestData", dataProviderClass = TestDataProvider.class)
	public void TC30_VerifyPersistance(UpdateEmployeeData data)
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,UIConstants.LOGIN_PAGE_TITLE);
		login.enterUsernameAndPassword(data.getUsername(),data.getPassword());
		login.clickLoginButton();	
		dashboardPage dashboard = new dashboardPage(driver);
		Assert.assertEquals(dashboard.verifyDashBoard(), UIConstants.DASHBOARD_PAGE_TITLE);
		PIMPage pim = new PIMPage(driver);
		pim.PIMclick();
		Assert.assertEquals(pim.verifyPIM(), UIConstants.PIM_PAGE_TITLE);
		pim.searchByEmployeeID(data.getEmpID());
		pim.clickSearch();	
		pim.editSearchedEmployeeProfile(data.getEmpID());	
		personalDetailsPage pdpage = new personalDetailsPage(driver);
		pdpage.updateFirstName(data.getFirstName());
		pdpage.updateLastName(data.getLastName());
		pdpage.clickSave();
		pim.PIMclick();
		Assert.assertEquals(pim.verifyPIM(), UIConstants.PIM_PAGE_TITLE);
		pim.searchByEmployeeID(data.getEmpID());
		pim.clickSearch();
		pim.editSearchedEmployeeProfile(data.getEmpID());	
		Assert.assertTrue(pdpage.getemployeeFirstName().contains(data.getFirstName()));
		Assert.assertTrue(pdpage.getemployeeLastName().contains(data.getLastName()));	
				
	}
	
	@Test(enabled=true, dataProvider = "TestData", dataProviderClass = TestDataProvider.class)
	public void TC31_VerifySuccessMessage(UpdateEmployeeData data)
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,UIConstants.LOGIN_PAGE_TITLE);
		login.enterUsernameAndPassword(data.getUsername(),data.getPassword());
		login.clickLoginButton();	
		dashboardPage dashboard = new dashboardPage(driver);
		Assert.assertEquals(dashboard.verifyDashBoard(), UIConstants.DASHBOARD_PAGE_TITLE);
		PIMPage pim = new PIMPage(driver);
		pim.PIMclick();
		Assert.assertEquals(pim.verifyPIM(), UIConstants.PIM_PAGE_TITLE);
		pim.searchByEmployeeID(data.getEmpID());
		pim.clickSearch();	
		pim.editSearchedEmployeeProfile(data.getEmpID());	
		personalDetailsPage pdpage = new personalDetailsPage(driver);
		pdpage.updateFirstName(data.getFirstName());
		pdpage.clickSave();
		Assert.assertEquals(pdpage.verifySuccessMessage(),UIConstants.SUCCESSFULLY_UPDATED_TEXT);
	}
	
}