import java.awt.*;
import javax.swing.table.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

class RoomClient extends JFrame
{
	//vari
   TextArea ta = new TextArea(); //��ȭ���� ����Ұ�.
   TextField tf = new TextField(); //��ȭ���� �Է��Ұ�.
 String data1[][]=new String[0][1];
   String cols1[] = {"��ȭ��"};

   DefaultTableModel model1= new DefaultTableModel(data1, cols1){
     
         public boolean isCellEditable(int row, int cols){
            return false;
         }
    };
   JTable table1 = new JTable(model1);
   JScrollPane roomInfoPane = new JScrollPane(table1);
   
   JLabel lab1 = new JLabel("�����ο�");
   TextField inwon= new TextField(10);
   
   JButton nickB = new JButton("��ȭ����");
   JButton sayB = new JButton("�ӼӸ�");
   JButton outB = new JButton("������");
 
   
   //cons
   public RoomClient(){//������.
   
      setTitle("RoomClient ��ȭ��"); //â����.
   
      //tf ����.
      tf.setFont(new Font("Dialog", Font.BOLD, 16));
     
      //ta ����.
      ta.setFont(new Font("Dialog", Font.BOLD, 16));
      ta.setEditable(false); //ta ����Ʈ ��
      ta.setFocusable(false); //��Ŀ�� ��.
      
      table1.getTableHeader().setReorderingAllowed(false); //���̺� �� ���� ���� ����
      table1.getTableHeader().setBackground(new Color(61,232,205)); //�� ����.
      
      
      //��ư ���.
      nickB.setBackground(new Color(85, 214,211));
      sayB.setBackground(new Color(85, 214,211));
      outB.setBackground(new Color(85, 214,211));
      
      
      //��Ʈ ����.
      nickB.setFont(new Font("Dialog", Font.BOLD, 12));
      sayB.setFont(new Font("Dialog", Font.BOLD, 12));
      outB.setFont(new Font("Dialog", Font.BOLD, 12));
      lab1.setFont(new Font("Dialog", Font.BOLD, 12));
      
      getContentPane().setLayout(null); //��ġ�� ���α׷��Ӱ� �Ϸ���.
      
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
