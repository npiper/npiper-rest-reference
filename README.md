# Rest reference

## Test libraries

Karate

## Prometheus monitoring

https://g00glen00b.be/monitoring-spring-prometheus-grafana/


## Jolokia Monitoring

https://hub.docker.com/r/jolokia/java-jolokia/

## Testing from tools

```
POST http://{HOSTNAME:PORT}/depot/10001/inventory_summaries

Request Body:
{
	"inventoryLocation" : "BRISTOL"
}
```

Read the response Header 'location'
location →
http://{HOSTNAME:PORT}/depot/10001/inventory_summaries/1

```
GET http://{HOSTNAME:PORT}/depot/10001/inventory_summaries/1

Response Body:
{
    "id": 1,
    "inventoryLocation": "BRISTOL"
}
```

# Other endpoints

Uses the Spring Boot actuator out of the box endpoints

https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html

`GET http://{HOSTNAME:PORT}/beans`
`GET http://{HOSTNAME:PORT}/health`
`GET http://{HOSTNAME:PORT}/metrics`
`GET http://{HOSTNAME:PORT}/env`
`		


-----------------------------------------------------------

# REST API Common Microservice Module 
![SpringBoot](https://i0.wp.com/mydevgeek.com/wp-content/uploads/2017/02/spring-boot-project-logo.png?w=100&ssl=1 "Spring Boot Icon")

This project / POM is a framework POM for the project that provides

 * Spring Boot Framework Version
 * Binding Frameworks (XML/JSON)
 * Common libraries
 * Connectivity Libraries (JDBC, Messaging)
 * Test and Mock frameworks
 * Code quality / scanning plugins
 
 This avoids having divergence in libraries or having library drift between microservice modules.
 
 The release managed and versioned approach allows teams to migrate at their own speed.
 




# POM Project

## How to use it in a local project

If you are building a Spring Boot based microservice for the program - use this POM at a required version as your parent.

```
<parent>
    <groupId>neilpiper.me</groupId>
	<artifactId>rest.microservice.base</artifactId>
	<version>0.1.0_22.2013488</version>
</parent>
```

## Coding standards



# Properties

The following property files are supported and can be overwritten in your project:

# Dependencies


## Build time dependencies

### Spring Boot base & starters

 * spring-boot-starter-parent
 * [spring-boot-starter-actuator](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-actuator)
 * spring-boot-starter-aop
 * spring-boot-starter-cache
 * spring-boot-starter-web
 * spring-boot-starter-web-services
 * spring-boot-starter-data-jpa
 * spring-retry
 
### Other

 * guice-persist
 * guice
 * lombok
 * qpid-amqp-1-0-client
 * qpid-amqp-1-0-client-jms
 * qpid-amqp-1-0-common
 * org.apache.geronimo.specs
 * commons-io
 * jacoco-maven-plugin
 * net.sf.ehcache
 * xbean-spring
 * cdi-api
 * springfox-swagger2
 * springfox-swagger-ui
 * javax.jms-api
 * javax.servlet-api
 * json
 * json-lib
 * jackson-databind
 * jackson-mapper-asl
 * spring-oxm
 
 ## IBM
 * com.ibm.mq.allclient
 
 ## AZURE
 
 * azure-eventhubs
 * azure-eventhubs-eph
 * azure-servicebus
 

## Test Dependencies

 * spring-boot-starter-test
 * junit
 * hamcrest-library
 * mockito-all
 * org.jacoco.agent
 * mockrunner-jms
 * awaitility
 * hsqldb
 * karate-core


## Assumed Runtime Dependencies

 * hsqldb
 * mssql-jdb

# Quality Frameworks

## Unit Testing

## Code Quality & Style

# Packaging & Deployment

## Plugins

### Build

 * spring-boot-maven-plugin
 * maven-jaxb2-plugin
 * maven-install-plugin
 * jacoco-maven-plugin
 * fabric8-maven-plugin
 

### Test

### Packaging

### Reporting


# Overriding this on a local POM

## 1.  ASK & NOTIFY

## 2. How to do it (Use sparingly)

### Upgrading a minor dependency version (Properties)

# Modules and Reference set

 * This project - parent pom - reduced to REST-API only
 * Integration POM [Hexagonal architecture](https://dzone.com/articles/hexagonal-architecture-is-powerful) - Topic publisher
 * Integration POM (Camel + MQ)
 * Integration POM (Full featured - High volume)
 * Archetype project (Quick starter + Samples, walkthrough
 * Archetype project - RAML --> Hexagonal architecture
 * Reference Project JSON + XML inputs
 * Reference Project - RAML
 * Reference Project - Camel Integration, Testing, Stubbing
 * Reference Project - API Gateway (Kong) + API + Test
 * Reference Project - [Light4j](https://github.com/networknt/light-4j)
 * High volume Reference project - large data set, caching, REST search - scalable pods
 * Reference project - stubbing, wiremock, CircuitBreaker
 * Reference project - HATEOS example
 * Reference project - Multiple pods - dependent microservices + Testing
 * Reference project - Hypermedia Client
 * Reference project - Security
 * Reference project - REST + Doco ( asciidoc, slate)
 * Reference project - GraphQL
 * Reference Project - BPM + Services
 


# Appendix

## Enhancements

### Camel to remove Glue Code?

A good deal of the common code appears to be 'glue code' that deals with integration patterns and connectors.

Camel already provides a lot of this.

[Camel - Component connectors](http://camel.apache.org/components.html)

[Camel - Enterprise Integration Patterns](http://camel.apache.org/enterprise-integration-patterns.html)

Using a framework that supports it could improve reliability and reduce the overall code base.

[Camel - Asynchronous patterns](http://camel.apache.org/async.html)

[Camel - with Azure Service bus](https://www.kth.se/blogs/1337/2016/11/using-apache-camel-with-azure-service-bus/)

### Raml to SpringBoot 

https://github.com/phoenixnap/springmvc-raml-plugin

## Maintenance

### Version Control

### Release numbering

### Alignment to Spring Boot releases

We will typically make a migration to a [Spring Boot Major](https://projects.spring.io/spring-boot/) version i.e. (V2) a major change.

We will start at Version 1 to align to Spring Boot v1.

[Semantic Versioning](https://semver.org/)

## References

### Microservices

[Java schema.org parser](https://github.com/google/schemaorg-java)

### 12 Factor Apps & Containers


### Where to read about the technologies?

[Lombok - reducing boilerplate code](http://www.baeldung.com/intro-to-project-lombok)

[SWAGGER - filter](https://stackoverflow.com/questions/33673283/spring-boot-actuator-swagger)

[AsciiDoctor](https://asciidoctor.org/)
[RAML to AsciiDoc](https://github.com/isaaceindhoven/raml-docgen)
[AsciiDoctor maven plugin](https://github.com/asciidoctor/asciidoctor-maven-plugin)
