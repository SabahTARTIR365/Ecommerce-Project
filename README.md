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

- Install MySQL and create databases named ecommerce_system_shop, ecommerce_system_wallet, and ecommerce_system_inventory.
- Configure the database connection properties in each microservice's application.properties file.
3. Import the project into your IDE and run each microservice using Spring Boot's built-in run configuration.

4. Alternatively, use Docker Compose to deploy the entire application:

- Open a terminal and navigate to the project directory.
- Run the following command to start the services: docker-compose up.
5. Once the services are running, you can access the following endpoints:

- Shop Service API: http://localhost:9002/api/shop
- Wallet Service API: http://localhost:9003/api/wallet
- Inventory Service API: http://localhost:9001/api/inventory
- Swagger API Documentation: http://localhost:9002/swagger-ui.html
6.  To access the Wallet Service UI for user registration:

- Open a web browser and navigate to: http://localhost:9003/register
