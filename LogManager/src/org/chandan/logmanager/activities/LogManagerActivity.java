package org.chandan.logmanager.activities;

import org.chandan.android.logmanager.DUMP_TO;
import org.chandan.android.logmanager.LOG_TYPE;
import org.chandan.android.logmanager.MyLogConfig;
import org.chandan.android.logmanager.MyLogController;

import android.app.Activity;
import android.os.Bundle;


/**
 * Demo activity class for custom logging.
 * chandan, Oct 20, 2012, 11:37:03 AM
 *
 */
public class LogManagerActivity extends Activity {
	
	/**
	 * TAG name for this class.
	 */
	private static final String TAG=LogManagerActivity.class.getSimpleName();
	
	/**
	 * Local flag to disable logs of this class.
	 */
	private static final boolean DEBUG=Boolean.TRUE;
	
    /** Called when the activity is first created. */
    @SuppressWarnings("null")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //[STANDARD_INTIALISATION_OF_LOG_CONFIG
        MyLogConfig.initLogger(getApplicationContext(),
        		true,getResources().getString(R.string.app_name));
        //STANDARD_INTIALISATION_OF_LOG_CONFIG]
        
        
        if(DEBUG){
        	MyLogController.processLog(
            		DUMP_TO.ALL, LOG_TYPE.DEBUG,	TAG,"onCreate()1.");
            MyLogController.processLog(
            		DUMP_TO.ALL, LOG_TYPE.DEBUG,	TAG,"onCreate()2.");
            MyLogController.processLog(
            		DUMP_TO.ALL, LOG_TYPE.DEBUG,	TAG,"onCreate()3.");            
        }
        
        String sampleExceptionString=null;
        try{
        	//As below string points to nothing, this will through the exception..
        	sampleExceptionString.charAt(1);
        }catch (Exception exception) {
        	if(DEBUG){
        		//Draw a line seperator..
            	MyLogController.feedSeperationLine(DUMP_TO.CONSOLE);
    			MyLogController.processException(
    					DUMP_TO.ALL, TAG, exception);
    			//Draw a line seperator..
    			MyLogController.feedSeperationLine(DUMP_TO.CONSOLE);
        	}        	
		}
    }
    
}