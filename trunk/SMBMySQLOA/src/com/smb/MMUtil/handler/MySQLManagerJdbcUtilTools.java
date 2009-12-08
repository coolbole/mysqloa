/**
 * 
 */
package com.smb.MMUtil.handler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//import org.apache.commons.dbutils.DbUtils;
//import org.apache.commons.dbutils.QueryRunner;
//import org.apache.commons.dbutils.ResultSetHandler;
//import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.handler.base.JDBCUtilBaseTools;
import com.smb.MMUtil.handler.xml.ReadMySQLConfigXMLFile;
import com.smb.MMUtil.pojo.DiskInfoPojo;
import com.smb.MMUtil.pojo.MySQLAutoConfigCase;
import com.smb.MMUtil.pojo.MySQLOpenTables;
import com.smb.MMUtil.pojo.MySQLOptimizeCase;
import com.smb.MMUtil.pojo.MySQLShowColumns;
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
	
	public  MySQLManagerJdbcUtilTools(JDBCUtilBaseTools JDBCUtilBaseTools){
		this.JDBCUtilBaseTools=JDBCUtilBaseTools;
	}
	
	private JDBCUtilBaseTools  JDBCUtilBaseTools;
	
 
	public List<MySQLShowProcessList>  showProcesslistCommand( ) throws  Exception {
		logger.info( "showProcesslist ......................." );
		Connection connection=null;
		connection=JDBCUtilBaseTools.getConnection();
		List <MySQLShowProcessList> result =  new ArrayList<MySQLShowProcessList>();
		try{
				ResultSet rs=connection.prepareStatement( "show full processlist"  ).executeQuery();
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
		connection=JDBCUtilBaseTools.getConnection();
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
		connection=JDBCUtilBaseTools.getConnection();
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
		connection=JDBCUtilBaseTools.getConnection();
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
		connection=JDBCUtilBaseTools.getConnection();
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
			connection=JDBCUtilBaseTools.getConnection();
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
	
	
	public void setVariblesByCommands(String commands) throws Exception {
		Connection connection=null;
		connection=JDBCUtilBaseTools.getConnection();
		
		try {
			String command[]=commands.split(",");
			
 			 connection.setAutoCommit(false);
			 for (int i=0;i<command.length;i++){
				 String SQL= "SET  GLOBAL "+command[i] ;  SQL=SQL.toLowerCase(); 
				logger.info("[ Command :"+SQL  + " ]  ");
					
				if (SQL.indexOf("table_cache")!=-1 ){
 						if (showDetailVaribles(SQL.split("=")[0].split(" ")[3] )==null){
 							 connection.prepareStatement(SQL .replaceAll("table_cache", "table_open_cache") ).execute();
 						}
 							else{   connection.prepareStatement(SQL).execute();  }
					}
				else{
				 connection.prepareStatement(SQL).execute();
					}
			 }
				
 		 connection.commit();
		} 
		catch ( Exception e) {
 			connection.rollback();
			logger.error(e);
			 throw new Exception(e);
		}
		finally {
			connection.close();
			}
	}
	

	public MySQLVariableObject showDetailVaribles(String variable_name)  throws Exception {
		Connection connection=null;
		connection=JDBCUtilBaseTools.getConnection();
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
		connection=JDBCUtilBaseTools.getConnection();
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
		connection=JDBCUtilBaseTools.getConnection();
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
		connection=JDBCUtilBaseTools.getConnection();
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
		connection=JDBCUtilBaseTools.getConnection();
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
					 long day=uptime/60/24;
					 long timeduo=(uptime/60)-(24*day);
					 
					 variable=variable+ "(  "+day +"天多 " +timeduo +" 个小时 )";
				 }
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

	@SuppressWarnings("unchecked")
	public List showDataBases() throws Exception {
		logger.info( "showDataBases ......................." );
		Connection connection=null;
		connection=JDBCUtilBaseTools.getConnection();
		List   result = new ArrayList();
		try{
			ResultSet rs=connection.prepareStatement( "show  databases"  ).executeQuery();
			while (rs.next() ){
				result.add( rs.getString(1)  );
			}
			result.remove("information_schema");
			
		}
		catch ( Exception e){
			logger.error(e);
		}
		finally {
			connection.close();
		}
		return result;
	}

	
	public Map<Object, Object> showTableRows() throws Exception {
		logger.info( "showDataBases ......................." );
		Connection connection=null;
		connection=JDBCUtilBaseTools.getConnection();
		Map<Object, Object>    result = new HashMap <Object, Object> ();
		try{
			ResultSet rs=connection.prepareStatement("show table status").executeQuery();
			while (rs.next() ){
				result.put(rs.getString("Name") , "   ("+rs.getString("Rows") +")" ) ; 
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
		connection=JDBCUtilBaseTools.getConnection();
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
			connection=JDBCUtilBaseTools.getConnection();
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
							
							if (SQL.indexOf("table_open_cache")!=-1 ){
								MySQLVariableObject table_cache= showDetailVaribles(value)  ;
								if (table_cache !=null  ){
									logger.info(SQL);
									optimizedList.add(commands[h].replaceAll("\t", ""));
									connection.prepareStatement( SQL  ).execute();
									}   // if table_cache
								
							}
							else{
								connection.prepareStatement( SQL  ).execute();
								optimizedList.add(commands[h].replaceAll("\t", ""));
							}
							
						
						}  //if 
						}  // for
						 
						}   //if  Optimize.equals
				
			}
			}
		catch(Exception e) {
			logger.error(e);
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
		connection=JDBCUtilBaseTools.getConnection();
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

	
	
	@SuppressWarnings("unchecked")
	public List<?>  showTABLESColumns(String tablename[]) throws Exception {
		logger.info( "showTableColumns ... ....tablename :[ "+  tablename +" ]");
		Connection connection=null;
		connection=JDBCUtilBaseTools.getConnection();
		List<MySQLShowColumns> list = new ArrayList<MySQLShowColumns> ();
		List tables= new ArrayList ();
		try{
			
			for (int i=0;i<tablename.length;i++){
				ResultSet rs=connection.prepareStatement("show columns from  "+tablename[i]  ).executeQuery();
				while (rs.next() ){ 
					MySQLShowColumns  showColumns=new  MySQLShowColumns();
					
					showColumns.setField( rs.getString("field") );
					showColumns.setType( rs.getString("type") );
					showColumns.setIsnull( rs.getString("null") );
					showColumns.setKey( rs.getString("key") );
					showColumns.setDefaults( rs.getString("default") );
					showColumns.setExtra( rs.getString("extra") );
					list.add( showColumns  );
					}    // while
			
				tables.add(list);
			}     //for
			
		}
		catch ( Exception e){
			logger.error(e);
		}
		finally {
			connection.close();
		}
		return tables;
	}
	
	
	
	public List<MySQLShowColumns> showTableColumns(String tablename) throws Exception {
		logger.info( "showTableColumns ... ....tablename :[ "+  tablename +" ]");
		Connection connection=null;
		connection=JDBCUtilBaseTools.getConnection();
		List<MySQLShowColumns> list = new ArrayList<MySQLShowColumns> ();
		try{
			ResultSet rs=connection.prepareStatement("show columns from  "+tablename  ).executeQuery();
			while (rs.next() ){ 
				MySQLShowColumns  showColumns=new  MySQLShowColumns();
				
				showColumns.setField( rs.getString("field") );
				showColumns.setType( rs.getString("type") );
				showColumns.setIsnull( rs.getString("null") );
				showColumns.setKey( rs.getString("key") );
				showColumns.setDefaults( rs.getString("default") );
				showColumns.setExtra( rs.getString("extra") );
				list.add( showColumns  );
				
			}
		}
		catch ( Exception e){
			logger.error(e);
		}
		finally {
			connection.close();
		}
		return list;
	}
	
	public String showCreateTable(String tablename) throws Exception {
		logger.info( "showCreateTable ......................." );
		Connection connection=null;
		connection=JDBCUtilBaseTools.getConnection();
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

	
	public void  flushTable() throws Exception {
		logger.info( "flushTable ......................." );
		Connection connection=null;
		connection=JDBCUtilBaseTools.getConnection();
		try{
			connection.prepareStatement("flush  table"  ).execute();
			}
 
		catch ( Exception e){
			logger.error(e);
		}
		finally {
			connection.close();
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	public List showOpentables() throws Exception {
		logger.info( "showOpentables ......................." );
		Connection connection=null;
		connection=JDBCUtilBaseTools.getConnection();
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
	
	
	public List <MySQLTableIndex> showTableIndexs(String DBName) throws Exception {
		logger.info( "showTableIndexs ......................." );
		Connection connection=null;
		connection=JDBCUtilBaseTools.getConnection();
		List<MySQLTableIndex>  opentablesList=  new ArrayList<MySQLTableIndex>();
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
		connection=JDBCUtilBaseTools.getConnection();
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

 
	public void killConnectionProcess(String ConnectionID) throws Exception {
		logger.info( "killConnectionProcess ......................." );
		Connection connection=null;
		connection=JDBCUtilBaseTools.getConnection();
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

	public List <DiskInfoPojo>  showTablesCount ( ) throws Exception {
		logger.info( "showTablesCount ......................." );
		Connection connection=null;
		connection=JDBCUtilBaseTools.getConnection();
		List<DiskInfoPojo> map = new ArrayList<DiskInfoPojo> ();
		try{
			 ResultSet rs=connection.
			 prepareStatement("SELECT  TABLE_SCHEMA, count(distinct(TABLE_NAME) ) from TABLES where TABLE_SCHEMA !='information_schema'  group by TABLE_SCHEMA ").
			 executeQuery();
			 while (rs.next()){
				 DiskInfoPojo  info = new DiskInfoPojo();
				 info.setDatabase_Name(  rs.getString(1) );
				 info.setTotal_Size(  rs.getInt(2) );
				 map.add( info);
			 }
		}
		catch ( Exception e){
			logger.error(e);
		}
		finally {
			connection.close();
		}
		return map;
		 
	}
	
	
	
	
	public List<?> showTablesCommand(String DBName) throws Exception {
		logger.info( "showTablesCommand ......................." );
		Connection connection=null;
		connection=JDBCUtilBaseTools.getConnection();
		List<String> tables= new ArrayList<String> ();
		try{
			 ResultSet rs=connection.prepareStatement("show tables").executeQuery();
			 while (rs.next()){
				 tables.add(   rs.getString(1));
			 }
		}
		catch ( Exception e){
			logger.error(e);
		}
		finally {
			connection.close();
		}
		return tables;
		 
	}

	@SuppressWarnings("unchecked")
	public Map  showTableDataInfo(String tableName,int startPaged, int endPaged) throws Exception {
		logger.info( "showTableDataInfo ......................." );
		Map map = new HashMap  ();
		StringBuffer sBuffer = new StringBuffer();
		Connection connection=null;
		connection=JDBCUtilBaseTools.getConnection();
		List<String> tableFields= new ArrayList<String> ();
		List<String>  pageOutPut= new ArrayList<String> ();
		try{
			 ResultSet rs=connection.prepareStatement("desc "+ tableName).executeQuery();
			 while (rs.next()){
				 tableFields.add(rs.getString(1));
			 }
			 
			pageOutPut.add( "<tr>"  );
				for (int i=0;i<tableFields.size() ;i++){
					pageOutPut.add("<td> <b>"+tableFields.get(i) +"</b></td>") ;
			} 
			 
			 
			 sBuffer.append("select ");
			 for ( int i=0;i<tableFields.size();i++){	 sBuffer.append(tableFields.get(i)).append(",");	 }
			 sBuffer.append( "from ").append( tableName).append(" limit ?,?");String SQL= sBuffer.toString().replaceAll(",from ", " from ") ;
 			 
 			PreparedStatement pstmt=connection.prepareStatement(SQL);
  			pstmt.setInt(1,startPaged);pstmt.setInt(2,endPaged);  rs=pstmt.executeQuery();
  		
  		
			pageOutPut.add( "</tr>"  );
  			
  			pageOutPut.add( "<tr>"  );
  			 while (rs.next()){
  				for ( int i=0;i<tableFields.size();i++){
  					pageOutPut.add("<td>"+rs.getString(i+1)+"&nbsp;</td>"  );
  				 }
  				pageOutPut.add( "</tr>"  );
  			}
  			
  			StringBuffer SQLcounts= new  StringBuffer();
  			SQLcounts.append("select count(*) from ").append(tableName );
  			rs=connection.prepareStatement(SQLcounts.toString() ).executeQuery();
			int counts=0;
  			while (rs.next()){
  				counts=rs.getInt(1);
			 }
  			
  			 
  			map.put("pageOutPut", pageOutPut);
  			map.put("counts", counts);
  			 
		}
		catch ( Exception e){
			logger.error(e);
		}
		finally {
			connection.close();
		}
		return map;
		 
	}
	 
	public List<DiskInfoPojo> getDataBaseDiskInfo (  ) throws  Exception{
		logger.info( "getDataBaseDiskInfo ......................." );
		Connection connection=JDBCUtilBaseTools.getConnection();
		List<String> databaseslist = new ArrayList<String> ();
		List<DiskInfoPojo> diskInfos= new  ArrayList<DiskInfoPojo> ();
		try{
		ResultSet databasesResult=connection.prepareStatement("show databases").executeQuery();
		while (databasesResult.next()){
			databaseslist.add( databasesResult.getString(1)  );
		}
		 
		for (int i=0;i<databaseslist.size();i++){
		ResultSet tableResult=connection.prepareStatement("show table status from "+databaseslist.get(i)).executeQuery();
			long data_length=0;
			long index_size=0;
			int rows=0;
			while (tableResult.next()){
						rows+=tableResult.getInt("Rows");
						data_length+=tableResult.getLong("data_length");
						index_size+=tableResult.getLong("index_length");
			}
			DiskInfoPojo  diskInfoPojo= new DiskInfoPojo();
			diskInfoPojo.setDatabase_Name( databaseslist.get(i).toString() );
			diskInfoPojo.setRows(rows);
			diskInfoPojo.setData_Size(  data_length );
			diskInfoPojo.setTotal_Size( data_length+index_size);
			diskInfoPojo.setIndex_Size( index_size );
			
			diskInfos.add(diskInfoPojo);
		}
		}
		catch ( Exception e){
			logger.error(e);
		}
		finally {
			connection.close();
		}
		return diskInfos;
	}

}
	
	
 