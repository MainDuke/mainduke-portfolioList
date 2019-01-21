package logic;

import java.util.*;

import dao.ItemDao;

public class ItemCatalogImpl implements ItemCatalog {

	private ItemDao itemDao; //º¯¼ö
	
	

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	
	
	@Override
	public List<Item> getItemList() {
		// TODO Auto-generated method stub
	
		return this.itemDao.findAll();
	}
	
	
}//class end
