<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    import="shopdb.*"
    %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
request.setCharacterEncoding("utf-8");
%>

<%!
List shopList;
%>
<html>

<head>
<link rel="stylesheet" href="style.css" type="text/css">
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="script.js"></script>

</head>

<body bgcolor="#99cc99" topmargin="20">
<%@ include file="Top.jsp" %> 

<%
shopdb.ProductMgr shop=shopdb.ProductMgr.getInstance();
shopList=shop.getGoodList();
%>

<%if(shopList.isEmpty()){%>
등록된 상품이 없습니다.
<%
}else{ //등록된 상품이 있으면.
%>
	<table align="center" border="1" width=80% cellpadding="3" cellspacing="0">
	
	<tr>
	<% for(int i=0;i<shopList.size();i++){
			if(i%3==0){
				out.println("</tr><tr>");
			}//if
		ProductBean bean=(ProductBean)shopList.get(i);	
		
		%>
	<td>
	<table border="0" align="center">
		<tr align="center" bgcolor="#D0D0D0" height="120%">	
		<td colspan="2"><%=bean.getName() %></td>
		</tr>
		<%-- <%=request.getContextPath() : 현재 경로 열기%> --%>
		<tr>
		<td colspan="2" align="center"> 
		<a href="javascript:productDetail('<%=bean.getCode() %>')">
		<img src="<%=request.getContextPath() %>/imgs/<%=bean.getImage() %>" width="250" height="150">
		</a>
		</td>
		</tr>
		
		<tr>
		<td width="50%">상품코드 :</td>
		<td><%=bean.getCode() %></td>
		</tr>
		
		<tr>
		<td>가격 :</td>
		<td><%=bean.getPrice() %></td>
		</tr>
		<tr>
		<td>출시날짜 :</td>
		<td><%=bean.getReg_date()%></td>
		</tr>
		
		<td>제조회사() :</td>
		<td><%=bean.getComp()%></td>
		</tr>
		
		<tr>
		<td>재고 현황 : </td>
		<td>
		<% if(bean.getStock()>0){%>
			<%=bean.getStock()%>
		<%
		}else{%>품절 <%}
		%>
		</td>
		</tr>
			
		
	</table>
	
	<%}//for %>
	</tr>
	
	</table>
	
<%
}//else %>

<%@ include file="Bottom.jsp" %>

<form name="detail" method="post" action="ProductDetail.jsp">
	<input type="hidden" name="code">
</form>

</body>

</html>








