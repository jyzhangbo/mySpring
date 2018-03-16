package com.github.repository;

import com.github.db.Order;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * zhangbo
 */
public interface OrderRepository extends MongoRepository<Order,Integer>,OrderOperations{

    @Query("{'type' : ?0}")
    List<Order> findByType(String type);
}
