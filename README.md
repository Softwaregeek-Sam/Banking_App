# 🏦 DemoBank — Full-Stack Digital Banking Platform

DemoBank is a full-stack digital banking application designed to model
real-world banking workflows such as user onboarding, account management,
fund transfers, and transaction handling.

The project focuses on understanding how a **React-based frontend**
interacts with a **Spring Boot backend** to deliver secure, consistent,
and scalable banking features. While the frontend explores state
management using React and Redux, the backend drives the core business
logic, data integrity, and authorization rules.

This application is built with a strong emphasis on **backend clarity,
service-layer design, and real-world data flows**, rather than just basic
CRUD operations.

---

## 🏗️ Core Modules & Architecture

### 🔐 Authentication & User Management
- User registration and login
- Role-based access control (User / Admin)
- Secure credential handling
- Backend-driven authorization checks

---

### 👤 User Profile Management
- View and update user profile details
- Account ownership mapping
- User-level access restrictions

---

### 💳 Account Management
- Support for multiple accounts per user
- Account lifecycle management
- Balance tracking and consistency

---

### 🔄 Transaction & Fund Transfer
- Secure fund transfers between accounts
- Backend validation to prevent inconsistent states
- Transaction history tracking
- Atomic operations at service level

---

### 📂 File & Content Handling
- User file uploads
- Admin-level access to uploaded files
- Controlled access and download permissions

---

### 🛡️ Admin Capabilities
- User account removal
- Access revocation while retaining historical records
- File inspection and moderation

---

## 🔄 Typical Banking Flow

1. ✅ User registers and logs in
2. 🏦 User creates and manages bank accounts
3. 💰 Funds are deposited into accounts
4. 🔁 Transfers are initiated between accounts
5. 📊 Transactions are validated and persisted
6. 🧾 History and balances are updated consistently

---

## 📦 Tech Stack

| Layer | Technology |
|-----|-----------|
| **Backend** | Java, Spring Boot |
| **Frontend** | React, Redux |
| **Database** | MySQL |
| **Security** | Spring Security |
| **Build Tools** | Maven, npm |
| **Optional Infra** | Docker, Docker Compose |

---

## 🧠 Key Design Highlights

- Backend-driven business logic
- Clear separation between controllers, services, and persistence
- Consistent transaction handling
- Role-aware API access
- Scalable architecture suitable for real banking use cases
- Designed to be easily extendable

---

## 🚀 Running the Application

### Prerequisites
- Java JDK (17 recommended)
- Maven
- Node.js and npm
- MySQL (for non-Docker setup)

---

### Run Without Docker

#### Backend (Spring Boot)
```bash
cd backend
./mvnw spring-boot:run
