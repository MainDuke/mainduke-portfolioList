package user.service;

import java.util.List;




import model.User;

import org.springframework.orm.ibatis.SqlMapClientTemplate;


//구현클래스
//Dao
//Service
public class UserDaoImplService implements UserDao{

	private SqlMapClientTemplate sqlMapClientTemplate;
	
	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}

	@Override
	public List<User> getList() {

		return sqlMapClientTemplate.queryForList("selectAll"); //user.xml.
	}

	@Override
	public String writeUser(User user) {
		String str="insert 성공";
		sqlMapClientTemplate.insert("insertUser",user);
		return str;
	}

	@Override
	public User getUser(String userId) {
		return (User)sqlMapClientTemplate.queryForObject("selectUser",userId);
	}

	@Override
	public void modifyUser(User user) {
	sqlMapClientTemplate.update("updateUser",user);
		
	}

	@Override
	public void deleteUser(String userId) {
		sqlMapClientTemplate.update("deleteUser", userId);
		
	}

	
	
}//class end
