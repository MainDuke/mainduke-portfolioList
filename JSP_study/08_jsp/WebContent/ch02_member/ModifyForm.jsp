<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.*"
     %>
     <%@ include file="../view/color.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
request.setCharacterEncoding("utf-8");

String id=(String)session.getAttribute("memId");
LoginDao dao=LoginDao.getInstance();
LoginDto dto= dao.getMember(id);
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
	function checkIt(){
		if (document.userForm.passwd.value=='') {
			alert("비밀번호를 입력하시오.");
			document.userForm.passwd.focus();
			return false;
		}
		
		if (document.userForm.passwd2.value=='') {
			alert("비밀번호 확인을 입력하시오.");
			document.userForm.passwd2.focus();
			return false;
		}
		if (document.userForm.passwd.value !=document.userForm.passwd2.value) {
			alert("비밀번호가 일치하지 않습니다.");
			document.userForm.passwd.focus();
			return false;
		}
	}	//end checkIt
	
	function zipCheck(){
		//alert("우편번호 찾기");
		
		url="ZipCheck.jsp?check=y";
		window.open(url, "zip",  "width=300, height=200, status=yes, scrollbars=yes");
	}//end zip
	
	</script>
</head>
<body bgcolor="<%=bodyback_c%>">
	<form method="post" name="userForm" action="ModifyPro.jsp" onsubmit="return checkIt()">
	
	<table width="600" border="1" cellpadding="3" cellspacing="0" align="center">
		<tr>
		<td colspan="2" height="39" bgcolor="<%=title_c %>" align="center">
		<h2><b><br>회원정보 수정</b></h2>
		</td>
		</tr>
		
		<tr>
		<td colspan="2" align="center">
		</td>
		</tr>
		
		<tr>
		<td width="200" bgcolor="<%=value_c%>"><b>패스워드 입력</b></td>
		<td width="400" bgcolor="<%=value_c%>">&nbsp;</td>
		</tr>
		
		<tr>
		<td >사용자 ID</td>
		<td ><%=dto.getId() %></td>
		</tr>
		
		<tr>
		<td >비밀번호</td>
		<td ><input type="password" name="passwd" size="10"></td>
		</tr>
		
		<tr>
		<td >비밀번호 확인</td>
		<td ><input type="password" name="passwd2" size="10"></td>
		</tr>
		
		<tr>
		<td width="200" bgcolor="<%=value_c%>"><b>개인정보 입력</b></td>
		<td width="400" bgcolor="<%=value_c%>">&nbsp;</td>
		</tr>
		
		<tr>
		<td >사용자 이름</td>
		<td ><input type="text" name="name" size="15" value="<%=dto.getName()%>"></td>
		</tr>
		
		<tr>
		<td >주민등록 번호</td>
		<td ><%=dto.getJumin1()%>-<%=dto.getJumin2()%></td>
		</tr>
		
		
		<%--email. --%>
		
		<tr>
		<td width="200">Email </td>
		<td width="400">
		<%
		String im=dto.getEmail();
		if(im==null){
			im="";
		}
		%>
		<input type="text" name="email" size="40" value="<%=im%>">
		</td>
		</tr>
		
		<%--우편번호. --%>
		
		<tr>
		<td width="200">우편번호</td>
		<td width="400">
		<%
		im=dto.getZipcode();
		if(im==null){
			im="";
		}
		%>
		<input type="text" name="zipcode" size="7" value="<%=im%>">
		<input type="button"  value="우편번호 찾기" onclick="zipCheck()">
		</td>
		</tr>
		
		<%--주소. --%>
		
		<tr>
		<td width="200">주소</td>
		<td width="400">
		<%
		im=dto.getAddr();
		if(im==null){
			im="";
		}
		%>
		<input type="text" name="addr" size="50" value="<%=im%>">
		</td>
		</tr>
		
		<%--직업. --%>
		
		<tr>
		<td width="200">직업</td>
		<td width="400">
		<%
		im=dto.getJob();
		if(im==null){
			im="무직";
		}
		%>
		<select name="job" >
			<option value="0">선택 하시오</option>
			<option value="회사원">회사원</option>
			<option value="연구원">연구원</option>
			<option value="교수학생">교수학생</option>
			<option value="의료인">의료인</option>
			<option value="공무원">공무원</option>
			<option value="기타">기타</option>
		
		</select>
		<input type="text" name="job2" size="20" value="기존 직업 : <%=im%>" readonly="readonly">
		</td>
		</tr>
		
		<%--Blog. --%>
		
		<tr>
		<td width="200">Blog</td>
		<td width="400">
		<%
		im=dto.getBlog();
		if(im==null){
			im="";
		}
		%>
		<input type="text" name="blog" size="50" value="<%=im%>">
		</td>
		</tr>
		
		<tr>
		<td colspan="2" align="center">
		<input type="submit" value="수정">
		<input type="button" value="취소"  onclick="javascript:location='Main.jsp'">
		</td>
		</tr>
		
		
		
		
	</table>	
	
	</form>
</body>
</html>