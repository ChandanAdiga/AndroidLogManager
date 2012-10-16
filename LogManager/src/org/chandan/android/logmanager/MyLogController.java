package org.chandan.android.logmanager;

import android.util.Log;

/**
 * Controller class for processing logs. Its a static class which defines different
 * ways for processing variety of logs.
 * NOTE: Ensure that you have configured via {@link MyLogConfig}
 * @author chandan
 */
public final class MyLogController {
	
	/**
	 * Formats message to be logged.
	 * @param message message of the log
	 * @return formated message.
	 */
	private static String formatMessage(String message) {
		// FIXME Define the method
		return message;
	}

	/**
	 * Formats tag to be logged.
	 * @param tag tag of the log
	 * @return formated log.
	 */
	private static String formatTag(String tag) {
		// FIXME Define the method
		
		//DEBUGGING 
		tag=MyLogConstants.APP_TAG+"."+tag;
				
		return tag;
	}


	
	/**
	 * Special method which prints stack trace contained in an {@link Exception} object.
	 * @param logTo How logs should be processed
	 * @param tag TAG for the log/exception
	 * @param exception Instance of exception which has just occured.
	 * chandan, Oct 16, 2012, 9:09:55 PM
	 */
	public static void processException(LOG_TO logTo,String tag,Exception exception){
		
		//NOTE : By default, LOG_TYPE will be ERROR  for exception!
		//FIXME Define the method..
		
			
		tag=formatTag(tag);
		//Feed a separation line..
		feedSeperationLine(logTo);
		
		//Process exception..
		for(StackTraceElement element:exception.getStackTrace()){
			processLog(logTo, LOG_TYPE.ERROR, tag, element.toString());			
		}
		
		//Feed a separation line..
		feedSeperationLine(logTo);
	}
	
	
	/**
	* Specialized logging method which processes log further.
	 * @param logTo How logs should be processed
	 * @param logType Category to which this log belongs to.
	 * @param tag TAG for the log/exception
	 * @param message Message part of the log.
	 * chandan, Oct 16, 2012, 9:09:27 PM
	 */
	@SuppressWarnings("deprecation")
	public static void processLog(LOG_TO logTo, LOG_TYPE logType,String tag,String message){
		//FIXME Define the method..
		
		switch(logTo){
		
		case NONE:
			//Do nothing..
			break;
			
		case CONSOLE:
			//Dump logs to console..
			processConsoleLog(logType, tag, message);
			break;
			
		case FILE:
			//FIXME Define rest of logTo cases.. as they are currently deprecated.
			break;
			
		case DB:
			//FIXME Define rest of logTo cases.. as they are currently deprecated.
			break;
				
		case CONSOLE_AND_DB:
			//FIXME Define rest of logTo cases.. as they are currently deprecated.
			break;
			
		case CONSOLE_AND_FILE:
			//FIXME Define rest of logTo cases.. as they are currently deprecated.
			break;
			
		case FILE_AND_DB:
			//FIXME Define rest of logTo cases.. as they are currently deprecated.
			break;
	
		case ALL:
			//FIXME Define rest of logTo cases.. as they are currently deprecated.
			break;
		
			
		}
	}
	
	/**
	 * Specialized logging method which simply logs a line.This can be
	 * user for more readability of logs / categorize logs.
	 * @param logTo How line-log should be processed
	 */
	public static void feedSeperationLine(LOG_TO logTo){
		processLog(logTo, LOG_TYPE.DEBUG, 
				MyLogConstants.TAG_LINE_FEED, MyLogConstants.MESSAGE_LINE_FEED);
	}
	
	

	/**
	 * Processes log which are to dumped to log cat/console.
	 * @param logType Category to which this log belongs to.
	 * @param tag TAG for the log/exception
	 * @param message Message part of the log.
	 * chandan, Oct 16, 2012, 9:08:50 PM
	 */
	private static void processConsoleLog(LOG_TYPE logType,String tag,String message){
		
		tag=formatTag(tag);
		message=formatMessage(message);
		
		switch(logType){
			
			case DEBUG:
				Log.d(tag, message);
				break;
				
			case INFO:
				Log.i(tag, message);
				break;
				
			case WARNING:
				Log.w(tag, message);
				break;				
				
			case ERROR:
				Log.e(tag, message);
				break;
		}
		
	}

	
}
