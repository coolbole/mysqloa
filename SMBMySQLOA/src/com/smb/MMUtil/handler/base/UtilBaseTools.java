/**
 * Copyright (c) SMB OpenSoftWare Team
 * All rights reserved.
 * 
 * Redistribution and use in source and binary OpenSoftWare OTS project, 
 * with or without modification, are permitted provided 
 * that the following conditions are met:
 * 
 * 1) Redistributions of source code must retain the above 
 * copyright notice, this list of conditions and the 
 * following  disclaimer.
 * 
 * 2)  Redistributions in binary form must reproduce the 
 * above copyright notice, this list of conditions and 
 * the following disclaimer in the documentation and/or 
 * other materials provided with the distribution.
 * 
 * 3) Neither the name of "H.E." or "Yi Huang" nor 
 * the names of its contributors may be used to endorse 
 * or promote products derived from this software without 
 * specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT 
 * HOLDERS AND CONTRIBUTORS "AS IS" AND ANY 
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, 
 * BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF 
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR 
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL 
 * THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE 
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, 
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES 
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, 
 * OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER 
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER 
 * IN CONTRACT, STRICT LIABILITY, OR TORT 
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN 
 * ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF 
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE
 * 
 * This file creation date: 10/11/2008 - 18:44:56
 * The OpenSoftWare OTS Project
 * http://code.google.com/p/smbopensoft/
 */

package com.smb.MMUtil.handler.base;

import java.sql.Connection;
import java.sql.DriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This Class is  Database Base Tools  methods
 * 
 * @author H.E.
 *
 */

public class  UtilBaseTools  {
	
	private static Log logger = LogFactory.getLog(UtilBaseTools.class);
	
	public UtilBaseTools(String Host, String Db,String User, String Passwd ){
		 		host=Host;	user=User;	passwd=Passwd;  db=Db;
	}
	
	private static String db;
	private static String host;
	private static String user;
	private static String passwd;
	
	public Connection getConnection() throws  Exception{
		logger.info("["+host+ "]  ["+db+ "] [" +user+"]  ["+passwd+ "]getConnection .................... \n");
		try{
			if (db==null){ 
				db="";
			}
			Class.forName("com.mysql.jdbc.Driver" );    
			Connection connection = DriverManager.getConnection("jdbc:mysql://"+host+"/"+db,user,passwd);  
			return connection;
		}
		catch (Exception e){
			logger.error(e);	
			throw  new Exception(e); 
		}
		
	}
}