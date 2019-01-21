/*
// header - edit "Data/yourJavaAppletHeader" to customize
// contents - edit "EventHandlers/Java Applet/onCreate" to customize
*/
import java.awt.*;
import java.applet.Applet;

public class Test06_DoubleBuffer extends Applet implements Runnable
{
   int x=0;
    Thread t;   
    Image imageBuffer;
      Graphics bufferg;
   Dimension d;

	public void init()
	{
      t = new Thread(this);
      t.start();
      
      //그림 그릴 준비.
      d= getSize();
      imageBuffer = createImage(d.width,d.height);
      
	}

   public void run(){
      try
      {
         while(true)
         {
            repaint();
            Thread.sleep(100);
         }
      }
      catch(Exception ex){}
   }//run end
   
   public void update(Graphics g){
      paint(g);
   }
    
	public void paint(Graphics g)
	{
     //버퍼를 위한 그래픽 객체를 얻는다.
      if(bufferg == null)
      {
         bufferg=imageBuffer.getGraphics();
      }
      //버퍼에 그리기작업.
      
      d=getSize();
      bufferg.setColor(Color.pink);
      bufferg.fillRect(0,0,d.width,d.height);
      
      bufferg.setColor(Color.green);
      bufferg.fillOval(x, d.height/4 ,50, 50);
      
      //화면에 출력.
      g.drawImage(imageBuffer,0,0,d.width,d.height, this);
      
      x +=10;
      if(x+50>d.width){
         x=0;
      }//if
      
   }//paint
}//class

