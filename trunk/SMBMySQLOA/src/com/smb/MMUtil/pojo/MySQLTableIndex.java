package com.smb.MMUtil.pojo;

public class MySQLTableIndex {
	
	private String CONSTRAINT_SCHEMA;
	private String CONSTRAINT_NAME;
	private String TABLE_NAME;
	private String COLUMN_NAME;
	
	public String getCONSTRAINT_SCHEMA() {
		return CONSTRAINT_SCHEMA;
	}
	public void setCONSTRAINT_SCHEMA(String constraint_schema) {
		CONSTRAINT_SCHEMA = constraint_schema;
	}
	public String getCONSTRAINT_NAME() {
		return CONSTRAINT_NAME;
	}
	public void setCONSTRAINT_NAME(String constraint_name) {
		CONSTRAINT_NAME = constraint_name;
	}
	public String getTABLE_NAME() {
		return TABLE_NAME;
	}
	public void setTABLE_NAME(String table_name) {
		TABLE_NAME = table_name;
	}
	public String getCOLUMN_NAME() {
		return COLUMN_NAME;
	}
	public void setCOLUMN_NAME(String column_name) {
		COLUMN_NAME = column_name;
	}
	
	
	
	
}
