package com.smb.MMUtil.handler.flashchart;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.smb.MMUtil.pojo.DiskInfoPojo;

public class FlashChartTools {
	
	private static Log logger = LogFactory.getLog(FlashChartTools.class);
	
	private static String colorA="333333";
	private static String colorB="99CC00";
	private static String colorC="000000";
	private static String colorD="FFFF00";
	
	
	public String getDataBaseTablesInfoXML (List<DiskInfoPojo> list){
		logger.info( "getDataBaseOnDiskSizeInfoXML .......................\n" );
		
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
