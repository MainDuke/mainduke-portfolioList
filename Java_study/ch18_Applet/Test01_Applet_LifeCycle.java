/*
// header - edit "Data/yourJavaAppletHeader" to customize
// contents - edit "EventHandlers/Java Applet/onCreate" to customize
 */
import java.awt.*;

public class Test01_Applet_LifeCycle extends java.applet.Applet
{
	
   String msg="";
   //생성자와 같은 기능.init
   public void init()
	{
      resize(300,300);
      msg +="init() ";
	}
   
   public void start(){
      msg +="start()";
   }
   public void stop(){
      msg += "stop() ";
   }
   public void destroy(){
      System.out.println("destroy() 호출 됬었음.");
   }

	public void paint(Graphics g)
	{
      msg +="paint() ";
		g.drawString("hellop", 50, 50);
	}
   
}

