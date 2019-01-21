<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
			<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>Insert title here</title>
			</head>
			<body>
			<h3>jspInit(), jspDestroy() 메서드는 프로그래머가 선언부에 선언해야한다.</h3>
			
			<%!
			String str="Hello!!---";
			
			public void jspInit(){
				str+="jspInit()메서드     ";
			}
			%>
			<%!
			public void jspDestroy(){
				System.out.println("jspDestroy() call");
			}%>
			
			<%--일반 코딩부분은 _jspService()에 코딩 된다. --%>
			
			<%str+="_jspService() 메서드      ";
			//자바구문
			%>
			<%=str %><%--표현식 --%>
			
			</body>
</html>

<%--jspPage 인터페이스 메서드
jspInit() jsp가 호출될때 한번 호출
jspDestroy() jsp 클래스가 메모르에서 제거될때 호출된다.--

HttpjspPage 인터페이스 메서드
_jspService().... 클라이언트 요청을 처리하는 메서드로써, JSP 컨테이터에 의해서 자동으로 실행된다.

--%>
