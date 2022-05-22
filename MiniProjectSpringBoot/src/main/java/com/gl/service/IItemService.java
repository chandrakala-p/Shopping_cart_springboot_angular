package com.gl.service;

import java.util.List;

import com.gl.beans.Item;
import com.gl.exception.ProjectException;

public interface IItemService {
	
	public Item addItem(Item item);

	public List<Item> getAllItems();

	public Item getItemById(Integer itemId) throws ProjectException;

	public Item updateItem(Item item) throws ProjectException;

	public String deleteItemById(Integer itemId) throws ProjectException;
	
	public List<Item> getItemsByOrderId(Integer orderId) throws ProjectException;

}
