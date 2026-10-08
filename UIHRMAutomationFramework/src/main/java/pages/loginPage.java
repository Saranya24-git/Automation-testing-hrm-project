package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.BasePage;

public class loginPage extends BasePage
{
	WebDriver driver;
	
	private static final Logger logger =
	        LogManager.getLogger(loginPage.class);
	
	@FindBy(xpath="//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']")
	WebElement loginText;
	@FindBy(name="username")
	WebElement usernameField;
	@FindBy(name="password")
	WebElement passwordField;
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginbtn;	
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
	WebElement invalidCredentialsText;
	@FindBy(xpath="//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\" and text()='Required']")
	WebElement requiredCredentialsText;
	
	public loginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String isLoginPageVisible()
	{
		return loginText.getText();
	}
	
		public void enterUsernameAndPassword(String username, String password)
		{
			wait.until(ExpectedConditions.visibilityOf(usernameField));
			wait.until(ExpectedConditions.elementToBeClickable(usernameField));
			usernameField.sendKeys(username);
			passwordField.sendKeys(password);
				logger.info("Username and Password entered");		
		}
		
		public void clickLoginButton() 
		{
			wait.until(ExpectedConditions.elementToBeClickable(loginbtn));
	
			loginbtn.click();	
			logger.info("login button clicked");
			
		}	
		
		
		public String verifyInvalidCredentials()
		{
			return invalidCredentialsText.getText();
		}
		
		public String verifyRequiredCredentials()
		{
			return requiredCredentialsText.getText();
		}
}