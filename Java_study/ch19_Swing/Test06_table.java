/*
ch19_swing �����׿� tab ���丮�� �����.

 */




import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*; //DefaultTableModel : ���߰� /����

class Test06_table extends JFrame implements ActionListener, MouseListener, KeyListener
{
   //vari
   JPanel panel;
   JLabel laName, laAge, laAddr;
   JTextField txName, txAge,txAddr;
  
   Object ob[][]=new Object[0][3]; //0�� 3��.
   String title[]={"�̸�","����","�ּ�"};
   
   DefaultTableModel model = new DefaultTableModel(ob, title)
   {
      //�� ���� ���ϰ� �ϸ�, table ��Ŭ�� ������.
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
      laName=new JLabel("�̸�",JLabel.RIGHT);
      laAge=new JLabel("����",JLabel.RIGHT);
      laAddr=new JLabel("�ּ�",JLabel.RIGHT);
      
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
      
      
      
      bu = new JButton("���̺� ���� ����.");
      
      
      //�׼� �̺�Ʈ.
      bu.addActionListener(this);
      txName.addActionListener(this);
      txAge.addActionListener(this);
      txAddr.addActionListener(this);
      
      //���콺 ���
      table.addMouseListener(this);
    
      //Ŭ������ �����ؼ� Ű �̺�Ʈ�� ���
      
      txName.setFocusTraversalKeysEnabled(false); //Tab Ű�� Ű�̵� ���ϰ���.
      txAddr.setFocusTraversalKeysEnabled(false); 
      txAge.setFocusTraversalKeysEnabled(false); 
      
      txAddr.addKeyListener(this);
      txAge.addKeyListener(this);
      txName.addKeyListener(this);
    
           
    
      
      
      //�ǳ� ��ġ.
      getContentPane().add("North", panel);
      getContentPane().add("Center", pane);
      getContentPane().add("South", bu);
      
      setSize(300,300);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   String name="",age="",addr="" ; //����.
   int r= -1;
   
   
   public void mouseClicked(MouseEvent m){
     
      r =table.getSelectedRow();
      
      if(m.getClickCount() == 2)
      {
      //model.removeRow(table.getSelectedRow()); //������.
    
      
      r=table.getSelectedRow(); 
      name=(String)table.getValueAt(r,0);
      age=(String)table.getValueAt(r,1);
      addr=(String)table.getValueAt(r,2);
      
      
      txName.setText(name); //���̺��� ���� �����͸� tdName�� ǥ��.
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
            JOptionPane.showMessageDialog(this, "������ ���� �����Ͻÿ�.");
            return;
         }
         model.removeRow(r);
      }
      
      if(ae.getSource()==txName)
      {
         imName=txName.getText().trim();
         
         if(imName.equals("")||imName.length()<0 )
         {
            JOptionPane.showMessageDialog(this, "�̸��� �Է��Ͻÿ�");
            txName.requestFocus();
            return;
         }//in if 1
         
         txAge.requestFocus();//��Ŀ�� �̵�.
      
      
      }else if(ae.getSource()==txAge)
      {
         imAge=txAge.getText().trim();
         if(imAge.equals("")||imAge.length()<0)
         {
            JOptionPane.showMessageDialog(this, "���̸� �Է��Ͻÿ�.");
            txAge.requestFocus();
            return;
         }//in if2
          
         txAddr.requestFocus();
      
      
      }else if( ae.getSource()==txAddr)
      {
         imAddr=txAddr.getText().trim();
         if(imAddr.equals("")||imAddr.length()<0)
         {
            JOptionPane.showMessageDialog(this, "�ּҸ� �Է��Ͻÿ�.");
            txAddr.requestFocus();
            return;
         }//in if3
         
         txName.requestFocus();
        
         //table �� ������ ���.
        
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
            JOptionPane.showMessageDialog(this, "�̸��� �Է��Ͻÿ�");
            txName.requestFocus();
            return;
         }//in if 1
         
         txAge.requestFocus();//��Ŀ�� �̵�.
         
         
      }else if(ke.getSource()== txAge)
      {
         System.out.println("TX AGE Tab Call");
         imAge=txAge.getText().trim();
         if(imAge.equals("")||imAge.length()<0)
         {
            JOptionPane.showMessageDialog(this, "���̸� �Է��Ͻÿ�.");
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
            JOptionPane.showMessageDialog(this, "�ּҸ� �Է��Ͻÿ�.");
            txAddr.requestFocus();
            return;
         }//in if3
         
         txName.requestFocus();
         
         //table �� ������ ���.
         
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
