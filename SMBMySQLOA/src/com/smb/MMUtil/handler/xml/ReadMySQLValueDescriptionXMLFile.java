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

import com.smb.MMUtil.pojo.MySQLVariableDescription;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @author huangyi
 *
 */
public class ReadMySQLValueDescriptionXMLFile {
	
	private static Log logger = LogFactory.getLog(ReadMySQLValueDescriptionXMLFile.class);
	private static String databaseConfigFile = ReadMySQLValueDescriptionXMLFile.class.
							 getResource ("MySQLValueDescription.xml").getFile();
	
	private static XStream xstream = new XStream(new DomDriver());
	private static MySQLVariableDescription   Description= new MySQLVariableDescription();
	private static  Map cache= new HashMap ();
	
	public List getMySQLVariableDescription()  throws  Exception {
		logger.info( "getMySQLVariableDescription ....................." );
		FileInputStream input; 
		List <MySQLVariableDescription> list=null;
		try {
			if (cache.get("cache")!=null){
				logger.info("Cache MySQL  Description XML File  ....................");
				list=(List<MySQLVariableDescription>) cache.get("cache");
			}
			else{
				logger.info(" Read XML File ....................");
				input = new FileInputStream(databaseConfigFile);
				xstream.alias("MySQLVariableDescription",  MySQLVariableDescription.class);
				list=(List<MySQLVariableDescription>) xstream.fromXML(input,Description) ;
				cache.put("cache", list);
			}
		
			} 
		catch ( Exception e) {
			logger.error(e);
		}
		return list;
	}
	
	
//	@Test
//	public void runCase() throws  Exception{
//		FileInputStream input= new FileInputStream(databaseConfigFile);
//		xstream.alias("MySQLVariableDescription",  MySQLVariableDescription.class);
//		
//		List <MySQLVariableDescription> list=(List<MySQLVariableDescription>) xstream.fromXML(input,Description) ;
//		
//		System.out.println (list.get(1).getVariable_name() );
//		System.out.println (list.get(1).getDescription() );
//	}

}
