package com.smb.MMUtil.queryAnalyzer;

import java.sql.SQLException;
import java.util.Map;

public interface IMySQLQueryAnalyzer {
	
	@SuppressWarnings("unchecked")
	public Map CUDSQLWildcard( String SQL ) throws SQLException;
	
	@SuppressWarnings("unchecked")
	public Map QueryWildcard( String SQL ) throws SQLException;
}
