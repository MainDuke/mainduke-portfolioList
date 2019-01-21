/*
// header - edit "Data/yourJavaAppletHeader" to customize
// contents - edit "EventHandlers/Java Applet/onCreate" to customize
*/
import java.awt.*;

public class Test02_Applet extends java.applet.Applet
{
	public void init()
	{
		resize(300,300);
	}

	public void paint(Graphics g)
	{
      int baseline=100;
      g.setColor(Color.gray);
      g.drawLine(0,baseline, 250, baseline); //¼±±ß±â.
      
      Font font = new Font("±¼¸²", Font.BOLD, 30);
      g.setFont(font);
      g.setColor(Color.blue);
      g.drawString("Hello Test02_Applet!", 5, baseline);
	   
      g.setColor(Color.magenta);
      
      FontMetrics fm = g.getFontMetrics(font);
      int decent= fm.getDescent();   
      g.drawLine(0,baseline+decent, 350, 100+decent);  
      
    }
}

