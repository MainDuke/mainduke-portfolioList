/*
// header - edit "Data/yourJavaAppletHeader" to customize
// contents - edit "EventHandlers/Java Applet/onCreate" to customize
 */
import java.awt.*;
import java.applet.*;

public class Test05_NoDoubleBuffer extends java.applet.Applet implements Runnable
{
   
   int x=0;
   
	public void init()
	{
      System.out.println("test1");
      Thread t= new Thread(this);
      t.start();
         
	}

   
   public void run(){
      try
      {
         while(true)
         {
           repaint();
           Thread.sleep(100);
          
            
         }
      }catch(Exception ex){}
   }//run end
   
	public void paint(Graphics g)
	{
      Dimension d =getSize();
      
      g.setColor(Color.pink);
      g.fillRect(0,0,d.width,d.height);
      
      g.setColor(Color.yellow);
      g.fillOval(x,d.height/4,50,50);
      
      x += 10;
      
      if(x+10>d.width){
         x=0;
      }
      
	}
}

