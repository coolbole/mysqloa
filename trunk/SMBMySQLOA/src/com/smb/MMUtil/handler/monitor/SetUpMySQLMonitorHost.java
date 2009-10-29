/**
 * 
 */
package com.smb.MMUtil.handler.monitor;

import java.util.List;

import com.smb.MMUtil.handler.xml.ReadMySQLConfigXMLFile;
import com.smb.MMUtil.pojo.monitor.MySQLMonitorHost;

/**
 * @author huangyi
 *
 */

public class SetUpMySQLMonitorHost  implements ISetUpMySQLMonitorHost {
	private static ReadMySQLConfigXMLFile  DescriptionXMLFile= new ReadMySQLConfigXMLFile();
	
	
	public void delMySQLMonitorHostList(String ID) throws Exception {
		DescriptionXMLFile.delMySQLMonitorHost(ID);
	}

	public MySQLMonitorHost getMySQLMonitorHost(String ID) throws Exception {
		MySQLMonitorHost  monitorHost=null;
		
		return monitorHost;
	}

	@SuppressWarnings("unchecked")
	public List getMySQLMonitorHostList() throws Exception {
			List hostList=null;
			hostList=DescriptionXMLFile.getMySQLMonitorHost();
		return hostList;
	}

	public void upDataMySQLMonitorHostList(String ID) throws Exception {
		
	}
	
	 

}
