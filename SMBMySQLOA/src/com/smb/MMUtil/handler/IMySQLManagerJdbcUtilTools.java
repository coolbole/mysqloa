/**
 * 
 */
package com.smb.MMUtil.handler;

import java.util.List;

import com.smb.MMUtil.pojo.MySQLShowColumns;
import com.smb.MMUtil.pojo.MySQLVariableObject;
import com.smb.MMUtil.pojo.ReplicationStatusPojo;

/**
 * @author huangyi
 *
 */
public interface IMySQLManagerJdbcUtilTools {
	
	@SuppressWarnings("unchecked")
	public List  showProcesslistCommand( ) throws  Exception;
	
	public List<MySQLVariableObject>  showVariblesCommand ( ) throws  Exception;
	
	public List<?>  showVariblesCommandByCategory (String category ) throws  Exception;
	
	public List<?>  showStatusCommand ( ) throws  Exception;

	public List<?>  showStatusCommandByCategory (String category) throws  Exception;
	
	public void setVariblesCommandByCategory(String category,String value) throws Exception;
	
	public MySQLVariableObject  showDetailVaribles (String variable_name) throws  Exception;
	
	public List<?>  showVariblesCommandByLetter(String letter ) throws  Exception;
	
	public ReplicationStatusPojo  showMasterReplicationStatus( ) throws  Exception;
	
	public ReplicationStatusPojo  showSlaveReplicationStatus(  ) throws  Exception;
	
	public String  showUptime (  ) throws  Exception;
	
	public List<?>  showDataBases(  ) throws  Exception;
	
	public List<?>  showTableStatus(  ) throws  Exception;
	
	public List<?>  MySQLOptimize (String Optimize) throws Exception ;
	
	public String showVersion (  ) throws  Exception;
	
	public  String CreateAutoCreateConfig ( String Config ) throws  Exception;
	
	public  String showCreateTable ( String tablename ) throws  Exception; 
	
	public  List<?>   showOpentables (   ) throws  Exception; 
	
	@SuppressWarnings("unchecked")
	public List showTableIndexs(String DBName) throws Exception;
	
	public String CollectionMySQLogData () throws Exception;
	
 	public  void killConnectionProcess (String ConnectionID)    throws Exception;
 	
 	public void  flushTable() throws Exception;
 	
 	public void setVariblesByCommands(String command) throws Exception;
 	
 	public List<MySQLShowColumns> showTableColumns(String tablename) throws Exception;
 	
}
