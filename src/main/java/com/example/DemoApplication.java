package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private DemoRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(final String... strings) throws Exception {
        Stream.of("first", "second")
                .map(name -> DemoEntity.builder().name(name).ignored("ignored").build())
                .forEach(repository::save);
    }
}
