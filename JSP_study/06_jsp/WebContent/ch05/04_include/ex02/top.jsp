<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%
    String memid=(String)session.getAttribute("memid");
    String log="";
    
    if(memid == null){
    	log="<a href=Login.jsp>로그인</a>";
    }else{
    	log="<a href=Logout.jsp>로그아웃</a>";
    }
    
    String mem="";
 	if(memid == null){
 		mem="<a href=Reguster.jsp>회원가입</a>";
 	}else{
 		mem="<a href=MemberUpdate.jsp>회원정보 수정</a>";
 	}
    %>
    
   <table width="70%" align="center" border=1>
   <tr bgcolor="#ffcc00">
   <td align="center"><b><%=log %></b></td>
   <td align="center"><b><%=mem %></b></td>
   <td align="center"><b><a href="product.jsp">상품목록</a></b></td>
   <td align="center"><b><a href="CartList.jsp">장바구니</a></b></td>
   <td align="center"><b><a href="OrderList.jsp">구매목록</a></b></td>
   </tr>
   </table>