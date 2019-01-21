package member.action;
import ch19.action.*;

import member.*;

import java.util.*;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InputProAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
 
		request.setCharacterEncoding("utf-8"); //한글 인코딩
		
		LoginDto dto= new LoginDto();
				
		dto.setId(request.getParameter("id"));
		dto.setPasswd(request.getParameter("passwd"));
		dto.setName(request.getParameter("name"));
		
		dto.setJumin1(request.getParameter("jumin1"));
		dto.setJumin2(request.getParameter("jumin2"));
		
		dto.setEmail(request.getParameter("email"));
		
		dto.setZipcode(request.getParameter("zipcode"));
		dto.setAddr(request.getParameter("addr"));
		
		dto.setJob(request.getParameter("job"));
		dto.setBlog(request.getParameter("blog"));
				
		dto.setRegdate(new Timestamp(System.currentTimeMillis()));
	   
		LoginDao dao=LoginDao.getInstance(); //객체 얻기
	   
		dao.insertMember(dto);
		
		return "/member/inputPro.jsp";
	}
	
}
