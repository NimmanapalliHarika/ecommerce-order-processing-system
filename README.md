# ecommerce-order-processing-system
# 🛒 E-Commerce Order Processing System

> A production-ready microservices-based e-commerce backend built using **Java 21**, **Spring Boot**, **Spring Cloud**, **Apache Kafka**, **Redis**, **Docker**, **GitHub Actions**, and **AWS**.

This project demonstrates a real-world enterprise backend architecture with secure authentication, event-driven communication, caching, containerization, CI/CD, and cloud deployment. It is designed to showcase backend engineering best practices and production-ready software development.

---

## 🚀 Project Overview

The **E-Commerce Order Processing System** is a scalable backend application developed using a microservices architecture.

It simulates how modern e-commerce platforms process customer orders by separating business functionalities into independent services. Each service owns its own database and communicates through REST APIs or asynchronous events using Apache Kafka.

The project emphasizes clean architecture, loose coupling, scalability, maintainability, and cloud-native deployment.

---

# ✨ Features

* User Registration & Login
* JWT Authentication & Authorization
* Product Management
* Inventory Management
* Order Processing
* Event-Driven Communication using Kafka
* Email Notifications
* Redis Caching
* Service Discovery using Eureka
* API Gateway
* RESTful APIs
* Global Exception Handling
* Bean Validation
* Swagger API Documentation
* Dockerized Microservices
* GitHub Actions CI/CD Pipeline
* AWS EC2 Deployment
* Production-Ready Project Structure

---

# 🏗️ System Architecture

```text
                    Client
                       │
                       ▼
                 API Gateway
                       │
      ┌────────┬─────────────┬─────────┐
      │        │             │         │
      ▼        ▼             ▼         ▼
 Auth Service Product Service Order Service Inventory Service
                                      │
                                      ▼
                                Apache Kafka
                                      │
                                      ▼
                           Notification Service
                                      │
                                      ▼
                                 Email Service
```

---

# 🛠️ Technology Stack

| Category          | Technology                 |
| ----------------- | -------------------------- |
| Language          | Java 21                    |
| Framework         | Spring Boot 3              |
| Microservices     | Spring Cloud               |
| Service Discovery | Eureka Server              |
| API Gateway       | Spring Cloud Gateway       |
| Security          | Spring Security, JWT       |
| Database          | MySQL                      |
| ORM               | Spring Data JPA, Hibernate |
| Messaging         | Apache Kafka               |
| Cache             | Redis                      |
| API Documentation | Swagger / OpenAPI          |
| Build Tool        | Maven                      |
| Containerization  | Docker & Docker Compose    |
| CI/CD             | GitHub Actions             |
| Cloud             | AWS EC2                    |
| Version Control   | Git & GitHub               |

---

# 📦 Microservices

### Discovery Service

Maintains the registry of all microservices using Eureka Server.

### API Gateway

Acts as the single entry point for all client requests and routes them to the appropriate services.

### Authentication Service

Handles user registration, login, JWT generation, and authorization.

### Product Service

Manages products, categories, pricing, and product information.

### Inventory Service

Tracks product stock availability and updates inventory after successful orders.

### Order Service

Processes customer orders and coordinates with inventory while publishing order events to Kafka.

### Notification Service

Consumes Kafka events and sends email notifications to customers after successful order placement.

---

# 🔄 Order Processing Flow

```text
User Login
     │
     ▼
JWT Authentication
     │
     ▼
Browse Products
     │
     ▼
Place Order
     │
     ▼
Inventory Validation
     │
     ▼
Order Created
     │
     ▼
Kafka Event Published
     │
     ▼
Notification Service
     │
     ▼
Email Sent
```

---

# 📂 Project Structure

```text
ecommerce-order-processing-system
│
├── discovery-service
├── api-gateway
├── auth-service
├── product-service
├── inventory-service
├── order-service
├── notification-service
│
├── architecture
│   ├── architecture-diagram.png
│   ├── sequence-diagram.png
│   └── deployment-diagram.png
│
├── postman
│   └── ecommerce.postman_collection.json
│
├── .github
│   └── workflows
│       └── ci.yml
│
├── docker-compose.yml
├── README.md
└── LICENSE
```

---

# 📌 API Modules

## Authentication APIs

```
POST /api/auth/register
POST /api/auth/login
```

## Product APIs

```
GET /api/products
GET /api/products/{id}
POST /api/products
PUT /api/products/{id}
DELETE /api/products/{id}
```

## Inventory APIs

```
GET /api/inventory/{productId}
PUT /api/inventory/update
```

## Order APIs

```
POST /api/orders
GET /api/orders/{id}
GET /api/orders/user/{userId}
```

---

# ⚡ Event-Driven Architecture

Apache Kafka is used to enable asynchronous communication between services.

**Example Flow**

```
Order Service
      │
Publishes OrderCreated Event
      │
      ▼
Kafka Topic
      │
      ▼
Notification Service
      │
      ▼
Email Sent to Customer
```

---

# ⚡ Redis Caching

Redis is used to cache frequently accessed data such as:

* Product List
* Product Details
* Categories
* Frequently Viewed Products

This reduces database load and improves API response times.

---

# 🐳 Docker

Every microservice is containerized using Docker.

Docker Compose orchestrates:

* MySQL
* Redis
* Apache Kafka
* Eureka Server
* API Gateway
* All Microservices

---

# ☁️ AWS Deployment

The complete application will be deployed on AWS using:

* EC2 Instance
* Docker Compose
* GitHub Actions
* Nginx Reverse Proxy (Optional)

Deployment screenshots and the live application URL will be added after deployment.

---

# 🔄 CI/CD Pipeline

GitHub Actions will automate:

* Build
* Unit Testing
* Docker Image Creation
* Deployment to AWS EC2

