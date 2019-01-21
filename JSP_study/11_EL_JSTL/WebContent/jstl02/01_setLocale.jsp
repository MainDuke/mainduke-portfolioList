<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
    <%--01_setLocale--%>
    
    <%-- 국제화 태그들이 사용한 로케일을 지정한다.
    로케일이란 : 로케일 지정 태그는 2가지가 있다. 
    setLocale : 국제화 태그들이 사용한 로케일을 시정한다.
    requestEncoding : 요청 파라미터의 케릭터 인코딩을 지정한다.
    --%>
    
    <h2>setLocale</h2>
    <h2>언어_나라</h2>
    <h2>ko_kr</h2>
    <h2>ko_KR.eucKR</h2>
    
    <pre>
    default locale:<%=response.getLocale() %><%--현재 컴퓨터에 설정된 나라와 언어를 표현한다. --%>
    디폴드 : 현재 컴퓨터에 국가별 설정에된 언어-나라가 된다.
    제어판 -- 국가 및 언어 가서 확인 할수 있다.
    </pre>
    
    
    <br>
    영문 로케일 지정
    <fmt:setLocale value="en"/>
    locale:<%=response.getLocale() %>
    
    <br>
    일어 로케일 지정
    <fmt:setLocale value="jo"/>
    locale:<%=response.getLocale() %>
    
    <br>
    한국어 로케일 지정
    <fmt:setLocale value="ko"/>
    locale:<%=response.getLocale() %>
    
    
    
    