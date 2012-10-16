package org.chandan.android.logmanager;


/**
 * Defines how log should be processed.
 * 
 * @author chandan
 *
 */
public enum LOG_TO {
	/**
	 * Logs will not be processed at all!
	 */
	 NONE,

	/**
	 * Processes logs and displays in console/logcat.
	 */
	 CONSOLE,
	
	/**
	 * Processes logs and writes to a file in application sync.
	 */
	@Deprecated
	 FILE,
	
	/**
	 * Process logs and writes to private log Data base.
	 */
	@Deprecated
	 DB,
	 
	/**
	 * Process logs and writes to console as well as to a  file.
	 */
	@Deprecated
	CONSOLE_AND_FILE,
	 
	/**
	 * Process logs and writes to console as well as to DB.
	 */
	@Deprecated
	 CONSOLE_AND_DB,
	 
	/**
	 * Process logs and writes to file as well as to DB.
	 */
	 @Deprecated
	 FILE_AND_DB,
	 
	/**
	 * Process logs and writes to console, file as well as to DB.
	 */
	 @Deprecated
	 ALL
	
}
