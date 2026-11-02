package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory { 
	
	 private static final Logger logger =
	            LogManager.getLogger(DriverFactory.class);

    
	    /*running multiple tests in parallel is not itself synchronization. 
	    * separate ThreadLocal<WebDriver> instances help each test thread use its own browser, 
	     * reducing conflicts over a shared WebDriver instance.*/
	 
		private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
		//createDriver() puts the correct driver into that thread's slot
        public static void createDriver(String browser, boolean headless) {
        	
        	logger.info(
                    "Creating browser: {} | Headless: {}",
                    browser,
                    headless);
        	
        	WebDriver webDriver;
        	
        	switch (browser.toLowerCase()) {

            case "chrome":
            	
            	logger.info("Initializing ChromeDriver");
            	ChromeOptions chromeOptions = new ChromeOptions();

                if (headless)
                    chromeOptions.addArguments("--headless=new");

                webDriver =  new ChromeDriver(chromeOptions);      
                break;

            case "edge":
            	 logger.info("Initializing EdgeDriver");

            	EdgeOptions edgeOptions = new EdgeOptions();

                if (headless)
                    edgeOptions.addArguments("--headless=new");

                webDriver =  new EdgeDriver(edgeOptions);
               break;

            case "firefox":
            	
            	 logger.info("Initializing FirefoxDriver");
            	 FirefoxOptions firefoxOptions = new FirefoxOptions();

                 if (headless)
                     firefoxOptions.addArguments("--headless");

                 webDriver =  new FirefoxDriver(firefoxOptions);
                 break;

            default:
            	logger.error(
                        "Unsupported browser: {}",
                        browser);
                throw new RuntimeException("Browser not supported: " + browser);
        }
        	if (headless) {
        		webDriver.manage().window().setSize(new Dimension(1920, 1080));
        	}
        	else {
        		webDriver.manage().window().maximize();
        	}
        	
        	driver.set(webDriver);
        	logger.info(
                    "WebDriver created successfully | Thread: {}",
                    Thread.currentThread().getId());
        }

        //getDriver() retrieves the driver belonging to the current thread
        public static WebDriver getDriver() {
            return driver.get();
        }
        
        public static void quitDriver() {

        	 WebDriver currentDriver = getDriver();

        	    try {
        	        if (currentDriver != null) {
        	            logger.info(
        	                "Closing WebDriver | Thread: {}",
        	                Thread.currentThread().getId()
        	            );

        	            currentDriver.quit();
        	        }
        	    }
        	    finally {
        	    	driver.remove();
        	    }
        }
}

