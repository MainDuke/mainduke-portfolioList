<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script type="text/JavaScript" src="http://code.jquery.com/jquery-1.7.min.js"></script>
		
	<!-- jQuery+Ajax 로 id 중복체크 --> 
	<!-- 아래 2개는 주소 자동 입력 -->
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script src="//cdn.poesis.kr/post/popup.min.js"></script>
	</head>
	
	<body>
	<h2>회원정보 수정</h2>
	
	<form method="post" action="editPro.do">
	<!-- 액션은 컨트롤러에 있는 주소로 -->
	
	<table>
	<tr>
		<td>ID</td>
		<td><input type="text" name="id" id="id" size="20" value="${memberDto.id }" readonly="readonly">
		</td>
	</tr>

	<tr>
		<td>비밀번호</td>
		<td><input type="text" name="passwd" id="passwd" size="20"></td>
	</tr>

	<tr>
		<td>이름</td>
		<td><input type="text" name="name" id="name" size="20" value="${memberDto.name }"></td>
	</tr>

	<tr>
		<td>주민등록번호</td>
		<td><input type="text" name="jumin1" id="jumin1" size="6" value="${memberDto.jumin1 }">-
		<input type="text" name="jumin2" id="jumin2" size="7" value="${memberDto.jumin2 }"></td>
	</tr>

	<tr>
		<td>email</td>
		<td><input type="text" name="email" id="email" size="30"  value="${memberDto.email }"></td>
	</tr>

	<tr>
		<td>우편번호</td>
		<td><input type="text" name="num1" id="num1" size="10" class="postcodify_postcode6_1" readonly="readonly">
		<input type="text" name="num2" id="num2" size="10" class="postcodify_postcode6_2" readonly="readonly">
		<button id="postcodify_search_button">우편번호 검색</button></td>
	</tr>

	<tr>
		<td>도로명주소</td>
		<td><input type="text" name="address" id="address" class="postcodify_address" size="50" readonly="readonly"></td>
	</tr>
	
	<tr>
		<td>상세주소</td>
		<td><input type="text" name="details" id="details" class="postcodify_details" size="50"></td>
	</tr>

	<tr>
		<td>직업</td>
		<td><select name="job">
			<option value="${memberDto.job }">${memberDto.job }</option>
			<option value="회사원">회사원</option>
			<option value="연구전문직">연구전문직</option>
			<option value="교수학생">교수학생</option>
			<option value="문화예술종사">문화예술종사</option>
			<option value="백수">백수</option>
		</select></td>
	</tr>

	<tr>
		<td>blog</td>
		<td><input type="text" name="blog" id="blog" size="40" value="${memberDto.blog }"></td>
	</tr>
	
	<tr>
		<td colspan="2" align="center"><input type="submit" value="수정">
		<input type="reset" value="리셋"></td>
	</tr>

	</table>
	
	</form>
	
	</body>
</html>