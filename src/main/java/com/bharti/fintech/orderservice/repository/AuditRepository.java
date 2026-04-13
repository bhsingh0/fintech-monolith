package com.bharti.fintech.orderservice.repository;

import com.bharti.fintech.orderservice.audit.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<AuditLog, Long> {
}
