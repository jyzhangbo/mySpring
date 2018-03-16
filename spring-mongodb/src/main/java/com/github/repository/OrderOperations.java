package com.github.repository;

import com.github.db.Order;

import java.util.List;

/**
 * zhangbo
 */
public interface OrderOperations {
    List<Order> findOrdersByType(String type);
}
