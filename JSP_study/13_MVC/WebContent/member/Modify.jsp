<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/view/color.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link href="style.css" rel="stylesheet" type="text/css">
	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function modifyTo(name){
	//alert(name);
	if(name=='modify'){
	document.ModifyMenu.action="../member/modifyForm.do";
	document.ModifyMenu.submit();
	}else if(name == 'delete'){
		document.ModifyMenu.action="../member/deleteForm.do";
		document.ModifyMenu.submit();
			
		
	}
	


}

</script>

</head>
<body bgcolor="${bodyback_c }">

<form method="post" name="ModifyMenu">

<input type="hidden" name="id" value="${sessionScope.memId }">
<input type="button" name="modify" value="정보수정" onclick="modifyTo(this.name)">&nbsp;&nbsp;
<input type="button" name="delete" value="탈퇴" onclick="modifyTo(this.name)">

</form>
</body>
</html>