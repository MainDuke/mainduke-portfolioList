<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2>03_response</h2>

응답할때 문자 인코딩 설정 내용 알아보기<br>
<%=response.getCharacterEncoding()  %><br>

<% 
//response.sendRedirect("http://www.daum.net"); //특정 URL 가능.
//response.sendRedirect("02_request.jsp"); //특정 jsp 가능

//response.setHeader("Refresh","2,URL=http://www.naver.com"); //html 의 Meta 기능과 유사하다.

/*
response.setHeader(name, value); //응답 헤더 설정.

response.setRedirect("url") //지정 URL 로 페이지 이동

===================================
response.setRedirect("외부url");

response.setRedirect("로컬url");
===================================
<참고> forward 액션은 로컬만 가능하다.
<jsp:forward page="로컬url">
</jsp>


*/


%>