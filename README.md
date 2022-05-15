## NatWest Assessment
Write a RESTful service which calculates and returns all the prime numbers up to and including a number provided.

##### Project configurations
Java 8<br>
Spring boot 2.6.7<br>
Maven 3.6.3<br>
Cucumber

##### Running instructions
- Clone the repository
- Run `mvn clean install` on the root folder natwest-assessment
- Run `NatwestAssessmentApplication` Spring Boot Application. The application will be started at port 8080.
- Test application using Postman or some other Rest client
- API: ` POST http://localhost:8080/prime`
- Sample request body: <br>
`{
   "input": "10"
 }`
 
 ##### JUnits
 JUnit test for service class is covered in `PrimeNumberServiceTest.java`
 JUnit test to check if controller loads successfully is covered in `NatwestAssessmentApplicationTests.java`
 
 ##### Cucumber Integration tests
 Pre-requisites
 - Make sure the application is up and running on port 8080
 - Run `CucumberIntegrationTest.java`
 - Integration tests covers both Success and error scenarios, that is, 200 and 400 error responses

##### Swagger documentation
- Make sure the application is running on port 8080
- Launch Swagger UI: `http://localhost:8080/swagger-ui.html` and click on "prime-number-controller" link on UI.
