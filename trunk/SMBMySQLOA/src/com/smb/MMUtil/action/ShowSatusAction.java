/**
 * 
 */
package com.smb.MMUtil.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.action.base.ActionBase;
import com.smb.MMUtil.handler.IMySQLManagerJdbcUtilTools;
import com.smb.MMUtil.pojo.MySQLVariableDescription;
import com.smb.framework.web.action.ControllerAction;
import com.smb.framework.web.action.ModelAndPage;


public class ShowSatusAction  extends ActionBase   implements ControllerAction  {
	
	private static Log logger = LogFactory.getLog(ShowSatusAction.class);

	
	@SuppressWarnings("unchecked")
	public ModelAndPage handleModelAndPage(HttpServletRequest request,HttpServletResponse response) throws Exception {
		try{
			logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
			HttpSession session=  request.getSession();
			
			if(session.getAttribute("host")==null ){ return new ModelAndPage("index.jsp",true); }
			
			IMySQLManagerJdbcUtilTools   mmu= getMMU(session);
			
			List <MySQLVariableDescription> listF=DescriptionXMLFile.getMySQLStatusDescription();
			
			List<?> listS=null;
			String category=request.getParameter("category");
			
			String warn="";
			if(category==null){
				request.setAttribute("warn",""); 
				category="";
				listS=mmu.showStatusCommand( );
			}
			else{
				request.setAttribute("warn",""); 
				listS=mmu.showStatusCommandByCategory(category);
				if(category.equals("cache")){
					warn="<b> 提示：如果该页面出现的 “0” 值 比较多的话，说明您的MySQL数据库基本没有很好的优化，如果具有非“0”的值请检查是否被合理使用。</b><br><hr> <I><FONT SIZE=2 COLOR=#006666><B>Tips:</B><BR>Query Cache有如下规则，如果数据表被更改，那么和这个数据表相关的全部Cache全部都会无效，并删除之。<BR>这里“数据表更改”包括: INSERT, UPDATE, DELETE, TRUNCATE, ALTER TABLE, DROP TABLE, or DROP DATABASE等。 </FONT></I><br><hr>  "; 
					request.setAttribute("warn",warn);   
				}
			}
				request.setAttribute("category",category);      
			 	request.setAttribute("listF",listF);      
				request.setAttribute("listS",listS);      
			 
			    return new ModelAndPage( request ,"/WEB-INF/page/show/showStatus.jsp" );
		}
		
		catch(Exception e ) {
			 logger.error(e);
			 throw new Exception (e);
		}
	}
}
 