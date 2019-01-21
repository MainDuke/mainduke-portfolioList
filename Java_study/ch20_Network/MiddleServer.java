import java.io.*;
import java.net.*;
import java.awt.*;
import java.util.*; //vector, Enumeration.


class MiddleServer extends Frame
{
   
   //vari
	public TextArea ta; //변수.
   
   public MiddleServer(){
      
      setTitle("채팅방 관리자.");
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
            System.out.println("입력에러.. 용법 > java Server 포트 번호");
            
            //													dos>java Server 7788
            System.exit(0);
            
         }//if
      if(Integer.parseInt(args[0]) < 1024)
      {
         System.out.println("입력에서.. 포트 번호는 1024 이상으로 넣으시오.");
         System.exit(0);
      }//if
      
      System.out.println("main1");
      MiddleServer f = new MiddleServer();
      
      f.setSize(400,300);
      f.setVisible(true);
      
      int i=1; //접속한 인원.
         
      System.out.println("main2");
         try
         {
          ServerSocket s = new ServerSocket(Integer.parseInt(args[0])); 
         //포트 번호.
         System.out.println("서버 구동중.");
            
         
            while(true)
            {
               Socket sock = s.accept(); //클라이언트 접속을 받아들림.
               f.ta.append(i+" 번째 손님이 방문 하였습니다. \t\t"+sock+"\n");
               
               new Handler(sock, i, f.ta).start(); //객체 생성().start() >> run();
               i++;  
               }//while end
         }catch(IOException ex){}
      
      
   }// end main
   


}//class

//-----------------------------------------------
class Handler extends Thread{
   //vari
   private int number; //인원수.
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

   public void run(){ //서비스, 오버.
      try
      {
         vec.add(this);
         while(true)
         {
            String msg= in.readUTF(); //클라이언트가 보내준 대화내용 받아.
            toMessage(msg); //메서드 호출. 모든 클라이언트에게 보내기.
            
            
         }//while end
      }
      catch(IOException ie){
         ta.append( number + " 번째 손님이 퇴실하였습니다.\n");
         toMessage( number + " 번째 손님이 퇴실하였습니다.\n");
         vec.remove(this); // 벡터 제거.
      }
      try
      {
         sock.close();
         
      }
      catch(IOException ioe)
      {System.out.println("소켓을 닫는 중에 에러."+ioe);}
      
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
                  sock.close(); //소켓 닫고.
               }catch(IOException io2){
                  io2.printStackTrace();
               }
               System.out.println("메세지 뿌리던 중 에러 발생 : "+ioe);
            }
         }//while
      }//synchro end
   }//toMessage
   
}
