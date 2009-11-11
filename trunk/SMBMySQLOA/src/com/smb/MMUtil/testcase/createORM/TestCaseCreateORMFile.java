package com.smb.MMUtil.testcase.createORM;

import java.util.List;

import org.junit.Test;

import com.smb.MMUtil.handler.MySQLManagerJdbcUtilTools;
import com.smb.MMUtil.handler.base.UtilBaseTools;
import com.smb.MMUtil.handler.createORM.CreateORMFileFactory;
import com.smb.MMUtil.pojo.CreateORMPojo;

public class TestCaseCreateORMFile {
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void runCase ( ) throws Exception{
		String host="127.0.0.1";
		String dbName="srvphone";
		String user="root";
		String pswd="123456";
		String tabNames[]={"firewall","firewallrecord"};
		String createORMID="hibernateSpring";
		String packName="com.you.packeage.name";
		
		UtilBaseTools  orm= new UtilBaseTools(host, dbName ,user, pswd);
		MySQLManagerJdbcUtilTools  mmu= new MySQLManagerJdbcUtilTools(orm);
		
		//1. 得到一张表的完整信息
//		List tables= new ArrayList ();
//		 for (int i=0;i <tabNames.length;i++){
//			 List<MySQLShowColumns> list=mmu.showTableColumns(tabNames[i]);
//				tables.add(  list );
//		 }
		
		List tables= mmu.showTABLESColumns(tabNames);
		CreateORMFileFactory  Factory=new CreateORMFileFactory ();
		CreateORMPojo   ORMPojo=Factory.factoryCreateORMPojo(host, dbName, user, pswd, tabNames, packName,createORMID,tables );
		
		System.out.println ( ORMPojo.getCreateType()  );
		System.out.println ( ORMPojo.getSpringFile() );
		System.out.println ( ORMPojo.getOrmMappingFiles() );
		System.out.println ( ORMPojo.getOrmCFGFile() );
		
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
