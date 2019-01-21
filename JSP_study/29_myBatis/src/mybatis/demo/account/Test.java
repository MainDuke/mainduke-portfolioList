package mybatis.demo.account;

//모델빈
public class Test {
	
	//전역변수=필드=프로퍼티
	private String id;
	private String pwd;
	private String name;
	
	//디폴트 생성자
	public Test(){}
	//이번엔 인자있는 생성자 안만들고 getter setter로 쓸거야.
	
	//getter setter
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		String result;
		result = String.format("[UserId=%s, Password=%s, Name=%s]", id, pwd, name);
		// %s : 문자열 / %d : 숫자 / %f : 실수
		return result;
	}
	
}//class
