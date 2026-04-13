package com.bharti.fintech.orderservice.service;

import com.bharti.fintech.orderservice.enums.OrderStatus;
import com.bharti.fintech.orderservice.mapper.OrderMapper;
import com.bharti.fintech.orderservice.model.Order;
import com.bharti.fintech.orderservice.repository.OrderRepository;
import com.bharti.fintech.orderservice.request.OrderRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private OrderRepository repository;
    private OrderMapper mapper;
    private AuditService auditService;

    public OrderService(OrderRepository repository, OrderMapper mapper, AuditService auditService) {
        this.repository = repository;
        this.mapper = mapper;
        this.auditService = auditService;
    }

    @CachePut(value = "orders", key = "#result.orderId")
    public Order createOrder(OrderRequest request) {
        try {

            // 🔴 SIMPLE VALIDATION (example)
            if (request.getUserId() == null) {

                auditService.log(
                        "VALIDATION_FAILED",
                        "UNKNOWN",
                        null,
                        "FAILURE",
                        "userId is null"
                );

                throw new RuntimeException("userId is required");
            }

            Order order = new Order();
            order.setUserId(request.getUserId());
            order.setStatus(OrderStatus.CREATED);

            Order saved = repository.save(order);

            auditService.log(
                    OrderStatus.CREATED.toString(),
                    request.getUserId().toString(),
                    saved.getOrderId().toString(),
                    "SUCCESS",
                    "Order created successfully"
            );

            return saved;

        } catch (Exception e) {

            // 🔥 SYSTEM FAILURE AUDIT (CRITICAL PART)
            auditService.log(
                    "ORDER_FAILED",
                    request.getUserId() != null ? request.getUserId().toString() : "UNKNOWN",
                    null,
                    "FAILURE",
                    e.getMessage()
            );

            throw e;
        }
    }


    @Cacheable(value = "orders", key = "#id")
    public Order getOrder(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Order> getAllOrders() {
        return repository.findAll();
    }
}
