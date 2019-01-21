<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ include file="../view/color.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
request.setCharacterEncoding("utf-8");
System.out.println(request.getParameter("id"));
String id=request.getParameter("id");

%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function setId(){
	//opener : 상위(부모) 창을 지칭, id자동 입력
opener.document.userForm.id.value="<%=id%>";
opener.document.userForm.flag.value="true";
self.close(); //자신의 창 닫기.
}//end

</script>

</head>
<body bgcolor="<%=bodyback_c%>">


<c:if test="${check==1}">

<table width="270" border="0" cellpadding="5" cellspacing="0">
<tr bgcolor="<%=title_c%>">
<td height="39">
${id} 는 사용중인 ID 입니다.
</td>
</tr>
<form name="checkForm" method="post" action="confirmId.do">
<table width="270" border="0" cellpadding="5" cellspacing="0">
		<tr>
		<td bgcolor="<%=value_c %>" align="center">
		다른 아이디를 선택 하시오. <p>
		<input type="text" name="id" size="12">
		<input type="submit" value="ID중복 확인">
		</td>
		</tr>
</table>
</form>
</table>
</c:if>

<c:if test="${check<0 }">  
	<table width="270" border="0" cellpadding="5" cellspacing="0">
	<tr bgcolor="<%= title_c%>">
	<td align="center">
	<p>
	<%=id %>는 사용가능한 id 입니다.</p>
	<input type="button" value="닫기" onclick="setId()">
	
	</td>
	</tr>
	
	</table>
</c:if>


</body>
</html>

















