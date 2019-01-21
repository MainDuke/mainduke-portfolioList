<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    <%@ page import="com.oreilly.servlet.*" %>
    <%@ page import="com.oreilly.servlet.multipart.*" %>
    <%@ page import="java.util.*" %>
    <%@ page import="java.io.*" %>
    
    
    <%
    request.setCharacterEncoding("utf-8");
    %>
    
    
    
    <%
    
    
    String savePath="c:/_java/aa/";
	int sizeLimit=5 * 1024 * 1024;
    
    try{
			//MultipartRequest multi=new MultipartRequest(request, "c:\\_java\\aa\\");
			MultipartRequest multi=new MultipartRequest(request, savePath, sizeLimit, "utf-8" , new DefaultFileRenamePolicy());
			
			Enumeration formNames=multi.getFileNames();
			String formName=(String)formNames.nextElement();
			String fileName=multi.getFilesystemName(formName);
			
			if(fileName == null){
				out.print("파일 업로드 되지 않았음");
			}else{//파일 업로드 됬을때
				
				out.print("name : "+multi.getParameter("name") + "<br>");
				out.print("id : "+multi.getParameter("id") + "<br>");
				out.print("pwd : "+multi.getParameter("pwd") + "<br>");
			
				out.print("form안에 name : "+formName +"<br>");
				out.print("File Name : "+fileName);
				
				//input 태그 속성이 file 인것
				String fileName2 = multi.getFilesystemName("file1");
				String original = multi.getOriginalFileName("file1");
				File file=multi.getFile("file1");
				
				String type=multi.getContentType("file1");
				
				out.print("<br><br> 실제 파일 이름 : "+original+"<br>");
				out.print("저장된 파일 이름 : "+fileName2+"<br>");
				out.print("파일 타입 :"+type+"<br>");
				
			}//end
			
			
		}catch(Exception ex2){
			out.print("파일 업로드 실패 : "+ex2);
		}
     %>