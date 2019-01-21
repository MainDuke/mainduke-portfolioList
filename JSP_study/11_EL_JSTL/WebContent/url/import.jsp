<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:import url="http://localhost:9001/11_EL_JSTL/url/header.jsp" var="hh">
	<c:param name="id" value="park"/>
</c:import> 

<c:import url="url.jsp" var="url1"/>
<c:import url="http://www.daum.net" var="daum"/>
<c:import url="footer.jsp" var="foot"/>

<%--사용시 주의할점 import 태그를 사용한다고 햇, 읽어온 내용이 곧바로 import 태그 위치에 
url 속성에 명시된 값으로 포함되는 것은 아니다. 
url 속성에 명시된 서버에 접속해서 읽어온 데이터는 
var 속성에 명시한 변수값으로 호출해야한다.
--%>

<html>
<body>
<table border="3">

<tr>
<td>
header.jsp<br>
${hh}
</td>
</tr>


<tr>
<td>
<table>
url.jsp<br>
${daum }
</td>
</tr>
</table>

<tr>
<td>
footer.jsp<br>
${foot}
</td>
</tr>




</table>
</body>

</html>

    
<%--
1. 
<c:redirect url="">
	<c:param name="id" value="park"/>
</c:redirect>

2.
<c:url var="a1" value="aa.jsp" scope="session">
	<c:param name="id" value="kim"/>
</c:url>

var= 생성된 URL이 저장될 변수명
value = 생성될 URL
scope = 변수에 저장될 범위 지정

#value 속성에 올수 있는 값 (3가지)
완전 URL : http://ip.port/컨텍스트이름/중간이름/a.jsp
웹 어플리케이션 내에서 절대  경로 : /bb.jsp
현재 경로에 대한 상대 경로. ../member/aa.jsp

3. import 
<c:import url="" charEncoding="" var="" scope="">
<c:param name="" value=""/>
</c:import>

url 읽어올 url
charEncoding 읽어올 데이터 케릭터 셋
var 변수 이름
scope 적용범위
param 파라미터 값


--%>