package com.github.lebw.tacocloud.repository;

import com.github.lebw.tacocloud.domain.Order;
import org.springframework.data.repository.CrudRepository;

/**
 * @author LBW
 */
public interface OrderRepository extends CrudRepository<Order, Long> {
//    Order save(Order order);
}
