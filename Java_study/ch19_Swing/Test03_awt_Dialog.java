/*
 * Author: Administrator
 * Created: 2016년 2월 15일 월요일 오후 12:02:58
 * Modified: 2016년 2월 15일 월요일 오후 12:02:58
 */

import java.awt.*; //Latout
import java.awt.event.*;
import javax.swing.*;


class Test03_awt_Dialog extends Frame implements ActionListener
{
	//vari
   Button b1,b2,b3;
   String msg;
   
   //cons
   public Test03_awt_Dialog(){
      
      b1 = new Button("Message");
      b2 = new Button("Confirm");
      b3 = new Button("Input");
         
      b1.setBackground(Color.blue); //배경색.
      b2.setBackground(Color.pink); //배경색.
      b3.setBackground(Color.green); //배경색.
      
      b1.setForeground(Color.white);//전경색, 글꼴 색.
      b2.setForeground(Color.white);
      b3.setForeground(Color.white);
      
      b1.addActionListener(this); //이벤트 등록.
      b2.addActionListener(this);
      b3.addActionListener(this);

      
      setLayout(new FlowLayout());//Flow Layout 설정.
      add(b1);//Frame 에 b1 담기.
      add(b2);
      add(b3);
      
      
      setVisible(true);
      setSize(500,300);
      
      //무명 클래스로 창종료.
      
      addWindowListener(new WindowAdapter()
         {
            public void windowClosing(WindowEvent w){
               System.exit(0);
            }
         }
         
         );
      
 
   }//cons end
   
   //over
   public void actionPerformed(ActionEvent e){
      
      if(e.getSource() ==b1)
      {
         JOptionPane.showMessageDialog(this, "Message ....");
      }else if(e.getSource() ==b2)
      {
         JOptionPane.showConfirmDialog(this, "Confirm ....");
      }else if(e.getSource() ==b3)
      {
         String str = JOptionPane.showInputDialog(this, "대화를 입력 ....");
         System.out.println("당신의 이름은"+str+" 입니다.");
         
       
      }
      
   }
   //custom
   
   //method
      public static void main( String [] args ) 
      {
         new Test03_awt_Dialog();
      }// end main
   
   
   }//class end
