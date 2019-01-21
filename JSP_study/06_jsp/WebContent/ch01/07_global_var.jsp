<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%!
String str="전역변수";
public int add(int a, int b){
	return (a+b);
}
%>
<ol>
<li>변수</li>
<li>str :<%=add(2,3) %></li>

<li>계산식</li>
<li>10+20 :<%=10+20 %></li>

<li>디폴트 객체 사용</li>
<li>사용자 컴퓨터 :<%=request.getRemoteHost() %></li>
</ol>

</body>
</html>