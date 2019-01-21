
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;
import java.io.*;
import java.util.*; //Vector


class MiddleClient extends JFrame implements ActionListener, Runnable
{
   
   //vari
   
   JButton b1,b2,b3;
   JTextField tf;
   JTextArea ta;
   String name;
   
   private DataInputStream dis;
   private DataOutputStream dos;
   private Thread thread;
   
   JScrollBar sbar;
   JScrollPane spane;
   
   //cons 
   public MiddleClient(String ip,int port){
      try
      {
         Socket sock = new Socket(ip, port);//���� ����.
         dis = new DataInputStream(sock.getInputStream());
         dos = new DataOutputStream(sock.getOutputStream());
         
      }
      catch(IOException e)
      {
         System.out.println("���� ���� �ÎN... ���� ��������...");
         System.exit(0);
      }
      
      //design + Event
      b1 = new JButton("����", new ImageIcon("a1.gif"));
      b1.addActionListener(this);      
      
      b2 = new JButton("����Ʈ ����.", new ImageIcon("a2.gif"));
      b2.addActionListener(this);
      
      b3 = new JButton("��������", new ImageIcon("a3.gif"));
      b3.addActionListener(this);
      
      tf = new JTextField();
      tf.addActionListener(this); 
      
      ta = new JTextArea();
      
      JPanel p = new JPanel();
      p.setLayout(new GridLayout(3,1));
      p.add(b1);
      p.add(b2);
      p.add(b3);
      
      ta.setEditable(false);
      spane = new JScrollPane(ta);
      sbar = spane.getVerticalScrollBar(); //
      sbar.setValue(sbar.getMaximum());
      
      getContentPane().add("East", p);
      getContentPane().add("Center", spane);
      getContentPane().add("South", tf);
      
      
      //Frame ����.
      setSize(400, 300);
      setVisible(true);
      
      tf.requestFocus(); // ��Ŀ�� ����.
      
      name= JOptionPane.showInputDialog(this, "��ȭ���� �Է��ϼ���.");
      
      thread = new Thread(this);
      thread.start(); //������ ����. >>> run() ȣ��.
      
   }//cons ================================================================
   
   
   public void run(){ //�������� ������ ������ ó�� �κ�.
      try
      {
        while(true)
         {
         String line= dis.readUTF(); //�����κ��� ���� �޼���.
         ta.append(line +"\n"); //�޼��� ���.
         sbar.setValue(sbar.getMaximum()); //��ũ�ѹ� �ִ밪 ����.
         }
      }
      catch(IOException ex)
      {
         ta.append("�������� �����͸� �д� �� ������ �߻��Ͽ����ϴ�.\n");
         ta.append("10�� �� ����.");
      
         try
         {
          Thread.sleep(10000);  
         }
         catch(InterruptedException e){}
         
         System.exit(0);
      
      }
   }//run end
   
   public void actionPerformed(ActionEvent e){
      if(e.getSource() == tf)
      {
         try
         {
            String msg = tf.getText().trim();
            if( msg.length() < 0){
               JOptionPane.showMessageDialog(this,"��ȭ�� �Է��Ͻÿ�.");
               tf.requestFocus();
               return;
            }//if end
            
            dos.writeUTF("<<"+name+">>"+msg);
            tf.setText("");
            sbar.setValue(sbar.getMaximum());
                 
         }catch(Exception ex5){
            
            ta.append("�������� �����͸� �д� �� ������ �߻��Ͽ����ϴ�.\n");
            ta.append("10�� �� ����.");
            try
            {
             Thread.sleep(10000);
            }
            catch(InterruptedException ex){}
            
            System.exit(0);
         
         }//catch
      
      }//if end
   
      if(e.getSource()==b1)//����
      {
         int ex=JOptionPane.showConfirmDialog(this,"�����ұ��?","����",JOptionPane.YES_NO_OPTION);
         
         switch(ex)
         {
         case JOptionPane.YES_OPTION : System.exit(0);
         case JOptionPane.NO_OPTION : break;
         }//switch
         
      }//if2 end
      
      if(e.getSource() == b2){
      
         ta.setText("");
         ta.append(name+"\n");
         
      }
      
      if(e.getSource() == b3)
      {
         ta.setForeground(Color.blue);
         ta.setBackground(Color.pink);
           
      }//if
      
   }//action end

   
   
   public static void main( String [] args ) 
   {
      if(args.length != 2)
      {
         System.out.println("�Է¿��� >> ��� : java MiddleClient ip port");
         System.exit(0);
      
      }//if
      if(Integer.parseInt( args[1]) < 1024 )
      {
         System.out.println("��Ʈ ����,���: 1024���� Ŀ���Ѵ�.");
         System.exit(0);
      }//if
      
      new MiddleClient(args[0], Integer.parseInt(args[1]));
      
      
   }// end main
   
}//class 
