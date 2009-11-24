
package com.smb.MMUtil.handler;

import java.util.List;
import java.util.Map;

import com.smb.MMUtil.pojo.MySQLShowColumns;
import com.smb.MMUtil.pojo.MySQLShowProcessList;
import com.smb.MMUtil.pojo.MySQLTableIndex;
import com.smb.MMUtil.pojo.MySQLVariableObject;
import com.smb.MMUtil.pojo.ReplicationStatusPojo;
import com.smb.MMUtil.pojo.TableStatusPojo;

/**
 * @author huangyi
 */

public interface IMySQLManagerJdbcUtilTools {
	
	public List  <MySQLShowProcessList> showProcesslistCommand( ) throws  Exception;
	
	public Map<Object, Object>  showTablesCount() throws Exception;
	
	public Map<Object, Object>  showTableRows() throws Exception;
	
	public List<MySQLVariableObject>  showVariblesCommand ( ) throws  Exception;
	
	public List<?>  showVariblesCommandByCategory (String category ) throws  Exception;
	
	public List<?>  showStatusCommand ( ) throws  Exception;
	
	public Map<?, ?>  showTableDataInfo (String tableName,int startPaged, int endPaged) throws  Exception;

	public List<?>  showTablesCommand (String DBName ) throws  Exception;
	
	public List<?>  showStatusCommandByCategory (String category) throws  Exception;
	
	public void setVariblesCommandByCategory(String category,String value) throws Exception;
	
	public MySQLVariableObject  showDetailVaribles (String variable_name) throws  Exception;
	
	public List<?>  showVariblesCommandByLetter(String letter ) throws  Exception;
	
	public ReplicationStatusPojo  showMasterReplicationStatus( ) throws  Exception;
	
	public ReplicationStatusPojo  showSlaveReplicationStatus(  ) throws  Exception;
	
	public String  showUptime (  ) throws  Exception;
	
	public List<?>  showDataBases(  ) throws  Exception;
	
	public List<TableStatusPojo>   showTableStatus(  ) throws  Exception;
	
	public List<?>  MySQLOptimize (String Optimize) throws Exception ;
	
	public String showVersion (  ) throws  Exception;
	
	public  String CreateAutoCreateConfig ( String Config ) throws  Exception;
	
	public  String showCreateTable ( String tablename ) throws  Exception; 
	
	public  List<?>   showOpentables (   ) throws  Exception; 
	
	public List <MySQLTableIndex> showTableIndexs(String DBName) throws Exception;
	
	public String CollectionMySQLogData () throws Exception;
	
 	public  void killConnectionProcess (String ConnectionID)    throws Exception;
 	
 	public void  flushTable() throws Exception;
 	
 	public void setVariblesByCommands(String command) throws Exception;
 	
 	public List<MySQLShowColumns> showTableColumns(String tablename) throws Exception;
 	
 	public List<?>  showTABLESColumns(String tablename[]) throws Exception;
 	
 	
}
