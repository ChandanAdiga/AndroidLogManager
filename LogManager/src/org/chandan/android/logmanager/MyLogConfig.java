package org.chandan.android.logmanager;


/**
 * Configuring class for custom logging.
 * @author chandan
 *
 */
public final class MyLogConfig {

	/**
	 * 
	 * @param applicationTag Application name if you wish to prefix with every tag.
	 * Usually <code> getResources().getString(R.string.app_name) </code>
	 * <p>
	 * chandan, Oct 16, 2012, 9:05:43 PM
	 */
	public static void setApplicationTag(final String applicationTag){
		MyLogConstants.APP_TAG=applicationTag;
	}
	
}
