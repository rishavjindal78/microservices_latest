# Distributed Tracing in Micoservices using Zipkin, Sleuth and ELK Stack

Integration of Spring Sleuth and Zipkin, Using ELK as backend for Zipkin
Trace calls from a service to messaging queue and then to a service	

## Enabling Zipkin and Sleuth

 <!-- Dependencies for Zipkin and Sleuth -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-zipkin</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-sleuth</artifactId>
    </dependency>
	
<!-- Dependencies for LogStash -->
   <dependency>
        <groupId>net.logstash.logback</groupId>
        <artifactId>logstash-logback-encoder</artifactId>
        <version>5.3</version>
    </dependency>
    <dependency>
        <groupId>ch.qos.logback</groupId>
        <artifactId>logback-core</artifactId>
        <version>1.2.3</version>
    </dependency>

## Installation of the needed tools

Running Zipkin from Source:
git clone https://github.com/openzipkin/zipkin
cd zipkin
mvnw -DskipTests --also-make -pl zipkin-server clean install
java -jar ./zipkin-server/target/zipkin-server-2.21.4-SNAPSHOT-exec.jar

## Installing the ELK Stack on Windows
https://logz.io/blog/installing-the-elk-stack-on-windows/

To check the elasticssearch indexes
http://localhost:9200/_cat/indices?v&pretty

## Here is the URL to setup the logback.xml file and logstash.config
https://medium.com/swlh/distributed-tracing-in-micoservices-using-spring-zipkin-sleuth-and-elk-stack-5665c5fbecf

## Install the Zookeeper and Kafka to handle the message events

kafka-server-start.bat ..\kafka_2.12-2.5.0\config\server.properties

## Running the application

Below are the URLs to run the application
http://localhost:8081/trades/aggregate/{tradeid}

http://localhost:8083/refdata/refdata/location




