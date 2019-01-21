<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--02_test_set_HashMap.jsp--%>

<c:set var="map" value="<%=new java.util.HashMap() %>"/>
<c:set target="${map }" property="name" value="강동원"/> 
<c:set target="${map }" property="addr" value="서울 서대문구 천연동"/> 
<c:set target="${map }" property="tel" value="010-8888-8888"/>

<h1>변수값 출력</h1>
이름:${map.name }<br>
주소:${map.addr }<br>
전화:${map.tel }<br>
 
<h1>이전 방식의 HashMap 사용</h1>

<%
java.util.Map map2=new java.util.HashMap(); //Map<-- HashMap
map2.put("name","강동원");
map2.put("addr","서울 마포구");
map2.put("tel","02-441-4125");
%>
이름:<%=map2.get("name") %> <br>
주소:<%=map2.get("addr") %> <br>
전화:<%=map2.get("tel") %> <br>
<h1>DTO사용법</h1>
<%--
set태그를 사용하면 target 속성과 property 속성을 통해서
자바빈 프로퍼티값이나 Map의 키값을 지정 할 수 있다 

<c:set var="dto" value="<%=new board.BoardDto()%>"/>

<c:set target="${dto}" property="id" value="gang"/>
<c:set target="${dto}" property="pwd" value="123"/>
<c:set target="${dto}" property="name" value="강동원"/>

ID: ${dto.id}<br>
PWD : ${dto.pwd}<br>
Name: ${dto.name}<br>
--%>