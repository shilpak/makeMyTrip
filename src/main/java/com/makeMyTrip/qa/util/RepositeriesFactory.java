package com.makeMyTrip.qa.util;

import com.makeMyTrip.qa.base.TestBase;

public class RepositeriesFactory extends TestBase {
	public static String optionsList = "//ul[@class='makeFlex font12']/li";
	public static String roundTripRadioButton = "//ul//li[text()='Round Trip']/child::span";
	public static String oneWayTripRadioButton = "//ul//li[text()='Oneway']";
	public static String multipleCityButton = "//ul//li[text()='Multi City']";
	public static String from="//input[@id='fromCity']";
	public static String DepartCityName="//input[@placeholder='From']";	
	public static String to = "//input[@id='toCity']";
	public static String ArrivalCityName = "//input[@placeholder='To']";
	public static String close="//*[@id='webklipper-publisher-widget-container-notification-close-div']";
	public static String autosearchList = "//ul[@class='react-autosuggest__suggestions-list']//li";
	public static String departureDate = "//span[text()='DEPARTURE']";
	public static String returnDate = "//span[text()='RETURN']";
	public static String searchButton = "//a[contains(text(), 'Search')]";
	public static String nonStop = "//span[text()='Non Stop']/preceding-sibling::span";
	public static String oneStop = "//span[text()='1 Stop']/preceding-sibling::span";
	public static String clearFilters = "//div[@id='fli_filter__stops']//a[@class='pull-right reset-filter'][contains(text(),'Reset')]";

	
	


	
}
