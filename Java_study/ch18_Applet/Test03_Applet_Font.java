/*
// header - edit "Data/yourJavaAppletHeader" to customize
// contents - edit "EventHandlers/Java Applet/onCreate" to customize
*/
import java.awt.*;

public class Test03_Applet_Font extends java.applet.Applet
{
	public void paint(Graphics g)
	{
      //가운데 정렬 하기!!!
      
		String msg="hello";
      Font font = new Font("Dialog", Font.BOLD, 20);
      g.setFont(font);
      
      FontMetrics fm= g.getFontMetrics();
      
      //d 에다가 전체 사이즈의 수치를 넣는다.
      Dimension d = getSize();
      //x,y 좌표를 구하는데, 이것은 정 중앙르 뜻한다.
      int x=d.width/2 - fm.stringWidth(msg)/2;
      int y=d.height/2 + fm.getDescent();
      
      
      
      g.drawString(msg, x, y);
	}
}

