/**
 * 
 */
package com.smb.MMUtil.pojo.email;

/**
 * @author huangyi
 *
 */

public class Email {
	
	private String mailServer;
	private int port;
	private String recipient;
	private String emailAccount;
	private String username;
	private String password;
	
	
	public String getMailServer() {
		return mailServer;
	}
	public void setMailServer(String mailServer) {
		this.mailServer = mailServer;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getRecipient() {
		return recipient;
	}
	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	public String getEmailAccount() {
		return emailAccount;
	}
	public void setEmailAccount(String emailAccount) {
		this.emailAccount = emailAccount;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
