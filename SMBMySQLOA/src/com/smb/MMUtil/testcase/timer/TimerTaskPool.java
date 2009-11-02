/** 
* myTimeTask 指定执行的线程 
* date 指定第一次日期执行的时间
*  timestamp 指定每格多久再次执行一次
*/

package com.smb.MMUtil.testcase.timer;

import java.util.Date;
import java.util.Timer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.action.monitor.MailHostConfigUpdateViewAction;

public class TimerTaskPool {
	private static Log logger = LogFactory.getLog(MailHostConfigUpdateViewAction.class);
	
	private static Timer timer = new Timer();
	private static Date date = new Date();
	private static TimerTasker myTimeTask = new TimerTasker();
	private static boolean isRUN=false;
	private static long timeFrequency=0;
	
	public static boolean  getRunStatus () { return isRUN;  }
	public static long  getTimeFrequency () { return timeFrequency;  }
	
	public void execute(String  Timestamp) {
		long setTimestamp=new Long (Timestamp);
		
		try{
			if (setTimestamp==-1){
					logger.warn("\nStoped !!!!");
					timer.cancel();
					isRUN=false;
					 timeFrequency=0;
					}

			else{  
					 setTimestamp=(setTimestamp*1000)*60;
					 timeFrequency=setTimestamp;
					  timer.cancel();
					  logger.warn("\nReSet Timer  !!!!");
					  timer = new Timer();
					  myTimeTask = new TimerTasker();
					  timer.schedule(myTimeTask , date, setTimestamp);
					  isRUN=true;
			}
			}
			catch (Exception e){
				String ems=e.getMessage() ;
				logger.error(ems);
				if ("Timer already cancelled.".equals(ems)){
					 setTimestamp=(setTimestamp*1000)*60;
					  isRUN=true;
					  timeFrequency=setTimestamp;
					  timer = new Timer();
		    		  myTimeTask = new TimerTasker();
					  timer.schedule(myTimeTask , date, setTimestamp);
					}
				}
			}

	public static void main(String[] args) {
		TimerTaskPool t = new TimerTaskPool();
		t.execute("1000");	
		t.execute("-1");
	}
	}
