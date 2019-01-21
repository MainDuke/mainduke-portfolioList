/*
// header - edit "Data/yourJavaAppletHeader" to customize
// contents - edit "EventHandlers/Java Applet/onCreate" to customize
*/
import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;



public class Test07_Applet_event extends Applet implements ActionListener
{
   //변수.
   int intNum=5;
   Image imgs[]=new Image[intNum]; //이미지 배열
   Button preBu, nextBu; //이전 버튼 , 다음벼튼
   int select=0; //그림 선택하려고 ~~
   
   public void init() // 초기화 작업
	{
      preBu = new Button("이전 그림");
      preBu.addActionListener(this); //이벤트 등록.
      add(preBu); //Applet 에 버튼 붙이기.
  
      
      nextBu = new Button("다음 그림");
      nextBu.addActionListener(this);
      add(nextBu);
      
      for(int i = 0; i<intNum; i++)
      {
         String imgName="a"+(i+1)+".JPG";
         imgs[i]= getImage(getDocumentBase(), imgName); //그림을 배열에 할당.
      }//for
      
      
   }//init() end.

   
   public void actionPerformed(ActionEvent e){
   if(e.getSource()==preBu)//이전 그림.   
   {
      select=0;
   }else if(e.getSource() == nextBu){//다음.그림.
   
      if(select < 4)
      {
       select++;  
      }else{
       select=0;
      }
   
   }//if end
   repaint();
   
}//end action
   
	public void paint(Graphics g)
	{
		g.drawImage(imgs[select], 20, 50, this);
	}
}

