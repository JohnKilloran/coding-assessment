# coding-assessment
Spring Boot microservices coding assessment

1. Build the application using mvnw wrapper included in the project (compile/test/etc.)
2. Run the application from within your IDE by running uk.co.killoran.codingassessment.CodingAssessmentApplication
or from the command line using "java -jar target/coding-assessment-0.0.1-SNAPSHOT.jar" from the project root directory.
   1. NOTE since demo only you will have to take a note of the password generated in the console output for the user "user" in order to login to the service
   2. No certificate was generated so http is used instead of https (which would be the norm)
3. Service is up - check http://localhost:8080/actuator/health
4. Swagger ui is available at http://localhost:8080/swagger-ui/index.html