<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    <%@ include file="jsp_header.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<h2>�α���</h2>
	<div align="center" class="body">
	<form:form modelAttribute="user" method="post" action="login.html">
	
	<!-- ��ü ���� �޼��� ��� -->
	<spring:hasBindErrors name="user">
		<font color="red">
			<c:forEach var="error" items="${errors.globalErrors }">
				<spring:message code="${error.code }"/>
			</c:forEach>
		</font>
	</spring:hasBindErrors>
	
	<table>
		<tr height="40px">
		<td>user Id</td>
		<td>
			<!-- path="userId"�� User ���� ���� (������Ƽ) �̴� -->
			<form:input path="userId" cssClass="userId"/>
			<font color="red"><!-- ���� �޼��� ��� -->
				<form:errors path="userId"></form:errors>
			</font>
			</td>
		</tr>
		
		<tr>
			<td>�н�����</td>
			<td>
			<!-- User���� ����(������Ƽ) �̴�-->
			<form:input path="password" cssClass="password"/>
			<font color="red"> <!--���� �޽��� ��� -->
			<form:errors path="password"></form:errors>
			</font>
			</td>
			
		</tr>
		
		<tr>
			<td align="center"><input type="submit" value="�α���"></td>
			<td align="center"><input type="reset" value="����"></td>
		</tr>
		
	
	</table>
	
	</form:form>
	</div>

</body>
</html>