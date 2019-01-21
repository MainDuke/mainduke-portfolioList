package guest;

public class GuestBean {
	
	/*
	create table guest(
			num int(11) not null auto_increment primary key,
			name varchar(20) not null,
			id varchar(20),
			
			pwd varchar(20),
			pos int(11),
			depth int(11),
		
			content text,
			regdate date,
			ip varchar(20)
			);
	*/
	private int num;
	
	private String name;
	private String id;
	private String pwd;
	
	private int pos;
	private int depth;
	
	private String content;
	private String regdate;
	private String ip;
	
	//持失切
	public GuestBean(){
		
	}//持失切
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
	
	
	
	
	
	
}//class end
