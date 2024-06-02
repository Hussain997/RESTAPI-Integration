Integration Assignment
    Description
        Spring Boot REST API in Java to consume "https://api.coindesk.com/v1/bpi/currentprice.json", saving data into a database

Technology Stack
Spring Boot 3.3.0
Java 17
JUnit 5
Maven
Hibernate
Spring Data JPA
MySQL
Jacoco

Instructions to Run the Project
Clone the repository from GitHub: https://github.com/Hussain997/RESTAPI-Integration
Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse, SpringToolSuite).
Ensure you have Java 17+ installed on your machine.
Configure MySQL database settings in application.yml file located in src/main/resources.
Create Database coindesk in MySQL.
Change the database username and password in application.yml.
Default port of the database is 8086. Configure as per your database port in application.yml.
Build the project using Maven: mvn clean install.
Run the application: mvn spring-boot:run.
The application will start running on localhost:8086.
API Endpoints
You can use URL (http://localhost:8086/coindesk/fetch-data) for API Endpoints.

Scripts for Database Setup
A script file named Scheme.sql located in src/main/resources/db containing SQL commands to create the necessary database schema and tables.

Running Unit Tests
Run unit tests using Maven: mvn test or right-click on the project and Run As Maven Test or Junit Test.
Check the test coverage report generated in the target/site/jacoco/index.html file.
Test coverage is not 100% due to some getter and setter methods. It's 97%. Although the test coverage is high, there are still many test cases missing that address various aspects of the code and business logic.
Please ensure the database is properly configured and running before executing the test cases. The test cases will fail if the database is not running. Note that I have not used any separate profile, or in-memory database, or test containers for these test cases right now.
Project Repository
The project is hosted on GitHub: https://github.com/ahmedasim/blog-service

Project Structure
└── blog-service/  
    ├── src/  
    │   ├── main/  
    │   │   ├── java/  
    │   │   │   └── com/  
    │   │   │       └── aa/  
    │   │   │           └── blog_service/  
    │   │   │               ├── BlogServiceApplication.java  
    │   │   │               ├── controller/  
    │   │   │               │   ├── AuthorController.java  
    │   │   │               │   └── PostController.java  
    │   │   │               ├── dto/  
    │   │   │               │   ├── AuthorRequestDto.java  
    │   │   │               │   ├── AuthorResponseDto.java  
    │   │   │               │   ├── PostRequestDto.java  
    │   │   │               │   ├── PostResponseDto.java  
    │   │   │               │   └── common/  
    │   │   │               │       ├── ApiError.java  
    │   │   │               │       └── ApiResponse.java  
    │   │   │               ├── entity/  
    │   │   │               │   ├── Author.java  
    │   │   │               │   └── Post.java  
    │   │   │               ├── exception/  
    │   │   │               │   └── GlobalExceptionHandler.java  
    │   │   │               ├── repo/  
    │   │   │               │   ├── AuthorRepo.java  
    │   │   │               │   └── PostRepo.java  
    │   │   │               ├── service/  
    │   │   │               │   ├── AuthorService.java  
    │   │   │               │   ├── PostService.java  
    │   │   │               │   └── impl/  
    │   │   │                   ├── AuthorServiceImpl.java  
    │   │   │                   └── PostServiceImpl.java  
    │   │   ├── resources/  
    │   │   │   ├── application.yml  
    │   │   │   └── db/  
    │   │   │       └── migration/  
    │   │   │           └── V01__DB_SCHEMA.sql  
    │   ├── test/  
    │   │   ├── java/  
    │   │   │   └── com/  
    │   │   │       └── aa/  
    │   │   │           └── blog_service/  
    │   │   │               ├── BlogServiceApplicationTests.java  
    │   │   │               ├── controller/  
    │   │   │               │   ├── AuthorControllerTest.java  
    │   │   │               │   └── PostControllerTest.java  
    │   │   │               ├── service/  
    │   │   │                   ├── AuthorServiceImplTest.java  
    │   │   │                   └── PostServiceImplTest.java  
    ├── pom.xml
└── blog-service.postman_collection.json  
└── README.md  
