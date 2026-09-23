package base;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory { 
    
		private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
		//createDriver() puts the correct driver into that thread's slot
        public static void createDriver(String browser, boolean headless) {
        	
        	WebDriver webDriver;
        	
        	switch (browser.toLowerCase()) {

            case "chrome":
            	ChromeOptions chromeOptions = new ChromeOptions();

                if (headless)
                    chromeOptions.addArguments("--headless=new");

                webDriver =  new ChromeDriver(chromeOptions);      
                break;

            case "edge":
            	EdgeOptions edgeOptions = new EdgeOptions();

                if (headless)
                    edgeOptions.addArguments("--headless=new");

                webDriver =  new EdgeDriver(edgeOptions);
               break;

            case "firefox":
            	 FirefoxOptions firefoxOptions = new FirefoxOptions();

                 if (headless)
                     firefoxOptions.addArguments("--headless");

                 webDriver =  new FirefoxDriver(firefoxOptions);
                 break;

            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }
        	if (headless) {
        		webDriver.manage().window().setSize(new Dimension(1920, 1080));
        	}
        	else {
        		webDriver.manage().window().maximize();
        	}
        	
        	driver.set(webDriver);
        }

        //getDriver() retrieves the driver belonging to the current thread
        public static WebDriver getDriver() {
            return driver.get();
        }
        
        public static void quitDriver(WebDriver driver) {

            if (driver != null) {
                driver.quit();
            }
        }
}

