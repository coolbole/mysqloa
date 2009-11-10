package com.smb.MMUtil.testcase.createORM;

import java.util.ArrayList;
import java.util.List;

import com.smb.MMUtil.pojo.CreateORMPojo;
import com.smb.MMUtil.pojo.MySQLShowColumns;

 

public class CreateORMFileFactory {
	
	 private static CreateHibernateHelper ceateHibernateHelper= new CreateHibernateHelper();
	 
	  
	@SuppressWarnings("unchecked")
	public CreateORMPojo factoryCreateORMPojo  (String host,  String dbName,  String user, 
			  String pswd, String tabNames[] ,String packName,String createORMID,List  tables) throws Exception{
		
		 CreateORMPojo   ORMPojo=null;
		 
		 if (createORMID.equals("hibernate")){
					 ORMPojo= new CreateORMPojo();
					 ORMPojo.setCreateType(createORMID);
					 ORMPojo.setSpringFile("");
					 String ormCFGFile=ceateHibernateHelper.HibernateCFGFile(host, dbName, user, pswd, tabNames, packName);
					 ORMPojo.setOrmCFGFile( ormCFGFile );
					
					 List ormMappingFiles= new ArrayList ();
					 for (int i=0;i<tables.size();i++){
						 String ormMappingFile=ceateHibernateHelper.HibernateHBMFile(tabNames[i], packName, 
								 (List<MySQLShowColumns>) tables.get(i) );
						 ormMappingFiles.add( ormMappingFile  );
					 }
		 			 ORMPojo.setOrmMappingFiles(ormMappingFiles);
		 }
		 
		 
		 
		 
		return ORMPojo;
		
	 }
		
		
	}

 
