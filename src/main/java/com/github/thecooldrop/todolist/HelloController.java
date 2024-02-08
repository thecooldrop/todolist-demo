package com.github.thecooldrop.todolist;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(path = "/hello")
    ResponseEntity<String> getHello() {
        return ResponseEntity.ok("Hello World!");
    }
}
