package com.gl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.beans.Item;

@Repository
public interface IItemRepository extends JpaRepository<Item, Integer> {

}
