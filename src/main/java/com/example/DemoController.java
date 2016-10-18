package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final DemoRepository repository;

    public DemoController(final DemoRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/")
    public Iterable<DemoEntity> someExamples() {
        return repository.findAll();
    }
}
