
package ch19.controller;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.util.*; //Map, HashMap

import ch19.action.*;

//컨트롤러 : servlet으로 작성한다
public class ControllerAction extends HttpServlet {
	
	private Map commandMap = new HashMap(); //key, value(객체)
	
	//init() : 초기화 작업. 생성자랑 같은 기능. 
	public void init(ServletConfig config) throws ServletException{
		//System.out.println("컨트롤러1");
		//이게 떠야 컨트롤러를 거쳐간걸 확인할 수 있당
		
		String path=config.getServletContext().getRealPath("/"); //실제경로.real path
		//실제경로를 쓰는 건 실제 web-inf 아래의 property를 얻기 위해서.
		//C:\00_asdf\01_work\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\13_MVC\WEB-INF
		
		
		//web.xml에서 propertyConfig에 해당하는 init-param 값을 읽어옴
		String props = path+config.getInitParameter("propertyConfig");
		//web.xml에 있는 param-value를 읽어오기 위해 param-name을 가져온것. ㄴ> =param-name
		//System.out.println("컨트롤러2");
		
		//System.out.println(path);
		//C:\00_asdf\01_work\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\13_MVC\
		//System.out.println(props);
		//C:\00_asdf\01_work\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\13_MVC\/WEB-INF/CommandPro.properties
		
		Properties pr=new Properties(); //프로퍼티로 가져오려고. 객체생성
		
		FileInputStream f=null;
		//filepath로 지정한 파일에 대한 입력 스트림을 생성.
		
		try{
			//System.out.println("컨트롤러3");
			f=new FileInputStream(props);
			//System.out.println("컨트롤러4");
			pr.load(f);// 	/ch19/list.do=ch19.action.ListAction
			//pr에다가 그런식으로 다 만들어놓음(???
		}catch(IOException e){
			throw new ServletException(e);
		}finally{
			try{
				if(f!=null){
					f.close();
				}//if
			}catch(Exception ex){}
		}//final
		
		//Iterator는 Collection 자료를 받아서 처리할 수 있다.
		Iterator keyIter=pr.keySet().iterator(); //프로퍼티 키를 다 가져옴/이터레이터로 키 변환.
		
		while(keyIter.hasNext()){
			String command=(String)keyIter.next(); //	/ch19/list.do <- 이 값을 얻어오는것
			String className=pr.getProperty(command); //	이 위의 값으로 그 뒤의 값인 /ch19.action.ListAction <- 얘네를 얻어옴. 
			
			try{
				Class commandClass=Class.forName(className); // /ch19.action.ListAction <-얘를 클래스로 변환함.
				Object commandInstance=commandClass.newInstance(); //그 클래스를 객체로 만듦.
				commandMap.put(command, commandInstance);
				//커맨드 부분에는 /ch19/list.do 이게 들어가고
				//뒤에는 객체가 들어감. 객체로 만든 저걸 넣는거인가봐.
				//프로퍼티 안에 있는걸 다 집어넣음. while문으로 도니까.
				
			}catch(Exception ex2){
				throw new ServletException(ex2);
			}//catch
		}//while
		
	}//init() end ---------------------------
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		requestPro(request, response); //메소드 호출 
	}//doGet
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		requestPro(request, response); //메소드 호출 (어떤 방식이던 메소드를 호출하게 만듦)
	}//doPost
	
	
	//클라이언트 요청을 처리하는 메소드
	private void requestPro(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{
		
		String view=null; //뷰 이름을 넣을 변수 (뷰는 jsp 파일)
		CommandAction commandAction=null; //인터페이스 (액션 사용하려고.)
		//상위 클래스 변수로 하위 객체 처리.
		
		try{
			String command=request.getRequestURI(); // 	/프로젝트명/ch19/list.do
			
			//url : 전체주소 
			//uri : 컨텍스트 이름(=프로젝트 이름)/중간이름/list.jsp
			//(지금은 jsp가 아니고 list.do)
			
			if(command.indexOf(request.getContextPath())==0){
			//request.getContextPath()는 /13_MVC <- 얘만.
			//if("/프로젝트명/ch19/list.do".indexOf("/13_MVC"){} 이 소리임. 이걸 다 찾았냐. 
			//컨텍스트까지 읽어왔을때 그게 0인가. 시작점이 0인가 = 그걸 찾았냐.
				
				//"/프로젝트명/ch19/list.do" <- 이게 커멘트. 
				// "/프로젝트명/ch19/list.do".substring("/13_MVC") 
				//substring : 어떤 위치부터 끝까지 문자열을 발췌
				//그 결과가 뭐냐 = /ch19/list.do 이걸 뽑아내려고. 
				command=command.substring(request.getContextPath().length());
			}//if
			
			//HashMap에서 객체를 꺼내서 CommandAction 타입으로 형변환
			commandAction=(CommandAction)commandMap.get(command);
			view=commandAction.requestPro(request, response); //액션 메소드 호출
			//객체.메소드 
			//리스트액션에 가보면 리턴값이 list.jsp인게 그게 저 view에 해당하는 것. 
		}catch(Throwable ex3){
			throw new ServletException(ex3);
		}//catch
		
		RequestDispatcher rd=request.getRequestDispatcher(view);
		rd.forward(request, response); //그러고나면 view(jsp)로 포워딩
		
	}//requestPro() end
			
}//class end
