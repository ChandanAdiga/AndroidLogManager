package org.chandan.android.logmanager;

import java.io.File;

import android.content.Context;


/**
 * Configuring class for custom logging. 
 * <p>
 * NOTE: It is recommended to do initial configuration via {@link #initLogger(Context, boolean, String)} as soon as application starts. Generally in 
 * the first launching activity's onCreate() method.
 * <p.
 * Rest of the configurations can be done on requirement basis.
 * <p>
 * @author chandan, Oct 20, 2012, 12:54:03 PM
 */
public final class MyLogConfig {

	/**
	 * Application context used mostly for FILE operations.
	 */
	protected static Context CONTEXT;
	
	/**
	 * Tag name of the application.
	 */
	protected static String APP_TAG;
	
	/**
	 * Counter to log error message that permission denied.
	 */
	protected static int COUNTER_OF_CONFIG_ERROR_NOTIFICATION;
	
	/**
	 * Qualified file name to which logs should be write to.
	 */
	protected static String QUALIFIED_FILE_NAME_TO_SAVE_LOGS;
	
	/**
	 * Folder name to save logged files.
	 */
	protected static String FOLDER_NAME_TO_DUMP_LOG_FILE;
	
	/**
	 * Flag to enable/disable logs.
	 */
	protected static boolean FLAG_LOGGING_PERMITTED=Boolean.TRUE;
	
	/**
	 * Flag to enable/disable debug logs.
	 */
	protected static boolean FLAG_DEBUG_LOG_ENABLED=Boolean.TRUE && FLAG_LOGGING_PERMITTED;
	
	/**
	 * Flag to enable/disable informative logs.
	 */
	protected static boolean FLAG_INFO_LOG_ENABLED=Boolean.TRUE && FLAG_LOGGING_PERMITTED;
	
	/**
	 * Flag to enable/disable warning logs.
	 */
	protected static boolean FLAG_WARNING_LOG_ENABLED=Boolean.TRUE && FLAG_LOGGING_PERMITTED;
	
	/**
	 * Flag to enable/disable error/exception logs.
	 */
	protected static boolean FLAG_ERROR_LOG_ENABLED=Boolean.TRUE && FLAG_LOGGING_PERMITTED;
	
	/**
	 * Flag which authorizes log dump to file.
	 */
	protected static boolean FLAG_FILE_DUMP_ENABLED=Boolean.FALSE;
	
	/**
	 * Flag which authorizes log dump to DB.
	 */
	protected static boolean FLAG_DB_DUMP_ENABLED=Boolean.FALSE;
	
	/**
	 * StringBuilder used for logging to file. As file IO operations are costly processes,
	 * we temporarily store logs in StringBuilder, once its capacity reaches
	 * a threshold defined @ {@link MyLogConstants#STRING_BUFER_MAXIMUM_CAPACITY}, we do File writing/dumping.
	 */
	protected static StringBuilder STRING_BUILDER_FOR_FILE_LOGS;
	
	/**
	 * Initializes logging environment with minimal settings.
	 * @param context  Application context.
	 * @param isLoggingPermitted is logging permitted ? if not no logging will be done.
	 * @param applicationTag TAG used for logging.
	 * <p>
	 * @author chandan, Oct 20, 2012, 12:43:21 PM
	 */
	public static void initLogger(
			Context context,boolean isLoggingPermitted,final String applicationTag){
		CONTEXT=context;
		enableLoggingPermission(isLoggingPermitted);
		setApplicationTag(applicationTag);
		if(STRING_BUILDER_FOR_FILE_LOGS==null){
			STRING_BUILDER_FOR_FILE_LOGS=new StringBuilder();
		}
		
		//For time being..
		FOLDER_NAME_TO_DUMP_LOG_FILE=MyLogConstants.FOLDER_NAME_TO_DUMP_LOG_FILE;
		QUALIFIED_FILE_NAME_TO_SAVE_LOGS=MyLogConstants.DEFAULT_QUALIFIED_DUMP_FILE_NAME;
	}
	
	/**
	 * 
	 * @param applicationTag Application name if you wish to prefix with every tag.
	 * Usually <code> getResources().getString(R.string.app_name) </code>
	 * <p>
	 * chandan, Oct 16, 2012, 9:05:43 PM
	 */
	public static void setApplicationTag(final String applicationTag){
		APP_TAG=applicationTag;
	}
	
	/**
	 * Simply enables & disables logging permission. Note that you have to enable logging of 
	 * individual category if you are expecting that category to be logged out.
	 * @param enable Enables[true]/Disables[false] logging permission.
	 * chandan, Oct 20, 2012, 12:10:01 PM
	 */
	public static void enableLoggingPermission(boolean enable){
		FLAG_LOGGING_PERMITTED=enable;
	}
	
	/**
	 * Permits file dumping.
	 * @param enable true if file dumping is permitted else false.
	 * <p>
	 * @author chandan, Oct 20, 2012, 3:54:30 PM
	 */
	public static void enableFileDumping(boolean enable){
		FLAG_FILE_DUMP_ENABLED=enable;
	}
	
	/**
	 * Returns dump file path for further usage.
	 * NOTE: Prefix Context.getFilesDir() to return value for complete path.
	 * @return dump file path.
	 * <p>
	 * @author chandan, Oct 20, 2012, 3:57:56 PM
	 */
	public static String getDumpFilePath(){
		return ""+File.separator+FOLDER_NAME_TO_DUMP_LOG_FILE
				+File.separator+QUALIFIED_FILE_NAME_TO_SAVE_LOGS;
	}
	
	/**
	 * Ensure you have enabled logging permission via {@link #enableLoggingPermission(boolean)}
	 * @see #enableDebugLogs()
	 * @see #enableInfoLogs()
	 * @see #enableWarningLogs()
	 * @see #enableErrorLogs()
	 * @author chandan, Oct 20, 2012, 12:27:47 PM
	 */
	public static void enableAllLogs(){
		enableDebugLogs();
		enableInfoLogs();
		enableWarningLogs();
		enableErrorLogs();
	}
	
	/**
	 * Enables only debug logs.
	 * Ensure you have enabled {@link #enableLoggingPermission(boolean)}
	 * 
	 * <p>
	 * @author chandan, Oct 20, 2012, 12:28:12 PM
	 */
	public static void enableDebugLogs(){
		FLAG_DEBUG_LOG_ENABLED=FLAG_LOGGING_PERMITTED;
	}
	
	/**
	 * Enables only info logs.
	 * Ensure you have enabled {@link #enableLoggingPermission(boolean)}
	 * 
	 * <p>
	 * @author chandan, Oct 20, 2012, 12:28:12 PM
	 */
	public static void enableInfoLogs(){
		FLAG_INFO_LOG_ENABLED=FLAG_LOGGING_PERMITTED;
	}
	
	/**
	 * Enables only warning logs.
	 * Ensure you have enabled {@link #enableLoggingPermission(boolean)}
	 * 
	 * <p>
	 * @author chandan, Oct 20, 2012, 12:28:12 PM
	 */
	public static void enableWarningLogs(){
		FLAG_WARNING_LOG_ENABLED=FLAG_LOGGING_PERMITTED;
	}
	
	/**
	 * Enables only error logs.
	 * Ensure you have enabled {@link #enableLoggingPermission(boolean)}
	 * 
	 * <p>
	 * @author chandan, Oct 20, 2012, 12:28:12 PM
	 */
	public static void enableErrorLogs(){
		FLAG_ERROR_LOG_ENABLED=FLAG_LOGGING_PERMITTED;
	}
	
	//For time being lets don't give chance to the developer out there..:P
	/**
	 * Sets the file name to which all logs will be dumped for {@link DUMP_TO#FILE} mode. 
	 * @param fileName Simple valid file name without extension. 
	 * <p>
	 * @author chandan, Oct 20, 2012, 12:38:08 PM
	 */
	//public static void setFileNameToDumpLogs(final String fileName){
	//	FILE_NAME_TO_SAVE_LOGS=fileName==null?
	//				MyLogConstants.DEFAULT_FILE_NAME_TO_SAVE_LOGS:fileName;
	//}
	
	
	
	
}
