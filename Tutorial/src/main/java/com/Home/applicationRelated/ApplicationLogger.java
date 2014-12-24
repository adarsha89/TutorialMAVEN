package com.Home.applicationRelated;

import org.slf4j.*;

public class ApplicationLogger {
	
	
	public  Logger logger = LoggerFactory.getLogger(ApplicationLogger.class);
	public ApplicationLogger() {
		// TODO Auto-generated constructor stub
		
	}
	 static  {
		 
	}
	 public  void assertLogEquals(Object expected, Object actual , String message)
	 {
		if(!expected.equals(actual))
		{
			logger.error(message);
		}
	 }
	 public  void assertLogNotEquals(Object expected, Object actual , String message)
	 {
		 if(expected.equals(actual))
		 {
			 logger.error(message);
		 }
	 }
	 public  void assertLogTrue(boolean expected, String message)
	 {
		 if(expected!=true)
		 {
			 logger.error(message);
		 }
	 }
	 public  void assertLogFalse(boolean expected, String message)
	 {
		 if(expected!=false)
			 {
			 logger.error(message);
			 }
	 }
	 public  void logInfo(String info)
	 {
		 logger.info(info);
	 }
	 public  void logError(String error)
	 {
		 logger.error(error);
	 }
	 public  void logErrorWithException(String error, Throwable throwable)
	 {
		 logger.error(error, throwable);
	 }
	 public  void logDebug(String info)
	 {
		 logger.debug(info);
	 }
	 public  void logDebugWithException(String info,Throwable exception)
	 {
		 logger.debug(info,exception);
	 }
}
