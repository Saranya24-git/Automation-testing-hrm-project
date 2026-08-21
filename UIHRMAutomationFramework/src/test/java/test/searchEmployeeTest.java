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
import datamodels.SearchEmployeeData;
import pages.PIMPage;
import pages.addEmployeePage;
import pages.dashboardPage;
import pages.loginPage;

@TestDataSheet(sheetName = "SearchEmployee",  model=SearchEmployeeData.class)

public class searchEmployeeTest extends BaseTest
{
	@Test(enabled=true, dataProvider = "TestData", dataProviderClass = TestDataProvider.class)
	public void TC15_SearchEmployeeByName(SearchEmployeeData data)
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
		pim.clickAddEmplpyee();
		addEmployeePage addEmployee = new addEmployeePage(driver);
		Assert.assertEquals(addEmployee.addEmployeeText(),UIConstants.PIM_PAGE_ADD_EMPLOYEE_TEXT);
		addEmployee.enterFirstName(data.getFirstName());
		addEmployee.enterLastName(data.getLastName());
		addEmployee.clickSaveButton();
		pim.PIMclick();
		pim.searchByEmployeeName(data.getEmpName());
		pim.clickSearch();	
		Assert.assertEquals(pim.checkEmployeeNameTable(),data.getEmpName());
	}
	
	@Test(enabled=true, dataProvider = "TestData", dataProviderClass = TestDataProvider.class)
	public void TC16_SearchEmployeeByID(SearchEmployeeData data)
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,UIConstants.LOGIN_PAGE_TITLE);
		login.enterUsernameAndPassword(data.getUsername(),data.getPassword());
		login.clickLoginButton();	
		PIMPage pim = new PIMPage(driver);
		pim.PIMclick();
		Assert.assertEquals(pim.verifyPIM(), UIConstants.PIM_PAGE_TITLE);
		pim.searchByEmployeeID(data.getEmpID());
		pim.clickSearch();	
		Assert.assertEquals(pim.checkEmployeeIDTable(),data.getEmpID());		
	}
	
	@Test(enabled=true, dataProvider = "TestData", dataProviderClass = TestDataProvider.class)
	public void TC17_SearchEmployeeByStatus(SearchEmployeeData data)
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,UIConstants.LOGIN_PAGE_TITLE);
		login.enterUsernameAndPassword(data.getUsername(),data.getPassword());
		login.clickLoginButton();	
		PIMPage pim = new PIMPage(driver);
		pim.PIMclick();
		Assert.assertEquals(pim.verifyPIM(), UIConstants.PIM_PAGE_TITLE);
		pim.searchByEmployeeStatus(data.getEmpStatus());
		pim.clickSearch();	
		WebElement row = pim.checkEmployeeTable(data.getEmpID());
		String status = row.findElement(By.xpath(".//div//div[6]")).getText();
		Assert.assertEquals(status, data.getEmpStatus());		
	}
	@Test(enabled=false, dataProvider = "TestData", dataProviderClass = TestDataProvider.class)
	public void TC18_SearchEmployeeByJobTitle(SearchEmployeeData data)
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,UIConstants.LOGIN_PAGE_TITLE);
		login.enterUsernameAndPassword(data.getUsername(),data.getPassword());
		login.clickLoginButton();	
		PIMPage pim = new PIMPage(driver);
		pim.PIMclick();
		Assert.assertEquals(pim.verifyPIM(), UIConstants.PIM_PAGE_TITLE);
		pim.searchByEmployeeJobTitle(data.getJobTitle());
		pim.clickSearch();	
		WebElement row = pim.checkEmployeeTable(data.getEmpID());
		String jobtitle = row.findElement(By.xpath(".//div//div[5]")).getText();
		Assert.assertEquals(jobtitle, data.getJobTitle());
	}
	
	@Test(enabled=false, dataProvider = "TestData", dataProviderClass = TestDataProvider.class)
	public void TC19_SearchByEmployeeSupervisorName(SearchEmployeeData data)
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,UIConstants.LOGIN_PAGE_TITLE);
		login.enterUsernameAndPassword(data.getUsername(),data.getPassword());
		login.clickLoginButton();	
		PIMPage pim = new PIMPage(driver);
		pim.PIMclick();
		Assert.assertEquals(pim.verifyPIM(), UIConstants.PIM_PAGE_TITLE);
		pim.searchByEmployeeSupervisorName(data.getSupervisorName());
		pim.clickSearch();	
		WebElement row = pim.checkEmployeeTable(data.getEmpID());
		String supervisorname = row.findElement(By.xpath(".//div//div[8]")).getText();
		Assert.assertEquals(supervisorname, data.getSupervisorName());
	}
	
	@Test(enabled=false, dataProvider = "TestData", dataProviderClass = TestDataProvider.class)
	public void TC20_SearchByMultipleFilters(SearchEmployeeData data)
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,UIConstants.LOGIN_PAGE_TITLE);
		login.enterUsernameAndPassword(data.getUsername(),data.getPassword());
		login.clickLoginButton();	
		PIMPage pim = new PIMPage(driver);
		pim.PIMclick();
		Assert.assertEquals(pim.verifyPIM(), UIConstants.PIM_PAGE_TITLE);
		pim.searchByEmployeeName(data.getEmpName());
		pim.searchByEmployeeID(data.getEmpID());
		pim.searchByEmployeeStatus(data.getEmpStatus());
		pim.searchByEmployeeJobTitle(data.getJobTitle());
		pim.searchByEmployeeSupervisorName(data.getSupervisorName());
		pim.clickSearch();	
		WebElement row = pim.checkEmployeeTable(data.getEmpID());
		String Id = row.findElement(By.xpath(".//div//div[2]")).getText();
		Assert.assertEquals(Id, data.getEmpID());		
		String firstname = row.findElement(By.xpath(".//div//div[3]")).getText();
		Assert.assertEquals(firstname, data.getFirstName());	
		String lastname = row.findElement(By.xpath(".//div//div[4]")).getText();
		Assert.assertEquals(lastname, data.getLastName());
		String jobtitle = row.findElement(By.xpath(".//div//div[5]")).getText();
		Assert.assertEquals(jobtitle, data.getJobTitle());
		String status = row.findElement(By.xpath(".//div//div[6]")).getText();
		Assert.assertEquals(status, data.getEmpStatus());		
		String supervisorname = row.findElement(By.xpath(".//div//div[8]")).getText();
		Assert.assertEquals(supervisorname, data.getSupervisorName());	
	}
	
	@Test(enabled=false, dataProvider = "TestData", dataProviderClass = TestDataProvider.class)
	public void TC21_SearchWithInvalidEmployeeName(SearchEmployeeData data)
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,UIConstants.LOGIN_PAGE_TITLE);
		login.enterUsernameAndPassword(data.getUsername(),data.getPassword());
		login.clickLoginButton();	
		PIMPage pim = new PIMPage(driver);
		pim.PIMclick();
		Assert.assertEquals(pim.verifyPIM(), UIConstants.PIM_PAGE_TITLE);
		pim.searchByEmployeeName(data.getEmpName());
		pim.clickSearch();	
		List<WebElement> rows = pim.checkEmployeeTableData();
		Assert.assertEquals(rows.size(), 0);
		Assert.assertEquals(pim.getNoRecordsFound(),UIConstants.PIM_PAGE_NO_RECORD_FOUND);
		
	}
	
	@Test(enabled=false, dataProvider = "TestData", dataProviderClass = TestDataProvider.class)
	public void TC22_SearchWithInvalidEmpID(SearchEmployeeData data)
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,UIConstants.LOGIN_PAGE_TITLE);
		login.enterUsernameAndPassword(data.getUsername(),data.getPassword());
		login.clickLoginButton();	
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
	public void TC23_SearchWithoutAnyFilters(SearchEmployeeData data)
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,UIConstants.LOGIN_PAGE_TITLE);
		login.enterUsernameAndPassword(data.getUsername(),data.getPassword());
		login.clickLoginButton();	
		PIMPage pim = new PIMPage(driver);
		pim.PIMclick();		
		Assert.assertEquals(pim.verifyPIM(), UIConstants.PIM_PAGE_TITLE);
		pim.clickSearch();			
		//Table headers are displayed correctly.		
		List<String> actualHeaders = pim.getTableHeader();
		Assert.assertEquals(actualHeaders,UIConstants.EXPECTED_HEADERS,UIConstants.PIM_PAGE_TABLE_HEADERS_INCORRECT);		
		//At least one employee record is returned.
		Assert.assertTrue(pim.checkEmployeeTableData().size() > 0,UIConstants.PIM_PAGE_TABLE_SHOULD_CONTAIN_RECORDS);
		//"No Records Found" is not displayed.
		Assert.assertFalse(pim.isNoRecordsFoundDisplayed());
		//Employee IDs and Employee Names in each row are populated.	
		List<WebElement> rows = pim.checkEmployeeTableData();
		for (WebElement row : rows)
		{
		    String employeeId = row.findElement(By.xpath(".//div[@role='cell'][2]"))
		                           .getText()
		                           .trim();

		    String employeeName = row.findElement(By.xpath(".//div[@role='cell'][3]"))
		                             .getText()
		                             .trim();
		   Assert.assertFalse(employeeId.isEmpty(),UIConstants.PIM_PAGE_EMPLOYEE_ID_NOT_EMPTY);
		   Assert.assertFalse(employeeName.isEmpty(), UIConstants.PIM_PAGE_EMPLOYEE_NAME_NOT_EMPTY);
		}
		//Pagination (if applicable) is displayed and functional.
		//is pagination available
		Assert.assertTrue(pim.isPaginationAvailable());
		//does next button enabled
		Assert.assertTrue(pim.isNextButtonEnabled());
		//click next button
		pim.clickNextButton();
		//get current page number
		Assert.assertEquals(pim.getCurrentPageNumber(), UIConstants.PIM_PAGE_CURRENT_PAGE_NUMBER);	
	}
	

	@Test(enabled=false, dataProvider = "TestData", dataProviderClass = TestDataProvider.class)
	public void TC24_ResetSearchFilters(SearchEmployeeData data)
	{
		loginPage login = new loginPage(driver);
		String loginPageCheck = login.isLoginPageVisible();
		Assert.assertEquals(loginPageCheck,UIConstants.LOGIN_PAGE_TITLE);
		login.enterUsernameAndPassword(data.getUsername(),data.getPassword());
		login.clickLoginButton();	
		PIMPage pim = new PIMPage(driver);
		pim.PIMclick();		
		Assert.assertEquals(pim.verifyPIM(), UIConstants.PIM_PAGE_TITLE);
		pim.searchByEmployeeName(data.getEmpName());
		pim.searchByEmployeeID(data.getEmpID());
		pim.searchByEmployeeStatus(data.getEmpStatus());
		pim.searchByEmployeeJobTitle(data.getJobTitle());
		pim.searchByEmployeeSupervisorName(data.getSupervisorName());
		pim.clickReset();
		Assert.assertEquals(pim.getEmployeeNameValueAfterReset(),"");
		Assert.assertEquals(pim.getEmployeeIdValueAfterReset(),"");
		Assert.assertEquals(pim.getEmployeeStatusAfterReset(), null);
		Assert.assertEquals(pim.getEmployeeJobAfterReset(), null);
		Assert.assertEquals(pim.getEmployeeSupervisorAfterReset(),"");		
	}
}