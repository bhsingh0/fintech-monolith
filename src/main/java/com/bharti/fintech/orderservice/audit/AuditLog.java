package com.bharti.fintech.orderservice.audit;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "audit_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String action;        // ORDER_CREATED, ORDER_FETCHED
    private String userId;      // user/service
    private String entityId;      // orderId (optional)
    private String status;
    private String correlationId;
    private String message;       // payload snapshot
    private LocalDateTime timestamp;
}
