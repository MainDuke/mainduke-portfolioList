<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="shopdb.*"
    import="java.util.*"
    %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="cartMgr" class="shopdb.CartMgr" scope="session"/>


<%

OrderBean ordBean=null;
ProductBean proBean=null;
shopdb.ProductMgr proMgr=null;
Hashtable hCart=null;

try{
	proMgr=shopdb.ProductMgr.getInstance();
	if(session.getAttribute("mem_id")== null){
		response.sendRedirect("Login.jsp");
	}else{
		//로그인 상태면 서비스시작.
		%>
		
		<html>
			<head>
			<title></title>
			<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
			<link rel="stylesheet" href="style.css" type="text/css">
			<script type="text/javascript" src="script.js"></script> 
			
			</head>
			
			<body bgcolor="#996600" topmargin="100">
			
			<%@ include file="Top.jsp" %>
			
			<table width="80%" align="center"> 
			<tr>
			<td align="center" bgcolor="#ffffcc">
			
			<table width="95%" align="center" bgcolor="#ffff99" border="1">
			
			<tr bgcolor="#996600">
			<td align="center"><font color="#ffffff">제품</font></td>
			<td align="center"><font color="#ffffff">수량</font></td>
			<td align="center"><font color="#ffffff">가격</font></td>
			<td align="center"><font color="#ffffff">수정/삭제</font></td>
			<td align="center"><font color="#ffffff">조회</font></td>
			
			</tr>
			
			<%
			int totalPrice=0; //총 금액
			
			hCart= cartMgr.getCartList(); //장바구니 내용 가져오기
			
			if(hCart.size()==0){//장바구니 물건이 없으면.
				%>
				
				<tr>
				<td colspan="5" align="center">
				선택하신 물품이 없습니다.
				</td>
				</tr>
				
				<%
				
			}else{//장바구니에 물건이 있으면
				
				out.println("<tr><td align=center colspan=5>선택하신 상품</td></tr>");
				
				Enumeration hCartKey=hCart.keys();
				 
				while(hCartKey.hasMoreElements()){
					ordBean=(OrderBean)hCart.get(hCartKey.nextElement());
					proBean= proMgr.getProduct(ordBean.getPro_no());
					//######3 ProductMgr.getProduct();
					int price=proBean.getPrice();//가격
					int quantity= Integer.parseInt(ordBean.getQuantity());//수정
					int subTotal= price*quantity;//계산
					
					totalPrice += price*quantity;
					%>
					
					<form method="post" action="CartProc.jsp" name="cartList">
					<input type="hidden" name="pro_no" value="<%=proBean.getPro_no()%>">
					<input type="hidden" name="flag">				
					
					
					<%
					java.util.Date date= new java.util.Date();
					java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd H:m:s");
					%>
					<!-- <input type="hidden" name="ord_date" value="<%=sdf.format(date)%>">	 -->
					<input type="hidden" name="state" value="2">
					
					<tr>
					<td align="center"><%=proBean.getName() %></td>
					<td align="center">
					<input type="text" name="quantity" value="<%=ordBean.getQuantity()%>" size="5">개
					</td>
					<td align="center"><%=subTotal+""%></td>
						<td align="center">
						<input type="button" value="cart수정" size="3" onclick="cartUpdate(this.form)">
					/<input type="button" value="cart삭제" size="3" onclick="cartDelete(this.form)">
					</td>
					
					
					<td align="center">
					<a href="javascript:productDetail('<%=proBean.getCode() %>')">
					상세보기
					</a>
					</td>
					</form>
					<%
				}//while
				%>
				<td colspan="4" align="right">총 금액 :<%=totalPrice %>원</td>
				<td align="center">
				<a href="OrderProc.jsp">주문하기</a>
				</td>	
			<%		
			}//else end
			
			%>
			</table>
			
			
			</td>
			</tr>
			</table>
		
			<%@ include file="Bottom.jsp" %>
			
			<form name="detail" action="ProductDetail.jsp" method="post">
			<input type="hidden" name="code">
			</form>
			
			</body>
			
		</html>
		
		<%
	}//else

}catch(Exception ex){
	
}finally{
	try{
		
	}catch(Exception ex1){
		
	}//end
}//finally
%>