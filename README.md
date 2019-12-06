# spring-boot-cafe

## stage-00

### Requirements
- Java 11
- IDE with lombok support (https://projectlombok.org)
- Browser and Postman (https://www.getpostman.com) for accessing REST endpoints
- Maven [optional] (https://maven.apache.org)

### Setup
First we will setup a new Spring Boot project with the Spring Initialzr(https://start.spring.io/).  
Therefore select the following setting on the website:  

- Project: **Maven Project**
- Language: **Java**
- Spring Boot: **2.2.1**
- Project Metadata:  
  - Group: **de.cegeka**
  - Artifact: **springbootcafe**
  - Options:  
    - Packaging: **Jar**
    - Java: **11**
- Dependencies: **Lombok, Spring Web, Spring Boot Actuator**

Generate and download zip file to your local filesystem and unzip the project to a folder.

### Tasks
- Import project into IDE
- Delete *mvn*.** files, if you have maven already installed on your workstation
- Rename *SpringbootcafeApplication.java* to *RunApplication.java* and the appropriate test class
- Change version to **0.1.0-SNAPSHOT**
- Add build information for the Actuator endpoint */actuatior/info*
- ``mvn clean package`` ausführen
- Start the service and call the endpoints */actuator/info* and */actuator/health*

### Goals
- Import in IDE was successful
- Maven builds the project successfully
- Calling *localhost:8080/actuator/health* you should get the response code 200 and the message body

```
    status: "UP"
```

- Calling *localhost:8080/actuator/info* you should get the response code 200 and the message body

```
    build:
        artifact:   "springbootcafe"
        name:       "springbootcafe"
        time:       "..."
        version:    "0.1.0-SNAPSHOT"
        group:      "de.cegeka"
```

### Next Stage
[stage-01](https://github.com/ns-cegeka/spring-boot-cafe/tree/stage-01)

