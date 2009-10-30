/**
 * 
 */
package com.smb.MMUtil.handler.monitor;

import java.util.List;

import com.smb.MMUtil.pojo.monitor.MySQLMonitorHost;

/**
 * @author huangyi
 *
 */

public interface ISetUpMySQLMonitorHost {

	@SuppressWarnings("unchecked")
	public List getMySQLMonitorHostList()  throws Exception ; 
		
	public void delMySQLMonitorHostList(String ID)  throws Exception ; 
	
	public void upDataMySQLMonitorHostList(MySQLMonitorHost MonitorHost)  throws Exception ; 
	
	public void addMySQLMonitorHost(MySQLMonitorHost monitorHost)  throws Exception ; 
	
	public MySQLMonitorHost getMySQLMonitorHost(String ID)  throws Exception ; 
	
}
