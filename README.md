# Integration Assignment
### Description
Spring Boot REST API in Java to consume "https://api.coindesk.com/v1/bpi/currentprice.json", saving data into a database

### Technology Stack
- Spring Boot 3.3.0
- Java 17
- JUnit 5
- Maven
- Hibernate
- Spring Data JPA
- MySQL
- Jacoco

### Instructions to Run the Project
- Clone the repository from GitHub: https://github.com/Hussain997/RESTAPI-Integration
- Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse, SpringToolSuite).
- Ensure you have Java 17+ installed on your machine.
- Configure MySQL database settings in the application.yml file located in src/main/resources.
- Create Database **coindesk** in MySQL.
- Change the database username and password in application.yml.
- The default port of the database is 3306. Configure as per your database port in application.yml.
- Build the project using Maven: mvn clean install.
- Run the application: mvn spring-boot:run.
- The application will start running on localhost:8086.

### Scripts for Database Setup
A script file named **Scheme.sql** located in src/main/resources/db contains SQL commands to create the necessary database schema and tables.

### API Endpoints
You can use the URL (http://localhost:8086/coindesk/fetch-data) for API Endpoints.


Running Unit Tests
* Run unit tests using Maven: mvn test or right-click on the project and Run As Maven Test or Junit Test.
* Check the test coverage report generated in the target/site/jacoco/index.html file.
