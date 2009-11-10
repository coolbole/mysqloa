package com.smb.MMUtil.testcase.createORM;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

import org.junit.Test;

import com.smb.MMUtil.handler.MySQLManagerJdbcUtilTools;
import com.smb.MMUtil.handler.base.UtilBaseTools;
import com.smb.MMUtil.pojo.MySQLShowColumns;

public class TestCaseCreateORMFile {
	
	
	@Test
	public void runCase ( ) throws Exception{
		String host="127.0.0.1";
		String dbName="smbcrm";
		String user="root";
		String pswd="123456";
		String tabNames[]={"crm_users","customer_contact","customer_contact_status"};
		String createORMID="hibernate";
		String packName="com.you.packeage.name";
		
		UtilBaseTools  orm= new UtilBaseTools(host, dbName ,user, pswd);
		MySQLManagerJdbcUtilTools  mmu= new MySQLManagerJdbcUtilTools(orm);
		
		//1. 得到一张表的完整信息
		List<MySQLShowColumns> list=mmu.showTableColumns(tabNames[0]);
		System.out.println ( list  );
		
		
		CreateORMFileFactory  Factory=new CreateORMFileFactory ();
		Factory.Factory(host, dbName, user, pswd, tabNames, packName,createORMID,list );
		
		//2. 组装(assembly) hibernate.cfg.xml 文件
	   /*String hibernate_cfg_xml_Path = TestCaseCreateORMFile.class.getResource ("hibernate/hibernate.cfg.xml").getFile();
	   BufferedReader   reader=new BufferedReader(new FileReader(hibernate_cfg_xml_Path));
				 String content=""; 
				 String line;
				 while((line=reader.readLine())!=null){
					 content+=line+"\n" ;
					}
				 content=content
				 .replaceAll("dbhost", host) 	
				 .replaceAll("dbname", dbName)  
				 .replaceAll("username", user)   
				 .replaceAll("password", pswd) ;
				 
				 content=content  .replaceAll("#", "") ;
				 
				 String mapping_resource="<mapping resource=\"\"/>";
				 
				 System.out.println (content.split(mapping_resource)[0]); 
				 
				 String FMTpackageName=packName.replaceAll("\\.", "/");
				 
				 for (int i=0;i<tabNames.length;i++){
					 System.out.println ("		<mapping resource=\""+FMTpackageName+"/"+tabNames[i]+"\"/>"); 
				 }
				 System.out.println (content.split(mapping_resource)[1]); 
				 */
				 
		
//		2.调用 工厂模式 根据 createORMID 使用那个 生成ORM的模板
//		3.根据 表结构 和 xml配置文件模板 ，生成 配置文件和 java程序
//		4.在服务器本地根据 时间戳 生成 流文件包
//		5.进行压缩，压缩成 zip  流文件，而不是
//		6.提供用户下载
		
		
		
	}

}
