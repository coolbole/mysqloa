package com.smb.MMUtil.testcase.createORM;

import java.util.List;

 

public class CreateORMFileFactory {
	
	 private static CreateHibernateFactory createHibernateFactory= new CreateHibernateFactory();
	 
	 public void Factory (String host,  String dbName,  String user, 
			  String pswd, String tabNames[] ,String packName,String createORMID,List list) throws Exception{
		 
		 if (createORMID.equals("hibernate")){
			 createHibernateFactory.HibernateCFGFile(host, dbName, user, pswd, tabNames, packName);
			 System.out.println ("---------========================--------------"); 
			 createHibernateFactory.HibernateHBMFile(tabNames, packName,list );
		 }
	 }
		
		
	}

 
