package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage
{
	WebDriver driver;
	
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
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String isLoginPageVisible()
	{
		return loginText.getText();
	}
	
		public void enterUsernameAndPassword(String username, String password)
		{
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			wait.until(ExpectedConditions.visibilityOf(usernameField));
			wait.until(ExpectedConditions.elementToBeClickable(usernameField));
			usernameField.sendKeys(username);
			passwordField.sendKeys(password);
			
		}
		
		public void clickLoginButton() 
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
			wait.until(ExpectedConditions.elementToBeClickable(loginbtn));
	
			loginbtn.click();			
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