package com.makeMyTrip.qa.pages;

import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import com.makeMyTrip.qa.base.TestBase;
import com.makeMyTrip.qa.util.RepositeriesFactory;
import com.makeMyTrip.qa.util.TestUtil;

public class HomePage extends TestBase {
	
	static Properties prop;
	TestUtil testutil;

	public void validateTitle() {
		Assert.assertEquals(driver.getTitle(), "MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights &amp; Holiday");		
	}
	
	//Method to click on flight menu
	public void selectFlightMenu(String menu) {
		List<WebElement> list = driver.findElements(By.xpath(RepositeriesFactory.optionsList));
		for(WebElement e:list) {
			if(e.getText().contains(menu)) {
				e.click();
				break;
			}
		}
	}
	
	public void TripWay(String way) {
		if (way.equalsIgnoreCase("two")) {
			TestUtil.waitForElement(driver, RepositeriesFactory.roundTripRadioButton);
			driver.findElement(By.xpath(RepositeriesFactory.roundTripRadioButton)).click();
			Reporter.log("Select on Stopway filter "+ way);
			
		} else if (way.equalsIgnoreCase("one")) {
			driver.findElement(By.xpath(RepositeriesFactory.oneWayTripRadioButton)).click();
			Reporter.log("select on Stopway filter "+ way);
			
		} else {
			driver.findElement(By.xpath(RepositeriesFactory.multipleCityButton)).click();
			Reporter.log("select on Stopway filter "+ way);			
		}
	}
		
	public FlightResultPage tripPlaner(String dCity, String aCity) {
		
		try {			
			driver.findElement(By.xpath(RepositeriesFactory.from)).click();
			driver.findElement(By.xpath(RepositeriesFactory.DepartCityName)).sendKeys(dCity);
			List<WebElement>list = driver.findElements(By.xpath(RepositeriesFactory.autosearchList));
			list.get(0).click();			
			TestUtil.waitForElement(driver, RepositeriesFactory.ArrivalCityName);
			//driver.findElement(By.xpath(RepositeriesFactory.to)).click();

			driver.findElement(By.xpath(RepositeriesFactory.ArrivalCityName)).sendKeys(aCity);
			//Thread.sleep(5000);
			List <WebElement> listTo = driver.findElements(By.xpath(RepositeriesFactory.autosearchList));
			listTo.get(0).click();

			WebElement departureInput = driver.findElement(By.xpath(RepositeriesFactory.departureDate));

			TestUtil.selectDateByJS(driver, departureInput, TestUtil.currentDate);
			TestUtil.waitForElement(driver,RepositeriesFactory.returnDate);

			WebElement arrivalinput = driver.findElement(By.xpath(RepositeriesFactory.returnDate));

			//Thread.sleep(5000);
			TestUtil.selectDateByJS(driver, arrivalinput, TestUtil.sevenplusreturnDate);
			arrivalinput.click();
			TestUtil.waitForElement(driver,RepositeriesFactory.searchButton);
			WebElement searchButton = driver.findElement(By.xpath(RepositeriesFactory.searchButton));
			TestUtil.safeJavaScriptClick(searchButton);
			driver.manage().deleteAllCookies();

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("popUp not found");

		}
		
		return new FlightResultPage();
		
		

	}

}


