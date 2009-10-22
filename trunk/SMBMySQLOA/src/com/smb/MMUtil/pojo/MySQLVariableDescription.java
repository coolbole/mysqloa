/**
 * 
 */
package com.smb.MMUtil.pojo;

/**
 * @author huangyi
 *
 */
public class MySQLVariableDescription {
	
	private String variable_name=""; 
	private String description="";
	private int isEdit=0;
	
	public int getIsEdit() {
		return isEdit;
	}
	public void setIsEdit(int isEdit) {
		this.isEdit = isEdit;
	}
	public String getVariable_name() {
		return variable_name;
	}
	public void setVariable_name(String variable_name) {
		this.variable_name = variable_name;
	}
	public String getDescription() {
		description=description.replaceAll("\n","<br>");
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	 
	
	
}
