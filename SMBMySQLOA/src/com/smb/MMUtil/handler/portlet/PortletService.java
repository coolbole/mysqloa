/**
 * 
 */

package com.smb.MMUtil.handler.portlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.handler.base.JDBCUtilBaseTools;
import com.smb.MMUtil.pojo.MySQLShowProcessList;

/**
 * @author ivan
 */

public class PortletService {
	
	private static Log logger = LogFactory.getLog(PortletService.class);
	
	private Connection connection=null;
	
	public  PortletService(JDBCUtilBaseTools JDBCUtilBaseTools) throws Exception{
		connection=JDBCUtilBaseTools.getConnection();
	}

	
	public Map<String, Object>  showProcesslistCommand( ) throws  Exception {
		logger.info("showProcesslistCommand .........................");
		
		List <MySQLShowProcessList> result =  new ArrayList<MySQLShowProcessList>();
		Map<String, Object> map = new HashMap<String, Object> ();
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
				String  variable="这台MySQL运行了 ";
				long uptime=0;
				rs=connection.prepareStatement(" show   status  like 'uptime' " ).executeQuery();
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
				 
				 String  version=  null;
				 rs=connection.prepareStatement( "SELECT VERSION()"  ).executeQuery();
				while (rs.next() ){ 
						version=rs.getString(1);
					}
				 
			map.put( "processlist", result);
 			map.put( "uptime", variable);
 			map.put( "version", version);
			
		}
		catch ( Exception e){
			logger.error(e);
		}
		finally {
//			connection.close();
		}
		return map;
	}
		
		public Map<String, Long>  getFlashchartData () throws Exception{
			logger.info("getFlashchartData .........................");
			Map<String, Long> map = new HashMap<String, Long> ();
			String Variable_Names[]={
					"innodb_additional_mem_pool_size","query_cache_limit",
					"binlog_cache_size","innodb_buffer_pool_size",
					"sort_buffer_size","key_cache_block_size",
					"max_allowed_packet","table_cache",
			};
 		
			try{
				for (int i=0;i<Variable_Names.length;i++){
					PreparedStatement pstatm=connection.prepareStatement( " show variables where Variable_name='"+Variable_Names[i]+"' ");
					java.sql.ResultSet rs=pstatm.executeQuery();
					while (rs.next() ){
//						if (Variable_Names[i].equals("table_cache") ){
//							map.put(Variable_Names[i],  rs.getLong(2)*1000*1000 );
//						}
//						else{
							map.put(Variable_Names[i],  rs.getLong(2) );
//						}
					}
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
	
}

