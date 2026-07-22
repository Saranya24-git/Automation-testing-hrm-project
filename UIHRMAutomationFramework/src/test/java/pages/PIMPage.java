package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIMPage
{
	WebDriver driver;
	
	@FindBy(xpath="//h6[@class=\"oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module\"]")
	WebElement pimText;
	@FindBy(xpath="//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]")
	WebElement addEmployeeButton;
	@FindBy(xpath="//div[@class=\"orangehrm-edit-employee-name\"]//h6[@class=\"oxd-text oxd-text--h6 --strong\"]")
	WebElement employeeNameText;
	@FindBy(xpath="//h5[text()=\"Employee Information\"]")
	WebElement empInfoText;
	
	public PIMPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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

	
}