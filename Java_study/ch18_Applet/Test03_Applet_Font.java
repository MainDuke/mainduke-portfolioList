/*
// header - edit "Data/yourJavaAppletHeader" to customize
// contents - edit "EventHandlers/Java Applet/onCreate" to customize
*/
import java.awt.*;

public class Test03_Applet_Font extends java.applet.Applet
{
	public void paint(Graphics g)
	{
      //��� ���� �ϱ�!!!
      
		String msg="hello";
      Font font = new Font("Dialog", Font.BOLD, 20);
      g.setFont(font);
      
      FontMetrics fm= g.getFontMetrics();
      
      //d ���ٰ� ��ü �������� ��ġ�� �ִ´�.
      Dimension d = getSize();
      //x,y ��ǥ�� ���ϴµ�, �̰��� �� �߾Ӹ� ���Ѵ�.
      int x=d.width/2 - fm.stringWidth(msg)/2;
      int y=d.height/2 + fm.getDescent();
      
      
      
      g.drawString(msg, x, y);
	}
}

