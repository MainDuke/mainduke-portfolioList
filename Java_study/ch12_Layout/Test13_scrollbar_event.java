/*
 * Author: Administrator
 * Created: 2016년 2월 3일 수요일 오전 9:08:19
 * Modified: 2016년 2월 3일 수요일 오전 9:08:19
 */

import java.awt.*;
import java.awt.event.*;

class Test13_scrollbar_event extends Frame implements AdjustmentListener
{
   //vari
   
   Scrollbar rsb,gsb,bsb;
   Label label,la_red,la_green,la_blue;
   
   //cons
	public Test13_scrollbar_event(){
      super("Scrollbar");
      
      setLayout(null); // 프로그래머가 직접 컴포넌트 배치.
     
      label = new Label("");
      label.setBackground(Color.yellow);
      label.setBounds(20, 150, 200, 20); //x, y, w,h
      this.add(label); 
     
      
      
      setVisible(true);
      setBounds(200,200,500,500);
      
      la_red = new Label("빨강", Label.LEFT);
      la_green = new Label("초록", Label.LEFT);
      la_blue = new Label("파랑", Label.LEFT);
      
      rsb = new Scrollbar(Scrollbar.HORIZONTAL, 0  , 0, 0, 256);
      gsb = new Scrollbar(Scrollbar.HORIZONTAL, 0  , 0, 0, 256);
      bsb = new Scrollbar(Scrollbar.HORIZONTAL, 0  , 0, 0, 256);
                  //수평 스크롤바.      
      
      la_red.setBounds(20,30,50,20);           
      la_green.setBounds(20,60,50,20);
      la_blue.setBounds(20,90,50,20);
                  
      this.add(la_red);
      this.add(la_green);
      this.add(la_blue);
      
      this.add(la_red).setBounds(20,30,50,20);
      this.add(la_green).setBounds(20,60,50,20);
      this.add(la_blue).setBounds(20,90,50,20);
      
      this.add(rsb).setBounds(80,30,250,20);
      this.add(gsb).setBounds(80,60,250,20);
      this.add(bsb).setBounds(80,90,250,20);
        
      //이벤트 등록.
      addWindowListener(new MyWin());
      
      rsb.addAdjustmentListener(this);
      gsb.addAdjustmentListener(this);
      bsb.addAdjustmentListener(this);
      
   }//cons
   
   //inner
   public class MyWin extends WindowAdapter{
      public void windowClosing(WindowEvent w){
         dispose();
         System.exit(0);
      }
  }//inner end
      
   
   //overiding
   public void adjustmentValueChanged(AdjustmentEvent e){
      int r = rsb.getValue(); // 빨강색상 값 얻기.
      int g = gsb.getValue(); // 그린색상 값 얻기.
      int b = bsb.getValue();
      
      Color color= new Color(r,g,b);
      setBackground(color);
      label.setText(" red "+r+" Green "+g+" Blue "+b);
      
   }
   
   //main
   public static void main( String [] args )
   {
      new Test13_scrollbar_event();
   }// end main


}//class
