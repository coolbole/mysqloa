/**
 * 
 */
package com.smb.MMUtil.handler.monitor;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.handler.xml.ReadMySQLConfigXMLFile;
import com.smb.MMUtil.pojo.monitor.MySQLMonitorHost;

/**
 * @author huangyi
 *
 */

public class SetUpMySQLMonitorHost  implements ISetUpMySQLMonitorHost {
	private static ReadMySQLConfigXMLFile  DescriptionXMLFile= new ReadMySQLConfigXMLFile();
	private static Log logger = LogFactory.getLog(SetUpMySQLMonitorHost.class);
	
	
	public void delMySQLMonitorHostList(String ID) throws Exception {
		logger.info("delMySQLMonitorHostList  ......................");
		DescriptionXMLFile.delMySQLMonitorHost(ID);
	}

	public MySQLMonitorHost getMySQLMonitorHost(String ID) throws Exception {
		logger.info(" getMySQLMonitorHost ......................");
		MySQLMonitorHost  monitorHost=DescriptionXMLFile.getMySQLMonitorHostInfo(ID);
		return monitorHost;
	}

	@SuppressWarnings("unchecked")
	public List getMySQLMonitorHostList() throws Exception {
		logger.info("getMySQLMonitorHostList  ......................");
			List hostList=null;
			hostList=DescriptionXMLFile.getMySQLMonitorHost();
		return hostList;
	}

	public void upDataMySQLMonitorHostList(MySQLMonitorHost MonitorHost) throws Exception {
		logger.info(" upDataMySQLMonitorHostList  ......................");
		DescriptionXMLFile.upDataMySQLMonitorHost(MonitorHost);
	}

	public void addMySQLMonitorHost(MySQLMonitorHost monitorHost) throws Exception {
		logger.info(" addMySQLMonitorHost  ......................");
		DescriptionXMLFile.addMySQLMonitorHost( monitorHost );
	}
	
	 

}
