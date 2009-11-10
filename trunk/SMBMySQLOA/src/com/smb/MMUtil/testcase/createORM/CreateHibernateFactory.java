package com.smb.MMUtil.testcase.createORM;
 
import java.util.List;

import com.smb.MMUtil.pojo.MySQLShowColumns;

 

public class CreateHibernateFactory {
	
	 private static String hibernate_cfg_xml_Path = TestCaseCreateORMFile.class.getResource ("hibernate/hibernate.cfg.xml").getFile();
	 private static String hibernate_hbm_xml_Path = TestCaseCreateORMFile.class.getResource ("hibernate/hibernate.hbm.xml").getFile();
	 private static CreateBaseHandler  baseHandler= new CreateBaseHandler();
	 
	 private static String mapping_resource="<mapping resource=\"\"/>";
	 private static  String hibernate_hbm_xml_content=baseHandler.getFiletoString(hibernate_hbm_xml_Path) ;
	 private static  String hibernate_cfg_xml_content=baseHandler.getFiletoString(hibernate_cfg_xml_Path) ;
	 
	 public void HibernateCFGFile (String host,  String dbName,  String user, 
			 			  String pswd, String tabNames[] ,String packName  ) throws Exception{
		 	
		 
		 StringBuffer HibernateCFGFile=new StringBuffer(); 
		 try{
					  
			 		 hibernate_cfg_xml_content.replaceAll("#dbhost#", host) 	
					 .replaceAll("#dbname#", dbName)  
					 .replaceAll("#username#", user)   
					 .replaceAll("#password#", pswd) ;
					 
					  
					 
					 HibernateCFGFile.append(  hibernate_cfg_xml_content.split(mapping_resource)[0] );
					 
					String getFMTpackName=baseHandler.getFMTpackName(packName);
					
					 for (int i=0;i<tabNames.length;i++){
						 HibernateCFGFile.append( "<mapping resource=\""+getFMTpackName+"/"+tabNames[i]+"\"/>" );
						 HibernateCFGFile.append( "\n		");
					 }
					 HibernateCFGFile.append( hibernate_cfg_xml_content.split(mapping_resource)[1]);
					 
					 System.out.println (HibernateCFGFile); 
					 
		 	}
		 	catch (Exception e){
		 		 throw new Exception (e);
		 	}
		 
	 }
		
	 public void HibernateHBMFile ( String tabNames[] ,String packName , List <MySQLShowColumns> list) throws Exception{
		 String tabName=tabNames[0];
		 
		 StringBuffer HibernateHBMFile=new StringBuffer(); 
		
		
		
		 hibernate_hbm_xml_content
		.replaceAll("#pojoNameAndpackageName#", packName+"."+tabName)
		.replaceAll("#tableName#", tabName);
		
		String pojoIdName="";
			
		for (int i=0;i<list.size();i++){
				if (list.get(i).getKey().equals("PRI")   ){
					pojoIdName=list.get(i).getField()    ;
				}
		}
		
		hibernate_hbm_xml_content=hibernate_hbm_xml_content.replaceAll("#pojoIdName#", pojoIdName).replaceAll("#columnIDName#", pojoIdName);
		 
		System.out.println (hibernate_hbm_xml_content ); 
		 
		 
	 }
	}

 
