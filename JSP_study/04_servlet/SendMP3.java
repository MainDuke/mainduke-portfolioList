

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
	res.setContentType("audio/mpeg"); //MP3 파일을 위한 MINE 설정
	ServletOutputStream out=res.getOutputStream();
	//MP3 파일도 바이너리 파일이기 때문에 ServletOutputStream 클래스를 이용한다.
	//MP3 파일도 
	try {
		ServletContext sc = getServletConfig().getServletContext();
		String str=sc.getRealPath("/");
		System.out.println("str : "+str);
		
		String file=sc.getRealPath("HA.mp3");
		System.out.println("file : "+file);
		
		
		BufferedInputStream in=new BufferedInputStream(new FileInputStream(file));
		//BufferedInputStream in=new BufferedInputStream(new FileInputStream("Heart Attack.mp3"));
		
		int n;
		
		while ((n=in.read(buffer, 0, 1024)) != -1 ){ //파일 끝이 아닌동안 반복
			out.write(buffer, 0, n); //파일에서 읽어온 내용을 출력한다.
			out.flush();
		}
		out.close();
		in.close();
		
	} catch (Exception e) {}
	
	
	}//service end
	//실행하면 MP3 파일이 넘어오기는 하는데, WINAMP 플러그인이 깔려있어야..... 음악을 들을수 있다.
	//WINAMP를 자동으로 실행 시키면서 음악을 재생시키는 방식이다.


}//class end
