/*
 * Author: Administrator
 * Created: 2016년 2월 15일 월요일 오후 2:30:51
 * Modified: 2016년 2월 15일 월요일 오후 2:30:51
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Test05_table extends JFrame
{
	//vari
   JTable table;

   //cons
   public Test05_table(){
      
   Object ob[][]={
      {"kim", "21", "aa@cc"},
      {"lee", "25", "11@cc"},
      {"kol", "24", "22@cc"},
      {"han", "28", "33@cc"},
      {"kkl", "33", "44@cc"},
      {"QRT", "27", "55@cc"},
      {"ERT", "55", "66@cc"},
      {"ERIC", "43", "77@cc"},
      {"DUKE", "44", "88@cc"},
      {"king", "55", "99@cc"},
      {"Queen", "52", "18@cc"}
   };
      
   String cols[]={"이름", "나이","이메일"}; //테이블의 열 제목.
   
   table= new JTable(ob, cols);
   JScrollPane pane=new JScrollPane(table); //table 에 스크롤바 넣기.
   
   getContentPane().add("Center", pane);
   setSize(300,300);
   setVisible(true);
   
   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
   }//cons
   
   public static void main( String [] args ) 
   {
     new Test05_table();
   }// end main
   
}//class end 
