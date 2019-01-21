<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="shopdb.*" %>

<!-- CartPro.jsp -->

<jsp:useBean id="cartMgr" class="shopdb.CartMgr" scope="session"/>
<%-- 
<jsp:useBean id="cartMgr" class="shopdb.CartMgr" scope="page"/> 디폴트 값
<jsp:useBean id="cartMgr" class="shopdb.CartMgr" scope="request"/> 요청 할때마다.
<jsp:useBean id="cartMgr" class="shopdb.CartMgr" scope="application"/> 프로젝트 단위
 --%>
<jsp:useBean id="OrderBean" class="shopdb.OrderBean">
	<jsp:setProperty name="OrderBean" property="*"/>
</jsp:useBean>

<%

String flag=request.getParameter("flag"); //update, del
String userId=(String)session.getAttribute("mem_id");

System.out.println(flag);

if(userId==null){//로그인 안된 상태
	response.sendRedirect("Login.jsp");
}else{//로그인 됬을때,

	if(flag==null){
		OrderBean.setUserid(userId);

		cartMgr.addCart(OrderBean); //장바구니에 넣는 메서드 호출
		%>
		<script>
		alert("장바구니에 담았습니다.")
		location.href="CartList.jsp"; //장바구니 목록 보러가자.
		</script>
	<%	
	}else if(flag.equals("update")){
		OrderBean.setUserid(userId);

		cartMgr.updateCart(OrderBean);
		%>
		 <script>
		alert("수정 하였습니다.")
		location.href="CartList.jsp"; //장바구니 목록 보러가자.
		</script> 
	<%	
	}else if(flag.equals("del")){
		cartMgr.deleteCart(OrderBean);
		%>
	 
		<script>
		alert("삭제 하였습니다.");
		location.href="CartList.jsp"; //장바구니 목록 보러가자.
		</script> 
<%
	}//end 
	
}//else end

%>
