<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
    <%@ include file="../view/color.jsp" %>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

function checkIt(){
	
	var userinput=eval("document.userForm");
	
	//not 연산으로 null 값 체크하기.
	if(!userinput.id.value){
		alert("id는 필수 입력 입니다.");
		return false;
	}//end
	
	if(userinput.passwd.value==''){
		alert("pwd는 필수 입력 입니다.");
		userinput.passwd.focus();
		return false;
	}//end
	
	if(userinput.passwd2.value==''){
		alert("pwd는 확인을 하십시오.");
		userinput.passwd2.focus();
		return false;
	}//end

	if(userinput.name.value==''){
		alert("이름을 입력하시오");
		userinput.name.focus();
		return false;
	}//end
	if(!userinput.jumin1.value || !userinput.jumin2.value){
		alert("주민번호를 확인을 하십시오.");
		userinput.jumin1.focus();
		return false;
		}//end
	//데이터 유효성 체크펑션 끝
	return true;
}//end function

function idCheck(formID){
	if(formID.id.value==''){
		formID.id.focus();
	}
	
}//end idCheck

function openConfirmID(formID){
	
	//alert("아이디 중복 체크 함수")
	
	if(formID.id.value==''){
		alert("아이디를 입력 하시오");
		formID.id.focus();
		return false;
		
	}//id end
	
	url="confirmId.jsp?id="+formID.id.value;
	
	open(url, "confirm", "width=300, height=200");//새로운 윈도우를 엽니다.
}//end ope

function zipCheck(){
	//alert("우편번호 찾기");
	
	url="ZipCheck.jsp?check=y";
	window.open(url, "zip",  "width=300, height=200, status=yes, scrollbars=yes");
}//end zip

</script>

</head>
<body bgcolor="<%=bodyback_c%>">
 
	<form method="post" name="userForm" action="inputPro.jsp">
	
	<table width="650" border="1" cellpadding="3" cellspacing="0">
	
	<tr>
	<td colspan="2" height="30" align="center" bgcolor="<%=value_c %>">	
	<h2><b><br>회원가입</b></h2>
	</td>
	</tr>	
	
	<tr>
	<td width="200" bgcolor="<%=value_c%>"><b>아이디</b></td>
	<td width="400" bgcolor="<%=value_c%>">&nbsp;</td>
	</tr>
	
	
	<tr>
	<td width="200">사용자 ID</td>
	<td width="400">
		<input type="text" name="id" size="10" onblur="idCheck(this.form)">
		<input type="button" value="중복체크" onClick="openConfirmID(this.form)">
	</td>
	</tr>	
	
	
	<tr>
	<td width="200">비밀번호</td>
	<td width="400">
		<input type="password" name="passwd" size="15">
	</td>
	</tr>	
		
		<tr>
		<td width="200">비밀번호 확인</td>
		<td width="400">
		<input type="password" name="passwd2" size="15">
		</td>
		</tr>

		<tr>
		<td width="200" bgcolor="<%=value_c%>"><b>개인정보 입력</b></td>
		<td width="400" bgcolor="<%=value_c%>">&nbsp;</td>
		</td>
		</tr>
		
		
		<tr>
		<td >사용자 이름</td>
		<td >
		<input type="text" name="name" size="15">
		</td>
		</tr>
		
		<tr>
		<td>주민 등록 번호</td>
		<td>
		<input type="text" name="jumin1" size="6" onkeyup="if(this.value.length==6) userForm.jumin2.focus();">-
		<input type="text" name="jumin2" size="7" onkeyup="if(this.value.length==7) userForm.email.focus();">
		</td>
		</tr>
	
		<tr>
		<td >Email</td>
		<td >
		<input type="text" name="email" size="40">
		</td>
		</tr>
		
		<tr>
		<td >우편번호</td>
		<td >
		<input type="text" name="zipcode" size="7">
		<input type="button"  value="우편번호 찾기" onclick="zipCheck()">
		</td>
		</tr>
		
		<tr>
		<td >주소</td>
		<td >
		<input type="text" name="addr" size="70">
		</td>
		</tr>
		
		<tr>
		<td >직업</td>
		<td >
		<select name="job" >
			<option >선택 하시오</option>
			<option value="회사원">회사원</option>
			<option value="연구원">연구원</option>
			<option value="교수학생">교수학생</option>
			<option value="의료인">의료인</option>
			<option value="공무원">공무원</option>
			<option value="기타">기타</option>
		
		</select>
		</td>
		</tr>
		
		<tr>
		<td >블로그</td>
		<td >
		<input type="text" name="blog" size="60">
		</td>
		</tr>
		
		<tr>
		<td colspan="2" align="center" bgcolor="<%=value_c%>">
		<input type="submit" value="회원가입"  >
		<input type="reset" value="다시 쓰기">
		
		<input type="button"  value="가입 안함" onclick=window.location="Main.jsp">
		
		
		</td>
		</tr>
		

	
	</table>
	
	</form>

</body>
</html>