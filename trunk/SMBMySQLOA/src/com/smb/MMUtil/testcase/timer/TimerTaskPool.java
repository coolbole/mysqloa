/** *//**
	* myTimeTask 指定执行的线程 date 指定第一次日期执行的时间 timestamp 指定每格多久再次执行一次
	*/
package com.smb.MMUtil.testcase.timer;

import java.util.Date;
import java.util.Timer;

public class TimerTaskPool {
	static Timer timer = new Timer();
	static Date date = new Date();
	static TimerTasker myTimeTask = new TimerTasker();
	
	public void execute(String  Timestamp) {
	long setTimestamp=new Long (Timestamp);

	try{
	
	if (setTimestamp==-1){
		System.out.println("Stoped !!!!");
		timer.cancel();
	}
	else if (setTimestamp==0){
		
		long timestamp = 1000;
		timer.schedule(myTimeTask, date, timestamp);
	}
	else{  
		 System.out.println("ReSet Timer  !!!!");
		timer.schedule(myTimeTask , date, setTimestamp);
	}
	}
	catch (Exception e){
		String dd=e.getMessage() ;
		System.out.println(" ====== "+dd);
		if ("Timer already cancelled.".equals(dd)){
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
