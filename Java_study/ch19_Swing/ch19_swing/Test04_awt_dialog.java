/*
 * Author: Administrator
 * Created: 2016년 2월 15일 월요일 오후 12:31:40
 * Modified: 2016년 2월 15일 월요일 오후 12:31:40
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Test04_awt_dialog extends Frame implements ActionListener
{
	
   //vari
   Image im;
   Button bu[][];
   int n=2;
   
   //cons
   public Test04_awt_dialog(){

      bu = new Button[n][n];
      setLayout(new GridLayout(n,n));
      setFont(new Font("Dialog", Font.BOLD, 72));
      int a=1;//버튼 에 숫자 표시 하려고.
      
      for(int i=0;i<2;i++)
      {
         for(int j=0;j<2;j++)
            {
               bu[i][j]=new Button("" + a++);//버튼 생성.
               bu[i][j].setBackground(Color.blue); //배경색
               bu[i][j].setForeground(Color.white); //버튼 글꼴
               bu[i][j].addActionListener(this);//이벤트 등록.
               add(bu[i][j]);//Frame에 등록.
               
               
            }//inner for
      }//out for

      im = Toolkit.getDefaultToolkit().getImage("t16.jpg");


      setVisible(true);
      setSize(300,300);	
      addWindowListener(new WindowAdapter()
         {
            public void windowClosing(WindowEvent w){
               System.exit(0);
            }
         }
         
         );

   }//cons end

   public void paint(Graphics g){
      g.drawImage(im,0,0,300,300,this);
   }
         
   //over
   public void actionPerformed(ActionEvent e){
   
   
      for(int i =0;i<2;i++)
      {
       for(int j = 0;j<2;j++)
       {
         
         if(e.getSource() == bu[i][j]){
            int anser = JOptionPane.showConfirmDialog(this, "자바는 쉽다." ,"질문", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            
            switch(anser){
            case JOptionPane.YES_OPTION:
               bu[i][j].setVisible(false);
               break;
            case JOptionPane.NO_OPTION:
               bu[i][j].setVisible(true);
               break;
            }   
         }
            
         }//in
         
      }//out
      
      /*
      if(e.getSource() == bu[0][0]){
      int anser = JOptionPane.showConfirmDialog(this, "자바는 쉽다." ,"질문", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
   
      switch(anser){
      case JOptionPane.YES_OPTION:
         bu[0][0].setVisible(false);
         break;
      case JOptionPane.NO_OPTION:
         bu[0][0].setVisible(true);
         break;
      }   
   }//if end
   */
   
}//over end
 
   //custom
   
   //method
   public static void main( String [] args ) 
   {
      new Test04_awt_dialog();
   }// end main

}//class end.
