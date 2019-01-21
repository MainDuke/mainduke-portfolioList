<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<%-- contentType="text/html; charset=EUC-KR" : 클라이언트로 응답할 한글처리
pageEncoding="EUC-KR" : 현재 jsp 페이지 한글처리. 저장 안됨. --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
	</head>
	
	<body>
	<h2>글내용보기</h2>
	현재 컨텍스트 구하기 : <%=request.getServletContext().getContextPath() %><br>
	
	<form method="get" action="content.do">
	
	<table width="500" border="1" bgcolor="ivory">
	<tr height="40px">
		<td width="150">글번호</td>
		<td width="350">${BoardDto.num }</td>
	</tr>

	<tr height="40px">
		<td width="150">글쓴이</td>
		<td width="350">${BoardDto.writer }</td>
	</tr>
	
	<tr height="40px">
		<td width="150">제목</td>
		<td width="350">${BoardDto.subject }</td>
	</tr>
	
	<tr height="40px">
		<td width="150">이메일</td>
		<td width="350">${BoardDto.email }</td>
	</tr>
	
	<tr height="40px">
		<td width="150">글내용</td>
		<td width="350"><br><br>${BoardDto.content }<br><br></td>
	</tr>
	
	<tr height="40px">
		<td width="150">날짜</td>
		<td width="350"><fmt:formatDate value="${BoardDto.wdate}"/></td>
	</tr>	

	<tr height="40px">
		<td width="150">IP</td>
		<td width="350">${BoardDto.ip }</td>
	</tr>	
		
	<tr>
		<td colspan="2" align="center">
		<input type="button" value="수정" onclick="location='update.do?num=${BoardDto.num}'">
		<input type="button" value="삭제" onclick="location='delete.do?num=${BoardDto.num}'">
		<input type="button" value="목록" onclick="location='list.do'">		
		</td>
	</tr>
	
	</table>
	
	</form>
	</body>
</html>