/**
 * 
 */
package com.smb.MMUtil.handler.xml;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

import com.smb.MMUtil.pojo.MySQLVariableDescription;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @author huangyi
 *
 */
public class ReadMySQLValueDescriptionXMLFile {
	
	private static Log logger = LogFactory.getLog(ReadMySQLValueDescriptionXMLFile.class);
	private static String mySQLValueDescriptionXMLFile = ReadMySQLValueDescriptionXMLFile.class.
							 getResource ("MySQLValueDescription.xml").getFile();
	
	
	private static String mySQLStatusDescriptionXMLFile = ReadMySQLValueDescriptionXMLFile.class.
	 getResource ("MySQLStatusDescription.xml").getFile();
	
	private static XStream xstream = new XStream(new DomDriver());
	private static MySQLVariableDescription   description= new MySQLVariableDescription();
	private static  Map cache= new HashMap ();
	private static String CacheVariableDescription="cacheVariableDescription";
	private static String CacheStatusDescription="cacheStatusDescription";
	
	public List getMySQLVariableDescription()  throws  Exception {
		logger.info( "get MySQLVariableDescription ....................." );
		FileInputStream input; 
		List <MySQLVariableDescription> list=null;
		try {
			if (cache.get(CacheVariableDescription)!=null){
				logger.info("Cache MySQL  Description XML File  ....................");
				list=(List<MySQLVariableDescription>) cache.get(CacheVariableDescription);
			}
			else{
				logger.info(" Read description ConfigFile XML File ....................");
				input = new FileInputStream(mySQLValueDescriptionXMLFile);
				xstream.alias("MySQLVariableDescription",  MySQLVariableDescription.class);
				list=(List<MySQLVariableDescription>) xstream.fromXML(input,description) ;
				cache.put(CacheVariableDescription, list);
			}
		
			} 
		catch ( Exception e) {
			logger.error(e);
		}
		return list;
	}
	
	public List getMySQLStatusDescription()  throws  Exception {
		logger.info( "get MySQLVariableDescription ....................." );
		FileInputStream input; 
		List <MySQLVariableDescription> list=null;
		try {
			if (cache.get(CacheStatusDescription)!=null){
				logger.info("Cache MySQL  Status Description XML File  ....................");
				list=(List<MySQLVariableDescription>) cache.get(CacheStatusDescription);
			}
			else{
				logger.info(" Read description Status ConfigFile XML File ....................");
				input = new FileInputStream(mySQLStatusDescriptionXMLFile);
				xstream.alias("MySQLVariableDescription",  MySQLVariableDescription.class);
				list=(List<MySQLVariableDescription>) xstream.fromXML(input,description) ;
				cache.put(CacheStatusDescription, list);
			}
		
			} 
		catch ( Exception e) {
			logger.error(e);
		}
		return list;
	}
	
	
	
	@Test
	public void runCase() throws  Exception{
		FileInputStream input= new FileInputStream(mySQLStatusDescriptionXMLFile);
		xstream.alias("MySQLVariableDescription",  MySQLVariableDescription.class);
		
		List <MySQLVariableDescription> list=(List<MySQLVariableDescription>) xstream.fromXML(input,description) ;
		
		System.out.println (list.get(1).getVariable_name() );
		System.out.println (list.get(1).getDescription() );
	}

}
