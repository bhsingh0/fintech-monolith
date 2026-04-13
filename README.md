# 🏦 Enterprise Monolith – Order Management System (Spring Boot)

> A production-style Spring Boot monolith built for **enterprise backend learning**, including security, audit logging, and future microservices migration.

---

# 🚀 Tech Stack

- Java 17
- Spring Boot
- Spring Security (JWT + OAuth2 Resource Server)
- Spring Data JPA
- Hibernate
- MySQL / PostgreSQL
- Maven

---

# 🧠 System Architecture
## 🧠 High Level Flow

```text
Client (Postman / Frontend)
        │
        ▼
Spring Boot Monolith Application
        │
        ▼
Controller → Service → Repository
        │
        ▼
Relational Database (SQL)

```
---

## 🧩 Internal Package Structure
```text
controller
service
repository
entity
dto
mapper
security
filter
audit
config
exception
```
---


# 🔐 Security Architecture

## 🔑 Authentication Flow


User → Login → JWT Token Generated → Request → Security Filter → Access Granted


## 🛡️ Security Features

- JWT Authentication
- OAuth2 Resource Server
- Role-Based Access Control (RBAC)
- BCrypt Password Encryption
- Spring Security Filter Chain

---

# 📊 Enterprise Features

## 🔍 Observability

- Correlation ID Filter for request tracing
- Structured logging for debugging
- Request tracking across layers

---

## 🧾 Audit System

- Tracks user actions (CREATE / UPDATE / DELETE)
- Stores system activity logs
- Supports compliance and debugging

---

## 🧩 Mapping Layer

- DTO ↔ Entity mapping using Mapper layer
- Prevents direct database exposure
- Clean separation of concerns

---

# ⚙️ Core Features

- User management
- Order management
- REST APIs
- Secure endpoints with RBAC

---

# 🏗️ System Design

---

# 🚀 2. APPLICATION FLOW

```

+-----------------------------+
| Client (Postman / UI)      |
+-------------+---------------+
              |
              v
+-----------------------------+
| Spring Boot Monolith       |
+-------------+---------------+
              |
              v
+-----------------------------+
| Controller Layer           |
| Service Layer              |
| Repository Layer           |
+-------------+---------------+
              |
              v
+-----------------------------+
| Relational Database (SQL)  |
+-----------------------------+

```
---

# ⚠️ Architecture Limitation

This system follows a **monolithic architecture**, which means:

- Tight coupling between modules
- Single deployment unit
- Limited scalability
- Shared runtime environment

---

# 🔄 Migration Roadmap

This project is designed to evolve into microservices architecture:

## 🟢 Phase 1
- Extract User Service
- Extract Order Service

## 🟡 Phase 2
- Introduce API Gateway

## 🔵 Phase 3
- Add Keycloak (centralized authentication)

## 🟣 Phase 4
- Introduce Hazelcast caching layer

## 🔴 Phase 5
- Event-driven architecture using Kafka

---

```
## 🏦 Target Microservices Architecture (Future)

API Gateway
   │
   ├── User Service
   ├── Order Service
   ├── Payment Service
   │
Kafka Event Bus
   │
Hazelcast Cache Layer
   │
Database per Service
```
---

# 🎯 Learning Outcomes

This project demonstrates:

- Enterprise backend design patterns
- Secure authentication (JWT + OAuth2)
- RBAC authorization
- Audit logging and traceability
- Clean layered architecture
- Microservices migration strategy

---

# 👨‍💻 Author

Backend developer building a fintech-grade distributed system using Spring Boot, evolving from monolith to microservices.

---

# ⭐ Note

This project is a foundational backend system designed to simulate real-world enterprise architecture and migration to distributed microservices systems.