package com.makeMyTrip.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.makeMyTrip.qa.base.TestBase;
import com.makeMyTrip.qa.pages.FlightResultPage;
import com.makeMyTrip.qa.pages.HomePage;
import com.makeMyTrip.qa.util.TestUtil;

public class HomePageTest extends TestBase {

	
	HomePage homepage;
	TestUtil testutil;
	FlightResultPage flightresultpage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		intialization();
		driver.manage().deleteAllCookies();
		testutil=new TestUtil();
		homepage=new HomePage();
	}
	
	@Test(priority = 1)
	public void ValidateHomePageTest() {
		homepage.validateTitle();
	}		
	
	@Test(priority = 2)
	public void tripPlanerTest()
	{
		homepage.selectFlightMenu("Flight");
		homepage.TripWay("two");
		flightresultpage = homepage.tripPlaner(prop.getProperty("departureCity"),prop.getProperty("arrivalCity"));		
	}
	
}
