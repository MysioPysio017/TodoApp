# Todo Application

## Description
A Spring Boot application for managing todos. Project in development.

## Technologies
- Java 21 
- Spring Boot 3.4.2
- Maven

## Configuration
1. **Create a database** using MySQL.
For example, create a database named 'spring_todo'.

2. **Update/Create your application.properties file:**
Set your datasource properties.
Example:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
```
Also add 
```bash
spring.jpa.hibernate.ddl-auto=update
```
This configuration allows Hibernate to automatically create/update the tables based on your entities when the application starts.

3. **Run the application:** 
Compile and run the application using:
```bash
mvn spring-boot:run
```
Once the application is running, you should see the tables created in the database.
 