package com.makeMyTrip.qa.util;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.makeMyTrip.qa.base.TestBase;


public class TestUtil extends TestBase {

	static WebDriver driver;
	public static String currentDate = getCurrentDate();
	public static String sevenplusreturnDate = getSevenDaysAfterCurrentDate();
	public static long Page_Load_TimeOut=20;
	public static long IMPLICIT_WAIT=10;

	public static String getCurrentDate() {
		SimpleDateFormat formattedDate = new SimpleDateFormat("EEEE, dd MMM yyyy");            
		Calendar cal = Calendar.getInstance();  
		currentDate = formattedDate.format(cal.getTime());	
		return currentDate;
	}

	public static String getSevenDaysAfterCurrentDate() {
		SimpleDateFormat formattedDate = new SimpleDateFormat("EEEE, dd MMM yyyy");            
		Calendar cal = Calendar.getInstance();  
		cal.add(Calendar.DAY_OF_MONTH, 7);
		sevenplusreturnDate = formattedDate.format(cal.getTime());
		return sevenplusreturnDate;
	}

	public static void selectDateByJS(WebDriver driver, WebElement element, String dateVal){
		JavascriptExecutor js = ((JavascriptExecutor) driver);

		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);


	}

	public static void safeJavaScriptClick(WebElement element) throws Exception {
		try {
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				System.out.println("clicked");
			} else {
				System.out.println("Unable to click on element");
			}
		} catch (StaleElementReferenceException e) {
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
	}	

	public static void waitForElement(WebDriver driver,  String locator) {
		WebDriverWait wait = new WebDriverWait (driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));		
	}

	public static void toBottomOfPage() {
		try {
			long Height =Long.parseLong(((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight").toString());

			System.out.println(Height);

			while (true) {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
				Thread.sleep(500);

				long newHeight = Long.parseLong(((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight").toString());

				System.out.println(newHeight);
				if (newHeight == Height) {
					break;
				}
				Height = newHeight;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//Scrolls to top of page
	public static void toTopPage() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(document.body.scrollHeight,0);");
	}

	//Scrolls till element is visible
	public static void toElement(WebElement element){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void clearStopFilter() {
		Reporter.log("Clearing applied filters..");
		driver.findElement(By.xpath(RepositeriesFactory.clearFilters)).click();
		
	}

}
