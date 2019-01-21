<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <h2>제목</h2>
    
    <table border="1">
    <tr>
    <td>JSP버전</td>
    <td><%=application.getMajorVersion() %></td> <%--실제 경로 --%>
    </tr>
    <tr>
    <td>JSP버전 마이너</td>
    <td><%=application.getMinorVersion() %></td>
     </tr>
     <tr>
     <td>JSP 컨테이너 정보</td>
    <td><%=application.getServerInfo() %></td> <%--mime 타입 text/html 이 대표적임 --%>
    </tr>
    
    <tr>
     <td>mime 타입</td>
    <td><%=application.getMimeType("aa.html") %></td> <%--mime 타입 text/html 이 대표적임 --%>
    </tr>
    
     <tr>
      <td>리얼패스</td>
    <td><%=application.getRealPath("/")%></td> <%--리얼 패스 --%>
    </tr>
        
    <tr>
    <td>log 정보</td>
    <td>
    <%
    application.log("2015년 9월 23일 수당받아서 술먹고 놀러가는사람~~");
    %>
    </td>
    </tr>
    
    
    </table>