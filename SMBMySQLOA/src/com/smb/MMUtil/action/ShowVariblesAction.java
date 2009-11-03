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

public class ShowVariblesAction   implements ControllerAction  {
	
	private static Log logger = LogFactory.getLog(ShowVariblesAction.class);
	private static ReadMySQLConfigXMLFile  DescriptionXMLFile= new ReadMySQLConfigXMLFile();
	
	@SuppressWarnings("unchecked")
	public ModelAndPage handleModelAndPage(HttpServletRequest request,  HttpServletResponse response)  throws Exception  {

		logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
	
		 if(request.getSession().getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
	    
	    String host= request.getSession().getAttribute("host").toString() ;
	    String username= request.getSession().getAttribute("username").toString();
	    String password= request.getSession().getAttribute("password").toString();
	    
	    UtilBaseTools orm= new UtilBaseTools(host,null,username,password);
		IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
		
		
		List <MySQLVariableDescription> listF=DescriptionXMLFile.getMySQLVariableDescription();
		
		List <MySQLVariableObject> listS=null;
		String category=request.getParameter("category");
		
		if(category==null){
			listS=(List<MySQLVariableObject>) mmu.showVariblesCommand( );
		}
		else{
			listS=(List<MySQLVariableObject>) mmu.showVariblesCommandByCategory(category);
		}
			
		 	request.setAttribute("listF",listF);      
			request.setAttribute("listS",listS);      
		if (category==null){
			return new ModelAndPage( request ,"/WEB-INF/page/show/showVaribles.jsp" );
		}
		else{
			return new ModelAndPage( request ,"/WEB-INF/page/show/showVariblesByCategory.jsp" );
		}
		
	}
}
 