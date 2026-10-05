package test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import annotations.TestDataSheet;
import base.BaseTest;
import constants.UIConstants;
import dataProviders.TestDataProvider;
import datamodels.DeleteData;
import pages.PIMPage;
import pages.dashboardPage;
import pages.loginPage;


@TestDataSheet(sheetName = "DeleteEmployee",  model=DeleteData.class)
public class deleteEmployeeTests extends BaseTest
{
	@Test(enabled=false,dataProvider = "TestData", dataProviderClass = TestDataProvider.class)
	public void TC32_VerifyThatAnExistingEmployeeCanBeDeletedSuccessfullyFromTheEmployeeList(DeleteData data) 
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
		pim.deleteSearchedEmployeeProfile(data.getEmpID());
		pim.validateDeleteConfirmationPopup();		
	}
	
	@Test(enabled=false,dataProvider = "TestData", dataProviderClass = TestDataProvider.class)
	public void TC33_VerifyThatAConfirmationPopupIsDisplayedWithAppropriateInformationBeforeDeletingAnEmployee(DeleteData data)
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
		pim.deleteSearchedEmployeeProfile(data.getEmpID());
		pim.validateDeleteConfirmationPopup();	
		Assert.assertEquals(UIConstants.DELETE_POPUP_HEADER, pim.validateConfirmationPopupHeader());
		Assert.assertEquals(UIConstants.DELETE_POPUP_TEXT, pim.validateConfirmationPopupText());		
	}
	
	@Test(enabled=false, dataProvider = "TestData", dataProviderClass = TestDataProvider.class)
	public void TC34_VerifyThatClickingCancelInTheDeleteConfirmationPopupDoesNotDeleteTheEmployee(DeleteData data)
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
		pim.deleteSearchedEmployeeProfile(data.getEmpID());
		pim.validateDeleteConfirmationPopup();	
		Assert.assertEquals(UIConstants.DELETE_POPUP_HEADER, pim.validateConfirmationPopupHeader());
		Assert.assertEquals(UIConstants.DELETE_POPUP_TEXT, pim.validateConfirmationPopupText());
		pim.clickCancelOnConfirmationPopup();
		pim.deleteSearchedEmployeeProfile(data.getEmpID());
	}
	
	@Test(enabled=false, dataProvider = "TestData", dataProviderClass = TestDataProvider.class)
	public void TC35_VerifyThatClickingConfirmInTheConfirmationPopupDeletesTheSelectedEmployee(DeleteData data)
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
		pim.deleteSearchedEmployeeProfile(data.getEmpID());
		pim.validateDeleteConfirmationPopup();	
		Assert.assertEquals(UIConstants.DELETE_POPUP_HEADER, pim.validateConfirmationPopupHeader());
		Assert.assertEquals(UIConstants.DELETE_POPUP_TEXT, pim.validateConfirmationPopupText());
		pim.clickConfirmOnConfirmationPopup();
		Assert.assertEquals(UIConstants.DELETE_SUCCESS_MESSAGE, pim.verifySuccessfullyDeletedMessage());
	}
	
	@Test(enabled=false, dataProvider = "TestData", dataProviderClass = TestDataProvider.class)
	public void TC36_VerifyThatTheDeletedEmployeeIsNoLongerPresentInTheEmployeeList(DeleteData data)
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
		pim.deleteSearchedEmployeeProfile(data.getEmpID());
		pim.validateDeleteConfirmationPopup();	
		Assert.assertEquals(UIConstants.DELETE_POPUP_HEADER, pim.validateConfirmationPopupHeader());
		Assert.assertEquals(UIConstants.DELETE_POPUP_TEXT, pim.validateConfirmationPopupText());
		pim.clickConfirmOnConfirmationPopup();
		Assert.assertEquals(UIConstants.DELETE_SUCCESS_MESSAGE, pim.verifySuccessfullyDeletedMessage());	
		List<WebElement> rows = pim.checkEmployeeTableData();
		Assert.assertEquals(rows.size(), 0);
		Assert.assertEquals(pim.getNoRecordsFound(),UIConstants.PIM_PAGE_NO_RECORD_FOUND);
	}
	
	@Test(enabled=false, dataProvider = "TestData", dataProviderClass = TestDataProvider.class)
	public void TC37_VerifyThatADeletedEmployeeCannotBeRetrievedThroughEmployeeSearch(DeleteData data)
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
		List<WebElement> rows = pim.checkEmployeeTableData();
		Assert.assertEquals(rows.size(), 0);
	}
	
	@Test(enabled=false, dataProvider = "TestData", dataProviderClass = TestDataProvider.class)
	public void TC38_VerifyThatTheAppropriateNoRecordsMessageIsDisplayedWhenSearchingForADeletedEmployee(DeleteData data)
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
		List<WebElement> rows = pim.checkEmployeeTableData();
		Assert.assertEquals(rows.size(), 0);
		Assert.assertEquals(pim.getNoRecordsFound(),UIConstants.PIM_PAGE_NO_RECORD_FOUND);
	}
	
	@Test(enabled=false, dataProvider = "TestData", dataProviderClass = TestDataProvider.class)
	public void TC39_VerifyThatTheEmployeeCountDecreasesByOneAfterDeletingAnEmployee(DeleteData data)
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
		int totalRecordsCount = pim.getTotalRecordsCount();
		pim.searchByEmployeeID(data.getEmpID());
		pim.clickSearch();	
		pim.deleteSearchedEmployeeProfile(data.getEmpID());
		pim.validateDeleteConfirmationPopup();	
		Assert.assertEquals(UIConstants.DELETE_POPUP_HEADER, pim.validateConfirmationPopupHeader());
		Assert.assertEquals(UIConstants.DELETE_POPUP_TEXT, pim.validateConfirmationPopupText());
		pim.clickConfirmOnConfirmationPopup();
		Assert.assertEquals(UIConstants.DELETE_SUCCESS_MESSAGE, pim.verifySuccessfullyDeletedMessage());
		pim.PIMclick();
		int totalRecordsCountAfterDeletion = pim.getTotalRecordsCount();
		Assert.assertEquals(totalRecordsCountAfterDeletion, totalRecordsCount-1);
	}
	
	
}