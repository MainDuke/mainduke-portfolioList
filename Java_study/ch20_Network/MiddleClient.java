
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
         Socket sock = new Socket(ip, port);//서버 접속.
         dis = new DataInputStream(sock.getInputStream());
         dos = new DataOutputStream(sock.getOutputStream());
         
      }
      catch(IOException e)
      {
         System.out.println("서버 접속 시랲... 서버 젖ㅁ검중...");
         System.exit(0);
      }
      
      //design + Event
      b1 = new JButton("종료", new ImageIcon("a1.gif"));
      b1.addActionListener(this);      
      
      b2 = new JButton("리스트 보기.", new ImageIcon("a2.gif"));
      b2.addActionListener(this);
      
      b3 = new JButton("색상지정", new ImageIcon("a3.gif"));
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
      
      
      //Frame 설정.
      setSize(400, 300);
      setVisible(true);
      
      tf.requestFocus(); // 포커스 설정.
      
      name= JOptionPane.showInputDialog(this, "대화명을 입력하세요.");
      
      thread = new Thread(this);
      thread.start(); //스레드 시작. >>> run() 호출.
      
   }//cons ================================================================
   
   
   public void run(){ //서버에서 보내준 데이터 처리 부분.
      try
      {
        while(true)
         {
         String line= dis.readUTF(); //서버로부터 받은 메세지.
         ta.append(line +"\n"); //메세지 출력.
         sbar.setValue(sbar.getMaximum()); //스크롤바 최대값 설정.
         }
      }
      catch(IOException ex)
      {
         ta.append("서버에서 데이터를 읽던 중 에러가 발생하였습니다.\n");
         ta.append("10초 후 종료.");
      
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
               JOptionPane.showMessageDialog(this,"대화를 입력하시오.");
               tf.requestFocus();
               return;
            }//if end
            
            dos.writeUTF("<<"+name+">>"+msg);
            tf.setText("");
            sbar.setValue(sbar.getMaximum());
                 
         }catch(Exception ex5){
            
            ta.append("서버에서 데이터를 읽던 중 에러가 발생하였습니다.\n");
            ta.append("10초 후 종료.");
            try
            {
             Thread.sleep(10000);
            }
            catch(InterruptedException ex){}
            
            System.exit(0);
         
         }//catch
      
      }//if end
   
      if(e.getSource()==b1)//종료
      {
         int ex=JOptionPane.showConfirmDialog(this,"종료할까요?","종료",JOptionPane.YES_NO_OPTION);
         
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
         System.out.println("입력에러 >> 용법 : java MiddleClient ip port");
         System.exit(0);
      
      }//if
      if(Integer.parseInt( args[1]) < 1024 )
      {
         System.out.println("포트 에러,용법: 1024보다 커야한다.");
         System.exit(0);
      }//if
      
      new MiddleClient(args[0], Integer.parseInt(args[1]));
      
      
   }// end main
   
}//class 
