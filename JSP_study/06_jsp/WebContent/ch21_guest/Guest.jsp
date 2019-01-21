<%@page import="guest.GuestBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     import="java.util.*"
    import="boardoracle.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
request.setCharacterEncoding("utf-8");

String id=(String)session.getAttribute("id");

id="test";

%>

<%
int nowPage=0;
int nowBlock=0;

int totalRecord=0;
int numPerPage=0;
int totalPage=0;

int totalBlock=0;
int pagePerBlock=0;
int beginPerPage=0;

String keyField="";
String keyWord="";

Vector vec=null;
%>


<%
String im=request.getParameter("keyWord");
System.out.println("im : "+im);

if(request.getParameter("keyWord") != null){
	keyWord=request.getParameter("keyWord");
	keyField=request.getParameter("keyField");
}//if end

if(request.getParameter("reload")!=null){
	
	if(request.getParameter("reload").equals("true")){
		keyField="";
		keyWord="";
	}//inner end

}//if end
%>
<jsp:useBean id="mgr" class="guest.GuestMsg"></jsp:useBean>
<%
vec=mgr.getBoardList(keyField, keyWord);
totalRecord=vec.size();
numPerPage=10; //페이지당 글 갯수
pagePerBlock=10; //블락당 페이지 수, 10페이지 1 블럭

if(request.getParameter("page") != null){
	nowPage=Integer.parseInt(request.getParameter("page"));	
	}//if end
	
beginPerPage = nowPage * numPerPage ; //시작페이지 계산
//						0 * 10 = 0~9 //해당페이지 시작.


totalPage=(int)Math.ceil((double)totalRecord/numPerPage); //ceil= 올림값
totalBlock=(int)Math.ceil((double)totalPage/pagePerBlock);

if(request.getParameter("nowBlock")!=null){
	nowBlock=Integer.parseInt(request.getParameter("nowBlock"));
}//if end

%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Guset.jsp</title>

<script type="text/javascript">

function insert(){
			
	//이름
	if(document.writeForm.name.value==''){
		alert("name을 입력하시오.");
		document.writeForm.name.focus();
		return false;
	}
	
	
		//content
		if(document.writeForm.content.value==''){
			alert("글내용을 입력하시오.");
			document.writeForm.content.focus();
			return false;
		}
		//pwd
		if(document.writeForm.pwd.value==''){
			alert("PWD을 입력하시오.");
			document.writeForm.pass.focus();
			return false;
		}
		
		//제출
		document.writeForm.submit();

}//insert end

function reply(num){
		
	document.actionForm.action="reply.jsp?num="+num; //글 ㄴ용 보기
	document.actionForm.num.value=num;//글 ㄴ용 보기
	document.actionForm.submit();	
		
}//reply end

function update(num){
	
	document.actionForm.action="UpdateGuest.jsp?num="+num; //글 ㄴ용 보기
	document.actionForm.num.value=num;//글 ㄴ용 보기
	document.actionForm.submit();	
		
}//reply end

function del(num){
	
	document.actionForm.action="Delete.jsp?num="+num; //글 ㄴ용 보기
	document.actionForm.num.value=num;//글 ㄴ용 보기
	document.actionForm.submit();	
		
}//reply end

</script>

<style type="text/css">

table{position:static}

table.depth#a{
position:relative ; left:50px; top:-20px
}

table.depth#b{
position:relative ; left:80px; top:-20px

}

table.depth#c{
position:relative ; left:110px; top:-20px

}

table.depth#d{
position:relative ; left:140px; top:-20px

}

table.depth#e{
position:relative ; left:170px; top:-20px

}
img.a{
position:relative ; left:550px; top:40px
}
img.b{
position:relative ; left:580px; top:40px
}
img.c{
position:relative ; left:610px; top:40px
}
img.d{
position:relative ; left:640px; top:40px
}
img.e{
position:relative ; left:670px; top:40px
}

</style>

</head>

<body >

<!-- 입력 부분 -->
<table  border="5" align="center" width="400" height="250" cellpadding="3" cellspacing="0" bgcolor="#e0ffff">

<tr>
<td colspan="2">홈페이지 주인에게 남기실 방명록을 쓰세요.</td>
</tr>


<form method="post" name="writeForm" action="Write_guest.jsp">

<tr>
<td width="80%" height="90%">
<textarea rows=10 cols=50 name="content"></textarea>
</td>

<td width="20%" height="90%" align=center>
<input type="hidden" name="ip" value="<%=request.getRemoteAddr() %>" >
<input type="hidden" name="id" value=<%=id %>>
<input type="text"  placeholder="이름" name="name">
<input type="password"  placeholder="삭제시 필요" name="pwd">
<input type="button" value="글 쓰기" onclick="insert()" >
<input type="reset" value="리셋">
</td>
</tr>

</form>
</table>

<hr color="blue">
<br>


<%
	for(int i=beginPerPage; i<(beginPerPage + numPerPage);i++){
		if(i==totalRecord){break;}//if end for 조건 탈출한다.
		
				GuestBean bean=(GuestBean)vec.get(i);
				
				String name=bean.getName();
				String content=bean.getContent();
				String regdate=bean.getRegdate();
				
				int depth=bean.getDepth();
				int num=bean.getNum();
				
	%>
<%
if(depth >0){
String imsi="";
	switch(depth){
	case 1: {imsi="a"; break;}
	case 2: {imsi="b"; break;}
	case 3: {imsi="c"; break;}
	case 4: {imsi="d"; break;}
	case 5:{imsi="e"; break;}
	}//end
	out.println("<img class='"+imsi+"' src=../src/cc.png width=60 height=20>");
	out.println("&nbsp;");

}
%>
<%
switch(depth){
case 0:{
%>
<table border="1" width="500" align="center" bgcolor="#e0ffff">
<%
break;
}case 1:{
	%>
	<table class="depth" id="a" border="1" width="500" align="center" bgcolor="#e0ffff">
	<%
break;
}case 2:{
	%>
	<table class="depth" id="b" border="1" width="500" align="center" bgcolor="#e0ffff">
	<%
break;	
}case 3:{
%>
<table class="depth" id="c" border="1" width="500" align="center" bgcolor="#e0ffff">
<%	
break;	
}case 4:{
	%>
	<table class="depth" id="d" border="1" width="500" align="center" bgcolor="#e0ffff">
<%
break;
}case 5:{
%>
	<table class="depth" id="e" border="1" width="500" align="center" bgcolor="#e0ffff">
	<%
	break;
}
}
%>



<!-- <table class="depth" id="a" border="1" width="500" align="center"><table border="1" width="500" align="center"> -->
	
<tr>
<td align="left" width="20%" ><%=totalRecord-i %>번글&nbsp;&nbsp;&nbsp;</td>	
<td><%=name %> 님이 <%=regdate %>에 남긴 방명록 입니다.</td>
</tr>
</table>


<%
switch(depth){
case 0:{
%>
<table border="1"  align="center" width="500" cellpadding="3" cellspacing="0" bgcolor="#f0f8ff">
<%
break;
}case 1:{
	%>
<table class="depth" id="a" border="1"  align="center" width="500" cellpadding="3" cellspacing="0" bgcolor="#f0f8ff">
	<%
break;
}case 2:{
	%>
<table class="depth" id="b" border="1"  align="center" width="500" cellpadding="3" cellspacing="0" bgcolor="#f0f8ff">
	<%
break;	
}case 3:{
%>
<table class="depth" id="c" border="1"  align="center" width="500" cellpadding="3" cellspacing="0" bgcolor="#f0f8ff">
<%	
break;	
}case 4:{
	%>
<table class="depth" id="d" border="1"  align="center" width="500"  cellpadding="3" cellspacing="0" bgcolor="#f0f8ff">
<%
break;
}case 5:{}
%>

<table class="depth" id="e" border="1"  align="center" width="500" cellpadding="3" cellspacing="0" bgcolor="#f0f8ff">
	<%
	break;
}
%>

<!-- 
<table border="1"  align="center" width="500" height="250" cellpadding="3" cellspacing="0" bgcolor="#f0f8ff">
 -->
<tr height="80%">
<td width="80%" height="90%">

<form method="post" name="Guest<%=num%>">
<%=content %><br>
<font size="4" color="pink" align="right"><B>From.<%=name %></B></font>
</form>


</td>

<td width="20%" height="90%" align=center>

<input type="button" value="수정"  onclick="javascript:update('<%=num%>')"><br>
<input type="button" value="삭제" onclick="javascript:del('<%=num%>')"><br>
<input type="button" value="댓글" onclick="javascript:reply('<%=num%>')">
</td>

</tr>

</table> <!-- 안쪽 -->

<br>
<%
	}//for end 방명록 반복이 끝났습니다. ===========================================================
%>
<hr color="blue">

<table border="0" width="100%" algin=center>

	<tr>
	<td align="left">Go to page&nbsp;
	<%
	if(totalRecord!=0){ //글이 존재하면
	
		if(nowBlock>0){%>
		
		<a href="Guest.jsp?nowBlock=<%=nowBlock-1%>&page=<%=((nowBlock-1)*pagePerBlock) %>&keyField=<%=keyField %>&keyWord=<%=keyWord %>">
		[이전블럭 <%=pagePerBlock %>]개</a>
	
	<%
	}//if end 글 존재?
				
	//페이지 처리 부분			
		for(int i=0;i<pagePerBlock; i++){
	%>
	<a href="Guest.jsp?nowBlock=<%=nowBlock %>&page=<%=(nowBlock*pagePerBlock)+i %>">
	[<%=(nowBlock*pagePerBlock)+i+1 %>]
	</a>
	
	<%
	if(((nowBlock*pagePerBlock)+i+1)==totalPage){
		//마지막 페이지인가?
				break; //for 탈출
	}//if 마지막 페이지 확인 end
	%>
		

<%	
	}//for end 숫자 하이퍼 링크 생성 end
	//페이지 처리 부분
	
	//다음 블럭
	
	if(totalBlock > (nowBlock+1)){
		%>
<a href="Guest.jsp?nowBlock=<%=nowBlock+1 %>&page=<%=((nowBlock+1)*pagePerBlock) %>&keyField=<%=keyField %>&keyWord=<%=keyWord %>">
	[다음 블럭<%=pagePerBlock %>]개
	</a>
	<%	
	}//if 다음 블럭 엔드
	
}//if end (글이 존재하면 if 부분 ENd)
%>
</table>

<%--actionForm --%>>
<form name="actionForm" method="post">

<input type="hidden" name="num" value="">
<input type="hidden" name="page" value="<%=nowPage%>">
<input type="hidden" name="keyField" value="<%=keyField%>">
<input type="hidden" name="keyWord" value="<%=keyWord%>">
</form>

</body>
</html>