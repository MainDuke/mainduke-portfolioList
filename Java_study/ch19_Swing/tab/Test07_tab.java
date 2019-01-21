//tab 을 사용하여
//다른 java파일 3개를 실행 시킬 수 있도록 만들기 

import java.awt.*;
import javax.swing.*;

class Test07_tab extends JFrame
{
   //vari
	Test03_awt_Dialog t3= new Test03_awt_Dialog();
   Test04_awt_dialog t4= new Test04_awt_dialog();
   Test06_table t6 = new Test06_table();
   
   JTabbedPane tab = new JTabbedPane();
   
   
   //cons
   
   public Test07_tab(){
      tab.addTab("Test3",t3);
      tab.addTab("Test4",t4);
      tab.addTab("Test6",t6);
            
      this.getContentPane().setLayout(new GridLayout(1,1));
      this.getContentPane().add(tab);
      
      this.setSize(810,700);
      this.setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
   }//cons end
   
   public static void main( String [] args ) 
   {
      new Test07_tab();
   }// end main
   
}//class 
