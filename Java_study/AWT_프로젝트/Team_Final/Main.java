import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import java.sql.*;


import java.awt.Toolkit;
import java.awt.Dimension;


class Main extends JFrame implements ActionListener
{
	//����
	//ȸ������. ��ü ����.
	Member_manager mm = new Member_manager();
   MyInfo my;
   MyBookPage mb; //���̺�������.
   //�뿩 ��ü
   rent_book rent;
   
   
	Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
	//setBounds((res.width)/3,(res.height)/3,430, 260);
	
	String loginId="";
	JTabbedPane tab;
	JPanel p_home;
	JLabel la_name, la_publisher, la_writer; 
	JTextField tf_name, tf_publisher, tf_writer;
	JButton bu_search, bu_logout, bu_borrow, bu_mypage,bu_rent, bu_refresh;
	
	Object ob[][] = new Object[0][6];//0��, 7��
	String title[] = {"��Ϲ�ȣ","å����","����","���ǻ�","�뿩","�ݳ�������"};
	
	DefaultTableModel model = new DefaultTableModel(ob,title){
		
		//�� ���� ���ϰ� �ϸ�, table ����Ŭ���� ������
		public boolean isCellEditable(int rows, int cols){
			return false;}
	};//isCellEditable()
	
	JTable table = new JTable(model);
	JScrollPane pane = new JScrollPane(table);//table�� ��ũ�ѹ� �ֱ�
	
	
	//db ���� vari
	String DRIVER ="com.mysql.jdbc.Driver";
	String URL = "jdbc:mysql://localhost:3306/e_team";
	String USER="root";
	String PWD= "12345";
	
	Connection con = null;
	Statement stmt= null;
	ResultSet rs= null;
   
   //��������
   int row=-1;
   String value="";
   int info = 1; //���� ���� ����. ������ ��ư�� ������ �α׾ƿ��� �� ��� �ڵ����� ����ǰ� �������.
	
	
	//������
	public Main(){}//����Ʈ ������.
	
	public Main(String id){ //////////////////////////////////////////////////����ڿ� ������
		
		super("Main_Ŭ���̾�Ʈ");
		
      mb = new MyBookPage(id);
      
      
      
		loginId = id;
		System.out.println("�α����� ���̵�: "+loginId);
		
		tab = new JTabbedPane();
		
      //table �� ���콺 ���.
		table.addMouseListener(new MyMouse());
		
		p_home = new JPanel();
		la_name = new JLabel("å �̸�");
		la_writer = new JLabel("���ڸ�");
		la_publisher = new JLabel("���ǻ�");
		tf_name = new JTextField();
		tf_publisher = new JTextField();
		tf_writer = new JTextField();
		bu_search = new JButton("�˻�");
		bu_logout = new JButton("�α׾ƿ�");
		bu_mypage = new JButton("������");
		bu_rent = new JButton("�뿩");
      bu_refresh = new JButton("���ΰ�ħ");
		
		//���̺� ���� �ɼǵ�.
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setBackground(Color.white);
		
		

    
		tab.addTab("�����˻�", null, p_home,"�����˻�");
    tab.addTab("������ȸ",null,mb.p1,"������ȸ");

		
		p_home.setLayout(null);
		
		this.getContentPane().setLayout(new GridLayout(1,1));
		this.getContentPane().add(tab);
		
		p_home.setLayout(null);
		
		p_home.add(tf_name).setBounds(80,115,550,23);
		p_home.add(tf_writer).setBounds(80,155,550,23);
		p_home.add(tf_publisher).setBounds(80,195,550,23);
		
		p_home.add(bu_search).setBounds(650,100,120,40);
		p_home.add(bu_rent).setBounds(650,150,120,40);
		p_home.add(bu_mypage).setBounds(580,10,80,40);
		p_home.add(bu_logout).setBounds(670,10,90,40);
		p_home.add(bu_refresh).setBounds(650,200,120,40);
      
		p_home.add(la_name).setBounds(20,110,80,40);
		p_home.add(la_writer).setBounds(20,150,80,40);
		p_home.add(la_publisher).setBounds(20,190,80,40);
		
		p_home.add(pane).setBounds(30,250,700,400);
		
		setBounds((res.width)/4,(res.height)/10,800,800);
		//setBounds(0,0,800,800);
		setVisible(true);
		
		tf_name.addActionListener(this);
		tf_publisher.addActionListener(this);
		tf_writer.addActionListener(this);  
		
		bu_search.addActionListener(this);
		bu_logout.addActionListener(this);
		bu_mypage.addActionListener(this);
		bu_rent.addActionListener(this);
		bu_refresh.addActionListener(this);
    (mb.b_out).addActionListener(this);  
      
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
		
		//---db����----------------------------------------------------  
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException ex1){
			System.out.println("����̹� �ε� ���� :"+ex1);
		}
		try{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_team","root","12345");
			stmt=con.createStatement();//Statement ����
		}catch(SQLException ex){
			System.out.println("SQL ���� :"+ex);
		}//catch
		
		model.setRowCount(0);
			search();
	}//con end
	//==============================================================================
	
	//String id, int memNo
	public Main(String id, int memNo){ //������� ������
				
		super("Main_Ŭ���̾�Ʈ");
		
		loginId = id;
		tab = new JTabbedPane();
		
		p_home = new JPanel();
		
		la_name = new JLabel("å �̸�");
		la_writer = new JLabel("���ڸ�");
		la_publisher = new JLabel("���ǻ�");
		tf_name = new JTextField();
		tf_publisher = new JTextField();
		tf_writer = new JTextField();
		bu_search = new JButton("�˻�");
		bu_logout = new JButton("�α׾ƿ�");
		bu_mypage = new JButton("������");

		
		//���̺� ���� �ɼǵ�.
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setBackground(Color.white);
		
		
		
		tab.addTab("HOME", null, p_home,"HOME");
		tab.addTab("ȸ�� ����", null, mm.p1, "ȸ��");
		
		
		this.getContentPane().setLayout(new GridLayout(1,1));
		this.getContentPane().add(tab);
		
		p_home.setLayout(null);
		
		p_home.add(tf_name).setBounds(80,115,550,23);
		p_home.add(tf_publisher).setBounds(80,195,550,23);
		p_home.add(tf_writer).setBounds(80,155,550,23);
		
		p_home.add(bu_search).setBounds(650,130,80,80);
		p_home.add(bu_mypage).setBounds(580,10,80,40);
		p_home.add(bu_logout).setBounds(670,10,90,40);
		p_home.add(la_name).setBounds(20,110,80,40);
		p_home.add(la_writer).setBounds(20,150,80,40);
		p_home.add(la_publisher).setBounds(20,190,80,40);
		p_home.add(pane).setBounds(30,250,700,400);
		
		setBounds((res.width)/4,(res.height)/10,800,800);
		//setBounds(0,0,800,800);
		setVisible(true);
		
		tf_name.addActionListener(this);
		tf_publisher.addActionListener(this);
		tf_writer.addActionListener(this);  
		bu_search.addActionListener(this);
		bu_logout.addActionListener(this);
		bu_mypage.addActionListener(this);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
		
		//�˸���.
		JOptionPane.showMessageDialog(this,"������ ���");
		
		//---db����----------------------------------------------------  
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException ex1){
			System.out.println("����̹� �ε� ���� :"+ex1);
		}
		try{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_team","root","12345");
			stmt=con.createStatement();//Statement ����
			
		}catch(SQLException ex){
			System.out.println("SQL ���� :"+ex);
		}//catch
		
		model.setRowCount(0);
			search();
		
	}//������ ������ ��.
	
	
	
	//overriding
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==bu_search){
			
			model.setRowCount(0);
			search();
			
		}else if(e.getSource()==bu_mypage){
			
			my = new MyInfo(loginId);
      info = -1;
			
		}else if(e.getSource()==bu_logout){
			Login lg = new Login();
			dispose();
         
         if(info < 0)
         {
            my.dispose();
         }
			JOptionPane.showMessageDialog(null,"�α׾ƿ� �ϼ̽��ϴ�.");
      }else if(e.getSource()== bu_rent)//====================================================================�뿩.
    {
      
      if(row < 0)
      {
        JOptionPane.showMessageDialog(null, "�뿩�� å�� ���ÿ�.");
        return;
      }//if
      
      
      
      //String cols[]={"no","å�̸�","����","���ǻ�","�뿩��","�ݳ���"};
      //�˾�â�� ���� �Ѹ���.
      String imNo = (String)model.getValueAt(row,0);
      String imName= (String)model.getValueAt(row,1);
      String imWriter= (String)model.getValueAt(row,2);
      String imPublisher= (String)model.getValueAt(row,3);
      String imrentable= (String)model.getValueAt(row,4);
      String imReturnday= "�뿩�Ⱓ 7��";
      if(imrentable.equals("���� ��"))
      {
         JOptionPane.showMessageDialog(null, "�̹� �뿩���Դϴ�.");
         return;
      }
      
	     String temp[] = {imNo,imName,imWriter,imPublisher,imrentable,imReturnday};
      
      row=-1;
      new rent_book(loginId, temp);
      
      
      
   }else if(e.getSource() == bu_refresh)
   {
         model.setRowCount(0);
			search();
    
    }else if(e.getSource()==mb.b_out){
      
      setVisible(false);
      Login lg = new Login();
      
          
   }
	}//actionPerformed() end
	
	//==============================================================================
   //inner class
   public class MyMouse extends MouseAdapter{
      public void mousePressed(MouseEvent me){
         
         row = table.getSelectedRow(); //�༱��.
         
         value=(String)model.getValueAt(row, 0);
         
      }//mousePressed end
      
   }//MyMouse end
	
	public void search(){//����� ���� �޼���
		
    try{
      
      //�˻� ���� �� ����==================================================================
      String sname = " and name like '%"+tf_name.getText().trim()+"%'";
      String swriter = " and writer like '%"+tf_writer.getText().trim()+"%'";
      String spublisher = " and publisher like '%"+tf_publisher.getText().trim()+"%'";
      
      if(tf_name.getText().equals("") || tf_name.getText().length()<0){
        sname = "";
        
        
        if(tf_writer.getText().equals("") || tf_writer.getText().length()<0)
        {
          spublisher = " and publisher like '%"+tf_publisher.getText().trim()+"%'";
        }
        
        swriter = " and writer like '%"+tf_writer.getText().trim()+"%'";         
        
        
      }//if
      
      if(tf_writer.getText().equals("") || tf_writer.getText().length()<0){
        swriter= "";   
      }
      
      if(tf_publisher.getText().equals("") || tf_publisher.getText().length()<0){
        spublisher= "";   
      }
      
      rs=stmt.executeQuery("select b.*, if(ifnull(r.rentdate,0)=0,'',DATE_FORMAT((r.rentdate)+7,'%Y-%m-%d')) as returnday, r.rentable as able from Book b, rent r where b.no=r.no"+sname+swriter+spublisher);
      
           
      //�˻� ���� �� ���� ==================================================================
      
      while(rs.next()){
        
        String no = rs.getString("no");
        String name=rs.getString("name");
        String writer=rs.getString("writer");
        String publisher=rs.getString("publisher");
        String returnday=rs.getString("returnday");
        
        String able = rs.getString("able");
                
        String temp[]={no,name,writer,publisher, able ,returnday};
        
        model.addRow(temp);
      }//while
      rs.close();
    }catch(SQLException ex3){
      System.out.println("disp() ���� :"+ex3);
    }
  }//search
	
}//class
