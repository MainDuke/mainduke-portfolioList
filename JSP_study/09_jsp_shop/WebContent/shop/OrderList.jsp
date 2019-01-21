<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    import="shopdb.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
shopdb.ProductMgr proMgr=ProductMgr.getInstance();

%>
<%!
String mem_id="";
%>
<jsp:useBean id="orderMgr" class="shopdb.OrderMgr"/>
<%@ include file="Top.jsp" %>
<% 
if(session.getAttribute("mem_id")==null){
	response.sendRedirect("Login.jsp");
}else{
	mem_id=(String)session.getAttribute("mem_id");
}//else
%>

<html>
<head>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" href="style.css" type="text/css">
<script type="text/javascript" src="script.js"></script> 

</head>

<body bgcolor="#996600" topmargin="20">
	<table width="80%" align="center" bgcolor="#ffff99">
		<tr>
		<td align="center" colspan="5">
		<br>
		<h3><%=mem_id %>님의 구매목록</h3>
		</tr>
	
	<tr>
	<td align="center" bgcolor="#ffffcc">
	
	<table width="95%" align="center" bgcolor="#ffff99" border="1">
		<tr bgcolor="#996600">
			<td align="center">주문 번호</td>
			<td align="center">제품</td>
			<td align="center">주문 수량</td>
			<td align="center">주문 날짜</td>
			<td align="center">주문 상태</td>
		</tr>
		
		<%
		Vector vec=orderMgr.getOrder(mem_id);
		if(vec.size()==0){//구매 목록이 없으면
			%>
			<tr>
			<td align="center" colspan="5">주문하신 물품이 없습니다.
			</td>
			</tr>
			<%
		}else{//구매 목록이 있스면
			for(int i=0;i<vec.size();i++){	
				
				OrderBean order=(OrderBean)vec.get(i);
				ProductBean product = proMgr.getProduct(order.getPro_no());
				%>
				
				<tr>
				<!-- 주문 번호 -->
				<td align="cetner"><%=order.getOrdno() %></td>
				
				<!-- 상품명 클릭하면 , 상세보기 -->
				<td align="center">
				<a href="javascript:productDetail('<%=product.getCode() %>')">
				<%=product.getName() %>
				</a>
				</td>
				
				<!-- 수량 -->
				<td align="center"><%=order.getQuantity() %></td>
				
				<!-- 주문 날짜 -->
				<td align="center"><%=order.getOrd_date() %></td>
				
				<!-- 상태 -->
				<td align="center">
				<%
				switch(Integer.parseInt(order.getState())){
				case 1: out.println("접수 중"); break;
				case 2: out.println("접수"); break;
				case 3: out.println("입금 확인"); break;
				case 4: out.println("배송 준비"); break;
				case 5: out.println("배송중"); break;
				
				default : out.println("배송 완료"); break;
				
				}//switch end
				%>
				</td>
				
				</tr>
				
				<%
			}//for end
		 }//else end
		%>
		</table>
	
	</td>
	</tr>
	
	</table>
<%@ include file="Bottom.jsp" %>
<form name="detail" method="post" action="ProductDetail.jsp">
<input type="hidden" name="code"></form>

</body>

</html>
