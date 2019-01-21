/*
 * Author: Administrator
 * Created: 2016�� 2�� 16�� ȭ���� ���� 10:41:06
 * Modified: 2016�� 2�� 16�� ȭ���� ���� 10:41:06
 */

//ȸ�� ���� â.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

class Test08_tab extends JFrame implements ActionListener
{
	//vari
   JButton b1,b2;
   JTabbedPane tab;
   JLabel la1,la2,la3;
   JTextField tf1,tf2;
   JRadioButton ra1, ra2;
   ButtonGroup group;
   JPanel p1,p2;
   DefaultTableModel model;
   JTable table;
   JScrollPane pane;
   
   //cons
   public Test08_tab(){
      tab = new JTabbedPane();
      p1= new JPanel();
      p2= new JPanel();
      la1 = new JLabel("ID",JLabel.RIGHT);
      la2 = new JLabel("��ȭ��",JLabel.RIGHT);
      la3 = new JLabel("����",JLabel.RIGHT);
      
      ra1 = new JRadioButton("����");
      ra2 = new JRadioButton("����");
      group= new ButtonGroup();
      group.add(ra1);
      group.add(ra2);
      
      String col[]={"ID", "��ȭ��", "����"};
      String data[][]= new String[0][3]; //�� ��
      
     
      model = new DefaultTableModel(data, col);
      table = new JTable(model);
       pane = new JScrollPane(table);
         
      table.getTableHeader().setReorderingAllowed(false);
      table.getTableHeader().setResizingAllowed(false);
      table.getTableHeader().setBackground(Color.white);

      tf1= new JTextField();
      tf2= new JTextField();

      b1= new JButton("Ȯ��");
      b2= new JButton("���");
      
      p1.setLayout(null);
      p2.setLayout(new BorderLayout());
      
      
      la1.setBounds(20,30,100,30);
      tf1.setBounds(130,30,150,30);
      
      la2.setBounds(20,70,100,30);
      tf2.setBounds(130,70,150,30);
      
      la3.setBounds(20,110,100,30);
      ra1.setBounds(130,110,70,30);
      ra2.setBounds(210,110,70,30);
            
      b1.setBounds(35,150,100,30);
      b2.setBounds(145,150,150,30);
      
      p1.add(la1);
      p1.add(tf1);
      
      p1.add(la2);
      p1.add(tf2);
      
      p1.add(la3);
      p1.add(ra1);
      p1.add(ra2);
      
      p1.add(b1);
      p1.add(b2);
      
      p2.add("Center", pane);
      
      tab.addTab("�α���", null,p1,"�α���");
      tab.addTab("��������", null, p2, "����");
      
      this.getContentPane().add("Center", tab);
      
      //�̺�Ʈ ���.
      b1.addActionListener(this);
      b2.addActionListener(this);
      
      setVisible(true);
      setSize(430, 260);
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      
   }//cons end

   //over
   public void actionPerformed(ActionEvent e){
      
      if(e.getSource()==b1)
      {
         String id=tf1.getText().trim();
         if(id.length()<1)
         {
            JOptionPane.showMessageDialog(this, "ID�� �Է��Ͻÿ�.");
            tf1.requestFocus();
            return;
         }//if
      String name=tf2.getText().trim();
      if(name.length()<1)
      {
         JOptionPane.showMessageDialog(this, "Name�� �Է��Ͻÿ�.");
         tf2.requestFocus();
         return;
      }//if
      
      String sex="";
      if(ra1.isSelected())
      {
         sex="����";
      }else if(ra2.isSelected()){
         sex="����";
      }else{
         JOptionPane.showMessageDialog(this, "������ �Է��Ͻÿ�.");
         return;
         
      }
      
      String im[]={id, name, sex};
      model.addRow(im);
      tab.setSelectedComponent(p2); //p2 ������Ʈ ����.
      
      
      }//if
      
      
   }//action end
   
   public static void main( String [] args ) 
   {
      new Test08_tab();
      
   }// end main
   
}//class end
