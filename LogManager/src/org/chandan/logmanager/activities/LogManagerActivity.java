package org.chandan.logmanager.activities;

import org.chandan.android.logmanager.LOG_TO;
import org.chandan.android.logmanager.LOG_TYPE;
import org.chandan.android.logmanager.MyLogConfig;
import org.chandan.android.logmanager.MyLogController;

import android.app.Activity;
import android.os.Bundle;


/**
 * 
 * @author chandan
 *
 */
public class LogManagerActivity extends Activity {
	
	/**
	 * TAG name for this class.
	 */
	private static final String TAG=LogManagerActivity.class.getSimpleName();
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        MyLogConfig.setApplicationTag(getResources().getString(R.string.app_name));
        
        MyLogController.processLog(
        		LOG_TO.CONSOLE, LOG_TYPE.DEBUG,	TAG,"onCreate().");
        
        String sampleExceptionString=null;
        try{
        	//As below string points to nothing, this will through the exception..
        	sampleExceptionString.charAt(1);
        }catch (Exception exception) {
        	//Draw a line seperator..
        	MyLogController.feedSeperationLine(LOG_TO.CONSOLE);
			MyLogController.processException(
					LOG_TO.CONSOLE, TAG, exception);
			//Draw a line seperator..
			MyLogController.feedSeperationLine(LOG_TO.CONSOLE);
		}
    }
    
}