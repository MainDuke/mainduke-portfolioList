package mybatis.demo.account;

//�𵨺�
public class Test {
	
	//��������=�ʵ�=������Ƽ
	private String id;
	private String pwd;
	private String name;
	
	//����Ʈ ������
	public Test(){}
	//�̹��� �����ִ� ������ �ȸ���� getter setter�� ���ž�.
	
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
		// %s : ���ڿ� / %d : ���� / %f : �Ǽ�
		return result;
	}
	
}//class
