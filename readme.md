# Spring Reactive Cassandra Kotlin Example

Spring Boot example with Spring Data Cassandra Reactive using Kotlin as programming language.

>Reactive programming is an asynchronous programming paradigm concerned with data streams and the propagation of change. This means that it becomes possible to express static (e.g. arrays) or dynamic (e.g. event emitters) data streams with ease via the employed programming language(s).
— https://en.wikipedia.org/wiki/Reactive_programming

## Setup

Make sure you have Cassandra running locally. You can download the distribution or use Docker: 

```bash
docker run --name cassandra-db -d -p 9042:9042 cassandra
```

You need to create a cassandra keyspace with cqslh.

```bash
# qlsh --cqlversion=3.4.4
cqlsh> create KEYSPACE avthart with replication={'class':'SimpleStrategy', 'replication_factor':1};
```

You can configure the keyspace name with `spring.data.cassandra.keyspace-name`

## Run

Start app using spring-boot maven plugin:

```bash
mvn spring-boot:run
```

Retrieve tasks using Server-Sent Events with httpie. The events are delayed with 500 ms because delayElements(...) is added to the Flux response, see code.

```bash
http -S :8080/tasks Accept:text/event-stream
```

Or retrieve as application/json:

```bash
http :8080/tasks
```

## References

* https://docs.spring.io/spring/docs/current/spring-framework-reference/web-reactive.html#spring-webflux
* https://docs.spring.io/spring-data/cassandra/docs/current/reference/html/#cassandra.reactive
* https://projectreactor.io/