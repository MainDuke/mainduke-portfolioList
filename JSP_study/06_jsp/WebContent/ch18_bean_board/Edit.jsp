<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.sql.*"
    
    %>
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
		if(document.editForm.pwd.value==''){
			alert("암호를 입력하시오");
			document.editForm.pwd.focus();
			return;
		}//if
		
	
		if(document.editForm.pwd.value != <%=dto.getPwd()%>){
			alert("입력한 암호가 맞지 않습니다.");
			document.editForm.pwd.focus();
			return;
		}//if
		
		
		
		document.editForm.action="EditSave.jsp?num=<%=num%>";
		document.editForm.submit();
	}//function end
	</script>

     </head>
     <body bgColor="margenta">
	 <form name="editForm"  method="post" action="UpdateSave.jsp">
	 <table border="1" borderColor="blue" bgColor="pink">
	 <tr>
	 <td colspan="2" align="center"><h2>글 수정하기</h2></td>
	 </tr>
	 
	 <tr>
	 <td>글 번호</td>
	 <td><input type="text" name="num" value="<%=dto.getNum()%>" readonly="readonly" ></td>	 
	 </tr>
	 
	 <tr>
	 <td>글 작성자</td>
	 <td><input type="text" name="writer" value="<%=dto.getWriter()%>" ></td>	 
	 </tr>
	 
	 <tr>
	 <td>Email</td>
	 <td><input type="text" name="email" value="<%=dto.getEmail()%>" ></td>	 
	 </tr>
	 <tr>
	 <td>글제목</td>
	 <td><input type="text" name="subject" value="<%=dto.getSubject() %>" ></td>	 
	 </tr>
	 
	 <tr>
	 <td>글 내용</td>
	 <td><textarea name="content" rows=10 cols=50 ><%=dto.getContent() %></textarea>
	 </td>	 
	 </tr>
	 
	 <tr>
	 <td>암호 입력</td>
	 <td><input type="password" name="pwd"  >
	 </td>	 
	 </tr>
	 
	 <tr>
   			<td align="center" colspan="2">
   			<input type="button" value="수정" onClick="javaScript:check()">
   			&nbsp;
   			<input type="button" value="이전으로 돌아가기" onClick="history.back()">
   	</td></tr>
	 
	 </table>
	 
	 
	 </form>

     </body>
     
     </html>