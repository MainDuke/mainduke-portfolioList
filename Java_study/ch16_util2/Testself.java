/*
 * Author: Administrator
 * Created: 2016년 2월 11일 목요일 오후 5:43:26
 * Modified: 2016년 2월 11일 목요일 오후 5:43:26
 */
import java.awt.*;
import java.awt.event.*;

class Testself extends Frame
{
	public Testself(){
      super("");
      addWindowListener(new MyWin());
      setBounds(200,200,200,200);
      setVisible(true);
   
   }
   
   public class MyWin extends WindowAdapter{
      public void windowClosing(WindowEvent w){
         dispose();
         System.exit(0);
      }
   }//end
   public static void main( String [] args ) 
   {
      new Testself();
   }// end main
}
