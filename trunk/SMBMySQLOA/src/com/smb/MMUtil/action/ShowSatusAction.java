/**
 * 
 */
package com.smb.MMUtil.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.smb.MMUtil.handler.IMySQLManagerJdbcUtilTools;
import com.smb.MMUtil.handler.MySQLManagerJdbcUtilTools;
import com.smb.MMUtil.handler.base.UtilBaseTools;
import com.smb.MMUtil.handler.xml.ReadMySQLValueDescriptionXMLFile;
import com.smb.MMUtil.pojo.MySQLVariableDescription;
import com.smb.MMUtil.pojo.MySQLVariableObject;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @author huangyi
 *
 */
public class ShowSatusAction extends HttpServlet {
	
	private static final long serialVersionUID = 2551449111136325075L;
	private static Log logger = LogFactory.getLog(ShowSatusAction.class);
	
	public ShowSatusAction() {super();	}
	
	public void destroy() {	super.destroy(); }

 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		    doPost(request, response);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println( );
		
		request.setCharacterEncoding("UTF-8");  
		response.setCharacterEncoding("UTF-8");  
		
		PrintWriter out = response.getWriter();
	 
		try{
			logger.info("\nClient Side Request RemoteAddr : [ "+request.getRemoteAddr() +" ]" );
		
			 if( request.getSession().getAttribute("host")==null){response.sendRedirect("index.jsp");}
		    
		    String host= request.getSession().getAttribute("host").toString() ;
		    String username= request.getSession().getAttribute("username").toString();
		    String password= request.getSession().getAttribute("password").toString();
		    
		    UtilBaseTools orm= new UtilBaseTools(host,null,username,password);
			IMySQLManagerJdbcUtilTools   mmu= new MySQLManagerJdbcUtilTools(orm);
			
			ReadMySQLValueDescriptionXMLFile  DescriptionXMLFile= new ReadMySQLValueDescriptionXMLFile();
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
			 
			    RequestDispatcher   requestDispatcher=request.getRequestDispatcher("showStatus.jsp");   
			    requestDispatcher.forward(request,response);
			
			
			
		}
		
		catch(Exception e ) {
			StringBuffer HeaderBuffer = new StringBuffer();
			HeaderBuffer.append("\n<SMBML><Header><Error><RequestItem>");
			HeaderBuffer.append(e );
			HeaderBuffer.append( "</RequestItem></Error></Header></SMBML>");
		}
		 
		out.flush();
		out.close();
	}
 
	public void init() throws ServletException {	}

}
