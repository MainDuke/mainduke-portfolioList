//awt = vc++
//�������̽� ���.
import java.awt.*;
import java.awt.event.*;

class Test01_Window extends Frame implements WindowListener
{
	//����
	//������
	public Test01_Window(){
	super("â����");
	addWindowListener(this);//�̺�Ʈ ���.
	
	setSize(300, 300);//âũ��.
	setVisible(true);//âǥ��
	}
	//�������̵�
	public void windowClosing(WindowEvent w){
		dispose();
		System.exit(0);//���α׷� â ����.
	}
	public void windowClosed(WindowEvent w){} //â ���� ��
	public void windowOpened(WindowEvent w){} // â ���� ������
	public void windowIconified(WindowEvent w){} // ������ȭ
	public void windowDeiconified(WindowEvent w){} //�� ������ȭ
	public void windowActivated(WindowEvent w){} //Ȱ��ȭ
	public void windowDeactivated(WindowEvent w){} // ��Ȱ��ȭ.
	
	//main
	public static void main( String [] args ) 
	{
		new Test01_Window(); //��ü ����.
		
	}// end main
}
