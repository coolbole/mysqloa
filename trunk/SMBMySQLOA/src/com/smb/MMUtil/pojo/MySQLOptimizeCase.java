/**
 * 
 */
package com.smb.MMUtil.pojo;

import java.util.List;

/**
 * @author ivan
 *
 */
public class MySQLOptimizeCase {
	
		private String name;
		private String setCommands;
		private String alias="";
		
		public String getAlias() {
			return alias;
		}
		public void setAlias(String alias) {
			this.alias = alias;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSetCommands() {
			return setCommands;
		}
		public void setSetCommands(String setCommands) {
			this.setCommands = setCommands;
		}
		
		
	
}
