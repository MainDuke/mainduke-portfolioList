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
      t = new Thread(this); //객체 생성.
      t.start();
      
   }//init() end

   
   public void run(){
   try
   {
      while(true)
      {
         repaint();//다시그리기.
         Thread.sleep(1000);//대기.
         ++cnt;
      
      }//while
   }catch(Exception ex){}
}//run() end
   
	public void paint(Graphics g)
	{
      g.setFont(new Font("Dialog",Font.BOLD, 36));
      FontMetrics fm =g.getFontMetrics(); //글꼴 정보를 구한다.
      
      String str = ""+cnt; //정수를 문자열로 해준다.
      Dimension d=getSize(); //창 크기 구함.
      int x=d.width/2 - fm.stringWidth(str)/2;
      
      
      g.drawString(str, x, d.height/2);
	}
}

