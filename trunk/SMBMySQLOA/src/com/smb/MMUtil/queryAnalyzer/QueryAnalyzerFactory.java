/**
 * 
 */
package com.smb.MMUtil.queryAnalyzer;

import java.sql.SQLException;
import java.util.Map;
import com.smb.MMUtil.handler.base.JDBCUtilBaseTools;

/**
 * @author huangyi
 *
 */
public class QueryAnalyzerFactory {
	
	public  QueryAnalyzerFactory(JDBCUtilBaseTools utilBaseTools){ UtilBaseTools=utilBaseTools; }
		
	private JDBCUtilBaseTools  UtilBaseTools;
	
	@SuppressWarnings("unchecked")
	public Map execResult (String SQL ) throws SQLException{
		
		MySQLQueryAnalyzer  MQA= new MySQLQueryAnalyzer(UtilBaseTools);
		Map map= null;
		SQL=SQL.toLowerCase();
			if (SQL.indexOf("select")!=-1){
				map=MQA.QueryWildcard(SQL);
				}
			else{
				map=MQA.CUDSQLWildcard(SQL);
				}
			return map;
		}

}
