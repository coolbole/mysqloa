/**
 * 
 */
package com.smb.MMUtil.handler;

import java.util.List;

import com.smb.MMUtil.pojo.MySQLVariableObject;
import com.smb.MMUtil.pojo.ReplicationStatusPojo;

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
	
	public List  showVariblesCommandByLetter(String letter ) throws  Exception;
	
	public ReplicationStatusPojo  showMasterReplicationStatus( ) throws  Exception;
	
	public ReplicationStatusPojo  showSlaveReplicationStatus(  ) throws  Exception;
	
	public String  showUptime (  ) throws  Exception;
	
	public List  showDataBases(  ) throws  Exception;
	
	public List  showTableStatus(  ) throws  Exception;
	
	public void MySQLOptimize (String Optimize) throws Exception ;
}
