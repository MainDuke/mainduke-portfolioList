<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.*" %>
    <%@ page import="shopdb.*" %>
    
  <%
  shopdb.ProductMgr proMgr= shopdb.ProductMgr.getInstance();
  %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Simple Shopping Mall Admin</title>
		
		<script type="text/javascript" src="script.js"></script> 
		<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
		<link rel="stylesheet" href="style.css" type="text/css"/>
		
	</head>
	
	<body topmargin="20">
	<%@ include file="Top.jsp" %>
		<table width="80%" align="center" bgcolor="#ffff99">
			<tr>
				<td align="center" bgcolor="#ffffcc">
					<table width="95%" align="center" bgcolor="#ffff99" border="1">
					<tr bgcolor="#996600">
					 <td align="center">이름</td>
					 <td align="center">가격</td>
					 <td align="center">입고날짜</td>
					 <td align="center">남은 수량</td>
					 <td align="center">&nbsp;</td>
					</tr>
					<%
					List <ProductBean> list=proMgr.getGoodList();
					if(list.size()==0){
						//남은 수량이 없습니다.
						%>
						<tr>
						<td align="center" colspan="5">상품이 없습니다.</td>
						</tr>
						<%
					}else{
						for(int i=0;i<list.size();i++){
							ProductBean productBean=(ProductBean)list.get(i);
						%>
						<tr>
						<td align="center"><%=productBean.getName()%></td>
						<td align="center"><%=productBean.getPrice() %></td>
						<td align="center"><%=productBean.getReg_date() %></td>
						<td align="center"><%if(productBean.getStock()>0){%>
											<%=productBean.getStock()%>						
											<%
											}else{
											out.println("품절");	
											}	%></td>
						<td align="center"><a href="javascript:productDetail('<%=productBean.getCode()%>','<%=productBean.getPro_no()%>')">
						
						상세보기
						</a>
						</td>
						</tr>
						<%
						}//for
					}//else end
					%>
					
					<tr>
					<td colspan="5" align="center">
					<a href="ProductInsertForm.jsp">상품 등록</a>
					</td>
					</tr>
					
					</table>
				</td>
			</tr>
		</table>
	<%@ include file="Bottom.jsp" %>
	<form name="detail" method="post" action="ProductDetail.jsp">
		<input type="hidden" name="code">
		<input type="hidden" name="pro_no">
		
	</form>
	
	</body>
</html>