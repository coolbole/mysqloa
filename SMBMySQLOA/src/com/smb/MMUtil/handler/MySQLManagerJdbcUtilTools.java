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
			
//			QueryRunner run = new QueryRunner(  );
//			ResultSetHandler resultSetHandler = new BeanListHandler(MySQLShowProcessList.class );
//			result =  (List) run.query(connection,"show processlist",   resultSetHandler);
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
		List <MySQLVariableObject>  result = null;
		try{
			ResultSet rs=connection.prepareStatement( "show status"  ).executeQuery();
			while (rs.next() ){
				MySQLVariableObject  variable= new MySQLVariableObject();	
				variable.setVariable_name( rs.getString(1)   );variable.setValue(rs.getString(2));
				result.add( variable  );
			}
//			QueryRunner run = new QueryRunner(   );
//			ResultSetHandler resultSetHandler =new BeanListHandler( MySQLVariableObject.class );
//			result =  (List) run.query(connection,"show status",   resultSetHandler);
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
//			QueryRunner run = new QueryRunner(  );
//			ResultSetHandler resultSetHandler = new BeanListHandler( MySQLVariableObject.class );
//			result =  (List) run.query(connection,"show status like '%"+category+"%' ",   resultSetHandler);
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
	
	/*public void runCommand (){
		IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools();
		try {
			
			mmu.setVariblesCommandByCategory("wait_timeout", "20000");
			List <MySQLVariableObject>  list=mmu.
					 showVariblesCommandByCategory("wait_timeout");
			
			for (int i=0;i<list.size();i++){
 					System.out.println( list .get(i).getVariable_name() +"    "+ list .get(i).getValue() );	
				}
			
			list=mmu.showVariblesCommand();
			System.out.println( list.size() );
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}