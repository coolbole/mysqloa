package com.smb.MMUtil.testcase.timer;

import java.util.TimerTask;

public class TimerTasker extends TimerTask {
	// 在这里写你要定时执行的方法
	public void run()  {
		System.out.println("Hello World!  " + new java.util.Date() );
	}
	}