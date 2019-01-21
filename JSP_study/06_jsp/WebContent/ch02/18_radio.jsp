<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("utf-8");
String method=request.getMethod();
out.println("메서드 방식:"+method+"<br>");

if(method.equalsIgnoreCase("POST")){
	out.println("<ui>");
String name= request.getParameter("name");
String addr = request.getParameter("addr");

out.println("<li>이름 : "+name);
out.println("<li>주소 : "+addr);

Enumeration en = request.getParameterNames(); //순서 없이 처리된다.
//html 의 form 안에 여러개의 이름을 받는다.

while(en.hasMoreElements()){
	out.println("<li>");
	String str=(String)en.nextElement();
	out.println(str);

	out.println(":");
	String v=(String)request.getParameter(str);
	
	out.println(v);
	out.println();
}



out.println("</ul></ul>");
}else{//get
	out.println(method+"방식으로는 사용할 수 없습니다.");
%>
<a href="17_checkbox.html">이 페이지</a>에서 내용을 채우세요.
<%
}//else ed
%>
</body>
</html>