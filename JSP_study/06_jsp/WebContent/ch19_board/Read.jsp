<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="boardre.*"
%>

Read.jsp


<%
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="mgr" class="boardre.BoardMgr"/><%-- 객체생성 --%>

<%
//List.jsp에서 보내준 값을 받기
int num=Integer.parseInt(request.getParameter("num"));
int nowPage=Integer.parseInt(request.getParameter("page"));
String keyField=request.getParameter("keyField");
String keyWord=request.getParameter("keyWord");

BoardBean bean=mgr.getBoard(num);//메서드 호출
mgr.upCount(num);

//모델 빈 내용을 변수로 지정
String name=bean.getName();
String email=bean.getEmail();
String homepage=bean.getHomepage();
String subject=bean.getSubject();
String regdate=bean.getRegdate();
String content=bean.getContent();
String ip=bean.getIp();
int count=bean.getCount();

if(content != null ){
content=content.replace("\n", "<br>");
}
%>
키필드 : <%=keyField %>
키 워드 : <%=keyWord %>

<html>
	<head>
	<script>
	function list(){
		document.listForm.action="List.jsp";
		document.listForm.submit();
	}
	</script>
	</head>
	<body>
	<table align=center width=70% border=1 cellpadding=3
	cellspacing=0 borderColor="blue">
		<tr>
		<td bgColor="#9ca2ee" height=25 align=center>
		<font size=7>글내용 보기</font>
		</td>
		</tr>
		
		<tr>
		<td colspan="2">
			<table border=0 cellpadding=3 cellspacing=0 width=100%>
			<tr>
			<td align=center bgcolor="#dddddd" width="10%">이름</td>
			<td bgcolor="#ffffe8"><%=name %></td>
			
			<td align=center bgcolor="#dddddd" width="15%">등록날짜</td>
			<td bgcolor="#ffffe8"><%=regdate %></td>
			</tr>
			
			<tr>
			<td align=center bgcolor="#dddddd" width="10%">메일</td>
			<td bgcolor="#ffffe8">
			<a href="mailto:<%=email %>">
				<%=email %>
			</a>
			</td>
			
			<td align=center bgcolor="#dddddd" width="15%">홈페이지</td>
			<td bgcolor="#ffffe8">
			<a href="<%=homepage %>">
				<%=homepage %>
				</a>
			</td>
			</tr>
			
			<tr>
			<td align=center bgcolor="#dddddd">제목</td>
			<td bgcolor="#ffffe8" colspan=3><%=subject %></td>
			</tr>
			
			<tr>
				<td bgcolor="#ccdde8" colspan=4><br>
				
				<%= content %>
				</td>
			</tr>
			
			<tr>
			<td colspan=4 align=right>
			<%=ip %>로부터 글을 남기셨습니다.  조회수:<%=count %>
			</td>
			</tr>
			
			<tr>
			<td align=center colspan=4>
			<hr>
				[<a href="javascript:list()">리스트</a>]
				[<a href="Update.jsp?page=<%=nowPage %>&num=<%=num %>">수정</a>]
				[<a href="Reply.jsp?page=<%=nowPage %>&num=<%=num %>">답글쓰기</a>]
				[<a href="Delete.jsp?page=<%=nowPage %>&num=<%=num %>">삭제</a>]
				[<a href="post.jsp">새글쓰기</a>]
		</td>
		</tr>
	</table>
	<%
	
	if(keyWord==null || keyWord.equals("")){
	%>
	<form name="listForm" method="post">
		<input type="hidden" name="num" value="<%=num %>">
		<input type="hidden" name="page" value="<%=nowPage %>">
	</form>
	
	<%
	}else{
	%>
	
	<form name="listForm" method="post">
		<input type="hidden" name="num" value="<%=num %>">
		<input type="hidden" name="page" value="<%=nowPage %>">
		<input type="hidden" name="keyWord" value="<%=keyWord %>">
		<input type="hidden" name="keyField" value="<%=keyField %>">
	</form>
	<%
	}
	%>
	</body>	
</html>