package com.tuk;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class Starter {

    @RequestMapping("/")
    String home() {
        return "Hello World - v4!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Starter.class, args);
    }

}