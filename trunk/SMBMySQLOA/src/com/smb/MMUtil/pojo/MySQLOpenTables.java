package com.smb.MMUtil.pojo;

public class MySQLOpenTables {
	
	private String database;
	private String table;
	private String in_use;
	private String name_locked;
	
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getIn_use() {
		return in_use;
	}
	public void setIn_use(String in_use) {
		this.in_use = in_use;
	}
	public String getName_locked() {
		return name_locked;
	}
	public void setName_locked(String name_locked) {
		this.name_locked = name_locked;
	}
	

}
