/*
��������
���� ���� 100
�游��� 200
����� 210
�濡���޽��� 400
��ȭ�� ���� 420
�ӼӸ� 450
������ 290
���� 900
 */


import java.awt.*;
import javax.swing.table.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

import java.io.*;
import java.net.*;

class MainClient extends JFrame implements Runnable, ActionListener, MouseListener
{
   //vari
   Socket s;
   BufferedReader in;
   OutputStream out;
   
   String name, ip, title = "����"; //name>> ��ȭ��, host >ip;
   
   String [][]data1 = new String[0][2];
   String []cols1 = {"������", "�ο�"};
   
   String [][]data2 = new String[0][1];
   String []cols2 = {"��ȭ��"};
   
   String [][]data3 = new String[0][2];
   String []cols3 = {"��ȭ��", "��ġ"};
   
   DefaultTableModel model1= new DefaultTableModel(data1, cols1){
      public boolean isCellEditable(int row, int cols){
         return false;
      }
   };//DefaultTableModel end
   
   DefaultTableModel model2 = new DefaultTableModel(data2, cols2){
      public boolean isCellEditable(int row, int cols){
         return false;
      }
   };//model 2 end  
   DefaultTableModel model3 = new DefaultTableModel(data3, cols3){
      public boolean isCellEditable(int row, int cols){
         return false;
      }
   };
   
   JTable table1 = new JTable(model1);
   JTable table2 = new JTable(model2);
   JTable table3= new JTable(model3);
   
   JScrollPane waitroom = new JScrollPane(table1); //������ , �ο�
   JScrollPane roominfo = new JScrollPane(table2);//��ȭ��
   JScrollPane waitinfo = new JScrollPane(table3);//��ȭ��, ��ġ.
   
   JButton creatB = new JButton("�� �����");
   JButton roominB = new JButton("�� ����");
   JButton exitB = new JButton("��  ��");
   
   //�� Ŭ���̾�Ʈ ������ ������ ȣ��.
   RoomClient client = new RoomClient(); // *** ��ü ����.
   
   //cons---------------------------------------------------------------------------------cons
   public MainClient(String ip){
      
      setTitle("chat_Main");
      this.ip=ip; //host ip;
      
      table1.getTableHeader().setReorderingAllowed(false); //�� ���� ����.
      table2.getTableHeader().setReorderingAllowed(false); 
      table3.getTableHeader().setReorderingAllowed(false); 
      
      //���� ����.
      table1.getTableHeader().setBackground(new Color(255,207,96));
      table2.getTableHeader().setBackground(new Color(255,207,96));
      table3.getTableHeader().setBackground(new Color(255,207,96));
      
      //��ư �۾� ����.
      creatB.setFont(new Font("Dialog",Font.BOLD, 12));
      roominB.setFont(new Font("Dialog",Font.BOLD, 12));
      exitB.setFont(new Font("Dialog",Font.BOLD, 12));
      
      //������ ��ġ.
      getContentPane().setLayout(null);
      getContentPane().add(waitroom).setBounds(10,10,400,250); //x,y,w,h
      getContentPane().add(roominfo).setBounds(415,10,168,250); 
      getContentPane().add(waitinfo).setBounds(10,270,400,197);
      
      getContentPane().add(creatB).setBounds(449,300,100,30);
      getContentPane().add(roominB).setBounds(449,340,100,30);
      getContentPane().add(exitB).setBounds(449,380,100,30);
      //table1.setSelectonMode(0);
      
      name = JOptionPane.showInputDialog(null, "��ȭ�����Է��Ͻÿ�.","��ȭ���Է�",JOptionPane.YES_NO_OPTION);
      
      if(name == null || name.length() < 1)
      {
         return;
      }
      
      connectProcess(); // ����� ���� �޼��� ȣ��.
      setSize(600,550);
      setVisible(true);
      eventUp(); //����� ���� �޼��� ȣ��.
      
   }//MainClient cons end---------------------------------------------------cons
   
   //overriding=======================================================================
   //run()=======================================================================run
   public void run(){ //�������� ������ ������ ���.
      
      while(true)
      {
         try
         {
            String msg = in.readLine(); //�������� ������ ���� �޴´�.
            if(msg == null)
            {
               return;
            }
            
            StringTokenizer token = new StringTokenizer(msg, "|");
            int protocol = Integer.parseInt(token.nextToken());
            
            switch(protocol)
            {
            case 1000: {
                  System.out.println(msg);
                  JOptionPane.showMessageDialog(this, msg);
                  System.exit(0);
               }//case 1000 end
               break;
               
            case 2000 : {
                  System.out.println("case 2000 : "+msg);
               JOptionPane.showMessageDialog(this, msg);
            }
            break;
               
            case 100: {
                  
                  String ob[]={token.nextToken(), token.nextToken()};//��ȭ��,��ġ. 
                  model3.addRow(ob);
                  break;
                  
               }//case 100 end
               
            case 200:{ //�� �����.
                  String ob[]={token.nextToken(), token.nextToken()};
                  model1.addRow(ob);;
                  break;
               }
            case 210:{
                  String n=token.nextToken(); //��ȭ��.
                  String t=token.nextToken(); //���̸�.
                  
                  for(int i=0;i<model3.getRowCount();i++)
                  {
                     String temp=(String)model3.getValueAt(i,0); //��ȭ��.
                     
                     if(temp.equals(n))//��ȭ���� ã������
                     {
                        model3.setValueAt(t,i,1);
                        break; //for Ż��.
                     }//if
                  }//for end
                  
                  if(n.equals(name)){//�ڽ��� �� ����.
                     roomInProcess();
                     //if end   
                  }else if(t.equals(title)){//�ٸ� ��� ���ö�.
                     Object ob[]={n};
                     client.model1.addRow(ob);
                     client.inwon.setText(client.model1.getRowCount()+""); //�ο�����.
                     client.ta.append("*** ["+n+"] �� �� ���Խ��ϴ�.. ***\n");
                     
                  }//else if end
               }//case210 end
               break;
               
            case 290 :{//�泪����.
                  String n = token.nextToken(); //��ȭ��.
                  String t = token.nextToken(); //������.
                  
                  //�ο�����.
                  for(int i=0;i < model1.getRowCount();i++)
                  {
                     String temp= (String)model1.getValueAt(i,0);
                     if(t.equals(temp))
                     {
                        int inwon = Integer.parseInt(model1.getValueAt(i,1)+"");
                        
                        if(inwon == 0)
                        {
                           model1.removeRow(i); //�� ����.
                        }else{
                           model1.setValueAt(--inwon + "",i,1); //�ο� ����.
                        }
                        break;//for Ż��.
                     }//if ed
                  }//for ed �ο�����.
                  
                  //model3 ��ġ ���� (��ȭ�� ==> ����)
                  for(int i=0;i < model3.getRowCount();i++)
                  {
                     String temp=(String)model3.getValueAt(i,0); //��ȭ��
                     
                     if(n.equals(temp))//��ȭ���� ��ġ�ϸ�
                     {
                        model3.setValueAt("����",i,1);
                        break;
                     }//if ed
                  }//for end ��ġ ����.
                  
                  if(n.equals(name))//���� ��ȭ�濡�� ������.
                  {roomOutProcess(); //�޼��� ȣ��.
                  }//if name ed
                  
                  if(n.equals(title))//�ٸ� ����� ������.
                  {
                     for(int i=0;i<client.model1.getRowCount();i++) 
                     {
                        String temp = (String) client.model1.getValueAt(i,0); //��ȭ�� �ޱ�.
                        
                        if(temp.equals(n))
                        {
                           client.model1.removeRow(i); //������� ����.
                           break; //Ż��.
                        }//if
                        
                     }//for
                     
                     
                     client.inwon.setText(client.model1.getRowCount()+"");//�ο�����.
                     client.ta.append("***[ "+n+"] ���� �����Ͽ����ϴ�. ***\n");
                  }//if title ed
               }  //case 290 end 
               break;
               
            case 400 : //��ȭ�ϱ�.
               {
                  client.ta.append(" "+token.nextToken()+"\n");
               }//case 400 end
               break;
               
            case 420 : //��ȭ�� ����.
               {
                  String oldN = token.nextToken(); //�����̸�.
                  String newN = token.nextToken(); //�� �̸�.
                  String t = token.nextToken(); //��ġ.
                  
                  //model3 �� �� �̸����� ����.
                  for(int i=0;i<model3.getRowCount();i++)
                  {
                     String N=(String)model3.getValueAt(i,0);
                     if(oldN.equals(N))
                     {
                        model3.setValueAt(newN, i, 0); //���ο� ��ȭ������ ����.
                        break; //for Ż��.
                     }//if oldN end.
                     
                  }//for end.
                  
                  if(t.equals(title)) //��ȭ�濡�� ��ȭ�� ����.
                  {
                     for(int i=0;i<client.model1.getRowCount();i++)
                     {
                        String N=(String)client.model1.getValueAt(i,0);//��ȭ�� ���.
                        if(oldN.equals(N))
                        {
                           client.model1.setValueAt(newN,i,0); //���̸����� ����.
                           break;
                        }//if
                     }//for end
                     client.ta.append(" *** ["+oldN+"] ���� ��ȭ���� ["+newN+"]���� �ٲ�����ϴ�.\n");
                  }//if t-title end
                  
                  if(oldN.equals(name))
                  {   name = newN;}//if ed
                  
               }//case 420 end
               break;
               
               
            case 450 : //�ӼӸ�.
               {
                  String n =token.nextToken();
                  String str=token.nextToken();
                  client.ta.append("�ӼӸ�(from)"+n+">>"+str+"\n");
                  
               }//case 450 end.
               break;
            
            case 900 : //����.
               {                  
                  String n =token.nextToken();
                  String t=token.nextToken();
                  
                  for(int i=0;i<model3.getRowCount();i++)
                  {
                     String temp=(String)model3.getValueAt(i,0); //��ȭ��.
                     if(temp.equals(n))//��ȭ���� ��ġ�ϸ�
                     {
                        model3.removeRow(i);
                        break;
                     }//if
                 }//for
               
                if(!t.equals("����")){//��ȭ���߿� ������.
  
                  for(int i=0;i < model1.getRowCount();i++)
                  {
                     String temp=(String)model1.getValueAt(i,0); //������     
                     
                     if(temp.equals(t))//���� ã�Ƽ� ������ �ο� ����.
                     {
                     int a = Integer.parseInt(model1.getValueAt(i,1).toString());//�ο�����.
                        
                     
                     if(--a == 0)
                     {
                        model1.removeRow(i); //�ƹ��� ������ �� ����.
                        
                     }else{
                        model1.setValueAt(a+"",i,1);//�ο� ����
                     }
                     break;//for Ż��.
                      }//if
                  }//for end
                  }//if end
                  
                 if(t.equals(title))//��ȭ�濡�� �ٸ� ����� �������.
                  {
                     for(int i=0;i<client.model1.getRowCount();i++)
                     {
                        String temp=(String)client.model1.getValueAt(i, 0); //��ȭ�� ���.
                        
                        if(temp.equals(n))
                        {
                           client.model1.removeRow(i);
                           break;//for Ż��.
                        }//if
                     }//for
                     client.inwon.setText(client.model1.getRowCount()+""); //�ο� ����.
                     client.ta.append("*** ["+n+"] ���� ���� �Ͽ����ϴ�. ");
                  
                  }//if3 end
                  
                  
                  
               }//case 900 end
               
            
            
            
            
            }//switch end
            
         }catch(Exception ex)
         {
            System.out.println("���� ���� ����.");
            return;
         }//try, catch End
         
      }//while
      
   }//run() end=======================================================================run end
   
   //mouse event
   public void mousePressed(MouseEvent me){
      
      model2.setRowCount(0); //���̺� ���� ��� ����.
      int r = table1.getSelectedRow();
      String temp = (String)model1.getValueAt(r,0); //model1 �������� ���,
      
      for(int i=0;i<model3.getRowCount();i++)
      {
         String roomt=(String)model3.getValueAt(i,1); //model3 ������ �� ����.
         if(temp.equals(roomt))//�������� ������.
         {
            Object ob[]={model3.getValueAt(i,0)}; //model3 ���� ��ȭ���� ��.
            model2.addRow(ob);//model2�� �־��ش�.
         }//if
      }//for
      
   }//mousePressed end
   
   public void mouseClicked(MouseEvent me){}
   public void mouseReleased(MouseEvent me){}
   public void mouseEntered(MouseEvent me){}
   public void mouseExited(MouseEvent me){}
   
   //actionPerformed
   public void actionPerformed(ActionEvent ae){//������ ��û�� �ϴµ�.
      
      Object ob= ae.getSource();
      
      if(ob == creatB) //�游���.
      {
         title = JOptionPane.showInputDialog(this, "�� ���� �Է� �Ͻÿ�.");
         if(title == null || title.length()<1)
         {
            return;
         }//inner if end
         
         try
         {
            System.out.println("�游��� ��û Ʈ����");
            out.write(("200|"+title+"\r\n").getBytes()); //������ ��û.  
         }catch(Exception ex){}
      }//if 1 end -------------------------------------------------------
      
      if(ob == roominB)//�����.
      {
         int row=table1.getSelectedRow();
         if(row<0)
         {
            JOptionPane.showMessageDialog(this, "���� ���� �����Ͻÿ�.");
            return;
         }//inner if end
         
         title=(model1.getValueAt(row, 0)).toString(); //���̸� ���.
         
         try
         {
            out.write(("210|"+title+"\r\n").getBytes());//������ ������.  
         }catch(Exception ex){}
         
      }//if2 end---------------------------------------------------------
      
      if(ob == client.tf)//��ȭ�ϱ�.
      {
         String msg= client.tf.getText().trim();
         System.out.println("client.tf");
         if(msg.length()<1)
         {
            return;
         }//if.
         
         try
         {
            out.write(("400|"+msg+"\n").getBytes());//������ ����.
         }catch(Exception ex){}
         client.tf.setText("");
      }//if3 end.
      
      if(ob == client.outB)//�� ������.
      {
         try
         {
            out.write(("290|\r\n").getBytes());//������ ������.  
         }catch(Exception ex){}
         title = "����"; 
      }//if4 end
      
      if(ob == client.nickB)//��ȭ�� ����.
      {
         String n= JOptionPane.showInputDialog(client, "������ ��ȭ���� �Է��ϼ���.","��ȭ�� �Է�");
        
         
        for(int i = 0;i<client.model1.getRowCount();i++) 
         {
            String nn = (String)client.model1.getValueAt(i,0);
            if(n.equals(nn))
            {
               JOptionPane.showMessageDialog(this, "������� ��ȭ�� �Դϴ�.");
               
               return;
            }//if ed
         }//for
         
         if(n == null ||n.length()<1)
         {
            return;
         }//inner if ed
         try
         {
            out.write(("420|"+n+"\r\n").getBytes());  
         }catch(Exception ex){}
      }//if5 end
      
      if(ob == client.sayB)
      {
         int row = client.table1.getSelectedRow(); //�� ����.
         if(row < 0)
         {
            JOptionPane.showMessageDialog(client,"�ӼӸ��� ���� ��븦 �����Ͻÿ�.");
            return;
         }//inner if ed
         
         //�ӼӸ� ���� ������� �̸��� ��.
         String sayN=(client.model1.getValueAt(row,0)).toString();
         String say=JOptionPane.showInputDialog(client, "�ӼӸ��� �Է��Ͻÿ�.");
         if(say == null || say.length()<1)
         {  return;         }//if end
         try
         {
            //���濡�� ������,
            out.write(("450|"+sayN+"|"+"\r\n").getBytes());
            //�ڽ��� ��ȭâ�� �Ѹ���.
            client.ta.append("[�ӼӸ�(to)]"+sayN+">> : "+say+"\n");
         }catch(Exception ex){}
      }//if6 end
      
      if(ob == exitB)
      {
         closeProcess();
      System.exit(0);
      
      }//if 7 end
      
      
   }//actionPerformed end=================================Over end
   
   //custom----------------------------------------------------------------------------
   public void eventUp(){
      creatB.addActionListener(this);
      roominB.addActionListener(this);
      exitB.addActionListener(this);
      
      table1.addMouseListener(this);
      
      client.tf.addActionListener(this);
      client.nickB.addActionListener(this);
      client.sayB.addActionListener(this);
      client.outB.addActionListener(this);
   }//eventUp() end
   
   
   //���� ����
   public void connectProcess() //����� ���� �޼���.
   {
      
      try{
         s= new Socket(ip, 7788);
         in = new BufferedReader(new InputStreamReader(s.getInputStream()));
         out = s.getOutputStream();
         
         out.write((name+"\r\n").getBytes()); //������ ����.
         new Thread(this).start(); //����, run() ȣ��.
         
      }catch(Exception ex){
         System.out.println("���� ���� ����!");     
         
      }  
   }// connetProcess end
   
   //custom ------------//���� ���μ���.
   public void closeProcess(){
      try
      {
         client.setVisible(false);
         client.dispose();
         out.write(("900|\r\n").getBytes()); //������ ��û.
         
         s.close();
         in.close();
         out.close();
         
      }catch(Exception ex){}
      
   }//closeProcess end
   
   //custom //�濡�� ���� �������
   public void roomOutProcess(){
      
      client.ta.setText(""); //��ȭ ����.
      client.inwon.setText(""); //�ο� ����.
      
      
      //model1. getRowCount(); //��ü ������ ��´�.
      for(int i=0;i<client.model1.getRowCount();i++)
      {
         client.model1.removeRow(0); //��ȭ���� ��� ����.
      }//for
      
      client.model1.setRowCount(0); //��ȭ���� ��� ����.
      
      int a=client.model1.getRowCount();
      client.inwon.setText(a+"");
      client.setVisible(false); //��ȭâ �Ⱥ��̰�.
      creatB.setEnabled(true);//��ư Ȱ��ȭ.
      roominB.setEnabled(true);// ��ư Ȱ��ȭ
      
   }//roomOutProcess end
   
   //custom //���� �濡 ����.
   public void roomInProcess(){
      
      client.setVisible(true);
      client.ta.append("*** [" + title + "] �濡 �����ϼ̽��ϴ�. ***\n");
      
      for(int i=0;i<model3.getRowCount();i++)
      {
         String temp = (String)model3.getValueAt(i,1); //����ġ ��.
         
         if(temp.equals(title))
         {
            Object ob[]={model3.getValueAt(i,0)}; //��ȭ���� ������.
            client.model1.addRow(ob); //��ȭ���� ��ȭâ�� ���.
         }//if
      }//for
      
      client.inwon.setText(client.model1.getRowCount()+"");
      roominB.setEnabled(false);
      creatB.setEnabled(false);
      
   }//roomInProcess end-------------------custom end---------------------------------------------------
   
   
   
   //Main-----------------------------------------------
   public static void main( String [] args ) 
   {
      new MainClient(args[0]); //������ ���� IP 
   }// end main
   
   
   
   
}//MainClient class end
