package com.smb.MMUtil.queryAnalyzer;

import java.sql.SQLException;
import java.util.Map;

public interface IMySQLQueryAnalyzer {
	
	public Map CUDSQLWildcard( String SQL ) throws SQLException;
	
	public Map QueryWildcard( String SQL ) throws SQLException;
}
