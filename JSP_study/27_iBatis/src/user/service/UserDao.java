package user.service;

import java.util.List;

import model.User;




//�������̽�: �߻�޼���
public interface UserDao {
	//selectAll
	public List<User> getList();
	
	//insert
	public String writeUser(User user);
	
	//select userId
	public User getUser(String userId);

	//modify
	public void modifyUser(User user);
	
	//delete
	public void deleteUser(String userId);

	
}//class end
