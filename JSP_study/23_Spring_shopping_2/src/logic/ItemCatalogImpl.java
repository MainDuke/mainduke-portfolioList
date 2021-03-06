package logic;

import java.util.*;

import dao.ItemDao;

public class ItemCatalogImpl implements ItemCatalog {

	private ItemDao itemDao; //����
	
	

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	
	
	@Override
	public List<Item> getItemList() {
		// TODO Auto-generated method stub
	
		return this.itemDao.findAll();
	}
	
	@Override
	public Item getItemByItemId(Integer itemId) {
		return this.itemDao.findByPrimaryKey(itemId);
	}
	
}//class end
