<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    %>
    
    <%--cart.jsp --%>
    
    <%request.setCharacterEncoding("utf-8"); %>

    <html>
    <body>
    <%@ include file="menu.jsp" %>
    
    <%
    String item=request.getParameter("item"); //menu.jsp, remove.jsp
    String step=request.getParameter("step");  //menu.jsp, remove.jsp
    
    Vector vec= null;
    if(item != null){//item이 선택된게 있으면!~
    	vec=(Vector)session.getAttribute("cart");
    
    	if(vec==null){
    		vec=new Vector();
    		vec.add(item);
    		session.setAttribute("cart", vec);
    	}else{
    		if(step.equals("add")){
    			vec.add(item);
    			
    		}else if(step.equals("remove")){
    			vec.remove(item);
    		}
    	}//inner else end
    	out.println("쇼핑 cart에 담긴 CD<br>");
    	for(int i=0; i<vec.size();i++){
    		out.println((i+1)+":"+(vec.get(i).toString()+"<br>"));
    	}%>
    	현재 cart에 모두 <%=vec.size() %>개가 담겨 있습니다.<br>
    	<%
    	if(vec.size()>0){
    		%>
    		<jsp:include page="remove.jsp" flush="true"/>
    	<%
    	}//if
    
    }//out if end
    
    %>
    
    </body>
    </html>