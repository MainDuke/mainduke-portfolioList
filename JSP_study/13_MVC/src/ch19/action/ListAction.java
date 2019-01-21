package ch19.action;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*; //����Ʈ
import boardmysql.*;

public class ListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		String pageNum= request.getParameter("pageNum"); //������ ��ȣ
		if(pageNum==null){
			pageNum="1";
		}
		
		int pageSize=10; //�� �������� ���� ����
		int currentPage=Integer.parseInt(pageNum);
		int startRow=(currentPage-1)*pageSize+1; //�� �������� ���۱� ��ȣ
		int endRow=currentPage * pageSize; //�� �������� ������ �۹�ȣ
		int count=0;
		int number=0;
		
		List articleList=null;
		BoardDao dbPro=BoardDao.getInstance(); //��ü ���, DB ����
		count=dbPro.getArticleCount(); //�޼ҵ� ȣ��, ��ü ���� ��
		
		//
		if(count>0){ //���� �����ϸ�
			//mysql
			articleList = dbPro.getList(startRow, pageSize); //���� �������� �ش��ϴ� �� ���

			//oracle
			//articleList = dbPro.getList(startRow, endRow); //���� �������� �ش��ϴ� �� ���
		}else{ //���� ������
			articleList = Collections.EMPTY_LIST;
			//EMPTY_LIST=null;
		}//else
		
		////////////////////////////
		number=count-(currentPage-1)*pageSize; //�� ��Ͽ� ǥ���� �� ��ȣ
		
		//�ش� �信�� ����� �Ӽ�
		request.setAttribute("currentPage", new Integer(currentPage));
		request.setAttribute("startRow", new Integer(startRow));
		request.setAttribute("endRow", new Integer(endRow));
		request.setAttribute("count", new Integer(count));
		request.setAttribute("pageSize", new Integer(pageSize));
		request.setAttribute("number", new Integer(number));
		request.setAttribute("articleList", articleList);
			
		return "/ch19/list.jsp"; //�ش� �並 ����
	}//requestPro() end

}//class end
