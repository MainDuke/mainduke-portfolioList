<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
    <%@ include file="../view/color.jsp" %>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	
<script type="text/javascript">

function checkIt(){
	
	if($("#id").val()==""){
		alert("아이디를 입력하시오.");
		$('#id').val('').focus();
		return false;
	}//if end
	
	if($("#passwd").val()==""){
		alert("암호를 입력하시오.");
		$('#passwd').val('').focus();
		return false;
	}//if end
	
	if($("#passwd2").val()==""){
		alert("passwd 확인을 입력하시오.");
		$('#passwd2').val('').focus();
		return false;
	}//if end
	
	
	if($("#name").val()==""){
		alert("이름을 입력하시오.");
		$('#name').val('').focus();
		return false;
	}//if end
	
	if($("#jumin1").val()==""){
		alert("주민번호 앞번호들을 입력하시오.");
		$('#jumin1').val('').focus();
		return false;
	}//if end
	
	if($("#jumin2").val()==""){
		alert("주민번호 뒷 번호들을 입력하시오.");
		$('#jumin2').val('').focus();
		return false;
	}//if end
	
	if($("#email").val()==""){
		alert("이메일을 입력하시오.");
		$('#email').val('').focus();
		return false;
	}//if end
	
	if($("#zipcode").val()==""){
		alert("우편번호를 입력하시오.");
		$('#zipcode').val('').focus();
		return false;
	}//if end
	
	if($("#addr").val()==""){
		alert("주소를 입력하시오.");
		$('#addr').val('').focus();
		return false;
	}//if end
	
	if($("#job").val()==""){
		alert("직업을 입력하시오.");
		$('#job').val('').focus();
		return false;
	}//if end
	
	if($("#blog").val()==""){
		alert("blog을 입력하시오.");
		$('#blog').val('').focus();
		return false;
	}//if end
	
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
 
	<form method="post" name="userForm" action="inputPro.jsp" onsubmit="return checkIt()">
	
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
		<input id="id" type="text" name="id" size="10" onblur="idCheck(this.form)">
		<input type="button" value="중복체크" onClick="openConfirmID(this.form)">
	</td>
	</tr>	
	
	
	<tr>
	<td width="200">비밀번호</td>
	<td width="400">
		<input id="passwd" type="password" name="passwd" size="15">
	</td>
	</tr>	
		
		<tr>
		<td width="200">비밀번호 확인</td>
		<td width="400">
		<input id="passwd2" type="password" name="passwd2" size="15">
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
		<input id="name" type="text" name="name" size="15">
		</td>
		</tr>
		
		<tr>
		<td>주민 등록 번호</td>
		<td>
		<input id="jumin1" type="text" name="jumin1" size="6" onkeyup="if(this.value.length==6) userForm.jumin2.focus();">-
		<input id="jumin2" type="text" name="jumin2" size="7" onkeyup="if(this.value.length==7) userForm.email.focus();">
		</td>
		</tr>
	
		<tr>
		<td >Email</td>
		<td >
		<input id="email" type="text" name="email" size="40">
		</td>
		</tr>
		
		<tr>
		<td >우편번호</td>
		<td >
		<input id="zipcode" type="text" name="zipcode" size="7">
		<input type="button"  value="우편번호 찾기" onclick="zipCheck()">
		</td>
		</tr>
		
		<tr>
		<td >주소</td>
		<td >
		<input id="addr" type="text" name="addr" size="70">
		</td>
		</tr>
		
		<tr>
		<td >직업</td>
		<td >
		<select name="job" id="job" >
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
		<input id="blog" type="text" name="blog" size="60">
		</td>
		</tr>
		
		<tr>
		<td colspan="2" align="center" bgcolor="<%=value_c%>">
		<input type="submit" value="회원가입" >
		<input type="reset" value="다시 쓰기">
		
		<input type="button"  value="가입 안함" onclick=window.location="Main.jsp">
		
		
		</td>
		</tr>
		

	
	</table>
	
	</form>

</body>
</html>