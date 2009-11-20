<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
      <title>Mysql Optimize Analysis</title>
  </head>
  
  <body>
     <br> 
    <a href="deepOptimizeCaseListAction.do?step=3">返回上一页</a> <br> 
   
    <br> <br> 
    	<b>请确认您需要优化的选项： </b>  <br><br><hr>
    	
    	<FORM METHOD="POST" ACTION="deepOptimizeCaseFinishAction.do">
   		 
   		 <% 
   		 List list=(List)request.getAttribute("deepOptimizeTitle");
   		 	
   		 if (list.size()==0){
				   out.print( "您尚未选中任何优化条件，请选择 “返回”<br><br> <INPUT TYPE='submit' name='back' value='返回'>   <br><br>");	
   		 	}
   		 	
   		 else {
   		 	for (int i=0;i<list.size();i++){
   		 		out.print(list.get(i)+"<br><br>");
   		 	}
   		 %>
    
    <INPUT TYPE="hidden" NAME="optimizeIDs" value="<%=request.getAttribute("optimizeIDs")%>">
			<br>
			<INPUT TYPE="submit"  name="yes" value="确定">   &nbsp;&nbsp;&nbsp;
			<INPUT TYPE="submit"  name="cancel" value="取消"> <br>
		
		<%} %>
 	  </FORM>
     
     <jsp:include page="/WEB-INF/page/common/bottom.jsp" flush="true"/>
  </body>
</html>
