package dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import logic.User;

public class UserDaoImpl implements UserDao {

	private SimpleJdbcTemplate template;
	
	public void setTemplate(SimpleJdbcTemplate template){
		this.template=template;
	}
	
	//로그인 쿼리 문
	private static final String SELECT_ID_PWD=
			"SELECT user_id, password, user_name, postcode, address, email, job, birthday FROM user_account "
			+ "WHERE user_id=? AND password=?";
	
	@Override
	public User findByUserIdAndPassword(String userId, String password) {
		
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		return this.template.queryForObject(SELECT_ID_PWD, mapper, userId, password);
			
	}
}
