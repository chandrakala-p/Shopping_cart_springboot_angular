package com.gl.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gl.beans.Order;
import com.gl.beans.ResponseMessage;
import com.gl.exception.ProjectException;
import com.gl.service.IOrderService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class OrderController {
	
	@Autowired
	IOrderService orderService;

	// Add order
	@RequestMapping(method = RequestMethod.POST, value = "/addOrder")
	public ResponseEntity<Order> addOrder(@RequestBody Order order) {

		return new ResponseEntity<Order>(orderService.addOrder(order), HttpStatus.CREATED);
	}

	// Get All orders)
	@RequestMapping(method = RequestMethod.GET, value = "/getAllOrders")
	public ResponseEntity<List<Order>> getAllOrders() {

		return new ResponseEntity<List<Order>>(orderService.getAllOrders(), HttpStatus.OK);
	}

	// Get order By ID
	@RequestMapping(method = RequestMethod.GET, value = "/getOrderById/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable("id") Integer id) throws ProjectException {

		return new ResponseEntity<Order>(orderService.getOrderById(id), HttpStatus.OK);
	}

	// Update orders
	@RequestMapping(method = RequestMethod.PUT, value = "/updateOrder")
	public ResponseEntity<Order> updateOrder(@RequestBody Order order) throws ProjectException {

		return new ResponseEntity<Order>(orderService.updateOrder(order), HttpStatus.OK);
	}

	// Delete order By Id
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteOrderById/{id}")
	public ResponseEntity<ResponseMessage> deleteOrderById(@PathVariable("id") int id) throws ProjectException {
		ResponseMessage rm = new ResponseMessage();
		rm.setMessage(orderService.deleteOrderById(id));
		return new ResponseEntity<ResponseMessage>(rm, HttpStatus.OK);
	}

	// Add order To user
	@RequestMapping(method = RequestMethod.POST, value = "/addOrderToUser/{userId}/{orderId}")
	public ResponseEntity<String> addBooksToLike(@PathVariable int userId, @PathVariable int orderId)
			throws ProjectException {
		return new ResponseEntity<String>(orderService.addOrdersToUser(userId, orderId), HttpStatus.OK);
	}

	// Delete order From user
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteOrdersFromUser/{userId}/{orderId}")
	public ResponseEntity<String> deleteOrdersFromUser(@PathVariable int userId, @PathVariable int orderId)
			throws ProjectException {
		return new ResponseEntity<>(orderService.removeOrdersfromUser(userId, orderId), HttpStatus.OK);
	}

	
	
	@RequestMapping(method = RequestMethod.GET, value = "/getOrderByUserId/{userId}")
	public ResponseEntity<List<Order>> getOrderByUserId(@PathVariable int userId) throws ProjectException {

		return new ResponseEntity<List<Order>>(orderService.getOrdersByUserId(userId), HttpStatus.OK);
	}
	
	@ExceptionHandler(ProjectException.class)
	public ResponseEntity<ResponseMessage> handleEmployeeIdException(HttpServletRequest request, Exception ex) {
		ResponseMessage rm = new ResponseMessage();
		rm.setMessage(ex.getMessage());
		rm.setErrorCode(404);
		return new ResponseEntity<ResponseMessage>(rm, HttpStatus.NOT_FOUND);
	}


}
