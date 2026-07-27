# This file should contain URLs for start.spring.io with pre-made projects for ease of access.
### Keep in mind that, as Spring updates, this project may stay behind, so it's important to be aware of potential discrepancies and/or outdated ways of understanding how a microservices project works.

---

## Infrastructure

- ConfigServer: https://start.spring.io/#!type=maven-project&language=java&platformVersion=4.1.0&packaging=jar&configurationFileFormat=yaml&jvmVersion=25&groupId=com.example.infrastructure&artifactId=configserver&packageName=com.example.infrastructure.configserver&dependencies=cloud-config-server,actuator,lombok,validation
- Eureka: https://start.spring.io/#!type=maven-project&language=java&platformVersion=4.1.0&packaging=jar&configurationFileFormat=yaml&jvmVersion=25&groupId=com.example.infrastructure&artifactId=eurekaserver&packageName=com.example.infrastructure.eurekaserver&dependencies=cloud-eureka-server,cloud-config-client,actuator,lombok,validation
- Gateway: https://start.spring.io/#!type=maven-project&language=java&platformVersion=4.1.0&packaging=jar&configurationFileFormat=yaml&jvmVersion=25&groupId=com.example.infrastructure&artifactId=gatewayserver&packageName=com.example.infrastructure.gatewayserver&dependencies=cloud-gateway,cloud-eureka,cloud-config-client,oauth2-resource-server,actuator,lombok,validation

## Services

- Profile Service: https://start.spring.io/#!type=maven-project&language=java&platformVersion=4.1.0&packaging=jar&configurationFileFormat=yaml&jvmVersion=25&groupId=com.example.services&artifactId=profileservice&packageName=com.example.services.profileservice&dependencies=web,data-jpa,postgresql,cloud-eureka,cloud-config-client,oauth2-resource-server,actuator,lombok,validation

- Post Service: https://start.spring.io/#!type=maven-project&language=java&platformVersion=4.1.0&packaging=jar&configurationFileFormat=yaml&jvmVersion=25&groupId=com.example.services&artifactId=postservice&packageName=com.example.services.postservice&dependencies=web,data-jpa,postgresql,cloud-eureka,cloud-config-client,oauth2-resource-server,actuator,lombok,validation
