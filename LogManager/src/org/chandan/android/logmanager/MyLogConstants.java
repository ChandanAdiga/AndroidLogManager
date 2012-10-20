package org.chandan.android.logmanager;

/**
 * Defines all associated constants for processing logs.
 * <p>
 * @author chandan, Oct 20, 2012, 12:57:08 PM
 */
final class MyLogConstants {
	
	/**
	 * String representing tab length of '_'
	 */
	protected static String SINGLE_TAB_OF_LINES="_____";
	
	/**
	 * As length() returns maximum integer value, we will put check near to
	 * Integer's maximum value. If this check exceeds we will dump all string to
	 * the file.
	 */
	protected static final int STRING_BUFER_MAXIMUM_CAPACITY=Integer.MAX_VALUE-100000;
	
	/**
	 * Tag for line feed.
	 */
	protected static final String TAG_LINE_FEED=SINGLE_TAB_OF_LINES;
	
	/**
	 * Message for line feed.
	 */
	protected static final String MESSAGE_LINE_FEED=SINGLE_TAB_OF_LINES+SINGLE_TAB_OF_LINES
			+SINGLE_TAB_OF_LINES+SINGLE_TAB_OF_LINES+SINGLE_TAB_OF_LINES;
	
	
	/**
	 * Default way to process logs, i.e {@link DUMP_TO#CONSOLE} 
	 */
	protected static final DUMP_TO DEFAULT_LOG_TO=DUMP_TO.CONSOLE;
	
	/**
	 * Default category for log i.e {@link LOG_TYPE#DEBUG} 
	 */
	protected static final LOG_TYPE DEFAULT_LOG_TYP=LOG_TYPE.DEBUG;
	
	/**
	 * 
	 */
	protected static final String TAG_LOG_CONFIG_ERROR="MyLogConfig";
	
	/**
	 * Error message  for logging permission denial
	 */
	protected static final String MESSAGE_LOGGING_IS_NOT_PERMITTED_ERROR="Permission denied! To enable logging, kindly enable logging permission";
	
	/* ********************FILE STUFFS***********************/
	
	/**
	 * Folder name to dump log files.
	 */
	protected static final String FOLDER_NAME_TO_DUMP_LOG_FILE="LOGS";
	
	/**
	 * Text file extension.
	 */
	private static final String DEFAULT_DUMP_FILE_NAME="MyLog";
	
	/**
	 * Text file extension.
	 */
	protected static final String TEXT_FILE_EXTENSION=".txt";
	
	/**
	 * Log file extension.
	 */
	protected static final String LOG_FILE_EXTENSION=".log";
	
	/**
	 * Default qualified file name to which logs should be write to.
	 * <p>
	 * @see DUMP_TO#FILE
	 */
	protected static final String DEFAULT_QUALIFIED_DUMP_FILE_NAME=DEFAULT_DUMP_FILE_NAME+TEXT_FILE_EXTENSION;
	
	/**
	 * Default DB file name to which logs should be write to.
	 * 
	 */
	protected static final String DEFAULT_DB_NAME="MyLog";
	
	
}
