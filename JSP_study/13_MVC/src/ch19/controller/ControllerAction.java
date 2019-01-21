
package ch19.controller;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;
import java.util.*; //Map, HashMap

import ch19.action.*;

//��Ʈ�ѷ� : servlet���� �ۼ��Ѵ�
public class ControllerAction extends HttpServlet {
	
	private Map commandMap = new HashMap(); //key, value(��ü)
	
	//init() : �ʱ�ȭ �۾�. �����ڶ� ���� ���. 
	public void init(ServletConfig config) throws ServletException{
		//System.out.println("��Ʈ�ѷ�1");
		//�̰� ���� ��Ʈ�ѷ��� ���İ��� Ȯ���� �� �ִ�
		
		String path=config.getServletContext().getRealPath("/"); //�������.real path
		//������θ� ���� �� ���� web-inf �Ʒ��� property�� ��� ���ؼ�.
		//C:\00_asdf\01_work\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\13_MVC\WEB-INF
		
		
		//web.xml���� propertyConfig�� �ش��ϴ� init-param ���� �о��
		String props = path+config.getInitParameter("propertyConfig");
		//web.xml�� �ִ� param-value�� �о���� ���� param-name�� �����°�. ��> =param-name
		//System.out.println("��Ʈ�ѷ�2");
		
		//System.out.println(path);
		//C:\00_asdf\01_work\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\13_MVC\
		//System.out.println(props);
		//C:\00_asdf\01_work\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\13_MVC\/WEB-INF/CommandPro.properties
		
		Properties pr=new Properties(); //������Ƽ�� ����������. ��ü����
		
		FileInputStream f=null;
		//filepath�� ������ ���Ͽ� ���� �Է� ��Ʈ���� ����.
		
		try{
			//System.out.println("��Ʈ�ѷ�3");
			f=new FileInputStream(props);
			//System.out.println("��Ʈ�ѷ�4");
			pr.load(f);// 	/ch19/list.do=ch19.action.ListAction
			//pr���ٰ� �׷������� �� ��������(???
		}catch(IOException e){
			throw new ServletException(e);
		}finally{
			try{
				if(f!=null){
					f.close();
				}//if
			}catch(Exception ex){}
		}//final
		
		//Iterator�� Collection �ڷḦ �޾Ƽ� ó���� �� �ִ�.
		Iterator keyIter=pr.keySet().iterator(); //������Ƽ Ű�� �� ������/���ͷ����ͷ� Ű ��ȯ.
		
		while(keyIter.hasNext()){
			String command=(String)keyIter.next(); //	/ch19/list.do <- �� ���� �����°�
			String className=pr.getProperty(command); //	�� ���� ������ �� ���� ���� /ch19.action.ListAction <- ��׸� ����. 
			
			try{
				Class commandClass=Class.forName(className); // /ch19.action.ListAction <-�긦 Ŭ������ ��ȯ��.
				Object commandInstance=commandClass.newInstance(); //�� Ŭ������ ��ü�� ����.
				commandMap.put(command, commandInstance);
				//Ŀ�ǵ� �κп��� /ch19/list.do �̰� ����
				//�ڿ��� ��ü�� ��. ��ü�� ���� ���� �ִ°��ΰ���.
				//������Ƽ �ȿ� �ִ°� �� �������. while������ ���ϱ�.
				
			}catch(Exception ex2){
				throw new ServletException(ex2);
			}//catch
		}//while
		
	}//init() end ---------------------------
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		requestPro(request, response); //�޼ҵ� ȣ�� 
	}//doGet
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		requestPro(request, response); //�޼ҵ� ȣ�� (� ����̴� �޼ҵ带 ȣ���ϰ� ����)
	}//doPost
	
	
	//Ŭ���̾�Ʈ ��û�� ó���ϴ� �޼ҵ�
	private void requestPro(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{
		
		String view=null; //�� �̸��� ���� ���� (��� jsp ����)
		CommandAction commandAction=null; //�������̽� (�׼� ����Ϸ���.)
		//���� Ŭ���� ������ ���� ��ü ó��.
		
		try{
			String command=request.getRequestURI(); // 	/������Ʈ��/ch19/list.do
			
			//url : ��ü�ּ� 
			//uri : ���ؽ�Ʈ �̸�(=������Ʈ �̸�)/�߰��̸�/list.jsp
			//(������ jsp�� �ƴϰ� list.do)
			
			if(command.indexOf(request.getContextPath())==0){
			//request.getContextPath()�� /13_MVC <- �길.
			//if("/������Ʈ��/ch19/list.do".indexOf("/13_MVC"){} �� �Ҹ���. �̰� �� ã�ҳ�. 
			//���ؽ�Ʈ���� �о������ �װ� 0�ΰ�. �������� 0�ΰ� = �װ� ã�ҳ�.
				
				//"/������Ʈ��/ch19/list.do" <- �̰� Ŀ��Ʈ. 
				// "/������Ʈ��/ch19/list.do".substring("/13_MVC") 
				//substring : � ��ġ���� ������ ���ڿ��� ����
				//�� ����� ���� = /ch19/list.do �̰� �̾Ƴ�����. 
				command=command.substring(request.getContextPath().length());
			}//if
			
			//HashMap���� ��ü�� ������ CommandAction Ÿ������ ����ȯ
			commandAction=(CommandAction)commandMap.get(command);
			view=commandAction.requestPro(request, response); //�׼� �޼ҵ� ȣ��
			//��ü.�޼ҵ� 
			//����Ʈ�׼ǿ� ������ ���ϰ��� list.jsp�ΰ� �װ� �� view�� �ش��ϴ� ��. 
		}catch(Throwable ex3){
			throw new ServletException(ex3);
		}//catch
		
		RequestDispatcher rd=request.getRequestDispatcher(view);
		rd.forward(request, response); //�׷����� view(jsp)�� ������
		
	}//requestPro() end
			
}//class end
