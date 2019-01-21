package dao;

import java.util.*;

import logic.Item;

public interface ItemDao {
	List<Item> findAll(); //추상
	
	public Item findByPrimaryKey(Integer itemId); //추상
	
}
