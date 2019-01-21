
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
		
		BoardDao dbPro=BoardDao.getInstance(); //객체 얻기
		int check=dbPro.deleteArticle(num, passwd); //메소드 호출
		
		//해당 뷰에서 사용할 속성
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("check", new Integer(check));

		return "/ch19/deletePro.jsp"; //해당뷰
	}//requestPro()end
	
}//class end
