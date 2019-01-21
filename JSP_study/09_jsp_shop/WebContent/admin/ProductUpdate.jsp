<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    import="shopdb.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%=request.getParameter("pro_no") %>
<%
request.setCharacterEncoding("utf-8");

ProductMgr proMgr=ProductMgr.getInstance();
%>
<html>
<head>
<script type="text/javascript" src="script.js"></script> 
		<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
		<link rel="stylesheet" href="style.css" type="text/css"/>

</head>
<body>
<%@ include file="Top.jsp" %>
<%
String im=request.getParameter("pro_no");
int pro_no=Integer.parseInt(im);
ProductBean product=proMgr.getProduct(request.getParameter("code"), pro_no);

%>

<table width="80%" align="center" bgcolor="#ffff99">
<tr>
<td align="center" bgcolor="#ffffcc">

<form method="post" action="ProductProc.jsp?flag=update" enctype="multipart/form-data">

<table width="95%" align="center" bgcolor="#ffff99" border="1">

	<tr bgcolor="#996600">
	<td colspan="2" align="center"><h2>상품 수정</h2></td>
	</tr>

	<tr>
	<td width="31%" align="center">상품 이름</td>
	<td width="69%" align="left"><input type="text" name="name" id="name" value="<%=product.getName()%>">
	</td>
	</tr>
	
	<tr>
	<td width="31%" align="center">상품 코드</td>
	<td width="69%" align="left"><input type="text" name="code" id="code" value="<%=product.getCode()%>" readonly="readonly">
	</td>
	</tr>
	
	
	
	<tr>
	<td headers="21" align="center">상품 가격</td>
	<td>
	<input type="text" name="price" id="price" size="20" value="<%=product.getPrice()%>">
	</td>
	</tr>
	
	<tr>
	<td align="center">상품내용(상세설명)</td>
	<td><textarea rows="10" cols="45" name="detail" id="detail"><%=product.getDetail() %></textarea>
	</tr>
	
	<tr>
	<td align="center">상품입고 수량</td>
	<td align="left"><input type="text" name="stock" id="stock" size="10" value="<%=product.getStock()%>">개</td>
	</tr>

	<tr>
	<td align="center">상품 이미지</td>
	<td align="left">
	<img src="../imgs/<%=product.getImage()%>">
	<input type="file" name="image"></td>
	</tr>
	
	<tr>
	<td align="center">제조회사</td>
	
	<td><input type="text" name="comp" id="code" size="20" value="<%=product.getComp()%>">	</td>
	</tr>	

	<tr>
	<td colspan="2" align="center">
	<input type="submit" value="제품 수정">&nbsp;&nbsp;
	<input type="reset" value="입력한 내용 취소">
	<input type="hidden" name="pro_no" value="<%=product.getPro_no()%>">
	<!-- <input type="hidden" name="code" value="<%=product.getCode()%>">
	 -->
	</tr>


</table>


</form>

</td>
</tr>

</table>


<%@ include file="Bottom.jsp" %>

</body>
</html>
