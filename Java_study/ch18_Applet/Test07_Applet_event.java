/*
// header - edit "Data/yourJavaAppletHeader" to customize
// contents - edit "EventHandlers/Java Applet/onCreate" to customize
*/
import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;



public class Test07_Applet_event extends Applet implements ActionListener
{
   //����.
   int intNum=5;
   Image imgs[]=new Image[intNum]; //�̹��� �迭
   Button preBu, nextBu; //���� ��ư , ������ư
   int select=0; //�׸� �����Ϸ��� ~~
   
   public void init() // �ʱ�ȭ �۾�
	{
      preBu = new Button("���� �׸�");
      preBu.addActionListener(this); //�̺�Ʈ ���.
      add(preBu); //Applet �� ��ư ���̱�.
  
      
      nextBu = new Button("���� �׸�");
      nextBu.addActionListener(this);
      add(nextBu);
      
      for(int i = 0; i<intNum; i++)
      {
         String imgName="a"+(i+1)+".JPG";
         imgs[i]= getImage(getDocumentBase(), imgName); //�׸��� �迭�� �Ҵ�.
      }//for
      
      
   }//init() end.

   
   public void actionPerformed(ActionEvent e){
   if(e.getSource()==preBu)//���� �׸�.   
   {
      select=0;
   }else if(e.getSource() == nextBu){//����.�׸�.
   
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

