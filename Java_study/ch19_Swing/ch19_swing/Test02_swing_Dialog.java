/*
 * Author: Administrator
 * Created: 2016년 2월 15일 월요일 오전 11:30:31
 * Modified: 2016년 2월 15일 월요일 오전 11:30:31
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Test02_swing_Dialog extends JFrame implements ActionListener
{
	//vari
   JButton b1,b2,b3;
   
   //cons
   public Test02_swing_Dialog(){
      ImageIcon i1 = new ImageIcon("a1.gif");
      ImageIcon i2 = new ImageIcon("a2.gif");
      ImageIcon i3 = new ImageIcon("a3.gif");
      
      b1 = new JButton("정보", i1);
      b2 = new JButton("경고", i2);
      b3 = new JButton("에러", i3);
      
      b1.setToolTipText("정보 대화 상자 입니다.");
      b2.setToolTipText("경보 대화 상자 입니다.");
      b3.setToolTipText("에러 대화 상자 입니다.");
      
      b1.addActionListener(this);
      b2.addActionListener(this);
      b3.addActionListener(this);
      
      this.getContentPane().setLayout(new FlowLayout());
      this.getContentPane().add(b1);
      this.getContentPane().add(b2);
      this.getContentPane().add(b3);
      
      setSize(500,300);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창 종료.
      
      
   }//cons end
   
   
   //over
   public void actionPerformed(ActionEvent e){
      if(e.getSource()==b1)
      {
         JOptionPane.showMessageDialog(this , "정보 전달 메세지.");
      }else if(e.getSource()==b2){
         JOptionPane.showMessageDialog(this , "경보 전달 메세지.","경고", JOptionPane.WARNING_MESSAGE);
      }else if(e.getSource()==b3){
         JOptionPane.showMessageDialog(this , "에러 전달 메세지.","에러", JOptionPane.ERROR_MESSAGE);
         //this는 부모창, 메세지 , 창제목, 
      
      }
      
      
   }//action end

    public static void main( String [] args ) 
   {
      new Test02_swing_Dialog();
   }// end main
   
}//class end

