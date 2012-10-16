package org.chandan.android.logmanager;

/**
 * Defines all associated constants for processing logs.
 *
 */
final class MyLogConstants {
	
	/**
	 * String representing tab length of '_'
	 */
	protected static String SINGLE_TAB_OF_LINES="_____";
	
	/**
	 * Tag name of the application.
	 */
	protected static String APP_TAG;

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
	 * Default way to process logs, i.e {@link LOG_TO#CONSOLE} 
	 */
	protected static final LOG_TO DEFAULT_LOG_TO=LOG_TO.CONSOLE;
	
	/**
	 * Default category for log i.e {@link LOG_TYPE#DEBUG} 
	 */
	protected static final LOG_TYPE DEFAULT_LOG_TYP=LOG_TYPE.DEBUG;
	
	
	
	/* ********************FILE STUFFS***********************/
	
	/**
	 * Text file extension.
	 */
	protected static final String FILE_EXTENSION_TEXT=".txt";
	
	/**
	 * Log file extension.
	 */
	protected static final String FILE_EXTENSION_LOG=".log";
	
	/**
	 * Default file name to which logs should be write to.
	 * <p>
	 * @see LOG_TO#FILE
	 */
	@SuppressWarnings("javadoc")
	protected static final String FILE_NAME_TO_SAVE_LOGS="MyLog"+FILE_EXTENSION_TEXT;
	
	/**
	 * Default DB file name to which logs should be write to.
	 * <p>
	 * @see LOG_TO#DB
	 */
	@SuppressWarnings("javadoc")
	protected static final String DB_NAME_TO_SAVE_LOGS="MyLog";
	
	
}
