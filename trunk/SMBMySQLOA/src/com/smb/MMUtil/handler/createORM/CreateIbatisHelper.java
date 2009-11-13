package com.smb.MMUtil.handler.createORM;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class CreateIbatisHelper {
	 private static Log logger = LogFactory.getLog(CreateIbatisHelper.class);
	 private static CreateBaseHandler  baseHandler= new CreateBaseHandler();
	 private static String Spring_SQL_MAP_Path = CreateIbatisHelper.class.getResource ("ibatis/Spring-sql-map-config.xml").getFile();
	 private static String Spring_ApplicationContext_Path = CreateIbatisHelper.class.getResource ("ibatis/applicationContext.xml").getFile();
	 private static String iBATISPojo_Path = CreateIbatisHelper.class.getResource ("ibatis/iBATISPojo.xml").getFile();
	 private static String iBATIS_MAP_Path = CreateIbatisHelper.class.getResource ("ibatis/sql-map-config.xml").getFile();
	 
	 private static String SpringSQLMAPFile=baseHandler.getFiletoString(Spring_SQL_MAP_Path);
	 private static String SpringApplicationContextFile=baseHandler.getFiletoString(Spring_ApplicationContext_Path);
	 private static String iBATISPojoFile=baseHandler.getFiletoString(iBATISPojo_Path);
	 private static String iBATISMAPFile=baseHandler.getFiletoString(iBATIS_MAP_Path);
	 
	 private static String sqlMap_resource="<sqlMap resource=\"#PojoMapping.xml#\"/>";
	 
	 public String getSpringApplicationContextFile   ( String host,  String dbName,  String user, 
			  String pswd   ) throws Exception{
		    logger.info("getSpringApplicationContextFile ...................");
		 	SpringApplicationContextFile=SpringApplicationContextFile .
		 	replaceAll(CreateBaseHandler.username, user).
		 	replaceAll(CreateBaseHandler.password, pswd).
		 	replaceAll(CreateBaseHandler.dbhost, host).
		 	replaceAll(CreateBaseHandler.dbname, dbName);
		 
				return SpringApplicationContextFile;
	 }
	 
	 public String getSpringSQLMAPFile   ( String host,  String dbName,  String user, 
			  String pswd, String tabNames[] ,String packName    ) throws Exception{
		 logger.info("getSpringSQLMAPFile ...................");
		 	 StringBuffer sqlmapconfigxml= new StringBuffer();
		 	 sqlmapconfigxml.append(  SpringSQLMAPFile.split(sqlMap_resource)[0]  );
		 
			String getFMTpackName=baseHandler.getFMTpackName(packName);
			
			StringBuffer mapFile= new StringBuffer();
			for (int i=0;i<tabNames.length;i++){
				mapFile.append( "   ");
					String resource=sqlMap_resource.replaceAll( "#PojoMapping.xml#"  ,getFMTpackName+"/"+ tabNames[i]);
					mapFile.append( resource  ).append(" \n	");
			}
			
			 sqlmapconfigxml.append(mapFile);
		 	 
			 sqlmapconfigxml.append("</sqlMapConfig>");
			return sqlmapconfigxml.toString();
	 }
	 
	 
	 
	 
	 public String getiBATISMapFile   ( String host,  String dbName,  String user, 
			  String pswd, String tabNames[] ,String packName    ) throws Exception{
		 logger.info("getiBATISMapFile ...................");
		 StringBuffer sqlmapconfigxml= new StringBuffer();
		 
		 	iBATISMAPFile=iBATISMAPFile .
		 	replaceAll(CreateBaseHandler.username, user).
		 	replaceAll(CreateBaseHandler.password, pswd).
		 	replaceAll(CreateBaseHandler.dbhost, host).
		 	replaceAll(CreateBaseHandler.dbname, dbName);
		
		 	sqlmapconfigxml.append(    iBATISMAPFile .split(sqlMap_resource)[0]  );
		 	
			String getFMTpackName=baseHandler.getFMTpackName(packName);
			
			StringBuffer mapFile= new StringBuffer();
			for (int i=0;i<tabNames.length;i++){
					String resource=sqlMap_resource.replaceAll( "#PojoMapping.xml#"  ,getFMTpackName+"/"+ tabNames[i]);
					mapFile.append( resource  ).append("\n				");
			}
			
			sqlmapconfigxml.append(mapFile);
		
			sqlmapconfigxml.append(iBATISMAPFile .split(sqlMap_resource)[1]  );
		 
			return sqlmapconfigxml.toString();
	 }
	 
	  
	 public String iBATISPojoMAPXMLFile ( String tabName ,String packName ) throws Exception{
		 StringBuffer HibernateHBMFile=new StringBuffer(); 
		 logger.info("iBATISPojoMAPXMLFile ...................");
		 
		 String  UpperTable=tabName.substring(0,1).toUpperCase() +tabName.substring(1);
		 
		 String iBATISPojoXML=iBATISPojoFile
		 .replaceAll( "#Pojo#"  ,UpperTable)
		 .replaceAll( "#PackageAndPojo#"  , packName+"."+UpperTable);
		 
		 HibernateHBMFile.append(iBATISPojoXML);
		 return HibernateHBMFile.toString(); 
	 }
	 
	 
}
