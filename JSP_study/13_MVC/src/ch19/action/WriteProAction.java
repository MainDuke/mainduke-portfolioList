
package ch19.action;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardmysql.*;


public class WriteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		request.setCharacterEncoding("utf-8"); //한글 인코딩
		
		BoardDto dto=new BoardDto(); //데이터 처리 빈
		
		dto.setNum(Integer.parseInt(request.getParameter("num")));
		dto.setWriter(request.getParameter("writer"));
		dto.setEmail(request.getParameter("email"));
		dto.setSubject(request.getParameter("subject"));
		dto.setPasswd(request.getParameter("passwd"));
		
		//dto.setRegdate(new Timestamp(System.currentTimeMillis()));
		dto.setRef(Integer.parseInt(request.getParameter("ref")));
		dto.setRe_step(Integer.parseInt(request.getParameter("re_step")));
		dto.setRe_level(Integer.parseInt(request.getParameter("re_level")));
		dto.setContent(request.getParameter("content"));
		dto.setIp(request.getRemoteAddr());
		
		BoardDao dao= BoardDao.getInstance(); //객체 얻기, DB 처리
		dao.insertArticle(dto); //메소드 호출
		return "/ch19/writePro.jsp"; //뷰 리턴
		
	}//requestPro() end

}

