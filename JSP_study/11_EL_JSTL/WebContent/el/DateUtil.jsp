<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/tlds/DateUtil.tld" prefix="ff" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DateUtil.jsp</title>
</head>
<body>
<%
java.util.Date date=new java.util.Date(); 
request.setAttribute("date",date);
%>

오늘날짜: ${ff:dateFormat(date)}

</body>
</html>