/**
 * 
 */
package com.smb.MMUtil.handler;

import java.util.List;

import com.smb.MMUtil.pojo.MySQLVariableObject;

/**
 * @author huangyi
 *
 */
public interface IMySQLManagerJdbcUtilTools {
	
	public List  showProcesslistCommand( ) throws  Exception;
	
	public List  showVariblesCommand ( ) throws  Exception;
	
	public List  showVariblesCommandByCategory (String category ) throws  Exception;
	
	public List  showStatusCommand ( ) throws  Exception;

	public List  showStatusCommandByCategory (String category) throws  Exception;
	
	public void setVariblesCommandByCategory(String category,String value) throws Exception;
	
	public MySQLVariableObject  showDetailVaribles (String variable_name) throws  Exception;
	
}
