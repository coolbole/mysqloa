package com.smb.MMUtil.pojo;


public class DiskInfoPojo {

	private String database_Name;
	private long total_Size	;
	private long data_Size	;
	private long index_Size	;
	private String data_as_of_Total_Size;
	private long rows	;
	
	public long getRows() {
		return rows;
	}
	public void setRows(long rows) {
		this.rows = rows;
	}
	public String getDatabase_Name() {
		return database_Name;
	}
	public void setDatabase_Name(String database_Name) {
		this.database_Name = database_Name;
	}
	public long getTotal_Size() {
		return total_Size;
	}
	public void setTotal_Size(long total_Size) {
		this.total_Size = total_Size;
	}
	public long getData_Size() {
		return data_Size;
	}
	public void setData_Size(long data_Size) {
		this.data_Size = data_Size;
	}
	public long getIndex_Size() {
		return index_Size;
	}
	public void setIndex_Size(long index_Size) {
		this.index_Size = index_Size;
	}
	public String getData_as_of_Total_Size() {
		return data_as_of_Total_Size;
	}
	public void setData_as_of_Total_Size(String data_as_of_Total_Size) {
		this.data_as_of_Total_Size = data_as_of_Total_Size;
	}
	
	
	
}
