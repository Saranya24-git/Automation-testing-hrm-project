package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import base.BasePage;
 
public class personalDetailsPage extends BasePage
{
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='firstName']")
	WebElement empFirstName;
	@FindBy(xpath="//button[@type=\"submit\" and text()=\" Save \"]")
	WebElement saveButton;
	@FindBy(xpath="//input[@name='lastName']")
	WebElement empLastName;
	@FindBy(xpath="//label[text()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]//input")
	WebElement empId;
	@FindBy(xpath="//input[@name=\"firstName\"]/ancestor::div[contains(@class,'oxd-input-group oxd-input-field-bottom-space')]//span[text()=\"Required\"]")
	WebElement firstNameMandatoryText;
	//@FindBy(xpath="//*[contains(@class,'oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text')]")
	//WebElement successfullyUpdatedText;
		
	
	public personalDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void updateFirstName(String firstname)
	{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".oxd-loading-spinner")));
		wait.until(ExpectedConditions.visibilityOf(empFirstName));
		empFirstName.click();
		empFirstName.sendKeys(Keys.CONTROL, "a");
		empFirstName.sendKeys(Keys.BACK_SPACE);
		empFirstName.sendKeys(firstname);
	}
	
	public void clickSave()
	{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".oxd-loading-spinner")));
		saveButton.click();	
	}
	
	public void updateLastName(String lastname)
	{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".oxd-loading-spinner")));
		wait.until(ExpectedConditions.visibilityOf(empLastName));
		empLastName.click();
		empLastName.sendKeys(Keys.CONTROL, "a");
		empLastName.sendKeys(Keys.BACK_SPACE);
		empLastName.sendKeys(lastname);
	}
	
	public void updateEmployeeId(String employeeId)
	{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".oxd-loading-spinner")));
		wait.until(ExpectedConditions.visibilityOf(empId));
		empId.click();
		empId.sendKeys(Keys.CONTROL, "a");
		empId.sendKeys(Keys.BACK_SPACE);
		empId.sendKeys(employeeId);
	}
	
	public String checkMandatoryForFirstName()
	{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".oxd-loading-spinner")));
		wait.until(ExpectedConditions.visibilityOf(empFirstName));
		empFirstName.click();
		empFirstName.sendKeys(Keys.CONTROL, "a");
		empFirstName.sendKeys(Keys.BACK_SPACE);
		return firstNameMandatoryText.getText();		
	}
	
	public String getemployeeFirstName()
	{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".oxd-loading-spinner")));
		wait.until(ExpectedConditions.visibilityOf(empFirstName));
		return empFirstName.getDomProperty("value");
	}
	
	public String getemployeeLastName()
	{
		empLastName.click();
		return empLastName.getDomProperty("value");
	}
	
	public String verifySuccessMessage()
	{
		By successfullyUpdatedText = By.xpath("//*[contains(@class,'oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text')]");
		return wait.until(ExpectedConditions.visibilityOfElementLocated(successfullyUpdatedText)).getText();
	}
}