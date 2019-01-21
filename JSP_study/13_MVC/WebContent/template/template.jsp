<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>템플릿 페이지를 사용한 웹어플리케이션</title>
	</head>
	
	<body>
	
	<table width="850" border="1" cellpadding="2" cellspacing="0">
	
	<tr height="30" bgcolor="ivory">
		<td colspan="2" align="right">
			<jsp:include page="/module/top.jsp" flush="false"/>
		</td>
	</tr>
	
	<tr>
		<td width="150" valign="top">
			<jsp:include page="/module/left.jsp" flush="false"/>
		</td>
		<td width="700" valign="top">
			<jsp:include page="${CONTENT }" flush="false"/>
		</td>
	</tr>
	
	<tr>
		<td width="150" valign="top" align="center">
			<img src="/13_MVC/module/logo.png" border="0">
		</td>
		<td width="700" valign="top">
			<jsp:include page="/module/bottom.jsp" flush="false"/>
		</td>
	</tr>
	
	</table>
	</body>
</html>

