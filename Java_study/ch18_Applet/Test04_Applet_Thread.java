/*
// header - edit "Data/yourJavaAppletHeader" to customize
// contents - edit "EventHandlers/Java Applet/onCreate" to customize
*/
import java.awt.*;

public class Test04_Applet_Thread extends java.applet.Applet implements Runnable
{
   int cnt;
 Thread t;  
   
	public void init()
	{
      cnt=0;
      t = new Thread(this); //��ü ����.
      t.start();
      
   }//init() end

   
   public void run(){
   try
   {
      while(true)
      {
         repaint();//�ٽñ׸���.
         Thread.sleep(1000);//���.
         ++cnt;
      
      }//while
   }catch(Exception ex){}
}//run() end
   
	public void paint(Graphics g)
	{
      g.setFont(new Font("Dialog",Font.BOLD, 36));
      FontMetrics fm =g.getFontMetrics(); //�۲� ������ ���Ѵ�.
      
      String str = ""+cnt; //������ ���ڿ��� ���ش�.
      Dimension d=getSize(); //â ũ�� ����.
      int x=d.width/2 - fm.stringWidth(str)/2;
      
      
      g.drawString(str, x, d.height/2);
	}
}

