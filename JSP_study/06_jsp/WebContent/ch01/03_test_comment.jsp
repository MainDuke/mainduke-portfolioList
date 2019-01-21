<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<html>
		<head>
					<title>Insert title here</title>
		</head>
		<body>
		<h2>HTML 주석</h2>
		<h2>HTML 주석은 소스보기 에서 보여진다.</h2>
		<!-- 
		<h2>HTML 주석</h2>
		<h2>HTML 주석</h2>
		<h2>HTML 주석</h2>
		out.priunmt~~!#@
		 -->
		 
		 <%
		 /*자바주석 */
	 out.println("오늘 부터 jsp 수업입니다.");
	 out.println("오늘 부터 jsp 수업입니다.");
	 //out.println("오늘 부터 jsp 수업입니다.");
	  %><br>
	  <br>이름: <%=name %><br><br>
	  <br>ID:<%=id %><br>
	  jsp 주석은 소스보기에서 안보인다.
	<%--
	jsp 주석은 소스보기에서 안보인다.
	jsp 주석은 소스보기에서 안보인다.
	jsp 주석은 소스보기에서 안보인다.
	jsp 주석은 소스보기에서 안보인다.
	jsp 주석은 소스보기에서 안보인다.
	otu~~!@~!@
	
	 --%>	 <br>
		 <%!
		 String name="박문수";
		 %>
		</body>
</html>

 <%!
		 String id="hcm";
		 %>