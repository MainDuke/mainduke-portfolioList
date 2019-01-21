<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>

<h2>JSTL fmt 예제 formatNumeric</h2>

number(숫자 표시) : <fmt:formatNumber value="12345.678" type="number"/><br>

currency(통화기호) : 
<fmt:formatNumber value="12345.678" type="currency" currencySymbol="$"/>
<br>

percent(퍼센트) : <fmt:formatNumber value="12345.678" type="percent"/><br>

pettern : ".0": <fmt:formatNumber value="12345.678" pattern=".0"/><br>


<h2>날짜 시간</h2>



</body>
</html>