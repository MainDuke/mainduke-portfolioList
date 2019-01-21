<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="../view/color.jsp" %>
<%--writeForm.jsp 원글 답글--%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
		
		<script type="text/javascript">
		function writeSave(){
			
			if($("#writer").val()==''){
				alert("이름을 입력 하시오");
				$("#writer").focus();
			return false;
			}//if end
			
			if($("#subject").val()==''){
				alert("글제목을 입력 하시오");
				$("#subject").focus();
				return false;
			}//if end
			
			if($("#content").val()==''){
				alert("글내용을 입력 하시오");
				$("#content").focus();
				return false;
			}//if end
			
			if($("#passwd").val()==''){
				alert("암호를 입력 하시오");
				$("#passwd").focus();
				return false;
			}//if end
			
			
		}//wrtie save() end
		
		</script>
	</head>
	<%
	int num=0; //변수
	int ref=1; //그룹 글
	int re_step=0; //글 순서 정리
	int re_level=0; //글 깊이 depth
	String regdate="";
	
	try{
		if(request.getParameter("num") != null){//답글 이면
			num=Integer.parseInt(request.getParameter("num"));
			ref=Integer.parseInt(request.getParameter("ref"));
			re_step=Integer.parseInt(request.getParameter("re_step"));
			re_level=Integer.parseInt(request.getParameter("re_level"));
			
		}//if
	}catch(Exception ex){}
	
	
	%>
	
<body bgcolor="<%=bodyback_c %>">
<center><h2>글 쓰기 ~ 답글 쓰기 폼</h2></center>
<form action="writePro.jsp" method="post" name="writeform" onsubmit="return writeSave()">
	
	<input type="hidden" name="num" value="<%=num%>">
	<input type="hidden" name="ref" value="<%=ref%>">
	<input type="hidden" name="re_step" value="<%=re_step%>">
	<input type="hidden" name="re_level" value="<%=re_level%>">

<table width="500" cellpadding="3" cellspacing="0" bgcolor="<%=bodyback_c%>" align="center">

	
	<tr>
		<td align="center" colspan="2" bgcolor="<%=value_c%>">
			<a href="list.jsp"><b>글 목록</b></a>
		</td>
	</tr>

	<!-- 이름 -->
	<tr bgcolor="<%=value_c%>">
		<td width="70" bgcolor="<%=value_c%>">이름</td>
		<td width="330">
		<input type="text" name="writer" id="writer" size=10>
		</td>
	</tr>

	<!-- 글제목 -->
	<tr bgcolor="<%=value_c%>">
		<td bgcolor="<%=value_c%>">제목</td>
		<td >
		<%if(request.getParameter("num")==null){ %>
		<input type="text" name="subject" id="subject" size=40>
		<%}else{ %>
		<input type="text" name="subject" id="subject" size=40 value="[답변]">
		<%} %>
		</td>
	</tr>
	
	<!-- 이메일 -->
	<tr bgcolor="<%=value_c%>">
		<td bgcolor="<%=value_c%>">이메일</td>
		<td>
		<input type="text" name="email" id="email" size=30>
		</td>
	</tr>
	
	<!-- 글내용 -->
	<tr bgcolor="<%=value_c%>">
		<td width="70" bgcolor="<%=value_c%>">글내용</td>
		<td width="330">
		<textarea name="content" id="content" rows="10" cols="40"></textarea>
		</td>
	</tr>
		<!-- 암호 -->
	<tr bgcolor="<%=value_c%>">
		<td bgcolor="<%=value_c%>">비밀번호</td>
		<td>
		<input type="password" name="passwd" id="passwd" size="12">
		</td>
	</tr>
	
	
	
	<tr bgcolor="<%=value_c%>">
		<td colspan="2" align="center" bgcolor="<%=value_c%>">
		<input type="submit" value="글쓰기">
		<input type="reset" value="다시쓰기">
		<input type="button" value="목록보기" onclick="window.location='list.jsp'">
		</td>
	</tr>
	
	
	
</table>



</form>
</body>
</html>



