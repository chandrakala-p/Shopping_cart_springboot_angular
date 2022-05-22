package com.gl.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name="Order_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int orderId;
	String orderName;
	int orderPrice;
	
	
	@JsonIgnore
	@ToString.Exclude
	@ManyToMany(targetEntity = User.class, mappedBy = "userOrders", cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	private List<User> users;
	

	
	@ToString.Exclude
	@OneToMany(mappedBy = "order" ,cascade= CascadeType.ALL)
	@JsonIgnore
	private List<Item> orderItems;
	
	

	
//	
}
