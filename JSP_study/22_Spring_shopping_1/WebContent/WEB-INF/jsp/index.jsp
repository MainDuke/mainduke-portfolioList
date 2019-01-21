<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="css/shopping3-1.css">

</head>


<body>

<div align="center" class="body">
	<h2>상품 목록 화면</h2>
	
<table border="1">
	<tr>
		<th align="center" width="80">상품 ID</th>
		<th align="center" width="80">상품명</th>
		<th align="center" width="80">상품가격</th>
		</tr>

	<c:forEach var="item" items="${itemList }">
		<tr>
			<th align="center">${item.itemId }</th>
			<th align="left">${item.itemName }</th>
			<th align="right">${item.price}</th>
		</tr>
	</c:forEach>

</table>
</div>

</body>
</html>