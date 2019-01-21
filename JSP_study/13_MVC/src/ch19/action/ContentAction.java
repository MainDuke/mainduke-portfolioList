
package ch19.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import boardmysql.*;

public class ContentAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		int num=Integer.parseInt(request.getParameter("num")); //�ش� �� ��ȣ
		String pageNum=request.getParameter("pageNum"); //�ش� ������ ��ȣ
		
		BoardDao dbPro=BoardDao.getInstance(); //DBó��
		BoardDto article= dbPro.getArticle(num); //�ش� �۹�ȣ�� ���� �ش� ���ڵ�
		
		//�ش� �信�� ����� �Ӽ�
		request.setAttribute("num", new Integer(num));
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);
		
		return "/ch19/content.jsp"; //�ش� �並 ����
	}//requestPro() end

}//class end
