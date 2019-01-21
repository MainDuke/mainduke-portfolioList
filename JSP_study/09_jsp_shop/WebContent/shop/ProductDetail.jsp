<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="shopdb.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
request.setCharacterEncoding("utf-8");
java.util.Date date=new java.util.Date();
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
%>

<html>
<head>
<title>상품 상세 보기</title>
<link rel="stylesheet" href="style.css" type="text/css">
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="script.js"></script>
</head>

<body bgcolor="#99cc99" topmargin="20">
<%@ include file="Top.jsp" %>

<%
ProductMgr proMgr=ProductMgr.getInstance();

String code=request.getParameter("code"); //상품 코드값 얻기
ProductBean bean= proMgr.getDetails(code);//DAO 메서드 호출

%>

<h2>상세보기</h2>

<!-- 장바구니에 담기 이동 -->
<form method="post" action="CartProc.jsp">

	<table align="center" border="1" width="50%" cellpadding="3" cellspacing="0">
	
		<tr align="center" bgcolor="#d0d0d0" height="120%">
			<td colspan="2"><%=bean.getName()%>
			</td>
		</tr>
	
		<tr>
			<td colspan="2" align="center">
				<a href="details.jsp?code=<%=bean.getCode() %>">
				<img src="<%=request.getContextPath() %>/imgs/<%=bean.getImage()%>" width="250" height="150"></a>
			</td>
		</tr>
			
		<tr>
		<td width="45%">상품 코드</td>
		<td><input type="text" name="product_code" id="product_code" value="<%=bean.getCode()%>" readonly="readonly">
		
		</td>
		</tr>
		
		<tr>
		<td>가격</td>
		<td><input type="text" name="price" id="price" value="<%=bean.getPrice()%>" readonly="readonly">
		</td>
		</tr>
		
		<tr>
		<td>출시날짜</td>
		<td><%=bean.getReg_date()%>
		
		<%--주문날짜 --%>
		<!--  <input type="hidden" name="ord_date" id="ord_date" value="<%=sdf.format(date)%>" readonly="readonly">
		-->
		</td>
		</tr>
	
		<tr>
		<td>제조회사(국내산)</td>
		<td><input type="text" name="comp" id="comp" value="<%=bean.getComp()%>" readonly="readonly">	
		</td>
		</tr>
		
		<tr>
		<td>수량:</td>
		<td>
		<select name="quantity" id="quantity">
			<option value="1" selected="selected">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
		</select>
		</td>
		</tr>
	
	<tr>
	<td colspan="2" align="center">
	<input type="submit" value="장바구니 담기">
	<input type="reset" value="취소">
	</td>
	</tr>
	
	<input type="hidden" name="pro_no" value="<%=bean.getPro_no()%>">
	<input type="hidden" name="userid" value="<%=session.getAttribute("mem_id")%>">
	<input type="hidden" name="state" value="1">
	</table>
컨텍스트 경로: <%=request.getContextPath() %> <br>
실제 경로: <%=config.getServletContext().getRealPath("/") %>
</form>


</body>

</html>















