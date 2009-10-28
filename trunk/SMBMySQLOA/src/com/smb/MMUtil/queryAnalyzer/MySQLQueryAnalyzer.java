/**
 * 
 */

package com.smb.MMUtil.queryAnalyzer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.handler.base.UtilBaseTools;

/**
 * @author huangyi
 *
 */
public class MySQLQueryAnalyzer implements IMySQLQueryAnalyzer {
	
	private UtilBaseTools  UtilBaseTools;
	
	private static Log logger = LogFactory.getLog(MySQLQueryAnalyzer.class);
	
	public MySQLQueryAnalyzer(UtilBaseTools utilBaseTools){UtilBaseTools=utilBaseTools;}
	
	public Map CUDSQLWildcard( String SQL ) throws SQLException{
		logger.info(SQL);
		Map result= new HashMap();
		List sql= new ArrayList ();
		Connection connection=null;
		String sqlsplit[]=SQL.split(";");
		int SQLCount=sqlsplit.length;
		
		logger.info(sqlsplit.length);
		
		try {
			connection=UtilBaseTools.getConnection();
			if (SQLCount<3){
				 connection.prepareStatement( SQL).execute() ;
				 sql.add( SQL ); result.put("SQLCount", 1);
			}
			else{
				for (int i=1;i<SQLCount;i++){
					connection.prepareStatement( sqlsplit[i-1]  ).execute() ;
					sql.add(  sqlsplit[i-1] ); result.put("SQLCount", sqlsplit.length-1);
					}
			}
			
			result.put("sql", sql);
		}
		catch (Exception e) {
				logger.error( e .getMessage() );
		}
		finally {
			connection.close();
		}
		return result;
	}
		
	 
	
	
	public Map QueryWildcard( String SQL ) throws SQLException{ 
		Map result= new HashMap();
		List columns= new ArrayList ();
		List values= new ArrayList ();
		logger.info(SQL);
		Connection connection=null;
		try {
			connection=UtilBaseTools.getConnection();
			ResultSet rs=connection.prepareStatement( SQL ).executeQuery();
			ResultSetMetaData MetaData= rs.getMetaData();
			int MetaDataSize=MetaData.getColumnCount() ;
			
			values.add( "<tr>"  );
			for (int i=0;i<MetaDataSize ;i++){
				columns.add("<td>"+rs.getMetaData().getColumnName(i+1) +"</td>") ;
			} 
			values.add( "</tr>"  );
 			int count=0;
 			
 			values.add( "<tr>"  );
			while (rs.next()){
				count=count +1;
				 for (int i=0;i<MetaDataSize;i++){
					 values.add("<td>"+rs.getString(i+1)+"</td>"  );
				 }
				 values.add( "</tr>"  );
 			}
 			
			result.put("sql", SQL);
 			result.put("count", count);
			result.put("columns", columns);
			result.put("values", values);
		}
		catch (Exception e) {
			result.put("err",  e .getMessage() );
				logger.error( e .getMessage() );
		}
		finally {
			connection.close();
		}
		return result;
	}
	
}
