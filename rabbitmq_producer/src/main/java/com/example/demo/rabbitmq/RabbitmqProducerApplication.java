package com.example.demo.rabbitmq;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqProducerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProducerApplication.class, args);
    }

    @Override
    public void run(String... args) throws InterruptedException {
        Producer producer = new Producer();
        Thread thread1 = new Thread(
                () -> producer.execute(Thread.currentThread().getName())
        );
        Thread thread2 = new Thread(
                () -> producer.execute(Thread.currentThread().getName())
        );
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

}
