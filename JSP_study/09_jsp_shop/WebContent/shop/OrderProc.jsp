<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="shopdb.*"
    import="java.util.*"
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

    <jsp:useBean id="cartMgr" class="shopdb.CartMgr" scope="session"/>
    <jsp:useBean id="orderMgr" class="shopdb.OrderMgr"></jsp:useBean>
    
    <%
    shopdb.ProductMgr proMgr=ProductMgr.getInstance();
    Hashtable hcart= cartMgr.getCartList();
    Enumeration hCartKey=hcart.keys();
    
    if(hcart.size() != 0 ){
    	while(hCartKey.hasMoreElements()){
			    		OrderBean order=(OrderBean)hcart.get(hCartKey.nextElement());
			    		
			    		orderMgr.insertOrder(order);
			    		proMgr.reduceProduct(order);
			    		cartMgr.deleteCart(order);
			    		
    	}//while emd
    	%>
    	<script>
    	alert("주문처리되었습니다.");
    	location.href="OrderList.jsp"
    	</script>
    	
    	<%
    }else{//장바구니가 비어있으면
    
    %>
    <script>
    alert("장바구니가 비어있습니다.");
    location.href="OrderList.jsp"
    </script>
    
    <%
    }//else
    %>
    
    
    