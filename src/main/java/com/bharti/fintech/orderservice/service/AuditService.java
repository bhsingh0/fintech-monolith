package com.bharti.fintech.orderservice.service;

import com.bharti.fintech.orderservice.audit.AuditLog;
import com.bharti.fintech.orderservice.repository.AuditRepository;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditService {
    private final AuditRepository auditRepository;

    public AuditService(AuditRepository auditRepository) {
        this.auditRepository = auditRepository;
    }

    public void log(String action,
                    String userId,
                    String entityId,
                    String status,
                    String message) {

        AuditLog log = new AuditLog();
        log.setAction(action);
        log.setUserId(userId);
        log.setEntityId(entityId);
        log.setStatus(status);
        log.setMessage(message);
        log.setTimestamp(LocalDateTime.now());

        log.setCorrelationId(MDC.get("correlationId"));

        auditRepository.save(log);
    }
}
