/**
 * 
 */
package com.smb.MMUtil.handler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


//import org.apache.commons.dbutils.DbUtils;
//import org.apache.commons.dbutils.QueryRunner;
//import org.apache.commons.dbutils.ResultSetHandler;
//import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.handler.base.UtilBaseTools;
import com.smb.MMUtil.handler.xml.ReadMySQLConfigXMLFile;
import com.smb.MMUtil.pojo.MySQLAutoConfigCase;
import com.smb.MMUtil.pojo.MySQLOpenTables;
import com.smb.MMUtil.pojo.MySQLOptimizeCase;
import com.smb.MMUtil.pojo.MySQLShowProcessList;
import com.smb.MMUtil.pojo.MySQLTableIndex;
import com.smb.MMUtil.pojo.MySQLVariableObject;
import com.smb.MMUtil.pojo.ReplicationStatusPojo;
import com.smb.MMUtil.pojo.TableStatusPojo;


/**
 * @author huangyi
 *
 */
public class MySQLManagerJdbcUtilTools  implements IMySQLManagerJdbcUtilTools {
	
	private static ReadMySQLConfigXMLFile  readXMLFile= new ReadMySQLConfigXMLFile();
	
	private static Log logger = LogFactory.getLog(MySQLManagerJdbcUtilTools.class);
	
	public  MySQLManagerJdbcUtilTools(UtilBaseTools utilBaseTools){
		UtilBaseTools=utilBaseTools;
	}
	
	private UtilBaseTools  UtilBaseTools;
	
	@SuppressWarnings("unchecked")
	public List  showProcesslistCommand( ) throws  Exception {
		logger.info( "showProcesslist ......................." );
		Connection connection=null;
		connection=UtilBaseTools.getConnection();
		List <MySQLShowProcessList> result =  new ArrayList();
		try{
			ResultSet rs=connection.prepareStatement( "Show full processlist"  ).executeQuery();
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

	@SuppressWarnings("unchecked")
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

	@SuppressWarnings("unchecked")
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

	@SuppressWarnings("unchecked")
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

	@SuppressWarnings("unchecked")
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

	@SuppressWarnings("unchecked")
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
				variable.setConnect_Retry(rs.getString("Connect_Retry"));
				variable.setExec_Master_Log_Pos( rs.getString("Exec_Master_Log_Pos"));
				variable.setLast_Errno(  rs.getString("Last_Errno"));
				variable.setLast_Error(  rs.getString("Last_Error"));
				variable.setLast_IO_Errno(  rs.getString("Last_IO_Errno"));
				variable.setLast_IO_Error(  rs.getString("Last_IO_Error"));
				variable.setMaster_Bind(  rs.getString("master_Bind"));
				variable.setMaster_Host(  rs.getString("master_Host"));
				variable.setMaster_Log_File(  rs.getString("master_Log_File"));
				variable.setMaster_Port( rs.getString("master_Port"));
//				variable.setMaster_SSL_Allowed(  rs.getString("master_SSL_Allowed"));
//				variable.setMaster_SSL_CA_File(  rs.getString("Master_SSL_CA_File"));
//				variable.setMaster_SSL_CA_Path(  rs.getString("Master_SSL_CA_Path"));
//				variable.setMaster_SSL_Cert(  rs.getString("Master_SSL_Cert"));
//				variable.setMaster_SSL_Cipher(  rs.getString("Master_SSL_Cipher"));
//				variable.setMaster_SSL_Key(  rs.getString("Master_SSL_Key"));
//				variable.setMaster_SSL_Verify_Server_Cert(  rs.getString("Master_SSL_Verify_Server_Cert"));
				variable.setMaster_User(  rs.getString("Master_User"));
				variable.setReplicate_Do_Table(rs.getString("Replicate_Do_Table"));
				variable.setSeconds_Behind_Master(  rs.getString("Seconds_Behind_Master"));
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
				variable.setMasterFile( rs.getString("File")   );
				variable.setMasterBinlog_Do_DB(rs.getString("Binlog_Do_DB"));
				variable.setMasterBinlog_Ignore_DB( rs.getString("Binlog_Ignore_DB"));
				variable.setMasterPosition(rs.getString("Position"));
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
				 
				 if (uptime/60>24 ){
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

	@SuppressWarnings("unchecked")
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

	@SuppressWarnings("unchecked")
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

	@SuppressWarnings("unchecked")
	public List MySQLOptimize(String Optimize) throws Exception {
		logger.info(Optimize);
		Connection connection=null;
		List optimizedList= new ArrayList();
		
		try{
			connection=UtilBaseTools.getConnection();
			List list=readXMLFile.getMySQLOptimizeCase();
			for (int i=0;i<list.size();i++){
				MySQLOptimizeCase optimizeCase=(MySQLOptimizeCase) list.get(i);
				if (Optimize.equals(optimizeCase.getAlias() )  ){
					
					System.out.println( optimizeCase.getName()  );
					
					String commands[]=optimizeCase.getSetCommands().split("\n");
					for (int h=0;h<commands.length;h++){
						String value=commands[h].replaceAll("\t", "").split("=")[0] ;
						
						if (commands[h].length()>4){
							String SQL="set global " +commands[h].replaceAll("\t", "");
							
							MySQLVariableObject table_cache= showDetailVaribles(value)  ;
							if (table_cache !=null  ){
								logger.info(SQL);
								connection.prepareStatement( SQL  ).execute();
								optimizedList.add(commands[h].replaceAll("\t", ""));
								}   // if table_cache
						}  //if 
						}  // for
						 
						}   //if  Optimize.equals
				
			}
			}
		catch(Exception e) {
			e.printStackTrace();
			}
		finally {
			connection.close();
		}
		return optimizedList;
	}

	public String showVersion() throws Exception {
		logger.info( "showProcesslist ......................." );
		Connection connection=null;
		connection=UtilBaseTools.getConnection();
		String  version=  null;
		try{
			ResultSet rs=connection.prepareStatement( "SELECT VERSION()"  ).executeQuery();
			while (rs.next() ){ 
				version=rs.getString(1);
			}
		}
		catch ( Exception e){
			logger.error(e);
		}
		finally {
			connection.close();
		}
		return version;
	}
	
	private static String MySQLDataDirPATH="datadir=";
	private static String _MySQLDataDirPATH="datadir";
	
	
	private static String MySQLBaseDirPATH="basedir=";
	private static String _MySQLBaseDirPATH="basedir";
	
	@SuppressWarnings("unchecked")
	public String CreateAutoCreateConfig(String Config) throws Exception {
		logger.info( "CreateAutoCreateConfig ......................." );
		List <MySQLAutoConfigCase> list=readXMLFile.getMySQLAutoConfigCase();
		String configFile=null;
			for (int i=0;i<list.size();i++){
				if (Config.equals(list.get(i).getAlias() )  ) {
				
 				  configFile=list.get(i).getConfigs() ;
				  
				  configFile=configFile.split("basedir")[0]+
				  MySQLBaseDirPATH+ showDetailVaribles(_MySQLBaseDirPATH).getValue()+
				  configFile.split("basedir")[1].substring(1) ;
				
				 configFile=configFile.split("datadir")[0] +
				  MySQLDataDirPATH+ showDetailVaribles(_MySQLDataDirPATH).getValue() +
				 configFile.split("datadir")[1].substring(1) ;
				 
				 
				 if (showDetailVaribles("table_cache")==null){
					 configFile=configFile.replaceAll("table_cache=256M", "");
				 }
				 if (showDetailVaribles("table_open_cache")==null){
					 configFile=configFile.replaceAll("table_open_cache=256M", "");
				 }
				
				}
			}
		return configFile;
	}

	public String showCreateTable(String tablename) throws Exception {
		logger.info( "showCreateTable ......................." );
		Connection connection=null;
		connection=UtilBaseTools.getConnection();
		String  version=  null;
		try{
			ResultSet rs=connection.prepareStatement("SHOW CREATE TABLE  "+tablename  ).executeQuery();
			while (rs.next() ){ 
				version=rs.getString(2).replaceAll("\n", "\n<br>");
			}
		}
		catch ( Exception e){
			logger.error(e);
		}
		finally {
			connection.close();
		}
		return version;
	}

	@SuppressWarnings("unchecked")
	public List showOpentables() throws Exception {
		logger.info( "showOpentables ......................." );
		Connection connection=null;
		connection=UtilBaseTools.getConnection();
		List  opentablesList=  new ArrayList();
		
		try{
			ResultSet rs=connection.prepareStatement("SHOW OPEN TABLES"  ).executeQuery();
			while ( rs.next() ){ 
				MySQLOpenTables openTables =new MySQLOpenTables();
				openTables.setDatabase( rs.getString("database") );
				openTables.setTable( rs.getString("table")  );
				openTables.setIn_use( rs.getString("in_use")  ) ;
				openTables.setName_locked( rs.getString("name_locked") ) ;
				opentablesList.add( openTables   );
			}
//			connection.prepareStatement("flush  table"  ).execute();
		}
		catch ( Exception e){
			logger.error(e);
		}
		finally {
			connection.close();
		}
		return opentablesList;
	}
	
	
	@SuppressWarnings("unchecked")
	public List showTableIndexs(String DBName) throws Exception {
		logger.info( "showTableIndexs ......................." );
		Connection connection=null;
		connection=UtilBaseTools.getConnection();
		List  opentablesList=  new ArrayList();
		String SQL="SELECT information_schema.KEY_COLUMN_USAGE.CONSTRAINT_SCHEMA,information_schema.KEY_COLUMN_USAGE.CONSTRAINT_NAME,information_schema.KEY_COLUMN_USAGE.TABLE_NAME,information_schema.KEY_COLUMN_USAGE.COLUMN_NAME from information_schema.KEY_COLUMN_USAGE where   information_schema.KEY_COLUMN_USAGE.CONSTRAINT_SCHEMA ='"+DBName+"'";
		try{
			ResultSet rs=connection.prepareStatement(SQL).executeQuery();
			while ( rs.next() ){ 
				MySQLTableIndex tableIndex=new MySQLTableIndex(); 
				
				tableIndex.setCONSTRAINT_SCHEMA(  rs.getString("CONSTRAINT_SCHEMA") );
				tableIndex.setCOLUMN_NAME(rs.getString("COLUMN_NAME"));
				tableIndex.setCONSTRAINT_NAME(rs.getString("CONSTRAINT_NAME") );
				tableIndex.setTABLE_NAME(rs.getString("TABLE_NAME") );
 
				opentablesList.add( tableIndex   );
			}
		}
		catch ( Exception e){
			logger.error(e);
		}
		finally {
			connection.close();
		}
		return opentablesList;
	}
	
	@SuppressWarnings("static-access")
	public String CollectionMySQLogData () throws Exception {
		logger.info( "CollectionMySQLogData ......................." );
		Connection connection=null;
		String srt="";
		StringBuffer sBuffer= new StringBuffer();
		try{
		connection=UtilBaseTools.getConnection();
	    Statement statement =connection.createStatement();
	   
	    
	    statement.execute("CREATE TEMPORARY TABLE log (loginfo LONGBLOB);");
	    statement.execute("insert into log (loginfo) values (hex(load_file('c:/mysql/data/team3-012.err' )))") ;
		ResultSet rs=statement.executeQuery("select unhex(loginfo) from log");
		
		while (rs.next() ){
			srt= rs.getString(1) ;
		 }
		
			Calendar   calendar   =    Calendar.getInstance();   
			calendar.add(calendar.MONTH,-1);//得到上个月的时间  
			Date   date   =   calendar.getTime();   
			
			DateFormat FORMAT_DT_yyyy_MM_dd__HH_mm_ss = new SimpleDateFormat("yyMM");
			String bb=FORMAT_DT_yyyy_MM_dd__HH_mm_ss.format( date );
			
			for (int i=1;i<srt.split(bb).length;i++){
				sBuffer.append(  srt.split(bb)[i] );
			}
			}
		
		catch ( Exception e){
			logger.error(e);
		}
		finally {
			connection.close();
		}
		return sBuffer.toString();
	}

	/**
	public void killConnectionProcess(String ConnectionID) throws Exception {
		Connection connection=null;
		connection=UtilBaseTools.getConnection();
		try{
			connection.prepareStatement( "kill "+ConnectionID).execute();
		}
		catch ( Exception e){
			logger.error(e);
		}
		finally {
			connection.close();
		}
		 
	}
	 */
	
}