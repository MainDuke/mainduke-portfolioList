<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>10_if.jsp</title>
</head>
<%!
//전역변수
String msg;
%>
<% 
request.setCharacterEncoding("utf-8"); 
%>
<%
	//클라이언트가 보내준 정보 받기.
	String name=request.getParameter("name");
	String color=request.getParameter("color");

	if(color.equals("blue")){
		msg="파랑색";
	}else if(color.equals("green")){
		msg="녹색";
	}else if(color.equals("red")){
		msg="빨강";
	}else if(color.equals("cyan")){
		msg="하늘색";
	}else if(color.equals("yellow")){
		msg="노랑색";
	}else if(color.equals("pink")){
		msg="핑크색";
	}else{
		color="white";
				msg="기타";
	}
	
	
	
%>
<body bgcolor="<%= color%>">


<%=name %> 님이 좋아하는 색상은 <%=color+"("+msg+")" %> 입니다.

</body>
</html>