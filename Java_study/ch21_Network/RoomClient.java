import java.awt.*;
import javax.swing.table.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

class RoomClient extends JFrame
{
	//vari
   TextArea ta = new TextArea(); //대화내용 출력할곳.
   TextField tf = new TextField(); //대화내용 입력할곳.
 String data1[][]=new String[0][1];
   String cols1[] = {"대화명"};

   DefaultTableModel model1= new DefaultTableModel(data1, cols1){
     
         public boolean isCellEditable(int row, int cols){
            return false;
         }
    };
   JTable table1 = new JTable(model1);
   JScrollPane roomInfoPane = new JScrollPane(table1);
   
   JLabel lab1 = new JLabel("현재인원");
   TextField inwon= new TextField(10);
   
   JButton nickB = new JButton("대화명변경");
   JButton sayB = new JButton("귓속말");
   JButton outB = new JButton("나가기");
 
   
   //cons
   public RoomClient(){//생성자.
   
      setTitle("RoomClient 대화방"); //창제목.
   
      //tf 설정.
      tf.setFont(new Font("Dialog", Font.BOLD, 16));
     
      //ta 설정.
      ta.setFont(new Font("Dialog", Font.BOLD, 16));
      ta.setEditable(false); //ta 에디트 락
      ta.setFocusable(false); //포커스 락.
      
      table1.getTableHeader().setReorderingAllowed(false); //테이블 열 순서 변경 ㄴㄴ
      table1.getTableHeader().setBackground(new Color(61,232,205)); //색 설정.
      
      
      //버튼 배경.
      nickB.setBackground(new Color(85, 214,211));
      sayB.setBackground(new Color(85, 214,211));
      outB.setBackground(new Color(85, 214,211));
      
      
      //폰트 설정.
      nickB.setFont(new Font("Dialog", Font.BOLD, 12));
      sayB.setFont(new Font("Dialog", Font.BOLD, 12));
      outB.setFont(new Font("Dialog", Font.BOLD, 12));
      lab1.setFont(new Font("Dialog", Font.BOLD, 12));
      
      getContentPane().setLayout(null); //배치를 프로그래머가 하려고.
      
      getContentPane().add(ta).setBounds(10,10,400,400);
      getContentPane().add(roomInfoPane).setBounds(415,10,168,200);
      getContentPane().add(tf).setBounds(10,420,400,20);
      
      getContentPane().add(lab1).setBounds(445,240,60,30);
      getContentPane().add(inwon).setBounds(510,245,50,30);
      
      getContentPane().add(nickB).setBounds(450,325,100,30);
      getContentPane().add(sayB).setBounds(450,365,100,30);
      getContentPane().add(outB).setBounds(450,405,100,30);
      
     
      setSize(600,500);
     // setVisible(true);
      tf.requestFocus();
   }//cons end
   
   
   /*
   public static void main( String [] args ) 
   {
   new RoomClient();
   }// end main
    */
   
}//RoomClient class end
