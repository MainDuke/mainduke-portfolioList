package emailupload;
import java.io.*;

import javax.servlet.http.*;

import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;


public class MailUpload {
	public String upload(HttpServletRequest request){
		String replay="";
		
		try{
			MultipartRequest m=new MultipartRequest(request, "c:\\_java\\aa\\", 2014*1024*5, "utf-8" , new DefaultFileRenamePolicy());
			
			String from=m.getParameter("from");
			String to=m.getParameter("to");
			String subject=m.getParameter("subject");
			String content=m.getParameter("content");
			/////
			subject = new String(subject.getBytes("utf-8"), "8859_1");
			content = new String(content.getBytes("utf-8"), "8859_1");
			/////
			MailMessage msg = new MailMessage("smtp.nate.com");
			
			msg.from(from);
			msg.to(to);
			msg.setSubject(subject);
			
			PrintStream out= msg.getPrintStream();
			
			out.println(content);			
			msg.sendAndClose();
			
			replay="메일 보내기, 파일 업로드 성공";
			
		}catch(Exception e1){
			replay="메일 보내기, 파일 업로드 실패";
			
		}
		return replay;
	}//upload end
	
}//class 
