package com.smb.MMUtil.handler.flashchart;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.smb.MMUtil.pojo.DiskInfoPojo;

public class FlashChartTools {
	
	private static Log logger = LogFactory.getLog(FlashChartTools.class);
	
	private static String colorA="333333";
	private static String colorB="99CC00";
	private static String colorC="000000";
	private static String colorD="FFFF00";
	
	
	
	public String getPortletAllStatusInfo (Map<?, ?> map){
		logger.info( "getPortletAllStatusInfo .......................\n" );
		
		StringBuffer sBuffer= new StringBuffer( );
		sBuffer.append("<chart palette='1' caption='' shownames='1' "   ).
		append("showvalues='1'  numberPrefix='' showSum='1' decimals='1' overlapColumns='0'  formatNumber='1'>").
		append(" <categories> "   ).
//		append(" <category label='Table Cache Size' /> "   ).
		append(" <category label='InnoDB MemPool' /> "   ).
		append(" <category label='Query Cache Size ' /> "   ).
		append(" <category label='Binlog Cache Size' /> "   ).
//		append(" <category label='InnoDB Log Buffer' /> "   ).
		append(" <category label='Sort Buffer Size' /> "   ).
//		append(" <category label='Key Buffer' />"   ).
		append(" <category label='Key Cache Block' />"   ).
		append(" <category label='Allowed Packet' />"   ).
		append(" </categories>"   ).
		
		
//		"innodb_additional_mem_pool_size","query_cache_limit",
//		"binlog_cache_size","innodb_buffer_pool_size",
//		"sort_buffer_size","key_cache_block_size",
//		"max_allowed_packet","table_cache",
		
		append(" <dataset seriesName=''  showValues='0'> "   ).
//		append("<set value='"+map.get("table_cache")+"' color='66CCFF'  />"   ).
		append("<set value='"+map.get("innodb_additional_mem_pool_size")+"'  link='compareVariablesAction.do'  color='CC0099'/>"   ).
		append("<set value='"+map.get("query_cache_limit")+"' color='33CC00' />"   ).
		append("<set value='"+map.get("binlog_cache_size")+"' color='FF0033'/>"   ).
//		append("<set value='"+map.get("innodb_buffer_pool_size")+"' color='66CCFF'/>"   ).
		append("<set value='"+map.get("sort_buffer_size")+"' color='009933'/>"   ).
		append("<set value='"+map.get("key_cache_block_size")+"' color='66CCFF' />"   ).
		append("<set value='"+map.get("max_allowed_packet")+"'   link='compareVariablesAction.do' color='0099CC' />"   ).
//		append("<set value='"+map.get("table_cache")+"' color='0099CC'/>"   ).
//		append("<set value='"+map.get("innodb_additional_mem_pool_size")+"' color='0099CC'/>"   ).
		
		append(" </dataset>  </chart>"   );
		
		return sBuffer.toString();
	}
	
	
	public String getDataBaseTablesInfoXML (List<DiskInfoPojo> list){
		logger.info( "getDataBaseTablesInfoXML .......................\n" );
		
		StringBuffer sBuffer= new StringBuffer( );
		sBuffer.append("<chart caption=' ' bgColor='FFFFFF,CCCCCC' showPercentageValues='1' " );
		sBuffer.append("plotBorderColor='FFFFFF' numberPrefix='$' isSmartLineSlanted='0'> \n");
		for (int i=0;i<list.size();i++){
			if (i%2==1){
				sBuffer.append("\t<set value='"+list.get(i).getTotal_Size()+"' label=' DataBase "+list.get(i).getDatabase_Name()
						+"' color='"+colorD+"' alpha='60'/>\n");
			}
			else{
				 if (i+1==list.size()-1 ){
			sBuffer.append("\t<set value='"+list.get(i).getTotal_Size()+"' label=' DataBase "+list.get(i).getDatabase_Name()
					+"' color='"+colorA+"' isSliced='1' alpha='60'/>\n");
				 }
				 else{
			sBuffer.append("\t<set value='"+list.get(i).getTotal_Size()+"' label=' DataBase "+list.get(i).getDatabase_Name()
					+"' color='"+colorC+"' alpha='60'/>\n");
			} 
				 }
		}
		
		sBuffer.append("\n</chart>");
		return sBuffer.toString();
	}
	 
	
	
	public String getDataBaseOnDiskSizeInfoXML (List<DiskInfoPojo> list){
		logger.info( "getDataBaseOnDiskSizeInfoXML .......................\n" );
		
		StringBuffer sBuffer= new StringBuffer( );
		sBuffer.append("<chart caption=' ' bgColor='FFFFFF,CCCCCC' showPercentageValues='1' " );
		sBuffer.append("plotBorderColor='FFFFFF' numberPrefix='$' isSmartLineSlanted='0'> \n");
		for (int i=0;i<list.size();i++){
			if (i%2==1){
				sBuffer.append("\t<set value='"+list.get(i).getData_Size()+"' label='"+list.get(i).getDatabase_Name()
						+"' color='"+colorB+"' alpha='60'/>\n");
			}
			else{
				 if (i+1==list.size()-2 ){
			sBuffer.append("\t<set value='"+list.get(i).getData_Size()+"' label='"+list.get(i).getDatabase_Name()
					+"' color='"+colorA+"' isSliced='1' alpha='60'/>\n");
				 }
				 else{
			sBuffer.append("\t<set value='"+list.get(i).getData_Size()+"' label='"+list.get(i).getDatabase_Name()
					+"' color='"+colorA+"' alpha='60'/>\n");
			} 
				 }
		}
		
		sBuffer.append("\n</chart>");
		return sBuffer.toString();
	}
	
	

}
