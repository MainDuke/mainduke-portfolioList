<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%-- ProductDetail.jsp--%>

<%@ page import="java.util.*" %>
<%@ page import="shopdb.*" %>

<%
shopdb.ProductMgr proMgr=ProductMgr.getInstance();


%>

<html>
<head>
<title>Simple Shopping Mall Admin</title>

<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" href="style.css" type="text/css">

<script type="text/javascript" src="script.js"></script> 
</head>

<body bgcolor="#996600" topmargin="20">
<%@ include file="Top.jsp" %>

<%

	int pro_no=Integer.parseInt(request.getParameter("pro_no"));
	String code=request.getParameter("code");
	ProductBean product=proMgr.getProduct(code, pro_no);

%>
	<table width="80%" align="center" bgcolor="#ffff99">
		<tr>
		<td align="center" bgcolor="#ffffcc">
			
			<table width="95%" align="center" bgcolor="#ffff99" border="1">
			<tr bgcolor="#996600">
			<td colspan="3" align="center"><%=product.getName() %></td>	
			</tr>
			
			<tr>
				<td width="20%">
					<img src="../imgs/<%=product.getImage()%>" height="150" width="150">
				</td>
				<td width="30%" valign="top">
				<table border="1" width="100%" height="100%">
				
				<tr>
				<td><b>상품이름 : </b><%=product.getName() %></td>
				</tr>		
				
				<tr>
				<td><b>가격 : </b><%=product.getPrice() %></td>
				</tr>		
				
				<tr>
				<td><b>입고 날짜</b><%=product.getReg_date() %></td>
				</tr>		
				
				<tr>
				<td><b>재고(남은 물량) : </b>
				<%if(product.getStock()>0){ %>
				<%=product.getStock()%>
				<%}else{%>품절<%}%>
				</td>
				</tr>
				</table>
				</td>
			
				<td width="50%" valign="top"><b>상세설명</b><br>
				<%=product.getDetail() %>
				</td>
			</tr>
			
			<tr>
				<td colspan="3" align="center">
					<a href="javascript:productUpdate('<%=product.getPro_no() %>')">
					수정하기</a>
					&nbsp;&nbsp;
					<a href="javascript:productDelete('<%=product.getPro_no() %>')">
					삭제하기</a>
				</td>
			</tr>
			
			</table>
		
		</td>
		</tr>
	
	</table>
	<%@ include file="Bottom.jsp" %>
	
	<form method="post" name="update" action="ProductUpdate.jsp">
		<input type="hidden" name="pro_no">
	</form>
	
	<form method="post" name="del" action="ProductProc.jsp?flag=del">
		<input type="hidden" name="pro_no">
	</form>


</body>

</html>


