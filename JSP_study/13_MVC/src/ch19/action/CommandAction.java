package ch19.action;

import javax.servlet.http.*;

//�������̽�
//��û �Ķ���ͷ� ��ɾ �����ϴ� ����� ����(super) �������̽�
public interface CommandAction {
	
	//�޼ҵ� �� �ϳ��� �־����
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable;

}//
