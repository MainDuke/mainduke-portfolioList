<%@ page import="java.util.*"%>
<%@ page 
contentType="application/xml"
pageEncoding="utf-8"
%>

<%
int op1=Integer.parseInt(request.getParameter("op1"));
int op2=Integer.parseInt(request.getParameter("op2"));
int result=op1+op2;

%>

<data>
	<op1 value="<%=op1%>"/>
	<op2 value="<%=op2%>"/>
	<result value="<%=result %>"/>
</data>