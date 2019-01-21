<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
			<head>
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>Insert title here</title>
			</head>
			<body>
			<%
			int total=out.getBufferSize();//전체 버퍼8kb
			int rate=out.getRemaining();//남아있는 버퍼
			%>
			전체 버퍼 : <%=total %><br>
			남아있는 버퍼: <%=rate %><br>
			사용중인 버퍼: <%=total -rate %><br>
			
			<%--
			out 객체 : JspWriter 의 객체 이다.
			
		메서드들 : 
		isAutoFlush() : 출력 버퍼가 가득 찼을때 자동으로 밀어낼 것인지 여부를 지정한다. T/F
							true 값이 디폴트로 설정 되어있다.
		
		getBufferSize() : 출력버퍼 전체 사이즈
		getRamaining(): 출력 버퍼에 남아 있는 size를 구한다.
		
		clearBuffer(): 출력 버퍼를 비운다
		println() : String을 출력한다.
		flush() : 출력 버퍼 내용을 밀어낸다.
		close() : 출력 버퍼 내용을 밀어내고, 출력 버퍼를 닫는다.
		
		서블릿 : 아래 메서드 중, 하나를 사용하면 된다.
		out.close()
		out.flush()
			 --%>
			
			</body>
</html>