package org.chandan.android.logmanager;

import java.util.Calendar;

import android.util.Log;

/**
 * Controller class for processing logs. Its a static class which defines different
 * ways for processing variety of logs.
 * <p>
 * NOTE: Ensure that you have configured logging via {@link MyLogConfig}
 * 
 * @author chandan, Oct 20, 2012, 12:51:53 PM
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
	 * @param addTimeStamp Should add time stamp? Usually for File/DB logging you may use timeStamp
	 * @return formated log.
	 */
	private static String formatTag(String tag,boolean addTimeStamp) {
			
		tag=(addTimeStamp?getTimeStamp():"")
					+MyLogConfig.APP_TAG+"."+tag;
				
		return tag;
	}
	
	/**
	 * Prepares time stamp in FORMAT: [YYYY:MM:DD-HH:MM:SS:MMM] 
	 * @return formated tiem stamp
	 * <p>
	 * @author chandan, Oct 20, 2012, 1:13:24 PM
	 */
	private static String getTimeStamp(){
		
		String timeStamp="";
		Calendar timeInstance=Calendar.getInstance();
		//Now prepare FORMAT: [YYYY:MM:DD-HH:MM:SS:MMM]
		timeStamp="["
				+timeInstance.get(Calendar.YEAR)
				+":"+(timeInstance.get(Calendar.MONTH)<10?"0"+timeInstance.get(Calendar.MONTH):timeInstance.get(Calendar.MONTH))
				+":"+(timeInstance.get(Calendar.DAY_OF_MONTH)<10?"0"+timeInstance.get(Calendar.DAY_OF_MONTH):timeInstance.get(Calendar.DAY_OF_MONTH))
				+"-"+(timeInstance.get(Calendar.HOUR_OF_DAY)<10?"0"+timeInstance.get(Calendar.HOUR_OF_DAY):timeInstance.get(Calendar.HOUR_OF_DAY))
				+":"+(timeInstance.get(Calendar.MINUTE)<10?"0"+timeInstance.get(Calendar.MINUTE):timeInstance.get(Calendar.MINUTE))
				+":"+(timeInstance.get(Calendar.SECOND)<10?"0"+timeInstance.get(Calendar.SECOND):timeInstance.get(Calendar.SECOND))
				+":"+(timeInstance.get(Calendar.MILLISECOND)<10?"0"+timeInstance.get(Calendar.MILLISECOND):timeInstance.get(Calendar.MILLISECOND))
				+"]";
		
		//Finally
		return timeStamp;
	}


	
	/**
	 * Special method which prints stack trace contained in an {@link Exception} object.
	 * @param logTo How logs should be processed
	 * @param tag TAG for the log/exception
	 * @param exception Instance of exception which has just occured.
	 * chandan, Oct 16, 2012, 9:09:55 PM
	 */
	public static void processException(DUMP_TO logTo,String tag,Exception exception){
		
		//NOTE : By default, LOG_TYPE will be ERROR  for exception!
		//FIXME Define the method..
					
		//Feed a separation line..
		feedSeperationLine(logTo);
		
		//Process exception..
		processLog(logTo, LOG_TYPE.ERROR, tag,exception.toString());
		for(StackTraceElement element:exception.getStackTrace()){
			processLog(logTo, LOG_TYPE.ERROR, tag, element.toString());			
		}
		
		//Feed a separation line..
		feedSeperationLine(logTo);
	}
	
	
	/**
	* Specialized logging method which processes log further.
	 * @param dumpLogTo How logs should be dumped
	 * @param logType Category to which this log belongs to.
	 * @param tag TAG for the log/exception
	 * @param message Message part of the log.
	 * chandan, Oct 16, 2012, 9:09:27 PM
	 */
	public static void processLog(DUMP_TO dumpLogTo, LOG_TYPE logType,String tag,String message){
		//FIXME Define the method..
		if(!MyLogConfig.FLAG_LOGGING_PERMITTED){
			if(MyLogConfig.COUNTER_OF_CONFIG_ERROR_NOTIFICATION<1){
				processConsoleLog(LOG_TYPE.ERROR, MyLogConstants.TAG_LOG_CONFIG_ERROR,
						MyLogConstants.MESSAGE_LOGGING_IS_NOT_PERMITTED_ERROR);
			}
			
			return;
		}
		
		//Evaluate
		dumpLogTo=dumpLogTo==null?DUMP_TO.CONSOLE:dumpLogTo;
		logType=logType==null?LOG_TYPE.DEBUG:logType;
		
		switch(dumpLogTo){
		
		case NONE:
			//Do nothing..
			break;
			
		case CONSOLE:
			//Dump logs to console..
			processConsoleLog(logType, tag, message);
			break;
			
		case FILE:
			//FIXME Define rest of logTo cases.. as they are currently deprecated.
			processFileLog(logType,tag,message);
			break;
			
		//case DB:
		//	//FIXME Define rest of logTo cases.. as they are currently deprecated.
		//	break;
				
		//case CONSOLE_AND_DB:
		//	//FIXME Define rest of logTo cases.. as they are currently deprecated.
		//	processConsoleLog(logType, tag, message);
		//	break;
			
		case CONSOLE_AND_FILE:
			//FIXME Define rest of logTo cases.. as they are currently deprecated.
			processConsoleLog(logType, tag, message);
			processFileLog(logType, tag, message);
			break;
			
		//case FILE_AND_DB:
		//	//FIXME Define rest of logTo cases.. as they are currently deprecated.
		//	break;
	
		case ALL:
			//FIXME Define rest of logTo cases.. as they are currently deprecated.
			processConsoleLog(logType, tag, message);
			processFileLog(logType, tag, message);			
			break;
		
			
		}
	}
	
	/**
	 * Specialized logging method which simply logs a line.This can be
	 * user for more readability of logs / categorize logs.
	 * @param dumpLogTo How line-log should be processed
	 */
	public static void feedSeperationLine(DUMP_TO dumpLogTo){
		processLog(dumpLogTo, LOG_TYPE.DEBUG, 
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
		
		tag=formatTag(tag,false);
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
	
	/**
	 * Processes log which are to dumped to log cat/console.
	 * @param logType Category to which this log belongs to.
	 * @param tag TAG for the log/exception
	 * @param message Message part of the log.
	 * chandan, Oct 16, 2012, 9:08:50 PM
	 */
	private static void processFileLog(LOG_TYPE logType,String tag,String message){
		
		if(!MyLogConfig.FLAG_FILE_DUMP_ENABLED){
			processLog(DUMP_TO.CONSOLE,LOG_TYPE.ERROR, MyLogConstants.TAG_LOG_CONFIG_ERROR,
					"File dump is not permitted. Kindly configure as per requirment.");
			
			return;
		}
		tag=logType.name()+formatTag(tag,true);
		message=formatMessage(message);
		
		if(MyLogConfig.STRING_BUILDER_FOR_FILE_LOGS==null){
			MyLogConfig.STRING_BUILDER_FOR_FILE_LOGS=new StringBuilder();
		}
				
		MyLogConfig.STRING_BUILDER_FOR_FILE_LOGS.append(
				"\n"
				+tag
				+": "+message);
		
		//Finally evaluate its capacity & handle the situation..
		if(MyLogConfig.STRING_BUILDER_FOR_FILE_LOGS.length()
					>MyLogConstants.STRING_BUFER_MAXIMUM_CAPACITY){
			
			new AsyncTaskDumpToFile().execute(MyLogConfig.STRING_BUILDER_FOR_FILE_LOGS);
			
			MyLogConfig.STRING_BUILDER_FOR_FILE_LOGS=null;
			MyLogConfig.STRING_BUILDER_FOR_FILE_LOGS=new StringBuilder();
			
		}
	}
	
	

	
}
