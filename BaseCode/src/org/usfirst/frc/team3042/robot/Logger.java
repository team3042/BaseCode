package org.usfirst.frc.team3042.robot;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Logger extends FileIO {
	private static final String FILE_DATE_FORMAT = "yyyy-MM-dd-hhmmss";
	private static final String LOG_TIME_FORMAT = "hh:mm:ss:SS";
	
	boolean useConsole;
	boolean useFile;
	int level;
	
	private static final String path = "/home/lvusers/logs/";
	
	public Logger(boolean useConsole,boolean useFile,int level) {
		if(useFile) {
			Date now = new Date();
			SimpleDateFormat fileTimeStamp = new SimpleDateFormat(FILE_DATE_FORMAT);
			fileTimeStamp.setTimeZone(TimeZone.getTimeZone("America/Chicago"));
			String filename = fileTimeStamp.format(now);
			this.openFile(path, filename);
	
		}
	}
	public void log(String message, int level) {
			
		if(level <= this.level) {
			String cls = Thread.currentThread().getStackTrace()[2].getClassName();
			int i = cls.lastIndexOf(".") + 1;
			cls = cls.substring(i);
				
			message = "[" + cls + "] " + message;
				
			Date now = new Date();
			SimpleDateFormat logTimeStamp = new SimpleDateFormat(LOG_TIME_FORMAT);
			logTimeStamp.setTimeZone(TimeZone.getTimeZone("America/Chicago"));
			String time = logTimeStamp.format(now);			
							
			message = time + "\t" + message;
				
			if(useFile) {
				this.writeToFile(message)     ;
			}
			if(useConsole) {
				System.out.println(message);
			}
		}
	}
}

