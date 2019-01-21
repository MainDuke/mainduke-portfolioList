<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="boardre.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="mgr" class="boardre.BoardMgr"/><%-- 객체생성 --%>

<%

//List.jsp에서 보내준 값을 받기
int num=Integer.parseInt(request.getParameter("num"));
int nowPage=Integer.parseInt(request.getParameter("page"));
String pwd="";
pwd=request.getParameter("pwd");
System.out.println("pwd 테스트 입니다. : "+request.getParameter("pwd"));
BoardBean bean=mgr.getBoard(num);//메서드 호출

if(!(pwd==null || pwd.equals("") )){

				if(pwd.equals(bean.getPass())){
					mgr.deleteBoard(num);
					response.sendRedirect("List.jsp?page="+nowPage);
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
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function check(){
	   if(document.delForm.pwd.value==''){
		   alert("암호를 입력하시오");
		   document.delForm.pwd.focus();
		   return;
	   }//if
	 
	   document.delForm.action="Delete.jsp";
	   document.delForm.submit();
}


</script>

</head>
<body>


		<h2>글 삭제 폼</h2>
   		<form name="delForm" method="post">
   		<table border="10" width=363 align="center">
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
   		
   		<input type="hidden" value="<%=num %>"  name="num">
   		<input type="hidden" value="<%=nowPage %>"  name="page">
   		<input type="button" value="삭제" onClick="javascript:check()">
   			&nbsp;
   			<input type="button" value="돌아가기" onClick="history.back()">
   		</p>
   		</td></tr>
   		</table>
   		
   		
   		</form>

</body>
</html>