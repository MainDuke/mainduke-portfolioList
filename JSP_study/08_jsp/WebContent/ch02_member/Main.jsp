<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    %>
    <%@ include file="../view/color.jsp" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
	    <script type="text/javascript">
		function focus(){
			document.inForm.id.focus();
		}   //end  
	    
		function checkIt(){
			//eval()함수
			//1. 인자로 받은 문자열을 수치화 한다.
			//문자열의 내용이 숫자라면 실제로 숫자로 바뀐다.
			//인자로 받은 문자열의 내용이, 자바스크립트가 인식할 수 있는
			//객체 형태라면, 문자열을 받아서 자바스크립트객체로 리턴한다.
			
			var userinput=eval("document.inForm");
			
			//not 연산으로 null 값 체크하기.
			if(!userinput.id.value){
				alert("id는 입력 하시오");
				return false;
			}//end
			
			if(userinput.passwd.value==''){
				alert("pwd는 입력 하시오.");
				inForm.passwd.focus();
				return false;
			}//end
		
			//데이터 유효성 체크펑션 끝
			return true;
		}//end function
	</script>
	</head>
	
    <body onload="focusIt()" bgcolor="<%=bodyback_c%>">
    <%
    try{
    	if(session.getAttribute("memId")==null){//로그인 안한 상태
    		%>
    	
		    	
		    	<form name="inForm" method="post" action="LoginPro.jsp" onsubmit="return checkIt()">
		    	<table width=500 cellpadding=0 cellspacing=0 align=center border="1">
		    	
		    	<tr>
		    	<td width="300" bgcolor="<%=bodyback_c %>" height="20">
		    	&nbsp;
		    	</td>
		    		    	
		    
		    	<td width="100" bgcolor="<%=title_c%>" align="right">
				아이디	    	
		    	</td>
		    	<td width="100" bgcolor="<%=value_c%>" >
		    	<input type="text" name="id" size="15">
		    	</td>
		    	</tr>
		    	
		    	<tr>
		    	<td rowspan="2" bgcolor="<%=bodyback_c%>" width="300">
		    	메인 입니다.
		    	</td>
		    	
		    	<td width="100" bgcolor="<%=title_c%>" align="right">
		    	패스워드
		    	</td>
		    	
		    	<td width="100" bgcolor="<%=value_c%>" >
		    			<input type="password" name="passwd" size=15>
		    	</td>
		    	</tr>
		    	
		    	<tr>
		    	<td colspan="2" bgcolor="<%=title_c%>" align="center">
		    		<input type="submit" value="로그인">
		    		<input type="reset" value="회원가입" onclick="javascript:location='inputForm.jsp'">
		    	</td>
		    	</tr>
		    	</table>
		    	</form>
    	
    
    <%
    		  	}else{//로그인 상태
    		  		%>
    		  		<table width=900 cellpadding=0 cellspacing=0 align=center border="1" height="90%">
    		  		<tr>
    		  		<td width="60%" height="10%" bgcolor="<%=bodyback_c%>">
    		  		반갑습니다.
    		  		</td>
    		  		<td width="40%"  colspan="2" bgcolor="<%=value_c%>">
    		  		<%
    		  		String memId=(String)session.getAttribute("memId");
    		  		%>
    		  		<%=session.getAttribute("memId") %>님의 방문을 환영합니다.<br>
    		  		<form method="post" action="Logout.jsp">
    		  		<input type="submit" value="로그아웃">
    		  		<input type="button" value="회원정보 변경" onclick="javascript:location='Modify.jsp'"> 
    		  		</form>
    		  		
    		  		</tr>
					<tr>
					<td colspan="2" height="70%" bgcolor="<%=bodyback_c%>" width="300">
					메인입니다.
					</td>
    		  		</table>

    		  		<%
    		  	}//else
    }catch(Exception ex){}
    %>
    	</body>		
    
    </html>