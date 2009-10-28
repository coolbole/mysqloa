/**
 * 
 */
package com.smb.MMUtil.queryAnalyzer;

import java.sql.SQLException;
import java.util.Map;
import com.smb.MMUtil.handler.base.UtilBaseTools;

/**
 * @author huangyi
 *
 */
public class QueryAnalyzerFactory {
	
	public  QueryAnalyzerFactory(UtilBaseTools utilBaseTools){ UtilBaseTools=utilBaseTools; }
		
	private UtilBaseTools  UtilBaseTools;
	
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
