<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
<h2>02_includeTagTop.jsp</h2>


<%request.setCharacterEncoding("utf-8"); %>
<%


String id=request.getParameter("id");
String pwd=request.getParameter("pwd");
String name=request.getParameter("name");
String addr=request.getParameter("addr");
String tel=request.getParameter("tel");

%>

ID:<%=id %><br>
PWD:<%=pwd %><br>
Name:<%=name %><br>
Addr:<%=addr %><br>
Addr:<%=tel %><br>



</body>
</html>