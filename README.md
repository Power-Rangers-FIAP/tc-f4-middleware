# 🌐 **tc-f4-middleware** 🚀

## 📜 Description
The **`tc-f4-middleware`** is a middleware solution designed to facilitate communication between microservices in a distributed architecture. It is responsible for managing **service discovery**, **load balancing**, and **communication** between the different services in the application. The `tc-f4-middleware` integrates with **Eureka** to perform **service registration** and **discovery**.

## ⚙️ Functionality
This middleware aims to:

- 🧩 **Eureka Server**: Service registration and discovery.
- 🔄 **API Gateway**: Managing incoming requests, routing, and communication with microservices.

It was developed using **Spring Boot** and **Spring Cloud**, and utilizes **Docker** and **Docker Compose** to facilitate the development and deployment environment.

## 🛠️ Technologies Used

- **🔸 Spring Boot**: Framework for creating microservices.
- **🔹 Spring Cloud**: Facilitates the use of distributed components like Eureka for service registration.
- **📍 Eureka Server**: Service for registering and discovering microservices.
- **🌐 API Gateway**: Responsible for routing requests to the appropriate microservices.
- **🐳 Docker & Docker Compose**: Used for **containerization** and **orchestration** of services.

## 🧩 Components

The application consists of the following microservices:

1. **🔍 Eureka Server** (`eureka-server`):
    - **Registration** and **discovery** service.
    - Allows other microservices to register and locate each other.

2. **🔀 API Gateway** (`api-gateway`):
    - Routes user requests to the appropriate microservices.
    - Performs functions like **authentication**, **validation**, and **route-based routing**.

## 🚀 How to Run

### 🛠️ Prerequisites

1. **🐋 Docker**: Make sure Docker is installed on your machine.
    - [Install Docker](https://www.docker.com/get-started)

2. **🧩 Docker Compose**: Docker Compose is used for container orchestration.
    - [Install Docker Compose](https://docs.docker.com/compose/install/)

### ⚡ Steps to run the application

1. **Clone the repository:**

   ```bash
   git clone https://github.com/your-username/tc-f4-middleware.git
   cd tc-f4-middleware
