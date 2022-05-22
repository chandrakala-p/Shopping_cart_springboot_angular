package com.gl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.beans.Item;
import com.gl.beans.Order;
import com.gl.dao.IItemRepository;
import com.gl.dao.IOrderRepository;
import com.gl.exception.ProjectException;

@Service
public class ItemServiceImpl implements IItemService {

	@Autowired
	IOrderRepository orderRepository;
	@Autowired
	IItemRepository itemRepository;

	@Override
	public Item addItem(Item item) {
		// TODO Auto-generated method stub
		return itemRepository.save(item);
	}

	@Override
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		return itemRepository.findAll();
	}

	@Override
	public Item getItemById(Integer itemId) throws ProjectException {
		// TODO Auto-generated method stub
		return itemRepository.findById(itemId).orElseThrow(() -> new ProjectException("Item Id not found"));
	}

	@Override
	public Item updateItem(Item item) throws ProjectException {
		// TODO Auto-generated method stub
		itemRepository.findById(item.getItemId()).orElseThrow(() -> new ProjectException("Item Id not found"));
		return itemRepository.saveAndFlush(item);
	}

	@Override
	public String deleteItemById(Integer itemId) throws ProjectException {
		// TODO Auto-generated method stub
		Item item = itemRepository.findById(itemId)
				.orElseThrow(() -> new ProjectException("Item Id not found"));
		itemRepository.delete(item);
		return "Item deleted succesfully";
	}

	

	@Override
	public List<Item> getItemsByOrderId(Integer orderId) throws ProjectException {
		// TODO Auto-generated method stub
		 Order order=orderRepository.findById(orderId).orElseThrow(() -> new ProjectException("Order Id not found"));
		 return order.getOrderItems();
	}

	
}
