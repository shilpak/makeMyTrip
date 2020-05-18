package com.makeMyTrip.qa.Reports;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtendReport {
	
	public static ExtentReports report=null;
	public static ExtentTest logger=null;

	//private constructor to limit initialization to one
	private ExtendReport()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyy_ hh_mm_ss");
		Date date = new Date();
		String currentDate = formatter.format(date);
		
		report=new ExtentReports(".\\ExtentReports\\Test Report_"+currentDate+".html");
		report.loadConfig(new File(".\\src//main//resources//extentreport.xml"));
	}
	//Initializes Report
	public static void initialize()
	{
		ExtendReport report=new ExtendReport();
	}

}
