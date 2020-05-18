package com.makeMyTrip.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.makeMyTrip.qa.base.TestBase;
import com.makeMyTrip.qa.pages.FlightResultPage;
import com.makeMyTrip.qa.pages.HomePage;
import com.makeMyTrip.qa.util.TestUtil;

public class FlightResultPageTest extends TestBase{
	
	HomePage homepage;
	TestUtil testutil;
	FlightResultPage flightresultpage;
	int[] counts;
	
	public FlightResultPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		intialization();
		driver.manage().deleteAllCookies();
		testutil=new TestUtil();
		homepage=new HomePage();
		homepage.selectFlightMenu("Flight");
		flightresultpage = homepage.tripPlaner(prop.getProperty("departureCity"),prop.getProperty("arrivalCity"));	
	}
	
	@Test
	  public void NoFilterFlightCountsTest() throws Exception{
		
			TestUtil.toBottomOfPage();
			counts = flightresultpage.totalnumberOfRecords();
			//System.out.println("Depature Flight count:"+counts[0]+"\nReturn Flight Count"+counts[1]); 
		System.out.println("Depature Flight count:"+counts[0]+"\nReturn Flight Count"+counts[1]);
	}
	
	public void NonStopFlightCountTest() throws Exception {
		TestUtil.toTopPage();
		flightresultpage.NonStopFlightCount();
		TestUtil.toBottomOfPage();
		flightresultpage.totalnumberOfRecords();
	}
	
	public void oneStopFlightCountTest() throws Exception {
		TestUtil.toTopPage();
		flightresultpage.oneStopFlightCount();
		TestUtil.toBottomOfPage();
		flightresultpage.totalnumberOfRecords();
		TestUtil.toTopPage();
		testutil.clearStopFilter();
		TestUtil.toBottomOfPage();
		TestUtil.toTopPage();
		
	
	}
	
}
