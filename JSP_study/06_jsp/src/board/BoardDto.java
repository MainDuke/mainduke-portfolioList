package board;
import java.util.*;


public class BoardDto {
	
	public BoardDto(){}
	
	public BoardDto(int num, String writer, String subject, String email, String date, int readcount) {
		super();
		this.num = num;
		this.writer = writer;
		this.subject = subject;
		this.email = email;
		this.date = date;
		this.readcount = readcount;
	}



	/*
	create table Myboard(
			num int not null auto_increment primary key,
			wirter varchar(20) not null,
			subject varchar(30) not null,
			email varchar(30) not null,
			content text not null,
			pwd varchar(8) not null,
			wdate date,
			readcount int unsigned default 0,
			ip varchar(20)
			);
	*/
	
	
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPwd() {
		return pwd;
	}
	public void setPwd(int pwd) {
		this.pwd = pwd;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	private int num;
	private String writer;
	private String subject;
	private String email;
	private String content;
	private int pwd;
	private String date;
	private int readcount;
	private String ip;
	
	
	
	
	
}
