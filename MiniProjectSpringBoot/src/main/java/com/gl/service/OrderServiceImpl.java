package com.gl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.beans.Order;
import com.gl.beans.User;
import com.gl.dao.IOrderRepository;
import com.gl.dao.IUserRepository;
import com.gl.exception.ProjectException;

@Service
public class OrderServiceImpl  implements IOrderService  {

	@Autowired
	IUserRepository userRepository;
	
	@Autowired
	IOrderRepository orderRepository;
	
	
	@Override
	public Order addOrder(Order order) {
		// TODO Auto-generated method stub
		return orderRepository.save(order);
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRepository.findAll();
	}

	@Override
	public Order getOrderById(Integer orderId) throws ProjectException {
		// TODO Auto-generated method stub
		return orderRepository.findById(orderId).orElseThrow(() -> new ProjectException("Order Id not found"));
	}

	@Override
	public Order updateOrder(Order order) throws ProjectException {
		// TODO Auto-generated method stub
		orderRepository.findById(order.getOrderId()).orElseThrow(() -> new ProjectException("Order Id not found"));
		return orderRepository.saveAndFlush(order);
	}

	@Override
	public String deleteOrderById(Integer orderId) throws ProjectException {
		// TODO Auto-generated method stub
		Order order= orderRepository.findById(orderId).orElseThrow(() -> new ProjectException("Order Id not found"));
		orderRepository.delete(order);
		return "Order deleted succesfully";
	}

	@Override
	public String addOrdersToUser(Integer userId, Integer orderId) throws ProjectException {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId).orElseThrow(() -> new ProjectException("User Id not found"));
	 Order order=orderRepository.findById(orderId).orElseThrow(() -> new ProjectException("Order Id not found"));
	 List<Order> userOrders=user.getUserOrders();
	 userOrders.add(order);
	 user.setUserOrders(userOrders);
	 userRepository.save(user);
	 return "The order added to user";
	}

	@Override
	public List<Order> getOrdersByUserId(Integer userId) throws ProjectException {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId).orElseThrow(() -> new ProjectException("User Id not found"));
		return user.getUserOrders();
	}

	@Override
	public String removeOrdersfromUser(Integer userId, Integer orderId) throws ProjectException {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId).orElseThrow(() -> new ProjectException("User Id not found"));
		 Order order=orderRepository.findById(orderId).orElseThrow(() -> new ProjectException("Order Id not found"));
		 List<Order> userOrders=user.getUserOrders();
		 userOrders.removeIf( data -> (data.getOrderId()==order.getOrderId()));
		 user.setUserOrders(userOrders);
		 userRepository.save(user);
		 return "The order deleted from user";
	}

}
