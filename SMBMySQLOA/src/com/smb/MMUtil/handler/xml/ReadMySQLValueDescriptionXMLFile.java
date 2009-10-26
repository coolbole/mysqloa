/**
 * 
 */
package com.smb.MMUtil.handler.xml;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.smb.MMUtil.pojo.MySQLAutoConfigCase;
import com.smb.MMUtil.pojo.MySQLOptimizeCase;
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
	
	private static String mySQLOptimizeCaseXMLFile = ReadMySQLValueDescriptionXMLFile.class.
	 getResource ("MySQLOptimizeCase.xml").getFile();
	
	private static String mySQLStatusDescriptionXMLFile = ReadMySQLValueDescriptionXMLFile.class.
	 getResource ("MySQLStatusDescription.xml").getFile();
	
	private static String mySQLAutoCreateConfigXMLFile = ReadMySQLValueDescriptionXMLFile.class.
	 getResource ("MySQLAutoCreateConfig.xml").getFile();
	
	
	private static XStream xstream = new XStream(new DomDriver());
	private static MySQLVariableDescription   description= new MySQLVariableDescription();
	private static  Map cache= new HashMap ();
	private static String CacheVariableDescription="cacheVariableDescription";
	private static String CacheStatusDescription="cacheStatusDescription";
	private static String CacheOptimizeCase="cacheOptimizeCase";
	private static String CacheAutoConfigCase="cacheAutoConfigCase";
	
	
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
	
	
	public List getMySQLAutoConfigCase()  throws  Exception {
		logger.info( "get getMySQLAutoConfigCase ....................." );
		List   list=new ArrayList();
		
		try {
			if (cache.get(CacheAutoConfigCase)!=null){
				logger.info("Cache MySQL AutoCreateConfig XML File  ....................");
				list=(List<MySQLAutoConfigCase>) cache.get(CacheAutoConfigCase);
			}
			else{
				logger.info(" Read  mySQL AutoCreateConfig XML File   ....................");
				File f=new File(mySQLAutoCreateConfigXMLFile); 
				DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance(); 
				DocumentBuilder builder=factory.newDocumentBuilder(); 
				Document doc = builder.parse(f); 
				 
				NodeList nodelist = doc.getElementsByTagName("case");
				int size = nodelist.getLength();
				for(int i=0; i<size; i++){
					MySQLAutoConfigCase  autoConfigCase= new MySQLAutoConfigCase();
					Node node = nodelist.item(i);
					String content = node.getTextContent() ;
					autoConfigCase.setName(node.getAttributes().getNamedItem("name").getNodeValue());
					autoConfigCase.setAlias(node.getAttributes().getNamedItem("alias").getNodeValue());
					autoConfigCase.setConfigs(content);
					list.add(  autoConfigCase );
				}
			
				cache.put(CacheAutoConfigCase,  list );
			}
			
			} 
		catch ( Exception e) {
			logger.error(e);
		}
		return list;
	}
	
	
	
	public List getMySQLOptimizeCase()  throws  Exception {
		logger.info( "get MySQLVariableDescription ....................." );
		List   list=new ArrayList();
		
		try {
			if (cache.get(CacheOptimizeCase)!=null){
				logger.info("Cache MySQL Optimize XML File  ....................");
				list=(List<MySQLVariableDescription>) cache.get(CacheOptimizeCase);
			}
			else{
				logger.info(" Read  MySQLOptimize Case ConfigFile XML File ....................");
				File f=new File(mySQLOptimizeCaseXMLFile); 
				DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance(); 
				DocumentBuilder builder=factory.newDocumentBuilder(); 
				Document doc = builder.parse(f); 
				 
				NodeList nodelist = doc.getElementsByTagName("case");
				int size = nodelist.getLength();
				for(int i=0; i<size; i++){
					MySQLOptimizeCase  optimizeCase= new MySQLOptimizeCase();
					Node node = nodelist.item(i);
					String content = node.getTextContent() ;
					optimizeCase.setName(node.getAttributes().getNamedItem("name").getNodeValue());
					optimizeCase.setAlias(node.getAttributes().getNamedItem("alias").getNodeValue());
 					optimizeCase.setSetCommands(content);
					list.add(  optimizeCase );
				}
			
				cache.put(CacheOptimizeCase,  list );
			}
			
			} 
		catch ( Exception e) {
			logger.error(e);
		}
		return list;
	}
	
	@Test
	public void runCase() throws  Exception{
		ReadMySQLValueDescriptionXMLFile  read= new ReadMySQLValueDescriptionXMLFile();
		List <MySQLAutoConfigCase> list=read.getMySQLAutoConfigCase();
		
		System.out.println (list.get(0).getConfigs().replaceAll("datadir=", "datadir=xxxxxx") 
				.replaceAll("basedir=", "basedir=yyyyyyyyyy"));
		
	}

}
