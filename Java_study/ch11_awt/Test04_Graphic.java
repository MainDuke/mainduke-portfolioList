/*
 * Author: Administrator
 * Created: 2016�� 1�� 29�� �ݿ��� ���� 11:19:52
 * Modified: 2016�� 1�� 29�� �ݿ��� ���� 11:19:52
 */

import java.awt.*;
import java.awt.event.*;

//inner Ŭ���� â���� ���.

class Test04_Graphic extends Frame
{
	public Test04_Graphic(){
		super("���콺 ����1");
		addWindowListener(new MyWin()); //�̺�Ʈ ����.
		setBounds(200, 200, 600, 600); // x/y/w/h 
		setVisible(true); //âǥ��.
	}//cons end
	
	//inner class
	class MyWin extends WindowAdapter{
		public void windowClosing(WindowEvent w){
			dispose();
			System.exit(0);
		}//windowclosing end
	}//end Mywin
	
	//�޼���
	//paint �۾� ����ϱ�~
	
	public void paint (Graphics g){
	/*g.drawString("���ڿ����", 10, 50); //(" ", x ��ǥ,y��ǥ)������ �ȼ�.	
	
	Font font= new Font("Dialog", Font.BOLD, 30);
	//					�۲� �̸�, ����, ũ��
	g.setFont(font);//font ����.
	g.drawString("���ڿ� ��� " , 10, 80);
	g.setFont(new Font("dialog", Font.BOLD+Font.ITALIC, 50));
	g.drawString("���ڿ� ���", 10, 130);
	
	//�� �׸���.
	g.drawLine(10, 30, 400, 300); //x1,y1 ~ x2 y2 �� �߱�.
	
	//�簢��.
	g.setColor(Color.red);
	g.drawRect(10, 50, 100,100); //x, y, w, h;
	
	//�ձ� �簢��.
	g.setColor(Color.blue);
	g.drawRoundRect(10, 100, 100, 100, 30, 50); // x,y,w,h, x����?,y���.
	
	//ä���� �簢��.
	g.setColor(Color.red);
	g.fillRect(100, 50, 100,100); //x, y, w, h;
	
	//ä���� �ձٻ簢��.
	g.setColor(Color.blue);
	g.fillRoundRect(150, 90, 100, 100, 30, 50); // x,y,w,h, x����?,y���.
	 
	
	//�� �׸���
	g.setColor(Color.blue);
	g.drawOval(200,140,50,50);
	
	//ä���� �� �׸���.
	g.setColor(Color.blue);
	g.fillOval(80,30,50,50);

	//Ÿ�� �׸���
	g.drawOval(80, 30, 50,100); //���� W , H �� ���̿� ���� ���� �޶�����.
	
	
	//ȣ �׸���.
	g.drawArc(200, 140, 250, 250, 30 , 240);
	
	g.fillArc(220, 160, 250, 250, 30 , 240);
	*/
	
	//�ٰ����� �迭�� �ؾ��Ѵ�.
	
	int x[]={30,200,250, 400, 450, 30};
	int y[]={140, 50, 70,10,140,140};
	
	g.drawPolygon(x, y, x.length); //�ٰ��� �׸���.
	
	for(int i=0;i<y.length;i++)
	{
		y[i]+=100;
	}
	g.drawPolygon(x, y, x.length); //�ٰ��� �׸���.
	
	
	
}//paint end
	
	
	
	public static void main( String [] args ) 
	{
		new Test04_Graphic();
	}// end main
}//class end
