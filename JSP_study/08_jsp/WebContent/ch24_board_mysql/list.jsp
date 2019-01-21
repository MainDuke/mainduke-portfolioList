<%@page import="boardmysql.BoardDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    import="boardmysql.*"
    %>
    
    <%@ include file="../view/color.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%request.setCharacterEncoding("utf-8");

%>

<%! int pageSize=10;
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

%>
<%
String pageNum=request.getParameter("pageNum");
if(pageNum==null){
	pageNum="1";
}//if
//list.jsp 에 들어올때 마다, 들어오는 값을 판단해서 결정한다.
int currentPage=Integer.parseInt(pageNum); //현재 페이지
int startRow=(currentPage-1)*pageSize+1; //시작 글 번호
//(1-1)*10+1=1
//(2-1)*10+1=11
//(3-1)*10+1=21
//(4-1)*10+1=31
//(5-1)*10+1=41
int endRow=currentPage*pageSize; //페이지의 끝 글번호
//1*10=10
//2*10=20
//3*10=30
//4*10=40
//5*10=50

int count=0; //글 갯수
int number=0;//글 번호
List list=null;

BoardDao dao=BoardDao.getInstance();
count = dao.getArticleCount(); //daon 메서드 호출, 글 갯수 얻기.

if(count>0){//글이 존재하면
	list=dao.getList(startRow, pageSize); //메서드 호출
}//if

number=count-(currentPage-1)*pageSize;// 보여질 글 번호
%>
<html>
	<head>
	<title>list.jsp</title>
	<link rel="stylesheet" href="style.css" type="text/css">

	</head>
	
	<body bgcolor="<%=bodyback_c%>">
	<center><b><h1>글목록(전체글):<%=count %></h1></b></center>
	
	<table width="700" align="center">
		<tr>
			<td align="right" bgcolor="<%=value_c%>">
				<a href="writeForm.jsp"><h3>글쓰기</h3></a>
			</td>
		</tr>
	</table>
	<%if(count==0){//글이 없으면 %>
	<table width="700" border="1" cellpadding="0" cellspacing="0">
	<tr>
	<td align="center">게시판에 저장된 글이 없습니다.</td>
	</tr>
	</table>
	
	<%
	}else{//저장된 글이 있으면
	%>
	<table width="700" border="1" cellpadding="3" cellspacing="0" align="center">
	
		<tr>
		<td align="center" width="50">번호</td>
		<td align="center" width="200">제목</td>
		<td align="center" width="100">작성자</td>
		<td align="center" width="200">작성일</td>
		<td align="center" width="50">조회수</td>
		<td align="center" width="100">IP</td>
		</tr>
	
	<%
	for(int i=0;i<list.size();i++){ 
		BoardDto dto=(BoardDto)list.get(i);
	%>	
		<tr height="30">
		<td align="center" width="50"><%=number-- %></td>
		<td width="200">
		<%
		int wid=0; //변수
		if(dto.getRe_level()>0){//답글이면
			wid=5*(dto.getRe_level());
		%>
		<img src="../imgs/level.gif" width="<%=wid%>" height="16">
		<img src="../imgs/re.gif">
		
		<%	
		}else{//원글
		%>
		<!-- <img src="imgs/level.gif" width="<%=wid%>" height="16"> -->
		<%	
		}//else
		%>
		<%--글 제목 --%>
		<a href="content.jsp?num=<%=dto.getNum() %>&pageNum=<%=currentPage %>">
		<%=dto.getSubject() %>
		</a>	
		
		<%
		if(dto.getReadcount()>20){//조회수가 20이상이면 표식
			%>
			<img src="../imgs/hot.gif" border="0" height="16">
		<%
		}//if
		%>
		</td>
		<%--글쓴이 --%>
		<td align="center" width="100">
		<a href="mailto:<%=dto.getEmail() %>"><%=dto.getWriter() %>	</a>
		</td>
		
		<td align="center"><%=sdf.format(dto.getRegdate()) %></td>
		<td align="center"><%=dto.getReadcount()%></td>
		<td align="center"><%=dto.getIp()%></td>
		</tr>
	<%
	}//for
	%>
	
	</table>
	
	<%
	}//else 글 존재 끝.
	 %>
	 
	 <%--block 처리 페이지 처리 --%>
	<%
	if(count>0){
	%>
	<table border="1" width="700" align="center">
	<tr>
	<td align="center">
	
	<%
	int pageCount=count/pageSize+(count%pageSize==0?0:1);
		//							조건?참:거짓
	int pageBlock=10; //블록당 페이지수
	int startPage=(int)(currentPage/pageBlock)*10+1; //시작 페이지
	int endPage=startPage+pageBlock-1;//끝 page
	
	if(endPage>pageCount){//에러 방지 하기 위해
		endPage=pageCount;
	}//if
	//이전 블럭
	if(startPage>10){
		%>
		<a href="list.jsp?pageNum=<%=startPage-10 %>">[이전블럭]</a>
	<%
	}//if
	%>
	<%
	//페이지 처리
	for(int i=startPage;i<=endPage;i++){
	%>
	
		<a href="list.jsp?pageNum=<%=i %>">[<%=i %>]</a>
		
	<%
	}//for 
	%>
	
	<%
	//다음 블럭
	if(endPage<pageCount){
		%>
		<a href="list.jsp?pageNum=<%=startPage+10 %>">[다음블럭]</a>
		<%
	}
	%>
	
	</td>
	</tr>
	
	</table>
		
	<%
	}//if end 글이 존재하면
	%>
	</body>
</html>











