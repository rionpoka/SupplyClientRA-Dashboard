package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtils {
	 public static WebDriver getDriver(String browser) {
	        WebDriver driver;
	        switch (browser.toLowerCase()) {
	            case "firefox":
	                WebDriverManager.firefoxdriver().setup();
	                driver = new FirefoxDriver();
	                break;
	            case "chrome":
	            default:
	                WebDriverManager.chromedriver().setup();
	                driver = new ChromeDriver();
	                break;
	        }
	        return driver;
	        
	 }
	 
	 public static void maximizeWindow(WebDriver driver) {
	        driver.manage().window().maximize();
	    }

	    public static void wait(int seconds) {
	        try {
	            Thread.sleep(seconds * 1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
}
