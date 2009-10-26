/**
 * 
 */
package com.smb.MMUtil.testcase;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import com.smb.MMUtil.handler.IMySQLManagerJdbcUtilTools;
import com.smb.MMUtil.handler.MySQLManagerJdbcUtilTools;
import com.smb.MMUtil.handler.base.UtilBaseTools;
import com.smb.MMUtil.handler.xml.ReadMySQLValueDescriptionXMLFile;
import com.smb.MMUtil.pojo.MySQLVariableDescription;
import com.smb.MMUtil.pojo.MySQLVariableObject;
import com.smb.MMUtil.pojo.ReplicationStatusPojo;

/**
 * @author huangyi
 *
 */
public class MapCompare {
	
	@Test
	public void showMasterReplicationStatus () throws Exception{
		UtilBaseTools orm= new UtilBaseTools("192.168.12.78",null,"root","123456");
		
		IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
		String list= mmu.CreateAutoCreateConfig("4g");
		System.out.println (list);
		 
		
	}
	
//		@Test
		public void fileAndshowTestCase () throws Exception{
			UtilBaseTools orm= new UtilBaseTools("192.168.12.212",null,"root","123456");
			
			IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
			List <MySQLVariableObject> listS=mmu.showVariblesCommand();
			
			ReadMySQLValueDescriptionXMLFile  DescriptionXMLFile= new ReadMySQLValueDescriptionXMLFile();
			List <MySQLVariableDescription> listF=DescriptionXMLFile.getMySQLVariableDescription();
			
				for (int i=0;i<listS.size();i++){
				
				for (int h=0;h<listF.size();h++){
				if(	listS.get(i).getVariable_name().equals(listF.get(h).getVariable_name() ) ){
					System.out.print (listS.get(i).getVariable_name()+"   "  ); 
					System.out.print (listS.get(i).getValue()+"   "  ); 
					System.out.print (listF.get(h).getDescription() +"  \n "  ); 
				}
				}
				 
			}
				System.out.print (listS.size()+"  \n "  ); System.out.print (listF.size()+"  \n "  ); 
			
				List ll=mmu.showProcesslistCommand();
				System.out.print (ll+"  \n "  ); 
			}
	
	
//		@Test
		public void runTestCase() throws Exception{
			
			List<MySQLVariableObject> list1= new ArrayList ();
			MySQLVariableObject  v1= new MySQLVariableObject();
			v1.setValue("1"); v1.setVariable_name("innodb_lock_wait_timeout");
			
			MySQLVariableObject  v2= new MySQLVariableObject();
			v2.setValue("1"); v2.setVariable_name("table_lock_wait_timeout");
			
			MySQLVariableObject  v3= new MySQLVariableObject();
			v3.setValue("2"); v3.setVariable_name("sql_mode");
			
			list1.add(v2); 
    		list1.add(v1);	
 			list1.add(v3);
	 
			
			List<MySQLVariableDescription> list2= new ArrayList ();
			MySQLVariableDescription  d1= new MySQLVariableDescription();
			d1.setDescription("在回�?rooled back)之前，InnoDB 事务将等待超时的时间(单位 �?。InnoDB 会自动检查自身在锁定表与事务回滚时的事务死锁。如果使�?LOCK TABLES 命令，或在同�?��事务中使用其它事务安全型表处理器(transaction safe table handlers than InnoDB)，那么可能会发生�?�� InnoDB 无法注意到的死锁。在这种情况下超时将用来解决这个问题。这个参数的默认值为 50 秒�?�?my.cnf 中以数字格式设置�?MySQL可以自动地监测行锁导致的死锁并进行相应的处理，但是对于表锁导致的死锁不能自动的监测，�?��该参数主要被用于在出现类似情况的时�?等待指定的时间后回滚。系统默认�?�?0秒，用户可以根据应用的需要进行调整�?");
			d1.setVariable_name("innodb_lock_wait_timeout");
			MySQLVariableDescription  d2= new MySQLVariableDescription();
			d2.setDescription("表示在Mysql服务器锁表的时�?�?��等待的时间长度�?");
			d2.setVariable_name("table_lock_wait_timeout");
			list2.add(d1); list2.add(d2);
			
			IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(null);
			List <MySQLVariableObject> list=mmu.showVariblesCommand();
			
			
			for (int i=0;i<list.size();i++){
				
				for (int h=0;h<list2.size();h++){
				if(	list.get(i).getVariable_name().equals(list2.get(h).getVariable_name() ) ){
					System.out.print (list.get(i).getVariable_name()+"   "  ); 
					System.out.print (list.get(i).getValue()+"   "  ); 
					System.out.print (list2.get(h).getDescription() +"  \n "  ); 
				}
				}
				 
			}
			 
			}
}
