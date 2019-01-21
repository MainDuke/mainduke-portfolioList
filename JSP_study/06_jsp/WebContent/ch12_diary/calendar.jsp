<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page
import="java.sql.*"
import="java.util.*"
import="mtutil.*"
%>

<%--calendar--%>
<%
Connection con=null;
Statement stmt=null;
ResultSet rs=null;

String strYear=request.getParameter("year");
String strMonth=request.getParameter("month");
String sql="";
String url="";
String selected="";

String user_id=(String)session.getAttribute("userid");
user_id="park";
/*
out.println("user_id: "+user_id);

if(user_id == null || user_id.equals("")){
	
	out.println("<script language='JavaScript'>");
	out.println("alert('로그인을 하세요')");
	out.println("document.location='Login.jsp'");
	out.println("</script>");
	
return;
}//if
*/

Calendar myCalendar=Calendar.getInstance();
Calendar cal= Calendar.getInstance();

int year=0;
int month=0;
int previous_year=0;
int previous_month=0;
int next_year=0;
int next_month=0;
int  day=0; //날짜
int id=0; //일련번호

myutil.DBConnection db= new myutil.DBConnection(); //객체 생성

try{
	con=db.getCon();
	stmt=con.createStatement();
		
}catch(SQLException se){}

if(strYear == null){ //넘어온 년도가 없으면 현재년도를 구한다.
	year=myCalendar.get(myCalendar.YEAR);
}else{
	year=Integer.parseInt(strYear);
}

if(strMonth==null){
month=myCalendar.get(myCalendar.MONTH);	
}else{
	month= Integer.parseInt(strMonth)-1; //넘어온 달을 -1 해줘야한다.
															//1월--0 2월 ==1 ,,,, 12월 --11
}
myCalendar.set(myCalendar.YEAR, year);
myCalendar.set(myCalendar.MONTH, month);
month=month+1; //1낮춘값을 다시 복귀 (보여주기 위해서)

previous_year=myCalendar.get(myCalendar.YEAR) -1;
previous_month = myCalendar.get(myCalendar.MONTH);

if(previous_month<1){
	previous_month=12;
}

next_year = myCalendar.get(myCalendar.YEAR)+1;
next_month=myCalendar.get(myCalendar.MONTH)+2; //다음달

if(next_month>12){
	next_month=1;
}

%>
<html>
<head>
<title>다이어리</title>
</head>
<body bgColor="margenta">
<center><h1><b><font color=blue>다이어리</font></b></h1></center>
<form method="post" action="calendar.jsp">
<table border="1" borderColor=#660000 width=470 cellspacing=1 cellpadding=1 align=center>
<tr>
<td align=center bgColor=#99FF99>
&nbsp;&nbsp; 금일은
<%=myCalendar.get(myCalendar.YEAR)%>년
<%=myCalendar.get(myCalendar.MONTH)+1 %>월
<%=myCalendar.get(myCalendar.DATE) %>일
</td>
</tr>
</table>
<table border="0" width=460 cellspacing=0 cellpadding=0 align=center>
<tr>
<td width="30%" align="center">
<a href="calendar.jsp?year=<%=previous_year %>&month=<%=month %>">[&lt;&lt;]</a>
<a href="calendar.jsp?year=<%=previous_month==12 ? previous_year:year %>&month=<%=previous_month %>">[&lt;&lt;]</a>

</td>
<!--  ----- -->
<td width="45%" align=Left>
<select name="year">
<%
for(int i=-7; i<7;i++){ //  -5 2016년 기준 + 5
	int temp_year=year+i;
	if(year==temp_year){
		selected="selected"; //선택
	}else{
		selected=""; //선택해제
	}//else end
	%>
	<option value="<%=temp_year%>"  <%=selected %>><%=temp_year %></option>
	
	<%
}//for
%>
</select>년도

<select name="month">
<%
for(int i=1; i<12;i++){ //  -5 2016년 기준 + 5
	
	if(month==i){
		selected="selected"; //선택
	}else{
		selected=""; //선택해제
	}//else end
	%>
	<option value="<%=i%>"  <%=selected %>><%=i %></option>
	
	<%
}//for
%>
</select>월
<input type="submit" value="이동">

</td>

<td width=25% align=Left>
	<a href="calendar.jsp?year=<%=next_month==1 ? next_year : year%>&month=<%=next_month %>">[&gt;]</a>
	<a href="calendar.jsp?year=<%=next_year%>&month=<%=month %>">[&gt;&gt;]</a>

</td>
</tr>
</table>
<br>
<table border="1" cellpadding=3 cellspacing=0 align=center borderColor=black borderColordark=white width=480>

<tr align=center>
<td width=180 bgColor=CC99FF>일요일</td>
<td width=180 bgColor=33CCFF>월요일</td>
<td width=180 bgColor=33CCFF>화요일</td>
<td width=180 bgColor=33CCFF>수요일</td>
<td width=180 bgColor=33CCFF>목요일</td>
<td width=180 bgColor=33CCFF>금요일</td>
<td width=180 bgColor=33CCFF>토요일</td>

</tr>

<%
while(true){
	day++;
	myCalendar.set(myCalendar.DAY_OF_MONTH, day);


//달력의 날짜가 다음달로 넘어가면
//DAY_OF_MONTH : 필드 번호를 get 및 set 달의 하루를 나타내는 설정할 수 있습니다.

//날짜를 구해서, 그달의 날짜가 아니면, while 문 탈출
if(day != myCalendar.get(myCalendar.DAY_OF_MONTH)){
	break;
}
if(day ==1){
	out.println("<tr align='right' valign='top'>");

	//DAY_OF_WEEK : 필드 번호를 get 및 set 달의 하루를 나타내는 설정할 수 있습니다.
	//요일수 만큼 빈칸 만들기
	for(int j=1;j<myCalendar.get(myCalendar.DAY_OF_WEEK); j++){
		out.println("<td height=60>&nbsp;</td>");
	}//for
	
}//if
try{
	sql="select id from diary where year='"+year+"'";
	sql= sql+ " and month='"+month+"' and day='"+day+"'";
	sql= sql+ " and userid='"+user_id+"'";
	
	rs=stmt.executeQuery(sql);
	
	if(rs.next()){
		id=rs.getInt("id");
	}
	
}catch(SQLException se){
	
}finally{
	rs.close();
}

if(id>0){ //id 글 번호가 존재하면, 노란색으로 표기.
	out.println("<td height=60 bgColor=yellow><img src=../src/aa.gif width=20 height=20>");
	url="view.jsp?id="+id;
	
}else{
	out.println("<td height=60>");
	//글쓰기 하러가기
	url="write.jsp?mode=null&year="+year+"&month="+month+"&day="+day;
}//else end
out.println("<a href='"+url+"'>");

//자기 생일 표시하기
int dd=myCalendar.get(myCalendar.DATE);
int mm= myCalendar.get(myCalendar.MONTH)+1;

//일요일이면 빨강색으로

if(myCalendar.get(myCalendar.DAY_OF_WEEK)==myCalendar.SUNDAY){
	
		//오늘
		if(cal.get(cal.YEAR)==year && (cal.get(cal.MONTH)+1)==month && cal.get(cal.DATE)==day){
			
			out.println("<font color=red size='2'>");
			out.println(myCalendar.get(myCalendar.DAY_OF_MONTH));	
			out.println("오늘");
			out.println("</font>");			
		}else{
			out.println("<font color='red'>");
			out.println(myCalendar.get(myCalendar.DAY_OF_MONTH));	 //날짜 출력
			out.println("</font>");		
		}

		//생일이면 출력
		if(dd==19 && mm==4){
			out.println("<br><font size='2'>내생일</font>");
		}
}//일요일 if 끝
else{ //일요일이 아니면
	if(cal.get(cal.YEAR)==year && (cal.get(cal.MONTH)+1)==month && cal.get(cal.DATE)==day){
		out.println("<font color=red size='2'>");

		out.println(myCalendar.get(myCalendar.DAY_OF_MONTH));	
		out.println("<br><center>오늘</center>");
		out.println("</font>");		
	}else{
		out.println(myCalendar.get(myCalendar.DAY_OF_MONTH));
	}
		//자기 생일 표시하기
			if(dd==19 && mm==4){
				out.println("<br><font size='2'>내생일</font>");
			}
}//else end

out.println("</a></td>");

//토요일이면 다음줄로 이동
if(myCalendar.get(myCalendar.DAY_OF_WEEK)==myCalendar.SATURDAY){
	out.println("</tr>");
	out.println("<tr align='right' valign='top'>"); //줄시작
}

id=0;
}//while end																			

//마지막이 토요일로 끝나지 않았을때ㅑ 줄을 닫아준다.
if(myCalendar.get(myCalendar.DAY_OF_WEEK) !=myCalendar.SATURDAY){
	out.println("</tr>");
	}


%>

</table>

</form>
</body>
</html>








