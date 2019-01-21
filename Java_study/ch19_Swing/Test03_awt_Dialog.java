/*
 * Author: Administrator
 * Created: 2016�� 2�� 15�� ������ ���� 12:02:58
 * Modified: 2016�� 2�� 15�� ������ ���� 12:02:58
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
         
      b1.setBackground(Color.blue); //����.
      b2.setBackground(Color.pink); //����.
      b3.setBackground(Color.green); //����.
      
      b1.setForeground(Color.white);//�����, �۲� ��.
      b2.setForeground(Color.white);
      b3.setForeground(Color.white);
      
      b1.addActionListener(this); //�̺�Ʈ ���.
      b2.addActionListener(this);
      b3.addActionListener(this);

      
      setLayout(new FlowLayout());//Flow Layout ����.
      add(b1);//Frame �� b1 ���.
      add(b2);
      add(b3);
      
      
      setVisible(true);
      setSize(500,300);
      
      //���� Ŭ������ â����.
      
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
         String str = JOptionPane.showInputDialog(this, "��ȭ�� �Է� ....");
         System.out.println("����� �̸���"+str+" �Դϴ�.");
         
       
      }
      
   }
   //custom
   
   //method
      public static void main( String [] args ) 
      {
         new Test03_awt_Dialog();
      }// end main
   
   
   }//class end
