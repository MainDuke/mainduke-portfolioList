import java.io.*;
import java.net.*;
import java.awt.*;
import java.util.*; //vector, Enumeration.


class MiddleServer extends Frame
{
   
   //vari
	public TextArea ta; //����.
   
   public MiddleServer(){
      
      setTitle("ä�ù� ������.");
     ta = new TextArea(100,50);
      
      this.setFont(new Font("Dialog", Font.BOLD, 20));
      add("Center", ta);
      ta.setEditable(false);
   
   
   }//cons end
   
   //over
   
   
 
   
   public static void main( String [] args ) 
   {
      if(args.length != 1)//port
      {
            System.out.println("�Է¿���.. ��� > java Server ��Ʈ ��ȣ");
            
            //													dos>java Server 7788
            System.exit(0);
            
         }//if
      if(Integer.parseInt(args[0]) < 1024)
      {
         System.out.println("�Է¿���.. ��Ʈ ��ȣ�� 1024 �̻����� �����ÿ�.");
         System.exit(0);
      }//if
      
      System.out.println("main1");
      MiddleServer f = new MiddleServer();
      
      f.setSize(400,300);
      f.setVisible(true);
      
      int i=1; //������ �ο�.
         
      System.out.println("main2");
         try
         {
          ServerSocket s = new ServerSocket(Integer.parseInt(args[0])); 
         //��Ʈ ��ȣ.
         System.out.println("���� ������.");
            
         
            while(true)
            {
               Socket sock = s.accept(); //Ŭ���̾�Ʈ ������ �޾Ƶ鸲.
               f.ta.append(i+" ��° �մ��� �湮 �Ͽ����ϴ�. \t\t"+sock+"\n");
               
               new Handler(sock, i, f.ta).start(); //��ü ����().start() >> run();
               i++;  
               }//while end
         }catch(IOException ex){}
      
      
   }// end main
   


}//class

//-----------------------------------------------
class Handler extends Thread{
   //vari
   private int number; //�ο���.
   static private Vector vec = new Vector();
   private TextArea ta;
   
   private Socket sock;
   private DataInputStream in;
   private DataOutputStream out;  

   public Handler( Socket s, int temp , TextArea t) throws IOException
   {
      System.out.println("handler");
      sock = s;
      number = temp;
      ta= t;
      
      in = new DataInputStream(sock.getInputStream());
      out = new DataOutputStream(sock.getOutputStream());
      
   }//cons end.

   public void run(){ //����, ����.
      try
      {
         vec.add(this);
         while(true)
         {
            String msg= in.readUTF(); //Ŭ���̾�Ʈ�� ������ ��ȭ���� �޾�.
            toMessage(msg); //�޼��� ȣ��. ��� Ŭ���̾�Ʈ���� ������.
            
            
         }//while end
      }
      catch(IOException ie){
         ta.append( number + " ��° �մ��� ����Ͽ����ϴ�.\n");
         toMessage( number + " ��° �մ��� ����Ͽ����ϴ�.\n");
         vec.remove(this); // ���� ����.
      }
      try
      {
         sock.close();
         
      }
      catch(IOException ioe)
      {System.out.println("������ �ݴ� �߿� ����."+ioe);}
      
   } //run end
 
   //custom //
   
   public void toMessage(String msg){
      synchronized(vec){
         Enumeration e = vec.elements();
         while(e.hasMoreElements())
         {
            Handler temp = (Handler)e.nextElement();
            try
            {
               temp.out.writeUTF(msg);  
            }
            catch(IOException ioe)
            {
               try{
                  sock.close(); //���� �ݰ�.
               }catch(IOException io2){
                  io2.printStackTrace();
               }
               System.out.println("�޼��� �Ѹ��� �� ���� �߻� : "+ioe);
            }
         }//while
      }//synchro end
   }//toMessage
   
}
