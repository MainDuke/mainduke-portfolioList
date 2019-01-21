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
	//변수
	//회원관리. 객체 생성.
	Member_manager mm = new Member_manager();
   MyInfo my;
   MyBookPage mb; //마이북페이지.
   //대여 객체
   rent_book rent;
   
   
	Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
	//setBounds((res.width)/3,(res.height)/3,430, 260);
	
	String loginId="";
	JTabbedPane tab;
	JPanel p_home;
	JLabel la_name, la_publisher, la_writer; 
	JTextField tf_name, tf_publisher, tf_writer;
	JButton bu_search, bu_logout, bu_borrow, bu_mypage,bu_rent, bu_refresh;
	
	Object ob[][] = new Object[0][6];//0행, 7열
	String title[] = {"등록번호","책제목","저자","출판사","대여","반납예정일"};
	
	DefaultTableModel model = new DefaultTableModel(ob,title){
		
		//셀 편집 못하게 하면, table 더블클릭이 먹힌다
		public boolean isCellEditable(int rows, int cols){
			return false;}
	};//isCellEditable()
	
	JTable table = new JTable(model);
	JScrollPane pane = new JScrollPane(table);//table에 스크롤바 넣기
	
	
	//db 관련 vari
	String DRIVER ="com.mysql.jdbc.Driver";
	String URL = "jdbc:mysql://localhost:3306/e_team";
	String USER="root";
	String PWD= "12345";
	
	Connection con = null;
	Statement stmt= null;
	ResultSet rs= null;
   
   //전역변수
   int row=-1;
   String value="";
   int info = 1; //인포 정보 변경. 내정보 버튼을 누른후 로그아웃을 할 경우 자동으로 종료되게 만들었음.
	
	
	//생성자
	public Main(){}//디폴트 생성자.
	
	public Main(String id){ //////////////////////////////////////////////////사용자용 생성자
		
		super("Main_클라이언트");
		
      mb = new MyBookPage(id);
      
      
      
		loginId = id;
		System.out.println("로그인한 아이디: "+loginId);
		
		tab = new JTabbedPane();
		
      //table 에 마우스 등록.
		table.addMouseListener(new MyMouse());
		
		p_home = new JPanel();
		la_name = new JLabel("책 이름");
		la_writer = new JLabel("저자명");
		la_publisher = new JLabel("출판사");
		tf_name = new JTextField();
		tf_publisher = new JTextField();
		tf_writer = new JTextField();
		bu_search = new JButton("검색");
		bu_logout = new JButton("로그아웃");
		bu_mypage = new JButton("내정보");
		bu_rent = new JButton("대여");
      bu_refresh = new JButton("새로고침");
		
		//테이블 고정 옵션들.
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setBackground(Color.white);
		
		

    
		tab.addTab("도서검색", null, p_home,"도서검색");
    tab.addTab("대출조회",null,mb.p1,"대출조회");

		
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
		
		//---db연결----------------------------------------------------  
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException ex1){
			System.out.println("드라이버 로딩 실패 :"+ex1);
		}
		try{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_team","root","12345");
			stmt=con.createStatement();//Statement 생성
		}catch(SQLException ex){
			System.out.println("SQL 예외 :"+ex);
		}//catch
		
		model.setRowCount(0);
			search();
	}//con end
	//==============================================================================
	
	//String id, int memNo
	public Main(String id, int memNo){ //관지라용 생성자
				
		super("Main_클라이언트");
		
		loginId = id;
		tab = new JTabbedPane();
		
		p_home = new JPanel();
		
		la_name = new JLabel("책 이름");
		la_writer = new JLabel("저자명");
		la_publisher = new JLabel("출판사");
		tf_name = new JTextField();
		tf_publisher = new JTextField();
		tf_writer = new JTextField();
		bu_search = new JButton("검색");
		bu_logout = new JButton("로그아웃");
		bu_mypage = new JButton("내정보");

		
		//테이블 고정 옵션들.
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setBackground(Color.white);
		
		
		
		tab.addTab("HOME", null, p_home,"HOME");
		tab.addTab("회원 관리", null, mm.p1, "회원");
		
		
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
		
		//알림문.
		JOptionPane.showMessageDialog(this,"관리자 모드");
		
		//---db연결----------------------------------------------------  
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException ex1){
			System.out.println("드라이버 로딩 실패 :"+ex1);
		}
		try{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_team","root","12345");
			stmt=con.createStatement();//Statement 생성
			
		}catch(SQLException ex){
			System.out.println("SQL 예외 :"+ex);
		}//catch
		
		model.setRowCount(0);
			search();
		
	}//관리자 생성자 끝.
	
	
	
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
			JOptionPane.showMessageDialog(null,"로그아웃 하셨습니다.");
      }else if(e.getSource()== bu_rent)//====================================================================대여.
    {
      
      if(row < 0)
      {
        JOptionPane.showMessageDialog(null, "대여할 책을 고르시오.");
        return;
      }//if
      
      
      
      //String cols[]={"no","책이름","저자","출판사","대여일","반납입"};
      //팝업창에 정보 뿌리기.
      String imNo = (String)model.getValueAt(row,0);
      String imName= (String)model.getValueAt(row,1);
      String imWriter= (String)model.getValueAt(row,2);
      String imPublisher= (String)model.getValueAt(row,3);
      String imrentable= (String)model.getValueAt(row,4);
      String imReturnday= "대여기간 7일";
      if(imrentable.equals("대출 중"))
      {
         JOptionPane.showMessageDialog(null, "이미 대여중입니다.");
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
         
         row = table.getSelectedRow(); //행선택.
         
         value=(String)model.getValueAt(row, 0);
         
      }//mousePressed end
      
   }//MyMouse end
	
	public void search(){//사용자 정의 메서드
		
    try{
      
      //검색 엔진 논리 구조==================================================================
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
      
           
      //검색 엔진 논리 구조 ==================================================================
      
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
      System.out.println("disp() 예외 :"+ex3);
    }
  }//search
	
}//class
