<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ include file="../view/color.jsp" %>

     <%
     int num=Integer.parseInt(request.getParameter("num"));
     String pageNum=request.getParameter("pageNum");
     %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
     
     <html>
     <head>
     <title>deleteForm.jsp</title>
     <link rel="stylesheet" href="style.css" type="text/css">
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>

	<script type="text/javascript">
	function deleteSave(){
		if($("#pwd").val()==""){
			alert("암호를 입력하시오");
			$("#pwd").val('').focus(); //입력한 값을 지우고, 포커스 설정
			return false;
		}//if
	}//end
	</script>

     </head>
     <body bgcolor="<%=bodyback_c%>">
     <center><b><font size="+1">글 삭제</font></b></center>
     
   <form name="delForm" method="post" action="deletePro.jsp?pageNum=<%=pageNum%>" onsubmit="return deleteSave()">
	    
	    <table border="1" align="center" cellpadding="5" cellspacing="0" width="360">

		<tr height="30">
		<td align="center" bgcolor="<%=value_c%>">
		<b>비밀번호를 입력하시오.</b>
		</td>
		</tr>
	   
	    <tr height="30">
		<td align="center">비밀번호: 
			<input type="password" name="passwd" id="passwd" size="8">
			<input type="hidden" name="num" value="<%=num%>">
		</td>	
		</tr>

	   <tr height="30">
		<td align="center" bgcolor="<%=value_c %>">비밀번호: 
			<input type="submit" value="글 삭제">
			<input type="button" value="글목록" onclick="document.location='list.jsp?pageNum=<%=pageNum%>'">
		</td>	
		</tr>

	     </table> 
   </form>
     
     </body>
     </html>
     