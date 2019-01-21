<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"
	import="member.*"
    %>
    
    <%
request.setCharacterEncoding("utf-8");
   LoginDao dao= LoginDao.getInstance();
   String check=request.getParameter("check");
   String area3=request.getParameter("area3");
    Vector <ZipcodeDto>vec=dao.zipcodeRead(area3);
    int totalList=vec.size();
     %>

<html>
<head>
<script type="text/javascript">
function dongCk(){
	if (document.zipForm.area3.value=='') {
		alert("동이름을 입력하시오.");
		document.zipForm.area3.focus();
	return false;
	}
	document.zipForm.submit();
}//end ck

function sendAddress(zipcode, area1, area2, area3, area4){
	var addrAll=area1+" "+area2+" "+area3+" "+area4;
	opener.document.userForm.zipcode.value=zipcode;
	opener.document.userForm.addr.value=addrAll;
	self.close();
	
}//self end

</script>

</head>

<body bgcolor="#ffffcc">
<form name="zipForm" method="post" action="ZipCheck.jsp">
<table>
<tr>
<td><br>
동이름 입력: <input type="text" name="area3">
<input type="button" value="검색" onClick="dongCk()">
<input type="hidden" name="check" value="n">
</td></tr>
</table>
</form>

<table>
<%
if(check.equals("n")){
	if(vec.isEmpty()){
		out.println("<tr><td align=center><br>검색된 결과가 없습니다.</td></tr>");
	}else{//검색된 주소 있을때
%>
		<tr>
		<td align=center>
		<font color=blue> <br>
		* 아래 우편번호를 클릭하면 주소가 자동으로 입력됩니다.
		</font>
</td>
</tr>

<%
for(int i=0; i<totalList; i++){
	ZipcodeDto dto=(ZipcodeDto)vec.get(i);
	
	String zipcode1=dto.getZipcode();
	String area11=dto.getArea1().trim();
	String area22=dto.getArea2().trim();
	String area33=dto.getArea3().trim();
	String area44=dto.getArea4().trim();
%>
<tr>
<td>
<a href="javascript:sendAddress('<%=zipcode1 %>' , '<%=area11 %>', '<%=area22 %>' , '<%=area33 %>' ,'<%=area44 %>')">
<%=zipcode1 %>&nbsp;<%=area11 %>&nbsp;<%=area22 %>&nbsp;<%=area33 %>&nbsp;<%=area44 %>
</a>
</td>
</tr>

<%
}//for end
%>

<%
	}//else
}//out if end
%>

<tr>
<td align=center><br>
<a href="javascript:this.close()">닫기</a>
</td>
</tr>

</table>

</body>

</html>