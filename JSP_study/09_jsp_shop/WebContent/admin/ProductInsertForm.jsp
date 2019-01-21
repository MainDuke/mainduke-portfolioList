<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%--ProductInsertForm.jsp 상품등록 --%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Simple Shopping Mall Admin</title>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" href="style.css" type="text/css">

<script type="text/javascript" src="script.js"></script> 

</head>
<body topmargin="20">
<%@ include file="Top.jsp" %>

<table width="80%" align="center" bgcolor="#ffff99">
	
	<tr>
	<td align="center" bgcolor="#ffff99" width="80%">
	
	<form method="post" action="ProductProc.jsp?flag=insert" enctype="multipart/form-data">
	
	<table width="95%" align="center" bgcolor="#ffff99" border="1">
	
		<tr>
			<td colspan="2" align="center">상품 등록</td>
		</tr>
		
		<tr>
		<td align="center">상품이름</td>
		<td align="left">
			<input type="text" name="name" id="name" size="15">
		</td>
		</tr>	
		
		<tr>
		<td align="center">상품코드</td>
		<td align="left">
			<input type="text" name="code" id="code" size="15">
		</td>
		</tr>

		<tr>
		<td align="center">상품가격</td>
		<td align="left">
			<input type="text" name="price" id="price" size="20">원
		</td>
		</tr>
	
		<tr>
		<td align="center">상품설명</td>
		<td>
			<textarea rows="10" cols="45" name="detail" id="detail"></textarea>
		</td>
		</tr>
	
		<tr>
		<td align="center">상품입고수량</td>
		<td><input type="text" name="stock" id="stock" size="10">개		</td>
		</tr>
	
		<tr>
		<td align="center">상품 이미지</td>
		<td><input type="file" name="image"></td>
		</tr>
	
		<tr>
		<td align="center">제조 회사</td>
		<td align="left"><input type="text" name="comp" id="comp" size="20"></td>
		</tr>
	
	<tr>
	<td><input type="submit" value="상품등록">&nbsp;&nbsp;
	<input type="reset" value="다시쓰기">
	
	</tr>
		
		
	</table>
	
	
	</form>

	</td>
	</tr>
</table>

<%@ include file="Bottom.jsp" %>
</body>
</html>