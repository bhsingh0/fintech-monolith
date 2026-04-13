package com.bharti.fintech.orderservice.repository;

import com.bharti.fintech.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
