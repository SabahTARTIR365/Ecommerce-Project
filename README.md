# E-commerce-Project
![image](https://github.com/SabahTARTIR365/Ecommerce-Project/assets/60351703/137f520d-01f3-44b7-a3c9-6d943808a72b)
# Microservice E-commerce Project 
This is a sample Microservice E-commerce project built using Spring Boot. The project consists of three microservices: Shop, Wallet, and Inventory. It utilizes MySQL as the database, and each microservice is independently deployed and managed. The project also includes a Naming Server (Eureka) for service discovery and an API Gateway to route incoming requests to the appropriate microservices. Additionally, Swagger is integrated to provide comprehensive API documentation.

# Services
* Shop Service - Handles product details and order processing.
* Wallet Service - Manages user accounts, including registration and balance updates.
* Inventory Service - Handles product inventory and stock management.
# Prerequisites
  - Docker and Docker Compose for containerization and easy deployment.
  - MySQL Server for database management.
  - Java Development Kit (JDK) 11 or higher for running the Spring Boot applications.
  - An integrated development environment (IDE) like IntelliJ or Eclipse.
# Getting Started
1. Clone the repository to your local machine.

2. Set up the MySQL database:

    - Install MySQL and create databases named ecommerce_system_shop, ecommerce_system, and ecommerce_system_inventory.
    - Configure the database connection properties in each microservice's application.properties file.
3. Configure the Spring Cloud Config Server:

   - Open the application.properties file in the Config Server project and set the path to your remote GitHub repository containing the configuration files for the microservices.
   - Import the project into your IDE and run each microservice using Spring Boot's built-in run configuration.

4. Alternatively, use Docker Compose to deploy the entire application:

     - Open a terminal and navigate to the project directory.
     - Run the following command to start the services: docker-compose up.
5. Once the services are running, you can access the following endpoints:
   
   - Inventory Service API: http://localhost:9001/api/inventory-service
   - Shop Service API: http://localhost:9002/shop-service
   - Wallet Service API: http://localhost:9003/wallet-service
   - Swagger API Documentation: http://localhost:9001/swagger-ui.html
   - Swagger API Documentation: http://localhost:9002/swagger-ui.html
   - Swagger API Documentation: http://localhost:9003/swagger-ui.html
7.  To access the Wallet Service UI for user registration:
    - Open a web browser and navigate to: http://localhost:9003/register
# Architecture Overview
The project follows a microservices architecture to ensure loose coupling and easy scalability. Each microservice is responsible for a specific domain and communicates with other services via RESTful APIs. The Eureka Naming Server is used for service registration and discovery, enabling each service to locate and communicate with others without hardcoding their addresses. The API Gateway routes incoming requests to the appropriate microservices based on the request URI.

# Technologies Used
- Spring Boot: For building the microservices.
- MySQL: As the database management system.
- Docker: For containerizing the application.
- Docker Compose: For orchestrating multiple containers.
- Eureka Naming Server: For service discovery and registration.
- API Gateway: For routing requests to the appropriate services.
- Swagger: For comprehensive API documentation.
- Thymeleaf: For creating UI in the Wallet Service.
- Feign Client: For easy and efficient communication between microservices.
- Circuit Breaker: For enhanced resilience and failure handling.
- Spring Cloud Config Server: For centralized configuration management by Github.
