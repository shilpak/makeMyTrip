package com.makeMyTrip.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import com.makeMyTrip.qa.util.TestUtil;

public class TestBase {
		
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
	
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\Shilpa\\eclipse-workspace\\mavenjenkins\\MakeMyTrip\\src\\main\\java\\com\\makeMyTrip\\qa\\config\\config.properties");
		    prop.load(fis);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static void intialization()
	{
		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			//ChromeOptions capabilities = new ChromeOptions();
			//capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(options);
			
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
            driver=new FirefoxDriver();
                    
		}
         
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		Reporter.log(prop.getProperty("Testing_URL") + " Opened");
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_TimeOut,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		
		
	}
}