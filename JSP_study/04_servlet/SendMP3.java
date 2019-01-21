

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;




import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SendMP3")
public class SendMP3 extends HttpServlet {
	
public void service(HttpServletRequest req, HttpServletResponse res) throws IOException{
	
	byte[] buffer =new byte[1024];
	res.setContentType("audio/mpeg"); //MP3 ������ ���� MINE ����
	ServletOutputStream out=res.getOutputStream();
	//MP3 ���ϵ� ���̳ʸ� �����̱� ������ ServletOutputStream Ŭ������ �̿��Ѵ�.
	//MP3 ���ϵ� 
	try {
		ServletContext sc = getServletConfig().getServletContext();
		String str=sc.getRealPath("/");
		System.out.println("str : "+str);
		
		String file=sc.getRealPath("HA.mp3");
		System.out.println("file : "+file);
		
		
		BufferedInputStream in=new BufferedInputStream(new FileInputStream(file));
		//BufferedInputStream in=new BufferedInputStream(new FileInputStream("Heart Attack.mp3"));
		
		int n;
		
		while ((n=in.read(buffer, 0, 1024)) != -1 ){ //���� ���� �ƴѵ��� �ݺ�
			out.write(buffer, 0, n); //���Ͽ��� �о�� ������ ����Ѵ�.
			out.flush();
		}
		out.close();
		in.close();
		
	} catch (Exception e) {}
	
	
	}//service end
	//�����ϸ� MP3 ������ �Ѿ����� �ϴµ�, WINAMP �÷������� ����־��..... ������ ������ �ִ�.
	//WINAMP�� �ڵ����� ���� ��Ű�鼭 ������ �����Ű�� ����̴�.


}//class end
