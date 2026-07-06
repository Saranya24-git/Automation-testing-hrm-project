package base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class DriverFactory {

    protected WebDriver driver;    
       
       
        @BeforeClass
    	public void Setup()
    	{
    		driver = DriverFactory.initDriver();
    		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    		driver.navigate().refresh();
    	}
        
        public static WebDriver initDriver() {

            WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();

            return driver;
    	}
        
       

		@AfterClass
        public void tearDown() {

            if(driver != null)
                driver.quit();
        }

       
    
}