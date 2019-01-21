/*
 * Author: Administrator
 * Created: 2016�� 2�� 4�� ����� ���� 11:24:39
 * Modified: 2016�� 2�� 4�� ����� ���� 11:24:39
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;

class MemoTest extends Frame implements ActionListener{
 
   //vari
   
   
 
   MenuItem newItem, openItem, saveItem,exitItem, printItem, cardItem;
   TextArea ta;
   String lastLoad;
   
   
   //cons
   public MemoTest(){
           
      super("MemoTest");
      
      MenuBar mb = new MenuBar();
      
      Menu fileMenu = new Menu("����");
      Menu printMenu = new Menu("�μ�");
      Menu gameMenu = new Menu("����");
      
      mb.add(fileMenu);
      mb.add(printMenu);
      mb.add(gameMenu);
      
      //���� �׸� �޴�.
      newItem = new MenuItem("����", new MenuShortcut('N'));//����Ű
      fileMenu.add(newItem); //�޴�// �׸�޴�.
 
      newItem.addActionListener(this);
      newItem.setActionCommand("new");
      
      //���Ͽ��� �׸�޴�.
      openItem = new MenuItem("���� ����", new MenuShortcut('O'));
      fileMenu.add(openItem);
      openItem.addActionListener(this);
      openItem.setActionCommand("open");
      
      //�������� �׸�޴�.
      saveItem= new MenuItem("���� ����", new MenuShortcut('S'));
      fileMenu.add(saveItem);
      saveItem.addActionListener(this);
      saveItem.setActionCommand("save");
      
      //�и���(���м�)
      fileMenu.addSeparator();
      
      //���� �׸�޴�
      exitItem = new MenuItem("����", new MenuShortcut('X'));
      fileMenu.add(exitItem);
      exitItem.addActionListener(this);
      exitItem.setActionCommand("exit");
      
      //�μ� �׸� �޴�.
      printItem= new MenuItem("�μ�", new MenuShortcut('P'));
      printMenu.add(printItem);
      printItem.addActionListener(this);
      printItem.setActionCommand("print");
      
      //ī������׸�.
      cardItem = new MenuItem("ī�����");
      gameMenu.add(cardItem);
      cardItem.addActionListener(this);
      cardItem.setActionCommand("card");
      
      
     ta = new TextArea();
      this.add(ta, "Center");
      this.setMenuBar(mb);
      
      //���� inner Class(â����.)
      addWindowListener(new WindowAdapter()
         {
            
               public void windowClosing(WindowEvent w){
                  System.exit(0);
               }
            
         }   
         );
      setVisible(true);
      setBounds(200,200,500,500);
   
   }//cons end
   
  
   
   //overriding
      public void actionPerformed(ActionEvent e){
      FileDialog fd=null;
      String str= e.getActionCommand();
      
      if(str.equals("new"))//���۾���.
      {
         ta.setText(" ");//�޸��� ������ �����.
                  
      }else if(str.equals("open")){//���Ͽ���.
         
         System.out.println("test");
         fd=new FileDialog(this, "���Ͽ���", FileDialog.LOAD);
         fd.setVisible(true);
         
         String fn = fd.getDirectory()+fd.getFile();
               
         if(fd.getFile() == null )
         {
            return;
         }else{
             loadFile(fn); //�޼��� ȣ��.
         }//if end
         
         
      }else if(str.equals("save")){//�����ϱ�.
         fd=new FileDialog(this, "��������", FileDialog.SAVE);
         fd.setVisible(true);
         String fn= fd.getDirectory()+fd.getFile();
         if(fd.getFile() == null)
         {
         return;
         }else
         {
            saveFile(fn);//�޼��� ȣ��.
         }
         
         //if end
         
      }else if(str.equals("print") || str.equals("printMenu")){//�μ��ϱ�.
         
         PrintJob pj = getToolkit().getPrintJob(this,"�μ�",null);
         
      }else if(str.equals("card") || str.equals("gameMenu") ){//ī�����.
         
         try{
            Runtime r = Runtime.getRuntime();
            r.exec("c:\\Windows\\System32\\calc.exe");
         }catch(Exception e1){
         System.out.println(e1);
         }
         
      }else if(str.equals("exit")){
         dispose();
         System.exit(0);
      }
      
   }//end actionPerfomaned
   
   //custom method Load, Save......
  //vari
   FileDialog open,save;
    
   //Save Method
   public void saveFile(String fn){
      PrintWriter pp = null;
      try{
         pp =new PrintWriter(new BufferedWriter(new FileWriter(fn)));
         String msg = ta.getText();
         pp.println(msg);
         pp.close();
         
         setTitle("���� �̸�:"+fn);
      }catch(Exception ex){
         System.out.println(ex);
      }
        
            
  
   }   
   
   //Load Method 
   public void loadFile(String fn){
      
      BufferedReader in =null;
      ta.setText(""); //�޸��� �����.
      String s="";
     
     
      try{
         
         in = new BufferedReader(new FileReader(fn) , 1024);
         while((s=in.readLine())!= null)
      {
         ta.append(s+"\n");
      }
         in.close();
         setTitle("�����̸�:"+fn);
           lastLoad = fn;
      }catch(Exception ex){
         System.out.println(ex);         
      
      }
   
    
   
   }
   
      
   //method
	public static void main( String [] args ) 
   {
      new MemoTest();
   }// end main

   }//class end
