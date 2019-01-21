<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="jsp_header.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="css/shopping3-1.css">

</head>


<body>

<div align="center" class="body">
	<h2>��ǰ ��� ȭ��</h2>
	
<table border="1">
	<tr>
		<th align="center" width="80">��ǰ ID</th>
		<th align="center" width="80">��ǰ��</th>
		<th align="center" width="80">��ǰ����</th>
		</tr>

	<c:forEach var="item" items="${itemList }">
		<tr>
			<td align="center">${item.itemId }</td>
			
			<td align="left"><a href="detail.html?itemId=${item.itemId }">
			${item.itemName }
			</a></td>
			<td align="right">${item.price}</td>
		</tr>
	</c:forEach>

</table>
</div>

</body>
</html>