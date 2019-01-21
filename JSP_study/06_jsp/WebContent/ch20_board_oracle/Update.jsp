<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="boardoracle.*"
    %>
    Update.jsp

<%
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="mgr" class="boardoracle.BoardMgr"/>

<%
	int nowPage=Integer.parseInt(request.getParameter("page"));
	int num=Integer.parseInt(request.getParameter("num"));
	
	BoardBean bean=mgr.getBoard(num);
	
	String subject=bean.getSubject();
	String name=bean.getName();
	String content=bean.getContent();
	String email=bean.getEmail();
	String homepage=bean.getHomepage();
	%>

	<html>
		<head>
			<script>
			function check(){
				if(document.editForm.pass.value==''){
					alert("암호를 입력하시오");
					editForm.pass.focus();
					return false;
				}
				document.editForm.submit();//서버로전송
			}//check() end
			</script>
		</head>
		
		<body>
			<table width=460 cellspacing=0 cellpadding=3 align="center">
			<tr>
			<td bgcolor="#ff9018" height=21 align="center">
			<font size=7>글 수정하기</font>
			</td>
			</tr>
			</table>
		
			<form name="editForm" method="post" action="UpdateProc.jsp" >
				<table align="center" cellspacing="0" cellpadding=7>
				<tr>
				<td >
				<table border=0 >
					<tr>
					<td width=20%>이름</td>
					<td width="80%">
					<input type="text" name="name" value="<%=name %>" size="20">
					</td>
					</tr>
					
					<tr>
					<td>이메일</td>
					<td>
					<input type="text" name="email" value="<%=email %>" size="30">
					</td>
					</tr>
					
					<tr>
					<td>홈페이지</td>
					<td>
					<input type="text" name="homepage" value="<%=homepage %>" size="30">
					</td>
					</tr>
					
					<tr>
					<td>제목</td>
					<td>
					<input type="text" name="subject" value="<%=subject %>" size="50">
					</td>
					</tr>
					
					<tr>
					<td>제목</td>
					<td>
					<textarea name="content" rows="10" cols="50"><%=content %></textarea>
					</td>
					</tr>
					
					<tr>
					<td>암호</td>
					<td>
					<input type="password" name="pass" size="15">
					수정시에는 암호가 필요합니다
					</td>
					</tr>
					
					<tr>
					<td colspan=2>
						<input type="button" value="수정" onclick="check()">
						<input type="reset" value="다시수정하기">
						<input type="button" value="뒤로" onclick="history.go(-1)">
						
						<input type="hidden" name="num" value="<%=num %>">
						<input type="hidden" name="page" value="<%=nowPage %>">
					</td>
					</tr>
					
					<tr>
					<td colspan=2>
					<hr>
					</td>  
					</tr>
					
				</table>
				</td>
				</tr>
				</table>
			
			</form>
		</body>
		
		
	</html>
	