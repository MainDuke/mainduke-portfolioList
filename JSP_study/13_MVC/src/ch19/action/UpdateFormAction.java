package ch19.action;

import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import boardmysql.*;

public class UpdateFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		int num=Integer.parseInt(request.getParameter("num"));
		String pageNum=request.getParameter("pageNum");
		
		BoardDao dbPro=BoardDao.getInstance(); //��ü����
		BoardDto article=dbPro.updateGetArticle(num); //�޼ҵ� ȣ��
		
		//�ش� �信�� ����� �Ӽ�
		request.setAttribute("pageNum", new Integer(pageNum));
		request.setAttribute("article", article);
		
		return "/ch19/updateForm.jsp"; //�ش�� ����
	}//requestPro() end

}//class end