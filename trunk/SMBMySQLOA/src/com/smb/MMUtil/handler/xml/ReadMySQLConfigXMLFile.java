/**
 * 
 */
package com.smb.MMUtil.handler.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.smb.MMUtil.pojo.MySQLAutoConfigCase;
import com.smb.MMUtil.pojo.MySQLDeepOptimize;
import com.smb.MMUtil.pojo.MySQLOptimizeCase;
import com.smb.MMUtil.pojo.MySQLVariableDescription;
import com.smb.MMUtil.pojo.email.Email;
import com.smb.MMUtil.pojo.monitor.MySQLMonitorHost;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @author huangyi
 *
 */
public class ReadMySQLConfigXMLFile {
	
	private static Log logger = LogFactory.getLog(ReadMySQLConfigXMLFile.class);
	
	private static String mySQLValueDescriptionXMLFile = ReadMySQLConfigXMLFile.class.
							 getResource ("MySQLValueDescription.xml").getFile();
	
	private static String mySQLOptimizeCaseXMLFile = ReadMySQLConfigXMLFile.class.
							getResource ("MySQLOptimizeCase.xml").getFile();
	
	private static String mySQLStatusDescriptionXMLFile = ReadMySQLConfigXMLFile.class.
							getResource ("MySQLStatusDescription.xml").getFile();
	
	private static String mySQLAutoCreateConfigXMLFile = ReadMySQLConfigXMLFile.class.
							getResource ("MySQLAutoCreateConfig.xml").getFile();
	
	private static String mySQLMonitorHostConfigXMLFile = ReadMySQLConfigXMLFile.class.
	 						getResource ("MySQLMonitorHostConfig.xml").getFile();
	
	private static String mailHostConfigXMLFile = ReadMySQLConfigXMLFile.class.
							getResource ("MailHost.xml").getFile();
	
	private static String mySQLDeepOptimizeCaseXMLFile = ReadMySQLConfigXMLFile.class.
	getResource ("MySQLDeepOptimizeCase.xml").getFile();
	
	
	private static  XStream xstream = new XStream(new DomDriver());
	private static  MySQLVariableDescription   description= new MySQLVariableDescription();
	private static  MySQLMonitorHost  monitorHost=new MySQLMonitorHost();
	private static  MySQLDeepOptimize  deepOptimize=new MySQLDeepOptimize();
	
	
	@SuppressWarnings("unchecked")
	private static  Map cache= new HashMap ();
	private static String CacheVariableDescription="cacheVariableDescription";
	private static String CacheStatusDescription="cacheStatusDescription";
	private static String CacheOptimizeCase="cacheOptimizeCase";
	private static String CacheAutoConfigCase="cacheAutoConfigCase";
	private static String CachedeepOptimize="cachedeepOptimize";
	
	@SuppressWarnings("unchecked")
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
	
	@SuppressWarnings("unchecked")
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
	
	
	@SuppressWarnings("unchecked")
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
	
	
	
	@SuppressWarnings("unchecked")
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
	
	
	
	public Email getMailHostConfigXMLFile()  throws  Exception {
		logger.info( "get  MailHostConfigXMLFile .....................\n" +mailHostConfigXMLFile);
		FileInputStream input; 
		Email  email=null;
		try {
				input = new FileInputStream(mailHostConfigXMLFile);
				 xstream.alias("MailHost",  Email.class);
				 email = (Email) xstream.fromXML(input,email) ;
			} 
		catch ( Exception e) {
			logger.error(e);
		}
		return email;
	}
	
	public Email updateMailHostConfigXMLFile(Email emailInfo)  throws  Exception {
		logger.info( "update  MailHostConfigXMLFile .....................\n" +mailHostConfigXMLFile);
		@SuppressWarnings("unused")
		FileInputStream input; 
		Email  email=null;
		try {
				String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+xstream.toXML(emailInfo);
				logger.info(xml);
					
				FileWriter resultFile = new FileWriter(mailHostConfigXMLFile);
				PrintWriter myFile = new PrintWriter(resultFile);
				myFile.println(xml);
				resultFile.close(); 
				
//				input = new FileInputStream(mailHostConfigXMLFile);
// 				xstream.alias("MailHost",  Email.class);
// 				email = (Email) xstream.fromXML(input,email) ;
		} 
		catch ( Exception e) {
			logger.error(e);
		}
		return email;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List getMySQLMonitorHost()  throws  Exception {
		logger.info( "get MySQLMonitorHost .....................\n" +mySQLMonitorHostConfigXMLFile);
		FileInputStream input; 
		List<MySQLMonitorHost> list=null;
		try {
				input = new FileInputStream(mySQLMonitorHostConfigXMLFile);
				xstream.alias("MySQLMonitorHost",  MySQLMonitorHost.class);
				list=  (List<MySQLMonitorHost>) xstream.fromXML(input,monitorHost) ;
			} 
		catch ( Exception e) {
			logger.error(e);
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public void delMySQLMonitorHost(String ID) throws Exception{
		logger.info( " delMySQLMonitorHost ......................." );
		List <MySQLMonitorHost> hostList=getMySQLMonitorHost();
		try {
		for (int i=0;i<hostList.size();i++){
			if (hostList.get(i).getId().equals(ID) 	){
				hostList.remove(i);
			}
		}
		String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+xstream.toXML(hostList);
		logger.info(xml);
		FileWriter resultFile = new FileWriter(mySQLMonitorHostConfigXMLFile);
		PrintWriter myFile = new PrintWriter(resultFile);
		myFile.println(xml);
		resultFile.close(); 
		} 
		catch ( Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public void upDataMySQLMonitorHost(MySQLMonitorHost  MonitorHost) throws Exception{
		logger.info( " upDataMySQLMonitorHost ......................." );
		try{
			List <MySQLMonitorHost> hostList=getMySQLMonitorHost();
			for (int i=0;i<hostList.size();i++){
				System.out.println("removed ...."+MonitorHost.getId()+"    "+hostList.get(i).getId() );
				if (hostList.get(i).getId().equals(MonitorHost.getId() ) 	){
					
					hostList.remove(i);
					MonitorHost.setId(System.currentTimeMillis()+"" );
					hostList.add( MonitorHost );
				}
			}
			
			String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+xstream.toXML(hostList);
			logger.info(xml);
			
			FileWriter resultFile = new FileWriter(mySQLMonitorHostConfigXMLFile);
			PrintWriter myFile = new PrintWriter(resultFile);
			myFile.println(xml);
			resultFile.close(); 
		} 
		catch ( Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public void addMySQLMonitorHost(MySQLMonitorHost  MonitorHost) throws Exception{
		logger.info( " addMySQLMonitorHost ......................." );
		try{
			List <MySQLMonitorHost> hostList=getMySQLMonitorHost();
			MonitorHost.setId(System.currentTimeMillis()+"" );
			hostList.add( MonitorHost );
			String xml="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+xstream.toXML(hostList);
			logger.info(xml);
			
			FileWriter resultFile = new FileWriter(mySQLMonitorHostConfigXMLFile);
			PrintWriter myFile = new PrintWriter(resultFile);
			myFile.println(xml);
			resultFile.close(); 
		} 
		catch ( Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public MySQLMonitorHost getMySQLMonitorHostInfo(String  ID) throws Exception{
		logger.info( " get MySQL Monitor Host Info ......................." );
		MySQLMonitorHost  monitorHost=null;
		try{
			List <MySQLMonitorHost> hostList=this.getMySQLMonitorHost();
			for (int i=0;i<hostList.size();i++){
				if (hostList.get(i).getId().equals(ID) 	){
					monitorHost=hostList.get(i);
				}
			}
		} 
		catch ( Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
		return monitorHost;
	}
	
	
	@SuppressWarnings("unchecked")
	public List getMySQLDeepOptimizeCase()  throws  Exception {
		logger.info( "get MySQLDeepOptimizeCase ....................." );
		FileInputStream input; 
		List <MySQLDeepOptimize> list=null;
		try {
			if (cache.get(CachedeepOptimize)!=null){
				logger.info("Cache MySQL  Deep Optimize Case XML File  ....................");
				list=(List<MySQLDeepOptimize>) cache.get(CachedeepOptimize);
			}
			else{
				logger.info(" Read description Status ConfigFile XML File ....................");
				input = new FileInputStream(mySQLDeepOptimizeCaseXMLFile);
				xstream.alias("MySQLDeepOptimize",  MySQLDeepOptimize.class);
				list=(List<MySQLDeepOptimize>) xstream.fromXML(input,deepOptimize) ;
				cache.put(CachedeepOptimize, list);
			}
		
			} 
		catch ( Exception e) {
			logger.error(e);
		}
		return list;
	}
	
	 

}
