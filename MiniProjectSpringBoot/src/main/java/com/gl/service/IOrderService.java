package com.gl.service;

import java.util.List;


import com.gl.beans.Order;

import com.gl.exception.ProjectException;

public interface IOrderService {

	
	public Order addOrder(Order order);

	public List<Order> getAllOrders();

	public Order getOrderById(Integer orderId) throws ProjectException;

	public Order updateOrder(Order order) throws ProjectException;

	public String deleteOrderById(Integer orderId) throws ProjectException;
	
	public String addOrdersToUser(Integer userId, Integer orderId) throws ProjectException;

	public List<Order> getOrdersByUserId(Integer userId) throws ProjectException;

	String removeOrdersfromUser(Integer userId, Integer orderId) throws ProjectException;
}
