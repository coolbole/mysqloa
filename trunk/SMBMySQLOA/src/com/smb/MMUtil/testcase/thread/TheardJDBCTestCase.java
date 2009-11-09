package com.smb.MMUtil.testcase.thread;

 

import com.smb.MMUtil.handler.drang.QueryDrangTestUtilTools;

public class TheardJDBCTestCase {
	
	public static void  main  (String [] agrs ){
			long start=System.currentTimeMillis();
			for (int i=0;i<1000;i++){
					new QueryDrangTestUtilTools ( ).start();
			}
		
			System.out.println (  System.currentTimeMillis()-start  );
			
	}

}
