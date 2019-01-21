/*
 * Author: Administrator
 * Created: 2016년 2월 25일 목요일 오후 3:33:26
 * Modified: 2016년 2월 25일 목요일 오후 3:33:26
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

class UpdateTest extends JFrame
{
	//vari
   JTextField tf_name, tf_id, tf_email, tf_title;  
   
   JTextArea ta_content;
   
   JButton bu_update;
   
   JLabel laName,laId,laEmail,laTitle,laContent, laJemok;
 
   
   
   //cons
   
   public UpdateTest(){
      
      tf_name=new JTextField();
      tf_id=new JTextField();
      tf_id.setEditable(false);
      tf_email=new JTextField();
      tf_title=new JTextField();
      ta_content = new JTextArea();
      
      bu_update= new JButton("Update");
      
      getContentPane().setBackground(new Color(100, 200, 150));
      
      laJemok = new JLabel("Update Book");
      laJemok.setFont(new Font("Dialog",Font.BOLD, 20));
      laJemok.setForeground(Color.green);
      
      laName=new JLabel("이름",JLabel.RIGHT);
      laName.setForeground(Color.blue);
      
      laId=new JLabel("ID",JLabel.RIGHT);
      laId.setForeground(Color.blue);
      
      laTitle=new JLabel("Title",JLabel.RIGHT);
      laTitle.setForeground(Color.blue);
      
      laEmail=new JLabel("Email",JLabel.RIGHT);
      laEmail.setForeground(Color.blue);
      
      laContent = new JLabel("글내용", JLabel.RIGHT);
      
      getContentPane().setLayout(null); //커스텀 디자인.
      //
      laJemok.setBounds(150,30,250,30); //x,y,w,h
      
      laName.setBounds(80,70,50,20);
      laId.setBounds(80,100,50,20);
      laEmail.setBounds(80,130,50,20);
      laTitle.setBounds(80,160,50,20);
      laContent.setBounds(80,190,50,20);
      //
      tf_name.setBounds(150,70,150,20);
      tf_id.setBounds(150,100,100,20);
      tf_email.setBounds(150,130,170,20);
      tf_title.setBounds(150,160,155,20);
      ta_content.setBounds(150,190,170,80);
      //
      bu_update.setBounds(170,300,80,30);
      //
      
      getContentPane().add(laJemok);
      getContentPane().add(laName);
      getContentPane().add(laId);
      getContentPane().add(laEmail);
      getContentPane().add(laTitle);
      getContentPane().add(laContent);
      //
      getContentPane().add(tf_name);
      getContentPane().add(tf_id);
      getContentPane().add(tf_email);
      getContentPane().add(tf_title);
      getContentPane().add(ta_content);
      //
      getContentPane().add(bu_update);
      //
      setBounds(200,200,400,400);
     setVisible(true);
      
   }//cons end
   //methud
   
   public static void main( String [] args ) 
   {
      new UpdateTest();
   }// end main

}//class end
