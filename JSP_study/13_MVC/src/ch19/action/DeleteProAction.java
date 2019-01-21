
package ch19.action;

import javax.servlet.http.*;

import boardmysql.*;

public class DeleteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8");
		
		int num=Integer.parseInt(request.getParameter("num"));
		String pageNum=request.getParameter("pageNum");
		String passwd=request.getParameter("passwd");
		
		BoardDao dbPro=BoardDao.getInstance(); //��ü ���
		int check=dbPro.deleteArticle(num, passwd); //�޼ҵ� ȣ��
		
		//�ش� �信�� ����� �Ӽ�
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("check", new Integer(check));

		return "/ch19/deletePro.jsp"; //�ش��
	}//requestPro()end
	
}//class end
