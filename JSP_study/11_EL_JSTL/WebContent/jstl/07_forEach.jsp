<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--07_forEach.jsp--%>
<%--
배열 뿐만 아니라 List,Iterator,Enumeration,Map 에서도
begin, end 속성을 사용하여 읽어 올 수 있다

Iterator,Enumeration,Map의 경우 삽입한 순서와 읽어오는 순서가 일치하지 않을 수도 있다.
그래서 begin,end 속성을 좀처럼 사용하지 않는다. 
--%>

<c:set var="map" value="<%=new java.util.HashMap() %>"/>
<c:set target="${map }" property="name" value="강동원"/>
<c:set target="${map }" property="id" value="gang"/>
<c:set target="${map }" property="addr" value="서울시 서대문구"/> 

<c:forEach var="i" items="${map }">
	<li>${i.key } ==> ${i.value }
</c:forEach>

<%--
====================================================================
--%>
<%
//Dao 에서 넘어온 데이터 받는 다는 생각으로
java.util.HashMap map=new java.util.HashMap();
map.put("name", "홍길동");
map.put("id", "hong");
map.put("addr", "주소입니다.");
map.put("date", new java.util.Date());
%>

<c:set var="mm" value="<%=map %>"/>

<table>
<c:forEach var="m" items="${mm }">
	<tr>
	<td>${m.key }</td>
	<td>${m.value }</td>
	</tr>
</c:forEach>
</table>

<table>

	<tr>
	<td>이름2</td>
	<td>${mm.name }</td>
	</tr>

	<tr>
	<td>id2</td>
	<td>${mm.id}</td>
	</tr>

	<tr>
	<td>주소2</td>
	<td>${mm.addr}</td>
	</tr>
	
	<tr>
	<td>날짜2</td>
	<td>${mm.date}
	</tr>

</table>


