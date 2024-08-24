# Spring Boot RabbitMQ Example

This repository contains a Spring Boot project with two modules: `rabbitmq_producer` and `rabbitmq_receiver`. The purpose of this project is to demonstrate and practice the use of RabbitMQ for messaging between two microservices.

## Overview

This project is an example of how to use RabbitMQ as a message broker in a Spring Boot application. It consists of two modules:
- **rabbitmq_producer**: Sends messages to a RabbitMQ queue, using multi-threading.
- **rabbitmq_receiver**: Listens for messages on a RabbitMQ queue and show messages received.

## Getting Started

### Prerequisites

- **Java 17** or higher
- **Maven 3.6+**
- **Docker** (for running RabbitMQ)
- **RabbitMQ** (can be run using Docker)

### Running RabbitMQ

You can run RabbitMQ using Docker with the following command:

```bash
docker run -d --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:management
```
## Building and Running the Modules
To build and run the modules, navigate to the project root directory and use Maven:

### Running the Receiver
```bash
cd rabbitmq_receiver
mvn spring-boot:run
```

### Running the Producer
```bash
cd rabbitmq_producer
mvn spring-boot:run
```

After running the producer, you should see messages like these in the **rabbitmq_receiver** log:

```bash
[Receiver] ha recibido el mensaje "Thread-5: Message 1"
[Receiver] ha recibido el mensaje "Thread-6: Message 1"
[Receiver] ha recibido el mensaje "Thread-5: Message 2"
[Receiver] ha recibido el mensaje "Thread-6: Message 2"
[Receiver] ha recibido el mensaje "Thread-5: Message 3"
[Receiver] ha recibido el mensaje "Thread-6: Message 3"
[Receiver] ha recibido el mensaje "Thread-6: Message 4"
[Receiver] ha recibido el mensaje "Thread-5: Message 4"
```

