package com.gl.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.beans.Order;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Integer> {

}
