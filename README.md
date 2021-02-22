# springboot-event-validator

[Spring Boot](http://projects.spring.io/spring-boot/) app. it allow to filter overlapped events via REST API

### Example

```shell
curl --location --request POST 'http://localhost:8080/event/overlapped' \
--header 'Content-Type: application/json' \
--data-raw '{
    "eventList": [
        {
            "id": "1",
            "start": "2019-02-03 01:00:00",
            "end": "2019-02-03 03:00:00"
        },
        {
            "id": "2",
            "start": "2019-02-03 02:00:00",
            "end": "2019-02-03 03:00:00"
        },
        {
            "id": "3",
            "start": "2019-02-03 04:00:00",
            "end": "2019-02-03 05:00:00"
        }
    ]
}'
```
The events with ID 1 and 2 are overlapped, for that reason they will be returned 

### Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)(Included as wrapper)

### Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `de.codecentric.springbootsample.Application` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

### Copyright

Released under the GNU GENERAL PUBLIC LICENSE. See the [LICENSE](https://github.com/rosemberg-12/Event-Validator/blob/main/LICENSE) file.
