System requirements:
	- JDK/JRE 1.8 and above
	- Maven 3.x and above
	- MySql 5.7 an above
	
	
Instructions for Build:
	>mnv clean
	>mvn compile
	>mvn package

Instructions for execution:

	Just execute the following on the command prompt.
	
	> java -jar target/codechallenge-0.0.1-SNAPSHOT.jar



JUnit test execution:
	>mvn test

	
Info:
- This code challenge is based on Spring Boot Version 1.5.2
- All the config for the app is provided in com.codechallenge.config.AppConfig.java
- For the scope of the code challenge the security on the rest web services have not been added.
- For brevity, have avoided the DTO layer. Have used DAO layer.
- For brevity, have avoided all the default enterprise design of timestamp tracking of the data models.
- JUnit test cases are available.
- For Brevity, avoided localization of data.















