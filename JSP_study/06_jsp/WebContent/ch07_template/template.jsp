<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    String control=request.getParameter("control");
    String contentPage=request.getParameter("contentPage");
    String pageTiltle=request.getParameter("pageTitle");
    String left=control+"Left.jsp";
       
    %>
    
    <html>
    <body bgcolor="orange" topmargin="10%">
	
	<table width="70%" height="90%" align="center" bgColor="margenta" borderColor="blue" border="1" 
	cellpadding="2"	cellspacing="0">
	
	<tr>
	<td colspan="2">	<font size="3"><jsp:include page="top.jsp"/></font> 	</td>
	</tr>
	
	<tr>
	
	<td width="100" valign="top" ><jsp:include page="<%=left %>" flush="false"/></td>
	
	<td><jsp:include page="<%=contentPage %>" flush="false" /></td>
	
	</tr>
	
	<tr>
	<td colspan="2">
	<jsp:include page="bottom.jsp"/>
	</td>
	</tr>
	
	</table>    
    </body>
    </html>