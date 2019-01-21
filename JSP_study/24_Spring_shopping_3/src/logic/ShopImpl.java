package logic;
 
public class ShopImpl implements Shop{
	private UserCatalog userCatalog;
	
	public void setUserCatalog(UserCatalog userCatalog){
		this.userCatalog=userCatalog;
	}
	@Override
	public User getUserByUserIdAndPassword(String userId, String password){
		
		return userCatalog.getUserByUserIdAndPassword(userId, password);
	}

	
}//class end
