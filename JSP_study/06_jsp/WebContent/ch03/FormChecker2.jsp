<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
 
    %>
<%@ page
   import="check.FormChecker"
 %>
<%!//선언부
public static void printErr(JspWriter out, String msg) throws Exception{
	
	out.println("<script>");
	out.println("alert('"+msg+"')");
	out.println("history.back()"); //history.back()==history.go(-1)
	out.println("</script>");
	
}//method end

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String name=request.getParameter("name");
String id=request.getParameter("id");
String email=request.getParameter("email");
String card=request.getParameter("card");
String ssn1=request.getParameter("ssn1");
String ssn2=request.getParameter("ssn2");
String p1=request.getParameter("p1");
String p2=request.getParameter("p2");

if (FormChecker.isNull(name)) {
	printErr(out, "이름을 입력하시오.");
	return;
	}
if (!FormChecker.isID(id)) {
	printErr(out, "id을 입력하시오.");
	return;
	}
if (!FormChecker.isEmail(email)) {
	printErr(out, "email이 올바르지 않습니다.");
	return;
	}

if (!FormChecker.isCardNumber(card)) {
	printErr(out, "카드번호가 올바르지 않습니다.");
	return;
	}

if (!FormChecker.isSSN(ssn1, ssn2)) {
	printErr(out, "주민번호가 올바르지 않습니다.");
	return;
	}

if (!FormChecker.isSame(p1, p2)) {
	printErr(out, "암호가 일치하지 않습니다.");
	return;
	}

StringBuffer sb= new StringBuffer(ssn1);
sb.append("-");
sb.append(ssn2);
sb.replace(0, 6, "######");
sb.replace(7, 14, "#######");

p1=p1.replace(p1, "**");
%>

<list>
<li>이름 : <%=name %></li>
<li>ID : <%=id %></li>
<li>EMAIL : <%=email %></li>
<li>카드번호 : <%=card %></li>
<li>주민번호 : <%=sb %></li>
<li>암호 : <%=p1 %></li>
</list>

</body>
</html>