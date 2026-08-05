package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class PIMPage
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
	@FindBy(xpath="//div[@class=\"oxd-table-body\"]")
	List<WebElement> tableRows;
	@FindBy(xpath="//label[text()=\"Employment Status\"]//..//..//div[@class=\"oxd-select-text--after\"]")
	WebElement empStatusDropDown;
	@FindBy(xpath="//label[text()=\"Employment Status\"]//..//..//div[@class=\"oxd-select-text-input\"]")
	WebElement empStatusField;
	
	
	public PIMPage(WebDriver driver) {
		this.driver = driver;
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
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
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(25));
		wait.until(ExpectedConditions.elementToBeClickable(empStatusDropdownField));
		empStatusDropdownField.click();	
		By selectedStatusLocator = By.xpath(
			    "//label[text()='Employment Status']//ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text-input')]");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(selectedStatusLocator,employeeStatus));
	}
	
	public WebElement checkEmployeeStatusTable(String empId)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
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
	
}