<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.*"
    %>
    
    <%@ include file="../view/color.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
request.setCharacterEncoding("utf-8");
%>

<jsp:useBean id="dto" class="member.LoginDto">
<jsp:setProperty name="dto" property="*"/>
</jsp:useBean>

<html>
<body>
<%

String id = (String)session.getAttribute("memId");
dto.setId(id);

LoginDao dao=LoginDao.getInstance();
dao.updateMember(dto);

%>
<table bgcolor="<%=title_c%>">
<tr>
<td height="39" align="center"><font size="+2">
<b>회원정보가 수정 되었습니다.</b>
</font></td>
</tr>

<tr>
<td bgcolor="<%=value_c%>" align="center">
<form>
<input type="button"  value="메인으로" onclick="window.location='Main.jsp'">  
</form>

5초후 메인으로 이동합니다.
<meta http-equiv="Refreash" content="3;url=Main.jsp">
</td>
</tr>

</table>


</body>

</html>
