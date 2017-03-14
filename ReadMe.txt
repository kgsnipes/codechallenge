System requirements:
	- JDK/JRE 1.8 and above
	- Maven 3.x and above
	- MySql 5.7 an above
	
MySql Config to be available before execution:
	- database config is available in the path src/main/resources/application.properties
	- change this as required.
	
	
Instructions for Build:
	
	To build with JUnit tests: 
	 >mvn clean package

	To skip running JUnit test while building 
	>mvn clean package -Dmaven.test.skip=true
	
	or 
	
	>mvnw clean package
	
	
Instructions for execution:

	Just execute the following on the command prompt.
	> java -jar target/codechallenge-0.0.1-SNAPSHOT.jar

Link to swagger UI - REST API explorer for the application:
	http://localhost:8080/swagger-ui.html

JUnit test execution:
	>mvn test

	
Notes:
- This REST Service application is based on Spring Boot Version 1.5.2
- All the config for the app is provided in com.codechallenge.config.AppConfig.java
- For brevity, the security on the rest web services have not been added.
- For brevity, have avoided the DTO layer. Have used DAO bean even at the controller.
- For brevity, have avoided all the default enterprise design of timestamp tracking of the data models.
- JUnit test cases are available for order and product service. A stress test of 200 threads for place order is also added.
- For brevity, avoided localization of data in the models.
- For brevity, some literals have been mentioned inline.














