<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.*"
    %>
    
     <%@ include file="../view/color.jsp" %>
     <html>
     <%
     request.setCharacterEncoding("utf-8");
     %>
     
     <%
     String id=(String)session.getAttribute("memId");
     String passwd=request.getParameter("passwd");
     
     LoginDao dao= LoginDao.getInstance();
     int check=dao.deleteMember(id, passwd);
     
         
     if(check==1){ //삭제 완료
    	 session.invalidate(); //세션 무효화
    	 %>
    	 <body bgcolor="<%=bodyback_c%>">
    	 <form method="post" action="Main.jsp" name="userinput">
		<table width=270 border="0" cellspacing="0" cellpadding="5" align=center>
				<tr bgcolor="<%=title_c%>">
				<td height="39" align="center">
				<font size="+2"><b>회원삭제가 완료되었습니다.</b></font>
		
				</td>
				</tr>
				
				<tr bgcolor="<%=value_c%>">
				<td align="center">
				<p>안녕히가세요.</p>
				<meta http-equiv="Refreash" content="3;url=Main.jsp">
				</td>
				</tr>
				
				<tr bgcolor="<%=value_c%>">
				<td align="center">
				<input type="submit" value="확인">
				</td>
				</tr>
				
				
				
		</table>    	 
    	 </form>
    	 </body>
    	 <%
     }else if(check==0){//비번 틀림
    	 %>
    	 <script>
    	 alert("비밀번호가 틀렸습니다.");
    	 history.go(-1);
    	 </script>
    	 <%
     }else if(check==-1){
    	 %>
    	 <script>
    	 alert("존재하지 않음.");
    	 history.go(-1);
    	 </script>
    	 
    	 
    	 <%
     }//else end
    	
     %>
     </html>