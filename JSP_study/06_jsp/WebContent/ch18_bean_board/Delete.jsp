<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--Delete.jsp --%>
    <%
    request.setCharacterEncoding("utf-8");
    String num = request.getParameter("num");
     %>
     
    <jsp:useBean id="dao" class="board.BoardDAO"></jsp:useBean>
    <%
    board.BoardDto dto = dao.getContent(num);
	%>     
    
    <html>
   <head>
   
   <script type="text/javascript">
   function check(){
	   if(document.delForm.pwd.value==''){
		   alert("암호를 입력하시오");
		   document.delForm.pwd.focus();
		   return;
	   }//if
	   
	   if(document.delForm.pwd.value != <%=dto.getPwd()%>){
			alert("입력한 암호가 맞지 않습니다.");
			document.editForm.pwd.focus();
			return;
		}//if
	   
	   document.delForm.action="DeleteSave.jsp?num=<%=num%>";
	   document.delForm.submit();
   }
   </script>
   </head>
   
    <body bgColor="orange">
   		<h2>글 삭제 폼</h2>
   		<form name="delForm" method="post">
   		<table border="10" width=363>
   		<tr>
   		<td align="center" height=13 width=363>
   		<b>
   		<font face="바탕" size="4" color="#0000A0">
   		글을 지우기를 원한다면 암호를 입력해주세요.
   		</font>
   		</b>
   		</td></tr>
   		
   		<tr>
   		<td height="27" width="363">비밀번호
   		<input type="password" name="pwd" size=8>
   		<p>
   		<input type="button" value="삭제" onClick="javaScript:check()">
   			&nbsp;
   			<input type="button" value="돌아가기" onClick="history.back()">
   		</p>
   		</td></tr>
   		</table>
   		
   		
   		</form>
    </body>
    </html>