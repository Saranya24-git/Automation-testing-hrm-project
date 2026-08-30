package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import base.BasePage;

import org.openqa.selenium.JavascriptExecutor;

public class PIMPage extends BasePage
{
	WebDriver driver;
	
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='PIM']")
	WebElement PIMOption;
	@FindBy(xpath="//h6[@class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]")
	WebElement pimText;
	@FindBy(xpath="//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]")
	WebElement addEmployeeButton;
	@FindBy(xpath="//div[@class=\"orangehrm-edit-employee-name\"]//h6[@class=\"oxd-text oxd-text--h6 --strong\"]")
	WebElement employeeNameText;
	@FindBy(xpath="//h5[text()=\"Employee Information\"]")
	WebElement empInfoText;
	@FindBy(xpath="//label[text()=\"Employee Name\"]//..//..//div[@class=\"oxd-autocomplete-text-input oxd-autocomplete-text-input--active\"]//input")
	WebElement empNameField;
	@FindBy(xpath="//button[text()=\" Search \"]")
	WebElement searchButton;
	@FindBy(xpath="//div[@class=\"oxd-table-row oxd-table-row--with-border oxd-table-row--clickable\"]//div[3]//div")
	WebElement tableEmployeeName;
	@FindBy(xpath="//label[text()=\"Employee Id\"]//..//..//input")
	WebElement empIDField;
	@FindBy(xpath="//div[@class=\"oxd-table-row oxd-table-row--with-border oxd-table-row--clickable\"]//div[2]//div")
	WebElement tableEmployeeID;	
	@FindBy(xpath="//div[@class=\"oxd-table-body\"]//div[@class=\"oxd-table-card\"]")
	List<WebElement> tableRows;
	@FindBy(xpath="//label[text()=\"Employment Status\"]//..//..//div[@class=\"oxd-select-text--after\"]")
	WebElement empStatusDropDown;
	//@FindBy(xpath="//label[text()=\"Employment Status\"]//..//..//div[@class=\"oxd-select-text-input\"]")
	//WebElement empStatusField;
	@FindBy(xpath="//label[text()=\"Job Title\"]//..//..//div[@class=\"oxd-select-text--after\"]")
	WebElement empJobTitleDropDown;
	@FindBy(xpath="//label[text()=\"Supervisor Name\"]//..//..//div[@class=\"oxd-autocomplete-text-input oxd-autocomplete-text-input--active\"]//input")
	WebElement empSupervisorNameField;
	@FindBy(xpath="//span[@class=\"oxd-text oxd-text--span\" and text()=\"No Records Found\"]")
	WebElement noRecordFoundText;
	@FindBy(xpath="//div[@class=\"oxd-table-row oxd-table-row--with-border\"]//div[@role=\"columnheader\"]")
	List<WebElement> tableheaders;
	@FindBy(xpath="//nav[@role = \"navigation\" and @aria-label=\"Pagination Navigation\"]")
	WebElement tablePagination;
	@FindBy(xpath="//i[@class=\"oxd-icon bi-chevron-right\"]")
	WebElement pageNavigationNextButton;
	@FindBy(xpath="//button[@class=\"oxd-pagination-page-item oxd-pagination-page-item--page oxd-pagination-page-item--page-selected\"]")
	WebElement currentPageNumber;
	@FindBy(xpath="//button[@type=\"reset\"]")
	WebElement resetButton;
	@FindBy(xpath="//label[text()='Job Title']//ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text-input')]")
	WebElement empJobField;
	@FindBy(xpath="//label[text()='Employment Status']//ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text-input')]")
	WebElement empStatusField;
	
	public PIMPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void PIMclick()
	{
		PIMOption.click();
	}
	
	public String verifyPIM()
	{
		return pimText.getText();
		
	}
	
	public void clickAddEmplpyee() {
		addEmployeeButton.click();
	}
	
	
	public String validateEmployeeName()
	{
		wait.until(ExpectedConditions.urlContains("viewPersonalDetails"));
		wait.until(driver ->
        !employeeNameText.getText().trim().isEmpty());
		return employeeNameText.getText();
	}
	
	public String validateEmployeeInfoText()
	{
		return empInfoText.getText();
	}

	
	public void searchByEmployeeName(String employeename)
	{
		empNameField.sendKeys(employeename);
	}
	
	public void clickSearch()
	{
		searchButton.click();
	}
	
	public String checkEmployeeNameTable()
	{
		return tableEmployeeName.getText();
	}
	
	public void searchByEmployeeID(String employeeID)
	{
		empIDField.sendKeys(employeeID);
	}
	
	public String checkEmployeeIDTable()
	{
		return tableEmployeeID.getText();
	}
	
	public void searchByEmployeeStatus(String employeeStatus)
	{
		empStatusDropDown.click();
		WebElement empStatusDropdownField = driver.findElement(By.xpath("//div[@role=\"listbox\"]//span[text()=\"" +employeeStatus+ "\"]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", empStatusDropdownField);
		wait.until(ExpectedConditions.elementToBeClickable(empStatusDropdownField));
		empStatusDropdownField.click();	
		wait.until(ExpectedConditions.textToBePresentInElement(empStatusField,employeeStatus));
	}
	
	public WebElement checkEmployeeTable(String empId)
	{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".oxd-loading-spinner")));
		wait.until(ExpectedConditions.visibilityOfAllElements(tableRows));
		for(WebElement row:tableRows)
		{
			String id = row.findElement(By.xpath(".//div//div[2]")).getText();
			if(id.equals(empId))
			{
				return row;
			}			
		}
		return null;
	}
	
	public List<WebElement> checkEmployeeTableData()
	{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".oxd-loading-spinner")));
		return tableRows;
	}
	
	public void searchByEmployeeJobTitle(String jobtitle)
	{
		empJobTitleDropDown.click();
		WebElement empJobTitleDropdownField = driver.findElement(By.xpath("//div[@role=\"listbox\"]//span[text()=\"" +jobtitle+ "\"]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", empJobTitleDropdownField);
		wait.until(ExpectedConditions.elementToBeClickable(empJobTitleDropdownField));
		empJobTitleDropdownField.click();	
		wait.until(ExpectedConditions.textToBePresentInElement(empJobField,jobtitle));
	}
	
	public void searchByEmployeeSupervisorName(String supervisorname)
	{
		empSupervisorNameField.sendKeys(supervisorname);
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//div[@role='listbox']//span[text()='" +
						 supervisorname +
						 "']")));		
		option.click();		
	}
	
	public String getNoRecordsFound()
	{
		return noRecordFoundText.getText();
	}
	
	public List<String> getTableHeader()
	{
		List<String> headers = new ArrayList<>();
		for(int i=1;i<tableheaders.size();i++)
		{
			headers.add(tableheaders.get(i).getText().trim());
		}
		return headers;		
	}
	
	public boolean isPaginationAvailable()
	{	
		return tablePagination.isDisplayed();		
	}
	
	public boolean isNoRecordsFoundDisplayed()
	{
		return !driver.findElements(
	            By.xpath("//span[normalize-space()='No Records Found']"))
	            .isEmpty();
	}
	
	public boolean isNextButtonEnabled()
	{
		return pageNavigationNextButton.isDisplayed();
	}
	
	public void clickNextButton()
	{
		pageNavigationNextButton.click();
	}
	
	public String getCurrentPageNumber()
	{
		return currentPageNumber.getText();
	}
	
	public void clickReset()
	{
		resetButton.click();
	}
	
	public String getEmployeeNameValueAfterReset()
	{
		return empNameField.getDomProperty("value");				
	}
	
	public String getEmployeeIdValueAfterReset()
	{
		return empIDField.getDomProperty("value");
	}
	
	public String getEmployeeStatusAfterReset()
	{
		return empStatusField.getDomProperty("value");
	}
	
	public String getEmployeeJobAfterReset()
	{
		return empJobField.getDomProperty("value");
	}
	
	public String getEmployeeSupervisorAfterReset()
	{
		return empSupervisorNameField.getDomProperty("value");
	}
	
	public void editSearchedEmployeeProfile(String empId)
	{
		List<WebElement> rows = checkEmployeeTableData();
		for(WebElement row : rows)
		{
			String employeeId = row.findElement(By.xpath(".//div[@role='cell'][2]"))
                    .getText()
                    .trim();
			if(employeeId.equals(empId))
			{
				 WebElement editButton =
			                row.findElement(
			                    By.xpath(".//button//i[@class='oxd-icon bi-pencil-fill']")
			                );

			        editButton.click();
			        break;
			}
		}
		
	}

}

