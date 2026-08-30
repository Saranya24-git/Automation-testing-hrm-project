package pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import base.BasePage;

public class dashboardPage extends BasePage
{
	WebDriver driver;
	
	@FindBy(xpath="//h6[text()='Dashboard']")
	WebElement dashboardPageText;
	@FindBy(xpath="//i[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]")
	WebElement profileDropDwn;
	@FindBy(xpath="//a[text()=\"Logout\"]")
	WebElement logoutButton;
	
	
	public dashboardPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String verifyDashBoard()
	{
		wait.until(ExpectedConditions.visibilityOf(dashboardPageText));
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