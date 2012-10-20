package org.chandan.android.logmanager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import android.os.AsyncTask;


/**
 * Performs file dumping process asynchronously..
 * 
 * <p>
 * @author chandan, Oct 20, 2012, 2:44:09 PM
 */
final class AsyncTaskDumpToFile extends AsyncTask<StringBuilder, Void, Void>{

	/* (non-Javadoc)
	 * @see android.os.AsyncTask#doInBackground(Params[])
	 */
	@Override
	protected Void doInBackground(StringBuilder... params) {
		final StringBuilder content=params[0];			
		
		if(content!=null && MyLogConfig.CONTEXT!=null){											
			try {
				File dumpFolder=new File(
						MyLogConfig.CONTEXT.getFilesDir()
						+File.separator
						+MyLogConfig.FOLDER_NAME_TO_DUMP_LOG_FILE);
				if(!dumpFolder.exists()){
					dumpFolder.mkdirs();
				}
				
								
				File dumpFile=new File(
						MyLogConfig.CONTEXT.getFilesDir()
						+File.separator
						+MyLogConfig.FOLDER_NAME_TO_DUMP_LOG_FILE
						+File.separator
						+MyLogConfig.QUALIFIED_FILE_NAME_TO_SAVE_LOGS);	
				
				//[DEBUGGED:CONTENT_WAS_NOT_APPENDING
				if(!dumpFile.exists()){
					dumpFile.createNewFile();					
				}				
				//FileOutputStream fos=new FileOutputStream(dumpFile);
				//fos.write(content.toString().getBytes());
				//fos.close();
				
				MyLogController.processLog(DUMP_TO.NONE,LOG_TYPE.WARNING, MyLogConstants.TAG_LOG_CONFIG_ERROR,
						"Appending to file:"+content.toString());
				FileWriter logFileWriter=new FileWriter(dumpFile,true);//Set append mode..
				BufferedWriter bufferedWriter=new BufferedWriter(logFileWriter);
				bufferedWriter.write(content.toString());
				bufferedWriter.close();
				logFileWriter.close();				
				//DEBUGGED:CONTENT_WAS_NOT_APPENDING]
									
			} catch (FileNotFoundException exception) {
				MyLogController.processException(DUMP_TO.CONSOLE, MyLogConstants.TAG_LOG_CONFIG_ERROR, exception);
			} catch (IOException exception) {
				MyLogController.processException(DUMP_TO.CONSOLE, MyLogConstants.TAG_LOG_CONFIG_ERROR, exception);
			}
		}
		
		return null;
	}
	
}