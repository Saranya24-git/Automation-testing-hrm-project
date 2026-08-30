package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import base.BasePage;

public class jobDetailsPage extends BasePage
{
	WebDriver driver;
	
	@FindBy(xpath="//a[text()=\"Job\"]")
	WebElement jobTab;
	@FindBy(xpath="//label[text()=\"Job Title\"]//..//..//div[@class=\"oxd-select-text--after\"]")
	WebElement empJobTitleDropDown;
	@FindBy(xpath="//label[text()='Job Title']//ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text-input')]")
	WebElement empJobField;
	@FindBy(xpath="//button[@type=\"submit\" and text()=\" Save \"]")
	WebElement saveButton;
	
	public jobDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickJobTab()
	{
		jobTab.click();
	}
	
	public void updateJob(String jobtitle)
	{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".oxd-loading-spinner")));
		wait.until(ExpectedConditions.visibilityOf(empJobTitleDropDown));
		empJobTitleDropDown.click();
		WebElement empJobTitleDropdownField = driver.findElement(By.xpath("//div[@role=\"listbox\"]//span[text()=\"" +jobtitle+ "\"]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", empJobTitleDropdownField);
		wait.until(ExpectedConditions.elementToBeClickable(empJobTitleDropdownField));
		empJobTitleDropdownField.click();	
		wait.until(ExpectedConditions.textToBePresentInElement(empJobField,jobtitle));
		
	}
	
	public void clickSave()
	{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".oxd-loading-spinner")));
		saveButton.click();	
	}
}