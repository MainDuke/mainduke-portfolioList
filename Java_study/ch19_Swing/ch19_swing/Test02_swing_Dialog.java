/*
 * Author: Administrator
 * Created: 2016�� 2�� 15�� ������ ���� 11:30:31
 * Modified: 2016�� 2�� 15�� ������ ���� 11:30:31
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
      
      b1 = new JButton("����", i1);
      b2 = new JButton("���", i2);
      b3 = new JButton("����", i3);
      
      b1.setToolTipText("���� ��ȭ ���� �Դϴ�.");
      b2.setToolTipText("�溸 ��ȭ ���� �Դϴ�.");
      b3.setToolTipText("���� ��ȭ ���� �Դϴ�.");
      
      b1.addActionListener(this);
      b2.addActionListener(this);
      b3.addActionListener(this);
      
      this.getContentPane().setLayout(new FlowLayout());
      this.getContentPane().add(b1);
      this.getContentPane().add(b2);
      this.getContentPane().add(b3);
      
      setSize(500,300);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //â ����.
      
      
   }//cons end
   
   
   //over
   public void actionPerformed(ActionEvent e){
      if(e.getSource()==b1)
      {
         JOptionPane.showMessageDialog(this , "���� ���� �޼���.");
      }else if(e.getSource()==b2){
         JOptionPane.showMessageDialog(this , "�溸 ���� �޼���.","���", JOptionPane.WARNING_MESSAGE);
      }else if(e.getSource()==b3){
         JOptionPane.showMessageDialog(this , "���� ���� �޼���.","����", JOptionPane.ERROR_MESSAGE);
         //this�� �θ�â, �޼��� , â����, 
      
      }
      
      
   }//action end

    public static void main( String [] args ) 
   {
      new Test02_swing_Dialog();
   }// end main
   
}//class end

