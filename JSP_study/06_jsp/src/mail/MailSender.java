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
	
		//�ʿ��ϸ� ��Ÿ �޼��嵵 ���� �ֵ�.
	public String send(){
		String reply=""; //����
	
		try{
			MailMessage msg= new MailMessage("smtp.nate.com");
			msg.from(from);
			msg.to(to);
			msg.setSubject(subject); 
			PrintStream out= msg.getPrintStream(); //��¿� ��Ʈ�� ����
			
			out.println(content);
			msg.sendAndClose();
			reply="���� ���� ����";
			
		}catch(Exception ex){
			reply="���� ���� ����";
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
