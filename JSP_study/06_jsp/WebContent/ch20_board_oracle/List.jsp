<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    import="boardoracle.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
request.setCharacterEncoding("utf-8");
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
//System.out.println("im : "+im);

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

<jsp:useBean id="mgr" class="boardoracle.BoardMgr"></jsp:useBean>


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
<title>Insert title here</title>
<script type="text/javascript">
function check(){
	if(document.searchForm.keyWord.value==''){
		alert("검색어를 입력하시오.");
		document.searchForm.keyWord.focus();
		return false;
	}//if end
	document.searchForm.submit();
}//end check;

function list(){
	document.listForm.action="List.jsp";
	document.listForm.submit();
}//list() end

function read(value){
	document.readForm.action="Read.jsp"; //글 ㄴ용 보기
	document.readForm.num.value=value;//글 ㄴ용 보기
	document.readForm.submit();	
}//read end

</script>

</head>
<body>
<table align="center" border="0" width="80%">
<tr>
<td align="left">
Total: <%=totalRecord %> Aticles
(<font color="red"><%=nowPage+1 %>/<%=totalPage %></font>)
</td>
</tr>

</table>

<table align="center" width="80%" border="1" cellpadding="3" cellspacing="0"> 

<tr>
<td align="center" colspan="2">
<%
if(vec.isEmpty()){
	out.println("등록된 글이 없습니다.");
}else{
	%>
	<table border="1" width="100%" cellpadding="2" cellspacing="0">
	
	<tr align="center" bgcolor="#d0d0d0" height="120%">
	<td>번호</td>
	<td>제목</td>
	<td>이름</td>
	<td>날짜</td>
	<td>조회수</td>
	</tr>
	
	<%
	for(int i=beginPerPage; i<(beginPerPage + numPerPage);i++){
		if(i==totalRecord){break;}//if end for 조건 탈출한다.
		
		BoardBean bean=(BoardBean)vec.get(i);
				
				String name=bean.getName();
				String subject=bean.getSubject();
				String email=bean.getEmail();
				String regdate=bean.getRegdate();
				
				int depth=bean.getDepth();
				int num=bean.getNum();
				int count=bean.getCount();
				%>
				
	<tr> <!--번호 역순으로 , num 과 다르다 -->
	<td align="center"><%=totalRecord-i %></td>	
	<td>
	<%
	if(depth>0){
		for(int re=0;re<depth; re++){
			out.println("&nbsp;&nbsp;");
		}//for
	}//if
	%>
	
	<a href="javascript:read('<%=num %>')"><%=subject %></a></td>
	
	<td align="center"><a href="mailto:<%=email %>"><%=name %></a></td>
	
	<td align="center"><%=regdate %></td>
	<td align="center"><%=count %></td>
	
	</tr>
	
	<%
	
	}//for end
	
	%>
	</table>
	
<%
}//else문 끝나는곳
%>
</td>
</tr>

	<tr>
	<td colspan="2"><br></td>
	</tr>
		
	<tr>
	<td align="left">Go to page&nbsp;
	<%
	if(totalRecord!=0){ //글이 존재하면
	
		if(nowBlock>0){%>
		
		<a href="List.jsp?nowBlock=<%=nowBlock-1%>&page=<%=((nowBlock-1)*pagePerBlock) %>&keyField=<%=keyField %>&keyWord=<%=keyWord %>">
		[이전블럭 <%=pagePerBlock %>]개</a>
	
	<%
	}//if end 글 존재?
				
	//페이지 처리 부분			
		for(int i=0;i<pagePerBlock; i++){
	%>
	<a href="List.jsp?nowBlock=<%=nowBlock %>&page=<%=(nowBlock*pagePerBlock)+i %>">
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
<a href="List.jsp?nowBlock=<%=nowBlock+1 %>&page=<%=((nowBlock+1)*pagePerBlock) %>&keyField=<%=keyField %>&keyWord=<%=keyWord %>">
	[다음 블럭<%=pagePerBlock %>]개
	</a>
	<%	
	}//if 다음 블럭 엔드
	
}//if end (글이 존재하면 if 부분 ENd)
%>
</td>
<td align="right">
<a href="post.jsp">[글쓰기]</a>
<a href="javascript:list()">[리스트 처음으로]</a>
</td>
</tr>

</table>

<form name="searchForm" method="post" action="List.jsp">
<table bgcolor="ivory" width="80%" border="1" align="center" cellpadding="4" cellspacing="0">
<tr>
<td align="center" valign="bottom">

<select name="keyField">
	<option value="subject">제목</option>
	<option value="name">이름</option>
	<option value="content">글 내용</option>
</select>

<input type="text" name="keyWord" size="16">
<input type="hidden" name="page" value="0">
<input type="button" value="찾기" onclick="check()">

   </td>
  </tr>
 </table>
</form>

<%--readForm --%>>
<form name="readForm" method="post">

<input type="hidden" name="num" value="">
<input type="hidden" name="page" value="<%=nowPage%>">
<input type="hidden" name="keyField" value="<%=keyField%>">
<input type="hidden" name="keyWord" value="<%=keyWord%>">
</form>

<%--listForm --%>>
<form name="listForm" method="post">

<input type="hidden" name="reload" value="true">
<input type="hidden" name="page" value="0">
<input type="hidden" name="nowBlock" value="0">
</form>

</body>
</html>













