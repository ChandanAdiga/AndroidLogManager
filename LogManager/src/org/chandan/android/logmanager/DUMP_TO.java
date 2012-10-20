package org.chandan.android.logmanager;

/**
 * Defines how log should be processed.
 * 
 * chandan, Oct 20, 2012, 11:35:22 AM
 *
 */
public enum DUMP_TO {
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
	 FILE,
	
	/**
	 * Process logs and writes to private log Data base.
	 */
	 //DB,
	 
	/**
	 * Process logs and writes to console as well as to a  file.
	 */
	CONSOLE_AND_FILE,
	 
	/**
	 * Process logs and writes to console as well as to DB.
	 */
	 //CONSOLE_AND_DB,
	 
	/**
	 * Process logs and writes to file as well as to DB.
	 */
	 //FILE_AND_DB,
	 
	/**
	 * Process logs and writes to console, file as well as to DB.
	 */
	 ALL
	
}
