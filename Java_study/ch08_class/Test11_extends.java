/*
 * Author: Administrator
 * Created: 2016�� 1�� 27�� ������ ���� 12:23:24
 * Modified: 2016�� 1�� 27�� ������ ���� 12:23:24
 */

/*
�ڻ��� Ŭ���� ������ ���� ��ü ó���ϴ� p.g
	����Ŭ���� ����=new ���� Ŭ����(); //upcasting
cf) double d =77; //�ڵ� ����ȯ
*/

import java.awt.*;
import java.awt.event.*;

class Test11_extends extends Frame
{
	
	//����
	//������
	public Test11_extends(){
		super("upcasting");
		addWindowListener(new Mywin());//�̺�Ʈ
	}
	//inner class
	class Mywin extends WindowAdapter{
		//���� ���̵�
		public void windowClosing(WindowEvent we){
		 System.exit(0); // â����, ���α׷� ����.
		}//windowClosing
	}//inner end
	
	
	public static void main( String [] args ) 
	{
		Frame f = new Test11_extends();// ��ü ����. ������ ȣ��.
		
		f.setSize(300,300);
		f.setVisible(true);
		
		
	}// end main

}//class end
