package com.makeMyTrip.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.makeMyTrip.qa.Reports.LogStatus;
import com.makeMyTrip.qa.util.RepositeriesFactory;
import com.makeMyTrip.qa.util.TestUtil;

public class FlightResultPage {
	
	WebDriver driver;
	TestUtil testUtil;
	private String Depart_FlightPrice;
	private String Depart_Flightname;

	private String Arrival_FlightPrice;
	private String Arrival_Flightname;

	public String getDepart_FlightPrice() {
		return Depart_FlightPrice;
	}

	private void setDepart_FlightPrice(String depart_FlightPrice) {
		Depart_FlightPrice = depart_FlightPrice;
	}

	public String getDepart_Flightname() {
		return Depart_Flightname;
	}

	private void setDepart_Flightname(String depart_Flightname) {
		Depart_Flightname = depart_Flightname;
	}

	public String getArrival_FlightPrice() {
		return Arrival_FlightPrice;
	}

	private void setArrival_FlightPrice(String arrival_FlightPrice) {
		Arrival_FlightPrice = arrival_FlightPrice;
	}

	public String getArrival_Flightname() {
		return Arrival_Flightname;
	}

	public void setArrival_Flightname(String arrival_Flightname) {
		Arrival_Flightname = arrival_Flightname;
	}

	@FindBy(xpath="//div[@class='splitVw-sctn pull-left']//div[@class='fli-list splitVw-listing']")
	List<WebElement> departureFlights;
	
	@FindBy(xpath="//div[@class='splitVw-sctn pull-right']//div[@class='fli-list splitVw-listing']")
	List<WebElement> arrivalFlights;
	
	@FindBy(xpath="//div[@class='pull-right marL5 text-right']/p/span")
	List<WebElement> FlightPriceCheck;
	
	@FindBy(xpath="//span[@class='splitVw-total-fare']")
	WebElement totalFlightPrice;
	
	By selectPriceFlight=By.xpath("//p[@class='actual-price']");
	
	//initialise variables using constructor 
	public FlightResultPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//total departure flight count
	public int totalCountOfDepartureFlight() throws Exception {
		TestUtil.waitForElement(driver, RepositeriesFactory.nonStop);
		TestUtil.toBottomOfPage();
		if(departureFlights.size()<1) {
			LogStatus.fail("Flights not found");
			throw new Exception("No Flight found");
		}
		return departureFlights.size();
	}
	
	//total return flight count
	public int totalCountOfArrivalFlight() throws Exception {
		TestUtil.waitForElement(driver, RepositeriesFactory.nonStop);
		TestUtil.toTopPage();
		if(arrivalFlights.size()<1) {
			LogStatus.fail("Flights not found");
			throw new Exception("Flights not found");
		}
		return arrivalFlights.size();
	}
	
	//total number of flights records with no filters applied
	public int[] totalnumberOfRecords() throws Exception {
		TestUtil.waitForElement(driver, RepositeriesFactory.clearFilters);
		driver.findElement(By.xpath(RepositeriesFactory.clearFilters)).click();
		int[] count = new int[2];
		count[0]=totalCountOfDepartureFlight();
		count[1]=totalCountOfArrivalFlight();
		return count;
	}
	
	//total number of flights with nonStopOption
	public int[] NonStopFlightCount() throws Exception
	{
		testUtil.clearStopFilter();
		driver.findElement(By.xpath(RepositeriesFactory.nonStop)).click();
		int[] countnonStop=new int[2];
		countnonStop[0]=totalCountOfDepartureFlight();
		countnonStop[1]=totalCountOfArrivalFlight();
		return countnonStop;
	}
	
	//total number of flights with onestopOption
		public int[] oneStopFlightCount() throws Exception
		{
			testUtil.clearStopFilter();
			driver.findElement(By.xpath(RepositeriesFactory.oneStop)).click();
			int[] countOneStop=new int[2];
			countOneStop[0]=totalCountOfDepartureFlight();
			countOneStop[1]=totalCountOfArrivalFlight();
			return countOneStop;
		}
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
