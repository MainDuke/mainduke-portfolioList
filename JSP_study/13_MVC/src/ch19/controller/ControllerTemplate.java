
package ch19.controller;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import ch19.action.*;

//��Ʈ�ѷ�
//��Ʈ�ѷ��� �������� �����
public class ControllerTemplate extends HttpServlet{

	private Map map = new HashMap(); //key, value(��ü)
	
	public void init(ServletConfig config) throws ServletException {
		
		String path=config.getServletContext().getRealPath("/");
		String props=path+config.getInitParameter("proFile"); //web.xml����
		Properties pr = new Properties(); //key(name), value
		FileInputStream f = null;
		
		try{
			f=new FileInputStream(props);
			pr.load(f);
			
		}catch(Exception ex){
			System.out.println("init() ����: "+ex);
		}finally{
			if(f != null) try{f.close();}catch(IOException ex){}
		}//final
		
		Iterator keyIter = pr.keySet().iterator();
		while( keyIter.hasNext() ){
			String command = (String)keyIter.next(); //key
			String className = pr.getProperty(command); //value
			
			try{
				Class commandClass = Class.forName(className); //Ŭ������ �����
				Object commandInstance = commandClass.newInstance(); //��ü�� �����
				map.put(command, commandInstance); //key, value(��ü)
				
			}catch(Exception e){
				System.out.println("init() ����: "+e);
			}//catch
		}//while
		
	}//init() end
	
	
	//get����� ���� �޼ҵ�
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		reqPro(request, response);
	}

	//post����� ���� �޼ҵ�
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		reqPro(request, response);
	}

	//������� ��û�� �м��ؼ� �ش� �۾��� ó��
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
			
			com = (CommandAction)map.get(command); //�ش� action ��ü�� ��´�
			view = com.requestPro(request, response); //action�� �޼ҵ� ȣ��
			
		}catch(Throwable ex){System.out.println("reqPro() ����: "+ex);}
		//throwable�� exception���� ���� exception(?)�ΰŶ� ���� ����� ���� �ȳ�.
		
		request.setAttribute("CONTENT", view);
		request.setAttribute("view", view); //key, value
		
	
		if(view.equals("/member/confirmId.jsp")){
		RequestDispatcher rd = request.getRequestDispatcher("/member/confirmId.jsp");
		rd.forward(request, response); //��� ������
		}else{
		RequestDispatcher rd = request.getRequestDispatcher("/template/template.jsp");
		rd.forward(request, response); //��� ������
		}
		
	}//reqPro() end
	
}//class end


