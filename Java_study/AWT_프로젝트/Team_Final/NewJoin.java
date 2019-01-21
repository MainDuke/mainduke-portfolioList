
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;

import java.sql.*;

public class NewJoin extends JFrame implements ActionListener {
	
	//DB ����
	String DRIVER ="com.mysql.jdbc.Driver";
	String URL = "jdbc:mysql://localhost:3306/e_team";
	String USER="root";
	String PWD= "12345";
	
	Connection con = null;
	Statement stmt= null;
	ResultSet rs= null;
	
	
	  //����
	  int cherk = -1; //�ߺ� Ȯ�� ����
	  JLabel la_name, la_id, la_pwd, la_email, la_sex, la_title;
	  JTextField tf_name, tf_id, tf_pwd, tf_email;
	  Checkbox man, woman;
	  CheckboxGroup group;
	  JButton bu_join, bu_cancel, bu_idCherk;
	
	  
	  //������
	  public NewJoin(){
	  setTitle("�� ����");
	  
	  la_title = new JLabel("ȸ�� ����");
	  la_title.setFont(new Font("Dialog",Font.BOLD, 20));
        la_title.setForeground(Color.blue);
		
	  la_name = new JLabel("�̸�", JLabel.RIGHT);
	  la_id = new JLabel("���̵�",JLabel.RIGHT);
	  la_pwd = new JLabel("PWD",JLabel.RIGHT);
	  la_email = new JLabel("�̸���",JLabel.RIGHT);
	  la_sex = new JLabel("����",JLabel.RIGHT);
	  
	  tf_name = new JTextField("");
	  tf_id = new JTextField("");
	  tf_pwd = new JTextField("");
	  tf_email = new JTextField("");

	  group=new CheckboxGroup();  
	  
	  man = new Checkbox("��",group,true);
	  woman = new Checkbox("��",group,false);
	  
	  bu_join = new JButton("ȸ�� ���");
	  bu_cancel = new JButton("���");
	  bu_idCherk = new JButton("�ߺ� Ȯ��");
		
		/*
      String data1[][] = new String[0][1];
      String cols1[] = {"��ȭ��"};
      DefaultTableModel model = new DefaultTableModel(data1,cols1);
      JTable table = new JTable(model);
      JScrollPane roomInfoPane = new JScrollPane(table);
      */
		
	  getContentPane().setLayout(null); //��ġ�� ���α׷��Ӱ� �Ϸ���
	  
		//Ÿ��Ʋ
	  getContentPane().add(la_title).setBounds(100,4,130,20);
		//��
	  getContentPane().add(la_name).setBounds(18,62,50,50);
	  getContentPane().add(la_id).setBounds(25,122,50,50);
	  getContentPane().add(la_pwd).setBounds(18,182,50,50);
	  getContentPane().add(la_email).setBounds(25,242,50,50);
	  getContentPane().add(la_sex).setBounds(18,302,50,50);
	  
	  //�ؽ�Ʈ �ʵ�.
	  getContentPane().add(tf_name).setBounds(82,72,140,25); 
	  getContentPane().add(tf_id).setBounds(82,132,140,25);
	  getContentPane().add(tf_pwd).setBounds(82,192,140,25);  
	  getContentPane().add(tf_email).setBounds(82,252,140,25);

		//���� ��ư.
	  getContentPane().add(man).setBounds(105,310,30,30);
	  getContentPane().add(woman).setBounds(130,310,30,30);
	  
		
	//��ư ��ġ.
	  getContentPane().add(bu_join).setBounds(65,400,100,30);  
	  getContentPane().add(bu_cancel).setBounds(180,400,95,30);
	 getContentPane().add(bu_idCherk).setBounds(226,130,90,25);
		
	 // setBounds(500,100,340,500);
	 // setVisible(true);
	  
	  
		//�̺�Ʈ ���
		bu_join.addActionListener(this);
		bu_cancel.addActionListener(this);
		bu_idCherk.addActionListener(this);
		
		//driver catch
		try
		{
			Class.forName(DRIVER);
         
			System.out.println("driver �ε� ���� from New Join ");
		}
		catch(ClassNotFoundException ce)
		{
			System.out.println("driver �ε� ����   from New Join: "+ce);
		}
		
		
		
		
	}//cons end -------------------------------------------------------------
		
		
	  //overriding
	  public void actionPerformed(ActionEvent a){
	  
			if(a.getSource() == bu_cancel)
			{
				setVisible(false);
				return;
			}else if(a.getSource() ==  bu_join)
			{
				//������ ����.
				int memNo=0;
            
            try{
            
               
              // String memNos = "select memNo from member";
					rs= stmt.executeQuery("select memNo from member");
               while(rs.next())
               {
                  memNo++;
               }
               System.out.println("���� ȸ����, memNo : "+memNo);
               
               //rs.close();
            }catch(Exception ex98){}
            
            
            String njName=tf_name.getText().trim();
				String njId=tf_id.getText().trim();
				String njPwd=tf_pwd.getText().trim();
				String njEmail=tf_email.getText().trim();
				String njSex="";
				        
				if(man.getState())
				{
				       njSex="����";
				}else if(woman.getState())
				{
					     njSex="����";
				}
			
				
            
            if(njName.equals("") || njName.length()<0)
				{
					JOptionPane.showMessageDialog(null, "name�� �Է��Ͻÿ�.");
					tf_name.requestFocus();
					return;
				}//if1
				if(njId.equals("") || njId.length()<0)
				{
					JOptionPane.showMessageDialog(null, "id�� �Է��Ͻÿ�.");
					tf_id.requestFocus();
					return;
				}//if2
				
				if(njPwd.equals("") || njPwd.length()<0)
				{
					JOptionPane.showMessageDialog(null, "PWD�� �Է��Ͻÿ�.");
					tf_pwd.requestFocus();
					return;
				}//if3
				if(njEmail.equals("") || njEmail.length()<0)
				{
					JOptionPane.showMessageDialog(null, "email�� �Է��Ͻÿ�.");
					tf_email.requestFocus();
					return;
				}//if4
				
				
				if(cherk > 0) //�ߺ� Ȯ�� ���� Ȯ��.
				{			
                               
					try{
                  
                  con= DriverManager.getConnection(URL,USER,PWD);
                  stmt=con.createStatement();
                 String sql = "create table hi"+memNo+"(no varchar(15) not null, name varchar(22) not null, writer varchar(15) not null, publisher varchar(15) not null);";
                 stmt.executeUpdate(sql);
            
            
            sql = "insert into member(memNo, name,id,pwd,email,sex) value ('"+(memNo)+"','"+njName+"','"+njId+"', '"+njPwd+"','"+njEmail+"','"+njSex+"');";
					stmt.executeUpdate(sql);
          
					JOptionPane.showMessageDialog(null, "ȸ�� ������ �Ϸ� �Ǿ����ϴ�.");
					cherk=-1;
               
               dispose();
               
						try{
							if(stmt != null){stmt.close();}
							if(con != null){con.close();}
						}catch(Exception ex99){}
				}catch(Exception ex8){}
				}else if(cherk < 0)//�ߺ� Ȯ�� if end
				{
					JOptionPane.showMessageDialog(null, "ID �ߺ� üũ�� ���ֽʽÿ�.");
					return;
				}
				
			}else if(a.getSource() ==  bu_idCherk)
			{
               System.out.println("id üũ");

				String cId = tf_id.getText().trim();
				if(cId.equals("") || cId.length()<0)
				{
					JOptionPane.showMessageDialog(null, "ID�� �Է��Ͻÿ�..");
					tf_id.requestFocus();
					return;
				}//if
        
               
        
				try{
               con= DriverManager.getConnection(URL,USER,PWD);
               
               stmt=con.createStatement();
				rs= stmt.executeQuery("select * from member where id ='"+cId+"'");
				
				  if(rs.next())
				  {
					
					 JOptionPane.showMessageDialog(null, "�ߺ��� ���̵� �ֽ��ϴ�.");
					 cherk = -1;
					 System.out.println("�ߺ� :"+ cherk);
          
                         
					
          }else if(Character.isDigit(cId.charAt(0))){
            
            JOptionPane.showMessageDialog(null, "���̵� ù���ڴ� ���ڰ� �Ұ��� �մϴ�.");
            cherk = -1;
            System.out.println("���ڿ��� :"+ cherk);
          
          /*
            }else if(cId>='\uAC00' && cId<='\uD7A3'){
            
            
            JOptionPane.showMessageDialog(null, "���̵�� �ѱ� ������ �Ұ��� �մϴ�.");
            cherk = -1;
            System.out.println("�ѱۿ��� :"+ cherk);
            
            */      
          
          }else{
					
					JOptionPane.showMessageDialog(null, "��� ������ ���̵��Դϴ�.");
					cherk = 1;
					System.out.println("��밡�� :"+ cherk);
				}
						
			}catch(Exception ex9){
				}
			
			} //else if end
			
	  }//actionPerformed()
    
    

//============================================================================================	 
		
		/*
      //main
      public static void main( String [] args ){
      new NewJoin();
      }// end main
      */
		
}//class

