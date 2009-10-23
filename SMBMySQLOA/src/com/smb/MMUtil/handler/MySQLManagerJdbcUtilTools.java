/**
 * 
 */
package com.smb.MMUtil.handler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


//import org.apache.commons.dbutils.DbUtils;
//import org.apache.commons.dbutils.QueryRunner;
//import org.apache.commons.dbutils.ResultSetHandler;
//import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.handler.base.UtilBaseTools;
import com.smb.MMUtil.pojo.MySQLShowProcessList;
import com.smb.MMUtil.pojo.MySQLVariableObject;
import com.smb.MMUtil.pojo.ReplicationStatusPojo;
import com.smb.MMUtil.pojo.TableStatusPojo;


/**
 * @author huangyi
 *
 */
public class MySQLManagerJdbcUtilTools  implements IMySQLManagerJdbcUtilTools {
	
	private static Log logger = LogFactory.getLog(MySQLManagerJdbcUtilTools.class);
	
	public  MySQLManagerJdbcUtilTools(UtilBaseTools utilBaseTools){
		UtilBaseTools=utilBaseTools;
	}
	
	private UtilBaseTools  UtilBaseTools;
	
	public List  showProcesslistCommand( ) throws  Exception {
		logger.info( "showProcesslist ......................." );
		Connection connection=null;
		connection=UtilBaseTools.getConnection();
		List <MySQLShowProcessList> result =  new ArrayList();
		try{
			ResultSet rs=connection.prepareStatement( "show processlist"  ).executeQuery();
			while (rs.next() ){
				MySQLShowProcessList  variable= new MySQLShowProcessList();	
				variable.setId( rs.getInt(1)   );
				variable.setUser(rs.getString(2));
				variable.setHost(rs.getString(3));
				variable.setDb(rs.getString(4));
				variable.setCommand(rs.getString(5));
				variable.setTime( rs.getString(6)  );
				variable.setState( rs.getString(7)  );
				variable.setInfo( rs.getString(8)  );
				
				result.add( variable  );
			}
		}
		catch ( Exception e){
			logger.error(e);
		}
		finally {
			connection.close();
		}
		return result;
	}

	public List showStatusCommand() throws Exception {
		logger.info( "showStatusCommand ......................." );
		Connection connection=null;
		connection=UtilBaseTools.getConnection();
		List <MySQLVariableObject>  result = new ArrayList();
		try{
			ResultSet rs=connection.prepareStatement( "show status"  ).executeQuery();
			while (rs.next() ){
				MySQLVariableObject  variable= new MySQLVariableObject();	
				variable.setVariable_name( rs.getString(1)   );variable.setValue(rs.getString(2));
				result.add( variable  );
			}
		}
		catch ( Exception e){
			logger.error(e);
		}
		finally {
			connection.close();
		}
		return result;
	}

	public List showVariblesCommand() throws Exception {
		logger.info( "showVariblesCommand ......................." );
		Connection connection=null;
		connection=UtilBaseTools.getConnection();
		List <MySQLVariableObject>  result = new ArrayList();
		try{
			ResultSet rs=connection.prepareStatement( "show variables"  ).executeQuery();
			while (rs.next() ){
				MySQLVariableObject  variable= new MySQLVariableObject();	
				variable.setVariable_name( rs.getString(1)   );variable.setValue(rs.getString(2));
				result.add( variable  );
			}
		}
		catch ( Exception e){
			logger.error(e);
		}
		finally {
			connection.close();
		}
		return result;
	}

	public List showStatusCommandByCategory(String category) throws Exception {
		logger.info( "showStatusCommandByCategory ......................." );
		Connection connection=null;
		connection=UtilBaseTools.getConnection();
		List <MySQLVariableObject>  result =  new ArrayList();
		try{
			ResultSet rs=connection.prepareStatement( "show status like '%"+category+"%' "  ).executeQuery();
			while (rs.next() ){
				MySQLVariableObject  variable= new MySQLVariableObject();	
				variable.setVariable_name( rs.getString(1)   );variable.setValue(rs.getString(2));
				result.add( variable  );
			}
		}
		catch ( Exception e){
			logger.error(e);
		}
		finally {
			connection.close();
		}
		return result;
	}

	public List showVariblesCommandByCategory(String category) throws Exception {
		logger.info( "showVariblesCommandByCategory ......................." );
		Connection connection=null;
		connection=UtilBaseTools.getConnection();
		List <MySQLVariableObject>  result =  new ArrayList();
		try{
			ResultSet rs=connection.prepareStatement( "show variables like '%"+category+"%' "  ).executeQuery();
			while (rs.next() ){
				MySQLVariableObject  variable= new MySQLVariableObject();	
				variable.setVariable_name( rs.getString(1)   );variable.setValue(rs.getString(2));
				result.add( variable  );
			}
		}
		catch ( Exception e){
			logger.error(e);
		}
		finally {
			connection.close();
		}
		return result;
	}
	
	public void setVariblesCommandByCategory(String category,String value) throws Exception {
			Connection connection=null;
			connection=UtilBaseTools.getConnection();
			String SQL= "set  GLOBAL "+category+"="+value;
			try {
				logger.info(SQL+"  setVariblesCommandByCategory. [ category :"+ category+ " ]  [ value : "+value+" ]");
				 connection.prepareStatement( SQL  ).execute();
				} 
			catch ( Exception e) {
				logger.error(e);
			}
			finally {
				connection.close();
				}
		}

	public MySQLVariableObject showDetailVaribles(String variable_name)  throws Exception {
		logger.info( "showDetailVaribles ......................." );
		Connection connection=null;
		connection=UtilBaseTools.getConnection();
		String SQL= "show variables where Variable_name='"+variable_name+"'  " ;
		MySQLVariableObject  variable=null;
		logger.info( "showDetailVaribles ......................." +SQL);
		try{
			ResultSet rs=connection.prepareStatement( SQL ).executeQuery();
			while (rs.next() ){
				variable= new MySQLVariableObject();	
				variable.setVariable_name( rs.getString(1)   );variable.setValue(rs.getString(2));
			}
		}
		catch ( Exception e){
			logger.error(SQL);
			logger.error(e);
		}
		finally {
			connection.close();
		}
		return variable;
	}

	public List showVariblesCommandByLetter(String letter) throws Exception {
		logger.info( "showVariblesCommandByLetter ......................." );
		Connection connection=null;
		connection=UtilBaseTools.getConnection();
		List <MySQLVariableObject>  result = new ArrayList();
		try{
			ResultSet rs=connection.prepareStatement( "show variables like '"+letter+"%' "  ).executeQuery();
			while (rs.next() ){
				MySQLVariableObject  variable= new MySQLVariableObject();	
				variable.setVariable_name( rs.getString(1)   );variable.setValue(rs.getString(2));
				result.add( variable  );
			}
		}
		catch ( Exception e){
			logger.error(e);
		}
		finally {
			connection.close();
		}
		return result;
	}

	public ReplicationStatusPojo showSlaveReplicationStatus() throws Exception {
		logger.info( "showSlaveReplicationStatus ......................." );
		Connection connection=null;
		connection=UtilBaseTools.getConnection();
		ReplicationStatusPojo  variable=null;
		try{
			ResultSet rs=connection.prepareStatement("show slave status" ).executeQuery();
			while (rs.next() ){
				variable= new ReplicationStatusPojo();	
				variable.setSlave_IO_State( rs.getString("Slave_IO_State")   );
				variable.setConnect_Retry(rs.getString("connect_Retry"));
				variable.setExec_Master_Log_Pos( rs.getString("Exec_Master_Log_Pos"));
				variable.setLast_Errno(  rs.getString("last_Errno"));
				variable.setLast_Error(  rs.getString("last_Error"));
				variable.setLast_IO_Errno(  rs.getString("last_IO_Errno"));
				variable.setLast_IO_Error(  rs.getString("last_IO_Error"));
				variable.setMaster_Bind(  rs.getString("master_Bind"));
				variable.setMaster_Host(  rs.getString("master_Host"));
				variable.setMaster_Log_File(  rs.getString("master_Log_File"));
				variable.setMaster_Port( rs.getString("master_Port"));
				variable.setMaster_SSL_Allowed(  rs.getString("master_SSL_Allowed"));
				variable.setMaster_SSL_CA_File(  rs.getString("Master_SSL_CA_File"));
				variable.setMaster_SSL_CA_Path(  rs.getString("Master_SSL_CA_Path"));
				variable.setMaster_SSL_Cert(  rs.getString("Master_SSL_Cert"));
				variable.setMaster_SSL_Cipher(  rs.getString("Master_SSL_Cipher"));
				variable.setMaster_SSL_Key(  rs.getString("Master_SSL_Key"));
				variable.setMaster_SSL_Verify_Server_Cert(  rs.getString("Master_SSL_Verify_Server_Cert"));
				variable.setMaster_User(  rs.getString("Master_User"));
				variable.setMasterBinlog_Do_DB(  rs.getString("MasterBinlog_Do_DB"));
				variable.setReplicate_Do_Table(rs.getString("Replicate_Do_Table"));
				variable.setMasterBinlog_Ignore_DB(  rs.getString("MasterBinlog_Ignore_DB"));
				variable.setSeconds_Behind_Master(  rs.getString("Seconds_Behind_Master"));
				variable.setMasterFile(  rs.getString("MasterFile"));
				variable.setMasterPosition(  rs.getString("MasterPosition"));
			}
		}
		catch ( Exception e){
			logger.error(e);
		}
		finally {
			connection.close();
		}
		return variable;
	
	}
	
	public ReplicationStatusPojo showMasterReplicationStatus() throws Exception {
		logger.info( "showMasterReplicationStatus ......................." );
		Connection connection=null;
		connection=UtilBaseTools.getConnection();
		ReplicationStatusPojo  variable=null;
		try{
			ResultSet rs=connection.prepareStatement("show master status" ).executeQuery();
			while (rs.next() ){
				variable= new ReplicationStatusPojo();	
				variable.setMasterFile( rs.getString("masterFile")   );
				variable.setMasterBinlog_Do_DB(rs.getString("masterBinlog_Do_DB"));
				variable.setMasterBinlog_Ignore_DB( rs.getString("masterBinlog_Ignore_DB"));
				variable.setMasterPosition(rs.getString("masterPosition"));
			}
		}
		catch ( Exception e){
			logger.error(e);
		}
		finally {
			connection.close();
		}
		return variable;
	
	}

	public String showUptime() throws Exception {
		logger.info( "showUptime ......................." );
		Connection connection=null;
		connection=UtilBaseTools.getConnection();
		String  variable="这台MySQL运行了 ";
		try{
			long uptime=0;
			ResultSet rs=connection.prepareStatement(" show   status  like 'uptime' " ).executeQuery();
			while (rs.next() ){
				uptime= rs.getLong(2)/60;
			}
			
			 if (uptime<60){
				 variable=variable+ uptime +" 分钟  " ;
			 }
			 
			 else if (uptime>60 ) {
				 variable=variable+ uptime/60 +" 小时  " ;
				 
				 if (uptime/60>60 ){
					 variable=variable+ "("+uptime/60/24 +"天)" ;
				 }
			 }
			 
			 System.out.println(    );
		
		}
		catch ( Exception e){
			logger.error(e);
		}
		finally {
			connection.close();
		}
		return variable;
	
	}

	public List showDataBases() throws Exception {
		logger.info( "showDataBases ......................." );
		Connection connection=null;
		connection=UtilBaseTools.getConnection();
		List   result = new ArrayList();
		try{
			ResultSet rs=connection.prepareStatement( "show  databases"  ).executeQuery();
			while (rs.next() ){
				result.add( rs.getString(1)  );
			}
		}
		catch ( Exception e){
			logger.error(e);
		}
		finally {
			connection.close();
		}
		return result;
	}

	public List showTableStatus() throws Exception {
		logger.info( "showDataBases ......................." );
		Connection connection=null;
		connection=UtilBaseTools.getConnection();
		List    result = new ArrayList();
		try{
			ResultSet rs=connection.prepareStatement( "show table status"  ).executeQuery();
			while (rs.next() ){
				TableStatusPojo table=new TableStatusPojo();
				table.setAuto_increment( rs.getString("auto_increment") );
				table.setAvg_row_length(rs.getString("avg_row_length")  );
				table.setCreate_options( rs.getString("create_options")  );
				table.setCheck_time(rs.getString("check_time"));
				table.setChecksum(rs.getString("checksum"));
				table.setCollation(rs.getString("collation"));
				table.setComment(rs.getString("comment"));
				table.setCreate_time(rs.getString("create_time"));
				table.setData_length(rs.getString("data_length"));
				table.setEngine(rs.getString("engine"));
				table.setIndex_length(rs.getString("index_length"));
				table.setMax_data_length(rs.getString("max_data_length"));
				table.setName(rs.getString("name"));
				table.setRow_format(rs.getString("row_format"));
				table.setRows(rs.getString("rows"));
				table.setUpdate_time(rs.getString("update_time"));
				table.setVersion(rs.getString("version"));
				
				result.add( table   );
			}
		}
		catch ( Exception e){
			logger.error(e);
		}
		finally {
			connection.close();
		}
		return result;
	}
	
	 
}