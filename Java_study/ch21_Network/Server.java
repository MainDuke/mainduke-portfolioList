/*
��������
������� �г����� ������, 1000
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
import java.util.*;
import java.net.*;
import java.io.*;


public class Server extends Frame implements Runnable
{
   
   //vari
   Vector globalvc = new Vector(); //�����ϴ� ��� Ŭ���̾�Ʈ ���� ����.
   Vector roomvc = new Vector(); //���̸� ��������
   TextArea ta = new TextArea(); //���� ���� ����Ϸ���.
   
   //cons
   
   public Server(){
      ta.setFont(new Font("Dialog", Font.BOLD, 20));
      add("Center", ta);
      setSize(500,300);
      setVisible(true);
      
   }//cons end
   
   public static void main( String [] args ) 
   {
      new Thread(new Server()).start();//����, run() ȣ��.
   }// end main
   
   public void run(){
      ServerSocket ss= null;
      try
      {
         ss = new ServerSocket(7788); //���� ����. 0~65535
         
         System.out.println("���� ������.");
         
         
      }
      catch(Exception e)
      {
         ta.append("�������� ����.");
         System.exit(0);
         
      }
      
      ta.append(" ���� ����Ǿ���, Ŭ���̾�Ʈ ������ ��ٸ�����.. \n");
      Socket s = null;
      
      while(true)
      {
         try
         {
            s = ss.accept(); // Ŭ���̾�Ʈ ��û �ް�, ���� ����.
            ta.append("client ���� : "+s+"\n");
            Service ser =new Service(s); //��ü ����.
            
         }
         catch(Exception e)
         {
            
         }
      }//while end
      
   }//run end---------------------------------------------------
   
   //inner class 
   class Service extends Thread{
      //vari
      
      BufferedReader in;
      OutputStream out;
      Room myroom = new Room(); //Ŭ���̾�Ʈ 1��� Room����, ����.
      String name = "" ; //��ȭ�� ����.
      
      //cons-----------------------------------------------------------------------
      public Service(Socket s){
         
         try{
            
            
            out = s.getOutputStream();
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
           
            
            name = in.readLine();
            myroom.title = "����";
            
            //String s3 = s.getInetAddress().getHostAddress(); //ip���.
            
            /*
             */
         }catch(Exception ex){
            ta.append("client�� ���� �Ҿ���"+s+"\n");
         }//try 1 end
          
         
         //��� Ŭ���̾�Ʈ���� , ���� �����ڸ� ������.
            for(int i=0;i< globalvc.size();i++)
            {
               try
               {
                  Service ser = (Service)globalvc.get(i);
                  if(name.equals(ser.name))
                  {
                     putMsgTo("1000|"+name+"�� ������� ��ȭ���Դϴ�.");
                     return;
                  }//if
                  //Ŭ���̾�Ʈ �鿡�� ������.
                  putMsgTo("100|"+ser.name+"|"+ser.myroom.title);
                  
               }catch(Exception ex2)
               {
                  globalvc.remove(i--);
               }
            }//for end
            
            //���� ���� �̸��� ���� ������... ������ ã�ƾ� ��.
            //���� �����ڿ��� ������ �������� ������.
            for(int i=0;i<roomvc.size();i++)   
            {
               Room r = (Room)roomvc.get(i);
               try
               {
                  putMsgTo("200|"+r.title+"|"+r.inwon);
                  
               }catch(Exception e){}
               
            }//for end
            
            globalvc.add(this);
            putMsgAll("100|"+name+"|"+myroom.title); //�����ڰ� ���ǿ� �������� Ŭ���̾�Ʈ���� �˸���.
            start(); // ����. run ȣ��.
         
         
      }//Service cons end---------------------------------------
      
      public void run(){
         
         while(true)
         {
            try
            {
               //vari
               String msg = in.readLine();
               if(msg == null)
               {
                  return;
               }//if
               
               StringTokenizer token = new StringTokenizer(msg,"|");
               int protocol = Integer.parseInt(token.nextToken());
               
               switch(protocol)
               {
               case 200:	{
                     
                     String t = token.nextToken(); //������.
                     String flag = "";
                     
                     for(int i=0;i<roomvc.size();i++)
                     {
                        Room r = (Room)roomvc.get(i); //���̸� ������.
                        
                        if(t.equals(r.title))
                        {
                           putMsgTo("2000|"+t+" �� ������� ��ȭ�� �Դϴ�.");
                           flag= t;
                           break; //for Ż��.
                        }//if
                       }//for
                     if(!flag.equals(t)){
                     
                     //�� �����
                     myroom = new Room(t, name,1);
                     myroom.uservec.add(this); //��ȭ�濡 ����.
                     roomvc.add(myroom);//���̸� ����.
                     putMsgAll("200|"+myroom.title+"|"+0);// ���� ���� �Ǿ���.
                     putMsgAll("210|"+name+"|"+myroom.title); //�濡 ���Դٴ�
                 
                  }//if 
                  
                  
                  }//case 200 end
                  break;
                  
               case 210:{//�����
                     String t= token.nextToken(); //������
                     
                     for(int i=0; i<roomvc.size();i++)
                     {
                        Room r= (Room)roomvc.get(i); //���̸��� ������.
                        if(t.equals(r.title))//���� ã������
                        {
                           myroom=r;
                           myroom.uservec.add(this);
                           myroom.inwon++; //�ο�����
                           putMsgAll("210|"+name+"|"+myroom.title);
                           break;
                        }//if
                        
                     }//for
                  }//case 210 end
                  break;
               case 400: //�濡�� ��ȭ�ϱ�
                  {
                     putMsgRoom("400|"+name+" ���� ��>>"+token.nextToken());
                     //
                  }//case 400 end
                  break;
                  
               case 290:
                  {
                     myroom.uservec.remove(this);
                     myroom.inwon=myroom.uservec.size();
                     
                     if(myroom.inwon==0)
                     {
                        roomvc.remove(myroom); //������.
                     }//if
                     
                     putMsgAll("290|"+name+"|"+myroom.title);
                     myroom= new Room();                     
                     myroom.title= "����"; 
                  }//case 290 end
                  break; 
               
               case 420: //��ȭ�� ����.
                  {
                     String newName = token.nextToken(); //���ο� ��ȭ���� �о�´�.
                     putMsgAll("420|"+name+"|"+newName+"|"+myroom.title);
                     //��� Ŭ���̾�Ʈ���� ������.
                     name=newName;
                  }//case 420 end
                  break;
                  
               case 450: //�ӼӸ�.
                  {
                     String sayName = token.nextToken();
                     String sayC = token.nextToken();
                     
                     //��ȭ�濡�� �ӼӸ� ���� ��븦 ã�Ƴ���.
                     for(int i=0;i<myroom.uservec.size();i++)
                     {
                        Service ser = (Service)myroom.uservec.get(i);
                        
                        if(sayName.equals(ser.name))
                        {
                           try
                           {
                            ser.putMsgTo("450|"+name+"|"+sayC);  
                           }
                           catch(Exception ex)
                           {
                              myroom.uservec.remove(ser);
                           }
                           break;//for Ż��.
                        }//if
                     }//for
                  }//case 450 end
                  break;
                  
               case 900 : {//����. // ���� ä�ù� ����Ʈ���� ���� Ŭ���̾�Ʈ.
                        globalvc.remove(this); //���ǿ��� ����.
                        putMsgAll("900|"+name+"|"+myroom.title); //��ο��� �˸���.
                     
                        if(!myroom.title.equals("����"))
                        {
                           //��ȭ�濡�� ��������
                           myroom.uservec.remove(this);
                           if(--myroom.inwon==0)
                           {
                              roomvc.remove(myroom); //������.
                           }//inner if
                        }//if
                        try
                        {
                         in.close();
                           out.close();
                        }
                        catch(Exception ex)
                        {
                           
                        }
                        return; //������ ��� �۾��� ���ְ� �ȴ�.
                  }//case 900 end
                  //break;
                  
                  
               }//switch end
               
               
            }catch(Exception ex)
            {
            return;
         }//catch end // ���ܰ� �߻��ص� �����ؾߵȴ�. ������ ��� ���ƾ��ϴϱ�.
            
         }//while
         
      }//run end------------------------------------------------------
      
         
         //custom//
      public void putMsgAll(String msg){
         synchronized(this){
            
            for(int i=0; i < globalvc.size(); i++)
            {
               try{
                  Service ser = (Service)globalvc.get(i);
                  ser.putMsgTo(msg); //�޼��� ȣ��.
               }catch(Exception ex){
                 System.out.println(ex);
                  globalvc.remove(i--);
               }//TC end
            }//for
        }//synchronized end
      }//putMsgALL end

     public void putMsgRoom(String msg){
         
         synchronized (this){
            for(int i=0;i<myroom.uservec.size();i++)
            {
            
            try{
               Service ser=(Service)myroom.uservec.get(i);
               ser.putMsgTo(msg); //�޼��� ȣ��.
               
            }catch(Exception ex){}//TC end
         }//for
           
         }//synchronized end
         
      }//putMsgRoom end

      
      public void putMsgTo(String msg) throws Exception{
         synchronized (this){
            out.write((msg+"\r\n").getBytes()); //Ŭ���̾�Ʈ�� msg ����
            //getByte()�� ���ڵ� ó���ϴ� �޼���.        
            
         }//synchronized end
      }//putMsgTo end
         
         
   }//=========Service end=======
   
   
}//Server class end-------><
