package com.smb.MMUtil.handler.base;

import java.math.BigDecimal;

public class CommonTools {
	
	public static  String convCapacityTools (double data_Size){
		String Data_Size="";
		if (data_Size<1024){
			Data_Size=data_Size+" kb";
		}
		else if (data_Size>1024){
			if (data_Size/1024>1024 ){
				 BigDecimal digDecimal= new BigDecimal( data_Size/1024/1024);
				 Data_Size=digDecimal.setScale(2, 4)+" M";
			}
			else{
				BigDecimal digDecimal= new BigDecimal( data_Size/1024);
				Data_Size=digDecimal.setScale(2, 4)+" K";
			}
		}
		return Data_Size; 
	}
}
