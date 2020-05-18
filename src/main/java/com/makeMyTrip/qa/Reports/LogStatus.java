package com.makeMyTrip.qa.Reports;

public class LogStatus {
	
	//Methods to log test data into Report
		private LogStatus()
		{
			//Private constructor to prevent initialization of class
		}
		public static void pass(String message)
		{
			ExtendReport.logger.log(com.relevantcodes.extentreports.LogStatus.PASS, message);
		}
		
		public static void fail(String message)
		{
			ExtendReport.logger.log(com.relevantcodes.extentreports.LogStatus.FAIL, message);
		}
		
		public static void fail(Exception message)
		{
			ExtendReport.logger.log(com.relevantcodes.extentreports.LogStatus.FAIL, message);
		}
		
		public static void fail(AssertionError a)
		{
			ExtendReport.logger.log(com.relevantcodes.extentreports.LogStatus.FAIL, a);
		}
		
		public static void info(String message)
		{
			ExtendReport.logger.log(com.relevantcodes.extentreports.LogStatus.INFO, message);
		}
		
		public static void error(String message)
		{
			ExtendReport.logger.log(com.relevantcodes.extentreports.LogStatus.ERROR, message);
		}
		
		public static void fatal(String message)
		{
			ExtendReport.logger.log(com.relevantcodes.extentreports.LogStatus.FATAL, message);
		}
		
		public static void skip(String message)
		{
			ExtendReport.logger.log(com.relevantcodes.extentreports.LogStatus.SKIP, message);
		}
		
		public static void unknown(String message)
		{
			ExtendReport.logger.log(com.relevantcodes.extentreports.LogStatus.UNKNOWN, message);
		}
		
		public static void warning(String message)
		{
			ExtendReport.logger.log(com.relevantcodes.extentreports.LogStatus.WARNING, message);
		}

}
