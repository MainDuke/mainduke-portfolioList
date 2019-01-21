<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%request.setCharacterEncoding("utf-8");
%>
<% 
String name= request.getParameter("name");
String id = request.getParameter("id");
String email= request.getParameter("email");
String card2= request.getParameter("card");
String ssn1 = request.getParameter("ssn1");
String ssn2 = request.getParameter("ssn2");
String pass = request.getParameter("p1");


StringBuffer sb=new StringBuffer(ssn1);
sb.append("-");
sb.append(ssn2);
sb.replace(0, 6, "######");
sb.replace(8, 13, "#######");

StringBuffer p=new StringBuffer(pass);
p.replace(0,5,"#####");



%>
<body>

이름: <%=name %><br>
id: <%=id %><br>
email: <%=email %><br>
card: <%=card2 %><br>
ssn:<%=sb %><br>
pass: <%=p %><br>


</body>
</html>