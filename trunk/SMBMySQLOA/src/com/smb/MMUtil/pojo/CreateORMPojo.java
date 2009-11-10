package com.smb.MMUtil.pojo;

import java.util.List;

public class CreateORMPojo {
	
	private String createType;
	private String springFile;
	private String ormCFGFile;
	private List<Object> ormMappingFiles;
	
	public String getCreateType() {
		return createType;
	}
	public void setCreateType(String createType) {
		this.createType = createType;
	}
	public String getSpringFile() {
		return springFile;
	}
	public void setSpringFile(String springFile) {
		this.springFile = springFile;
	}
	public String getOrmCFGFile() {
		return ormCFGFile;
	}
	public void setOrmCFGFile(String ormCFGFile) {
		this.ormCFGFile = ormCFGFile;
	}
	public List<Object> getOrmMappingFiles() {
		return ormMappingFiles;
	}
	public void setOrmMappingFiles(List<Object> ormMappingFiles) {
		this.ormMappingFiles = ormMappingFiles;
	}
	
	
}
