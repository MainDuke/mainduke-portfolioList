<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.net.*"
    %>

    cookie_count.jsp <br>
    
    <html>
    <body>
    <h2>방문 횟수</h2>
    
    <%!
    int count=-1;
    %>
    <%
    if("GET".equals(request.getMethod())){
    	
    	Cookie cookies[]= request.getCookies(); //모든 쿠키를 얻는다.
    	String name=null; //지역 변수
    
    	if(cookies != null){
    		for(int i =0;i<cookies.length;i++){
    			if("name".equals(cookies[i].getName())){
    				//이름이 name인 쿠키값을 얻는다.
    				name=(String)cookies[i].getValue();
    				//URLDecoder.decode() 메서드를 이용해서 디코딩한다.
    				name=URLDecoder.decode(name, "utf-8");
    				
    			}else if("count".equals(cookies[i].getName())){
 					   				count=Integer.parseInt(cookies[i].getValue());
    			}//if
    		}//for
    		
    	}//out if
    	
    	if(name==null || count == -1){ //처음 방문일때
    		%>
    		<h2>이름을 등록해주세요.</h2>
			<form method=get >
			이름: <input type="text" name="name" ><br>
			<input type="submit" value="전송">
			
			</form>    	
				
    	<%}else{//2번째 이후 방문
    	count++;//방문 횟수 증가
    	%>
    	<%= name%>님 <%=count %>번째 방문을 감사 드립니다.
    	<%
    	Cookie nameCookie=new Cookie("name", URLEncoder.encode(name, "utf-8"));
    	nameCookie.setMaxAge(60*60*24*365); //유효기간
    	
    	Cookie countCookie=new Cookie("count",String.valueOf(count));
    	nameCookie.setMaxAge(60*60*24*365); //유효기간
    	
    	response.addCookie(nameCookie);
    	response.addCookie(countCookie);
    	
    	
    	}//if name end
    	
    }else { //post 방식이면
    	request.setCharacterEncoding("utf-8");
    	String name=request.getParameter("name");
    	
    	Cookie nameCookie=new Cookie("name", URLEncoder.encode(name, "utf-8"));
    	nameCookie.setMaxAge(60*60*24*365); //유효기간
    	
    	Cookie countCookie=new Cookie("count",String.valueOf(1));
    	nameCookie.setMaxAge(60*60*24*365); //유효기간
    	
    	    	response.addCookie(nameCookie);
    	response.addCookie(countCookie);
     %>
    	<%=name%>님 첫번째 방문을 감사합니다.
    	
    	<%
    }//first else end
    
    %>
    
    
    
    
    </body>
    
    </html>