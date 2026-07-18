package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dashboardPage
{
	WebDriver driver;
	
	@FindBy(xpath="//h6[text()='Dashboard']")
	WebElement dashboardPageText;
	@FindBy(xpath="//i[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]")
	WebElement profileDropDwn;
	@FindBy(xpath="//a[text()=\"Logout\"]")
	WebElement logoutButton;
	
	public dashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String verifyDashBoard()
	{
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));		
		wait1.until(ExpectedConditions.visibilityOf(dashboardPageText));
		return dashboardPageText.getText();
	}
	
	public void clickProfileDropdown()
	{
		profileDropDwn.click();
	}
	
	public void clickLogoutButton()
	{
		logoutButton.click();
	}
}