package com.github.lebw.tacocloud.repository;

import com.github.lebw.tacocloud.domain.Order;

/**
 * @author LBW
 */
public interface OrderRepository {
    Order save(Order order);
}
