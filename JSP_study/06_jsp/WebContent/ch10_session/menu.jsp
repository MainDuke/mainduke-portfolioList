<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

menu.jsp<br>

<h2>구매 CD를 고르세요.</h2>

<form method="post" >
	
	<select name="item">
	<option value="백아연CD" selected="selected">백아연CD</option>
	<option value="가수1CD" >가수1CD</option>
	<option value="가수2CD" >가수2CD</option>
	
	<option value="가수3CD" >가수3CD</option>
	</select>
	<input type="hidden" name="step" value="add"><!-- 장바구니에 추가 -->
	<input type="submit" value="선택">

</form>