/*
ch19_swing 폴더네에 tab 디렉토리를 만든다.

 */




import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*; //DefaultTableModel : 행추가 /삭제

class Test06_table extends JFrame implements ActionListener, MouseListener, KeyListener
{
   //vari
   JPanel panel;
   JLabel laName, laAge, laAddr;
   JTextField txName, txAge,txAddr;
  
   Object ob[][]=new Object[0][3]; //0행 3열.
   String title[]={"이름","나이","주소"};
   
   DefaultTableModel model = new DefaultTableModel(ob, title)
   {
      //셀 편집 못하게 하면, table 더클이 먹힌다.
      public boolean isCellEditable(int rows, int cols){
         return false;
      }
   };
   
   JTable table = new JTable(model);
   JScrollPane pane = new JScrollPane(table);
   JButton bu;
   
   //cons
   public Test06_table(){
      
   
      panel = new JPanel();
      panel.setBackground(Color.yellow);
      laName=new JLabel("이름",JLabel.RIGHT);
      laAge=new JLabel("나이",JLabel.RIGHT);
      laAddr=new JLabel("주소",JLabel.RIGHT);
      
      txName=new JTextField();
      txAge=new JTextField();
      txAddr=new JTextField();
      
      
      panel.setLayout(new GridLayout(3,2));
      panel.add(laName);
      panel.add(txName);
      panel.add(laAge);
      panel.add(txAge);
      panel.add(laAddr);
      panel.add(txAddr);
      
      
      
      bu = new JButton("테이블 내용 삭제.");
      
      
      //액션 이벤트.
      bu.addActionListener(this);
      txName.addActionListener(this);
      txAge.addActionListener(this);
      txAddr.addActionListener(this);
      
      //마우스 등록
      table.addMouseListener(this);
    
      //클래스를 선언해서 키 이벤트를 등록
      
      txName.setFocusTraversalKeysEnabled(false); //Tab 키로 키이동 안하게함.
      txAddr.setFocusTraversalKeysEnabled(false); 
      txAge.setFocusTraversalKeysEnabled(false); 
      
      txAddr.addKeyListener(this);
      txAge.addKeyListener(this);
      txName.addKeyListener(this);
    
           
    
      
      
      //판넬 배치.
      getContentPane().add("North", panel);
      getContentPane().add("Center", pane);
      getContentPane().add("South", bu);
      
      setSize(300,300);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   String name="",age="",addr="" ; //변수.
   int r= -1;
   
   
   public void mouseClicked(MouseEvent m){
     
      r =table.getSelectedRow();
      
      if(m.getClickCount() == 2)
      {
      //model.removeRow(table.getSelectedRow()); //행제거.
    
      
      r=table.getSelectedRow(); 
      name=(String)table.getValueAt(r,0);
      age=(String)table.getValueAt(r,1);
      addr=(String)table.getValueAt(r,2);
      
      
      txName.setText(name); //테이블에서 얻은 데이터를 tdName에 표시.
      txAge.setText(age);
      txAddr.setText(addr);   
      }
      
      
      
   }//mouse click end
   
   
   //over
   public void mousePressed(MouseEvent me){}
   public void mouseReleased(MouseEvent me){}
   public void mouseEntered(MouseEvent me){}
   public void mouseExited(MouseEvent me){}
 
   //key

   public void keyPressed(KeyEvent ke){
      if(ke.getKeyCode()== KeyEvent.VK_TAB)
      {
         System.out.println("tab pressed");
         tab(ke);
      }//if
   }//key pressed
   public void keyReleased(KeyEvent ke){}
   public void keyTyped(KeyEvent ke){}
   
   
   //
   String imName, imAge, imAddr;
  
   
         
         public void actionPerformed(ActionEvent ae){
      
     
      if(ae.getSource()==bu  )
      {
         if(r<0)
         {
            JOptionPane.showMessageDialog(this, "삭제할 행을 선택하시오.");
            return;
         }
         model.removeRow(r);
      }
      
      if(ae.getSource()==txName)
      {
         imName=txName.getText().trim();
         
         if(imName.equals("")||imName.length()<0 )
         {
            JOptionPane.showMessageDialog(this, "이름을 입력하시오");
            txName.requestFocus();
            return;
         }//in if 1
         
         txAge.requestFocus();//포커스 이동.
      
      
      }else if(ae.getSource()==txAge)
      {
         imAge=txAge.getText().trim();
         if(imAge.equals("")||imAge.length()<0)
         {
            JOptionPane.showMessageDialog(this, "나이를 입력하시오.");
            txAge.requestFocus();
            return;
         }//in if2
          
         txAddr.requestFocus();
      
      
      }else if( ae.getSource()==txAddr)
      {
         imAddr=txAddr.getText().trim();
         if(imAddr.equals("")||imAddr.length()<0)
         {
            JOptionPane.showMessageDialog(this, "주소를 입력하시오.");
            txAddr.requestFocus();
            return;
         }//in if3
         
         txName.requestFocus();
        
         //table 에 데이터 출력.
        
         Object temp[]={imName,imAge,imAddr};
         model.addRow(temp);
         txName.setText("");
         txAge.setText("");
         txAddr.setText("");
         
      }
      
      
   
      
   }//action end
   
   //custom method
   public void tab(KeyEvent ke){
      
      if( ke.getSource()== txName)
      {
         System.out.println("TX name Tab Call");
         imName=txName.getText().trim();
         
         if(imName.equals("")||imName.length()<0 )
         {
            JOptionPane.showMessageDialog(this, "이름을 입력하시오");
            txName.requestFocus();
            return;
         }//in if 1
         
         txAge.requestFocus();//포커스 이동.
         
         
      }else if(ke.getSource()== txAge)
      {
         System.out.println("TX AGE Tab Call");
         imAge=txAge.getText().trim();
         if(imAge.equals("")||imAge.length()<0)
         {
            JOptionPane.showMessageDialog(this, "나이를 입력하시오.");
            txAge.requestFocus();
            return;
         }//in if2
         
         txAddr.requestFocus();
         
         
      }else if( ke.getSource()== txAddr)
      {
         System.out.println("TX Addr Tab Call");
         imAddr=txAddr.getText().trim();
         if(imAddr.equals("")||imAddr.length()<0)
         {
            JOptionPane.showMessageDialog(this, "주소를 입력하시오.");
            txAddr.requestFocus();
            return;
         }//in if3
         
         txName.requestFocus();
         
         //table 에 데이터 출력.
         
         Object temp[]={imName,imAge,imAddr};
         model.addRow(temp);
         txName.setText("");
         txAge.setText("");
         txAddr.setText("");
         
      }
   }
   
   
   public static void main( String [] args ) 
   {
      new Test06_table();
   }// end main
   
}//class end.
