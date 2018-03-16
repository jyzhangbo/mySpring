package com.github.repository.impl;

import com.github.db.Order;
import com.github.repository.OrderOperations;
import com.github.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * zhangbo
 */
public class OrderRepositoryImp implements OrderOperations{

    @Autowired
    private MongoOperations operations;

    @Override
    public List<Order> findOrdersByType(String type) {
        return operations.find(Query.query(Criteria.where("type").is("dizhi")),Order.class);
    }
}
