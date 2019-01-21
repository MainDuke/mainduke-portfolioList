<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="guest.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
request.setCharacterEncoding("utf-8");
String id=(String)session.getAttribute("id");

id="test";

int num=Integer.parseInt(request.getParameter("num"));

%>

<jsp:useBean id="msg" class="guest.GuestMsg"></jsp:useBean>

<%

String pwd=request.getParameter("pwd");

GuestBean bean=msg.getBoard(num, id);//메서드 호출      

if(!(pwd==null || pwd.equals("") )){

				if(pwd.equals(bean.getPwd())){
					msg.deleteBoard(num); 
					response.sendRedirect("Guest.jsp");
				}else{
	%>
					
					<script>
						alert("암호가 틀립니다")
						history.go(-1)
						</script> 
	<%	
					}//else end
		}//out if end
		%>