/**
 * 
 */

package com.smb.MMUtil.pojo.monitor;

/**
 * @author huangyi
 * 
 */
public class MySQLMonitorHost {
	
	private String id;
	private String host;
	private String port;
	private String user;
	private String pswd;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

}
