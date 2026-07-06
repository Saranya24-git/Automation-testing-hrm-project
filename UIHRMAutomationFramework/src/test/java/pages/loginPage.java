package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
			
			
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	
			wait1.until(ExpectedConditions.visibilityOfElementLocated(
			    By.xpath("//h6[text()='Dashboard']")
			));
			
		}
}