<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="euc-kr"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

String type= request.getParameter("type");

if(type != null){
	if(type.equalsIgnoreCase("excel")){
		
response.setContentType("application/vnd.ms-excel");
response.setHeader("Content-Disposition","attachment;filename=mm.xls");
response.setHeader("Content-Description", "JSP Generated Data");
}else if(type.equalsIgnoreCase("word")){

response.setContentType("application/msword ");
response.setHeader("Content-Disposition","attachment;filename=mm.doc");
response.setHeader("Content-Description", "JSP Generated Data");
}else{
	response.setContentType("text/html;charset=utf-8");
	
}//inner end
}//class end

%>
<table border="1">

<tr>
<th>이름</th><th>급여</th><th>주소</th>
</tr>

<tr>
<td>김대진</td><td>500</td><td>서울</td>
</tr>
<tr>
<td>김대진</td><td>500</td><td>서울</td>
</tr><tr>
<td>김대진</td><td>500</td><td>서울</td>
</tr>

</table>

</body>
</html>