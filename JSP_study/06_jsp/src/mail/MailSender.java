package mail;
import java.io.*;

import com.oreilly.servlet.*;

import javax.servlet.http.*;

import com.oreilly.servlet.multipart.*;



public class MailSender {
	private String from;	
	private String to;
	private String subject;
	private String content;
	
		//필요하면 기타 메서드도 쓸수 있따.
	public String send(){
		String reply=""; //변수
	
		try{
			MailMessage msg= new MailMessage("smtp.nate.com");
			msg.from(from);
			msg.to(to);
			msg.setSubject(subject); 
			PrintStream out= msg.getPrintStream(); //출력용 스트림 생성
			
			out.println(content);
			msg.sendAndClose();
			reply="메일 전송 성공";
			
		}catch(Exception ex){
			reply="메일 전송 실패";
		}
	return reply;
	}//send

	public void setFrom(String from) {
		this.from = from;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
}//class end
