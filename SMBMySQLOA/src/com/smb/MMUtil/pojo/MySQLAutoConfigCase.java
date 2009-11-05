/**
 * 
 */
package com.smb.MMUtil.pojo;

/**
 * @author ivan
 *
 */ 
public class MySQLAutoConfigCase {
	
		private String name;
		private String Configs;
		private String alias="";
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getConfigs() {
//			Configs=Configs.replaceAll("\n", "\n<br>");
			return Configs;
		}
		public void setConfigs(String configs) {
			Configs = configs;
		}
		public String getAlias() {
			return alias;
		}
		public void setAlias(String alias) {
			this.alias = alias;
		}
		
	 
		
	
}
