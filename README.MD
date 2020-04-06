# Sandbox App

## Technology Stack
* Spring
* Swagger
* Kafka
* Hibernate
* Security

## Prerequisites
* Java 11
* Maven 3.5.0+

# Development
## Building
* From IDE (Eclipse, Intellij) open as a Maven project and compile.
* From Command Line `mvn clean package`

## Running the Application
Run or debug the app with the `Starter` main class at the root of your Java package hierarchy.

You must add the following VM options in order for logging to work properly:
```
-Dapplication.home=. -Dspring.profiles.active=dev -Dapplication.environment=dev
```
Alternately, you may use the following Maven target to run the application from either the command line or your IDE:
```
mvn spring-boot:run
```
Open a browser and visit [http://localhost:8080](http://localhost:8080) for Swagger documentation.

To run on a different port, e.g. 8090, add:
```
-Dserver.port=8090
```

# Kafka
## Before startup the application

Download Kafka 4.2.1 or later: 
https://kafka.apache.org/downloads

#### Start zookeeper server
```
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
```

#### Start kafka server
```
.\bin\windows\kafka-server-start.bat .\config\server.properties
```

You must add the following VM options in order for logging to work properly:
```
-Dapplication.home=. -Dspring.profiles.active=kafka -Dapplication.environment=kafka
```