package dao;

import java.util.*;

import logic.Item;

public interface ItemDao {
	List<Item> findAll(); //�߻�
	
	public Item findByPrimaryKey(Integer itemId); //�߻�
	
}
