/**
 * 
 */
package com.smb.MMUtil.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.handler.IMySQLManagerJdbcUtilTools;
import com.smb.MMUtil.handler.MySQLManagerJdbcUtilTools;
import com.smb.MMUtil.handler.base.UtilBaseTools;
import com.smb.MMUtil.handler.xml.ReadMySQLConfigXMLFile;
import com.smb.MMUtil.pojo.MySQLVariableDescription;
import com.smb.MMUtil.pojo.MySQLVariableObject;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;


public class ShowSatusAction   implements ControllerAction  {
	
	private static Log logger = LogFactory.getLog(ShowSatusAction.class);
	private static ReadMySQLConfigXMLFile  DescriptionXMLFile= new ReadMySQLConfigXMLFile();
	
	public ModelAndPage handleModelAndPage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try{
			logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
		
			if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
		    
		    String host= request.getSession().getAttribute("host").toString() ;
		    String username= request.getSession().getAttribute("username").toString();
		    String password= request.getSession().getAttribute("password").toString();
		    
		    UtilBaseTools orm= new UtilBaseTools(host,null,username,password);
			IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
			List <MySQLVariableDescription> listF=DescriptionXMLFile.getMySQLStatusDescription();
			
			List <MySQLVariableObject> listS=null;
			String category=request.getParameter("category");
			
			String warn="";
			if(category==null){
				request.setAttribute("warn",""); 
				listS=mmu.showStatusCommand( );
			}
			else{
				request.setAttribute("warn",""); 
				listS=mmu.showStatusCommandByCategory(category);
				if(category.equals("cache")){
					warn="<b> 提示：如果该页面出现的 “0” 值 比较多的话，说明您的MySQL数据库基本没有很好的优化，如果具有非“0”的值请检查是否被合理使用。</b><br>  "; 
					request.setAttribute("warn",warn);   
				}
			}
				
			 	request.setAttribute("listF",listF);      
				request.setAttribute("listS",listS);      
			 
			    return new ModelAndPage( request ,"/WEB-INF/page/show/showStatus.jsp" );
		}
		
		catch(Exception e ) {
			 logger.error(e);
		}
		return null;
	}
}
 