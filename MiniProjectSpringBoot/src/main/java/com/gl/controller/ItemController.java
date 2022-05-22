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

import com.gl.beans.Item;
import com.gl.beans.ResponseMessage;
import com.gl.exception.ProjectException;
import com.gl.service.IItemService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ItemController {
	
	@Autowired
	IItemService itemService;

	
	@RequestMapping(method = RequestMethod.POST, value = "/addItem")
	public ResponseEntity<Item> addItem(@RequestBody Item item) {

		return new ResponseEntity<Item>(itemService.addItem(item), HttpStatus.CREATED);
	}

	
	@RequestMapping(method = RequestMethod.GET, value = "/getAllItems")
	public ResponseEntity<List<Item>> getAllItems() {

		return new ResponseEntity<List<Item>>(itemService.getAllItems(), HttpStatus.OK);
	}


	@RequestMapping(method = RequestMethod.GET, value = "/getItemById/{id}")
	public ResponseEntity<Item> getOrderById(@PathVariable("id") Integer id) throws ProjectException {

		return new ResponseEntity<Item>(itemService.getItemById(id), HttpStatus.OK);
	}

	
	@RequestMapping(method = RequestMethod.PUT, value = "/updateItem")
	public ResponseEntity<Item> updateItem(@RequestBody Item item) throws ProjectException {

		return new ResponseEntity<Item>(itemService.updateItem(item), HttpStatus.OK);
	}

	
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteItemById/{id}")
	public ResponseEntity<ResponseMessage> deleteItemById(@PathVariable("id") int id) throws ProjectException {
		ResponseMessage rm = new ResponseMessage();
		rm.setMessage(itemService.deleteItemById(id));
		return new ResponseEntity<ResponseMessage>(rm, HttpStatus.OK);
	}

	
	
	@RequestMapping(method = RequestMethod.GET, value = "/getItemsByOrderId/{orderId}")
	public ResponseEntity<List<Item>> getOrderByUserId(@PathVariable int orderId) throws ProjectException {

		return new ResponseEntity<List<Item>>(itemService.getItemsByOrderId(orderId), HttpStatus.OK);
	}
	
	@ExceptionHandler(ProjectException.class)
	public ResponseEntity<ResponseMessage> handleEmployeeIdException(HttpServletRequest request, Exception ex) {
		ResponseMessage rm = new ResponseMessage();
		rm.setMessage(ex.getMessage());
		rm.setErrorCode(404);
		return new ResponseEntity<ResponseMessage>(rm, HttpStatus.NOT_FOUND);
	}



}
