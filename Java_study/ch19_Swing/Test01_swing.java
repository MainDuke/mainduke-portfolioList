import java.awt.*; //layout ���.
import javax.swing.*;

class Test01_swing extends JFrame
{
   //vari
   JButton b1,b2,b3;
   
   //cons
   public Test01_swing(){
      
      
      this.getContentPane().setLayout(new FlowLayout());

      
      ImageIcon icon1= new ImageIcon("a1.gif");
      b1= new JButton("1��", icon1);
      b1.setToolTipText("���� ���� ù��° ��ư");
      this.getContentPane().add(b1);
      
      //
      ImageIcon icon2= new ImageIcon("a2.gif");
      b2 = new JButton("2��", icon2);
      b2.setToolTipText("�������� �ι�° ��ư");
      this.getContentPane().add(b2);
      
      //
      ImageIcon icon3 = new ImageIcon("a3.gif");
      b3 = new JButton("3��", icon3);
      b3.setToolTipText("�������� ����° ��ư.");
      this.getContentPane().add(b3);
      
      setVisible(true);
      setSize(500,300);
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      }//cons end
   
   public static void main( String [] args ) 
   {
      new Test01_swing();
   }// end main
   
}//class end
