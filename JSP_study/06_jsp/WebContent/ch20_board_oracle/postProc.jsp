<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="boardoracle.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

  <%
    request.setCharacterEncoding("UTF-8");
    
    %>

<jsp:useBean id="bean" class="boardoracle.BoardBean">
 <jsp:setProperty name="bean" property="*"/>
</jsp:useBean>

<jsp:useBean id="mgr" class="boardoracle.BoardMgr"/>

<%  
mgr.insertBoard(bean); 
response.sendRedirect("List.jsp");
    
%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>