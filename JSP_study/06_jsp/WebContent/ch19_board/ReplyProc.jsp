<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="boardre.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
request.setCharacterEncoding("utf-8");
%>


<jsp:useBean id="bb" class="boardre.BoardBean">
	<jsp:setProperty name="bb" property="*"/>
</jsp:useBean>

<jsp:useBean id="mgr" class="boardre.BoardMgr"/>
<%

//List.jsp에서 보내준 값을 받기
int num=Integer.parseInt(request.getParameter("num"));
int nowPage=Integer.parseInt(request.getParameter("page"));

BoardBean bean=mgr.getBoard(num);

int pos=bean.getPos();
int depth=bean.getDepth();

bb.setPos(pos);
bb.setDepth(depth);

mgr.replyPos(bb);
mgr.replyBoard(bb);


response.sendRedirect("List.jsp?page="+nowPage);

%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>