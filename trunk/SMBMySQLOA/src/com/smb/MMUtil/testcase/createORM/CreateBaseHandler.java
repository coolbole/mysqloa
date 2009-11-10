package com.smb.MMUtil.testcase.createORM;

import java.io.BufferedReader;
import java.io.FileReader;

public class CreateBaseHandler {

	public String getFiletoString(String xml_Path)   {
		
		StringBuffer xmlContent = new StringBuffer();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(xml_Path));
			String line;
				while ((line = reader.readLine()) != null) {
					xmlContent.append(line).append("\n");
			}
		}

		catch (Exception e) {
			 
		}
		return xmlContent.toString();
	}
	
	public String getFMTpackName(String packName) throws Exception {
		
		String FMTpackageName=packName.replaceAll("\\.", "/");
		
		return FMTpackageName;
	}
	
}
