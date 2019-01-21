<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.*"
    %>
    
    <%@ include file="../view/color.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
request.setCharacterEncoding("utf-8");
%>
<html>
<body>

<table bgcolor="<%=title_c%>">
<tr>
<td height="39" align="center"><font size="+2">
<b>회원정보가 수정 되었습니다.</b>
</font></td>
</tr>

<tr>
<td bgcolor="<%=value_c%>" align="center">
<form>
<input type="button"  value="메인으로" onclick="window.location='../member/main.do'">  
</form>

5초후 메인으로 이동합니다.
<meta http-equiv="Refresh" content="3;url=../member/main.do">
</td>
</tr>

</table>


</body>

</html>
