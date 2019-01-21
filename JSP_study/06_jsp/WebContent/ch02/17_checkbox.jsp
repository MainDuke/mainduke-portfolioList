<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<%request.setCharacterEncoding("utf-8");
String method=request.getMethod();
out.println("메서드 방식:"+method+"<br>");

if(method.equalsIgnoreCase("POST")){
	out.println("<ui>");
String name= request.getParameter("name");
String addr = request.getParameter("addr");
String fruit[]=request.getParameterValues("과일");

out.println("<li>이름 : "+name);
out.println("<li>주소 : "+addr);

out.println("<li>과일<ul>");
if(fruit != null){
for(int i=0;i<fruit.length;i++){

	out.println("<li>"+fruit[i]);
	
}	//for
}//if
out.println("</ul></ul>");
}else{//get
	out.println(method+"방식으로는 사용할 수 없습니다.");
%>
<a href="17_checkbox.html">이 페이지</a>에서 내용을 채우세요.
<%
}//else ed
%>


<body>

</body>
</html>