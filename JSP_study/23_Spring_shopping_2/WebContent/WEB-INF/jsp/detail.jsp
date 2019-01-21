<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
    
  <%@ include file="/WEB-INF/jsp/jsp_header.jsp" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<div align="center" class="body">
		<h2>상품 상세 화면</h2>
		<table>
			<tr>
				<td><img src="img/${item.pictureUrl }" width=200 height="200" >
			
				<td align="center">
					<table>
					<tr height="50">
						<td width="80">상품명</td>
						<td width="160">${item.itemName }</td>
					</tr>
					
					<tr height="50">
						<td width="80">가격</td>
						<td width="160">${item.price }</td>
					</tr>
					
					<tr height="50">
						<td width="80">비고</td>
						<td width="160">${item.description }</td>
					</tr>
					
					<tr>
						<td colspan="2" align="center" width="240">
							<a href="index.html">목록으로 돌아가기</a>
							
						</td>
					</tr>
					
					</table>
				</td>
			</tr>
		
		</table>
	</div>


</body>
</html>