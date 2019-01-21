<%@ page language="java" contentType="application/vnd.ms-excel"
pageEncoding="euc-kr"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%

response.setHeader("Content-Disposition","attachment;filename=mm.xls");
response.setHeader("Content-Description", "JSP Generated Data");

%>

<body>
이름 급여 주소
김대진 350 서울
김영지 360 서울
이상철 370 고양시


</body>
</html>