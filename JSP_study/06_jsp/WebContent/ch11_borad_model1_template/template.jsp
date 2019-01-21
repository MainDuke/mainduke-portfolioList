<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    template.jsp<br>
    
    <%
    String pageFile=request.getParameter("page");
    String pageNum=request.getParameter("num");
    
    if(pageFile==null){
    	pageFile="newItem.jsp";
    }
    if(pageNum==null){
    	pageNum=null;
    }
    
    %>
    <html>
    <body bgcolor="orange">
    <table width="90%" height="99%" border="1" borderColor="blue" align="center" bgColor="pink">
	
	<tr>
	<td height="43" colspan="3" align="left">
	<jsp:include page="top.jsp"/>
	</td></tr>
	
	
	<tr>
	<td width="15%" valign="top" align="right"><%--왼쪽 메뉴 --%>
	<br>
	<jsp:include page="left.jsp"/>
	</td>
	
	<td  colspan="2" align="center">
	<jsp:include page='<%=pageFile %>'/>
	</td>
	</tr>
	
	

<tr>
<td width="100%" height="40" colspan="3">
<jsp:include page="bottom.jsp"/>
</td></tr>
	    
    </table>
    
    </body>
    
    </html>