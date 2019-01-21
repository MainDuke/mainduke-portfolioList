
package ch19.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import ch19.action.*;

//컨트롤러
//컨트롤러는 서블릿으로 만든다
public class ControllerTemplate extends HttpServlet{

	private Map map = new HashMap(); //key, value(객체)
	
	public void init(ServletConfig config) throws ServletException {
		
		String path=config.getServletContext().getRealPath("/");
		String props=path+config.getInitParameter("proFile"); //web.xml에서
		Properties pr = new Properties(); //key(name), value
		FileInputStream f = null;
		
		try{
			f=new FileInputStream(props);
			pr.load(f);
			
		}catch(Exception ex){
			System.out.println("init() 예외: "+ex);
		}finally{
			if(f != null) try{f.close();}catch(IOException ex){}
		}//final
		
		Iterator keyIter = pr.keySet().iterator();
		while( keyIter.hasNext() ){
			String command = (String)keyIter.next(); //key
			String className = pr.getProperty(command); //value
			
			try{
				Class commandClass = Class.forName(className); //클래스로 만든다
				Object commandInstance = commandClass.newInstance(); //객체로 만든다
				map.put(command, commandInstance); //key, value(객체)
				
			}catch(Exception e){
				System.out.println("init() 예외: "+e);
			}//catch
		}//while
		
	}//init() end
	
	
	//get방식의 서비스 메소드
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		reqPro(request, response);
	}

	//post방식의 서비스 메소드
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		reqPro(request, response);
	}

	//사용자의 요청을 분석해서 해당 작업을 처리
	private void reqPro(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		String view = null;
		CommandAction com = null;
		
		try{
			String command = request.getRequestURI(); //uri
			if(command.indexOf(request.getContextPath())==0){
				command = command.substring(request.getContextPath().length());
				//command => /member/main.do
			}//if
			
			com = (CommandAction)map.get(command); //해당 action 객체를 얻는다
			view = com.requestPro(request, response); //action의 메소드 호출
			
		}catch(Throwable ex){System.out.println("reqPro() 예외: "+ex);}
		//throwable이 exception보다 상위 exception(?)인거라서 저거 써줘야 에러 안남.
		
		request.setAttribute("CONTENT", view);
		request.setAttribute("view", view); //key, value
		
	
		if(view.equals("/member/confirmId.jsp")){
		RequestDispatcher rd = request.getRequestDispatcher("/member/confirmId.jsp");
		rd.forward(request, response); //뷰로 포워딩
		}else{
		RequestDispatcher rd = request.getRequestDispatcher("/template/template.jsp");
		rd.forward(request, response); //뷰로 포워딩
		}
		
	}//reqPro() end
	
}//class end


