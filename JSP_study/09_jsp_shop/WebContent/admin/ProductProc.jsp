<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
    import="shopdb.*"
    
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% request.setCharacterEncoding("utf-8");
shopdb.ProductMgr proMgr=ProductMgr.getInstance();

%>

<jsp:useBean id="ordMgr" class="shopdb.OrderMgr"/>


<%

String flag=request.getParameter("flag"); //insert, update, delete
boolean result=false;
int iti=0;
if(flag.equals("insert")){
	result=proMgr.insertProduct(request);
	response.sendRedirect("ProductMgr.jsp");
	//out.println("insert 성공");		
}else if(flag.equals("update")){
	result=proMgr.updateProduct(request);
	response.sendRedirect("ProductMgr.jsp");
}else if(flag.equals("del")){
 Vector vec=ordMgr.getOrderList();
 if(vec.size()==0){
	 result=proMgr.deleteProduct(request, Integer.parseInt(request.getParameter("pro_no")));
 }else{
	 for(int i=0; i<vec.size();i++){
		 OrderBean order=(OrderBean)vec.get(i);
		 int pro_no=order.getPro_no();
		 if(pro_no == Integer.parseInt(request.getParameter("pro_no"))){
			 iti++;
		 }//if
	 }//for
	 
	 if(iti==0){//주문 상황이 아니면
		 result=proMgr.deleteProduct(request, Integer.parseInt(request.getParameter("pro_no")));
	 }else{
		 result=false;
	 }//else
	 
 }//else end
 response.sendRedirect("ProductMgr.jsp");
}else{
	response.sendRedirect("ProductMgr.jsp");
}

%>